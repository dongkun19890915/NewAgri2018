package com.sinosoft.fileserver.controller;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSON;
import com.sinosoft.fileserver.controller.config.ShortLinkConfig;
import com.sinosoft.fileserver.controller.config.UploadConfig;
import com.sinosoft.fileserver.controller.util.FileInfoUtils;
import com.sinosoft.fileserver.entity.TFileInfo;
import com.sinosoft.fileserver.entity.TFileShortLink;
import com.sinosoft.fileserver.service.TFileInfoService;
import com.sinosoft.fileserver.service.TFileShortLinkService;
import com.sinosoft.fileserver.storage.FileOptFactory;
import com.sinosoft.fileserver.storage.FileOptInter;
import com.sinosoft.fileserver.utils.FileContentType;
import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.framework.exception.BusinessException;

/**
 * @author 周建龙
 * @author yangqunwei@sinosoft.com.cn
 * @description 文件服务Controller
 * @date 2016年10月5日下午5:11:51
 */
@Controller
public class FileController {

    @Autowired
    private TFileInfoService tfileInfoService;
    private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);
    @Autowired
    private TFileShortLinkService tFileShortLinkService;

    @Value("${sftp.ftpPassword}")
    private String ftpPassword;
    @Value("${db.fileserver.password}")
    private String password1;
