package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.PrpPmainDao;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.CheckStatusService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * (查询是否有效的批单的接口实现类）
 * @author 王保良
 * @date 2017年11月10日
 */
@Service
public class CheckStatusServiceImpl extends BaseServiceImpl implements CheckStatusService {
    @Autowired
    private PrpPmainDao prpPmainDao;

    /**
     * 根据保单号查询是否有有效批单
     * @param policyNo 保单号
     * @return status 标示了查询结果,有或者无有效的批单 并封装进responseDto中
     * @author 王保良
     * @date 2017年10月28日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer checkStatus(String policyNo)throws Exception{
        if (StringUtils.isEmpty(policyNo)){
            throw new Exception("保单号不能为空");
        }
        Integer status;
        int i=prpPmainDao.findAllByPolicyNoAndUnderwriteFlag(policyNo);
        if (i==0){
            status=0;
        }
        else {
            status=1;
        }
        return status;
    }
}
