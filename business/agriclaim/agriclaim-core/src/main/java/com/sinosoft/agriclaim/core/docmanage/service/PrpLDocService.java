package com.sinosoft.agriclaim.core.docmanage.service;


import com.sinosoft.agriclaim.api.docmanage.dto.ClaimListDto;
import com.sinosoft.agriclaim.api.docmanage.dto.ClaimListRequestDto;
import com.sinosoft.agriclaim.api.docmanage.dto.PrpLDocDto;
import com.sinosoft.agriclaim.api.docmanage.dto.SaveCertifyDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:41:23.407 
 * @description 索赔单证信息表Core接口
 */
public interface PrpLDocService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLDocDto prpLDocDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String claimNo,String docCode);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLDocDto prpLDocDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLDocDto queryByPK(String claimNo,String docCode);
    /**
     * @description:方法功能简述:索赔清单查询服务
     * @author 安齐崇
     * @date 2017年11月13日下午1:55:28
     * @param requestDto 参数接收类
     * @return responseDto 组装数据类
     * @throws Exception
     */
    ClaimListDto findClaimList(ClaimListRequestDto requestDto) throws Exception;
    /**
     * @description:方法功能简述:索赔清单保存
     * @author 安齐崇
     * @date 2017年12月8日下午5:55:36
     * @param requestDto 请求参数
     * @return map 处理状态等信息
     */
    Map<String, String> saveCertify(SaveCertifyDto requestDto);
}