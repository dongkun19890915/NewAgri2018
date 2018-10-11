package com.sinosoft.agriprpall.core.proposalmanage.service;


import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTfeildDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 01:57:51.087 
 * @description 大户田块信息Core接口
 */
public interface PrpTfeildService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpTfeildDto prpTfeildDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String proposalNo, String feildNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpTfeildDto prpTfeildDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpTfeildDto queryByPK(String proposalNo, String feildNo);
}