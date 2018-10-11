package com.sinosoft.agriclaim.core.printmanage.impl;

import com.sinosoft.agriclaim.api.claimmanage.dto.*;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistDto;
//import com.sinosoft.agriclaim.core.checkmanage.dao.PrplCertifyDirectDao;
//import com.sinosoft.agriclaim.core.checkmanage.entity.PrplCertifyDirect;
import com.sinosoft.agriclaim.core.claimmanage.service.PrpLClaimService;
import com.sinosoft.agriclaim.core.claimmanage.utils.PrintUtil;
import com.sinosoft.agriclaim.core.docmanage.dao.PrplCertifyDirectDao;
import com.sinosoft.agriclaim.core.docmanage.entity.PrplCertifyDirect;
import com.sinosoft.agriclaim.core.printmanage.PrintService;
import com.sinosoft.agriclaim.core.registmanage.service.PrpLRegistService;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.pms.api.kernel.PrpDriskApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

/**（理赔打印service实现类）
* @Author: 王志文
* @Date: 2017/11/24 9:35
*/
@Service
@Transactional
public class PrintServiceImpl extends BaseServiceImpl implements PrintService {

    /** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrintServiceImpl.class);

    private static final String TEXT_NONE = "无";
    @Autowired
    private PrpLClaimService prpLClaimService;
    @Autowired
    private PrpLRegistService prpLRegistService;
    @Autowired
    private PrplCertifyDirectDao prplCertifyDirectDao;
    @Autowired
    private PrpDriskApi prpDriskApi;

    /**
     * （农险卷宗打印PDF实现）
     * @author: 王志文
     * @date: 2017/11/23 20:05
     * @param request 通过请求传入立案号参数
     * @param response 农险卷宗PDF页面
     * @throws Exception
     */
    @Override
    public void agriPrint(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.error("农险卷宗打印服务开始");

        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream inputStream=null;
        try {
            String claimNo = request.getParameter("claimNo");
            List<Map<String,Object>> listMap = getAgriOfferParamsForProposal(request,classLoader,inputStream,claimNo);
            PrintUtil.printReportPdfMore(listMap,1,response);
        }catch (Exception e){
            LOGGER.error("农险卷宗打印服务报错：" + e.getMessage());
            e.printStackTrace();
            throw new BusinessException("农险卷宗打印服务报错");
        }finally {
            if(inputStream!=null){
                try{
                    inputStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        LOGGER.error("农险卷宗打印服务结束");
    }

    /**
     * （农险卷宗打印文件读取方法）
     * @author: 王志文
     * @date: 2017/11/24 9:28
     * @param request 通过请求传入立案号参数
     * @param classLoader
     * @param inputStream
     * @return 返回读取的PDF页面
     * @throws Exception
     */
    public List<Map<String, Object>> getAgriOfferParamsForProposal(HttpServletRequest request, ClassLoader classLoader, InputStream inputStream,String claimNo) throws Exception {
        AgriPrintDto agriPrintDto = prpLClaimService.queryAgriByPrint(claimNo);
        inputStream = classLoader.getResourceAsStream("template/agriPrint.jrxml");

        List<Map<String,Object>> listMap = new ArrayList<>();
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("claimNo",agriPrintDto.getClaimNo());
        paramMap.put("policyNo",agriPrintDto.getPolicyNo());
        paramMap.put("insuredName",agriPrintDto.getInsuredName());
        paramMap.put("riskCName",agriPrintDto.getRiskCName());
        paramMap.put("damageName",agriPrintDto.getDamageName());
        paramMap.put("damageStartDate",agriPrintDto.getDamageStartDate());
        paramMap.put("sumPaid",agriPrintDto.getSumPaid());
        paramMap.put("comCName",agriPrintDto.getComCName());
        InputStream url = classLoader.getResourceAsStream("template/claimImage/agriPrintLogo.gif");
        paramMap.put("logoPath",url);
        InputStream strUrl = classLoader.getResourceAsStream("template/claimImage/claimfile.jpg");
        paramMap.put("strPath",strUrl);

        paramMap.put("templetPath", inputStream);//jasper地址

        listMap.add(paramMap);
        return listMap;
    }

    /**
     * （拒赔注销通知书打印PDF实现）
     * @author: 王志文
     * @date: 2017/11/24 8:41
     * @param request 通过请求传入立案号参数
     * @param response 拒赔注销通知书打印PDF页面
     * @throws Exception
     */
    @Override
    public void cancelNoticePrint(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.error("拒赔注销通知书打印服务开始");

        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream inputStream=null;
        try {
            String claimNo = request.getParameter("claimNo");
            List<Map<String,Object>> listMap = getCancelNoticeOfferParamsForProposal(request,classLoader,inputStream,claimNo);
            PrintUtil.printReportPdfMore(listMap,1,response);
        }catch (Exception e){
            LOGGER.error("拒赔注销通知书打印服务报错：" + e.getMessage());
            e.printStackTrace();
            throw new BusinessException("拒赔注销通知书打印服务报错");
        }finally {
            if(inputStream!=null){
                try{
                    inputStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        LOGGER.error("拒赔注销通知书打印服务结束");
    }

    /**
     * （拒赔注销通知书打印文件读取方法）
     * @author: 王志文
     * @date: 2017/11/24 9:28
     * @param request 通过请求传入立案号参数
     * @param classLoader
     * @param inputStream
     * @return 返回读取的PDF页面
     * @throws Exception
     */
    public List<Map<String, Object>> getCancelNoticeOfferParamsForProposal(HttpServletRequest request, ClassLoader classLoader, InputStream inputStream,String claimNo) throws Exception {
        RefuseCancelBackPrintDto refuseCancelBackPrintDto = prpLClaimService.queryRefuseCancelByClaimNo(claimNo);
        inputStream = classLoader.getResourceAsStream("template/cancelNoticePrint.jrxml");

        List<Map<String,Object>> listMap = new ArrayList<>();
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("registNo",refuseCancelBackPrintDto.getRegistNo());
        paramMap.put("caseNo",refuseCancelBackPrintDto.getCaseNo());
        paramMap.put("insuredName",refuseCancelBackPrintDto.getInsuredName());
        paramMap.put("sumAmount",refuseCancelBackPrintDto.getSumAmount());
        paramMap.put("riskCName",refuseCancelBackPrintDto.getRiskCName());
        paramMap.put("itemCName",refuseCancelBackPrintDto.getItemCName());
        paramMap.put("policyNo",refuseCancelBackPrintDto.getPolicyNo());
        paramMap.put("startDate",refuseCancelBackPrintDto.getStartDate());
        paramMap.put("endDate",refuseCancelBackPrintDto.getEndDate());
        paramMap.put("damageStartDate",refuseCancelBackPrintDto.getDamageStartDate());
        paramMap.put("damageAddress",refuseCancelBackPrintDto.getDamageAddress());
        paramMap.put("damageName",refuseCancelBackPrintDto.getDamageName());
        paramMap.put("addressCName",refuseCancelBackPrintDto.getAddressCName());
        paramMap.put("damageReason",refuseCancelBackPrintDto.getCancelReason());
        paramMap.put("postCode",refuseCancelBackPrintDto.getPostCode());
        paramMap.put("phoneNumber",refuseCancelBackPrintDto.getPhoneNumber());
        paramMap.put("printTime",refuseCancelBackPrintDto.getPrintTime());
        InputStream url = classLoader.getResourceAsStream("template/claimImage/guoyuanPrintLOGO.jpg");
        paramMap.put("logoPath",url);

        paramMap.put("templetPath", inputStream);//jasper地址

        listMap.add(paramMap);
        return listMap;
    }

    /**
     * （结案报告打印PDF实现）
     * @author: 王志文
     * @date: 2017/11/24 8:42
     * @param request 传入打印结案报告请求及立案号参数
     * @param response  结案报告打印PDF页面
     * @throws Exception
     */
    @Override
    public void endCasePrint(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.error("结案报告打印服务开始");

        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream inputStream=null;
        try {
            String claimNo = request.getParameter("claimNo");
            List<Map<String,Object>> listMap = getEndCaseOfferParamsForProposal(request,classLoader,inputStream,claimNo);
            PrintUtil.printReportPdfMore(listMap,1,response);
        }catch (Exception e){
            LOGGER.error("结案报告打印服务报错：" + e.getMessage());
            e.printStackTrace();
            throw new BusinessException("结案报告打印服务报错");
        }finally {
            if(inputStream!=null){
                try{
                    inputStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        LOGGER.error("结案报告打印服务结束");
    }

    /**
     * （结案报告打印文件读取方法）
     * @author: 王志文
     * @date: 2017/11/24 9:28
     * @param request  通过请求传入立案号参数
     * @param classLoader 类加载器
     * @param inputStream 流信息
     * @return 返回读取的PDF页面
     * @throws Exception 异常信息
     */
    private List<Map<String, Object>> getEndCaseOfferParamsForProposal(HttpServletRequest request, ClassLoader classLoader, InputStream inputStream,String claimNo) throws Exception {
        EndCasePrintBackDto endCasePrintBackDto = prpLClaimService.queryEndCasePrintByClaimNo(claimNo);
        inputStream = classLoader.getResourceAsStream("template/endCasePrint.jrxml");

        List<Map<String,Object>> listMap = new ArrayList<>();
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("riskCName",endCasePrintBackDto.getRiskCName());
        paramMap.put("insuredName",endCasePrintBackDto.getInsuredName());
        paramMap.put("policyNo",endCasePrintBackDto.getPolicyNo());
        paramMap.put("sumAmount",endCasePrintBackDto.getSumAmount());
        paramMap.put("sumPremium",endCasePrintBackDto.getSumPremium());
        paramMap.put("damageStartDate",endCasePrintBackDto.getDamageStartDate());
        paramMap.put("damageAddress",endCasePrintBackDto.getDamageAddress());
        paramMap.put("tempContext",endCasePrintBackDto.getTempContext());
        InputStream url = classLoader.getResourceAsStream("template/claimImage/guoyuanPrintLOGO.jpg");
        paramMap.put("logoPath",url);

        paramMap.put("templetPath", inputStream);//jasper地址

        listMap.add(paramMap);
        return listMap;
    }

    /**
     * （赔款收据打印PDF实现）
     * @author: 王志文
     * @date: 2017/11/24 8:44
     * @param request 传入打印请求及理算书号参数
     * @param response 赔款收据打印PDF页面
     * @throws Exception 异常信息
     */
    @Override
    public void indemnityNoticePrint(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.error("赔款收据打印服务开始");

        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream inputStream=null;
        try {
            String compensateNo = request.getParameter("compensateNo");
            List<Map<String,Object>> listMap = getIndemnityNoticeOfferParamsForProposal(request,classLoader,inputStream,compensateNo);
            PrintUtil.printReportPdfMore(listMap,1,response);
        }catch (Exception e){
            LOGGER.error("赔款收据打印服务报错：" + e.getMessage());
            e.printStackTrace();
            throw new BusinessException("赔款收据打印服务报错");
        }finally {
            if(inputStream!=null){
                try{
                    inputStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        LOGGER.error("赔款收据打印服务结束");
    }

    /**
     * （赔款收据打印文件读取方法）
     * @author: 王志文
     * @date: 2017/11/24 9:28
     * @param request 通过请求传入理算书号参数
     * @param classLoader 类加载器
     * @param inputStream 流信息
     * @return 返回读取的PDF页面
     * @throws Exception 异常信息
     */
    private List<Map<String, Object>> getIndemnityNoticeOfferParamsForProposal(HttpServletRequest request, ClassLoader classLoader, InputStream inputStream,String compensateNo) throws Exception {
        IndemnityNoticePrintBackDto indemnityNoticePrintBackDto = prpLClaimService.queryIndemnityNoticeByCompensateNo(compensateNo);
        inputStream = classLoader.getResourceAsStream("template/indemnityNoticePrint.jrxml");

        List<Map<String,Object>> listMap = new ArrayList<>();
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("insuredName",indemnityNoticePrintBackDto.getInsuredName());
        paramMap.put("policyNo",indemnityNoticePrintBackDto.getPolicyNo());
        paramMap.put("riskCName",indemnityNoticePrintBackDto.getRiskCName());
        paramMap.put("compensateNo",indemnityNoticePrintBackDto.getCompensateNo());
        paramMap.put("sumClaim",indemnityNoticePrintBackDto.getSumClaim());
        paramMap.put("capitalSumClaim",indemnityNoticePrintBackDto.getCapitalSumClaim());
        paramMap.put("bank",indemnityNoticePrintBackDto.getBank());
        paramMap.put("receiverName",indemnityNoticePrintBackDto.getReceiverName());
        paramMap.put("account",indemnityNoticePrintBackDto.getAccount());
        paramMap.put("underWriteName",indemnityNoticePrintBackDto.getUnderWriteName());
        paramMap.put("handlerCode",indemnityNoticePrintBackDto.getHandlerCode());
        paramMap.put("printTime",indemnityNoticePrintBackDto.getPrintTime());
        InputStream url = classLoader.getResourceAsStream("template/claimImage/guoyuanPrintLOGO.jpg");
        paramMap.put("logoPath",url);

        paramMap.put("templetPath", inputStream);//jasper地址

        listMap.add(paramMap);
        return listMap;
    }

    /**
     * （赔款理算书打印PDF实现）
     * @author: 王志文
     * @date: 2017/11/24 8:46
     * @param request 传入理算书打印请求及参数
     * @param response 赔款理算书打印PDF页面
     * @throws Exception 异常信息
     */
    @Override
    public void compensatePrint(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.error("赔款理算书打印服务开始");

        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream inputStream=null;
        try {
            String compensateNo = request.getParameter("compensateNo");
            List<Map<String,Object>> listMap = getCompensateOfferParamsForProposal(request,classLoader,inputStream,compensateNo);
            PrintUtil.printReportPdfMore(listMap,1,response);
        }catch (Exception e){
            LOGGER.error("赔款理算书打印服务报错：" + e.getMessage());
            e.printStackTrace();
            throw new BusinessException("赔款理算书打印服务报错");
        }finally {
            if(inputStream!=null){
                try{
                    inputStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        LOGGER.error("赔款理算书打印服务结束");
    }

    /**
     * （赔款理算书打印文件读取方法）
     * @author: 王志文
     * @date: 2017/11/24 9:28
     * @param request 通过请求传入理算书号参数
     * @param classLoader 类加载
     * @param inputStream 流信息
     * @return 返回读取的PDF页面
     * @throws Exception 异常信息
     */
    private List<Map<String, Object>> getCompensateOfferParamsForProposal(HttpServletRequest request, ClassLoader classLoader, InputStream inputStream,String compensateNo) throws Exception {
        CompensatePrintBackDto compensatePrintBackDto = prpLClaimService.queryCompensatePrintByCompensateNo(compensateNo);
        inputStream = classLoader.getResourceAsStream("template/compensatePrint.jrxml");

        List<Map<String,Object>> listMap = new ArrayList<>();
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("riskCName",compensatePrintBackDto.getRiskCName());
        paramMap.put("compensateNo",compensatePrintBackDto.getCompensateNo());
        paramMap.put("claimNo",compensatePrintBackDto.getClaimNo());
        paramMap.put("insuredName",compensatePrintBackDto.getInsuredName());
        paramMap.put("policyNo",compensatePrintBackDto.getPolicyNo());
        paramMap.put("damageStartDate",compensatePrintBackDto.getDamageStartDate());
        paramMap.put("amount",compensatePrintBackDto.getAmount());
        paramMap.put("damageAddress",compensatePrintBackDto.getDamageAddress());
        paramMap.put("validAmount",compensatePrintBackDto.getValidAmount());
        paramMap.put("damageName",compensatePrintBackDto.getDamageName());
        paramMap.put("startDate",compensatePrintBackDto.getStartDate());
        paramMap.put("endDate",compensatePrintBackDto.getEndDate());
        paramMap.put("itemCName",compensatePrintBackDto.getItemCName());
        paramMap.put("bank",compensatePrintBackDto.getBank());
        paramMap.put("account",compensatePrintBackDto.getAccount());
        paramMap.put("receiverName",compensatePrintBackDto.getReceiverName());
        paramMap.put("tempContext",compensatePrintBackDto.getTempContext());
        paramMap.put("sumClaim",compensatePrintBackDto.getSumClaim());
        paramMap.put("sumDutyPaid",compensatePrintBackDto.getSumDutyPaid());
        paramMap.put("sumPaid",compensatePrintBackDto.getSumPaid());
        paramMap.put("underWriteEndDate",compensatePrintBackDto.getUnderWriteEndDate());
        paramMap.put("userName",compensatePrintBackDto.getUserName());
        paramMap.put("underWriteName",compensatePrintBackDto.getUnderWriteName());
        paramMap.put("listFlag",compensatePrintBackDto.getListFlag());
        paramMap.put("tempContext1",compensatePrintBackDto.getTempContext1());
        InputStream url = classLoader.getResourceAsStream("template/claimImage/guoyuanPrintLOGO.jpg");
        paramMap.put("logoPath",url);

        paramMap.put("templetPath", inputStream);//jasper地址

        listMap.add(paramMap);
        return listMap;
    }

    /**
     * （现场查勘报告打印PDF实现）
     * @author: 王志文
     * @date: 2017/11/24 8:49
     * @param request 传入打印请求
     * @param response 现场查勘报告打印PDF页面
     * @throws Exception
     */
    @Override
    public void siteSurveyPrint(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.error("现场查勘报告打印服务开始");

        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream inputStream=null;
        try {
            List<Map<String,Object>> listMap = getSiteSurveyOfferParamsForProposal(request,classLoader,inputStream);
            PrintUtil.printReportPdfMore(listMap,1,response);
        }catch (Exception e){
            LOGGER.error("现场查勘报告打印服务报错：" + e.getMessage());
            e.printStackTrace();
            throw new BusinessException("现场查勘报告打印服务报错");
        }finally {
            if(inputStream!=null){
                try{
                    inputStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        LOGGER.error("现场查勘报告打印服务结束");
    }

    /**
     * （现场查勘报告文件读取方法）
     * @author: 王志文
     * @date: 2017/11/24 9:25
     * @param request 传入打印请求
     * @param classLoader 类加载器
     * @param inputStream 流信息
     * @return 返回读取的PDF页面
     * @throws Exception 异常信息
     */
    private List<Map<String, Object>> getSiteSurveyOfferParamsForProposal(HttpServletRequest request, ClassLoader classLoader, InputStream inputStream) throws Exception {
        inputStream = classLoader.getResourceAsStream("template/siteSurveyPrint.jrxml");

        List<Map<String,Object>> listMap = new ArrayList<>();
        Map<String,Object> paramMap = new HashMap<>();

        paramMap.put("templetPath", inputStream);//jasper地址

        listMap.add(paramMap);
        return listMap;
    }




    /**
     * （保单抄件打印PDF实现）
     * @author: 王志文
     * @date: 2017/11/23 20:05
     * @param request 通过请求传入理算书号和员工代码参数
     * @param response 响应
     * @throws Exception 异常信息
     */
    @Override
    public void copyPrint(HttpServletRequest request, HttpServletResponse response) throws Exception {
        LOGGER.error("保单抄件服务开始");

        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream inputStream=null;
        try {
            String registNo = request.getParameter("registNo");
            List<Map<String,Object>> listMap = getCopyPrintOfferParamsForProposal(request,classLoader,inputStream,registNo);
            PrintUtil.printReportPdfMore(listMap,1,response);
        }catch (Exception e){
            LOGGER.error("保单抄件服务报错：" + e.getMessage());
            e.printStackTrace();
            throw new BusinessException("保单抄件服务报错");
        }finally {
            if(inputStream != null){
                try{
                    inputStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        LOGGER.error("保单抄件服务结束");
    }

    /**
     * （保单抄件文件读取方法）
     * @author: 王志文
     * @date: 2017/11/24 9:25
     * @param request 请求传入理算书号和员工代码参数
     * @param classLoader 类加载器
     * @param inputStream 流信息
     * @return 返回读取的PDF页面
     * @throws Exception 异常信息
     */
    private List<Map<String, Object>> getCopyPrintOfferParamsForProposal(HttpServletRequest request,ClassLoader classLoader,InputStream inputStream,String registNo) throws Exception {
        inputStream = classLoader.getResourceAsStream("template/copyPrint.jrxml");
        String userCode = request.getParameter("userCode");
        CopyPrintBackDto copyPrintBackDto = prpLClaimService.queryCopyPrintByRegistNo(registNo,userCode);

        if (copyPrintBackDto == null){
            return null;
        }
        List<Map<String,Object>> listMap = new ArrayList<>();
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("riskCName",copyPrintBackDto.getRiskCName());
        paramMap.put("registNo",copyPrintBackDto.getRegistNo());
        paramMap.put("policyNo",copyPrintBackDto.getPolicyNo());
        paramMap.put("insuredName",copyPrintBackDto.getInsuredName());
        paramMap.put("insuredAddress",copyPrintBackDto.getInsuredAddress());
        paramMap.put("itemDetailName",copyPrintBackDto.getItemDetailName());
        paramMap.put("unitAmount",copyPrintBackDto.getUnitAmount());
        paramMap.put("amount",copyPrintBackDto.getAmount());
        paramMap.put("sumAmount",copyPrintBackDto.getSumAmount());
        paramMap.put("sumAmount1",copyPrintBackDto.getSumAmount1());
        paramMap.put("deductible",copyPrintBackDto.getDeductible());
        paramMap.put("operateDate",copyPrintBackDto.getOperateDate());
        paramMap.put("inputDate",copyPrintBackDto.getInputDate());
        paramMap.put("signDate",copyPrintBackDto.getSignDate());
        paramMap.put("outputDate",copyPrintBackDto.getOutputDate());
        paramMap.put("startDate",copyPrintBackDto.getStartDate());
        paramMap.put("endDate",copyPrintBackDto.getEndDate());
        paramMap.put("coinsFlag",copyPrintBackDto.getCoinsFlag());
        paramMap.put("clauses",copyPrintBackDto.getClauses());

        List<CopyPrintListDto> copyPrintListDtoList = copyPrintBackDto.getCopyPrintListDtoList();
        paramMap.put("list",copyPrintListDtoList);

        paramMap.put("templetPath", inputStream);//jasper地址

        listMap.add(paramMap);
        return listMap;
    }

    /**
     * （多个单号多个页面的打印）
     * @author: 王志文
     * @date: 2017/12/7 15:36
     * @param request 需要打印的页面名和所需参数
     * @param response 多个PDF页面
     * @throws Exception 异常信息
     */
    @Override
    public void multipleMorePrint(HttpServletRequest request, HttpServletResponse response, String[] claimNos, String[] compensateNos, String [] registNos, String[] printTypes) throws Exception {
        LOGGER.error("多单号多个PDF页面打印服务开始");
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream coverInputStream = null;
        InputStream localCheckInputStream = null;
        InputStream endCaseInputStream = null;
        InputStream cancelInputStream = null;
        InputStream copyPrintInputStream = null;
        InputStream compensateInputStream = null;
        InputStream indemnityNoticeInputStream = null;
        try {
            List<Map<String,Object>> listMap = new ArrayList<>();
            for (int i = 0 ;i < claimNos.length ; i++) {
                String claimNo = "";
                if (claimNos != null && StringUtils.isNotEmpty(claimNos[i])){
                    claimNo = claimNos[i];
                }
                String compensateNo ="";
                if (compensateNos != null && StringUtils.isNotEmpty(compensateNos[i])){
                    compensateNo = compensateNos[i];
                }
                String registNo ="";
                if (registNos != null && StringUtils.isNotEmpty(registNos[i])){
                    registNo = registNos[i];
                }
                String printStr = "";
                if (printTypes != null && StringUtils.isNotEmpty(printTypes[i])){
                    printStr = printTypes[i];
                }
                String [] printArr = printStr.split("_");
                String coverPrint = "";
                String localCheck = "";
                String endCase = "";
                String cancel = "";
                String copyPrint = "";
                String compensate = "";
                String indemnityNotice = "";

                for (String printType: printArr) {
                    if ("CoverPrint".equals(printType)){
                        coverPrint = "y";
                    }
                    if ("LocalCheck".equals(printType)){
                        localCheck = "y";
                    }
                    if ("EndCase".equals(printType)){
                        endCase = "y";
                    }
                    if ("Cancel".equals(printType)){
                        cancel = "y";
                    }
                    if ("Compensate".equals(printType)){
                        compensate = "y";
                    }
                    if ("IndemnityNotice".equals(printType)){
                        indemnityNotice = "y";
                    }
                    if ("CopyPrint".equals(printType)){
                        copyPrint = "y";
                    }
                }
                //农险卷宗
                List<Map<String,Object>> coverPrintListMap = null;
                //现场查勘
                List<Map<String,Object>> localCheckListMap = null;
                //结案报告
                List<Map<String,Object>> endCaseListMap = null;
                //注销拒赔
                List<Map<String,Object>> cancelListMap = null;
                //保单抄件
                List<Map<String,Object>> copyPrintListMap = null;
                //理算书
                List<Map<String,Object>> compensateListMap = null;
                //赔款收据
                List<Map<String,Object>> indemnityNoticeListMap = null;
                //组合页面

                if (StringUtils.isNotEmpty(coverPrint) && "y".equals(coverPrint)){
                    coverPrintListMap = getAgriOfferParamsForProposal(request,classLoader,coverInputStream,claimNo);
                }
                if (StringUtils.isNotEmpty(localCheck) && "y".equals(localCheck)){
                    localCheckListMap = getSiteSurveyOfferParamsForProposal(request,classLoader,localCheckInputStream);
                }
                if (StringUtils.isNotEmpty(endCase) && "y".equals(endCase)){
                    endCaseListMap = getEndCaseOfferParamsForProposal(request,classLoader,endCaseInputStream,claimNo);
                }
                if (StringUtils.isNotEmpty(cancel) && "y".equals(cancel)){
                    cancelListMap = getCancelNoticeOfferParamsForProposal(request,classLoader,cancelInputStream,claimNo);
                }
                if (StringUtils.isNotEmpty(copyPrint) && "y".equals(copyPrint)){
                    copyPrintListMap = getCopyPrintOfferParamsForProposal(request,classLoader,copyPrintInputStream,registNo);
                }
                if (StringUtils.isNotEmpty(compensate) && "y".equals(compensate)){
                    compensateListMap = getCompensateOfferParamsForProposal(request,classLoader,compensateInputStream,compensateNo);
                }
                if (StringUtils.isNotEmpty(indemnityNotice) && "y".equals(indemnityNotice)){
                    indemnityNoticeListMap = getIndemnityNoticeOfferParamsForProposal(request,classLoader,indemnityNoticeInputStream,compensateNo);
                }
                if (coverPrintListMap != null && coverPrintListMap.size() > 0){
                    listMap.add(coverPrintListMap.get(0));
                }
                if (localCheckListMap != null && localCheckListMap.size() > 0){
                    listMap.add(localCheckListMap.get(0));
                }
                if (endCaseListMap != null && endCaseListMap.size() > 0){
                    listMap.add(endCaseListMap.get(0));
                }
                if (cancelListMap != null && cancelListMap.size() > 0){
                    listMap.add(cancelListMap.get(0));
                }
                if (copyPrintListMap != null && copyPrintListMap.size() > 0){
                    listMap.add(copyPrintListMap.get(0));
                }
                if (compensateListMap != null && compensateListMap.size() > 0){
                    listMap.add(compensateListMap.get(0));
                }
                if (indemnityNoticeListMap != null && indemnityNoticeListMap.size() > 0){
                    listMap.add(indemnityNoticeListMap.get(0));
                }
            }
            PrintUtil.printReportPdfMore(listMap,1,response);
        }catch (Exception e){
            LOGGER.error("多单号多个PDF页面打印服务报错：" + e.getMessage());
            e.printStackTrace();
            throw new BusinessException("多单号多个PDF页面打印服务报错");
        }finally {
            if(coverInputStream != null){
                try{
                    coverInputStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(localCheckInputStream != null){
                try{
                    localCheckInputStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(endCaseInputStream != null){
                try{
                    endCaseInputStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(cancelInputStream != null){
                try{
                    cancelInputStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(copyPrintInputStream != null){
                try{
                    copyPrintInputStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(compensateInputStream != null){
                try{
                    compensateInputStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(indemnityNoticeInputStream != null){
                try{
                    indemnityNoticeInputStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        LOGGER.error("多单号多个PDF页面打印服务结束");
    }
    /**
     * （索赔须知）
     * @author 刘鹏飞
     * @date 2018/01/30 16:00
     * @param request
     */
    @Override
    public void claimCertifyPrint(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.error("开始打印索赔须知");

        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream inputStream=null;

        try {
            List<Map<String, Object>> listMap = getClaimCertifyParamsForProposal(request, response, classLoader, inputStream);
            PrintUtil.printReportPdfMore(listMap,1,response);
        } catch (Exception e) {
            LOGGER.error("打印索赔须知异常");
            e.printStackTrace();
            throw new BusinessException("打印索赔须知异常");
        } finally {
            if(inputStream!=null){
                try{
                    inputStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

        LOGGER.error("结束打印索赔须知");
    }
    /**
     * （获取索赔须知的数据）
     * @param request
     * @param response
     * @param classLoader
     * @param inputStream
     * @return
     * @throws Exception
     */
    private List<Map<String, Object>> getClaimCertifyParamsForProposal(HttpServletRequest request, HttpServletResponse response, ClassLoader classLoader, InputStream inputStream) throws Exception{
        inputStream = classLoader.getResourceAsStream("template/printCertifyDirect.jrxml");
        List<Map<String,Object>> listMap = new ArrayList<>();
        Map<String,Object> paramMap = new HashMap<>();
        // 获取报案号
        String registNo = request.getParameter("registNo");
        PrpLRegistDto prpLRegistDto = prpLRegistService.queryByPK(registNo);
        // 获取被保险人姓名
        String insuredName = prpLRegistDto.getInsuredName();
        String riskCode = prpLRegistDto.getRiskCode();
        String riskName = "";
        // 获取索赔材料失败提示信息
        String message = "";
        if (StringUtils.isNotEmpty(riskCode)) {
            Map<String,String> map = new HashMap<>();
            map.put("riskCode", riskCode);
            map.put("isChinese", "zh-CN");
            // 获取险种名称
            riskName = prpDriskApi.translateCode(map);
        } else {
            LOGGER.error("获取险种代码失败！");
        }
        List<PrplCertifyDirect> prplCertifyDirectList = prplCertifyDirectDao.findAll(Specifications.<PrplCertifyDirect>and().eq("registNo", registNo).build(),new Sort(Direction.ASC, "serialNo"));
        int i = 1;
        if (prplCertifyDirectList != null && prplCertifyDirectList.size() > 0) {
            for (PrplCertifyDirect prplCertifyDirect : prplCertifyDirectList) {
                if (StringUtils.isNotEmpty(prplCertifyDirect.getTypeName())) {
                    if (!prplCertifyDirect.getTypeName().contains(".")) {
                        prplCertifyDirect.setTypeName(i++ + "." +prplCertifyDirect.getTypeName());
                    }
                }
            }
        } else {
            prplCertifyDirectList = new ArrayList<PrplCertifyDirect>();
            PrplCertifyDirect prplCertifyDirect = new PrplCertifyDirect();
            prplCertifyDirect.setTypeName("暂未提供材料");
            prplCertifyDirectList.add(prplCertifyDirect);
        }
        ListIterator<PrplCertifyDirect> it = prplCertifyDirectList.listIterator();
        while(it.hasNext()){
            PrplCertifyDirect direct = it.next();
            if(StringUtils.isEmpty(direct.getTypeName())){
                it.remove();
            }
        }
        paramMap.put("templetPath", inputStream); //jasper地址
        paramMap.put("list",prplCertifyDirectList);
        paramMap.put("insuredName", insuredName);
        paramMap.put("riskName", riskName);
        listMap.add(paramMap);
        return listMap;
    }
}
