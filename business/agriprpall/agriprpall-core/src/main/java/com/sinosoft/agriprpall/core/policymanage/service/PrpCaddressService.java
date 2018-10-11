package com.sinosoft.agriprpall.core.policymanage.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpCPaddressDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPaddressDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpAddressRespDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCaddressDto;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCaddress;
import com.sinosoft.framework.dto.ResponseDto;

/**
 * 保单保险地址表Core接口
 * @Author: 宋振振
 * @Date: 9:00 2017/10/17
 */
public interface PrpCaddressService {
    /**
     *@description 新增
     *@param
     */
    void save(PrpCaddressDto prpCaddressDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String policyNo,java.lang.Integer addressNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpCaddressDto prpCaddressDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    PrpCaddressDto queryByPK(String policyNo, java.lang.Integer addressNo);
    /**
     * 根据投保单号或保单号查询标的地址打印信息
     * @author: 宋振振
     * @date: 2017/10/17 9:00
     * @param  bizType 保单类型（PROPOSAL或POLICY）
     * @param bizNo 数据号（投保单号或保单号）
     * @return PrpAddressRespDto 返回标的地址打印信息
     * @throws Exception
     */
    public PrpAddressRespDto queryPrpaddressPrintByCondition(String bizType, String bizNo) throws Exception;

    /**
     * P表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpPaddressDto
     * @return PrpCaddressDto
     * @throws Exception
     */
    public PrpCaddressDto PEvaluateC(PrpPaddressDto prpPaddressDto) throws Exception;

    /**
     * CP表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpCPaddressDto
     * @return PrpCaddressDto
     * @throws Exception
     */
    public PrpCaddressDto generatePrpCaddress(PrpCPaddressDto prpCPaddressDto) throws Exception;
}