package com.sinosoft.pms.core.kernel.service;


import com.sinosoft.pms.api.kernel.dto.PrpDclauseCodeKindDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-07 03:36:19.515 
 * @description 条款险别配置表Core接口
 */
public interface PrpDclauseCodeKindService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDclauseCodeKindDto prpDclauseCodeKindDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String clauseCode,java.lang.Double serialNo,String kindCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDclauseCodeKindDto prpDclauseCodeKindDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDclauseCodeKindDto queryByPK(String clauseCode,java.lang.Double serialNo,String kindCode);
    /**
     * 根据clauseCode条款代码和calculateFlag主险标识代码查询险别
     * @author: 田慧
     * @date: 2017/12/14 14:16
     * @param clauseCode 条款代码
     * @param calculateFlag 主险标识：1-主险，2-附加险
     * @return kindCode的集合
     * @throws Exception
     */
   List<String> queryKindCodeByClauseCode(String clauseCode,String calculateFlag)throws Exception;
    /**
     *  根据clauseCode条款代码和kindCode险别代码查询标的
     * @author: 田慧
     * @date: 2017/12/16 10:38
     * @param clauseCode 条款代码
     * @param kindCode 险别代码
     * @return itemCode的集合
     * @throws Exception
     */
    List<String> queryItemCodeByClauseCodeAndKindCode(String clauseCode,String kindCode) throws Exception;
    /**
     * 根据条款代码查询条款险别配置
     * @author: 宋振振
     * @date: 2018/4/14 14:20
     * @param clauseCode
     * @return  List<PrpDclauseCodeKindDto>
     */
    public List<PrpDclauseCodeKindDto> queryPrpDclauseCodeKindByClauseCode(String clauseCode)throws Exception;
}