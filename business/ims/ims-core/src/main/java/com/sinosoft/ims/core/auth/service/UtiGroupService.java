package com.sinosoft.ims.core.auth.service;


import com.sinosoft.ims.api.auth.dto.AddCodePowerConditionDto;
import com.sinosoft.ims.api.auth.dto.SubComDto;
import com.sinosoft.ims.api.auth.dto.UtiGroupDto;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:45.148 
 * @description UtiGroupCore接口
 */
public interface UtiGroupService {

    /**
     *@description 新增
     *@param
     */
    void save(UtiGroupDto utiGroupDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String groupCode);
    /**
     *@description 修改
     *@param
     */
    void modify(UtiGroupDto utiGroupDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    UtiGroupDto queryByPK(String groupCode);
    /**
     *  获取权限查询条件service接口
     * @param addCodePowerConditionDto
     * @return String 返回权限查询条件的Sql字符串
     * @throws Exception
     * @author 李冬松
     * @date 11:29 2017/11/20
     */
    public String addCodePower(AddCodePowerConditionDto addCodePowerConditionDto)throws Exception;
    /**
    * 获取险种的权限service
    * @param addCodePowerConditionDto
    * @return java.lang.String 返回险种权限的SQL
    * @throws Exception
    * @author 李冬松
    * @date 16:45 2017/12/21
    */
    public String addRiskCodePermit(AddCodePowerConditionDto addCodePowerConditionDto)throws Exception;

    /**
     * 获取机构权限的list
     *
     * @param addCodePowerConditionDto
     * @return
     * @author: 何伟东
     * @date: 2018/1/5 16:02
     */
    List<String> getCodePowerList(AddCodePowerConditionDto addCodePowerConditionDto) throws Exception;

    /**
     * 获取子级机构信息
     *
     * @param param comCode-机构代码；userCode-用户代码
     * @return 所有子级机构信息
     * @author: 何伟东
     * @date: 2018/1/5 16:02
     */
    List<SubComDto> getSubComList(Map<String, String> param) throws Exception;
}