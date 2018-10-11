package com.sinosoft.agriclaim.core.checkmanage.service;


import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLAcciCheckTextDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:38:49.324 
 * @description 调查文本信息表Core接口
 */
public interface PrpLAcciCheckTextService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLAcciCheckTextDto prpLAcciCheckTextDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String checkNo,String textType,java.lang.Integer lineNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLAcciCheckTextDto prpLAcciCheckTextDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLAcciCheckTextDto queryByPK(String checkNo,String textType,java.lang.Integer lineNo);
}