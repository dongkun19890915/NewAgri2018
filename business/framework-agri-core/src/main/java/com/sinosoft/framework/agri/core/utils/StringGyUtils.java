package com.sinosoft.framework.agri.core.utils;

import com.sinosoft.framework.core.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * description:
 *
 * @outhor wq
 * @create 2018-05-04 14:48
 */
public class StringGyUtils {
    /**
     * 按字符个数拆分
     * 过时不建议使用，直接用 java.lang.split方法
     * @param originalString
     * @param splitByteLength
     * @return
     */
    @Deprecated
    public static String[] split(String originalString, int splitByteLength) {
        if (originalString == null) {
            return null;
        }
        if (splitByteLength <= 0) {
            return new String[]{originalString};
        }

        int total = originalString.length();
        //获取数组总长度
        int len = (int) Math.ceil(total / Double.valueOf(splitByteLength));
        //截取的起始位置
        int startIndex, endIndex;

        String[] ary = new String[len];
        String temp;
        for (int i = 0; i < len; i++) {
            startIndex = i * splitByteLength;
            endIndex = (i + 1) * splitByteLength;
            if (endIndex > total) {
                endIndex = total;
            }
            temp = originalString.substring(startIndex, endIndex);
            ary[i] = temp;
        }
        return ary;
    }

    /**
     * 按照字符拆分
     * 过时不建议使用，直接用 java.lang.split方法
     * @param originalString
     * @param delimiterString
     * @return
     */
    @Deprecated
    public static String[] split(String originalString, String delimiterString) {
        //return StringUtils.split(originalString, delimiterString);
        //如果被拆分字符为空
        if(originalString==null){
            return null;
        }
        if(delimiterString==null){
            return new String[]{originalString};
        }
        Map<String,String> map=new HashMap<>();
        map.put(".",".");
        map.put("*","*");
        map.put("^","^");
        map.put(":",":");
        map.put("|","|");
        map.put("\\","\\");

        if(map.containsKey(delimiterString)){
            delimiterString="\\"+delimiterString;
        }
        String[] ary=originalString.split(delimiterString);
        return ary;
    }
}