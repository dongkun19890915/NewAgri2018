package com.sinosoft.agriclaim.core.compensatemanage.service;


import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCTextDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225 
 * @description 赔款计算文字表Core接口
 */
public interface PrpLCTextService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLCTextDto prpLCTextDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String compensateNo,String textType,java.lang.Integer lineNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLCTextDto prpLCTextDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLCTextDto queryByPK(String compensateNo,String textType,java.lang.Integer lineNo);
}