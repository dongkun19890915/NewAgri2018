package com.sinosoft.agriprpall.web.policymanage;

import com.sinosoft.agriprpall.api.policymanage.PrpCcoinsApi;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCcoinsDto;
import com.sinosoft.agriprpall.api.policymanage.dto.QueryPrpCcoinsDto;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCcoinsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * *PrpCcoins 共保信息表controller层
 * @Author: 田慧
 * @Date: 2017/11/20 15:14
 */
@RestController
@RequestMapping(value = PrpCcoinsController.PATH)
public class PrpCcoinsController implements PrpCcoinsApi{
    private static Logger LOGGER = LoggerFactory.getLogger(PrpCplanController.class);
    @Autowired
    private PrpCcoinsService prpCcoinsService;
    /**
     *  根据主键查询PrpCcoin共保信息表信息
     * @author: 田慧
     * @date: 2017/12/3 12:08
     * @param queryPrpCcoinsDto 包括policyNo保单号、serialNo序列号
     * @return PrpCcoinsDto 共保信息表信息的Dto
     */
    @Override
    public @ResponseBody
    PrpCcoinsDto queryByPK(@RequestBody QueryPrpCcoinsDto queryPrpCcoinsDto) {
        String policyNo = queryPrpCcoinsDto.getPolicyNo();
        Integer serialNo = queryPrpCcoinsDto.getSerialNo();
        return prpCcoinsService.queryByPK(policyNo,serialNo);

    }

    /**
     *  根据保单号查询prpCcoins 共保信息表信息
     * @author: 田慧
     * @date: 2017/11/20 15:39
     * @param map 包括policyNo保单号
     * @return prpCcoinsDtoList 返回共保信息表Dto的集合
     * @throws Exception
     */
    @Override
    public @ResponseBody List<PrpCcoinsDto> queryByPolicyNo(@RequestBody Map<String,String> map)throws Exception{
        return prpCcoinsService.queryByPolicyNo(map.get("policyNo"));
    }

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
    @Override
    public double getPubTools(@RequestParam("iBaseCurrency") String iBaseCurrency, @RequestParam("iExchCurrency")String iExchCurrency, @RequestParam("iExchDate") String iExchDate)throws Exception{
        return prpCcoinsService.getPubTools(iBaseCurrency,iExchCurrency,iExchDate);
    }
}
