package com.sinosoft.txnlist.api.plantinginsurancelist;

import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxEffectiveAmountDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.RequestNyxEffectiveAmountDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = NyxEffectiveAmountApi.PATH)
public interface NyxEffectiveAmountApi {
    public static final String PATH = "nyxEffectiveAmount";

    /**
     * 根据主键及日期查询有效保额表
     * @author: 刘曼曼
     * @date: 15:44 15:44
     * @param nyxEffectiveAmountDto
     * @return NyxEffectiveAmountDto有效保额数据
     */
    @RequestMapping(value = "queryAll",method = {RequestMethod.POST})
     @ResponseBody NyxEffectiveAmountDto queryAll(@RequestBody NyxEffectiveAmountDto nyxEffectiveAmountDto) throws Exception;


    /**
     * 根据需要插入或修改数据
     * @author: 刘曼曼
     * @date: 15:39 15:39
     * @param requestNyxEffectiveAmountDto
     * @return Map
     */
    @RequestMapping(value = "modifyNyxEffectiveAmount",method = {RequestMethod.POST})
     @ResponseBody Map<String,String> modifyNyxEffectiveAmount(@RequestBody RequestNyxEffectiveAmountDto requestNyxEffectiveAmountDto) throws Exception;

    /**
     * 保存NyxEffectiveAmount表
     * @author: 刘曼曼
     * @date: 15:43
     * @return Map
     */
    @RequestMapping(value = "saveNyxEffectiveAmount",method = {RequestMethod.POST})
     @ResponseBody Map<String,String> saveNyxEffectiveAmount(@RequestBody List<NyxEffectiveAmountDto> nyxEffectiveAmountDtoList) throws Exception;

    /*
    *根据保单号查询最大的数据
    * @author: 钱浩
    * @date: 2018/4/12 下午 14:22
    *
    */
    @RequestMapping(value = "queryNyxEffectiveAmount", method = {RequestMethod.POST})
     @ResponseBody
    Map<String, Double> queryNyxEffectiveAmount(@RequestParam("flse") Boolean flse, @RequestParam("riskCode") String riskCode, @RequestParam("inusreListCode") String inusreListCode, @RequestParam("policyNo") String policyNo) throws Exception;

    /**
     *  根据businessNo查询有效保额信息`
     * @author: 田健
     * @date: 2018/5/16 18:44
     * @param  map 集合 key为 riskCode 险种代码、inusreListCode 清单编号、businessNo 业务号
     * @return 有效保额map集合
     * @throws Exception
     */
    @RequestMapping(value = "queryNyxEffectiveAmountByBusinessNo", method = {RequestMethod.POST})
     @ResponseBody Map<String, Double> queryNyxEffectiveAmountByBusinessNo(@RequestBody Map<String,String> map ) throws Exception;


    /**
     * 查询保单的有效保额
     * @author: 孙朋飞
     * @date: 2018/5/18 18:12
     * @param map policyNo 保单号
     * @return 该保单的有效保额
     * @throws Exception
     */
    @RequestMapping(value="queryNyxEffectiveAmountByPolicyNo",method = {RequestMethod.POST})
    public @ResponseBody
    Map<String, Double> queryNyxEffectiveAmountByPolicyNo(@RequestBody Map<String, String> map) throws Exception;

    /**
     * 查询保单的有效保额
     *
     * @param map policyNo 保单号
     * @return 该保单的有效保额
     * @throws Exception
     * @author: 孙朋飞
     * @date: 2018/5/18 18:12
     */
    @RequestMapping(value = "queryNyxEffectiveAmountByPolicyNo1", method = {RequestMethod.POST})
    public @ResponseBody
    Map<String, Double> queryNyxEffectiveAmountByPolicyNo1(@RequestBody Map<String, String> map) throws Exception;
}
