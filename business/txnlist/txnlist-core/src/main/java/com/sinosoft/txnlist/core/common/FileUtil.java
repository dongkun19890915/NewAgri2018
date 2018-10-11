package com.sinosoft.txnlist.core.common;

import com.sinosoft.fileserver.client.FileServerHelper;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.BusinessException;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 快速上传下载文件工具类
 *
 * @author: 何伟东
 * @date: 2017/12/27 14:57
 */
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

}
