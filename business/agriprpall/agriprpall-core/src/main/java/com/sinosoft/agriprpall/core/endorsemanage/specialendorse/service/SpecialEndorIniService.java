package com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.RequestSpecialEndorseDto;

import java.util.List;

/**
 * 特殊批改初始化信息查询
 * @Author: ldd
 * @Date: 2018/1/9 18:50
 */
public interface SpecialEndorIniService {

    /**
     *  特殊批改初始化信息
     * @author: ldd
     * @date: 2018/1/9 17:47
     * @param requestSpecialEndorseDto 批单对象集合、批改条件对象合并大对象
     * @return
     */
    public RequestSpecialEndorseDto querySpecialEndorIni(RequestSpecialEndorseDto requestSpecialEndorseDto) throws Exception;

    /**
     *  获取保单中需要批改的交集信息
     * @author: ldd
     * @date: 2018/1/10 10:36
     * @param endorType 批改类型
     * @param policyNoList 保单号
     * @return
     * @throws Exception
     */
    public List queryRetainInfo(String endorType, List<String> policyNoList) throws Exception;
}
