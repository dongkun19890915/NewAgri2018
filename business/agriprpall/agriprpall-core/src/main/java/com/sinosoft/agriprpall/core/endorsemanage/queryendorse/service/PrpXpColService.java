package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service;



import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpXpColDto;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-06 06:23:40.452 
 * @description 批文数据字典表Core接口
 */
public interface PrpXpColService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpXpColDto prpXpColDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String riskCode, String tableName, Integer colSeq, Integer dispSeq);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpXpColDto prpXpColDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    PrpXpColDto queryByPK(String riskCode, String tableName, Integer colSeq, Integer dispSeq);
}