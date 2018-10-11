package com.sinosoft.agriprpall.core.proposalmanage.service;

import com.sinosoft.agriprpall.api.client.dto.ResponseQueryReinsAgreementDto;
import com.sinosoft.agriprpall.api.client.dto.ResponseQueryReinsCoinsDto;

import java.util.List;

/**
 * 共保再保信息基本信息表Service接口
 * @Author: 王保良
 * @Date: 2017/11/18 11:20
 */
public interface QueryCoinsTreatyService {
    /**
     * 方法简述：根据入参1险种代码 riskCode 2机构代码 comCode 3合约起期查询其共保协议信息 startDate
     * @author: 王保良
     * @date: 2017/11/18 11:20
     * @param riskCode 险种代码
     * @param comCode 机构代码
     * @param startDate 合约起期
     * @return List<FhCoinsTreatyDto>(1.TreatyNo 协议共保合约编码 2.coinsType 协议共保类型:(1-主共；2-从共)  3.coinsPremiumType收付费类型：1-整单收付；2-我方收付)
     * @throws Exception
     */
    public List<ResponseQueryReinsCoinsDto> queryCoinsTreatyService(String riskCode, String comCode, String startDate) throws Exception;

    /**
     * 方法简述：根据入参treatyNo 协议共保合约编码 查询其再保协议信息
     * @author: 王保良
     * @date: 2017/11/18 11:20
     * @param treatyNo
     * @return List<FhCoinsTreatyInfoDto>(1.TreatyNo 协议共保合约编码 2.coinsType 协议共保类型:(1-主共；2-从共)  3.coinsPremiumType收付费类型：1-整单收付；2-我方收付 )
     * @throws Exception
     */
    public List<ResponseQueryReinsAgreementDto> queryCoinsTreatyInfo(String treatyNo) throws Exception;

}
