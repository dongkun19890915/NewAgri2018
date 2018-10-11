package com.sinosoft.dms.core.paymanage.service;


import java.util.List;
import java.util.Map;

import com.sinosoft.dms.api.paymanage.dto.PrpDbankDto;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-02-13 03:08:45.046 
 * @description 银行定义表Core接口
 */
public interface PrpDbankService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDbankDto prpDBankDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String bankCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDbankDto prpDBankDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDbankDto queryByPK(String bankCode);

	List<PrpDbankDto> getBanklist(Map<String, String> map_banklist);
}