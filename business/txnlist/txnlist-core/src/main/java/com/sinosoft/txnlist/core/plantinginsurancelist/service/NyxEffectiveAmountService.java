package com.sinosoft.txnlist.core.plantinginsurancelist.service;

import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxEffectiveAmountDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.RequestNyxEffectiveAmountDto;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface NyxEffectiveAmountService {


    /**
     * 根据主键及日期查询有效保额表
     * @author: 刘曼曼
     * @date: 15:44 15:44
     * @param nyxEffectiveAmountDto
     * @return NyxEffectiveAmountDto有效保额数据
     */
     NyxEffectiveAmountDto queryAll(NyxEffectiveAmountDto nyxEffectiveAmountDto) throws Exception;

    /**
     * 根据需要插入或修改数据
     * @author: 刘曼曼
     * @date: 15:39 15:39
     * @param requestNyxEffectiveAmountDto
     * @return Map
     */
     Map<String,String> modifyNyxEffectiveAmount(RequestNyxEffectiveAmountDto requestNyxEffectiveAmountDto) throws Exception;

    /**
     * 保存NyxEffectiveAmount表
     * @author: 刘曼曼
     * @date: 15:43
     * @return Map
     */
     Map<String,String> saveNyxEffectiveAmount(List<NyxEffectiveAmountDto> nyxEffectiveAmountDtoList) throws Exception;

    /*
  *根据保单号查询最大的数据
  * @author: 钱浩
  * @date: 2018/4/12 下午 14:22
  *
  */
     Map<String, Double> queryNyxEffectiveAmount(Boolean flse, String riskCode, String inusreListCode, String policyNo) throws Exception;
    /**
     *  根据businessNo查询有效保额信息`
     * @author: 田健
     * @date: 2018/5/16 18:44
     * @param riskCode 险种代码
     * @param inusreListCode 清单编号
     * @param businessNo 业务号
     * @return 有效保额map集合
     * @throws Exception
     */
     Map<String, Double> queryNyxEffectiveAmountByBusinessNo( String riskCode, String inusreListCode, String businessNo) throws Exception;


    /**
     * 查询保单的有效保额
     * @author: 孙朋飞
     * @date: 2018/5/18 18:12
     * @param  policyNo 保单号
     * @return 该保单的有效保额
     * @throws Exception
     */
    public Map<String,Double> queryNyxEffectiveAmountByPolicyNo(String policyNo,Date startDate) throws Exception;

    /**
     * 查询保单的有效保额
     *
     * @param policyNo 保单号
     * @return 该保单的有效保额
     * @throws Exception
     * @author: 孙朋飞
     * @date: 2018/5/18 18:12
     */
    public Map<String, Double> queryNyxEffectiveAmountByPolicyNo1(String policyNo, Date startDate) throws Exception;
}
