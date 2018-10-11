package com.sinosoft.agriprpall.web.printPdf;

import com.sinosoft.agriprpall.api.printPdf.PrintApi;
import com.sinosoft.agriprpall.api.printPdf.dto.PolicyPrintStatusDto;
import com.sinosoft.agriprpall.core.printPdf.service.PrintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RestController
@RequestMapping(value = PrintApi.PATH)
public class PrintController implements PrintApi {
    @Autowired
    private PrintService printService;
    /**
     * 缴费通知书打印页面
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     * @param request 获取保单号
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    public void PaymentNoticePrint(HttpServletRequest request, HttpServletResponse response,String[] policyNo) throws Exception {
         printService.PaymentNoticePrint(request,response,policyNo);
    }

    public void EndorsePaymentNoticePrint(HttpServletRequest request, HttpServletResponse response,String[] endorseNo) throws Exception{
        printService.PaymentNoticePrint(request,response,endorseNo);
    }
    /**
     * 标的地址打印
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     * @param request 获取保单号
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    public void PrpaddressPrint(HttpServletRequest request, HttpServletResponse response,String[] policyNo) throws Exception {
        printService.PrpaddressPrint(request,response,policyNo);
    }
    /**
     * 主险清单打印
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     * @param request 获取保单号
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    public void MainPrint(HttpServletRequest request, HttpServletResponse response,String[] policyNo) throws Exception {
        printService.MainSubPrint(request,response,"main",policyNo);
    }
    /**
     * 附加险清单打印
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     * @param request 获取保单号
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    public void SubPrint(HttpServletRequest request, HttpServletResponse response,String[] policyNo) throws Exception {
        printService.MainSubPrint(request,response,"sub",policyNo);
    }
    /**
     * 承保卷宗打印打印
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     * @param request 获取保单号
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    public void FilePrint(HttpServletRequest request, HttpServletResponse response,String[] policyNo) throws Exception {
        printService.FilePrint(request,response,policyNo);
    }
    /**
     * 缴费计划打印
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     * @param request 获取保单号
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    public void PaymentPlanPrint(HttpServletRequest request, HttpServletResponse response,String[] policyNo) throws Exception {
        printService.PaymentPlanPrint(request,response,policyNo);
    }
    /**
     * 批单抄件打印
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     * @param request 获取批单号
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    public void EndorsePrint(HttpServletRequest request, HttpServletResponse response,String[] endorseNo) throws Exception {
        printService.EndorsePrint(request,response,endorseNo);
    }
    /**
     * 批单正本打印
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     * @param request 获取批单号
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    public void OriginalPrint(HttpServletRequest request, HttpServletResponse response,String[] endorseNo,String comCode, String visaCode, String visaSerialNo, String userCode) throws Exception{
        printService.OriginalPrint(request,response,endorseNo,comCode,visaCode,visaSerialNo,userCode);
    }
    /**
     * 特别约定打印
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     * @param request 获取保单号
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    public void SpecialyAgreedPrint(HttpServletRequest request, HttpServletResponse response,String[] policyNo) throws Exception {
        printService.SpecialyAgreedPrint(request,response,policyNo);
    }
    /**
     * 投保单打印
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     * @param request 获取投保单号
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    public void InsuranceFormPrint(HttpServletRequest request, HttpServletResponse response,String[] proposalNo) throws Exception {
        printService.InsuranceFormPrint(request,response,proposalNo);
    }
    /**
     * 保单打印
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     * @param request 获取保单号
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    public void PolicyPrint(HttpServletRequest request, HttpServletResponse response,String[] policyNo,String comCode,String visaCode,String visaSerialNo,String userCode) throws Exception {
        printService.PolicyPrint(request,response,policyNo,comCode,visaCode,visaSerialNo,userCode);
    }

    /**
     * 保单下载
     * @author: 汪强
     * @date: 2017/11/27 16:50
     * @param request 获取保单号
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    public void policyDownLoad(HttpServletRequest request, HttpServletResponse response,String[] policyNo,String[] fileIds) throws Exception {
        printService.policyDownLoad(request,response,policyNo,fileIds);
    }
    /**
     * 凭证打印
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     * @param request 获取保单号
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    public void voucherPrinting(HttpServletRequest request, HttpServletResponse response, String[] policyNo) throws Exception {
        printService.voucherPrinting(request, response, policyNo);
    }

    /**
     * 查询保单打印状态
     * @author: 宋振振
     * @date: 2018/3/14 17:59
     * @param map 保单号数组
     * @return 返回已打印的保单号
     * @throws Exception
     */
    @RequestMapping(value = "policyPrintStatus",method = {RequestMethod.POST})
    public PolicyPrintStatusDto policyPrintStatus(@RequestBody Map<String,List<String>> map)throws Exception{
        List<String> policyNos=map.get("policyNos");
        return  printService.policyPrintStatus(policyNos);
    }
    /**
     * 查看批单打印状态
     * @author: 宋振振
     * @date: 2018/4/4 9:45
     * @param map endorseNo
     * @return 打印状态
     * @throws Exception
     */
    public @ResponseBody List<String> endorsePrintStatus(@RequestBody Map<String,List<String>> map)throws Exception{
        List<String> endorseNos=map.get("endorseNos");
        return printService.endorsePrintStatus(endorseNos);
    }
}
