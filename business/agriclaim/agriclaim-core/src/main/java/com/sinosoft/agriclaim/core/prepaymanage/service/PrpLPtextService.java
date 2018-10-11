package com.sinosoft.agriclaim.core.prepaymanage.service;


import com.sinosoft.agriclaim.api.prepaymanage.dto.PrpLPtextDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:44:02.119 
 * @description 预赔文字表Core接口
 */
public interface PrpLPtextService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLPtextDto prpLPtextDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String preCompensateNo,java.lang.Double lineNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLPtextDto prpLPtextDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLPtextDto queryByPK(String preCompensateNo,java.lang.Double lineNo);
}