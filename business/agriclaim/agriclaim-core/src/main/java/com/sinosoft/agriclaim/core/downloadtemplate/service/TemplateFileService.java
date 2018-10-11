package com.sinosoft.agriclaim.core.downloadtemplate.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 模板文件操作Service
 *
 * @author: 何伟东
 * @date: 2018/1/10 14:52
 */
public interface TemplateFileService {

    /**
     * 下载模板文件
     *
     * @param request fileType-文件类型
     * @author: 何伟东
     * @date: 2018/1/10 14:15
     */
    void download(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
