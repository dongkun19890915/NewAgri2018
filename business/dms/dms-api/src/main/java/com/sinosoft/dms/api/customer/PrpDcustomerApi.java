package com.sinosoft.dms.api.customer;

import com.sinosoft.dms.api.DMSConstant;
import com.sinosoft.dms.api.customer.dto.*;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 01:57:51.087 
 * @description 客户信息表Api接口
 */
@FeignClient(name = DMSConstant.DMS_SERVICE_NAME, path = PrpDcustomerApi.PATH)
public interface PrpDcustomerApi {

    public static final String PATH = "prpDcustomer";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(@RequestBody PrpDcustomerDto prpDcustomerDto);

    /**
     *  批量保存客户信息主表（国元应该只有一个客户信息，信达可能有多个）
     * @author: 田健
     * @date: 2017/12/28 10:53
     * @param prpDcustomerDtos 客户主表信息集合
     * @Return 返回成功
     */
    @RequestMapping(value = "saveByList",method = {RequestMethod.POST})
    String saveByList(@RequestBody List<PrpDcustomerDto> prpDcustomerDtos);
    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestParam("customerCode") String customerCode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(@RequestBody PrpDcustomerDto prpDcustomerDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    @ResponseBody PrpDcustomerDto queryByPK(@RequestParam("customerCode") String customerCode);

    /**
     *  个体客户根据证件号查询 暂不使用
     * @author: 钱浩
     * @date: 2017/10/13 18:39
     * @param identifyNumber 证件号码
     * @param pageNo     页码
     * @param pageSize   条数
     * @return ResponseDto ：PageInfo<PrpDcustomerIdvDto>  大对象
     * @throws Exception
     */
    @RequestMapping(value = "queryPrpDcustomerIdvByCondition",method = {RequestMethod.POST})
    public @ResponseBody
    ResponseDto queryPrpDcustomerIdvByCondition(@RequestParam("identifyNumber") String identifyNumber, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize)throws Exception;

    /**
     *   集体客户根据号查询 暂不使用
     * @author: 钱浩
     * @date: 2017/11/1 15:29
     * @param socialCode 机构代码
     * @param pageNo     页码
     * @param pageSize   条数
     * @return ResponseDto ： PageInfo<PrpDcustomerUnitDto>对象
     * @throws Exception
     */
    @RequestMapping(value = "queryPrpDcustomerUnitByCondition",method = {RequestMethod.POST})
    public @ResponseBody ResponseDto queryPrpDcustomerUnitByCondition(@RequestParam("socialCode") String socialCode,@RequestParam("pageNo")  Integer pageNo,@RequestParam("pageSize")  Integer pageSize)throws Exception;
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
    @RequestMapping(value = "saveCustomerInfo", method = RequestMethod.POST)
    public @ResponseBody
    Map<String,String> saveCustomerInfo(@RequestBody PrpDcustomerSaveDto prpDcustomerSaveDto) throws  Exception;

    /**
     * 客户查询接口
     *
     * @param customerInfoDto 入参Dto
     * @return
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/11/16 12:01
     */
    @RequestMapping(value = "queryCustomerInfo", method = RequestMethod.POST)
    public @ResponseBody PageInfo<RCustomerInfoDto> queryCustomerInfo(@RequestBody CustomerInfoDto customerInfoDto) throws Exception;

    /**
     *  按照条件查询PrpDcustomerUnitDto集体客户代码表信息和PrpDcustomerIdvDto个人客户代码表信息
     *  如果客户类型customerType为1，查询PrpDcustomerIdvDto个人客户代码表信息，否则查询PrpDcustomerUnitDto集体客户代码表信息
     * @author: 田慧
     * @date: 2017/12/4 15:07
     * @param queryCustomerInfoByConditionDto customerType客户类型、identifyNumber证件号码、socialcode1:组织机构代码 2:统一社会信用代码'、customerCName客户中文名称、
     *         customerCode客户代码、startupdatedate endupdatedate维护日期、username员工名称
     * @return  返回PrpDcustomerUnitDto集合或者PrpDcustomerIdvDto集合
     * @throws Exception
     */
    @RequestMapping(value = "queryCustomerInfoByCondition", method = RequestMethod.POST)
    public PageInfo queryCustomerInfoByCondition(@RequestBody QueryCustomerInfoByConditionDto queryCustomerInfoByConditionDto) throws Exception;

    /**
     * 根据客户中文名称查询 prpdcustomerunit集体客户代码表信息
     * @param queryCustomerInfoDto 自己定义的Dto 包括客户中文名称customerCName、客户类型customerType
     * @return 返回pageInfo 分页信息
     * @throws Exception
     * @author: 田慧
     * @date: 2017/12/1 17:39
     */
    @RequestMapping(value = "queryByCondition",method = {RequestMethod.POST})
    public PageInfo queryByCondition(@RequestBody QueryCustomerInfoDto queryCustomerInfoDto) throws Exception;

    /**
     * 根据散户名称去基础表中查询是否有该散户的信息
     * @param
     * @return
     * @throws Exception
     * @author: 王保良
     * @date: 2017/12/1 17:39
     */
    @RequestMapping(value = "queryPrpDcustomerByInsureName",method = RequestMethod.POST)
    public List<PrpDcustomerDto> queryPrpDcustomerByInsureName(@RequestBody Map<String,String> map)throws Exception;

}