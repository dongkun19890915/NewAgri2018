package com.sinosoft.agriprpall.core.policymanage.service.impl;

import com.sinosoft.agriprpall.api.policymanage.dto.PaymentContentDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponsePaymentNoticeDto;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCinsuredDao;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCmainDao;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpPolicyFeeNoticeDao;
import com.sinosoft.agriprpall.core.policymanage.entity.*;
import com.sinosoft.agriprpall.core.policymanage.service.PaymentNoticeService;
import com.sinosoft.dms.api.billno.BillNoApi;
import com.sinosoft.dms.api.billno.dto.BillNoDto;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.pms.api.kernel.PrpDriskApi;
import com.sinosoft.pms.api.kernel.dto.PrpDriskDto;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;


/**
 *（缴费通知书打印查询）
 * @Author: 陈道洋
 * @Date: 2017/11/8 14:19
 */
@Service
public class PaymentNoticeServiceImpl extends BaseServiceImpl implements PaymentNoticeService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentNoticeServiceImpl.class);
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PrpPolicyFeeNoticeDao prpPolicyFeeNoticeDao;
    @Autowired
    private PrpCinsuredDao prpCinsuredDao;
    @Autowired
    private BillNoApi billNoApi;
    @Autowired
    private PrpCmainDao prpCmainDao;
    @Autowired
    private PrpDcompanyApi prpDcompanyApi;
    @Autowired
    private PrpDriskApi prpDriskApi;
    /**
     * @description:缴费通知书打印查询
     * @author: 陈道洋
     * @date: 2017/10/23 14:57
     * @param policyNo
     * @return 缴费通知书打印查询所需的数据
     * @throws Exception
     */
    @Override
    public ResponsePaymentNoticeDto queryPaymentNoticeByCondition(String policyNo) throws Exception {
        if(StringUtils.isEmpty(policyNo)){
            throw new DataVerifyException("投保单号不能为空");
        }
        ResponsePaymentNoticeDto responsePaymentNoticeDto = new ResponsePaymentNoticeDto();
        //todo 机构名称和险种名称查prpDcompany表prpdrisk，公共表暂时不写
        PrpCmain prpCmain = prpCmainDao.findOne(new PrpCmainKey(policyNo));
        PrpDcompanyDto prpDcompanyDto = null;
        PrpDriskDto prpDriskDto=null;
        if(prpCmain!=null){
             String comcode = prpCmain.getComCode();
             String riskcode=prpCmain.getRiskCode();
             Map<String,String> riskCodemap = new HashMap<>();
             riskCodemap.put("riskCode",riskcode);
             prpDcompanyDto = prpDcompanyApi.queryByPK(comcode);
             prpDriskDto = prpDriskApi.queryByPK(riskCodemap);
        }
        responsePaymentNoticeDto.setComCName(prpDcompanyDto.getComCName());
        //查询保单和保费
        StringBuilder Sql = new StringBuilder("SELECT c FROM PrpCplan c WHERE c.payReason in('P10', 'P40','PS3', 'PS4','PS5','PS6','PS7','R10','R20','R30','RS3','RS4','RS5','RS6','RS7')");
        Sql.append(" AND c.policyNo=:policyNo");
        System.out.print(Sql);
        Query dataQuery = entityManager.createQuery(Sql.toString());
        dataQuery.setParameter("policyNo",policyNo);
        List<PrpCplan> prpCplanList = dataQuery.getResultList();
        List<PaymentContentDto> arraylist = new ArrayList<>();
        convertCollection(prpCplanList,arraylist,PaymentContentDto.class);
        if(prpDriskDto!=null&&prpDriskDto.getRiskCName()!=null){
        for(PaymentContentDto paymentContentDto:arraylist){
                paymentContentDto.setRiskCName(prpDriskDto.getRiskCName());
            }
        }
        //将保单和保费信息添加到responsePaymentNoticeDto中
        responsePaymentNoticeDto.setPaymentContentlist(arraylist);
        //查询客户名称
        List<PrpCinsured> prpCinsuredList = prpCinsuredDao.findByPolicyNoAndInsuredFlag(policyNo, "2");
        if(prpCinsuredList!=null&&prpCinsuredList.size()>0){
            for( PrpCinsured prpCinsured:prpCinsuredList){
                //将客户名称添加到responsePaymentNoticeDto中
                responsePaymentNoticeDto.setInsuredName(prpCinsured.getInsuredName());
            }
        }
        //缴费通知单编号查询
        BillNoDto billNoDto=new BillNoDto();
        billNoDto.setTableName("prppolicyfeenotice");
        billNoDto.setPolicyNo(policyNo);
        ResponseDto responseDto = billNoApi.getNo(billNoDto);
        responsePaymentNoticeDto.setPolicyFeeNo(responseDto.getResultObj().toString());
        return responsePaymentNoticeDto;
    }

    /**
     * @description:缴费通知书单号回写
     * @author: 陈道洋
     * @date: 2017/10/24 9:27
     * @param policyFeeNo
     * @param policyNo
     * @return
     * @throws Exception
     */
    @Override
    public void updatepolicyFeeNo(String policyFeeNo, String policyNo) throws Exception {
        if(StringUtils.isEmpty(policyNo)){
            throw new DataVerifyException("保单号不能为空");
        }
        int i = prpPolicyFeeNoticeDao.updatepolicyFeeNo(policyFeeNo, policyNo);
    }


    }

