package com.sinosoft.agriclaim.core.individuation.service;



import com.sinosoft.agriclaim.api.individuation.dto.PrpLsumpayLogDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-22 08:23:52.676 
 * @description 支付信息轨迹表Core接口
 */
public interface PrpLsumpayLogService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLsumpayLogDto prpLsumpayLogDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String claimNo, String serialNo, String logNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLsumpayLogDto prpLsumpayLogDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLsumpayLogDto queryByPK(String claimNo, String serialNo, String logNo);
}