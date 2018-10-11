package com.sinosoft.demo.core.printpdf.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
* 打印
* @Author: 周家伟
* @Date: 2017/11/21 上午9:16
*/
public interface PrintService {

    /**
     * 打印测试方法
     * @author: 周家伟
     * @date: 2017/11/21 上午9:17
     * @param request
     * @param response
     * @throws Exception
     */
    public void testPrint(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
