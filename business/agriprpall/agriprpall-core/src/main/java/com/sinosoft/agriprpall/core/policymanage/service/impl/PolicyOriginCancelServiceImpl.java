package com.sinosoft.agriprpall.core.policymanage.service.impl;

import com.sinosoft.agriprpall.core.policymanage.dao.*;
import com.sinosoft.agriprpall.core.policymanage.service.PolicyOriginCancelService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PolicyOriginCancelServiceImpl extends BaseServiceImpl implements PolicyOriginCancelService {

    @Autowired
    private PrpCcoinsDetailOriginDao prpCcoinsDetailOriginDao;
    @Autowired
    private PrpCcoinsOriginDao prpCcoinsOriginDao;
    @Autowired
    private PrpCexpenseOriginDao prpCexpenseOriginDao;
    @Autowired
    private PrpCitemKindOriginDao prpCitemKindOriginDao;
    @Autowired
    private PrpCfeeOriginDao prpCfeeOriginDao;
    @Autowired
    private PrpCmainOriginDao prpCmainOriginDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void originCancel(String policyNo, String option) throws Exception {
        if (StringUtils.isEmpty(policyNo)){
            throw new DataVerifyException("请传入保单号");
        }
        prpCcoinsDetailOriginDao.deleteByPolicyNo(policyNo);
        prpCcoinsOriginDao.deleteByPolicyNo(policyNo);
        prpCexpenseOriginDao.deleteByPolicyNo(policyNo);
        prpCitemKindOriginDao.deleteByPolicyNo(policyNo);
        prpCfeeOriginDao.deleteByPolicyNo(policyNo);
        if ("Y".equals(option)){
            prpCmainOriginDao.deleteByPolicyNo(policyNo);
        }
    }
}
