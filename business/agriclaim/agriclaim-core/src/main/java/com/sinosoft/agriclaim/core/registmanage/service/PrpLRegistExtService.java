package com.sinosoft.agriclaim.core.registmanage.service;


import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistExtDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:45:22.527 
 * @description 报案信息补充说明Core接口
 */
public interface PrpLRegistExtService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLRegistExtDto prpLRegistExtDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String registNo,java.lang.Integer serialNo,String nodeType);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLRegistExtDto prpLRegistExtDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLRegistExtDto queryByPK(String registNo,java.lang.Integer serialNo,String nodeType);
    /**
     * @description:方法功能简述: 通过报案号查询集合
     * @author 安齐崇
     * @date 2017年11月10日下午4:45:37
     * @param registNo 报案号
     * @return registExtDtoList
     */
    List<PrpLRegistExtDto> queryByRegistNo(String registNo);
}