package com.sinosoft.agriclaim.web.printmanage;

import com.sinosoft.agriclaim.api.printmanage.PrintPDFApi;
import com.sinosoft.agriclaim.core.printmanage.PrintService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/***（理赔打印controller）
* @Author: 王志文
* @Date: 2017/12/7 15:29
*/
@RestController
@RequestMapping(value = PrintPDFApi.PATH)
public class PrintPDFController implements PrintPDFApi {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PrintPDFController.class);
    @Autowired
    private PrintService printService;
    /**
     * （保单抄件打印PDF实现接口）
     * @author: 王志文
     * @date: 2017/11/23 20:05
     * @param request 请求传入理算书号和员工代码参数
     * @param response
     * @throws Exception
     */
    @Override
    public void copyPrint(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.error("保单抄件打印服务");
        printService.copyPrint(request,response);
    }
    /**
     * （农险卷宗打印Pdf实现接口）
     * @author: 王志文
     * @date: 2017/11/23 20:05
     * @param request 通过请求传入立案号参数
     * @param response  农险卷宗PDF页面
     * @throws Exception
     */
    @Override
    public void agriPrint(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.error("农险卷宗封面打印服务");
        printService.agriPrint(request,response);
    }

    /**
     * （拒赔注销通知书打印PDF实现接口）
     * @author: 王志文
     * @date: 2017/11/24 8:41
     * @param request 通过请求传入立案号参数
     * @param response 拒赔注销通知书打印PDF页面
     * @throws Exception
     */
    @Override
    public void cancelNoticePrint(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.error("拒赔注销通知书打印服务");
        printService.cancelNoticePrint(request,response);
    }

    /**
     * （结案报告打印PDF实现接口）
     * @author: 王志文
     * @date: 2017/11/24 8:42
     * @param request  传入打印结案报告请求及立案号参数
     * @param response 结案报告打印PDF页面
     * @throws Exception
     */
    @Override
    public void endCasePrint(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.error("结案报告打印服务");
        printService.endCasePrint(request,response);
    }

    /**
     * （赔款收据打印PDF实现接口）
     * @author: 王志文
     * @date: 2017/11/24 8:44
     * @param request  传入打印请求及理算书号参数
     * @param response  赔款收据打印PDF实现
     * @throws Exception
     */
    @Override
    public void indemnityNoticePrint(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.error("赔款收据打印服务");
        printService.indemnityNoticePrint(request,response);
    }

    /**
     * （赔款理算书打印PDF实现接口）
     * @author: 王志文
     * @date: 2017/11/24 8:46
     * @param request 传入理算书打印请求及参数
     * @param response  赔款理算书打印PDF页面
     * @throws Exception
     */
    @Override
    public void compensatePrint(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.error("赔款理算书打印服务");
        printService.compensatePrint(request,response);
    }

    /**
     * （现场查勘报告打印PDF实现接口）
     * @author: 王志文
     * @date: 2017/11/24 8:49
     * @param request 传入打印请求
     * @param response 现场查勘报告打印PDF页面
     * @throws Exception
     */
    @Override
    public void siteSurveyPrint(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.error("现场查勘打印服务");
        printService.siteSurveyPrint(request,response);
    }

    /**
     * （多个单号多个页面的打印）
     * @author: 王志文
     * @date: 2017/12/25 17:03
     * @param request 传入打印请求
     * @param response 响应
     * @throws Exception
     */
    @Override
    public void multipleMorePrint(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] claimNos = request.getParameterValues("claimNos");
        String[] compensateNos = request.getParameterValues("compensateNos");
        String[] registNos = request.getParameterValues("registNos");
        String[] printTypes = request.getParameterValues("printTypes");
        printService.multipleMorePrint(request,response,claimNos,compensateNos,registNos,printTypes);
    }
    /**
     * （索赔须知）
     * @author: 刘鹏飞
     * @date 2018/01/30 16:00
     * @param request
     * @param response
     * @throws Exception
     */
    @Override
    public void claimCertifyPrint(HttpServletRequest request, HttpServletResponse response) {
        printService.claimCertifyPrint(request, response);
    }
}
