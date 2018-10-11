package com.sinosoft.agriclaim.api.printmanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***（理赔打印pdf页面接口）
* @Author: 王志文
* @Date: 2017/11/24 10:12
*/
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = PrintPDFApi.PATH)
public interface PrintPDFApi {
    String PATH = "print";

    /**
     * （保单抄件打印PDF实现接口）
     * @author: 王志文
     * @date: 2017/11/23 20:05
     * @param request  请求传入理算书号和员工代码参数
     * @param response  保单抄件PDF页面
     * @throws Exception
     */
    @RequestMapping(value = "copyPrint", method = RequestMethod.GET)
    public void copyPrint(HttpServletRequest request, HttpServletResponse response) throws Exception;

    /**
     * （农险卷宗打印Pdf实现接口）
     * @author: 王志文
     * @date: 2017/11/23 20:05
     * @param request  通过请求传入立案号参数
     * @param response  农险卷宗PDF页面
     * @throws Exception
     */
    @RequestMapping(value = "agriPrint",method = RequestMethod.GET)
    public void agriPrint(HttpServletRequest request, HttpServletResponse response)throws Exception;

    /**
     * （拒赔注销通知书打印PDF实现接口）
     * @author: 王志文
     * @date: 2017/11/24 8:41
     * @param request 通过请求传入立案号参数
     * @param response 拒赔注销通知书打印PDF页面
     * @throws Exception
     */
    @RequestMapping(value = "cancelNoticePrint",method = {RequestMethod.GET})
    public void cancelNoticePrint(HttpServletRequest request, HttpServletResponse response)throws Exception;


    /**
     * （结案报告打印PDF实现接口）
     * @author: 王志文
     * @date: 2017/11/24 8:42
     * @param request  传入打印结案报告请求及立案号参数
     * @param response 结案报告打印PDF页面
     * @throws Exception
     */
    @RequestMapping(value = "endCasePrint",method = {RequestMethod.GET})
    public void endCasePrint(HttpServletRequest request, HttpServletResponse response)throws Exception;

    /**
     * （赔款收据打印PDF实现接口）
     * @author: 王志文
     * @date: 2017/11/24 8:44
     * @param request  传入打印请求及理算书号参数
     * @param response  赔款收据打印PDF实现
     * @throws Exception
     */
    @RequestMapping(value = "indemnityNoticePrint",method = {RequestMethod.GET})
    public void indemnityNoticePrint(HttpServletRequest request, HttpServletResponse response)throws Exception;

    /**
     * （赔款理算书打印PDF实现接口）
     * @author: 王志文
     * @date: 2017/11/24 8:46
     * @param request 传入理算书打印请求及参数
     * @param response 赔款理算书打印PDF页面
     * @throws Exception
     */
    @RequestMapping(value = "compensatePrint",method = {RequestMethod.GET})
    public void compensatePrint(HttpServletRequest request, HttpServletResponse response)throws Exception;

    /**
     * （现场查勘报告打印PDF实现接口）
     * @author: 王志文
     * @date: 2017/11/24 8:49
     * @param request  传入打印请求
     * @param response 现场查勘报告打印PDF页面
     * @throws Exception
     */
    @RequestMapping(value = "siteSurveyPrint",method = {RequestMethod.GET})
    public void siteSurveyPrint(HttpServletRequest request, HttpServletResponse response)throws Exception;

    /**
     * （多个单号多个页面的打印）
     * @author: 王志文
     * @date: 2017/12/25 17:01
     * @param request 传入打印请求
     * @param response 响应
     * @throws Exception
     */
    @RequestMapping(value = "multipleMorePrint",method = {RequestMethod.GET})
    public void multipleMorePrint(HttpServletRequest request, HttpServletResponse response) throws Exception;
    /**
     * （打印索赔须知）
     * @author: 杨航
     * @date 2018/01/30 16:00
     * @param request 里面只有报案号
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "claimCertifyPrint",method = {RequestMethod.GET})
    public void claimCertifyPrint(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
