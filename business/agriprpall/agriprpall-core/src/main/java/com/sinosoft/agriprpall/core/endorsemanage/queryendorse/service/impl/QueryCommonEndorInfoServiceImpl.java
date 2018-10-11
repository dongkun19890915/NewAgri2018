package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.QueryPolicyTxnListService;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.CalEndorPremiumService;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.QueryCommonEndorInfoService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.exception.DataVerifyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class QueryCommonEndorInfoServiceImpl extends BaseServiceImpl implements QueryCommonEndorInfoService{
    @Autowired
    private CalEndorPremiumService calEndorPremiumService;
    @Autowired
    private QueryPolicyTxnListService queryPolicyTxnListService;
    /**
     *  普通批改保费计算
     * @param policyNo 保单号
     * @return PolicyEndorseDto 批单保单大对象
     * @throws Exception
     * @author 李冬松
     * @date 16:39 2017/12/22
     */
    @Override
    public PolicyEndorseDto queryCommonEndorInfo(String policyNo ,String validDate) throws Exception {
        PolicyEndorseDto policyEndorseDto = new PolicyEndorseDto();
        policyEndorseDto.setBlPolicyInfoDtoNew(queryPolicyTxnListService.queryPolicyAndTxnListInfo(policyNo));
        policyEndorseDto.setBlPolicyInfoDtoOld(queryPolicyTxnListService.queryPolicyAndTxnListInfo(policyNo));
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date=sdf.parse(validDate);
        }catch (Exception e){
            throw new DataVerifyException("日期格式不对！");
        }
        calEndorPremiumService.CalEndor93PremByNext(policyEndorseDto,date);
        return policyEndorseDto;
    }
}
