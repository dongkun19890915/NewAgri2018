package com.sinosoft.notice.core.common.utils;

import com.sinosoft.fileserver.client.FileServerHelper;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.BusinessException;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileUtil {
    /**
     * 短链接有效时长,默认一小时
     */
    private String validWhenLong = "3600000";

    /**
     * 上传文件到fileServer并返回文件下载短链接
     *
     * @param fileServiceUrl 文件服务器地址
     * @param file           excel文件的file对象
     * @param userCode       用户代码
     * @param systemId       调用系统id
     * @param bussType       业务类型
     * @return shortLinkId 文件下载短链接
     * @author: 何伟东
     * @date: 2017/12/27 15:22
     */
    public String uploadFile(String fileServiceUrl, File file, String userCode, String systemId, String bussType) throws Exception {
        String fileId = uploadFileServer(fileServiceUrl, file, userCode, systemId, bussType);
        String shortLinkId = createShortId(fileId, userCode, fileServiceUrl);
        return shortLinkId;
    }

    public String uploadFileServer(String fileServiceUrl, File file, String userCode, String systemId, String bussType) throws Exception {
        String fileId = null;
        // 上传文件到fileServer
        Map<String, String> uploadFileMap = new HashMap<>(3);
        uploadFileMap.put("userCode", userCode);
        uploadFileMap.put("systemId", systemId);
        uploadFileMap.put("bussType", bussType);
        Map<String, String> uploadFileResult = FileServerHelper.uploadFile(fileServiceUrl + "/uploadFile", file, uploadFileMap);
        if (uploadFileResult != null && StringUtils.isNotEmpty(uploadFileResult.get("fileId"))) {
            fileId = uploadFileResult.get("fileId");
        }
        return fileId;
    }

    /**
     * 生成短链接
     *
     * @return
     */
    public String createShortId(String fileId, String userCode, String fileServiceUrl) throws Exception {
        String shortLinkId = null;
        // 生成短链接服务调用
        if (StringUtils.isNotEmpty(fileId)) {
            Map<String, String> shortLinkMap = new HashMap<>(3);
            shortLinkMap.put("userCode", userCode);
            shortLinkMap.put("fileId", fileId);
            shortLinkMap.put("validWhenLong", validWhenLong);
            Map<String, String> shortLinkResult = FileServerHelper.sendPost(fileServiceUrl + "/generateFileShortLink", shortLinkMap);
            shortLinkId = fileServiceUrl + "/downloadFileByShortLinkId?shortLinkId=" + shortLinkResult.get("shortLinkId");
        }
        if (StringUtils.isEmpty(shortLinkId)) {
            throw new BusinessException("生成文件下载短链接失败！");
        }
        return shortLinkId;
    }

    /**
     * 使用fileId下载excel文件
     *
     * @param fileServiceUrl  文件服务器地址
     * @param exportExcelType excel文件扩展名，需要从配置文件中获取
     * @param fileId          文件id
     * @return 下载的文件file对象
     * @author: 何伟东
     * @date: 2017/12/29 9:08
     */
    public File downloadExcel(String fileServiceUrl, String exportExcelType, String fileId) throws Exception {
        File file = File.createTempFile(fileId + "_", exportExcelType);
        downloadFile(fileServiceUrl, fileId, file);
        return file;
    }


    /**
     * 按文件id下载文件
     * @param fileServiceUrl
     * @param exportExcelType
     * @param fileId
     * @return
     * @throws Exception
     */
    public InputStream downFile(String fileServiceUrl, String exportExcelType, String fileId) throws Exception {
        File file = File.createTempFile(fileId + "_", exportExcelType);
        downloadFile(fileServiceUrl, fileId, file);
        InputStream inputStream=new FileInputStream(file);
        return inputStream;
    }

    /**
     * 使用fileId从fileService下载文件到指定路径
     *
     * @param fileServiceUrl 文件服务器地址
     * @param fileId         文件id
     * @param file           下载后的file文件对象
     * @author: 何伟东
     * @date: 2017/12/29 9:24
     */
    private void downloadFile(String fileServiceUrl, String fileId, File file) throws Exception {
        Map<String, String> params = new HashMap<>(1);
        params.put("fileId", fileId);
        FileServerHelper.dowloadFileByFileId(fileServiceUrl + "/downloadFile", file, params);
    }

    /**
     * 设置短链接的有效时长
     *
     * @param validWhenLong 有效时长，精确到毫秒数
     * @return 本类实例
     * @author: 何伟东
     * @date: 2017/12/28 13:17
     */
    public FileUtil setValidWhenLong(long validWhenLong) {
        if (validWhenLong > 0) {
            this.validWhenLong = Long.toString(validWhenLong);
        }
        return this;
    }

    public File zipCompire(List<InputStream> inputStreamList, String[] filenames, String fileExend) {
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
        String date = sim.format(new Date());
        byte[] buffer = new byte[1024];
        File tempFile = null;
        try {
            tempFile = File.createTempFile("print", ".zip");
            //ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipPath));
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(tempFile));
            String filename = "";
            for (int i = 0; i < inputStreamList.size(); i++) {
                filename = filenames[i] + "-" + date + "." + fileExend;
                InputStream fis = inputStreamList.get(i);
                out.putNextEntry(new ZipEntry(filename));
                int len;
                // 读入需要下载的文件的内容，打包到zip文件
                while ((len = fis.read(buffer)) > 0) {
                    out.write(buffer, 0, len);
                }
                out.closeEntry();
                fis.close();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tempFile;
    }


    /**
     * inputStream转file
     * @param ins
     * @param file
     */
    public void inputstreamtofile(InputStream ins,File file){
        OutputStream os=null;
        try {
            os= new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ins != null) {
                try {
                    ins.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public ByteArrayOutputStream cloneInputStream(InputStream input) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = input.read(buffer)) > -1) {
                baos.write(buffer, 0, len);
            }
            baos.flush();
            return baos;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
