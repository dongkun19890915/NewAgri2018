package com.sinosoft.dms.web.customer;

import com.sinosoft.dms.api.customer.PrpDcustomerTaxPayInfoApi;
import com.sinosoft.dms.api.customer.dto.PrpDcustomerRequestDto;
import com.sinosoft.dms.api.customer.dto.PrpDcustomerResponseDto;
import com.sinosoft.dms.api.customer.dto.PrpDcustomerTaxPayInfoDto;
import com.sinosoft.dms.core.customer.service.PrpDcustomerTaxPayInfoService;
import com.sinosoft.framework.dto.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 客户纳税人信息表controller层
 * @Author: 宋振振
 * @Date: 21:15 2017/10/17
 */
@RestController
@RequestMapping(value = PrpDcustomerTaxPayInfoController.PATH)
public class PrpDcustomerTaxPayInfoController implements PrpDcustomerTaxPayInfoApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDcustomerTaxPayInfoController.class);

    @Autowired
    private PrpDcustomerTaxPayInfoService prpDcustomerTaxPayInfoService;

    /**
     *  保存发票信息
     * @author: 田健
     * @date: 2017/12/28 11:28
     * @param PrpDcustomerTaxPayInfoDto 发票信息dto
     * @return
     */
    @Override
    public String save(@RequestBody PrpDcustomerTaxPayInfoDto PrpDcustomerTaxPayInfoDto) {
        prpDcustomerTaxPayInfoService.save(PrpDcustomerTaxPayInfoDto);
        return "Success";
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String customerCode) {
        prpDcustomerTaxPayInfoService.remove(customerCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpDcustomerTaxPayInfoDto prpDcustomerTaxPayInfoDto) {
        prpDcustomerTaxPayInfoService.modify(prpDcustomerTaxPayInfoDto);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    public @ResponseBody PrpDcustomerTaxPayInfoDto queryByPK(@RequestParam("customerCode") String customerCode) {
        return prpDcustomerTaxPayInfoService.queryByPK(customerCode);
    }
    /**
     * 根据条件查询发票购货方信息
     * @author: 宋振振
     * @date: 2017/10/17 21:15
     * @param prpDcustomerRequestDto 查询发票购货方请求参数的Dto
     * @return PrpDcustomerResponseDto 返回客户信息
     * @throws Exception
     */
    public @ResponseBody
    PrpDcustomerResponseDto queryPayInfo(@RequestBody PrpDcustomerRequestDto prpDcustomerRequestDto) throws Exception{
        return prpDcustomerTaxPayInfoService.queryPayInfo(prpDcustomerRequestDto);
    }
}
