package com.sinosoft.agriprpall.core.policymanage.service.impl;

import com.sinosoft.agriprpall.api.policymanage.PrpCmainApi;
import com.sinosoft.agriprpall.api.policymanage.dto.CheckPolicyNoDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.agriprpall.api.proposalmanage.PrpTmainApi;
import com.sinosoft.agriprpall.core.policymanage.service.CheckPolicyNoService;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCmainService;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTmain;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTmainService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * * 检查保单号是否存在
 * @Author: 田慧
 * @Date: 2017/12/1 11:54
 */
@Service
public class CheckPolicyNoServiceImpl extends BaseServiceImpl implements CheckPolicyNoService {
   @Autowired
   private PrpCmainService prpCmainService;
   @Autowired
   private PrpTmainService prpTmainService;

    /**
     *  检查保单号是否存在
     * @author: 田慧
     * @date: 2017/12/1 14:26
     * @param checkPolicyNoDto 自己定义的Dto 包括policyNo保单号、riskCode险种代码
     * @return map key是message，值分别为两种情况，一种是保单号系统中已存在，不可使用!请重输!，另一种是
     *         保单号已被投保单占用，不可使用!请重输!
     * @throws Exception
     */
    @Override
    public Map<String, String> checkPolicyNo(CheckPolicyNoDto checkPolicyNoDto) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Message", "success");
        String policyNo = checkPolicyNoDto.getPolicyNo();
        String riskCode = checkPolicyNoDto.getRiskCode();
        if (StringUtils.isEmpty(policyNo)) {
            throw new DataVerifyException("保单号不能为空!");
        }
        if (StringUtils.isEmpty(riskCode)) {
            throw new DataVerifyException("险种代码不能为空!");
        }
        int size=prpCmainService.checkPolicyNo(policyNo, riskCode).size();
        if (size>0) {
            map.put("Message", policyNo+"保单号系统中已存在，不可使用!请重输!");
            return map;
        }
        int strSize = prpTmainService.checkPolicyNo(policyNo, riskCode).size();
        if (strSize>0){
            String proposalNo = prpTmainService.checkPolicyNo(policyNo, riskCode).get(0).getProposalNo();
            map.put("Message",policyNo+"保单号已被投保单："+proposalNo+" 占用，不可使用!请重输!");
            return map;
        }
        return map;
    }
}

