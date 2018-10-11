package com.sinosoft.agriclaim.core.downloadtemplate.service.impl;

import com.sinosoft.agriclaim.core.downloadtemplate.constant.FileType;
import com.sinosoft.agriclaim.core.downloadtemplate.service.TemplateFileService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * 模板文件操作ServiceImpl
 *
 * @author: 何伟东
 * @date: 2018/1/10 14:52
 */
@Service
public class TemplateFileServiceImpl extends BaseServiceImpl implements TemplateFileService {
    /**
     * 存放模板文件的文件夹
     */
    private final String FOLDER = "filetemplate" + File.separator;

    /**
     * 下载模板文件
     *
     * @param request fileType-文件类型
     * @author: 何伟东
     * @date: 2018/1/10 14:15
     */
    @Override
    public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String fileType = request.getParameter("fileType");
        String fileName;
        if (StringUtils.isNotEmpty(fileType)) {
            // 特殊赔案清单模板文件
            if (FileType.SPECCASE_LIST.equals(fileType)) {
                fileName = "3107_SPECCASE_LIST.xls";
            }else if(FileType.CLAIMPAY_LIST.equals(fileType)){
                fileName="3107_CLAIMPAY_LIST.xls";
            }
            //种植险理赔清单空模板文件
            else if(FileType.NYXPLANTINGCLAIM_LIST.equals(fileType)){
                fileName="3107_NYXPLANTINGCLAIM_LIST.xls";
            }
            //养殖险理赔清单空模板文件
            else if(FileType.NYXBREEDCLAIM_LIST.equals(fileType)){
                fileName="3220_NYXBREEDCLAIM_LIST.xls";
            }
            else if(FileType.DINGSUN_LIST.equals(fileType)){
                fileName="3220_DINGSUN.xls";
            }
            else if(FileType.PLANTINGDINGSUN_LIST.equals(fileType)){
                fileName="3107_DINGSUN.xls";
            }
            // 文件类型不正确
            else {
                throw new DataVerifyException("模板文件类型不正确！");
            }
        } else {
            throw new DataVerifyException("下载文件类型不能为空！");
        }
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream fileInputStream = classLoader.getResourceAsStream(FOLDER + fileName);
        write(response, fileInputStream, fileName);
    }

    /**
     * 向前端回写文件流
     *
     * @param response        HttpServletResponse
     * @param fileInputStream 文件输入流
     * @param fileName        文件名
     * @author: 何伟东
     * @date: 2018/1/10 15:11
     */
    private void write(HttpServletResponse response, InputStream fileInputStream, String fileName) throws IOException {
        try {
            response.setHeader("content-disposition", "attachment;filename=" + fileName);
            ServletOutputStream out = response.getOutputStream();
            int len;
            byte[] buffer = new byte[1024];
            while ((len = fileInputStream.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } finally {
            fileInputStream.close();
        }
    }
}
