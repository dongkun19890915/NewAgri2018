package com.sinosoft.txnlist.web.plantinginsurancelist;

import com.sinosoft.txnlist.api.plantinginsurancelist.NyxEffectiveAmountApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxEffectiveAmountDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.RequestNyxEffectiveAmountDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.NyxEffectiveAmountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = NyxEffectiveAmountApi.PATH)
public class NyxEffectiveAmountController implements NyxEffectiveAmountApi {

    private static Logger LOGGER = LoggerFactory.getLogger(NyxEffectiveAmountController.class);

    @Autowired
    private NyxEffectiveAmountService nyxEffectiveAmountService;

    /**
     * 根据主键及日期查询有效保额表
     * @author: 刘曼曼
     * @date: 15:44 15:44
     * @param nyxEffectiveAmountDto
     * @return NyxEffectiveAmountDto有效保额数据
     */
    @Override
    public @ResponseBody NyxEffectiveAmountDto queryAll(@RequestBody NyxEffectiveAmountDto nyxEffectiveAmountDto) throws Exception{
        return nyxEffectiveAmountService.queryAll(nyxEffectiveAmountDto);
    }

    /**
     * 根据需要插入或修改数据
     * @author: 刘曼曼
     * @date: 15:39 15:39
     * @param requestNyxEffectiveAmountDto
     * @return Map
     */
    @Override
    public @ResponseBody Map<String,String> modifyNyxEffectiveAmount(@RequestBody RequestNyxEffectiveAmountDto requestNyxEffectiveAmountDto) throws Exception{
        return nyxEffectiveAmountService.modifyNyxEffectiveAmount(requestNyxEffectiveAmountDto);
    }

    /**
     * 保存NyxEffectiveAmount表
     * @author: 刘曼曼
     * @date: 15:43
     * @return Map
     */
    @Override
    public @ResponseBody Map<String,String> saveNyxEffectiveAmount(@RequestBody List<NyxEffectiveAmountDto> nyxEffectiveAmountDtoList) throws Exception{
        return nyxEffectiveAmountService.saveNyxEffectiveAmount(nyxEffectiveAmountDtoList);
    }

    /*
   *根据保单号查询最大的数据
   * @author: 钱浩
   * @date: 2018/4/12 下午 14:22
   *
   */
    @Override
    public @ResponseBody
    Map<String, Double> queryNyxEffectiveAmount(@RequestParam("flse") Boolean flse, @RequestParam("riskCode") String riskCode, @RequestParam("inusreListCode") String inusreListCode, @RequestParam("policyNo") String policyNo) throws Exception {
        return nyxEffectiveAmountService.queryNyxEffectiveAmount(flse, riskCode, inusreListCode, policyNo);
    }
    /**
     *  根据businessNo查询有效保额信息`
     * @author: 田健
     * @date: 2018/5/16 18:44
     * @param  map 集合 key为 riskCode 险种代码、inusreListCode 清单编号、businessNo 业务号
     * @return 有效保额map集合
     * @throws Exception
     */
    @Override
    public @ResponseBody Map<String, Double> queryNyxEffectiveAmountByBusinessNo(@RequestBody Map<String,String> map ) throws Exception{
        String riskCode = map.get("riskCode");
        String inusreListCode = map.get("inusreListCode");
        String businessNo = map.get("businessNo");
        return nyxEffectiveAmountService.queryNyxEffectiveAmountByBusinessNo(riskCode,inusreListCode,businessNo);
    }
    /**
     * 查询保单的有效保额
     * @author: 孙朋飞
     * @date: 2018/5/18 18:12
     * @param map policyNo 保单号
     * @return 该保单的有效保额
     * @throws Exception
     */
    @Override
    public @ResponseBody
    Map<String, Double> queryNyxEffectiveAmountByPolicyNo(@RequestBody Map<String, String> map) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = format.parse(map.get("starDate"));
       String policyNo=(String) map.get("policyNo");
        return nyxEffectiveAmountService.queryNyxEffectiveAmountByPolicyNo(policyNo,startDate);
    }

    /**
     * 查询保单的有效保额
     *
     * @param map policyNo 保单号
     * @return 该保单的有效保额
     * @throws Exception
     * @author: 孙朋飞
     * @date: 2018/5/18 18:12
     */
    @Override
    public @ResponseBody
    Map<String, Double> queryNyxEffectiveAmountByPolicyNo1(@RequestBody Map<String, String> map) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = format.parse(map.get("starDate"));
        String policyNo = (String) map.get("policyNo");
        return nyxEffectiveAmountService.queryNyxEffectiveAmountByPolicyNo1(policyNo, startDate);
    }


}
