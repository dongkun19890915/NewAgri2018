package com.sinosoft.agriclaim.core.compensatemanage.service;


import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLLossDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225 
 * @description 赔付标的信息表Core接口
 */
public interface PrpLLossService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLLossDto prpLLossDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String compensateNo,java.lang.Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLLossDto prpLLossDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLLossDto queryByPK(String compensateNo,java.lang.Integer serialNo);

    /**
     *
     * @description 根据业务号查询PrpLLoss表
     * @author 周柯宇
     * @date 2018年1月26日 下午3:49:27
     * @param businessNo
     * @return List<PrpLLossDto>
     * @Throws Exception
     */
    List<PrpLLossDto> queryByBusinessNo(String businessNo);
}