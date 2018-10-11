package com.sinosoft.agriprpall.api.endorsemanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindAgriDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = PrpCitemKindAgriApi.PATH)
public interface PrpCitemKindAgriApi {
    public static final String PATH = "prpCitemKindAgri";

    /**
     * 按照 policyNo 查询 PrpCitemKind 集合
     * @author 王心洋
     * @time 2017-11-09
     * @param policyNo 保单号
     * @param kindCode 险别
     * @return List<PrpCitemKindAgriDto>
     */
    @RequestMapping(value = "queryByConditions",method = RequestMethod.POST)
    List<PrpCitemKindAgriDto> queryByConditions(@RequestParam("policyNo") String policyNo,@RequestParam("kindCode") String kindCode) throws Exception;

    /**
     * （按照 policyNo itemkindno kindcode 报案所在茬次时间 查询 PrpCitemKind 集合）
     * @author: 王志文
     * @date: 2018/3/14 17:19
     * @param map
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "queryByPk",method = {RequestMethod.POST})
    PrpCitemKindAgriDto queryByPk(@RequestBody Map<String,Object> map) throws Exception;

    /**
     * （查询茬次信息）
     * @author: 王志文
     * @date: 2018/4/20 15:10
     * @param map
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "queryListByPolicyNoAndKindCodeAndTimesDate",method = {RequestMethod.POST})
    public List<PrpCitemKindAgriDto> queryListByPolicyNoAndKindCodeAndTimesDate(@RequestBody Map<String,Object> map)throws Exception;

    /**
     * 根据保单号、险种、险别、出险时间查询茬次信息
     * @author: 孙朋飞
     * @date: 2018/4/25 8:46
     * @param map policyNo-保单号、riskCode-险种、kindCode险别、damageStartDate出险时间
     * @return 茬次
     * @throws Exception
     */
    @RequestMapping(value = "queryPrpcItemKindAgriTimesByConditions",method = {RequestMethod.POST})
    public @ResponseBody Map<String,Integer> queryPrpcItemKindAgriTimesByConditions(@RequestBody Map<String,String> map) throws Exception;
}
