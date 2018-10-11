package com.sinosoft.agriprpall.api.printPdf;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.printPdf.dto.PolicyPrintStatusDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 *
 *缴费通知书打印页面
 * @Author: 陈道洋
 * @Date: 2017/11/27 16:41
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = PrintApi.PATH)
public interface PrintApi {
    String PATH = "print";

    /**
     * 缴费通知书打印页面
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     * @param request 获取保单号
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "PaymentNoticePrint", method = RequestMethod.GET)
    public void PaymentNoticePrint(HttpServletRequest request, HttpServletResponse response,String[] policyNo) throws Exception;

    @RequestMapping(value = "EndorsePaymentNoticePrint", method = RequestMethod.GET)
    public void EndorsePaymentNoticePrint(HttpServletRequest request, HttpServletResponse response,String[] endorseNo) throws Exception;

    /**
     * 标的地址打印
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     * @param request 获取保单号
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "PrpaddressPrint", method = RequestMethod.GET)
    public void PrpaddressPrint(HttpServletRequest request, HttpServletResponse response,String[] policyNo) throws Exception;

    /**
     * 主险清单打印
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     * @param request 获取保单号
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "MainPrint", method = RequestMethod.GET)
    public void MainPrint(HttpServletRequest request, HttpServletResponse response,String[] policyNo) throws Exception;

    /**
     * 附加险清单打印
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     * @param request 获取保单号
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "SubPrint", method = RequestMethod.GET)
    public void SubPrint(HttpServletRequest request, HttpServletResponse response,String[] policyNo) throws Exception;

    /**
     * 承保卷宗打印打印
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     * @param request 获取保单号
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "FilePrint", method = RequestMethod.GET)
    public void FilePrint(HttpServletRequest request, HttpServletResponse response,String[] policyNo) throws Exception;

    /**
     * 缴费计划打印
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     * @param request  获取保单号
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "PaymentPlanPrint", method = RequestMethod.GET)
    public void PaymentPlanPrint(HttpServletRequest request, HttpServletResponse response,String[] policyNo) throws Exception;

    /**
     * 批单抄件打印
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     * @param request 获取批单号
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "EndorsePrint", method = RequestMethod.GET)
    public void EndorsePrint(HttpServletRequest request, HttpServletResponse response,String[] endorseNo) throws Exception;
    /**
     * 批单正本打印
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     * @param request 获取批单号
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "EndorsePrintOriginal", method = RequestMethod.GET)
    public void OriginalPrint(HttpServletRequest request, HttpServletResponse response,String[] endorseNo,String comCode, String visaCode, String visaSerialNo, String userCode) throws Exception;
    /**
     * 特别约定打印
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     * @param request 获取保单号
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "SpecialyAgreedPrint", method = RequestMethod.GET)
    public void SpecialyAgreedPrint(HttpServletRequest request, HttpServletResponse response,String[] policyNo) throws Exception;

    /**
     * 投保单打印
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     * @param request 获取投保单号
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "InsuranceFormPrint", method = RequestMethod.GET)
    public void InsuranceFormPrint(HttpServletRequest request, HttpServletResponse response, String[] proposalNo) throws Exception;
    /**
     * 保单打印
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     * @param request 获取保单号
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "PolicyPrint", method = RequestMethod.GET)
    public void PolicyPrint(HttpServletRequest request, HttpServletResponse response,String[] policyNo,String comCode,String visaCode,String visaSerialNo,String userCode) throws Exception;

    /**
     * 保单下载
     * @author: 汪强
     * @date: 2017/11/27 16:50
     * @param request 获取保单号
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "policyDownLoad", method = RequestMethod.GET)
    public void policyDownLoad(HttpServletRequest request, HttpServletResponse response,String[] policyNo,String[] fileIds) throws Exception;

    /**
     * 凭证打印
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     * @param request 获取保单号
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "VoucherPrinting", method = RequestMethod.GET)
    public void voucherPrinting(HttpServletRequest request, HttpServletResponse response, String[] policyNo) throws Exception;

    /**
     * 查询保单打印状态
     * @author: 宋振振
     * @date: 2018/3/14 17:59
     * @param map
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "policyPrintStatus",method = {RequestMethod.POST})
    public @ResponseBody PolicyPrintStatusDto policyPrintStatus(@RequestBody Map<String,List<String>> map)throws Exception;
    /**
     * 查看批单打印状态
     * @author: 宋振振
     * @date: 2018/4/4 9:45
     * @param map endorseNo
     * @return 打印状态
     * @throws Exception
     */
    @RequestMapping(value = "endorsePrintStatus",method = {RequestMethod.POST})
    public @ResponseBody List<String> endorsePrintStatus(@RequestBody Map<String,List<String>> map)throws Exception;
}
