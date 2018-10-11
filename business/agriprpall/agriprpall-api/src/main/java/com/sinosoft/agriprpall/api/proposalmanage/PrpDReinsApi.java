package com.sinosoft.agriprpall.api.proposalmanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.client.dto.ResponseQueryPrpDreinsDto;
import com.sinosoft.agriprpall.api.client.dto.ResponseQueryReinsAgreementDto;
import com.sinosoft.agriprpall.api.client.dto.ResponseQueryReinsCoinsDto;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 12:54:07.447 
 * @description 分保接受人代码表Api接口
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = PrpDReinsApi.PATH)
public interface PrpDReinsApi {

    public static final String PATH = "prpDReins";

    /**
     * 查询共保接受人信息
     * @author: 钱浩
     * @date: 2017/10/24 21:10
     * @param map :  reinsCode 接受人代码 shortName 接受人简称
     * @return ResponseDto： List<ResponseQueryPrpDreinsDto> 共保人信息List
     */
    @RequestMapping(value = "queryCoinsComCodeInfo",method = RequestMethod.POST)
    public @ResponseBody
    List<ResponseQueryPrpDreinsDto> queryCoinsComCodeInfo(@RequestBody Map<String,String> map)throws Exception;
    /**
     * 查询协议共保
     * @author: 田健
     * @date: 2018/5/8 10:10
     * @param map 中的key为startDate 起保时间\comCode 归属机构\riskCode 险种代码
     * @return 协议共保信息
     * @throws Exception
     */
    @RequestMapping(value = "findCoinsTreaty",method = RequestMethod.POST)
    @ResponseBody ResponseQueryReinsCoinsDto findCoinsTreaty(@RequestBody Map<String,String> map) throws Exception;

    /**
     * 获取再保协议业务数据方法
     * @author: 田健
     * @date: 2018/5/8 18:05
     * @param map 中的keyTreatyNo 再保合约号
     * @return 再保合约信息
     * @throws Exception
     */
    @RequestMapping(value = "getResponseQueryReinsAgreementDtoList",method = RequestMethod.POST)
    @ResponseBody List<ResponseQueryReinsAgreementDto> getResponseQueryReinsAgreementDtoList(@RequestBody Map<String,String> map)throws Exception;
  }