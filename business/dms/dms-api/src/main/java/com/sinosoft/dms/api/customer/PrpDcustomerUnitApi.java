package com.sinosoft.dms.api.customer;

import com.sinosoft.dms.api.DMSConstant;
import com.sinosoft.dms.api.customer.dto.PrpDcustomerUnitDto;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-09 11:34:12.554 
 * @description 集体客户代码表Api接口
 */
@FeignClient(name = DMSConstant.DMS_SERVICE_NAME, path = PrpDcustomerUnitApi.PATH)
public interface PrpDcustomerUnitApi {

    public static final String PATH = "prpDcustomerUnit";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(@RequestBody PrpDcustomerUnitDto prpDcustomerUnitDto);

    /**
     * 保存集体客户信息
     * @author: 田健
     * @date: 2017/12/28 11:09
     * @param prpDcustomerUnitDtos 集体客户信息集合
     * @Return 返回成功
     */
    @RequestMapping(value = "saveByList",method = {RequestMethod.POST})
    String saveByList(@RequestBody List<PrpDcustomerUnitDto> prpDcustomerUnitDtos);
    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestParam("customercode") String customercode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(@RequestBody PrpDcustomerUnitDto prpDcustomerUnitDto);
    /**
     * （根据客户代码查询团体客户风险等级信息）
     * @author: 赵鹏
     * @date: 2017/12/17 13:22
     * @param customercode （客户代码）
     * @return PrpDcustomerUnitDto（客户风险等级信息列表）
     * @throws Exception
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpDcustomerUnitDto queryByPK(@RequestParam("customercode") String customercode);

    /**
     * （查询团体客户风险等级信息）
     * @author: 赵鹏
     * @date: 2017/12/17 13:22
     * @param prpDcustomerUnitDto （查询条件，客户类型，证件类型，证件号码）
     * @return PrpDcustomerUnitDto（客户风险等级信息 列表）
     * @throws Exception
     */
    @RequestMapping(value = "queryAllUnit",method = {RequestMethod.POST})
    PageInfo <PrpDcustomerUnitDto> queryAllUnit(@RequestBody PrpDcustomerUnitDto prpDcustomerUnitDto)throws Exception;

    @RequestMapping(value = "queryByInsureName",method = {RequestMethod.POST})
    public List<PrpDcustomerUnitDto> queryByInsureName(@RequestBody Map<String,String> map)throws Exception;

}