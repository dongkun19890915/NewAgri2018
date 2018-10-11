package com.sinosoft.agriclaim.api.downloadtemplate;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 模板文件操作Api
 *
 * @author: 何伟东
 * @date: 2018/1/10 14:52
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = TemplateFileApi.PATH)
public interface TemplateFileApi {
    String PATH = "templateFile";

    /**
     * 下载模板文件
     *
     * @param request fileType-文件类型
     * @author: 何伟东
     * @date: 2018/1/10 14:15
     */
    @RequestMapping(value = "download", method = RequestMethod.GET)
    void download(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
