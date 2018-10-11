package com.sinosoft.agriprpall.web.proposalmanage;

import com.sinosoft.agriprpall.api.client.dto.ResponseQueryPrpDreinsDto;
import com.sinosoft.agriprpall.api.client.dto.ResponseQueryReinsAgreementDto;
import com.sinosoft.agriprpall.api.client.dto.ResponseQueryReinsCoinsDto;
import com.sinosoft.agriprpall.api.proposalmanage.PrpDReinsApi;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpDReinsService;
import com.sinosoft.framework.dto.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 12:54:07.447 
 * @description 分保接受人代码表controller层
 */
@RestController
@RequestMapping(value = PrpDReinsController.PATH)
public class PrpDReinsController implements PrpDReinsApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDReinsController.class);

    @Autowired
    private PrpDReinsService prpDReinsService;

    /**
     * 查询共保接受人信息
     * @author: 钱浩
     * @date: 2017/10/24 21:10
     * @param map :  reinsCode 接受人代码 shortName 接受人简称
     * @return ResponseDto： List<ResponseQueryPrpDreinsDto> 共保人信息List
     */
    public List<ResponseQueryPrpDreinsDto> queryCoinsComCodeInfo(@RequestBody Map<String,String> map)throws Exception{
        String reinsCode=map.get("reinsCode");
        String shortName=map.get("shortName");
        return prpDReinsService.queryCoinsComCodeInfo(reinsCode, shortName);
    }
    /**
     * 查询协议共保
     * @author: 田健
     * @date: 2018/5/8 10:10
     * @param map 中的key为startDate 起保时间\comCode 归属机构\riskCode 险种代码
     * @return 协议共保信息
     * @throws Exception
     */
    public ResponseQueryReinsCoinsDto findCoinsTreaty(@RequestBody Map<String,String> map) throws Exception{
        String startDate = map.get("startDate");
        String comCode = map.get("comCode");
        String riskCode = map.get("riskCode");
        return prpDReinsService.findCoinsTreaty(startDate, comCode,riskCode);
    }
    /**
     * 获取再保协议业务数据方法
     * @author: 田健
     * @date: 2018/5/8 18:05
     * @param map 中的keyTreatyNo 再保合约号
     * @return 再保合约信息
     * @throws Exception
     */
    public List<ResponseQueryReinsAgreementDto> getResponseQueryReinsAgreementDtoList(@RequestBody Map<String,String> map)throws Exception{
        String TreatyNo = map.get("TreatyNo");
        return prpDReinsService.getResponseQueryReinsAgreementDtoList(TreatyNo);
    }
   }
