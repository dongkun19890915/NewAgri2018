package com.sinosoft.agriprpall.core.proposalmanage.service;


import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTmainSubDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 01:57:51.087 
 * @description 投保单隶属表Core接口
 */
public interface PrpTmainSubService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpTmainSubDto prpTmainSubDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String proposalNo, String mainPolicyNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpTmainSubDto prpTmainSubDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpTmainSubDto queryByPK(String proposalNo, String mainPolicyNo);
}