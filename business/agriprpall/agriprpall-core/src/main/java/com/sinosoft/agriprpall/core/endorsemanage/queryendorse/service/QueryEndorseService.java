package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.RequestShowPrPoEnDto;

/**
 * 批单明细信息查询服务
 * @author 王保良
 * @date 2017年11月28日
 */
public interface QueryEndorseService {
    /**
     * 寻找所查询批单保单信息及批改前的信息(供下面的queryEndorseDetail方法调用)
     * @param endorseNo 批单号
     * @return PolicyEndorseDto(包含保单信息及批改前的信息)
     * @author 王保良
     * @throws  Exception
     * @date 2017年11月28日
     */
    public PolicyEndorseDto queryEndorseInfo(String endorseNo) throws Exception;

    /**
     * 根据业务类型BizType寻找所查询批单保单信息及批改前的信息
     * @param requestShowPrPoEnDto (包含BizNo业务号,BizType业务类型,familyNo 分户号,damageDate 出险日期)
     * @return PolicyEndorseDto(包含保单信息及批改前的信息)
     * @author 王保良
     * @throws  Exception
     * @date 2017年11月28日
     */
    public PolicyEndorseDto queryEndorseDetail(RequestShowPrPoEnDto requestShowPrPoEnDto) throws Exception;
}
