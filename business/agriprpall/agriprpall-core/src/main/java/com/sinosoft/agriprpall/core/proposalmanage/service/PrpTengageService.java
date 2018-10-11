package com.sinosoft.agriprpall.core.proposalmanage.service;


import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTengageDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail yanghang@sinosoft.com.cn
 * @time  2017-10-19 06:31:19.937 
 * @description 特别约定表Core接口
 */
public interface PrpTengageService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpTengageDto prpTengageDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String proposalNo, Integer serialNo, Integer lineno);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpTengageDto prpTengageDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpTengageDto queryByPK(String proposalNo, Integer serialNo, Integer lineno);
}