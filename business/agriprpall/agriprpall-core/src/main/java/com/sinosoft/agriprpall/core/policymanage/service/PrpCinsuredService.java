package com.sinosoft.agriprpall.core.policymanage.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpCPinsuredDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPinsuredDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCinsuredDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;

import java.util.List;

/**
 * *PrpCinsured表的Core接口
 * @Author: 田慧
 * @Date: 2017/11/20 16:22
 */

public interface PrpCinsuredService {
    /**
     *   根据保单号查询prpCinsured 投保人被保险人关系表信息
     * @author: 田慧
     * @date: 2017/11/20 16:19
     * @param policyNo 保单号
     * @return prpCinsuredDtoList 返回prpCinsuredDto的集合
     * @throws Exception
     */
    public List<PrpCinsuredDto> queryByPolicyNo(String policyNo)throws Exception;
    /**
     *@description 按主键查询实体
     *@param
     */
    public PrpCinsuredDto queryByPK(String policyNo, Integer serialNo);
    /**
     *  根据保单号、关系人标识查询prpCinsured 投保人被保险人关系表信息
     * @author: 田慧
     * @date: 2017/11/20 16:51
     * @param policyNo 保单号
     * @param insuredFlag  关系人标识
     * @return prpCinsuredDtoList 返回投保人被保险人关系表Dto的集合
     * @throws Exception
     */
    public List<PrpCinsuredDto> queryByCondition(String policyNo,String insuredFlag)throws Exception;
    /**
     *  根据身份证查询PrpCinsuredDto 投保人被保险人关系表Dto结果集
     * @author: 田慧
     * @date: 2017/11/22 10:20
     * @param policyNo 保单号
     * @param identifyNumber 身份证件号
     * @return 返回prpCinsuredDtoList 投保人被保险人关系表Dto的集合
     */
    public List<PrpCinsuredDto> queryPolicyNoByID(String policyNo, String identifyNumber)throws Exception;

    /**
     * P表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpPinsuredDto
     * @return PrpCinduredDto
     * @throws Exception
     */
    public PrpCinsuredDto PEvaluateC(PrpPinsuredDto prpPinsuredDto) throws Exception;

    /**
     * CP表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpCPinsuredDto
     * @return PrpCindured
     * @throws Exception
     */
    public PrpCinsuredDto generatePrpCinsured(PrpCPinsuredDto prpCPinsuredDto) throws Exception;

    public List<PrpCmainDto> queryPolicyById(String identifyNumber) throws Exception;

    /**
     * （查询被保险人代码）
     * @author: 王志文
     * @date: 2018/3/31 18:14
     * @param
     * @return
     * @throws Exception
     */
    List<PrpCinsuredDto> queryInsuredCodeByPolicyNoAndInsuredName(String policyNo)throws Exception;


    /**
     * 根据被保险人代码查询被保险人信息
     * @author: 王志文
     * @date: 2018/3/31 18:14
     * @param map
     * @return
     * @throws Exception
     */
    List<PrpCinsuredDto> queryByInsuredCode(String insuredCode) throws Exception;

}
