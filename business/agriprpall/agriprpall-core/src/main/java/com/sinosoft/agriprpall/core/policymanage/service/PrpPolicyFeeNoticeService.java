package com.sinosoft.agriprpall.core.policymanage.service;


import com.sinosoft.agriprpall.api.policymanage.dto.PrpPolicyFeeNoticeDto;

import java.util.List;

/**
 * 保费缴款通知书信息表Dao数据操作对象
 *
 * @author: 钱浩
 * @date: 2017/12/6 下午 17:07
 */
public interface PrpPolicyFeeNoticeService {
    /**
     * 缴费通知书号生成所用
     *
     * @param policyNo
     * @return
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/12/6 下午 17:22
     */
    public List<PrpPolicyFeeNoticeDto> queryByPolicyNo(String policyNo) throws Exception;
}