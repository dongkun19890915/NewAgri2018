package com.sinosoft.agriprpall.core.downloadtemplate.service.impl;

import com.sinosoft.agriprpall.core.downloadtemplate.constant.FileType;
import com.sinosoft.agriprpall.core.downloadtemplate.service.TemplateFileService;
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
        String fileName="";
        if (StringUtils.isNotEmpty(fileType)) {
            // 批改支付清单模板文件
            if (FileType.INSURE_LIST.equals(fileType)) {
                fileName = "3107_INSURE_LIST.xls";
            }
            //耳标号清单
            else if (FileType.EAR_LABEL_LISTING.equals(fileType)) {
                fileName = "3107_EAR_LABEL_LISTING.xls";
            }
            //连带被保险人清单
            else if (FileType.JOINT_INSURED.equals(fileType)) {
                fileName = "3107_JOINT_INSURED.xls";
            }
            // B5条款文件
            String riskCode=fileType.substring(0,4);
            String com=fileType.substring(4,6);
            if ("3107".equals(riskCode)) {
                if ("34".equals(com)) {//安徽
                    fileName = "3107_MAIN_B5.doc";
                } else if ("41".equals(com)) {//河南
                    fileName = "3107_MAIN_B5_B_B01.doc";
                } else if ("52".equals(com)) {//贵州
                    fileName = "3107_MAIN_B5_D_D01.doc";
                }
            }else if("3101".equals(riskCode)){
                if("34".equals(com)){//安徽
                    fileName = "3101_MAIN_B5.doc";
                }else if("41".equals(com)){//河南
                    fileName = "3101_MAIN_B5_B_B01.doc";
                }else if("52".equals(com)){//贵州
                    fileName = "3101_MAIN_B5_D_D01.doc";
                }
            }else if("3102".equals(riskCode)){
                fileName = "3102_MAIN_B5.doc";
            }else if("3114".equals(riskCode)){
                fileName = "3114_MAIN_B5.doc";
            }else if("3122".equals(riskCode)){
                fileName = "3122_MAIN_B5.doc";
            }else if("3126".equals(riskCode)){
                fileName = "3126_MAIN_B5.doc";
            }else if("3161".equals(riskCode)){
                fileName = "3161_MAIN_B5.doc";
            }else if("3108".equals(riskCode)){
                if("34".equals(com)){//安徽
                    fileName = "3108_MAIN_B5.doc";
                }else if("41".equals(com)){//河南
                    fileName = "3108_MAIN_B5_B_B01.doc";
                }else if("52".equals(com)){//贵州
                    fileName = "3108_MAIN_B5_D_D01.doc";
                }
            }else if("3129".equals(riskCode)){
                fileName = "3129_MAIN_B5.doc";
            }else if("3130".equals(riskCode)){
                fileName = "3130_MAIN_B5.doc";
            }else if("3134".equals(riskCode)){
                if("34".equals(com)) {//安徽
                    fileName = "3134_MAIN_B5.doc";
                }else if("42".equals(com)){//湖北
                    fileName = "3134_MAIN_B5_C_C01.doc";
                }
            }else if("3141".equals(riskCode)){
                if("34".equals(com)){//安徽
                    fileName = "3141_MAIN_B5.doc";
                }else if("41".equals(com)){//河南
                    fileName = "3141_MAIN_B5_B_B01.doc";
                }else if("42".equals(com)){//湖北
                    fileName = "3141_MAIN_B5_C_C01.doc";
                }
            }else if("3147".equals(riskCode)){
                fileName = "3147_MAIN_B5.doc";
            }else if("3155".equals(riskCode)){
                fileName = "3155_MAIN_B5.doc";
            }else if("3220".equals(riskCode)){
                if("34".equals(com)){//安徽
                    fileName = "3220_MAIN_B5.doc";
                }else if("41".equals(com)){//河南
                    fileName = "3220_MAIN_B5_B_B01.doc";
                }else if("42".equals(com)){//湖北
                    fileName = "3220_MAIN_B5_C_C01.doc";
                }
            }else if("3224".equals(riskCode)){
                fileName = "3224_MIAN_B5.doc";
            }else if("3233".equals(riskCode)){
                fileName = "3233_MAIN_B5_B_B01.doc";
            }else if("3237".equals(riskCode)){
                fileName = "3237_MAIN_B5.docx";
            }else if("3162".equals(riskCode)){
                fileName = "3162_MAIN_B5.doc";
            }else if("3149".equals(riskCode)){
                fileName = "3149_MAIN_B5.doc";
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
