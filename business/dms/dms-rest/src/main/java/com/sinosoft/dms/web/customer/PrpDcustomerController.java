package com.sinosoft.dms.web.customer;

import com.sinosoft.dms.api.customer.PrpDcustomerApi;
import com.sinosoft.dms.api.customer.dto.*;
import com.sinosoft.dms.core.customer.service.PrpDcustomerService;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.framework.exception.DataVerifyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 01:57:51.087 
 * @description 客户信息表controller层
 */
@RestController
@RequestMapping(value = PrpDcustomerController.PATH)
public class PrpDcustomerController implements PrpDcustomerApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDcustomerController.class);

    @Autowired
    private PrpDcustomerService prpDcustomerService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpDcustomerDto prpDcustomerDto) {
        prpDcustomerService.save(prpDcustomerDto);
    }

    /**
     *  批量保存客户信息主表（国元应该只有一个客户信息，信达可能有多个）
     * @author: 田健
     * @date: 2017/12/28 10:53
     * @param prpDcustomerDtos 客户主表信息集合
     * @Return 返回成功
     */
    @Override
    public String saveByList(@RequestBody List<PrpDcustomerDto> prpDcustomerDtos) {
        prpDcustomerService.saveByList(prpDcustomerDtos);
        return "Success";
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestParam("customerCode") String customerCode) {
        prpDcustomerService.remove(customerCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpDcustomerDto prpDcustomerDto) {
        prpDcustomerService.modify(prpDcustomerDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public @ResponseBody PrpDcustomerDto queryByPK(@RequestParam("customerCode") String customerCode) {
        return prpDcustomerService.queryByPK(customerCode);
    }
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
    public @ResponseBody
    ResponseDto queryPrpDcustomerIdvByCondition(@RequestParam("identifyNumber") String identifyNumber, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize)throws Exception{
        return ResponseDto.instance(prpDcustomerService.queryPrpDcustomerIdvByCondition(identifyNumber, pageNo, pageSize));
    }

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
    public @ResponseBody ResponseDto queryPrpDcustomerUnitByCondition(@RequestParam("socialCode") String socialCode,@RequestParam("pageNo")  Integer pageNo,@RequestParam("pageSize")  Integer pageSize)throws Exception{
        return ResponseDto.instance(prpDcustomerService.queryPrpDcustomerUnitByCondition(socialCode, pageNo, pageSize));
    }
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
    public @ResponseBody
    Map<String,String> saveCustomerInfo(@RequestBody PrpDcustomerSaveDto prpDcustomerSaveDto) throws  Exception{
        return prpDcustomerService.saveCustomerInfo(prpDcustomerSaveDto);
    }
    /**
     * 客户查询接口
     *
     * @param customerInfoDto 入参Dto
     * @return
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/11/16 12:01
     */
    public @ResponseBody
    PageInfo<RCustomerInfoDto> queryCustomerInfo(@RequestBody CustomerInfoDto customerInfoDto) throws Exception{
             return prpDcustomerService.queryCustomerInfo(customerInfoDto);
    }

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
    @Override
    public PageInfo queryCustomerInfoByCondition(@RequestBody QueryCustomerInfoByConditionDto queryCustomerInfoByConditionDto) throws Exception{
        if (StringUtils.isEmpty(queryCustomerInfoByConditionDto.getCustomerType())){
            throw new DataVerifyException("客户类型不能为空！");
        }
        if ("1".equals(queryCustomerInfoByConditionDto.getCustomerType())){
            return prpDcustomerService.queryPrpDcustomerIdvInfoByCondition(queryCustomerInfoByConditionDto);
        }else{
            return prpDcustomerService.queryPrpDcustomerUnitInfoByCondition(queryCustomerInfoByConditionDto);
        }

    }

    /**
     * 根据客户中文名称查询 prpdcustomerunit集体客户代码表信息
     *
     * @param queryCustomerInfoDto 自己定义的Dto 包括客户中文名称customerCName、客户类型customerType
     * @return 返回pageInfo 分页信息
     * @throws Exception
     * @author: 田慧
     * @date: 2017/12/1 17:39
     */
    @Override
    public PageInfo queryByCondition(@RequestBody QueryCustomerInfoDto queryCustomerInfoDto) throws Exception{
        if (StringUtils.isEmpty(queryCustomerInfoDto.getCustomerType())){
            throw new DataVerifyException("客户类型不能为空!");
        }
        if (StringUtils.isEmpty(queryCustomerInfoDto.getCustomerCName())){
            throw new DataVerifyException("客户中文名称不能为空!");
        }
        if ("1".equals(queryCustomerInfoDto.getCustomerType())){
            return prpDcustomerService.queryPrpDcustomerIdvByCondition(queryCustomerInfoDto);
        }else{
            return prpDcustomerService.queryPrpDcustomerUnitByCondition(queryCustomerInfoDto);
        }

    }

    /**
     * 根据散户名称去基础表中查询是否有该散户的信息
     * @param
     * @return
     * @throws Exception
     * @author: 王保良
     * @date: 2017/12/1 17:39
     */
    @Override
    public List<PrpDcustomerDto> queryPrpDcustomerByInsureName(@RequestBody Map<String, String> map) throws Exception {
        return prpDcustomerService.queryPrpDcustomerByInsureName(map.get("insureName"));
    }
}
