package com.sinosoft.dms.core.dict.service;

import java.util.List;

import com.sinosoft.dms.api.dict.dto.PrpDcodeRiskDto;

/**
 * 特约及附加信息查询Service层接口
 * @Author: 王保良
 * @Date: 2017/11/17 10:53
 */
public interface PrpDcodeRiskService {

    /**
     * 根据险种代码查询CodeCode
     * @author 王保良
     * @param riskCode (险种代码)
     * @return List<String> codeCode的集合
     * @time 2017-11-17
     * @throws Exception
     */
    public List<String> queryCodeCode(String riskCode) throws Exception;
    /**
     * @description:方法功能简述: 根据riskCode 和codeType查询返回结果集
     * @author chong
     * @date 2017年11月10日下午4:09:34
     * @param riskCode 险种编码
     * @param codeType 代码类型
     * @return codeRiskDtoList
     */
	public List<PrpDcodeRiskDto> queryByCodesAndType(String riskCodes, String codeType);
}
