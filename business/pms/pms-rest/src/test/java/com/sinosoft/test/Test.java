package com.sinosoft.test;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 2017/8/15.
 */
public class Test {
    public static void main(String[] args) throws Exception{
        Map map = new HashMap();
        map.put("areaCode","12345");
        map.put("invalidDate",new Date());
        map.put("effectDate",new Date());

        URL url = new URL("http://localhost:9003/areaLimit/queryAreaLimitList");
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(connection.getOutputStream(),"8859_1");
        outputStreamWriter.write("areaCode=12345&invalidDate=2016-12-12&effectDate=2016-12-12");
        outputStreamWriter.flush();
        outputStreamWriter.close();
        String sCurrentLine;
        String sTotalString;
        sCurrentLine = "";
        sTotalString = "";
        InputStream l_urlStream;
        l_urlStream = connection.getInputStream();
        // 传说中的三层包装阿！
        BufferedReader l_reader = new BufferedReader(new InputStreamReader(l_urlStream));
         while ((sCurrentLine = l_reader.readLine()) != null) {
                sTotalString += sCurrentLine + "/r/n";
        }
        System.out.println(sTotalString);

    }
}
