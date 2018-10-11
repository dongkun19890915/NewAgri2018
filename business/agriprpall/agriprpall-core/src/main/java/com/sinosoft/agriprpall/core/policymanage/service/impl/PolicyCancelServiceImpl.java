package com.sinosoft.agriprpall.core.policymanage.service.impl;

import com.sinosoft.agriprpall.core.policymanage.dao.*;
import com.sinosoft.agriprpall.core.policymanage.service.PolicyCancelService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 保单删除服务
 * @Author: 王保良
 * @Date: 2017/12/8 14:55
 */
@Service
public class PolicyCancelServiceImpl extends BaseServiceImpl implements PolicyCancelService {


    @Autowired
    private PrpCitemKindAgriDao prpCitemKindAgriDao;
    @Autowired
    private PrpCsubsidyDao prpCsubsidyDao;
    @Autowired
    private PrpCfeildDao prpCfeildDao;
    @Autowired
    private PrpCrenewalDao prpCrenewalDao;
    @Autowired
    private PrpCinsuredDao prpCinsuredDao;
    @Autowired
    private PrpCaddressDao prpCaddressDao;
    @Autowired
    private PrpCitemKindDao prpCitemKindDao;
    @Autowired
    private PrpCplanDao prpCplanDao;
    @Autowired
    private PrpCplanCoinsDao prpCplanCoinsDao;
    @Autowired
    private PrpCcoinsDetailDao prpCcoinsDetailDao;
    @Autowired
    private PrpCcoinsDao prpCcoinsDao;
    @Autowired
    private PrpCfeeDao prpCfeeDao;
    @Autowired
    private PrpCengageDao prpCengageDao;
    @Autowired
    private PrpCmainAgriDao prpCmainAgriDao;
    @Autowired
    private PrpCexpenseDao prpCexpenseDao;
    @Autowired
    private PrpCmainDao prpCmainDao;



    @Override
    @Transactional(rollbackFor = Exception.class)
    public void cancel(String policyNo,String option) throws Exception {

        //1
        prpCsubsidyDao.deleteAllByCondition(policyNo);
        //2
        prpCaddressDao.deleteByPolicyNo(policyNo);
        //3
        prpCengageDao.deleteAllByCondition(policyNo);
        //4
        prpCfeeDao.deleteByPolicyNo(policyNo);
        //5
        prpCinsuredDao.deleteAllByCondition(policyNo);
        //6
        prpCitemKindDao.deleteByPolicyNo(policyNo);
        //7
        prpCmainAgriDao.deleteByPolicyNo(policyNo);
        //8
        prpCplanDao.deleteByPolicyNo(policyNo);


        prpCitemKindAgriDao.deleteByPolicyNo(policyNo);
        prpCfeildDao.deleteByPolicyNo(policyNo);
        prpCrenewalDao.deleteByPolicyNo(policyNo);
        prpCplanCoinsDao.deleteByPolicyNo(policyNo);
        prpCcoinsDetailDao.deleteByPolicyNo(policyNo);
        prpCcoinsDao.deleteAllByCondition(policyNo);
        prpCexpenseDao.deleteAllByCondition(policyNo);
        if ("Y".equals(option)){
            prpCmainDao.deleteByPolicyNo(policyNo);
        }


    }
}
