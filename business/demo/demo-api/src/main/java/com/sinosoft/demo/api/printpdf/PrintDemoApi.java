package com.sinosoft.demo.api.printpdf;

import com.sinosoft.demo.api.DemoConstant;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@FeignClient(name = DemoConstant.DEMO_SERVICE_NAME, path = PrintDemoApi.PATH)
public interface PrintDemoApi {
    String PATH = "print";

    @RequestMapping(value = "testPrint", method = RequestMethod.GET)
    public void testPrint(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