//	@Value("${db.fileserver.password}")
//	private String password;

    @RequestMapping(value = "/test")
    @ResponseBody
    public String test() {

//        String key = "9lWaL475Hqwg";
//        String pwd = "1lE1D+OiOop/TCZsQsnE7kNBJMAGge7U";
//
//        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
//        encryptor.setPassword(key);
//        System.out.println(encryptor.decrypt(pwd));

//        System.out.println("password-----" + password1);
//        System.out.println("ftpPassword-----"+ftpPassword);
//        TFileShortLink tFileShortLink = tFileShortLinkService.queryTFileShortLinkByPk("8fdc864d535f4f5285221f234c5444ee");
//        System.out.println(tFileShortLink.getFileId() + tFileShortLink.getShortLinkId());
//        return password1 + tFileShortLink.getFileId() + tFileShortLink.getShortLinkId();
        return null;
    }

    /**
     * @param request
     * @return json结果的对象
     * @throws Exception
     * @description 文件上传服务
     * @author 周建龙
     * @author yangqunwei
     * @date 2016年10月5日上午11:16:03
     */

    @RequestMapping(value = "/uploadFile")
    public void uploadFile(HttpServletRequest request, HttpServletResponse response) {
        //tfileInfoService.synFile();
        UploadConfig upconfig = new UploadConfig();
        String agent = request.getHeader("user-agent").toLowerCase();
        LOGGER.error("客户端Agent" + agent);
        String contentType = "text/plain;";
        LOGGER.error("响应Content-Type:" + contentType);
        response.setHeader("Content-Type", contentType);
        Map<String, String> resultMap = new HashMap<String, String>();
        String jsonstr = "";
        try {
            LOGGER.error("收到上传请求");
            // 解析request到更新配制
            upconfig.parseUploadConfig(request);
//			LOGGER.error("解析request:{}", upconfig);
            if (upconfig.getParseStatus() != 1) {
                LOGGER.error("上传失败${}", upconfig.getParseMsg());
                throw new BusinessException("9999", upconfig.getParseMsg());
            }
            // 根据参数配置获得文件信息
            TFileInfo fileinfo = FileInfoUtils.getFileInfoByUploadConfig(upconfig);
            FileOptInter fileOptInter = FileOptFactory.getFileInstance(fileinfo.getBussType(), FileOptFactory.BUSSTYPE);
            fileinfo.setStorageMedium(fileOptInter.getStorageMedium());
            fileinfo.setStorageConfig(fileOptInter.getStoreConfig());
            fileOptInter.uploadFile(fileinfo.getFilePath(), upconfig.getFile().getInputStream());
            //文件MD5值
            try {

                fileinfo.setFileMD5(DigestUtils.md5Hex(upconfig.getFile().getInputStream()));
            } catch (Exception e) {
                LOGGER.error("文件MD5取值失败,异常{}", e);
            }
//			LOGGER.error("开始上传到{}",storageService.getStorageMedium());
            // 把文件存放到相应介质
            //删除临时文件
            deleteTempFile(upconfig);
            LOGGER.error("结束上传");
            // 保存文件信息到数据库
            tfileInfoService.save(fileinfo);
            resultMap.put("resultCode", "0000");
            resultMap.put("fileId", fileinfo.getFileId());
            resultMap.put("fileMD5", fileinfo.getFileMD5());
            writeResponse(resultMap, response);
        } catch (Exception e) {
            LOGGER.error("上传出错,异常{}", e);
            throw new BusinessException("9999", "上传出错,请联系管理员");
        }
        LOGGER.error("上传返回", jsonstr);
    }

    private void deleteTempFile(UploadConfig upconfig) {
        String realPath = null;
        try {
            if (upconfig.getFile().getClass().equals(CommonsMultipartFile.class)) {
                CommonsMultipartFile commonsMultipartFile = (CommonsMultipartFile) upconfig.getFile();
                //参考相关源码192行不保证版本兼容性...
                if (commonsMultipartFile.getStorageDescription().startsWith("at")) {
                    realPath = commonsMultipartFile.getStorageDescription().substring(4, commonsMultipartFile.getStorageDescription().length() - 1);
                    if (new File(realPath).exists()) {
                        new File(realPath).delete();
                        LOGGER.error("删除临时文件:{},成功.", realPath);
                    }

                }
                commonsMultipartFile.getStorageDescription();
            }
        } catch (Exception e) {
            if (null != realPath) {
                LOGGER.warn("删除临时文件:{}失败.异常:", realPath, e);
            }
            e.printStackTrace();
        }
    }

    //针对IE做特殊处理,不支持application/json的响应!!!!!
    private void writeResponse(Map<String, String> result, HttpServletResponse response) {
        try {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html");
            response.getWriter().write(JSON.toJSONString(ResponseDto.instance(result)));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.getWriter().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //测试用
    @RequestMapping(value = {"/downloadFileTest.pdf", "/downloadFileTest"})
    public void downloadFileTest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.reset();// 清空输出流
        response.setContentType(FileContentType.getContentType("pdf"));

        String filepath = request.getSession().getServletContext().getRealPath("/");
        filepath += "aaa.pdf";

        File filename = new File(filepath);
        InputStream inputStream = new FileInputStream(filename);
        OutputStream os = response.getOutputStream();
        byte[] b = new byte[2048];
        int length;
        while ((length = inputStream.read(b)) > 0) {
            os.write(b, 0, length);
        }
        os.close();
        inputStream.close();
    }

    /**
     * @return
     * @throws Exception
     * @description 把文件下载到本地
     * @author 周建龙
     * @author yangqunwei@sinosoft.com.cn
     * @date 2016年10月5日下午6:21:40
     */
    @RequestMapping("/downloadFile")
    public void downloadFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String fileId = request.getParameter("fileId");
        if (fileId == null) {
            throw new RuntimeException("fileId不能为空！");
        }
        downLoadFileById(request, response, fileId);
    }

    /**
     * @param request
     * @param response
     * @param fileId   文件ID
     * @throws Exception
     * @throws UnsupportedEncodingException
     * @throws IOException
     * @description 根据文件ID下载文件
     * @author yangqunwei@sinosoft.com.cn
     * @date 2016年11月1日下午6:34:28
     */
    private void downLoadFileById(HttpServletRequest request, HttpServletResponse response, String fileId)
            throws Exception, UnsupportedEncodingException, IOException {
        response.setCharacterEncoding("utf-8");
        TFileInfo fileInfo = tfileInfoService.queryTFileInfoByFileId(fileId);
        if (fileInfo == null) {
            LOGGER.error("文件{}信息不存在,无法下载", fileId);
            throw new BusinessException("文件信息不存在,无法下载");
        }
        if ("1".equals(fileInfo.getIsDeleted())) {
            LOGGER.error("文件{}已删除无法下载", fileId);
            throw new BusinessException("文件已删除无法下载");
        }
        FileOptInter fileOptInter = FileOptFactory.getFileInstance(fileInfo.getStorageConfig(), FileOptFactory.CONFIGCODE);
        InputStream inputStream = fileOptInter.getInputStreamByPath(fileInfo.getFilePath());
        if ("view".equals(request.getParameter("type"))) {
            response.setContentType(FileContentType.getContentType(fileInfo.getFileExt()));
        } else {
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + new String(fileInfo.getFileName().getBytes("gbk"), "iso-8859-1"));
        }
        OutputStream os = response.getOutputStream();
        byte[] b = new byte[2048];
        int length;
        while ((length = inputStream.read(b)) > 0) {
            os.write(b, 0, length);
        }
        os.close();
        inputStream.close();
    }


    /**
     * @return
     * @throws Exception
     * @description 把文件下载到本地
     * @author 周建龙
     * @author yangqunwei
     * @date 2016年10月5日下午6:21:40
     */
    @RequestMapping("/downloadFileByShortLinkId")
    public void downloadFileByShortLinkId(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String shortLinkId = request.getParameter("shortLinkId");
        if (shortLinkId == null) {
            throw new BusinessException("shortLinkId不能为空！");
        }
        TFileShortLink tFileShortLink = tFileShortLinkService.queryTFileShortLinkByPk(shortLinkId);
        if (tFileShortLink == null) {
            LOGGER.error("短链接{}信息不存在,无法下载", shortLinkId);
            throw new BusinessException("短链接信息不存在,无法下载");
        }
        if ("1".equals(tFileShortLink.getIsDeleted())) {
            LOGGER.error("短链接{}已删除无法下载", shortLinkId);
            throw new BusinessException("文件已删除无法下载");
        }
        if (tFileShortLink.getInvalidTime().getTime() < new Date().getTime()) {
            LOGGER.error("短链接{}已失效无法下载", shortLinkId);
            throw new BusinessException("文件已失效无法下载");
        }
        String fileId = tFileShortLink.getFileId();
        this.downLoadFileById(request, response, fileId);
    }

    /**
     * 查询文件状态-暂废弃
     *
     * @param request
     * @param response
     * @return
     * @description （用一句话描述这个方法是做什么的）
     * @author yangqunwei@sinosoft.com.cn
     * @date 2016年11月1日下午6:02:07
     */
    @ResponseBody
    //@RequestMapping(value = "/queryFileStatus", produces = "application/json;charset=UTF-8")
    public String queryFileStatus(HttpServletRequest request, HttpServletResponse response) {
        String fileId = request.getParameter("fileId");
        if (fileId == null) {
            throw new BusinessException("文件id不能为空!");

        }
        TFileInfo fileInfo = tfileInfoService.queryTFileInfoByFileId(fileId);
        if (fileInfo == null) {
            throw new BusinessException("查不到该文件信息！");
        }

        if ("1".equals(fileInfo.getIsDeleted())) {
            throw new BusinessException("该文件被已删除，无法下载！");
        }


        return JSON.toJSONString(ResponseDto.instance(null));
    }

    /**
     * @param request
     * @param response
     * @return
     * @description （用一句话描述这个方法是做什么的）
     * @author yangqunwei@sinosoft.com.cn
     * @date 2016年11月1日下午6:02:07
     */
    @ResponseBody
    @RequestMapping(value = "/moveFile", produces = "application/json;charset=UTF-8")
    public ResponseDto moveFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String fileId = request.getParameter("fileId");
        String targetPath = request.getParameter("targetPath");
        String userCode = request.getParameter("userCode");
        if (fileId == null || "".equals(fileId)) {
            throw new BusinessException("文件id不能为空!");
        }
        if (targetPath == null || "".equals(targetPath)) {
            throw new BusinessException("目标路径不能为空!");
        }
        if (userCode == null || "".equals(userCode)) {
            throw new BusinessException("用户代码不能为空!");
        }
        TFileInfo fileInfo = tfileInfoService.queryTFileInfoByFileId(fileId);
        if (fileInfo == null) {
            throw new BusinessException("查不到该文件信息！");
        }
        if ("1".equals(fileInfo.getIsDeleted())) {
            throw new BusinessException("该文件被已删除，无法操作！");
        }
        String busType = fileInfo.getBussType();
        FileOptInter fileOptInter = FileOptFactory.getFileInstance(fileInfo.getStorageConfig(), FileOptFactory.CONFIGCODE);
        String distPath = fileInfo.getBussType() + "/" + targetPath;
        fileOptInter.moveFile(fileInfo.getFilePath(), distPath);
        fileInfo.setFilePath(distPath);
        fileInfo.setUpdateBy(userCode);
        fileInfo.setUpdateTime(new Date());
        tfileInfoService.updateByPrimaryKey(fileInfo);
        Map<String, String> resultMap = new HashMap<String, String>();
        resultMap.put("fileId", fileInfo.getFileId());
        return ResponseDto.instance(resultMap);
    }

    /**
     * 文件删除
     *
     * @param request
     * @return
     * @description （用一句话描述这个方法是做什么的）
     * @author yangqunwei@sinosoft.com.cn
     * @date 2016年11月1日下午6:08:35
     */
    @ResponseBody
    // @RequestMapping(value = "/deleteFile", produces ="application/json;charset=UTF-8")
    public String deleteFile(HttpServletRequest request) {
        String fileId = request.getParameter("fileId");
        String userCode = request.getParameter("userCode");
        if (fileId == null) {
            throw new BusinessException("文件id不能为空!");
        }
        if (userCode == null) {
            throw new BusinessException("userCode不能为空!");
        }
        TFileInfo fileInfo = tfileInfoService.queryTFileInfoByFileId(fileId);
        if (fileInfo == null) {
            throw new BusinessException("查不到该文件信息！");
        }
        TFileInfo updateFileInfo = tfileInfoService.queryTFileInfoByFileId(fileId);
        updateFileInfo.setFileId(updateFileInfo.getFileId());
        updateFileInfo.setUpdateBy(userCode);
        updateFileInfo.setUpdateTime(new Date());
        tfileInfoService.updateByPrimaryKey(updateFileInfo);
        return JSON.toJSONString(ResponseDto.instance(null));
    }

    /**
     * @return
     * @throws Exception
     * @description 把文件下载到本地
     * @author 周建龙
     * @author yangqunwei@sinosoft.com.cn
     * @date 2016年10月5日下午6:21:40
     */
    @ResponseBody
    @RequestMapping(value = "/generateFileShortLink", produces = "application/json;charset=UTF-8")
    public ResponseDto generateFileShortLink(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HashMap<String, String> result = new HashMap<String, String>();
        ShortLinkConfig slc = new ShortLinkConfig();
        slc.parseShortLinkConfig(request);
        LOGGER.error("解析request:{}", slc);
        if (slc.getParseStatus() != 1) {
            throw new BusinessException(slc.getParseMsg());
        }
        TFileInfo fileInfo = tfileInfoService.queryTFileInfoByFileId(slc.getFileId());
        if (fileInfo == null) {
            throw new BusinessException("查不到该文件信息！");
        }
        TFileShortLink tsl = new TFileShortLink();
        tsl.setCreateBy(slc.getUserCode());
        tsl.setUpdateBy(slc.getUserCode());
        tsl.setCreateTime(new Date());
        tsl.setUpdateTime(new Date());
        tsl.setInvalidTime(slc.getInvalidTime());
        tsl.setIsDeleted("2");
        tsl.setShortLinkId(FileInfoUtils.createNewFileId());
        tsl.setFileId(slc.getFileId());
        tFileShortLinkService.save(tsl);
        result.put("resultCode", "0000");
        result.put("shortLinkId", tsl.getShortLinkId());
        result.put("fileExt", fileInfo.getFileExt());
        LOGGER.error("返回短链接:" + JSON.toJSONString(result));
        return ResponseDto.instance(result);
    }
}