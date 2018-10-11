package com.sinosoft.agriprpall.core.proposalmanage.service;


import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTcoinsDetailDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-21 05:54:45.680 
 * @description 共保明细信息表Core接口
 */
public interface PrpTcoinsDetailService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpTcoinsDetailDto prpTcoinsDetailDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String proposalNo, Integer serialNo, String currency);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpTcoinsDetailDto prpTcoinsDetailDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpTcoinsDetailDto queryByPK(String proposalNo, Integer serialNo, String currency);
}