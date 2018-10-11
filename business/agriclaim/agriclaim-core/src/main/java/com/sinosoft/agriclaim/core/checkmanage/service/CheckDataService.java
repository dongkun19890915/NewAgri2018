package com.sinosoft.agriclaim.core.checkmanage.service;

import com.sinosoft.agriclaim.api.checkmanage.dto.CheckDto;
import com.sinosoft.agriclaim.api.docmanage.dto.CertifyDto;

/**
 * @description: 类功能简述：此service用于查询CheckDto,CertifyDto 大对象
 * @author chong
 * @date 2017年11月9日下午2:53:51
 */
public interface CheckDataService {
	
    /**
     * @description:方法功能简述:根据报案号查询查勘大对象 
     * @author chong
     * @date 2017年11月9日下午2:56:35
     * @param registNo 报案号
     * @return checkDto 查勘大对象
    */
    CheckDto findCheckDtoByRegistNo(String registNo);
    /**
     * @description:方法功能简述: 
     * @author chong
     * @date 2017年11月9日下午2:56:35
     * @param registNo 报案号
     * @return certifyDto 单证相关大对象
    */
    CertifyDto findCertifyDtoByRegistNo(String registNo);
}
