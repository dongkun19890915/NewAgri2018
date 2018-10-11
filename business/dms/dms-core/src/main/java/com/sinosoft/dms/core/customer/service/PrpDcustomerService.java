package com.sinosoft.dms.core.customer.service;


import com.sinosoft.dms.api.customer.dto.*;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 01:57:51.087 
 * @description 客户信息表Core接口
 */
public interface PrpDcustomerService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDcustomerDto prpDcustomerDto);
    /**
     *  批量保存客户信息主表（国元应该只有一个客户信息，信达可能有多个）
     * @author: 田健
     * @date: 2017/12/28 10:53
     * @param prpDcustomerDtos 客户主表信息集合
     */
    void saveByList(List<PrpDcustomerDto> prpDcustomerDtos);
    /**
     *@description 删除
     *@param
     */
    void remove(String customerCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDcustomerDto prpDcustomerDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDcustomerDto queryByPK(String customerCode);

    /**
     *  个体客户根据证件号查询
     * @author: 钱浩
     * @date: 2017/10/13 18:39
     * @param identifyNumber 证件号码
     * @param pageNo     页码
     * @param pageSize   条数
     * @return ResponseDto ：PageInfo<PrpDcustomerIdvDto>  大对象
     * @throws Exception
     */
    public PageInfo<PrpDcustomerIdvDto> queryPrpDcustomerIdvByCondition(String identifyNumber, Integer pageNo, Integer pageSize)throws Exception;
    /**
     *   集体客户根据号查询
     * @author: 钱浩
     * @date: 2017/11/1 15:29
     * @param socialCode 机构代码
     * @param pageNo     页码
     * @param pageSize   条数
     * @return ResponseDto ： PageInfo<PrpDcustomerUnitDto>对象
     * @throws Exception
     */
    public PageInfo<PrpDcustomerUnitDto> queryPrpDcustomerUnitByCondition(String socialCode, Integer pageNo, Integer pageSize)throws Exception;
    /**
     *  1.判断customerType为1走个体客户，否则集体客户
     * 2.风险轨迹表PrpDcustomLevelTrace保存
     * 3.客户纳税人信息表 prpDCustomerTaxPayInfo保存
     * @author: 钱浩
     * @date: 2017/10/21 15:00
     * @param prpDcustomerSaveDto 增加或者修改客户封装dto
     * @return ResponseDto： 成功或失败
     * @throws Exception
     */
    public Map<String,String> saveCustomerInfo(PrpDcustomerSaveDto prpDcustomerSaveDto) throws  Exception;

    /**
     * 客户查询接口
     * @author: 钱浩
     * @date: 2017/11/16 12:01
     * @param customerInfoDto  入参Dto
     * @return
     * @throws Exception
     */
    public PageInfo<RCustomerInfoDto> queryCustomerInfo(CustomerInfoDto customerInfoDto)throws Exception;

    /**
     *  按照条件查询PrpDcustomerIdvDto个人客户代码表信息
     * @author: 田慧
     * @date: 2017/12/4 15:07
     * @param queryCustomerInfoByConditionDto customerType客户类型、identifyNumber证件号码、customerCName客户中文名称、
     *         customerCode客户代码、startupdatedate endupdatedate维护日期、username员工名称
     * @return  返回PrpDcustomerIdvDto集合
     * @throws Exception
     */
    public PageInfo<PrpDcustomerIdvDto> queryPrpDcustomerIdvInfoByCondition (QueryCustomerInfoByConditionDto queryCustomerInfoByConditionDto) throws Exception;
    /**
     *  按照条件查询PrpDcustomerUnitDto集体客户代码表信息
     * @author: 田慧
     * @date: 2017/12/4 15:07
     * @param queryCustomerInfoByConditionDto customerType客户类型、socialcode1:组织机构代码 2:统一社会信用代码'、customerCName客户中文名称、
     *         customerCode客户代码、startupdatedate endupdatedate维护日期、username员工名称
     * @return  返回PrpDcustomerUnitDto集合
     * @throws Exception
     */
    public PageInfo<PrpDcustomerUnitDto> queryPrpDcustomerUnitInfoByCondition (QueryCustomerInfoByConditionDto queryCustomerInfoByConditionDto) throws Exception;

    /**
     * 根据客户中文名称查询prpDcustomerIdv 个人客户代码表信息
     *
     * @param queryCustomerInfoDto 客户中文名称customerCName、页码pageNo、每页大小pageSize
     * @return 返回pageInfo 分页信息
     * @throws Exception
     * @author: 田慧
     * @date: 2017/12/1 17:39
     */
    public PageInfo<PrpDcustomerIdvDto> queryPrpDcustomerIdvByCondition(QueryCustomerInfoDto queryCustomerInfoDto) throws Exception;
    /**
     * 根据客户中文名称查询 prpdcustomerunit集体客户代码表信息
     *
     * @param queryCustomerInfoDto 客户中文名称customerCName、页码pageNo、每页大小pageSize
     * @return 返回pageInfo 分页信息
     * @throws Exception
     * @author: 田慧
     * @date: 2017/12/1 17:39
     */
    public PageInfo<PrpDcustomerUnitDto> queryPrpDcustomerUnitByCondition(QueryCustomerInfoDto queryCustomerInfoDto) throws Exception;

    /**
     * 生成客户号
     *
     * @param iCustomerType 客户类型
     * @param iMakeCom
     * @return
     * @throws Exception
     * @author: 王保良
     * @date: 2017/10/20 19:36
     */
    public String apply(String iCustomerType, String iMakeCom) throws Exception;

    /**
     * 根据散户名称去基础表中查询是否有该散户的信息
     * @param
     * @return
     * @throws Exception
     * @author: 王保良
     * @date: 2017/12/1 17:39
     */
    public List<PrpDcustomerDto> queryPrpDcustomerByInsureName(String insureName) throws Exception;
}