package com.sinosoft.agriprpall.core.policymanage.service.impl;


import com.sinosoft.agriprpall.api.policymanage.dto.PrpPolicyFeeNoticeDto;
import com.sinosoft.agriprpall.core.policymanage.service.PrpPolicyFeeNoticeService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * 保费缴款通知书信息表Dao数据操作对象
 *
 * @author: 钱浩
 * @date: 2017/12/6 下午 17:07
 */
@Service
public class PrpPolicyFeeNoticeServiceImpl extends BaseServiceImpl implements PrpPolicyFeeNoticeService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpPolicyFeeNoticeServiceImpl.class);
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * 缴费通知书号生成所用
     *
     * @param policyNo
     * @return
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/12/6 下午 17:22
     */
    public List<PrpPolicyFeeNoticeDto> queryByPolicyNo(String policyNo) throws Exception {
        if (StringUtils.isEmpty(policyNo)) {
            throw new DataVerifyException("保单号不能为空");
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append(" select p from PrpPolicyFeeNotice p where p.policyNo like :policyNo ORDER BY p.policyFeeNo DESC ");
        Query query = entityManager.createQuery(buffer.toString());
        query.setParameter("policyNo", policyNo + "%");
        List<PrpPolicyFeeNoticeDto> prpPolicyFeeNoticeDtoList = query.getResultList();
        return prpPolicyFeeNoticeDtoList;
    }
}