package com.sinosoft.agriclaim.core.checkmanage.service;


import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLCheckLossDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:38:49.324 
 * @description 查勘事故估损金额表Core接口
 */
public interface PrpLCheckLossService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLCheckLossDto prpLCheckLossDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String registNo,java.lang.Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLCheckLossDto prpLCheckLossDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLCheckLossDto queryByPK(String registNo,java.lang.Integer serialNo);
    /**
     * @description:方法功能简述:根据报案号查询估损金额信息
     * @author chong
     * @date 2017年11月9日下午4:50:01
     * @param registNo 报案号
     * @return checkLossDtoList
     */
    List<PrpLCheckLossDto> queryByRegistNo(String registNo);
}