package com.sinosoft.agriprpall.core.policymanage.service.impl;

import com.sinosoft.agriprpall.core.policymanage.dao.PrpDrenewalTraceDao;
import com.sinosoft.agriprpall.core.policymanage.service.PrpDrenewalTraceService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PrpDrenewalTraceServiceImpl extends BaseServiceImpl implements PrpDrenewalTraceService {

    @Autowired
    private PrpDrenewalTraceDao prpDrenewalTraceDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByPolicyNo(String policyNo) throws Exception {
        if (StringUtils.isEmpty(policyNo)){
            throw new DataVerifyException("请传入保单号");
        }
        prpDrenewalTraceDao.deleteByPolicyNo(policyNo);
    }
}
