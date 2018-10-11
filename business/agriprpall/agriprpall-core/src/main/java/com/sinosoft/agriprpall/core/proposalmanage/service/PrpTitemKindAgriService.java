package com.sinosoft.agriprpall.core.proposalmanage.service;


import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTitemKindAgriDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 08:03:36.446 
 * @description 农险标的信息表Core接口
 */
public interface PrpTitemKindAgriService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpTitemKindAgriDto prpTitemKindAgriDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String proposalNo, Integer itemKindNo, String kindCode, Integer times);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpTitemKindAgriDto prpTitemKindAgriDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpTitemKindAgriDto queryByPK(String proposalNo, Integer itemKindNo, String kindCode, Integer times);
}