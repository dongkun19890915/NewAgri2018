package com.sinosoft.demo.web.printpdf;

import com.sinosoft.demo.api.customer.CustomerApi;
import com.sinosoft.demo.api.printpdf.PrintDemoApi;
import com.sinosoft.demo.core.printpdf.service.PrintService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = PrintDemoApi.PATH)
public class PrintDemoController implements PrintDemoApi{
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PrintDemoController.class);
    @Autowired
    private PrintService printService;

    @Override
    public void testPrint(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.info("保单打印服务");
        printService.testPrint(request,response);
    }
}
