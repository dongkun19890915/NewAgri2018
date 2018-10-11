package com.sinosoft.dms.api.customer;

import com.sinosoft.dms.api.DMSConstant;
import com.sinosoft.dms.api.customer.dto.PrpDcustomerRequestDto;
import com.sinosoft.dms.api.customer.dto.PrpDcustomerResponseDto;
import com.sinosoft.dms.api.customer.dto.PrpDcustomerTaxPayInfoDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-17 13:04:37.553
 * @description 客户纳税人信息表Api接口
 */
@FeignClient(name = DMSConstant.DMS_SERVICE_NAME, path = PrpDcustomerTaxPayInfoApi.PATH)
public interface PrpDcustomerTaxPayInfoApi {

    public static final String PATH = "prpDcustomerTaxPayInfo";

    /**
     *  保存发票信息
     * @author: 田健
     * @date: 2017/12/28 11:28
     * @param prpDCustomerTaxPayInfoDto 发票信息dto
     * @return  返回成功
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    String save(@RequestBody PrpDcustomerTaxPayInfoDto prpDCustomerTaxPayInfoDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String customerCode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpDcustomerTaxPayInfoDto prpDCustomerTaxPayInfoDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    public @ResponseBody PrpDcustomerTaxPayInfoDto queryByPK(@RequestParam(value = "customerCode") String customerCode);
    /**
     * 根据条件查询发票购货方信息
     * @author: 宋振振
     * @date: 2017/10/17 21:15
     * @param prpDcustomerRequestDto 查询发票购货方请求参数的Dto
     * @return PrpDcustomerResponseDto 返回客户信息
     * @throws Exception
     */
    @RequestMapping(value = "queryPayInfo",method = {RequestMethod.POST})
    public @ResponseBody
    PrpDcustomerResponseDto queryPayInfo(@RequestBody PrpDcustomerRequestDto prpDcustomerRequestDto)throws Exception;
}