package com.sinosoft.dms.core.customer.service;


import com.sinosoft.dms.api.customer.dto.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-09 11:34:12.554
 * @description 个人客户代码表Core接口
 */
public interface PrpDcustomerIdvService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDcustomerIdvDto prpDcustomerIdvDto);
    /**
     * 保存个体客户信息
     * @author: 田健
     * @date: 2017/12/28 11:01
     * @param prpDcustomerIdvDtos 个体客户信息集合
     */
    void saveByList(List<PrpDcustomerIdvDto> prpDcustomerIdvDtos);
    /**
     *@description 删除
     *@param
     */
    void remove(String customercode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDcustomerIdvDto prpDcustomerIdvDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    PrpDcustomerIdvDto queryByPK(String customercode);
    /**
     * @description:（查询个人客户风险等级信息）
     * @author: 董坤
     * @date: 2017/10/16 8:40
     * @param requestDto
     * @return List<PrpDCustomerIdvDto>
     */
    List<ResponseCustomerRiskLevelDto> queryRiskLevelByCondition(RequestDto requestDto) throws Exception;

    /**
     * @description:（保存数据）
     * @author: 董坤
     * @date: 2017/10/18 8:57
     * @param requestSaveDto
     * @return
     */
    String saveByCondition (RequestSaveDto requestSaveDto) throws Exception;

    /**
     * （根据条件查询客户列表信息）
     * @author: 赵鹏
     * @date: 2017/12/16 14:29
     * @param requestDto
     * @return List<ResponseCustomerRiskLevelDto>（要展示的客户列表信息）
     * @throws Exception
     */
      List<ResponseCustomerRiskLevelDto> queryAllUnitAndIdv(RequestUnitAndldvDto requestDto)throws Exception;

    /***
     * （保存客户风险等级数据）
     * @author: 赵鹏
     * @param requestSaveDto(要保存或更新的对象参数)
     * @return Map<String,String>
     * @throws Exception
     */
      Map<String,String> saveByCustomerRiskLevel(PrpDcustomerIdvAndUnitDto requestSaveDto)throws Exception;


    /**
     * 根据证件类型和证件号去基础表中查询是否有该大户的信息
     * @param identifyType
     * @param identifyNumber
     * @return
     * @throws Exception
     * @author: 王保良
     * @date: 2017/12/1 17:39
     */
    public List<PrpDcustomerIdvDto> queryPrpDcustomerByIndentity(String identifyType,String identifyNumber)throws Exception;

}