package com.sinosoft.agriprpall.api.proposalmanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.client.dto.ResponseQueryReinsAgreementDto;
import com.sinosoft.agriprpall.api.client.dto.ResponseQueryReinsCoinsDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


/**
 * 共保再保信息基本信息表Api接口
 * @Author: 王保良
 * @Date: 2017/11/18 11:20
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME,path = QueryCoinsTreatyApi.PATH)
public interface QueryCoinsTreatyApi {
    public static final String PATH="proposalmanage";

    /**
     * 方法简述：根据入参 1险种代码riskCode 2机构代码 comCode 3合约起期 startDate 查询其共保协议信息
     * @author: 王保良
     * @date: 2017/11/18 11:20
     * @param map 的 key:riskCode是险种代码
     * @param map 的 key:comCode是机构代码
     * @param map 的 key: startDate是 合约起期
     * @return ResponseDto(1.TreatyNo 协议共保合约编码 2.coinsType 协议共保类型:(1-主共；2-从共)  3.coinsPremiumType收付费类型：1-整单收付；2-我方收付 )
     * @throws Exception
     */
    @RequestMapping(value = "queryCoinsTreaty",method = RequestMethod.POST)
    public List<ResponseQueryReinsCoinsDto> queryCoinsTreaty(@RequestBody Map<String,String> map) throws Exception;

    /**
     * 方法简述：根据入参treatyNo 协议共保合约编码 查询其再保协议信息
     * @author: 王保良
     * @date: 2017/11/18 11:20
     * @param treatyNo
     * @return ResponseDto(1.TreatyNo 协议共保合约编码 2.coinsType 协议共保类型:(1-主共；2-从共)  3.coinsPremiumType收付费类型：1-整单收付；2-我方收付 )
     * @throws Exception
     */
    @RequestMapping(value = "queryCoinsTreatyInfo",method = RequestMethod.POST)
    public List<ResponseQueryReinsAgreementDto> queryCoinsTreatyInfo(@RequestParam("treatyNo") String treatyNo) throws Exception;
}
