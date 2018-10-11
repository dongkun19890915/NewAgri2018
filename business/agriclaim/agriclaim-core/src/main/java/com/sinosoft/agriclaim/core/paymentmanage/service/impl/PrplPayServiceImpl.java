package com.sinosoft.agriclaim.core.paymentmanage.service.impl;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCompensateDto;
import com.sinosoft.agriclaim.api.paymentmanage.PrplPayApi;
import com.sinosoft.agriclaim.api.paymentmanage.dto.*;
import com.sinosoft.agriclaim.api.recasemanage.dto.UndwrtWriteBackReCaseDto;
import com.sinosoft.agriclaim.core.businessutilmanage.utils.FileUtil;
import com.sinosoft.agriclaim.core.claimmanage.dao.PrpLClaimDao;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLClaim;
import com.sinosoft.agriclaim.core.claimmanage.utils.GetPayStatusFlagUtil;
import com.sinosoft.agriclaim.core.common.client.UIClaimPayService;
import com.sinosoft.agriclaim.core.common.receipt.QueryAllinPayreceiptInfoSoapBindingStub;
import com.sinosoft.agriclaim.core.common.undwrtClient.NewAgriPrpallUndwrtService;
import com.sinosoft.agriclaim.core.common.utils.FTPUtils;
import com.sinosoft.agriclaim.core.common.utils.XMLUtils;
import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLCompensate;
import com.sinosoft.agriclaim.core.paymentmanage.dao.*;
import com.sinosoft.agriclaim.core.paymentmanage.entity.*;
import com.sinosoft.agriclaim.core.paymentmanage.service.PaymentGetNoUtilService;
import com.sinosoft.agriclaim.core.paymentmanage.service.PrpLPayMainService;
import com.sinosoft.agriclaim.core.paymentmanage.service.PrplPayService;
import com.sinosoft.agriclaim.core.registmanage.dao.PrpLRegistDao;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegist;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegistKey;
import com.sinosoft.agriprpall.api.policymanage.PrpCinsuredApi;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCinsuredDto;
import com.sinosoft.dms.api.dict.PrpDcodeApi;
import com.sinosoft.dms.api.dict.dto.PrpDcodeDto;
import com.sinosoft.fileserver.client.FileServerHelper;
import com.sinosoft.framework.agri.core.dto.PacketDto;
import com.sinosoft.framework.agri.core.excel.hanlder.ReadHandler;
import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.agri.core.utils.ExcelUtil;
import com.sinosoft.framework.agri.core.utils.QuicklyExportExcel;
import com.sinosoft.framework.agri.core.utils.XmlUtil;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.datatype.DateTime;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.UserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.txnlist.api.claiminsurancelist.NyxBreedClaimListApi;
import com.sinosoft.txnlist.api.claiminsurancelist.NyxClaimPayListApi;
import com.sinosoft.txnlist.api.claiminsurancelist.NyxPlantingClaimListApi;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.*;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.w3c.dom.Node;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:43:17.258
 * @description 支付信息子表Core接口实现
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PrplPayServiceImpl extends BaseCustomServiceImpl implements PrplPayService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrplPayServiceImpl.class);

    @Autowired
    private PrplPayDao prplPayDao;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    PrplPayApi prplPayApi;
    @Value("${fileService.url}")
    private String fileServiceUrl;
    @Value("${exportExcelType}")
    private String exportExcelType;
    @Value("${webservice.webAgriPrpallService.url}")
    private String webAgriPrpallServiceUrl;
    @Value("${webservice.receiptService.url}")
    private String receiptServiceUrl;
    @Value("${webservice.receiptService.ftpUser}")
    private String ftpUser;
    @Value("${webservice.receiptService.ftpPass}")
    private String ftpPass;
    @Value("${webservice.receiptService.ftpUrl}")
    private String ftpUrl;
    @Value("${webservice.receiptService.ftpDir}")
    private String ftpDir;
    @Value("${webservice.receiptService.ftpPort}")
    private int ftpPort;
    @Value("${webservice.receiptService.iUserCode}")
    private String iUserCode;
    @Value("${webservice.receiptService.iPassWord}")
    private String iPassWord;
    @Autowired
    private PrpLRegistDao prpLRegistDao;
    @Autowired
    private PrpLPayMainDao prpLPayMainDao;
    @Autowired
    private PrpLPayExtDao prpLPayExtDao;
    @Autowired
    private PrpLPayBillDao prpLPayBillDao;
    @Autowired
    private PrpLClaimDao prpLClaimDao;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyyMMddhhmmss");
    @Autowired
    private PaymentGetNoUtilService paymentGetNoUtilService;
    @Autowired
    private NyxClaimPayListApi nyxClaimPayListApi;
    @Autowired
    private NyxPlantingClaimListApi nyxPlantingClaimListApi;
    @Autowired
    private NyxBreedClaimListApi nyxBreedClaimListApi;
    @Autowired
    private PrpDcodeApi prpDcodeApi;
    @Autowired
    PrpCinsuredApi prpCinsuredApi;
    @Autowired
    private UserApi userApi;
    @Autowired
    private PrpDuserApi prpDuserApi;
    @Autowired
    private PrpLClaimBillManagerDao prpLClaimBillManagerDao;
    @Autowired
    private PrpLPayMainService prpLPayMainService;

    @Autowired
    PrplPayService prplPayService;
    /**
     *@description 新增
     *@param
     */
    public void save(PrplPayDto prplPayDto) {
        PrplPay prplPay = this.convert(prplPayDto, PrplPay.class);
        prplPayDao.save(prplPay);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String serialNo,String serialNo2) {
        PrplPayKey prplPayKey = new PrplPayKey(serialNo,serialNo2);
        prplPayDao.delete(prplPayKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrplPayDto prplPayDto) {
        PrplPay prplPay = this.convert(prplPayDto, PrplPay.class);
        prplPayDao.save(prplPay);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    public PrplPayDto queryByPK(String serialNo,String serialNo2) {
        PrplPayKey prplPayKey = new PrplPayKey(serialNo,serialNo2);
        PrplPay prplPay = prplPayDao.findOne(prplPayKey);
        return this.convert(prplPay,PrplPayDto.class);
    }

    /**
     * @description 按条件查询支付录入信息（带分页）
     * @param  prpJPlanFeePageMsgDto 查询入参
     * @return PrpJPlanFeePageMsgDto 查询结果
     * @throws Exception
     * @author 李磊
     * @date 2017-12-21 15:35
     */
    public PrpJPlanFeePageMsgDto queryPrpJPlanFeePageMsgDto(PrpJPlanFeePageMsgDto prpJPlanFeePageMsgDto)throws Exception{
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(UIClaimPayService.class);
        jaxWsProxyFactoryBean.setAddress(webAgriPrpallServiceUrl+"/webAgriPrpallService/services/UIClaimPayService?wsdl".trim());
        UIClaimPayService uiClaimPayService = (UIClaimPayService)jaxWsProxyFactoryBean.create();

        String requestXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><requestData>";

        //获取查询条件
        if(prpJPlanFeePageMsgDto!=null){
            requestXml +="<registNo>"+ prpJPlanFeePageMsgDto.getRegistNo()+"</registNo>";//报案号
            requestXml +="<policyNo>"+prpJPlanFeePageMsgDto.getPolicyNo()+"</policyNo>";//保单号
            requestXml +="<insuredName>"+prpJPlanFeePageMsgDto.getInsuredName()+"</insuredName>";//被保人姓名
            requestXml +="<certiNo>"+prpJPlanFeePageMsgDto.getCertiNo()+"</certiNo>";//计算书号
            requestXml +="<payRefReason>"+prpJPlanFeePageMsgDto.getPayRefReason()+"</payRefReason>";//赔款类型
            requestXml +="<certiType>"+prpJPlanFeePageMsgDto.getCertiType()+"</certiType>";//支付类型
            requestXml +="<comCode>"+prpJPlanFeePageMsgDto.getComCode()+"</comCode>";//案件类型
            requestXml +="<flowStartDate>"+prpJPlanFeePageMsgDto.getFlowStartDate()+"</flowStartDate>";//流入时间起
            requestXml +="<flowEndDate>"+prpJPlanFeePageMsgDto.getFlowEndDate()+"</flowEndDate>";//流入时间止
            requestXml +="<pageNum>"+prpJPlanFeePageMsgDto.getPageNum()+"</pageNum>";//页码
            requestXml +="<pageCount>"+prpJPlanFeePageMsgDto.getPageCount()+"</pageCount>";//每页显示记录数
            requestXml +="<queryType></queryType>";//分页标识
            requestXml += "</requestData>";
        }
        String getXml = uiClaimPayService.queryPayList(requestXml);
        System.out.println(getXml.replaceAll("><",">\r\n<"));

        List<PrpJplanFeeDto>  prpJplanFeeDtoList = new ArrayList<PrpJplanFeeDto>();

        Document document = null;
        try {
            document = DocumentHelper.parseText(getXml);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        //取支付录入信息
        Element requestData =document.getRootElement();
        List<Element> list = requestData.elements("payList");
        PrpJPlanFeePageMsgDto prpJplanFeePageMsgDto1 = new PrpJPlanFeePageMsgDto();
        if(list.size()>0){

            //取总记录数
            Element page = requestData.element("page");
            String pageSize = page.element("pageSize").getTextTrim();

            for(int i=0;i<list.size();i++){
                PrpJplanFeeDto prpJplanFeeDto = new PrpJplanFeeDto();

                String policyNo = list.get(i).element("policyNo").getTextTrim();
                String registNo = list.get(i).element("registNo").getTextTrim();
                String certiNo = list.get(i).element("certiNo").getTextTrim();
                String payRefReason = list.get(i).element("payRefReason").getTextTrim();
                String insuredName = list.get(i).element("insuredName").getTextTrim();
                String planFee = list.get(i).element("planFee").getTextTrim();
                String payAmount = list.get(i).element("payAmount").getTextTrim();
                String paidPayAmount = list.get(i).element("paidPayAmount").getTextTrim();
                String thisPayAmount = list.get(i).element("thisPayAmount").getTextTrim();

                prpJplanFeeDto.setPolicyNo(policyNo);
                prpJplanFeeDto.setRegistNo(registNo);
                prpJplanFeeDto.setCertiNo(certiNo);
                prpJplanFeeDto.setPayRefReason(payRefReason);
                prpJplanFeeDto.setInsuredName(insuredName);
                prpJplanFeeDto.setPlanFee(planFee);
                prpJplanFeeDto.setPayAmount(payAmount);
                prpJplanFeeDto.setPaidPayAmount(paidPayAmount);
                prpJplanFeeDto.setThisPayAmount(thisPayAmount);
                prpJplanFeeDtoList.add(prpJplanFeeDto);
            }
            prpJplanFeePageMsgDto1.setPrpJplanFeeDtoList(prpJplanFeeDtoList);
            prpJplanFeePageMsgDto1.setPageSize(Integer.valueOf(pageSize));
            return prpJplanFeePageMsgDto1;
        }else{
            prpJplanFeePageMsgDto1.setPageSize(0);
            return prpJplanFeePageMsgDto1;
        }

    }

    /**
     * @description 按条件查询支付录入信息（无分页）
     * @param  queryPrpJplanFeeDto 查询入参
     * @return List<PrpJplanFeeDto> 查询结果
     * @throws Exception
     * @author 李磊
     * @date 2017-12-21 15:35
     */
    public List<PrpJplanFeeDto> queryPrpJPlanFeeDto(@RequestBody QueryPrpJplanFeeDto queryPrpJplanFeeDto) throws Exception{

        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(UIClaimPayService.class);
        jaxWsProxyFactoryBean.setAddress(webAgriPrpallServiceUrl+"/webAgriPrpallService/services/UIClaimPayService?wsdl".trim());
        UIClaimPayService uiClaimPayService = (UIClaimPayService)jaxWsProxyFactoryBean.create();

            String requestXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><requestData>";

            //获取查询条件
            if(queryPrpJplanFeeDto!=null){
                requestXml +="<registNo>"+ queryPrpJplanFeeDto.getRegistNo()+"</registNo>";//报案号
                requestXml +="<policyNo>"+queryPrpJplanFeeDto.getPolicyNo()+"</policyNo>";//保单号
                requestXml +="<insuredName>"+queryPrpJplanFeeDto.getInsuredName()+"</insuredName>";//被保人姓名
                requestXml +="<certiNo>"+queryPrpJplanFeeDto.getCertiNo()+"</certiNo>";//计算书号
                requestXml +="<payRefReason>"+queryPrpJplanFeeDto.getPayRefReason()+"</payRefReason>";//赔款类型
                requestXml +="<certiType>"+queryPrpJplanFeeDto.getCertiType()+"</certiType>";//支付类型
                requestXml +="<comCode>"+queryPrpJplanFeeDto.getComCode()+"</comCode>";//案件类型
                requestXml +="<flowStartDate>"+queryPrpJplanFeeDto.getFlowStartDate()+"</flowStartDate>";//流入时间起
                requestXml +="<flowEndDate>"+queryPrpJplanFeeDto.getFlowEndDate()+"</flowEndDate>";//流入时间止
                requestXml +="<queryType>all</queryType>";//无分页
                requestXml += "</requestData>";
            }
            String getXml = uiClaimPayService.queryPayList(requestXml);
            System.out.println(getXml.replaceAll("><",">\r\n<"));

            List<PrpJplanFeeDto>  prpJplanFeeDtoList = new ArrayList<PrpJplanFeeDto>();

            Document document = null;
            try {
                document = DocumentHelper.parseText(getXml);
            } catch (DocumentException e) {
                e.printStackTrace();
            }

            //取支付录入信息
            Element requestData =document.getRootElement();
            List<Element> list = requestData.elements("payList");

            PrpJPlanFeePageMsgDto prpJplanFeePageMsgDto1 = new PrpJPlanFeePageMsgDto();
            for(int i=0;i<list.size();i++){
                PrpJplanFeeDto prpJplanFeeDto = new PrpJplanFeeDto();

                String policyNo = list.get(i).element("policyNo").getTextTrim();
                String registNo = list.get(i).element("registNo").getTextTrim();
                String certiNo = list.get(i).element("certiNo").getTextTrim();
                String payRefReason = list.get(i).element("payRefReason").getTextTrim();
                String insuredName = list.get(i).element("insuredName").getTextTrim();
                String planFee = list.get(i).element("planFee").getTextTrim();
                String payAmount = list.get(i).element("payAmount").getTextTrim();
                String paidPayAmount = list.get(i).element("paidPayAmount").getTextTrim();
                String thisPayAmount = list.get(i).element("thisPayAmount").getTextTrim();

                prpJplanFeeDto.setPolicyNo(policyNo);
                prpJplanFeeDto.setRegistNo(registNo);
                prpJplanFeeDto.setCertiNo(certiNo);
                prpJplanFeeDto.setPayRefReason(payRefReason);
                prpJplanFeeDto.setInsuredName(insuredName);
                prpJplanFeeDto.setPlanFee(planFee);
                prpJplanFeeDto.setPayAmount(payAmount);
                prpJplanFeeDto.setPaidPayAmount(paidPayAmount);
                prpJplanFeeDto.setThisPayAmount(thisPayAmount);
                prpJplanFeeDtoList.add(prpJplanFeeDto);
            }
            return prpJplanFeeDtoList;
    }


    /**
     * @description 按条件查询已经录入的支付信息
     * @param  prplPayDto 查询入参封装对象
     * @return PrplPayDto 查询结果返回对象
     * @throws Exception
     * @author 李磊
     * @date 2017-12-28 14:15
     */
    public PageInfo<PrplPayDto> queryPrplPayDtoByCondition(PrplPayDto prplPayDto) throws Exception{
        if(prplPayDto.getPageSize()==0){
            prplPayDto.setPageSize(20);
        }
        if(prplPayDto.getPageNo()<1){
            throw new DataVerifyException("查询页码不能小于1！");
        }
        if(prplPayDto.getPageSize()<1){
            throw new DataVerifyException("每页查询数量不能小于1！");
        }
        StringBuilder count = new StringBuilder(200);
        StringBuilder sql = new StringBuilder(200);
        sql.append("select serialno,serialno2,compensateno,policyno,registno,inputdate,billno,     ");
        sql.append("  payamount,paytype,paymenttype,insuredname,thirdpayflag,comcode               ");
        sql.append("  from (select pay.serialno,                                                   ");
        sql.append("               pay.serialno2,                                                  ");
        sql.append("               pay.compensateno,                                               ");
        sql.append("               pay.policyno,                                                   ");
        sql.append("               pay.registno,                                                   ");
        sql.append("               pay.inputdate,                                                  ");
        sql.append("               nvl((select distinct billno                                     ");
        sql.append("                     from prplpaybill bill                                     ");
        sql.append("                    where bill.paymentno = pay.serialno),                      ");
        sql.append("                   pay.serialno) as billno,                                    ");
        sql.append("               pay.payamount,                                                  ");
        sql.append("               pay.paytype,                                                    ");
        sql.append("               pay.paymenttype,                                                ");
        sql.append("               (select re.insuredname                                          ");
        sql.append("                  from prplregist re                                           ");
        sql.append("                 where re.registno = pay.registno) as insuredname,             ");
        sql.append("               (select prplpaymain.thirdpayflag                                ");
        sql.append("                  from prplpaymain prplpaymain                                 ");
        sql.append("                 where prplpaymain.paymentno = pay.serialno) as thirdpayflag,  ");
        sql.append("               pay.comcode                                                     ");
        sql.append("          from prplpay pay) data                                               ");


        count.append("select count(1)                                                                ");
        count.append("  from (select pay.serialno,                                                   ");
        count.append("               pay.serialno2,                                                  ");
        count.append("               pay.compensateno,                                               ");
        count.append("               pay.policyno,                                                   ");
        count.append("               pay.registno,                                                   ");
        count.append("               pay.inputdate,                                                  ");
        count.append("               nvl((select distinct billno                                     ");
        count.append("                     from prplpaybill bill                                     ");
        count.append("                    where bill.paymentno = pay.serialno),                      ");
        count.append("                   pay.serialno) as billno,                                    ");
        count.append("               pay.payamount,                                                  ");
        count.append("               pay.paytype,                                                    ");
        count.append("               pay.paymenttype,                                                ");
        count.append("               (select re.insuredname                                          ");
        count.append("                  from prplregist re                                           ");
        count.append("                 where re.registno = pay.registno) as insuredname,             ");
        count.append("               (select prplpaymain.thirdpayflag                                ");
        count.append("                  from prplpaymain prplpaymain                                 ");
        count.append("                 where prplpaymain.paymentno = pay.serialno) as thirdpayflag,  ");
        count.append("               pay.comcode                                                     ");
        count.append("          from prplpay pay) data                                               ");

        String dateCondition;
        //定义查询条件语句
        List<String> conditionList = new ArrayList<String>();
        //定义条件参数集合
        Map<String, String> paraMap = new HashMap<String, String>();
        if(StringUtils.isNotEmpty(prplPayDto.getSerialNo())){//支付单号
            conditionList.add("and serialNo like :serialNo");
            paraMap.put("serialNo", "%"+prplPayDto.getSerialNo()+"%");
        }
        if(StringUtils.isNotEmpty(prplPayDto.getCompensateNo())){//计算书号
            conditionList.add("and compensateNo like :compensateNo");
            paraMap.put("compensateNo", "%"+prplPayDto.getCompensateNo()+"%");
        }
        if(StringUtils.isNotEmpty(prplPayDto.getPolicyNo())){//保单号
            conditionList.add("and policyNo like :policyNo");
            paraMap.put("policyNo", "%"+prplPayDto.getPolicyNo()+"%");
        }
        if(StringUtils.isNotEmpty(prplPayDto.getRegistNo())){//报案号
            conditionList.add("and registNo like :registNo");
            paraMap.put("registNo", "%"+prplPayDto.getRegistNo()+"%");
        }
        if(StringUtils.isNotEmpty(prplPayDto.getBillNo())){//批次号
            conditionList.add("and billNo like :billNo");
            paraMap.put("billNo", "%"+prplPayDto.getBillNo()+"%");
        }
        if(StringUtils.isNotEmpty(prplPayDto.getPayType())){//支付类型
            conditionList.add("and payType in ("+prplPayDto.getPayType()+")"); //赔付P1，预付P3
        }
        if(StringUtils.isNotEmpty(prplPayDto.getPaymentType())){//赔款类型
            if(!"else".equals(prplPayDto.getPaymentType())){
                conditionList.add("and paymentType=:paymentType");
                paraMap.put("paymentType", prplPayDto.getPaymentType());
            }else {
                conditionList.add("and (paymentType not in ('P60','GS60','P63','P62','P64','P61','F67','P65','P68') or paymentType is null)");
            }
        }
        if(StringUtils.isNotEmpty(prplPayDto.getInsuredName())){//被保险人
            conditionList.add("and insuredName=:insuredName");
            paraMap.put("insuredName", prplPayDto.getInsuredName());
        }
        if(StringUtils.isNotEmpty(prplPayDto.getThirdPayFlag())){//第三方支付标识 处理状态
            conditionList.add("and thirdPayFlag=:thirdPayFlag");
            paraMap.put("thirdPayFlag", prplPayDto.getThirdPayFlag());
        }
        if(StringUtils.isNotEmpty(prplPayDto.getComCode())){//机构  案件状态
            if(prplPayDto.getComCode().length()==10){
                conditionList.add("and comCode=:comCode");
                paraMap.put("comCode", prplPayDto.getComCode());
            }else{
                conditionList.add("and comCode<>:comCode");
                paraMap.put("comCode", prplPayDto.getComCode().substring(3));
            }
        }
        if(StringUtils.isNotEmpty(prplPayDto.getFlowStartDate())){//流入时间起
            conditionList.add("and inputDate>=to_date('"+prplPayDto.getFlowStartDate()+" 00:00:00','YYYY-MM-DD hh24:mi:ss')");
        }
        if(StringUtils.isNotEmpty(prplPayDto.getFlowEndDate())){//流入时间止
            conditionList.add("and inputDate<=to_date('"+prplPayDto.getFlowEndDate()+" 23:59:59','YYYY-MM-DD hh24:mi:ss')");
        }
        //如果有拼接条件
        if (conditionList.size() > 0) {
            //去掉第一个"and"字符串
            dateCondition = this.joinCondition(conditionList);
            sql.append(" where ");
            sql.append(dateCondition);
            count.append(" where ");
            count.append(dateCondition);
        }
        Query dataQuery = entityManager.createNativeQuery(sql.toString(),PrplPayInfo.class);
        Query countQuery = entityManager.createNativeQuery(count.toString());
        for(Map.Entry<String,String> entry : paraMap.entrySet()){
            dataQuery.setParameter(entry.getKey(),entry.getValue());
            countQuery.setParameter(entry.getKey(),entry.getValue());
        }
        //当前页第一条数据在总数据中的位置
        dataQuery.setFirstResult((prplPayDto.getPageNo()-1)*prplPayDto.getPageSize());
        dataQuery.setMaxResults(prplPayDto.getPageSize());
        System.err.println(sql.toString());
        long countNum = Long.valueOf( String.valueOf (countQuery.getSingleResult()));

        List<PrplPayInfo> prplPayInfoList =  dataQuery.getResultList();
        List<PrplPayDto> PrplPayDtoList=new ArrayList<>();
        convertCollection(prplPayInfoList,PrplPayDtoList,PrplPayDto.class);


        //统一封装分页响应dto
        PageInfo<PrplPayDto> pageInfo = new PageInfo<>();
        pageInfo.setContent(PrplPayDtoList);// 数据存放dto集合
        pageInfo.setPages(prplPayDto.getPageNo());// 当前页数
        pageInfo.setTotalCount(countNum);// 总记录数
        return pageInfo;
    }
    /**
     *支付清单数据的导入保存
     * @author: 孙朋飞
     * @date: 2018/1/2 14:44
     * @param fileId 文件标识id
     * @param comCode 机构代码
     * @return 返回清单号和金额合计
     * @throws Exception
     */
    @Override
    public Map<String,Object> importNyxClaimPayList(String fileId,String comCode) throws Exception {
        if(StringUtils.isEmpty(comCode)){
            comCode = SinoRequestContext.getCurrentContext().getUser().getLoginComCode();
        }
        if(StringUtils.isEmpty(comCode)){
            throw new DataVerifyException("机构代码不能为空!");
        }
        if(StringUtils.isEmpty(fileId)){
            throw new DataVerifyException("文件传入失败!");
        }
        //初始化工具类
        ExcelUtil excelUtil = ExcelUtil.initImport();
        Map<String,String> otherParams=new HashMap<String,String>();
        otherParams.put("fileId",fileId);

        List<NyxClaimPayListDto> nyxClaimPayListDtos=null;
        File file=null;
        try {
            file= File.createTempFile("支付清单",exportExcelType);
            FileServerHelper.dowloadFileByFileId(fileServiceUrl+"/downloadFile",file,otherParams);
            NyxClaimPayListReader nyxClaimPayListReader = new NyxClaimPayListReader();
            excelUtil.setStartRowNumber(3).readExcel(file,nyxClaimPayListReader);
            nyxClaimPayListDtos = nyxClaimPayListReader.getNyxClaimPayListDtos();

        } finally {
            //删除本地临时文件
            if (file != null) {
                file.delete();
            }
        }
        //清单号
        String tableName = "PRPLPAYBILL";
        String  riskCode="";
        if(nyxClaimPayListDtos!=null && nyxClaimPayListDtos.size()>0){
            if(nyxClaimPayListDtos.get(0)!=null){
                List<PrpLClaim> prpLClaimList = prpLClaimDao.queryAllByRegistNo(nyxClaimPayListDtos.get(0).getRegistNo());
                if(prpLClaimList!=null && prpLClaimList.size()>0){
                    riskCode = prpLClaimList.get(0).getClassCode()+"00";
                }else{
                    throw new BusinessException("没有此报案号的信息!");
                }
            }
        }else{
            throw new BusinessException("导入的数据为空!");
        }
        int year = new DateTime(DateTime.current().toString()).getYear();
        String listNo = paymentGetNoUtilService.getNo(tableName, riskCode,comCode, year);
        //支付编号
        tableName = "prplpaymain";
        Double sumAccount=0D;
        String paymentNo;
        for (NyxClaimPayListDto nyxClaimPayListDto : nyxClaimPayListDtos) {
            paymentNo = paymentGetNoUtilService.getNo(tableName, riskCode, comCode, year);
            nyxClaimPayListDto.setListNo(listNo);
            nyxClaimPayListDto.setPaymentNo(paymentNo);
            sumAccount+=nyxClaimPayListDto.getSettleAmount();
        }
        //支付清单数据的批量保存
        try {
            nyxClaimPayListApi.batchSaveNyxClaimPayList(nyxClaimPayListDtos);
        }catch(Exception e){
            throw new BusinessException();
        }
        //返回清单号和金额合计
        Map<String,Object> map=new HashMap<>();
        map.put("listNo",listNo);
        map.put("sumAccount",sumAccount);
        return map;
    }
    /**
     *导入excel回调接口实现类
     * @Author: 孙朋飞
     * @Date: 2018/1/3 9:44
     */
    public class NyxClaimPayListReader implements ReadHandler {
        //存储导入的list集合
        private List<NyxClaimPayListDto> nyxClaimPayListDtos=new ArrayList<>();
        /**
         * 导入excel数据
         * @author: 孙朋飞
         * @date: 2018/1/3 9:49
         * @param sheetIndex 当前sheet页的页码,从0开始
         * @param rowIndex 当前行的行号，从0开始
         * @param row 当前行数据
         */
        @Override
        public void handler(int sheetIndex, int rowIndex, List<String> row) {
            NyxClaimPayListDto nyxClaimPayListDto = new NyxClaimPayListDto();
            if(StringUtils.isEmpty(row.get(0))){
                throw new BusinessException("序号不能为空");
            }
            nyxClaimPayListDto.setSerialNo(row.get(0));
            if(StringUtils.isEmpty(row.get(1))){
                throw new BusinessException("保单号不能为空");
            }
            nyxClaimPayListDto.setPolicyNo(row.get(1));
            if(StringUtils.isEmpty(row.get(2))){
                throw new BusinessException("报案号不能为空");
            }
            nyxClaimPayListDto.setRegistNo(row.get(2));
            if(StringUtils.isEmpty(row.get(3))){
                throw new BusinessException("立案号不能为空");
            }
            nyxClaimPayListDto.setClaimNo(row.get(3));
            nyxClaimPayListDto.setCompensateNo(row.get(4));
            if(StringUtils.isEmpty(row.get(5))){
                throw new BusinessException("农户代码不能为空");
            }
            nyxClaimPayListDto.setfCode(row.get(5));
            if(StringUtils.isEmpty(row.get(6))){
                throw new BusinessException("农户姓名不能为空");
            }
            nyxClaimPayListDto.setfName(row.get(6));
            if(StringUtils.isNotEmpty(row.get(7))){
                nyxClaimPayListDto.setReceiverType(row.get(7).split("-")[0]);
            }else{
                throw new BusinessException("领款人类型不能为空");
            }
            if(StringUtils.isEmpty(row.get(8))){
                throw new BusinessException("领款人姓名不能为空");
            }
            nyxClaimPayListDto.setReceiverName(row.get(8));
            if(StringUtils.isNotEmpty(row.get(9))) {
                nyxClaimPayListDto.setIdentifyType(row.get(9).split("-")[0]);
            }else{
                throw new BusinessException("领款人证件类型不能为空");
            }
            if(StringUtils.isEmpty(row.get(10))){
                throw new BusinessException("领款人证件号不能为空");
            }
            nyxClaimPayListDto.setIdentifyNumber(row.get(10));
            nyxClaimPayListDto.setBankType(row.get(11));
            nyxClaimPayListDto.setProvinceName(row.get(12));
            nyxClaimPayListDto.setCityName(row.get(13));
            if(StringUtils.isEmpty(row.get(14))){
                throw new BusinessException("开户银行名称不能为空");
            }
            nyxClaimPayListDto.setBankName(row.get(14));
            if(StringUtils.isEmpty(row.get(15))){
                throw new BusinessException("银行账号不能为空");
            }
            nyxClaimPayListDto.setBankAccount(row.get(15));
            if(StringUtils.isNotEmpty(row.get(16))) {
                nyxClaimPayListDto.setAccountType(row.get(16).split("-")[0]);
            }
            if(StringUtils.isNotEmpty(row.get(17))) {
                nyxClaimPayListDto.setAccountFlag(row.get(17).split("-")[0]);
            }
            if(StringUtils.isEmpty(row.get(18))){
                throw new BusinessException("手机号码不能为空");
            }
            nyxClaimPayListDto.setPhoneNumber(row.get(18));
            if(StringUtils.isEmpty(row.get(19))){
                throw new BusinessException("赔款类型不能为空");
            }
            nyxClaimPayListDto.setSettleType(row.get(19).split("-")[0]);
            if(StringUtils.isNotEmpty(row.get(20))){
                nyxClaimPayListDto.setSettleAmount(Double.valueOf(row.get(20)));
            }else{
                throw new BusinessException("赔款金额不能空");
            }
            this.nyxClaimPayListDtos.add(nyxClaimPayListDto);
        }

        public List<NyxClaimPayListDto> getNyxClaimPayListDtos() {
            return nyxClaimPayListDtos;
        }
    }
    /**
     * 支付清单的下载
     * @author: 孙朋飞
     * @date: 2017/12/27 16:16
     * @param listNo 支付清单号
     * @return 文件下载的链接
     * @throws Exception
     */
    @Override
    public String expNyxClaimPayList(String listNo) throws Exception {
        if(StringUtils.isEmpty(listNo)){
            throw new DataVerifyException("支付清单号不能为空!");
        }
        String titleName = "";
        String excelName= "";
        excelName=titleName= "国元农业保险支付清单";
        Class<NyxClaimPayListDto> nyxClaimPayListClass = NyxClaimPayListDto.class;
        File file = null;
        String shortLinkId = null;
        //数据
        Map<String,String> map=new HashMap<>();
        map.put("listNo",listNo);
        List<NyxClaimPayListDto>  responsePayList=nyxClaimPayListApi.queryNyxClaimPayListByListNo(map);
        if(responsePayList==null || responsePayList.size()==0){
            throw new BusinessException("无此支付清单数据!");
        }else{

            for(int i=0;i<responsePayList.size();i++){
                StringBuffer receiverType = new StringBuffer("");
                StringBuffer identifyType = new StringBuffer("");
                StringBuffer accountType = new StringBuffer("");
                StringBuffer accountFlag = new StringBuffer("");
                receiverType.append(responsePayList.get(i).getReceiverType()).append("-").append(
                        prpDcodeApi.translateCode("ReceiverType",responsePayList.get(i).getReceiverType(),""));
                responsePayList.get(i).setReceiverType(receiverType.toString());
                identifyType.append(responsePayList.get(i).getIdentifyType()).append("-").append(
                        prpDcodeApi.translateCode("IdentifyType",responsePayList.get(i).getIdentifyType(),""));
                responsePayList.get(i).setIdentifyType(identifyType.toString());
                accountType.append(responsePayList.get(i).getAccountType()).append("-").append(
                        prpDcodeApi.translateCode("AccountType",responsePayList.get(i).getAccountType(),""));
                responsePayList.get(i).setAccountType(accountType.toString());
                if("00".equals(responsePayList.get(i).getAccountFlag())){
                    accountFlag.append("00-银行卡");
                }
                if("01".equals(responsePayList.get(i).getAccountFlag())){
                    accountFlag.append("01-存折");
                }
                if("03".equals(responsePayList.get(i).getAccountFlag())){
                    accountFlag.append("03-对公账户");
                }
                responsePayList.get(i).setAccountFlag(accountFlag.toString());
            }
        }
        for(int i=0;i<responsePayList.size();i++){
            if("Y".equals(responsePayList.get(i).getSettleType())){
                responsePayList.get(i).setSettleType("Y-预赔");
            }else{
                responsePayList.get(i).setSettleType("C-实赔");
            }
        }
        try{
            //Excel导出类型判断：.xls 97-2003 版本 Excel
            QuicklyExportExcel quicklyExportExcel = new QuicklyExportExcel();
            file = quicklyExportExcel.quicklyExport(exportExcelType,excelName,titleName,
                    responsePayList,1,20, nyxClaimPayListClass);
            // 上传文件到fileServer
            FileUtil fileUtil = new FileUtil();
            List<String> selectList=new ArrayList<>();
            //收款人类型下拉选
            List<PrpDcodeDto> prpDcodeDtoList = prpDcodeApi.queryCodeInfoByCodeType("ReceiverType", "");
            for (PrpDcodeDto prpDcodeDto : prpDcodeDtoList) {
                selectList.add(prpDcodeDto.getCodeCode()+"-"+prpDcodeDto.getCodeCName());
            }
            this.addExcelSelect(selectList,file,responsePayList.size(),7);
            //收款人证件类型下拉选
            selectList = new ArrayList<>();
            prpDcodeDtoList = prpDcodeApi.queryCodeInfoByCodeType("IdentifyType", "");
            for (PrpDcodeDto prpDcodeDto : prpDcodeDtoList) {
                selectList.add(prpDcodeDto.getCodeCode()+"-"+prpDcodeDto.getCodeCName());
            }
            this.addExcelSelect(selectList,file,responsePayList.size(),9);
            //银行账号属性下拉选
            selectList = new ArrayList<>();
            prpDcodeDtoList = prpDcodeApi.queryCodeInfoByCodeType("AccountType", "");
            for (PrpDcodeDto prpDcodeDto : prpDcodeDtoList) {
                selectList.add(prpDcodeDto.getCodeCode()+"-"+prpDcodeDto.getCodeCName());
            }
            this.addExcelSelect(selectList,file,responsePayList.size(),16);
            //银行账号类型下拉选
            selectList = new ArrayList<>();
            selectList.add("00-银行卡");
            selectList.add("01-存折");
            selectList.add("03-对公账户");
            this.addExcelSelect(selectList,file,responsePayList.size(),17);
            //赔付类型
            selectList = new ArrayList<>();
            selectList.add("C-实赔");
            selectList.add("Y-预赔");
            this.addExcelSelect(selectList,file,responsePayList.size(),19);
            String userCode = SinoRequestContext.getCurrentContext().getUserCode();
            String systemId = "agri/tempfile";//系统
            String bussType = "agriclaim_paymentmanage";//项目名_模块名
            shortLinkId = fileUtil.uploadFile(fileServiceUrl,file,userCode,systemId,bussType);
        }finally {
            // 删除本地的临时文件
            if (file != null) {
                file.delete();
            }
        }
        return shortLinkId;
    }

    /**
     * 由理赔清单封装支付清单并下载
     * @param requestNyxPlantingClaimListDto
     * @return 文件下载的链接
     * @throws Exception
     * @author 王心洋
     * @time 2018/4/12
     */
    @Override
    public String expAssembleClaimPayList(RequestNyxPlantingClaimListDto requestNyxPlantingClaimListDto) throws Exception {
        String shortLinkId;
        String titleName;
        String excelName;
        BigDecimal sumPaid = new BigDecimal("0");
        excelName=titleName= "国元农业保险支付清单";
        Class<NyxClaimPayListDto> nyxClaimPayListClass = NyxClaimPayListDto.class;
        NyxClaimPayListDto nyxClaimPayListDto = new NyxClaimPayListDto();
        List<NyxClaimPayListDto> nyxClaimPayListDtoList = new ArrayList<>();//支付清单
        List<NyxPlantingClaimListDto> nyxPlantingClaimListDtoList;//种植险理赔清单
        List<NyxBreedClaimListDto> nyxBreedClaimListDtoList;//养殖险理赔清单
        String classCode = "";
        if(StringUtils.isNotEmpty(requestNyxPlantingClaimListDto.getRegistNo())){
            classCode = requestNyxPlantingClaimListDto.getRegistNo().substring(1,3);
        }else if(StringUtils.isNotEmpty(requestNyxPlantingClaimListDto.getPolicyNo())){
            classCode = requestNyxPlantingClaimListDto.getPolicyNo().substring(1,3);
        }else if(StringUtils.isNotEmpty(requestNyxPlantingClaimListDto.getCompensateNo())){
            classCode = requestNyxPlantingClaimListDto.getCompensateNo().substring(1,3);
        }
        /*Map<String,String> map = new HashMap<>();
        map.put("policyNo",requestNyxPlantingClaimListDto.getRegistNo());
        map.put("validDate",requestNyxPlantingClaimListDto.getValidDate());
        List<AcceptInsuranceDto> acceptInsuranceDtoList = plantingExcelApi.queryInsureListInfo(map);*/
        int j;
        if("31".equals(classCode) || "3224".equals(requestNyxPlantingClaimListDto.getPolicyNo().substring(1,5)) || "3237".equals(requestNyxPlantingClaimListDto.getPolicyNo().substring(1,5))) {
            nyxPlantingClaimListDtoList = nyxPlantingClaimListApi.queryNyxPlantingClaimListByConditions(requestNyxPlantingClaimListDto);
            if (nyxPlantingClaimListDtoList.size() < 1 || nyxPlantingClaimListDtoList == null) {
                throw new BusinessException("无种植险理赔清单数据信息");
            }
            //封装支付清单
            NyxPlantingClaimListDto nyxPlantingClaimListDto;

            for(int i=0;i<nyxPlantingClaimListDtoList.size();i++){
                if (i==0){
                    sumPaid = new BigDecimal(nyxPlantingClaimListDtoList.get(0).getSettleAmount());
                    nyxPlantingClaimListDto = nyxPlantingClaimListDtoList.get(i);
                    nyxClaimPayListDto = new NyxClaimPayListDto();
                    nyxClaimPayListDto.setSerialNo(i+1+"");
                    nyxClaimPayListDto.setPolicyNo(nyxPlantingClaimListDto.getPolicyNo());
                    nyxClaimPayListDto.setRegistNo(nyxPlantingClaimListDto.getRegistNo());
                    nyxClaimPayListDto.setClaimNo(nyxPlantingClaimListDto.getClaimNo());
                    nyxClaimPayListDto.setCompensateNo(nyxPlantingClaimListDto.getCompensateNo());
                    nyxClaimPayListDto.setfCode(nyxPlantingClaimListDto.getfCode());
                    nyxClaimPayListDto.setfName(nyxPlantingClaimListDto.getfName());
                    nyxClaimPayListDto.setIdentifyType("01-身份证");
                    nyxClaimPayListDto.setIdentifyNumber(nyxPlantingClaimListDto.getfIdCard());
                    nyxClaimPayListDto.setBankAccount(nyxPlantingClaimListDto.getBankAccount());
                    nyxClaimPayListDto.setPhoneNumber(nyxPlantingClaimListDto.getPhoneNumber());
                    nyxClaimPayListDto.setSettleType(nyxPlantingClaimListDto.getPayType());
                    nyxClaimPayListDto.setSettleAmount(nyxPlantingClaimListDto.getSettleAmount());
                    nyxClaimPayListDtoList.add(nyxClaimPayListDto);
                }
                if (i>0&&nyxPlantingClaimListDtoList.get(i-1).getfCode().equals(nyxPlantingClaimListDtoList.get(i).getfCode())) {
                    sumPaid = new BigDecimal(nyxPlantingClaimListDtoList.get(i).getSettleAmount()).add(sumPaid);
                    nyxClaimPayListDto.setSettleAmount(sumPaid.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
                }
                if (i>0&&!nyxPlantingClaimListDtoList.get(i-1).getfCode().equals(nyxPlantingClaimListDtoList.get(i).getfCode())){
                    sumPaid = new BigDecimal("0");
                    sumPaid = new BigDecimal(nyxPlantingClaimListDtoList.get(i).getSettleAmount()).add(sumPaid);
                    nyxPlantingClaimListDto = nyxPlantingClaimListDtoList.get(i);
                    nyxClaimPayListDto = new NyxClaimPayListDto();
                    nyxClaimPayListDto.setSerialNo(i+1+"");
                    nyxClaimPayListDto.setPolicyNo(nyxPlantingClaimListDto.getPolicyNo());
                    nyxClaimPayListDto.setRegistNo(nyxPlantingClaimListDto.getRegistNo());
                    nyxClaimPayListDto.setClaimNo(nyxPlantingClaimListDto.getClaimNo());
                    nyxClaimPayListDto.setCompensateNo(nyxPlantingClaimListDto.getCompensateNo());
                    nyxClaimPayListDto.setfCode(nyxPlantingClaimListDto.getfCode());
                    nyxClaimPayListDto.setfName(nyxPlantingClaimListDto.getfName());
                    nyxClaimPayListDto.setIdentifyType("01-身份证");
                    nyxClaimPayListDto.setIdentifyNumber(nyxPlantingClaimListDto.getfIdCard());
                    nyxClaimPayListDto.setBankAccount(nyxPlantingClaimListDto.getBankAccount());
                    nyxClaimPayListDto.setPhoneNumber(nyxPlantingClaimListDto.getPhoneNumber());
                    nyxClaimPayListDto.setSettleType(nyxPlantingClaimListDto.getPayType());
                    nyxClaimPayListDto.setSettleAmount(nyxPlantingClaimListDto.getSettleAmount());

                    nyxClaimPayListDtoList.add(nyxClaimPayListDto);
                }


            }
        }else if("32".equals(classCode)&&"3224"!=requestNyxPlantingClaimListDto.getPolicyNo().substring(1,5) &&"3237"!=requestNyxPlantingClaimListDto.getPolicyNo().substring(1,5)) {
            RequestNyxBreedClaimListDto requestNyxBreedClaimListDto = new RequestNyxBreedClaimListDto();
            requestNyxBreedClaimListDto.setListNo(requestNyxPlantingClaimListDto.getListNo());
            requestNyxBreedClaimListDto.setPolicyNo(requestNyxPlantingClaimListDto.getPolicyNo());
            requestNyxBreedClaimListDto.setRegistNo(requestNyxPlantingClaimListDto.getRegistNo());
            requestNyxBreedClaimListDto.setfCode(requestNyxPlantingClaimListDto.getfCode());
            requestNyxBreedClaimListDto.setPageNo(requestNyxPlantingClaimListDto.getPageNo());
            requestNyxBreedClaimListDto.setPageSize(requestNyxPlantingClaimListDto.getPageSize());
            //requestNyxBreedClaimListDto.setValidDate(requestNyxPlantingClaimListDto.getValidDate());
            nyxBreedClaimListDtoList = nyxBreedClaimListApi.queryNyxBreedClaimListByConditions(requestNyxBreedClaimListDto);
            if (nyxBreedClaimListDtoList.size() < 1 || nyxBreedClaimListDtoList == null) {
                throw new BusinessException("无养殖险理赔清单数据");
            }
            //封装支付清单
            NyxBreedClaimListDto nyxBreedClaimListDto;

            for(int i=0;i<nyxBreedClaimListDtoList.size();i++){
                if (i==0) {
                    sumPaid = new BigDecimal(nyxBreedClaimListDtoList.get(0).getPayAmount());

                    nyxBreedClaimListDto = nyxBreedClaimListDtoList.get(i);
                    nyxClaimPayListDto = new NyxClaimPayListDto();
                    nyxClaimPayListDto.setSerialNo(i+1+"");
                    nyxClaimPayListDto.setPolicyNo(nyxBreedClaimListDto.getPolicyNo());
                    nyxClaimPayListDto.setRegistNo(nyxBreedClaimListDto.getRegistNo());
                    nyxClaimPayListDto.setClaimNo(nyxBreedClaimListDto.getClaimNo());
                    nyxClaimPayListDto.setCompensateNo(nyxBreedClaimListDto.getCompensateNo());
                    nyxClaimPayListDto.setfCode(nyxBreedClaimListDto.getfCode());
                    nyxClaimPayListDto.setfName(nyxBreedClaimListDto.getfName());
                    nyxClaimPayListDto.setIdentifyType("01-身份证");
                    nyxClaimPayListDto.setIdentifyNumber(nyxBreedClaimListDto.getfIdCard());
                    nyxClaimPayListDto.setBankAccount(nyxBreedClaimListDto.getBankAccount());
                    nyxClaimPayListDto.setPhoneNumber(nyxBreedClaimListDto.getPhoneNumber());
                    nyxClaimPayListDto.setSettleType(nyxBreedClaimListDto.getPayType());
                    nyxClaimPayListDto.setSettleAmount(nyxBreedClaimListDto.getPayAmount());
                    nyxClaimPayListDtoList.add(nyxClaimPayListDto);
                }
                if (i>0&&nyxBreedClaimListDtoList.get(i-1).getfCode().equals(nyxBreedClaimListDtoList.get(i).getfCode())) {
                    sumPaid = new BigDecimal(nyxBreedClaimListDtoList.get(i).getPayAmount()).add(sumPaid);
                    nyxClaimPayListDto.setSettleAmount(sumPaid.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
                }

                if (i>0&&!nyxBreedClaimListDtoList.get(i-1).getfCode().equals(nyxBreedClaimListDtoList.get(i).getfCode())) {
                    sumPaid = new BigDecimal("0");
                    new BigDecimal(nyxBreedClaimListDtoList.get(i).getPayAmount()).add(sumPaid);

                    nyxBreedClaimListDto = nyxBreedClaimListDtoList.get(i);
                    nyxClaimPayListDto = new NyxClaimPayListDto();
                    nyxClaimPayListDto.setSerialNo(i+1+"");
                    nyxClaimPayListDto.setPolicyNo(nyxBreedClaimListDto.getPolicyNo());
                    nyxClaimPayListDto.setRegistNo(nyxBreedClaimListDto.getRegistNo());
                    nyxClaimPayListDto.setClaimNo(nyxBreedClaimListDto.getClaimNo());
                    nyxClaimPayListDto.setCompensateNo(nyxBreedClaimListDto.getCompensateNo());
                    nyxClaimPayListDto.setfCode(nyxBreedClaimListDto.getfCode());
                    nyxClaimPayListDto.setfName(nyxBreedClaimListDto.getfName());
                    nyxClaimPayListDto.setIdentifyType("01-身份证");
                    nyxClaimPayListDto.setIdentifyNumber(nyxBreedClaimListDto.getfIdCard());
                    nyxClaimPayListDto.setBankAccount(nyxBreedClaimListDto.getBankAccount());
                    nyxClaimPayListDto.setPhoneNumber(nyxBreedClaimListDto.getPhoneNumber());
                    nyxClaimPayListDto.setSettleType(nyxBreedClaimListDto.getPayType());
                    nyxClaimPayListDto.setSettleAmount(nyxBreedClaimListDto.getPayAmount());
                    nyxClaimPayListDtoList.add(nyxClaimPayListDto);

                }
            }
        }else {
            throw new BusinessException("无理赔清单数据信息");
        }
        File file = null;
        for(int i=0;i<nyxClaimPayListDtoList.size();i++){
            if("Y".equals(nyxClaimPayListDtoList.get(i).getSettleType())){
                nyxClaimPayListDtoList.get(i).setSettleType("Y-预赔");
            }else{
                nyxClaimPayListDtoList.get(i).setSettleType("C-实赔");
            }
        }
        try{
            //Excel导出类型判断：.xls 97-2003 版本 Excel
            QuicklyExportExcel quicklyExportExcel = new QuicklyExportExcel();
            file = quicklyExportExcel.quicklyExport(exportExcelType,excelName,titleName,
                    nyxClaimPayListDtoList,1,20, nyxClaimPayListClass);
            // 上传文件到fileServer
            FileUtil fileUtil = new FileUtil();
            List<String> selectList=new ArrayList<>();
            //收款人类型下拉选
            List<PrpDcodeDto> prpDcodeDtoList = prpDcodeApi.queryCodeInfoByCodeType("ReceiverType", "");
            for (PrpDcodeDto prpDcodeDto : prpDcodeDtoList) {
                selectList.add(prpDcodeDto.getCodeCode()+"-"+prpDcodeDto.getCodeCName());
            }
            this.addExcelSelect(selectList,file,nyxClaimPayListDtoList.size(),7);
            //收款人证件类型下拉选
            selectList = new ArrayList<>();
            prpDcodeDtoList = prpDcodeApi.queryCodeInfoByCodeType("IdentifyType", "");
            for (PrpDcodeDto prpDcodeDto : prpDcodeDtoList) {
                selectList.add(prpDcodeDto.getCodeCode()+"-"+prpDcodeDto.getCodeCName());
            }
            this.addExcelSelect(selectList,file,nyxClaimPayListDtoList.size(),9);
            //银行账号属性下拉选
            selectList = new ArrayList<>();
            prpDcodeDtoList = prpDcodeApi.queryCodeInfoByCodeType("AccountType", "");
            for (PrpDcodeDto prpDcodeDto : prpDcodeDtoList) {
                selectList.add(prpDcodeDto.getCodeCode()+"-"+prpDcodeDto.getCodeCName());
            }
            this.addExcelSelect(selectList,file,nyxClaimPayListDtoList.size(),16);
            //银行账号类型下拉选
            selectList = new ArrayList<>();
            selectList.add("00-银行卡");
            selectList.add("01-存折");
            selectList.add("03-对公账户");
            this.addExcelSelect(selectList,file,nyxClaimPayListDtoList.size(),17);
            //赔付类型
            selectList = new ArrayList<>();
            selectList.add("C-实赔");
            selectList.add("Y-预赔");
            this.addExcelSelect(selectList,file,nyxClaimPayListDtoList.size(),19);
            String userCode = SinoRequestContext.getCurrentContext().getUserCode();
            String systemId = "agri/tempfile";//系统
            String bussType = "agriclaim_paymentmanage";//项目名_模块名
            shortLinkId = fileUtil.uploadFile(fileServiceUrl,file,userCode,systemId,bussType);
        }finally {
            // 删除本地的临时文件
            if (file != null) {
                file.delete();
            }
        }
        return shortLinkId;
    }

    /**
     * （支付录入整单支付保存）
     * @author: 王志文
     * @date: 2017/12/26 15:03
     * @return 操作成功信息
     * @throws Exception 异常信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, String> savePaysOut(PaySaveDto paySaveDto) throws Exception {
        String businessNo = "";
        String thirdPayFlag = paySaveDto.getThirdPayFlag();
        if(paySaveDto.getPaymentMessageDtoList()!=null && paySaveDto.getPaymentMessageDtoList().size()>0) {
            paySaveDto.setPaymentType(paySaveDto.getPaymentMessageDtoList().get(0).getPaymentType());
        }
        Map<String, String> map = new HashMap<>();
        if (StringUtils.isEmpty(thirdPayFlag)) {
            throw new BusinessException("操作类型传入错误");
        }else {
            if ("0".equals(paySaveDto.getThirdPayFlag()) && !"1".equals(paySaveDto.getBillFlag())) {
                //数据暂存     页面暂存按钮
                //整单支付暂存和提交共用方法
                prplPayService.saveEntirePay(paySaveDto);
                map.put("code", "暂存成功");
                return map;
            } else if ("1".equals(paySaveDto.getThirdPayFlag())) {
                //清单提交
                if ("1".equals(paySaveDto.getBillFlag())){
                    List<NyxClaimPayListDto> nyxClaimPayListDtoList =
                            nyxClaimPayListApi.queryAllNyxClaimPayListDtoByListNo(paySaveDto.getBillNo());
                    paySaveDto.setNyxClaimPayListDtoList(nyxClaimPayListDtoList);
                    businessNo = savePayMainBill(paySaveDto);
                }else {
                    businessNo = prplPayService.saveEntirePay(paySaveDto);
                }
            }else{
                map.put("message", "数据异常");
                map.put("businessNo",businessNo);
                return map;
            }
        }
        String returnMessage = "";
        try{
            String userCode = SinoRequestContext.getCurrentContext().getUser().getUserCode();
            String registNo = paySaveDto.getPaymentMessageDtoList().get(0).getRegistNo();
            PrpLRegist prpLRegist = prpLRegistDao.findByRegistNo(registNo);
            if(prpLRegist==null){
                throw new BusinessException("无当前案件工作流信息！");
            }
            RequestSubmitUndwrtDto requestSubmitUndwrtDto = new RequestSubmitUndwrtDto();
            requestSubmitUndwrtDto.setLflowID("00");
            requestSubmitUndwrtDto.setLlogNo("00");
            requestSubmitUndwrtDto.setModelType("54");
            requestSubmitUndwrtDto.setCertiType("V");
            requestSubmitUndwrtDto.setBusinessNo(businessNo);
            List<PrpLPayBill> prpLPayBillList = prpLPayBillDao.queryAllByBillNo(businessNo);
            requestSubmitUndwrtDto.setRiskCode(prpLRegist.getRiskCode());
            requestSubmitUndwrtDto.setClassCode(prpLRegist.getClassCode());
            requestSubmitUndwrtDto.setComCode(paySaveDto.getComCode());
            requestSubmitUndwrtDto.setHandlerCode(userCode);
            requestSubmitUndwrtDto.setMakecom(prpLRegist.getMakeCom());
            requestSubmitUndwrtDto.setUserCode(userCode);
            requestSubmitUndwrtDto.setHandler1Code(userCode);
            String xmlData;
            XmlUtil xmlUtil = new XmlUtil();
            PacketDto<RequestSubmitUndwrtDto> packetDto = new PacketDto<>();
            packetDto.setBody(requestSubmitUndwrtDto);
            xmlData = xmlUtil.packetDtoToXml_bodyDto(packetDto);
            System.err.println(xmlData);
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            jaxWsProxyFactoryBean.setServiceClass(NewAgriPrpallUndwrtService.class);
            jaxWsProxyFactoryBean.setAddress(webAgriPrpallServiceUrl+"/webAgriPrpallService/services/NewAgriPrpallUndwrtService?wsdl".trim());
            NewAgriPrpallUndwrtService newAgriPrpallUndwrtService = (NewAgriPrpallUndwrtService)jaxWsProxyFactoryBean.create();
            String getXml = newAgriPrpallUndwrtService.claimPaySubmit(xmlData);
            System.out.println(getXml);
            Document document;
            try {
                document = DocumentHelper.parseText(getXml);
                Element requestData =document.getRootElement();
                Element startData = requestData.element("head");
                String LflowID = startData.element("returnStatusCode").getTextTrim();
                if("9999".equals(LflowID)){
                    returnMessage = startData.element("returnMessage").getTextTrim();
                    throw new BusinessException("提交失败!"+returnMessage);
                }
            } catch (DocumentException e) {
                throw new DocumentException(e.getMessage());
            }
        }catch (Exception e){
            //清单支付失败不进入暂存，需要重新操作
            if ("1".equals(paySaveDto.getBillFlag())){
                throw new BusinessException("清单支付提交失败!"+returnMessage);
            }else {
                map.put("message", "整单支付提交失败!"+returnMessage);
                map.put("businessNo",businessNo);
                return map;
            }
        }
        if ("1".equals(thirdPayFlag)) {
            map = prplPayService.savePayCommit(paySaveDto,businessNo);
        }
        return map;
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String,String> savePayCommit(PaySaveDto paySaveDto,String businessNo)throws Exception{
        Map<String,String> map = new HashMap<>();
        //支付主表更改第三方支付表识  清单支付信息：businessNo为清单号，整单支付信息：businessNo为支付编号
        List<PrpLPayBill> prpLPayBillList = prpLPayBillDao.queryAllByBillNo(paySaveDto.getNyxClaimPayListDtoList().get(0).getListNo());
        if(prpLPayBillList.size()>0) {
            for (PrpLPayBill prpLPayBill : prpLPayBillList) {
                String paymentNo = prpLPayBill.getPaymentNo();
//                PrpLPayMainDto prpLPayMainDto = prpLPayMainService.queryByPK(paymentNo);
                paySaveDto.getPrpLPayMainDto().setThirdPayFlag("1");
//                prpLPayMainDto.setThirdPayFlag("1");
                prpLPayMainDao.save(this.convert(paySaveDto.getPrpLPayMainDto(),PrpLPayMain.class));
                //支付处理意见表更改暂存标志
                PrpLPayExtKey prpLPayExtKey = new PrpLPayExtKey();
                prpLPayExtKey.setPaymentNo(prpLPayBill.getBillNo());
                int count = prpLPayExtDao.getCountByPaymentNo(prpLPayBill.getBillNo());
                prpLPayExtKey.setSerialNo(count);
                PrpLPayExt prpLPayExt = prpLPayExtDao.findOne(prpLPayExtKey);
                //判断seriaNo最大的一条是否为暂存状态 是：覆盖、否：新建
                if (prpLPayExt != null && "apay".equals(prpLPayExt.getNodeType()) && "N".equals(prpLPayExt.getFlag())) {
                    prpLPayExt.setFlag("Y");
                    prpLPayExt.setNotionCode("2");
                    prpLPayExt.setNotionName("提交审核");
                    prpLPayExtDao.save(prpLPayExt);
                } else {
                    prpLPayExt = new PrpLPayExt();
                    PayPurposeDto payPurposeDto;
                    if (paySaveDto.getPayPurposeDtoList() != null && paySaveDto.getPayPurposeDtoList().size() > 0) {
                        payPurposeDto = paySaveDto.getPayPurposeDtoList().get(0);
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                        Date dt = new Date();
                        String time = sdf.format(dt);
                        prpLPayExt.setPaymentNo(businessNo);
                        prpLPayExt.setOperatorCode(paySaveDto.getUserCode());
                        prpLPayExt.setInputDate(new DateTime(time, DateTime.YEAR_TO_SECOND));
                        prpLPayExt.setSerialNo(count + 1);
                        prpLPayExt.setContext(paySaveDto.getNewContext());
                        prpLPayExt.setInputDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_SECOND));
                        prpLPayExt.setComCode(paySaveDto.getComCode());
                        prpLPayExt.setNodeType("apay");
                        prpLPayExt.setNodeName("支付录入");
                        prpLPayExt.setNotionCode("2");
                        prpLPayExt.setNotionName("提交审核");
                        prpLPayExt.setFlag("Y");
                        prpLPayExtDao.save(prpLPayExt);
                    }
                }
            }
        }
        map.put("code", "提交成功");
        return map;
    }

    /**
     * （整单支付的封装方法）
     * @author: 王志文
     * @date: 2017/12/28 16:42
     * @param paySaveDto 页面传入数据
     * @return 清单号
     */
    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public String saveEntirePay(PaySaveDto paySaveDto){
        String paymentNo;
        String billNo = "";
        String tableName = "prplpaymain";
        String comCode = paySaveDto.getComCode();
        List<PrpLClaim> prpLClaimList = prpLClaimDao.queryAllByRegistNo(paySaveDto.getPaymentMessageDtoList().get(0).getRegistNo());
        String riskCode = prpLClaimList.get(0).getClassCode() + "00";
        List<NyxClaimPayListDto> nyxClaimPayListDtoList1 = new ArrayList<>();
        List<NyxClaimPayListDto> nyxClaimPayListDtoList = new ArrayList<>();
        NyxClaimPayListDto nyxClaimPayListDto;
        int year = new DateTime(DateTime.current().toString()).getYear();
        ////判断是否由暂存进入 暂存之后会生成支付编号 modify by wxy
        if (StringUtils.isNotEmpty(paySaveDto.getPrpLPayMainDto().getPaymentNo())){
            paymentNo = paySaveDto.getPrpLPayMainDto().getPaymentNo();
            nyxClaimPayListDtoList1 = nyxClaimPayListApi.queryAllByPaymentNo(paymentNo);
        }else {
            paymentNo = paymentGetNoUtilService.getNo(tableName, riskCode, comCode, year);
            for (PaymentMessageDto paymentMessageDto : paySaveDto.getPaymentMessageDtoList()) {
                nyxClaimPayListDto = new NyxClaimPayListDto();
                tableName = "PRPLPAYBILL";
                billNo = paymentGetNoUtilService.getNo(tableName, riskCode, comCode, year);
                nyxClaimPayListDto.setListNo(billNo);
                nyxClaimPayListDtoList1.add(nyxClaimPayListDto);
            }

        }
        if (paySaveDto.getPaymentMessageDtoList()!= null && paySaveDto.getPaymentMessageDtoList().size()>0) {
            Integer count = 1;
            //按照赔付信息封装清单对象
            for (PaymentMessageDto paymentMessageDto : paySaveDto.getPaymentMessageDtoList()) {
                //判断是否由暂存进入 暂存之后会生成支付编号 modify by wxy
                /*if (StringUtils.isNotEmpty(paySaveDto.getPrpLPayMainDto().getPaymentNo())) {//paymentMessageDto.getCompensateNo()
                    List<PrplPay> prplPayList = prplPayDao.queryAllByCompensateNo(paymentMessageDto.getCompensateNo());
                    if (prplPayList.size()>0){
                        List<PrpLPayBill> prpLPayBillList = prpLPayBillDao.queryAllByPaymentNo(paymentNo);
                        if (prpLPayBillList.size()>0){
                            billNo = prpLPayBillList.get(0).getBillNo();
                        }
                    }else {
                        //获取清单号
                        billNo = paymentGetNoUtilService.getNo(tableName, riskCode,comCode, year);
                    }
                } else {
                }*/
                //获取清单号
                PrpLPayMainDto prpLPayMainDto = paySaveDto.getPrpLPayMainDto();
                nyxClaimPayListDto = new NyxClaimPayListDto();
                nyxClaimPayListDto.setPaymentNo(paymentNo);
                nyxClaimPayListDto.setListNo(nyxClaimPayListDtoList1.get(count-1).getListNo());
                nyxClaimPayListDto.setSerialNo(count.toString());
                count++;
                nyxClaimPayListDto.setRegistNo(paymentMessageDto.getRegistNo());
                nyxClaimPayListDto.setPolicyNo(paymentMessageDto.getPolicyNo());
                nyxClaimPayListDto.setSettleAmount(Double.parseDouble(paymentMessageDto.getPayAmount()));
                nyxClaimPayListDto.setSettleType(paymentMessageDto.getPaymentType());
                nyxClaimPayListDto.setReceiverName(prpLPayMainDto.getReceiverFullName());
                // nyxClaimPayListDto.setReceiverType(prpLPayMainDto.getReceiverType());

                nyxClaimPayListDto.setReceiverType(prpLPayMainDto.getReceiverTypeOther());
                nyxClaimPayListDto.setfName(prpLPayMainDto.getReceiverFullName());
                nyxClaimPayListDto.setIdentifyNumber(prpLPayMainDto.getCertifNo());
                nyxClaimPayListDto.setIdentifyType(prpLPayMainDto.getCertifType());
                nyxClaimPayListDto.setProvinceName(prpLPayMainDto.getProvinceCode());
                nyxClaimPayListDto.setCityName(prpLPayMainDto.getCityCode());
                nyxClaimPayListDto.setCompensateNo(paymentMessageDto.getCompensateNo());
                nyxClaimPayListDto.setAccountFlag(prpLPayMainDto.getAccountFlag());
                nyxClaimPayListDto.setAccountType(prpLPayMainDto.getAccountType());
                nyxClaimPayListDto.setBankAccount(prpLPayMainDto.getBankAccount());
                nyxClaimPayListDto.setBankType(prpLPayMainDto.getBankType());
                nyxClaimPayListDto.setBankName(prpLPayMainDto.getBank());
                //nyxClaimPayListDto.setReceiverName(prpLPayMainDto.getReceiverFullName());
                nyxClaimPayListDto.setPhoneNumber(prpLPayMainDto.getMobilePhone());

//                PrpLCompensateKey prpLCompensateKey = new PrpLCompensateKey();
//                prpLCompensateKey.setCompensateNo(paymentMessageDto.getCompensateNo());
                List<PrpLClaim> prpLClaimList1 = prpLClaimDao.queryAllByRegistNo(paymentMessageDto.getRegistNo());
//                PrpLCompensate prpLCompensate = prpLCompensateDao.findOne(prpLCompensateKey);
                if (prpLClaimList1 != null) {
                    nyxClaimPayListDto.setClaimNo(prpLClaimList1.get(0).getClaimNo());
                }
                nyxClaimPayListApi.save(nyxClaimPayListDto);
                nyxClaimPayListDtoList.add(nyxClaimPayListDto);
            }
        }

        paySaveDto.setNyxClaimPayListDtoList(nyxClaimPayListDtoList);
        return savePayMainBill(paySaveDto);
    }


    /**
     * （支付录入中保存支付处理意见表）
     * @author: 王志文
     * @date: 2017/12/15 17:43
     * @param paySaveDto 页面传入数据
     */
    private void savePrplpayExt(PaySaveDto paySaveDto) {
        PayPurposeDto payPurposeDto = null;
        if (paySaveDto.getPayPurposeDtoList() != null && paySaveDto.getPayPurposeDtoList().size()>0){
            payPurposeDto = paySaveDto.getPayPurposeDtoList().get(0);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date dt = new Date();
        String time = sdf.format(dt);
        if (payPurposeDto != null ) {
            PrpLPayExtDto prpLpayExtDto = new PrpLPayExtDto();
            //清单录入存入清单号 整单录入存入支付编号
            if ("1".equals(paySaveDto.getBillFlag())){//StringUtils.isNotEmpty(payPurposeDto.getBillNo())
                prpLpayExtDto.setPaymentNo(payPurposeDto.getBillNo());
            }else {
                prpLpayExtDto.setPaymentNo(payPurposeDto.getPaymentNo());
            }
            prpLpayExtDto.setOperatorCode(paySaveDto.getUserCode());
            prpLpayExtDto.setInputDate(new DateTime(time, DateTime.YEAR_TO_SECOND));
            int count = prpLPayExtDao.getCountByPaymentNo(payPurposeDto.getPaymentNo())+1;
            prpLpayExtDto.setSerialNo(count);
            prpLpayExtDto.setContext(paySaveDto.getNewContext());
            prpLpayExtDto.setInputDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND));
            prpLpayExtDto.setComCode(paySaveDto.getComCode());
            prpLpayExtDto.setNodeType("apay");
            prpLpayExtDto.setNodeName("支付录入");
            prpLpayExtDto.setNotionCode("1");
            prpLpayExtDto.setNotionName("暂存任务");
            prpLpayExtDto.setFlag("N");
            prpLPayExtDao.save(this.convert(prpLpayExtDto,PrpLPayExt.class));
        }
    }

    /**
     * （支付录入清单支付提交）
     * @author: 王志文
     * @date: 2017/12/20 9:07
     * @param paySaveDto 页面传入数据
     * @return 支付编号
     */
    @Transactional(rollbackFor = Exception.class)
    String savePayMainBill(PaySaveDto paySaveDto){
        //整单支付同一清单
        String payType = paySaveDto.getPayType();//支付类型
        String mergerFlag  = paySaveDto.getMergerFlag();//合并标志
        PrpLPayMainDto prpLpaymainDto = paySaveDto.getPrpLPayMainDto();
        String purpose = "";
        if(prpLpaymainDto!=null){
            if(StringUtils.isNotEmpty(paySaveDto.getPrpLPayMainDto().getPayPurpose())){
                purpose = paySaveDto.getPrpLPayMainDto().getPayPurpose();
            }else {
                purpose = "国元理赔";
            }
        }else {
            purpose = "国元理赔";
        }
        String paymentNo = "";
        String billNo = "";
        //添加业务号：清单支付存入清单号、整单支付存入支付编号
        String businessNo = "";
        boolean isSave = false;
        List<NyxClaimPayListDto> nyxClaimPayListDtoList = paySaveDto.getNyxClaimPayListDtoList();
        if (nyxClaimPayListDtoList.size()>0) {
            int count = 1;
            String tableName = "prplpaymain";
            List<PrpLClaim> prpLClaimList = prpLClaimDao.queryAllByRegistNo(nyxClaimPayListDtoList.get(0).getRegistNo());
            String riskCode = prpLClaimList.get(0).getClassCode() + "00";
            String comCode = paySaveDto.getComCode();
            int year = new DateTime(DateTime.current().toString()).getYear();
            if(StringUtils.isEmpty(nyxClaimPayListDtoList.get(0).getListNo())) {
                billNo = paymentGetNoUtilService.getNo(tableName, riskCode, comCode, year);
            }else{
                billNo = nyxClaimPayListDtoList.get(0).getListNo();
            }
            for (NyxClaimPayListDto nyxClaimPayListDto : nyxClaimPayListDtoList) {
                //判断是否审批退回案件 需作废当前支付编号 新生成支付编号
                paymentNo = nyxClaimPayListDto.getPaymentNo();
                PrpLPayMainKey prpLPayMainKey = new PrpLPayMainKey();
                prpLPayMainKey.setPaymentNo(paymentNo);
                PrpLPayMain prpLPayMain = prpLPayMainDao.findOne(prpLPayMainKey);
                if (prpLPayMain != null && "4".equals(prpLPayMain.getThirdPayFlag())){
                    //重新获取支付编号
                    paymentNo = paymentGetNoUtilService.getNo(tableName, riskCode, comCode, year);
                    prpLpaymainDto.setPaymentNo(paymentNo);
                    //重新获取清单号
                    tableName = "PRPLPAYBILL";
                    nyxClaimPayListDto.setPaymentNo(paymentNo);
                    nyxClaimPayListDto.setListNo(billNo);
                }else {
                    if(prpLpaymainDto==null){
                        prpLpaymainDto = new PrpLPayMainDto();
                    }
                    prpLpaymainDto.setPaymentNo(paymentNo);
                    billNo = nyxClaimPayListDto.getListNo();
                }
                prpLpaymainDto.setPayType(payType);
                prpLpaymainDto.setPaymentType(paySaveDto.getPaymentType());
                prpLpaymainDto.setReceiverTypeOther(nyxClaimPayListDto.getReceiverType());
                prpLpaymainDto.setReceiverTypeOtherName(nyxClaimPayListDto.getReceiverName());
                prpLpaymainDto.setReceiverFullName(nyxClaimPayListDto.getReceiverName());
                prpLpaymainDto.setReceiverFullCode(nyxClaimPayListDto.getfCode());
                prpLpaymainDto.setCertifNo(nyxClaimPayListDto.getIdentifyNumber());
                prpLpaymainDto.setCertifType(nyxClaimPayListDto.getIdentifyType());
                prpLpaymainDto.setProvinceCode(nyxClaimPayListDto.getProvinceName());
                prpLpaymainDto.setCityCode(nyxClaimPayListDto.getCityName());
                prpLpaymainDto.setAccountType(nyxClaimPayListDto.getAccountType());
                prpLpaymainDto.setBankType(nyxClaimPayListDto.getBankType());
                prpLpaymainDto.setBank(nyxClaimPayListDto.getBankName());
                prpLpaymainDto.setBankAccount(nyxClaimPayListDto.getBankAccount());
                prpLpaymainDto.setBankAccount(nyxClaimPayListDto.getBankAccount());
                prpLpaymainDto.setMobilePhone(nyxClaimPayListDto.getPhoneNumber());
                prpLpaymainDto.setPayAmount(nyxClaimPayListDto.getSettleAmount());
                prpLpaymainDto.setNode(paySaveDto.getNode());
                prpLpaymainDto.setThirdPayFlag("0");//保存任务状态
                prpLpaymainDto.setMergerFlag(mergerFlag);//合并下发标志
                prpLpaymainDto.setComCode(paySaveDto.getComCode());//一般是承保机构
                prpLpaymainDto.setOperatorCode(paySaveDto.getUserCode());
                prpLpaymainDto.setInputDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND));
                if(paySaveDto.getPrpLPayMainDto()!=null){
                    prpLpaymainDto.setPayWay(paySaveDto.getPrpLPayMainDto().getPayWay());//支付方式
                    prpLpaymainDto.setPayType(paySaveDto.getPrpLPayMainDto().getPayType());//支付类型
                    prpLpaymainDto.setUrgentType(paySaveDto.getPrpLPayMainDto().getUrgentType());//紧急程度
                }
                prpLpaymainDto.setPayReason(paySaveDto.getPayReason());//支付原因
                prpLpaymainDto.setAccountFlag(nyxClaimPayListDto.getAccountFlag());//账户类型
                prpLpaymainDto.setRouteNum(paySaveDto.getRouteNum());//支付行号
                prpLpaymainDto.setBillFlag(paySaveDto.getBillFlag());
                prpLpaymainDto.setPayPurpose(purpose);
                paySaveDto.setPrpLPayMainDto(prpLpaymainDto);
                prpLPayMainDao.saveAndFlush(this.convert(prpLpaymainDto,PrpLPayMain.class));

                List<PrplPay> prplPays =  prplPayDao.findAllBySerialNo(paymentNo);
                prplPayDao.delete(prplPays);
                List<PrpLPayBill> prpLPayBills = prpLPayBillDao.findAllByPaymentNo(paymentNo);
                prpLPayBillDao.delete(prpLPayBills);
                prplPayService.savePayBill(nyxClaimPayListDto,count, billNo,paySaveDto.getBillFlag());
                savePay(paySaveDto,nyxClaimPayListDto,paymentNo,count);
                isSave = true;
                count ++;
            }
            if("0".equals(paySaveDto.getBillFlag())){
                businessNo = paymentNo;
            }else{
                businessNo = billNo;
            }

            List<PrpLPayExt> prpLPayExts = prpLPayExtDao.findAllByPaymentNo(businessNo);
            prpLPayExtDao.delete(prpLPayExts);
        }
        if(isSave){
            if("0".equals(paySaveDto.getBillFlag())){
                paySaveDto.getPayPurposeDtoList().get(0).setPaymentNo(paymentNo);
            }else{
                paySaveDto.getPayPurposeDtoList().get(0).setBillNo(billNo);
            }
            //prpLPayExtDao.deleteAllByPaymentNo(businessNo);
            savePrplpayExt(paySaveDto);
        }
        return businessNo;
    }

    /**
     * （支付录入保存清单表）
     * @author: 王志文
     * @date: 2017/12/20 9:08
     * @param nyxClaimPayListDto 清单数据
     * @param count 序号
     * @param billNo 清单号
     */
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void savePayBill(NyxClaimPayListDto nyxClaimPayListDto,int count,String billNo,String billFlag) {
        PrpLPayBillDto prpLPayBillDto;
        prpLPayBillDto = new PrpLPayBillDto();
        prpLPayBillDto.setBillNo(billNo);
        prpLPayBillDto.setPaymentNo(nyxClaimPayListDto.getPaymentNo());
        prpLPayBillDto.setRegistNo(nyxClaimPayListDto.getRegistNo());
        prpLPayBillDto.setCompensateNo(nyxClaimPayListDto.getCompensateNo());
        prpLPayBillDto.setSerialNo(count);
        prpLPayBillDto.setPayAmount(nyxClaimPayListDto.getSettleAmount());
        if("0".equals(billFlag)){
            prpLPayBillDto.setBusinessNo(nyxClaimPayListDto.getPaymentNo());
        }else{
            prpLPayBillDto.setBusinessNo(billNo);
        }
        prpLPayBillDao.saveAndFlush(this.convert(prpLPayBillDto,PrpLPayBill.class));
    }

    /**
     * （保存支付清单）
     * @author: 王志文
     * @date: 2017/12/20 9:11
     * @param paySaveDto 页面传入数据
     * @param nyxClaimPayListDto 清单列表
     * @param paymentNo 支付编号
     */
    private void savePay(PaySaveDto paySaveDto,NyxClaimPayListDto nyxClaimPayListDto,String paymentNo,int count){
        String payType = paySaveDto.getPayType();//支付类型
		String node = paySaveDto.getNode();
        PrpLRegistKey prpLRegistKey = new PrpLRegistKey();
        prpLRegistKey.setRegistNo(nyxClaimPayListDto.getRegistNo());
        PrplPayDto prplpayDto = new PrplPayDto();
        prplpayDto.setClaimNo(nyxClaimPayListDto.getClaimNo());
        prplpayDto.setSerialNo(paymentNo);
        if ("1".equals(paySaveDto.getMergerFlag())){
            prplpayDto.setSerialNo2(count+"");
        }else{
            prplpayDto.setSerialNo2("1");
        }
        prplpayDto.setCompensateNo(nyxClaimPayListDto.getCompensateNo());
        prplpayDto.setClassCode(nyxClaimPayListDto.getPolicyNo().substring(1, 3));
        prplpayDto.setRiskCode(nyxClaimPayListDto.getPolicyNo().substring(1,5));
        prplpayDto.setRegistNo(nyxClaimPayListDto.getRegistNo());
        prplpayDto.setPolicyNo(nyxClaimPayListDto.getPolicyNo());
        prplpayDto.setPayType(payType);
        prplpayDto.setReceiverType(nyxClaimPayListDto.getReceiverType());
        double payAmount = nyxClaimPayListDto.getSettleAmount();
        prplpayDto.setPayAmount(payAmount);
        prplpayDto.setBankType(nyxClaimPayListDto.getBankType());
        prplpayDto.setBank(nyxClaimPayListDto.getBankName());
        prplpayDto.setAccountType(nyxClaimPayListDto.getAccountType());
        prplpayDto.setReceiverFullName(nyxClaimPayListDto.getfName());
        prplpayDto.setCertiftype("01");//被保险人
        if(paySaveDto.getPrpLPayMainDto()!=null){
            prplpayDto.setAddress(paySaveDto.getPrpLPayMainDto().getAddress());
        }
        prplpayDto.setCertifNo(nyxClaimPayListDto.getIdentifyNumber());
        prplpayDto.setMobilePhone(nyxClaimPayListDto.getPhoneNumber());
        prplpayDto.setOperatorCode(paySaveDto.getUserCode());
        prplpayDto.setOperatorComcode(paySaveDto.getComCode());
        prplpayDto.setInputDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND));
        prplpayDto.setPaymentType(paySaveDto.getPaymentType());
        prplpayDto.setBankAccount(nyxClaimPayListDto.getBankAccount());
        prplpayDto.setNode(node);
        if ("0".equals(paySaveDto.getThirdPayFlag())){
            prplpayDto.setVFlag("");//未处理
        }else if ("1".equals(paySaveDto.getThirdPayFlag())){
            prplpayDto.setVFlag("2");//待审核
        }else if ("2".equals(paySaveDto.getThirdPayFlag())){
            prplpayDto.setVFlag("3");//待审核
        }
        else if ("9".equals(paySaveDto.getThirdPayFlag())){
            prplpayDto.setVFlag("8");//审核通过
        }
        prplpayDto.setComCode(paySaveDto.getComCode());
        prplPayDao.save(this.convert(prplpayDto,PrplPay.class));
    }

    /**
     * （将该支付编号的信息作废）
     * @author: 王志文
     * @date: 2017/12/27 11:58
     * @param paymentNo 支付编号
     * @return 修改结果信息
     * @throws Exception 异常信息
     */
    @Override
    public Map<String, String> updateCancelFlagByPaymentNo(String paymentNo) throws Exception {
        prpLPayMainDao.updateCancelFlagByPaymenNo(paymentNo);
        Map<String,String> map = new HashMap<>();
        map.put("message","操作成功");
        return map;
    }

    /**
     * （整单支付初始化查询）
     * @author: 王志文
     * @date: 2017/12/28 16:47
     * @param paymentNo 支付编号
     * @return 页面组装信息
     * @throws Exception 异常信息
     */
    @Override
    public PaySaveDto queryInitEntirePay(String paymentNo) throws Exception {
        PaySaveDto paySaveDto = new PaySaveDto();
        PayPurposeDto payPurposeDto = new PayPurposeDto();
        PrpLPayMainDto prpLPayMainDto = new PrpLPayMainDto();
        PaymentMessageDto paymentMessageDto ;
        List<PaymentMessageDto> paymentMessageDtoList = new ArrayList<>();
        List<PayPurposeDto> payPurposeDtoList = new ArrayList<>();
        PrpLPayMainKey prpLPayMainKey = new PrpLPayMainKey();
        prpLPayMainKey.setPaymentNo(paymentNo);
        PrpLPayMain prpLPayMain = prpLPayMainDao.findOne(prpLPayMainKey);
        if (prpLPayMain != null){
            prpLPayMainDto = this.convert(prpLPayMain,PrpLPayMainDto.class);
            prpLPayMainDto.setPaymentNo(paymentNo);
        }
        paySaveDto.setPrpLPayMainDto(prpLPayMainDto);

        List<PrplPay> prplPayList = prplPayDao.queryAllBySerialNo(paymentNo);
        if (prplPayList.size()>0){
            for (PrplPay prplpay:prplPayList) {
                /*QueryPrpJplanFeeDto queryPrpJplanFeeDto = new QueryPrpJplanFeeDto();
                queryPrpJplanFeeDto.setCertiNo(prplpay.getCompensateNo());
                List<PrpJplanFeeDto> prpJplanFeeDtoList = prplPayService.queryPrpJPlanFeeDto(queryPrpJplanFeeDto);
                if (prpJplanFeeDtoList.size()>0){
                    for (PrpJplanFeeDto prpJplanFeeDto:prpJplanFeeDtoList) {
                        paymentMessageDto = new PaymentMessageDto();
                        paymentMessageDto.setRegistNo(prpJplanFeeDto.getRegistNo());
                        paymentMessageDto.setCompensateNo(prpJplanFeeDto.getCertiNo());
                        paymentMessageDto.setInsuredName(prpJplanFeeDto.getInsuredName());
                        paymentMessageDto.setPayAmount(prpJplanFeeDto.getPaidPayAmount());
                        paymentMessageDto.setHavePayAmount(prpJplanFeeDto.getPayAmount());
                        paymentMessageDto.setPaymentType(prpJplanFeeDto.getPayRefReason());
                        paymentMessageDto.setPayTotalAmount(prpJplanFeeDto.getPlanFee());
                        paymentMessageDto.setPolicyNo(prpJplanFeeDto.getPolicyNo());
                        paymentMessageDtoList.add(paymentMessageDto);
                    }
                }*/
                paymentMessageDto = new PaymentMessageDto();
                paymentMessageDto.setPaymentNo(prplpay.getSerialNo());
                paymentMessageDto.setSerialNo2(prplpay.getSerialNo2());
                paymentMessageDto.setRegistNo(prplpay.getRegistNo());
                paymentMessageDto.setCompensateNo(prplpay.getCompensateNo());
                paymentMessageDto.setInsuredName(prplpay.getReceiverFullName());
                paymentMessageDto.setPayAmount(prplpay.getPayAmount()+"");
                paymentMessageDto.setHavePayAmount("0.00");
                paymentMessageDto.setPaymentType(prplpay.getPaymentType());
                paymentMessageDto.setPayTotalAmount(prplpay.getPayAmount()+"");
                paymentMessageDto.setPolicyNo(prplpay.getPolicyNo());
                paymentMessageDtoList.add(paymentMessageDto);
            }
        }
        paySaveDto.setPaymentMessageDtoList(paymentMessageDtoList);

        List<PrpLPayExt> prpLPayExtList = prpLPayExtDao.queryAllByPaymentNo(paymentNo);
        if (prpLPayExtList==null || prpLPayExtList.size()<=0){
            String billNo = prpLPayBillDao.queryAllByPaymentNo(paymentNo).get(0).getBillNo();
            prpLPayExtList = prpLPayExtDao.queryAllByPaymentNo(billNo);
        }
        if(prpLPayExtList!=null && prpLPayExtList.size()>0) {
            for (PrpLPayExt prpLPayExt : prpLPayExtList) {
                payPurposeDto.setNodeName(prpLPayExt.getNodeName());
                payPurposeDto.setOccupyTime(getDatePoor(prpLPayExt.getInputDate(), new DateTime()));
                payPurposeDto.setOperatorName(prpLPayExt.getOperatorCode());
                payPurposeDto.setComName(prpLPayExt.getComCode());
                payPurposeDto.setNotionName(prpLPayExt.getNotionName());
                payPurposeDto.setOutputTime(simpleDateFormat.format(prpLPayExt.getInputDate()));
                payPurposeDto.setContext(prpLPayExt.getContext());
                payPurposeDtoList.add(payPurposeDto);
            }
        }
        paySaveDto.setPayPurposeDtoList(payPurposeDtoList);
        return paySaveDto;
    }

    /**
     * （获取两个日期差值时间）
     * @author: 王志文
     * @date: 2017/12/28 18:44
     * @param endDate 结束日期
     * @param nowDate 现在日期
     * @return 差值时间
     */
    private String getDatePoor(Date endDate,Date nowDate){
        //精确到秒
        long ns = 1000 * 24 * 60 * 60 * 60;
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = nowDate.getTime() - endDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        long sec = diff % nd % nh % nm / ns;
        return day + "天" + hour + "小时" + min + "分钟"+ sec + "秒";
    }

    /**
     * （支付情况统计更多查询）
     * @author: 王志文
     * @date: 2018/1/3 14:37
     * @param compensateNo 计算书号
     * @return 页面参数dto
     */
    @Override
    public PageInfo queryPayDetail(String compensateNo,String payrefReason,int page,int size) {
        List<PayStatisticsBackDto> payStatisticsBackDtoList = new ArrayList<>();
        PayStatisticsBackDto payStatisticsBackDto ;
        PageInfo pageInfo = new PageInfo();
        if (StringUtils.isNotEmpty(compensateNo)){
            //原生sql
            StringBuilder sql = new StringBuilder("select p.billNo,p.paymentNo,main.receiverFullName, " +
                    " main.bankAccount,p.payAmount,main.thirdPayFlag,main.payPurpose from prplpaybill p left join " +
                    " prplpaymain main on main.paymentNo = p.paymentNo where p.compensateNo =:compensateNo " +
                    " and main.paymenttype =:payrefReason");
            StringBuilder countSql = new StringBuilder("select count(p.billNo) from prplpaybill p left join " +
                    " prplpaymain main on main.paymentNo = p.paymentNo where p.compensateNo =:compensateNo " +
                    " and main.paymenttype =:payrefReason");
            Map<String,Object> paraMap = new HashMap<>();
            paraMap.put("compensateNo",compensateNo);
            paraMap.put("payrefReason",payrefReason);
            Query query = entityManager.createNativeQuery(sql.toString());
            Query countQuery = entityManager.createNativeQuery(countSql.toString());
            this.setQueryParam(countQuery,paraMap);
            this.setQueryParam(query,page,size,paraMap);
            BigDecimal totalCount = (BigDecimal)countQuery.getSingleResult();
            List<Object[]> objectList = query.getResultList();
            if (objectList.size()>0){
                for (Object[] object:objectList) {
                    payStatisticsBackDto = new PayStatisticsBackDto();
                    payStatisticsBackDto.setBillNo((String)object[0]);
                    BigDecimal payAmount = (BigDecimal)object[4];
                    payStatisticsBackDto.setPayAmount(payAmount.toString());
                    payStatisticsBackDto.setPaymentNo((String)object[1]);
                    String thirdPayFlag = (String)object[5];
                    payStatisticsBackDto.setPayType(GetPayStatusFlagUtil.getPayStatusFlag().get(thirdPayFlag));
                    payStatisticsBackDto.setPurpose((String)object[6]);
                    payStatisticsBackDto.setReceiverAccount((String)object[3]);
                    payStatisticsBackDto.setReceiverName((String)object[2]);
                    payStatisticsBackDtoList.add(payStatisticsBackDto);
                }
                pageInfo.setPages(page);
                pageInfo.setContent(payStatisticsBackDtoList);
                pageInfo.setTotalCount(totalCount.longValue());
            }
        }
        return pageInfo;
    }

    /**
     * （支付情况统计列表查询）(分页)
     * @author: 王志文
     * @date: 2018/1/4 16:28
     * @param paymentStatisticsInDto 页面入参
     * @return 页面数据
     * @throws Exception 异常信息
     */
    public PageInfo queryPaymentStatistics(PaymentStatisticsInDto paymentStatisticsInDto)throws Exception{
        PageInfo pageInfo = new PageInfo();
        String requestXml = "";

        //获取查询条件
        if(paymentStatisticsInDto != null){
            XmlUtil xmlUtil = new XmlUtil();
            PacketDto<PaymentStatisticsInDto> packetDto = new PacketDto<>();
            packetDto.setBody(paymentStatisticsInDto);
            requestXml = xmlUtil.packetDtoToXml_bodyDto(packetDto);
        }
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(UIClaimPayService.class);
        jaxWsProxyFactoryBean.setAddress(webAgriPrpallServiceUrl+"/webAgriPrpallService/services/UIClaimPayService?wsdl".trim());
        UIClaimPayService uiClaimPayService = (UIClaimPayService)jaxWsProxyFactoryBean.create();
        String getXml = uiClaimPayService.queryPayStatisticsList(requestXml);

        List<PaymentStatisticsBackDto>  paymentStatisticsBackDtoList = new ArrayList<>();
        Document document = null;
        try {
            document = DocumentHelper.parseText(getXml);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        //取支付录入信息
        Element requestData =document.getRootElement();
        List<Element> list = requestData.elements("payStatisticsList");

        //取总记录数
        Element page = requestData.element("page");
        if(page==null){
            return null;
        }
        String pageSize = page.element("pageSize").getTextTrim();

        for(int i=0;i<list.size();i++){
            PaymentStatisticsBackDto paymentStatisticsBackDto = new PaymentStatisticsBackDto();

            String registNo = list.get(i).element("registNo").getTextTrim();
            String compensateNo = list.get(i).element("compensateNo").getTextTrim();
            String insuredName = list.get(i).element("insuredName").getTextTrim();
            String underWriteEndDate = list.get(i).element("underWriteEndDate").getTextTrim();
            String paymentType = list.get(i).element("paymentType").getTextTrim();
            String paymentTypeName = list.get(i).element("paymentTypeName").getTextTrim();
            String totalPayAmount = list.get(i).element("totalPayAmount").getTextTrim();
            String noEnterAmount = list.get(i).element("noEnterAmount").getTextTrim();
            String onTheWayAmount = list.get(i).element("onTheWayAmount").getTextTrim();
            String payedAmount = list.get(i).element("payedAmount").getTextTrim();

            paymentStatisticsBackDto.setCompensateNo(compensateNo);
            paymentStatisticsBackDto.setRegistNo(registNo);
            paymentStatisticsBackDto.setNoEnterAmount(noEnterAmount);
            paymentStatisticsBackDto.setInsuredName(insuredName);
            paymentStatisticsBackDto.setUnderWriteEndDate(underWriteEndDate);
            paymentStatisticsBackDto.setPaymentType(paymentType);
            paymentStatisticsBackDto.setPaymentTypeName(paymentTypeName);
            paymentStatisticsBackDto.setTotalPayAmount(totalPayAmount);
            paymentStatisticsBackDto.setOnTheWayAmount(onTheWayAmount);
            paymentStatisticsBackDto.setPayedAmount(payedAmount);
            paymentStatisticsBackDtoList.add(paymentStatisticsBackDto);
        }
        pageInfo.setContent(paymentStatisticsBackDtoList);
        pageInfo.setTotalCount(Long.valueOf(pageSize));
        pageInfo.setPages(paymentStatisticsInDto.getPageNo());
        return pageInfo;
    }

    /**
     * （支付情况统计列表查询）（不分页）
     * @author: 王志文
     * @date: 2018/1/4 18:18
     * @param paymentStatisticsInDto 页面入参
     * @return 页面数据
     * @throws Exception 异常信息
     */
    @Override
    public List<PaymentStatisticsBackDto> queryPaymentStatisticsNoPage(PaymentStatisticsInDto paymentStatisticsInDto) throws Exception {
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(NewAgriPrpallUndwrtService.class);
        jaxWsProxyFactoryBean.setAddress(webAgriPrpallServiceUrl+"/webAgriPrpallService/services/UIClaimPayService?wsdl".trim());
        UIClaimPayService uiClaimPayService = (UIClaimPayService)jaxWsProxyFactoryBean.create();
        String requestXml = "";

        //获取查询条件
        if(paymentStatisticsInDto != null){
            XmlUtil xmlUtil = new XmlUtil();
            PacketDto<PaymentStatisticsInDto> packetDto = new PacketDto<>();
            packetDto.setBody(paymentStatisticsInDto);
            requestXml = xmlUtil.packetDtoToXml_bodyDto(packetDto);
        }
        String getXml = uiClaimPayService.queryPayStatisticsList(requestXml);

        List<PaymentStatisticsBackDto>  paymentStatisticsBackDtoList = new ArrayList<>();

        Document document = null;
        try {
            document = DocumentHelper.parseText(getXml);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        //取支付录入信息
        Element requestData =document.getRootElement();
        List<Element> list = requestData.elements("payStatisticsList");

        for(int i=0;i<list.size();i++){
            PaymentStatisticsBackDto paymentStatisticsBackDto = new PaymentStatisticsBackDto();

            String registNo = list.get(i).element("registNo").getTextTrim();
            String compensateNo = list.get(i).element("compensateNo").getTextTrim();
            String insuredName = list.get(i).element("insuredName").getTextTrim();
            String underWriteEndDate = list.get(i).element("underWriteEndDate").getTextTrim();
            String paymentType = list.get(i).element("paymentType").getTextTrim();
            String totalPayAmount = list.get(i).element("totalPayAmount").getTextTrim();
            String noEnterAmount = list.get(i).element("noEnterAmount").getTextTrim();
            String onTheWayAmount = list.get(i).element("onTheWayAmount").getTextTrim();
            String payedAmount = list.get(i).element("payedAmount").getTextTrim();

            paymentStatisticsBackDto.setCompensateNo(compensateNo);
            paymentStatisticsBackDto.setRegistNo(registNo);
            paymentStatisticsBackDto.setNoEnterAmount(noEnterAmount);
            paymentStatisticsBackDto.setInsuredName(insuredName);
            paymentStatisticsBackDto.setUnderWriteEndDate(underWriteEndDate);
            paymentStatisticsBackDto.setPaymentType(paymentType);
            paymentStatisticsBackDto.setTotalPayAmount(totalPayAmount);
            paymentStatisticsBackDto.setOnTheWayAmount(onTheWayAmount);
            paymentStatisticsBackDto.setPayedAmount(payedAmount);
            paymentStatisticsBackDtoList.add(paymentStatisticsBackDto);
        }
        return paymentStatisticsBackDtoList;
    }

    /**
     * （状态金额总计查询）
     * @author: 王志文
     * @date: 2018/1/5 9:30
     * @param paymentType 第三方支付标识
     * @param compensateNo 计算书号
     * @return 页面数据集合
     * @throws Exception 异常信息
     */
    @Override
    public List<PayStateAmountBackDto> queryPayStateAmount(String paymentType, String compensateNo) throws Exception {
        List<PayStateAmountBackDto> payStateAmountBackDtoList = new ArrayList<>();
        if (StringUtils.isNotEmpty(paymentType) && StringUtils.isNotEmpty(compensateNo)){
            StringBuilder strSql = new StringBuilder("select main.thirdPayFlag,NVL(sum(t.payAmount), 0) as payAmount" +
                    " from prplPay t left join prplPayMain main on t.serialNo = main.paymentNo" +
                    " where t.paymentType =:paymentType AND T.compensateNo =:compensateNo " +
                    " group by main.thirdPayFlag");
            PayStateAmountBackDto payStateAmountBackDto;
            Map<String,Object> paraMap = new HashMap<>();
            paraMap.put("paymentType",paymentType);
            paraMap.put("compensateNo",compensateNo);
            Query query = entityManager.createNativeQuery(strSql.toString());
            this.setQueryParam(query,paraMap);
            List<Object[]> objects = query.getResultList();
            if (objects.size()>0){
                for (Object[] objectArr: objects) {
                    payStateAmountBackDto = new PayStateAmountBackDto();
                    String paymentState = (String)objectArr[0];
                    payStateAmountBackDto.setPaymentState(GetPayStatusFlagUtil.getPayStatusFlag().get(paymentState));
                    payStateAmountBackDto.setPayAmount(((BigDecimal)objectArr[1]).doubleValue());
                    payStateAmountBackDtoList.add(payStateAmountBackDto);
                }
            }
        }
        return payStateAmountBackDtoList;
    }

    /**
     * 支付情况统计查询导出Excel
     * @param paymentStatisticsInDto   查询入参封装对象
     * @return shortLink 文件下载短链接
     * @throws Exception
     * @author 李文刚
     * @time 2018-1-10
     */
    @Override
    public Map<String,String> paymentStatisticsExportExcel(PaymentStatisticsInDto paymentStatisticsInDto) throws Exception{

        List<PaymentStatisticsBackDto> paymentStatisticsBackDtoList = new ArrayList<>();
        String titleName = "";
        String excelName = "";
        String shortLinkId = "";
        excelName = titleName = "支付情况统计清单";
        Class<PaymentStatisticsBackDto> paymentStatisticsBackDtoClass = PaymentStatisticsBackDto.class;
        paymentStatisticsBackDtoList = prplPayApi.queryPaymentStatisticsNoPage(paymentStatisticsInDto);
         if(paymentStatisticsBackDtoList.size()<1||paymentStatisticsBackDtoList==null){
             throw new BusinessException("无支付情况统计查询数据");
         }
        File file = null;
        try {
            //Excel导出类型判断：.xls 97-2003 版本 Excel
            QuicklyExportExcel quicklyExportExcel = new QuicklyExportExcel();
            file = quicklyExportExcel.quicklyExport(exportExcelType, excelName, titleName,
                    paymentStatisticsBackDtoList, 1, 8, paymentStatisticsBackDtoClass);
            // 上传文件到fileServer
            FileUtil fileUtil = new FileUtil();
            String userCode = SinoRequestContext.getCurrentContext().getUserCode();
            String systemId ="agri/tempfile" ;
            String bussType ="agriclaim_paymentmanage";
            shortLinkId = fileUtil.uploadFile(fileServiceUrl, file, userCode, systemId, bussType);
        } finally {
            // 删除本地的临时文件
            if (file != null) {
                file.delete();
            }
        }
        Map<String,String> map = new HashMap<>();
        map.put("shortLinkId",shortLinkId);
        return map;
    }
    void addExcelSelect(List<String> list,File file, int currentRow, int colNum) throws Exception{
        if(list!=null&&list.size()>0){
            FileOutputStream os;
            FileInputStream finput = new FileInputStream(file.getAbsolutePath());
            POIFSFileSystem fs = new POIFSFileSystem(finput);
            HSSFWorkbook hs = new HSSFWorkbook(fs);
            HSSFSheet sheet = hs.getSheetAt(0);
            //list转为数组
            int size = list.size();
            CellRangeAddressList regions = new CellRangeAddressList(3, currentRow+3, colNum, colNum);
            // 创建下拉列表数据
            DVConstraint constraint = DVConstraint.createExplicitListConstraint((String[])list.toArray(new String[size]));
            // 绑定
            HSSFDataValidation dataValidation = new HSSFDataValidation(regions, constraint);
            sheet.addValidationData(dataValidation);
            os = new FileOutputStream(file.getAbsolutePath());
            hs.write(os);
        }
    }

    /**
     * 账户同步按钮
     * @Author 王心洋
     * @time 2018/4/24
     * @param registNoList
     * @return List<PrpLCompensateDto>
     */
    public List<PrpLCompensateDto> synchAccount(List<String> registNoList){
        StringBuffer conditions = new StringBuffer("select p from PrpLCompensate p where (p.receiverName is not null or p.bank is not null or p.account is not null)");
        StringBuffer strRegistNo = new StringBuffer("");
        List<PrpLCompensateDto> prpLCompensateDtoList1 = new ArrayList<>();
        List<PrpLCompensateDto> prpLCompensateDtoList2 = new ArrayList<>();
        if(null!=registNoList && registNoList.size()>0){
            for(int i=0;i<registNoList.size();i++){
                if(i==0){
                    strRegistNo.append("'"+registNoList.get(i)+"'");
                }else{
                    strRegistNo.append(",'"+registNoList.get(i)+"'");
                }
            }
            conditions.append(" and p.claimNo in (select claimNo from PrpLClaim where registNo in (")
                    .append(strRegistNo).append("))");
        }

        try {
            Query query = entityManager.createQuery(conditions.toString());
            List<PrpLCompensate> prpLCompensateList = query.getResultList();
            this.convertCollection(prpLCompensateList, prpLCompensateDtoList1, PrpLCompensateDto.class);
            //根据保单号查询客户信息
            Map<String,String> map;
            PrpLCompensateDto prpLCompensateDto;
            for(PrpLCompensateDto iPrpLCompensateDto:prpLCompensateDtoList1){
                map = new HashMap<>();
                map.put("policyNo",iPrpLCompensateDto.getPolicyNo());
                List<PrpCinsuredDto> prpCinsuredDtoList = prpCinsuredApi.queryByPolicyNo(map);
                for(PrpCinsuredDto prpCinsuredDto:prpCinsuredDtoList){
                    prpLCompensateDto = new PrpLCompensateDto();
                    prpLCompensateDto.setAccount(prpCinsuredDto.getAccount());
                    prpLCompensateDto.setBank(prpCinsuredDto.getBank());
                    prpLCompensateDto.setReceiverName(prpCinsuredDto.getInsuredName());
                    prpLCompensateDto.setCompensateNo(iPrpLCompensateDto.getCompensateNo());
                    prpLCompensateDtoList2.add(prpLCompensateDto);
                }
            }
            for(PrpLCompensateDto iPrpLCompensateDto:prpLCompensateDtoList2){
                prpLCompensateDtoList1.add(iPrpLCompensateDto);
            }
        } catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        return prpLCompensateDtoList1;
    }

    /**
     * 支付信息统计表在途金额飘窗
     * @param compensateNo 计算书号
     * @param paymentType 赔款类型
     * @return
     * @throws Exception
     * @author 王心洋
     * @time 2018/4/27
     */
    public List<PrplPayDto> queryOnTheWayList(String compensateNo,String paymentType) throws Exception{
        List<PrplPayDto> prplPayDtoList = new ArrayList<>();
        List<PrpLPayMainDto> prplPayMainDtoList;
        if(StringUtils.isEmpty(compensateNo)){
            compensateNo = "";
        }
        if(StringUtils.isEmpty(paymentType)){
            paymentType = "";
        }
        StringBuffer sql = new StringBuffer("select a.* from PrplPay a left join PrpLPayMain b on a.serialNo=b.paymentNo");
        sql.append("    where b.thirdPayFlag in ('0', '1', '2', '3', '4', '5', '6', '7') and a.compensateNo='");
        sql.append(compensateNo).append("' and a.paymentType='").append(paymentType).append("'");
        Query dataQuery = entityManager.createNativeQuery(sql.toString(),PrplPay.class);
        convertCollection(dataQuery.getResultList(),prplPayDtoList,PrplPayDto.class);
        for(int i=0;i<prplPayDtoList.size();i++){
            StringBuffer sql2 = new StringBuffer("select b.* from PrpLPayMain b where b.paymentNo='");
            sql2.append(prplPayDtoList.get(i).getSerialNo()).append("'");
            Query dataQuery2 = entityManager.createNativeQuery(sql2.toString(),PrpLPayMain.class);
            prplPayMainDtoList = new ArrayList<>();
            convertCollection(dataQuery2.getResultList(),prplPayMainDtoList,PrpLPayMainDto.class);
            if(prplPayMainDtoList!=null&&prplPayMainDtoList.size()>0){
                if(StringUtils.isNotEmpty(prplPayMainDtoList.get(0).getThirdPayFlag())){
                    if("0".equals(prplPayMainDtoList.get(0).getThirdPayFlag())){
                        prplPayDtoList.get(i).setThirdPayFlag("待提交");
                    }
                    if("1".equals(prplPayMainDtoList.get(0).getThirdPayFlag())){
                        prplPayDtoList.get(i).setThirdPayFlag("待审核");
                    }
                    if("2".equals(prplPayMainDtoList.get(0).getThirdPayFlag())){
                        prplPayDtoList.get(i).setThirdPayFlag("审核不通过");
                    }
                    if("3".equals(prplPayMainDtoList.get(0).getThirdPayFlag())){
                        prplPayDtoList.get(i).setThirdPayFlag("支付中心待处理");
                    }
                    if("4".equals(prplPayMainDtoList.get(0).getThirdPayFlag())){
                        prplPayDtoList.get(i).setThirdPayFlag("支付中心退回");
                    }
                    if("5".equals(prplPayMainDtoList.get(0).getThirdPayFlag())){
                        prplPayDtoList.get(i).setThirdPayFlag("已打包待审核");
                    }
                    if("6".equals(prplPayMainDtoList.get(0).getThirdPayFlag())){
                        prplPayDtoList.get(i).setThirdPayFlag("打包审核通过待发送");
                    }
                    if("7".equals(prplPayMainDtoList.get(0).getThirdPayFlag())){
                        prplPayDtoList.get(i).setThirdPayFlag("已发往银行");
                    }
                }
            }
        }
        return prplPayDtoList;
    }

    /**
     * （电子回执单下载）
     * @author: 王志文
     * @date: 2018/5/9 9:37
     * @param paymentNo
     * @return
     * @throws Exception
     *
     */
    @Override
    public Map<String, String> downloadReceipt(String paymentNo) throws Exception {
        Map<String,String> map = new HashMap<>();
        String requestXml = this.getRequestXml(paymentNo);
        String strURL = receiptServiceUrl+"/payment-service/services/QueryAllinPayreceiptInfo?wsdl";
        org.apache.axis.client.Service service = new org.apache.axis.client.Service();
        QueryAllinPayreceiptInfoSoapBindingStub stub = new QueryAllinPayreceiptInfoSoapBindingStub(new java.net.URL(strURL), service);
        String responseXml = stub.queryAllinPayreceiptInfo(requestXml);
        InputStream in = new ByteArrayInputStream(responseXml.getBytes());
        org.w3c.dom.Document document = XMLUtils.parse(in);
        Node node = XMLUtils.getChildNodeByPath(document, "/Packet/Body/AllinpayReceiptDtoList/allinpayReceiptDto");
        if (node != null){
            String ftpPath = XMLUtils.getChildNodeValue(node, "pdfaddress");
            FTPUtils ftpUtils = new FTPUtils();
            File file = ftpUtils.AllinPayreceiptFile(ftpPath,ftpUrl,ftpPort,ftpUser,ftpPass,ftpDir);
            // 上传文件到fileServer
            FileUtil fileUtil = new FileUtil();
            String userCode = SinoRequestContext.getCurrentContext().getUserCode();
            String systemId = "agri/tempfile";//系统
            String bussType = "agriclaim_paymentmanage";//项目名_模块名
            String shortLink = fileUtil.uploadFile(fileServiceUrl, file, userCode, systemId, bussType);
            map.put("shortLink",shortLink);
        }
        return map;
    }

    //报文组装
    private String getRequestXml(String paymentNo){
        String currentTime = simpleDateFormat1.format(new Date());
        String requestXml =
                "<Packet type=\"REQUEST\" version=\"1.0\">\n" +
                        " <Head>\n" +
                        "\t\t<TransType>queryallinpay</TransType>\n" +
                        "\t\t<TransID>"+currentTime+"</TransID>\n" +
                        "\t\t<ChannelCode>Sinosoft</ChannelCode>\n" +
                        "\t\t<UserCode>"+iUserCode+"</UserCode>\n" +
                        "\t\t<Password>"+iPassWord+"</Password>\n" +
                        " </Head>\n" +
                        " <Body>\n" +
                        "      <BasePart>\n" +
                        "          <visaserialno>"+paymentNo+"</visaserialno>\n" +
                        "          <channelcode>Sinosoft</channelcode>\n" +
                        "     </BasePart>\n" +
                        " </Body>\n" +
                        "</Packet>";
        return requestXml;
    }

    /**
     * （支付信息双核回写方法）
     * @author: 王志文
     * @date: 2018/5/12 16:17
     * @param undwrtWriteBackReCaseDto
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String undwrtBackPay(UndwrtWriteBackReCaseDto undwrtWriteBackReCaseDto) throws Exception {
        String userCode = SinoRequestContext.getCurrentContext().getUserCode();
        String notionInfo = undwrtWriteBackReCaseDto.getNotionInfo();
        PrpDuserDto userInfo = userApi.queryUserInfo(userCode);
        String businessNo = undwrtWriteBackReCaseDto.getBusinessNo();
        if ("1".equals(undwrtWriteBackReCaseDto.getUndwrtFlag())){
            prplPayDao.updateVFlagBySerialNo("8",businessNo);
            PrpLPayMainKey prpLPayMainKey = new PrpLPayMainKey();
            prpLPayMainKey.setPaymentNo(businessNo);
            PrpLPayMain prplpaymain = prpLPayMainDao.findOne(prpLPayMainKey);
            prplpaymain.setvFlag("8");
            prplpaymain.setVerifyFlag("1");
            if(prplpaymain.getPayAmount()<0){
                prplpaymain.setThirdPayFlag("a");//更新第三方支付标识
            }else{
                prplpaymain.setThirdPayFlag("3");//更新第三方支付标识
            }
            prpLPayMainDao.save(prplpaymain);
            //插入支付占用处理意见的操作
            PrpLPayExtDto prpLpayExtDto = new PrpLPayExtDto();
            prpLpayExtDto.setPaymentNo(businessNo);
            int count = prpLPayExtDao.getCountByPaymentNo(businessNo)+1;
            prpLpayExtDto.setSerialNo(count);
            prpLpayExtDto.setComCode(userInfo.getComCode());
            prpLpayExtDto.setNodeType("vpay");
            prpLpayExtDto.setNodeName("支付审批");
            prpLpayExtDto.setInputDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND));
            prpLpayExtDto.setOperatorCode(userInfo.getUserCode());
            prpLpayExtDto.setFlag("Y");
            prpLpayExtDto.setNotionCode("4");
            prpLpayExtDto.setNotionName("审核通过");
            String[] strMessageStrings = notionInfo.split(" ");
            String context = strMessageStrings[strMessageStrings.length - 1];
            prpLpayExtDto.setContext(context);
            prpLPayExtDao.save(this.convert(prpLpayExtDto,PrpLPayExt.class));
        }else if("0".equals(undwrtWriteBackReCaseDto.getUndwrtFlag())){
            prplPayDao.updateVFlagBySerialNo("6",businessNo);
            prpLPayMainDao.updateVFlagByPaymentNo("6",businessNo);
        }
        return "0000";
    }
    /**
     * 双核系统审核回调
     * @author: 孙朋飞
     * @date: 2018/1/11 15:55
     * @param requestPrpLPayDto 接受双核数据
     * @return 回调状态
     * @throws Exception
     */
    @Override
    public Integer writeVeriPay(UndwrtWriteBackReCaseDto requestPrpLPayDto) throws Exception {
        if(requestPrpLPayDto==null){
            throw new DataVerifyException("数据不能为空!");
        }
        //初始化
        int checkFlag=100;
        String payType=requestPrpLPayDto.getUndwrtFlag();
        //String LflowID = requestPrpLPayDto.getLflowID();
        //int lLogNo = requestPrpLPayDto.getLlogNo();
        String businessNo = requestPrpLPayDto.getBusinessNo();
        String notionInfo = requestPrpLPayDto.getNotionInfo();
        String handlerCode = requestPrpLPayDto.getHandlerCode();
        //查询员工
        PrpDuserDto prpDuserDto = prpDuserApi.queryByPK(handlerCode);
        if("1".equals(payType)){
            //审核平台通过
            if(StringUtils.isNotEmpty(businessNo)&&businessNo.startsWith("H")){
                //更新支付信息主表和子表
                List<PrpLPayBill> prpLPayBillList = prpLPayBillDao.findPrpLPayBillByBillNo(businessNo);
                if(prpLPayBillList!=null&&prpLPayBillList.size()>0) {
                    for (int i = 0; i < prpLPayBillList.size(); i++) {
                        PrpLPayBill prpLPayBill = prpLPayBillList.get(i);
                        //更新支付表和支付main表
                        updatePrpLPayAndPrpLPayMainBySerialNo(prpLPayBill.getPaymentNo());
                    }
                }
            }else{
                //根据业务号更新
                updatePrpLPayAndPrpLPayMainBySerialNo(businessNo);
            }
            //保存支付处理意见表
            savePrpLPayExt(businessNo,prpDuserDto,"vpay","支付审批",handlerCode,
                    "Y","4","审核通过",notionInfo);
        }else if("0".equals(payType)){
            //审核平台放弃
            if(StringUtils.isNotEmpty(businessNo)&&businessNo.startsWith("H")){
                //更新支付信息主表和子表
                List<PrpLPayBill> prpLPayBillList = prpLPayBillDao.findPrpLPayBillByBillNo(businessNo);
                if(prpLPayBillList!=null && prpLPayBillList.size()>0){
                    for (int i = 0; i < prpLPayBillList.size(); i++) {
                        PrpLPayBill prpLPayBill = prpLPayBillList.get(i);
                        prplPayDao.updatePrpLPayBySerialNo("6",prpLPayBill.getPaymentNo());
                        prpLPayMainDao.updatePrpLPayMainByKey(prpLPayBill.getPaymentNo(),"6");
                    }
                }
            }else{
                prplPayDao.updatePrpLPayBySerialNo("6",businessNo);
                prpLPayMainDao.updatePrpLPayMainByKey(businessNo,"6");
            }

        }else{
            //审核平台不通过下发修改
            if(StringUtils.isNotEmpty(businessNo)&&businessNo.startsWith("H")){
                //更新支付信息主表和子表
                List<PrpLPayBill> prpLPayBillList = prpLPayBillDao.findPrpLPayBillByBillNo(businessNo);
                if(prpLPayBillList!=null&&prpLPayBillList.size()>0) {
                    for (int i = 0; i < prpLPayBillList.size(); i++) {
                        PrpLPayBill prpLPayBill = prpLPayBillList.get(i);
                        //更新支付表和支付main表 “3”-退回
                        prplPayDao.updatePrpLPayBySerialNo("3",prpLPayBill.getPaymentNo());
                        prpLPayMainDao.updatePrpLPayMainByKeyAndThirdPayFlag(prpLPayBill.getPaymentNo(),"3","2");

                    }
                }
            }else{
                //根据业务号更新 “3”-退回
                prplPayDao.updatePrpLPayBySerialNo("3",businessNo);
                prpLPayMainDao.updatePrpLPayMainByKeyAndThirdPayFlag(businessNo,"3","2");
            }
            //插入审批退回处理意见的操作
            savePrpLPayExt(businessNo,prpDuserDto,"vpay","支付审批",handlerCode,
                    "Y","3","下发修改",notionInfo);
            List<PrpLPayBill> prpLPayBillByPaymentNo = prpLPayBillDao.findPrpLPayBillByPaymentNo(businessNo);
            for (int i=0; i<prpLPayBillByPaymentNo.size();i++) {
                PrpLPayBill prpLPayBill = prpLPayBillByPaymentNo.get(i);
                prpLClaimBillManagerDao.updatePrpLClaimBillManagerByConditions(prpLPayBill.getRegistNo(),prpLPayBill.getCompensateNo(),
                        prpLPayBill.getSerialNo(),"5");
            }
        }
        return checkFlag;
    }
    /**
     * 根据序号更新支付表和支付main表标志
     * @author: 孙朋飞
     * @date: 2018/1/11 18:34
     * @param serialNo 序号
     * @throws Exception
     */
    public void updatePrpLPayAndPrpLPayMainBySerialNo(String serialNo) throws Exception{
        //更新支付标记 “8”-审核通过
        prplPayDao.updatePrpLPayBySerialNo("8",serialNo);
        //更新支付信息主表
        PrpLPayMainKey prpLPayMainKey = new PrpLPayMainKey(serialNo);
        PrpLPayMain prpLPayMain = prpLPayMainDao.findOne(prpLPayMainKey);
        if(prpLPayMain!=null){
            prpLPayMain.setvFlag("8");
            //审核方式-人工审核1，自动审核为0；
            prpLPayMain.setVerifyFlag("1");
            if(prpLPayMain.getPayAmount()<0){
                //更新第三方支付标志
                prpLPayMain.setThirdPayFlag("a");
            }else{
                //“3”-支付中心待处理
                prpLPayMain.setThirdPayFlag("3");
            }
            //更新
            prpLPayMainDao.save(prpLPayMain);
        }
    }


    /**
     * 保存支付处理意见表
     * @author: 孙朋飞
     * @date: 2018/1/11 19:26
     * @param businessNo 业务号
     * @param prpDuserDto 员工的dto
     * @param nodeType 节点类型
     * @param nodeName 节点名称
     * @param operatorCode 操作人代码
     * @param flag 标志
     * @param notionCode 审核代码
     * @param notionName 审核的名称
     * @param notionInfo 审核信息
     * @throws Exception
     */
    public void savePrpLPayExt(String businessNo, PrpDuserDto prpDuserDto, String nodeType, String nodeName, String operatorCode,
                               String flag, String notionCode, String notionName, String notionInfo) throws Exception{
        PrpLPayExt prpLPayExt = new PrpLPayExt();
        prpLPayExt.setPaymentNo(businessNo);
        int countNum =prpLPayExtDao.findPrpLPayExtCount(businessNo)+1;
        prpLPayExt.setSerialNo(countNum);
        prpLPayExt.setComCode(prpDuserDto.getComCode());
        prpLPayExt.setNodeType(nodeType);
        prpLPayExt.setNodeName(nodeName);
        prpLPayExt.setInputDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND));
        prpLPayExt.setOperatorCode(operatorCode);
        prpLPayExt.setFlag(flag);
        prpLPayExt.setNotionCode(notionCode);
        prpLPayExt.setNotionName(notionName);
        String[] strMessageStrings = notionInfo.split(" ");
        String context = strMessageStrings[strMessageStrings.length - 1];
        prpLPayExt.setContext(context);
        prpLPayExtDao.save(prpLPayExt);
    }
}