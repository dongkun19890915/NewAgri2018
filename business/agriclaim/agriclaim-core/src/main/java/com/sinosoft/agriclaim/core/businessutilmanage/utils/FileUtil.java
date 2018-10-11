package com.sinosoft.agriclaim.core.businessutilmanage.utils;

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
     * 上传文件到fileServer并返回文件下载短链接，短链接默认有效时间为一小时
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
        String fileId = null;
        String shortLinkId = null;
        // 上传文件到fileServer
        Map<String, String> uploadFileMap = new HashMap<>(3);
        uploadFileMap.put("userCode", userCode);
        uploadFileMap.put("systemId", systemId);
        uploadFileMap.put("bussType", bussType);
        Map<String, String> uploadFileResult = FileServerHelper.uploadFile(fileServiceUrl + "/uploadFile", file, uploadFileMap);
        if (uploadFileResult != null && StringUtils.isNotEmpty(uploadFileResult.get("fileId"))) {
            fileId = uploadFileResult.get("fileId");
        }
        // 生成短链接服务调用
        if (StringUtils.isNotEmpty(fileId)) {
            Map<String, String> shortLinkMap = new HashMap<>(3);
            shortLinkMap.put("userCode", userCode);
            shortLinkMap.put("fileId", fileId);
            shortLinkMap.put("validWhenLong", "3600000");
            Map<String, String> shortLinkResult = FileServerHelper.sendPost(fileServiceUrl + "/generateFileShortLink", shortLinkMap);
            shortLinkId = fileServiceUrl + "/downloadFileByShortLinkId?shortLinkId=" + shortLinkResult.get("shortLinkId");
        }
        if (StringUtils.isEmpty(shortLinkId)) {
            throw new BusinessException("生成文件下载短链接失败！");
        }
        return shortLinkId;
    }
}
