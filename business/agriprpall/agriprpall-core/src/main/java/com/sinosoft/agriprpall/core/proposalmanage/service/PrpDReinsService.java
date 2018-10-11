package com.sinosoft.agriprpall.core.proposalmanage.service;


import com.sinosoft.agriprpall.api.client.dto.ResponseQueryPrpDreinsDto;
import com.sinosoft.agriprpall.api.client.dto.ResponseQueryReinsAgreementDto;
import com.sinosoft.agriprpall.api.client.dto.ResponseQueryReinsCoinsDto;
import com.sinosoft.framework.dto.ResponseDto;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 12:54:07.447 
 * @description 分保接受人代码表Core接口
 */
public interface PrpDReinsService {

    /**
     * 查询共保接受人信息
     * @author: 钱浩
     * @date: 2017/10/24 21:10
     * @param reinsCode 接受人代码
     * @param shortName 接受人简称
     * @return ResponseDto： List<ResponseQueryPrpDreinsDto> 共保人信息List
     */
    public List<ResponseQueryPrpDreinsDto> queryCoinsComCodeInfo(String reinsCode, String shortName)throws Exception;
    /**
     * 查询协议共保
     * @author: 田健
     * @date: 2018/5/8 10:10
     * @param startDate 起保时间
     * @param comCode 归属机构
     * @param riskCode 险种代码
     * @return 协议共保信息
     * @throws Exception
     */
    public ResponseQueryReinsCoinsDto findCoinsTreaty(String startDate, String comCode, String riskCode) throws Exception;
    /**
     * 获取再保协议业务数据方法
     * @author: 田健
     * @date: 2018/5/8 18:05
     * @param TreatyNo 再保合约号
     * @return 再保合约信息
     * @throws Exception
     */
    public List<ResponseQueryReinsAgreementDto> getResponseQueryReinsAgreementDtoList(String TreatyNo)throws Exception;
}