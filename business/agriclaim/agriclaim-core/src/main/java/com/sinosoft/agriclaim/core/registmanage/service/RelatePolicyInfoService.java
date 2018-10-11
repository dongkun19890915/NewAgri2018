package com.sinosoft.agriclaim.core.registmanage.service;

import java.util.Map;

import com.sinosoft.agriclaim.api.registmanage.dto.RelatePolicyInfoDto;

/**
 * @author 陈旭
 * @time  2017-11-14 15:38:49.324 
 * @description 保单关联信息Core接口
 */
public interface RelatePolicyInfoService {
    
    /**
      * @description 关联保单信息
      * @author 杨昆
      * @date 2017年12月20日 上午12:45:11
      * @param policyNoMap 保单号map
      * @return relatePolicyInfoDto 关联保单返参
     */ 
	RelatePolicyInfoDto showRelateInfo(Map<String, String>  policyNoMap) throws Exception;
    
}
