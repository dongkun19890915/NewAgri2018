package com.sinosoft.agriprpall.api.policymanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCcoinsDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.agriprpall.api.policymanage.dto.QueryPrpCcoinsDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * *PrpCcoins 共保信息表Api接口
 * @Author: 田慧
 * @Date: 2017/11/20 15:10
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = PrpCcoinsApi.PATH)
public interface PrpCcoinsApi {
    public static final String PATH = "prpCcoins";

    /**
     *  根据主键查询PrpCcoin共保信息表信息
     * @author: 田慧
     * @date: 2017/12/3 12:08
     * @param queryPrpCcoinsDto 包括policyNo保单号、serialNo序列号
     * @return PrpCcoinsDto 共保信息表信息的Dto
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpCcoinsDto queryByPK(@RequestBody QueryPrpCcoinsDto queryPrpCcoinsDto);

    /**
     *  根据保单号查询prpCcoins 共保信息表信息
     * @author: 田慧
     * @date: 2017/11/20 15:39
     * @param map 包括policyNo保单号
     * @return prpCcoinsDtoList 返回共保信息表Dto的集合
     * @throws Exception
     */
    @RequestMapping(value = "queryByPolicyNo",method = {RequestMethod.POST})
    public @ResponseBody List<PrpCcoinsDto> queryByPolicyNo(@RequestBody Map<String,String> map)throws Exception;

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
    @RequestMapping(value = "getPubTools",method = {RequestMethod.POST})
    double getPubTools(@RequestParam("iBaseCurrency") String iBaseCurrency, @RequestParam("iExchCurrency")String iExchCurrency,@RequestParam("iExchDate") String iExchDate)throws Exception;
}
