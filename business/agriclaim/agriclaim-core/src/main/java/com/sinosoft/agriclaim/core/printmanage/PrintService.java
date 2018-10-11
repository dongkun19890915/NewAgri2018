package com.sinosoft.agriclaim.core.printmanage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/***（理赔打印）
* @Author: 王志文
* @Date: 2017/12/7 15:29
*/
public interface PrintService {

    /**
     * （保单抄件打印PDF实现接口）
     * @author: 王志文
     * @date: 2017/11/23 20:05
     * @param request 请求传入理算书号和员工代码参数
     * @param response
     * @throws Exception
     */
    public void copyPrint(HttpServletRequest request, HttpServletResponse response) throws Exception;

    /**
     * （农险卷宗打印Pdf实现接口）
     * @author: 王志文
     * @date: 2017/11/23 20:05
     * @param request 通过请求传入立案号参数
     * @param response  农险卷宗PDF页面
     * @throws Exception
     */
    public void agriPrint(HttpServletRequest request, HttpServletResponse response) throws Exception;

    /**
     * （拒赔注销通知书打印PDF实现接口）
     * @author: 王志文
     * @date: 2017/11/24 8:41
     * @param request 通过请求传入立案号参数
     * @param response 拒赔注销通知书打印PDF页面
     * @throws Exception
     */
    public void cancelNoticePrint(HttpServletRequest request, HttpServletResponse response) throws Exception;

    /**
     * （结案报告打印PDF实现接口）
     * @author: 王志文
     * @date: 2017/11/24 8:42
     * @param request  传入打印结案报告请求及立案号参数
     * @param response 结案报告打印PDF页面
     * @throws Exception
     */
    public void endCasePrint(HttpServletRequest request, HttpServletResponse response) throws Exception;

    /**
     * （赔款收据打印PDF实现接口）
     * @author: 王志文
     * @date: 2017/11/24 8:44
     * @param request  传入打印请求及理算书号参数
     * @param response  赔款收据打印PDF实现
     * @throws Exception
     */
    public void indemnityNoticePrint(HttpServletRequest request, HttpServletResponse response) throws Exception;

    /**
     * （赔款理算书打印PDF实现接口）
     * @author: 王志文
     * @date: 2017/11/24 8:46
     * @param request 传入理算书打印请求及参数
     * @param response  赔款理算书打印PDF页面
     * @throws Exception
     */
    public void compensatePrint(HttpServletRequest request, HttpServletResponse response) throws Exception;

    /**
     * （现场查勘报告打印PDF实现接口）
     * @author: 王志文
     * @date: 2017/11/24 8:49
     * @param request 传入打印请求
     * @param response 现场查勘报告打印PDF页面
     * @throws Exception
     */
    public void siteSurveyPrint(HttpServletRequest request, HttpServletResponse response) throws Exception;

    /**
     * （多个单号多个页面的打印）
     * @author: 王志文
     * @date: 2017/12/7 15:36
     * @param request 需要打印的页面名和所需参数
     * @param response 多个PDF页面
     * @throws Exception
     */
    public void multipleMorePrint(HttpServletRequest request, HttpServletResponse response,
                                  String[] claimNos, String[] compensateNos,String [] registNos,
                                  String[] printTypes) throws Exception;
    /**
     * （索赔须知）
     * @date 2018/01/30 16:00
     * @param request
     * @param response
     */
    public void claimCertifyPrint(HttpServletRequest request, HttpServletResponse response);
}
