package com.sinosoft.agriclaim.core.claimmanage.service;


import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLLTextDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:39:53.061 
 * @description 立案文字表Core接口
 */
public interface PrpLLTextService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLLTextDto prpLLTextDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String claimNo,String textType,java.lang.Integer lineNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLLTextDto prpLLTextDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLLTextDto queryByPK(String claimNo,String textType,java.lang.Integer lineNo);

    /**
     * （理赔打印结案报告获取文本信息）
     * @author: 王志文
     * @date: 2017/11/30 17:15
     * @param claimNo
     * @param textType
     * @return
     */
    public List<PrpLLTextDto> queryListByClaimNoAndTextType(String claimNo, String textType);
}