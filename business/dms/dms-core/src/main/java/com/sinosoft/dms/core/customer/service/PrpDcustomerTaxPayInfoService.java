package com.sinosoft.dms.core.customer.service;

import com.sinosoft.dms.api.customer.dto.PrpDcustomerRequestDto;
import com.sinosoft.dms.api.customer.dto.PrpDcustomerResponseDto;
import com.sinosoft.dms.api.customer.dto.PrpDcustomerTaxPayInfoDto;

/**
 * @Description: 客户纳税人信息表Core接口
 * @Author: 宋振振
 * @Date: 21:15 2017/10/17
 */
public interface PrpDcustomerTaxPayInfoService {
    /**
     *  保存发票信息
     * @author: 田健
     * @date: 2017/12/28 11:28
     * @param prpDcustomerTaxPayInfoDto 发票信息dto
     */
    void save(PrpDcustomerTaxPayInfoDto prpDcustomerTaxPayInfoDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String customerCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDcustomerTaxPayInfoDto prpDcustomerTaxPayInfoDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    public PrpDcustomerTaxPayInfoDto queryByPK(String customerCode);
    /**
     * 根据条件查询发票购货方信息
     * @author: 宋振振
     * @date: 2017/10/17 21:15
     * @param prpDcustomerRequestDto 查询发票购货方请求参数的Dto
     * @return PrpDcustomerResponseDto 返回客户信息
     * @throws Exception
     */
    public PrpDcustomerResponseDto queryPayInfo(PrpDcustomerRequestDto prpDcustomerRequestDto)throws Exception;
}