package com.sinosoft.notice.core.common.utils;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;


public class FreemarkerUtil
{
    
    
    /**
     * 特殊字符窜替换工具类
     * 将字符串templateStr中 ${key} 替换成map中匹配key的value值
     * @param map
     * @param templateStr
     * @return
     * @author zkr10
     * @throws Exception 
     * @date 2016年10月13日上午10:33:33
     */
    public static String freemarkerProcess(Map map, String templateStr) throws Exception{

        if ((templateStr == null) || ("".equals(templateStr)) || (map == null)){
            return templateStr;
        }
        if (templateStr.indexOf("$") < 0){
            return templateStr;
        }
        StringTemplateLoader stringLoader = new StringTemplateLoader();
        String template = "content";
        stringLoader.putTemplate(template, templateStr);
        Configuration cfg = new Configuration();
        cfg.setTemplateLoader(stringLoader);
        Template templateCon = cfg.getTemplate(template);
        StringWriter writer = new StringWriter();
        templateCon.process(map, writer);
        return writer.toString();
    }

}
