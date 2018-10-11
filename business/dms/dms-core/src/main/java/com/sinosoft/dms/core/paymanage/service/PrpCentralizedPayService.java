package com.sinosoft.dms.core.paymanage.service;

import java.util.List;
import java.util.Map;

import com.sinosoft.dms.api.paymanage.dto.PrpCentralizedPayInfoDto;
import com.sinosoft.framework.dto.PageInfo;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-21 08:39:47.289 
 * @description PrpCentralizedPayInfoCore接口
 */
public interface PrpCentralizedPayService {
	
	/**
     *@description 新增
     *@param
     */
    void save(PrpCentralizedPayInfoDto prpCentralizedPayInfoDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String operateId);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpCentralizedPayInfoDto prpCentralizedPayInfoDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpCentralizedPayInfoDto queryByPK(String operateId);

}