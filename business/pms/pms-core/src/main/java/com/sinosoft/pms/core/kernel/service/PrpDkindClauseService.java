package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.pms.api.kernel.dto.PrpDkindClauseDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * @description PrpDkindClauseCore接口
 */
public interface PrpDkindClauseService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDkindClauseDto prpDkindClauseDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String riskCode, String clauseFlag, String kindCode, String language, String clauseCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDkindClauseDto prpDkindClauseDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDkindClauseDto queryByPK(String riskCode, String clauseFlag, String kindCode, String language, String clauseCode);
    /**
     * 根据险种代码查询条款代码集合
     * @param riskCode 险种代码
     * @return List<String> 条款代码集合
     * @throws Exception
     */
    public List<String> queryClauseCode(String riskCode)throws Exception;
}