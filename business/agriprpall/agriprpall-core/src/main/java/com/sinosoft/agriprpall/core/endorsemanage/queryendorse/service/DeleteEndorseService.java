package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.DeleteEndorseRequestDto;

import java.util.HashMap;
import java.util.List;

public interface DeleteEndorseService {
    /**
     * 批单批量删除（先校验批单号，然后再删除相关的表的数据）
     * @author: 宋振振
     * @date: 2017/11/24 15:16
     * @param deleteEndorseRequestDto 批单批量删除请求
     * @return HashMap 返回删除成功或失败的信息
     * @throws Exception
     */
    public HashMap deleteEndorse(DeleteEndorseRequestDto deleteEndorseRequestDto) throws Exception;
    /**
     * 批单批量删除校验
     * @author: 宋振振
     * @date: 2017/11/24 15:19
     * @param deleteEndorseRequestDto 批单批量删除请求
     * @return HashMap 批单号集合
     * @throws Exception
     */
    public HashMap getEndorseNoMap(DeleteEndorseRequestDto deleteEndorseRequestDto) throws Exception;

    /**
     * 封装批单删除要删除的表
     * @author: 宋振振
     * @date: 2017/12/6 11:24
     * @param policyNo 保单号
     * @param endorseNo 批单号
     * @param strRiskCode 险种
     * @param endorList 批单号集合
     * @throws Exception
     */
    public void cancel(String policyNo, String endorseNo, String strRiskCode, List endorList,String plantingFarmerListFlag,String breedingFarmerListFlag,String nyxSingleFarmerListFlag,String nyxMultipleFarmerListFlag) throws Exception;
}
