package com.sinosoft.agriclaim.core.businessutilmanage.service;


import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLCfeecoinsDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * @description 共保费用信息表（无表名）Core接口
 */
public interface PrpLCfeecoinsService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLCfeecoinsDto prpLCfeecoinsDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String businessNo,java.lang.Double serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLCfeecoinsDto prpLCfeecoinsDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLCfeecoinsDto queryByPK(String businessNo,java.lang.Double serialNo);

    /**
     * @description 共保费用信息表查询
     * @param xml 入参报文
     * @return returnXml 反参报文
     * @throws Exception
     * @author 周柯宇
     * @date 2017-12-8 18:43:36
     */
    List<PrpLCfeecoinsDto> queryByBusinessNo(String businessNo)throws Exception;
}