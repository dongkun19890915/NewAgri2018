package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto.PrpDkindClauseAgriDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * @description PrpDkindClauseCore接口
 */
public interface PrpDkindClauseAgriService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDkindClauseAgriDto prpDkindClauseAgriDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String riskCode, String clauseFlag, String kindCode, String language, String clauseCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDkindClauseAgriDto prpDkindClauseAgriDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDkindClauseAgriDto queryByPK(String riskCode, String clauseFlag, String kindCode, String language, String clauseCode);
    /**
     * 根据险种代码查询条款代码集合
     * @param riskCode 险种代码
     * @return List<String> 条款代码集合
     * @throws Exception
     */
    public List<String> queryClauseCode(String riskCode)throws Exception;

}