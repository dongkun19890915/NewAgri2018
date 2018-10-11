package com.sinosoft.agriclaim.core.checkmanage.service;


import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLCheckDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:38:49.324 
 * @description 查勘/代查勘信息表Core接口
 */
public interface PrpLCheckService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLCheckDto prpLCheckDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String registNo,java.lang.Integer referSerialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLCheckDto prpLCheckDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLCheckDto queryByPK(String registNo,java.lang.Integer referSerialNo);
    /**
     *@description 按报案号查询最大序列号
     *@param registNo 清单号
     *@return serialNo 最大序列号
     *@author 王心洋
     *@time 2018-01-18
     */
    public Integer queryMaxSerialByRegistNo(String registNo) throws Exception;
}