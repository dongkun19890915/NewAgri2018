package com.sinosoft.agriprpall.core.policymanage.service;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpCPcoinsDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCcoinsDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;

import java.util.List;

/**
 * *PrpCcoins 共保信息表的Core接口
 * @Author: 田慧
 * @Date: 2017/11/20 16:24
 */

public interface PrpCcoinsService {
    /**
     *  根据主键查询PrpCcoin共保信息表信息
     * @author: 田慧
     * @date: 2017/12/3 12:08
     * @param policyNo 保单号
     * @param serialNo 序列号
     * @return
     */
    PrpCcoinsDto queryByPK(String policyNo,Integer serialNo);

    /**
     *  根据保单号查询prpCcoins 共保信息表信息
     * @author: 田慧
     * @date: 2017/11/20 15:32
     * @param policyNo 保单号
     * @return prpCcoinsDtoList 返回共保信息表Dto的集合
     */
    public List<PrpCcoinsDto> queryByPolicyNo(String policyNo)throws Exception;

    /**
     * CP表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpCPcoinsDto
     * @return PrpCcoinsDto
     * @throws Exception
     */
    public PrpCcoinsDto generatePrpCcoins(PrpCPcoinsDto prpCPcoinsDto) throws Exception;

    /**
     * （获取pubTolls 服务）
     * @author: 王志文
     * @date: 2018/4/12 18:08
     * @param iBaseCurrency
     * @param iExchCurrency
     * @param iExchDate
     * @return
     * @throws Exception
     */
    double getPubTools(String iBaseCurrency, String iExchCurrency,String iExchDate)throws Exception;

}
