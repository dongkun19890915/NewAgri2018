package com.sinosoft.agriclaim.core.compensatemanage.service;


import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCompensateDto;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225 
 * @description 赔款计算书表Core接口
 */
public interface PrpLCompensateService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLCompensateDto prpLCompensateDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String compensateNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLCompensateDto prpLCompensateDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLCompensateDto queryByPK(String compensateNo);
    /**
     * 承保清单的下载
     * @author: 孙朋飞
     * @date: 2017/12/28 17:47
     * @param param 保单号
     * @return 下载链接
     * @throws Exception
     */
    public Map<String, String> expNyxPolicyList(Map<String, String> param) throws Exception;

    /**
     *  根据立案号查询prpTplan信息
     * @author: 周柯宇
     * @date: 2017-12-7 17:02:49
     * @param proposalNo 投保单号
     * @return prpLCompensateDtoList  返回赔款计算书表表Dto集合
     */
    public List<PrpLCompensateDto> queryClaimNo(String claimNo)  throws Exception;

    /**
     * （按险种代码查询理算数据）
     * @author: 王志文
     * @date: 2018/3/28 16:02
     * @param riskCode
     * @return
     * @throws Exception
     */
    List<PrpLCompensateDto> queryByRiskCode(String riskCode)throws Exception;
}