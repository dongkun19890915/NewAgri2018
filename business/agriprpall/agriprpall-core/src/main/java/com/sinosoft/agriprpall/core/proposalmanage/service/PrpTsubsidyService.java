package com.sinosoft.agriprpall.core.proposalmanage.service;


import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTsubsidyDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 01:57:51.087 
 * @description 补贴表Core接口
 */
public interface PrpTsubsidyService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpTsubsidyDto prpTsubsidyDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String proposalNo, String subsidyCode, String subsidyType);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpTsubsidyDto prpTsubsidyDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpTsubsidyDto queryByPK(String proposalNo, String subsidyCode, String subsidyType);
}