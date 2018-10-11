package com.sinosoft.dms.core.customer.service;


import com.sinosoft.dms.api.customer.dto.PrpDcustomerUnitDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-09 11:34:12.554 
 * @description 集体客户代码表Core接口
 */
public interface PrpDcustomerUnitService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpDcustomerUnitDto prpDcustomerUnitDto);
    /**
     * 保存集体客户信息
     * @author: 田健
     * @date: 2017/12/28 11:09
     * @param prpDcustomerUnitDtos 集体客户信息集合
     */
    void saveByList(List<PrpDcustomerUnitDto> prpDcustomerUnitDtos);
    /**
     *@description 删除
     *@param
     */
    void remove(String customercode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpDcustomerUnitDto prpDcustomerUnitDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpDcustomerUnitDto queryByPK(String customercode);

    /**
     * （查询团体客户风险等级信息）
     * @author: 赵鹏
     * @date: 2017/12/17 13:22
     * @param prpDcustomerUnitDto （查询条件，客户类型，证件类型，证件号码）
     * @return PrpDcustomerUnitDto（客户风险等级信息 列表）
     * @throws Exception
     */
    PageInfo<PrpDcustomerUnitDto> queryAllUnit(PrpDcustomerUnitDto prpDcustomerUnitDto);


    public List<PrpDcustomerUnitDto> queryByInsureName(String insureName);
}