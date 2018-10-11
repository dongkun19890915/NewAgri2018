package com.sinosoft.agriclaim.core.claimmanage.service;


import com.sinosoft.agriclaim.api.claimmanage.dto.ClaimDto1;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimLossDto;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:39:53.061 
 * @description 立案险别估损金额表Core接口
 */
public interface PrpLClaimLossService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLClaimLossDto prpLClaimLossDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String claimNo,java.lang.Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLClaimLossDto prpLClaimLossDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLClaimLossDto queryByPK(String claimNo,java.lang.Integer serialNo);

    /**
     *  根据立案号查询PrpLClaimLoss表信息
     * @author: 汪钊
     * @date: 2017/11/20 15:50
     * @param map 包括claimNo立案号
     * @return prpLClaimLossDtoList 返回PrpLClaimLossDto的集合
     */
    public List<PrpLClaimLossDto> queryByClaimNo(String claimNo);

    public String saveCLaimLoss( ClaimDto1 claimDto)throws Exception;
}