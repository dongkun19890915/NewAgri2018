package com.sinosoft.agriprpall.core.printPdf.service;

import com.sinosoft.agriprpall.api.printPdf.dto.PolicyPrintStatusDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 *缴费通知书打印页面
 * @Author: 陈道洋
 * @Date: 2017/11/27 16:41
 */
public interface PrintService {
    /**
     * 缴费通知书打印页面
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     * @param request 获取保单号
     * @param response
     * @return
     * @throws Exception
     */
    public void PaymentNoticePrint(HttpServletRequest request, HttpServletResponse response,String[] policyNo) throws Exception;

    /**
     * 标的地址打印
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     * @param request 获取保单号
     * @param response
     * @return
     * @throws Exception
     */
    public void PrpaddressPrint(HttpServletRequest request, HttpServletResponse response,String[] policyNo) throws Exception;

    /**
     * 主险，附加险清单打印
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     * @param request 获取保单号
     * @param response
     * @return
     * @throws Exception
     */
    public void MainSubPrint(HttpServletRequest request, HttpServletResponse response, String Type,String[] policyNo) throws Exception;

    /**
     * 承保卷宗打印打印
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     * @param request 获取保单号
     * @param response
     * @return
     * @throws Exception
     */
    public void FilePrint(HttpServletRequest request, HttpServletResponse response,String[] policyNo) throws Exception;

    /**
     * 缴费计划打印
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     * @param request 获取保单号
     * @param response
     * @return
     * @throws Exception
     */
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
    public void EndorsePrint(HttpServletRequest request, HttpServletResponse response,String[] endorseNos) throws Exception;
    /**
     * 批单正本打印
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     * @param request 获取批单号
     * @param response
     * @return
     * @throws Exception
     */
    public void OriginalPrint(HttpServletRequest request, HttpServletResponse response,String[] endorseNos,String comCode, String visaCode, String visaSerialNo, String userCode) throws Exception;

    /**
     * 特别约定打印
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public void SpecialyAgreedPrint(HttpServletRequest request, HttpServletResponse response,String[] policyNo) throws Exception;
    /**
     * 投保单打印
     * @author: 陈道洋
     * @date: 2017/11/27 16:50
     * @param request 获取保单号
     * @param response
     * @return
     * @throws Exception
     */
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
    public void voucherPrinting(HttpServletRequest request, HttpServletResponse response, String[] policyNo) throws Exception;
    /**
     * 查询保单打印状态
     * @author: 宋振振
     * @date: 2018/3/14 17:59
     * @param  policyNos 保单号数组
     * @return 返回已打印的保单号
     * @throws Exception
     */
    public PolicyPrintStatusDto policyPrintStatus(List<String> policyNos)throws Exception;
    /**
     * 查看批单打印状态
     * @author: 宋振振
     * @date: 2018/4/4 9:45
     * @param endorseNo
     * @return 打印状态
     * @throws Exception
     */
    public List<String> endorsePrintStatus(List<String> endorseNo)throws Exception;
}
