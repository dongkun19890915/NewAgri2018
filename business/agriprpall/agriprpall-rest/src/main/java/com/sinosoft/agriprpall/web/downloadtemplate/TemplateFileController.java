package com.sinosoft.agriprpall.web.downloadtemplate;

import com.sinosoft.agriprpall.api.downloadtemplate.TemplateFileApi;
import com.sinosoft.agriprpall.api.printPdf.PrintApi;
import com.sinosoft.agriprpall.core.downloadtemplate.service.TemplateFileService;
import com.sinosoft.framework.core.context.SinoRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 模板文件操作Controller
 *
 * @author: 何伟东
 * @date: 2018/1/10 14:52
 */
@RestController
@RequestMapping(value = TemplateFileApi.PATH)
public class TemplateFileController implements TemplateFileApi {
    @Autowired
    private TemplateFileService templateFileService;

    /**
     * 下载模板文件
     *
     * @param request fileType-文件类型
     * @author: 何伟东
     * @date: 2018/1/10 14:15
     */
    @Override
    public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
        templateFileService.download(request, response);
    }
}
