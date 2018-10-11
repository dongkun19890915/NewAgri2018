package com.sinosoft.agriprpall.web.policymanage;

import com.sinosoft.agriprpall.api.endorsemanage.PrpCitemKindAgriApi;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindAgriDto;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCitemKindAgriService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = PrpCitemKindAgriController.PATH)
public class PrpCitemKindAgriController implements PrpCitemKindAgriApi {
    private static Logger LOGGER = LoggerFactory.getLogger(PrpCitemKindAgriController.class);

    @Autowired
    PrpCitemKindAgriService prpCitemKindAgriService;

    /**
     * 按照 policyNo 查询 PrpCitemKind 集合
     * @author 王心洋
     * @time 2017-11-09
     * @param policyNo 保单号
     * @param kindCode 险别
     * @return List<PrpCitemKindAgriDto>
     */
    @Override
    public List<PrpCitemKindAgriDto> queryByConditions(@RequestParam("policyNo") String policyNo, @RequestParam("kindCode") String kindCode) throws Exception {
        return prpCitemKindAgriService.queryByConditions(policyNo,kindCode);
    }

    /**
     * （按照 policyNo itemkindno kindcode 报案所在茬次时间 查询 PrpCitemKind 集合）
     * @author: 王志文
     * @date: 2018/3/14 17:19
     * @param map
     * @return
     * @throws Exception
     */
    @Override
    public PrpCitemKindAgriDto queryByPk(@RequestBody Map<String, Object> map) throws Exception {
        String policyNo = (String)map.get("policyNo");
        String kindCode = (String)map.get("kindCode");
        int times = (int)map.get("times");
        int itemKindNo = (int)map.get("itemKindNo");
        return prpCitemKindAgriService.queryByPk(policyNo,kindCode,times,itemKindNo);
    }

    /**
     * （查询茬次信息）
     * @author: 王志文
     * @date: 2018/4/20 15:10
     * @param map
     * @return
     * @throws Exception
     */
    public List<PrpCitemKindAgriDto> queryListByPolicyNoAndKindCodeAndTimesDate(@RequestBody Map<String,Object> map)throws Exception{
        String policyNo = (String)map.get("policyNo");
        String kindCode = (String)map.get("kindCode");
        int itemKindNo = (int)map.get("itemKindNo");
        return prpCitemKindAgriService.queryListByPolicyNoAndKindCodeAndTimesDate(policyNo,kindCode,itemKindNo);
    }
    /**
     * 根据保单号、险种、险别、出险时间查询茬次信息
     * @author: 孙朋飞
     * @date: 2018/4/25 8:46
     * @param map policyNo-保单号、riskCode-险种、kindCode险别、damageStartDate出险时间
     * @return 茬次
     * @throws Exception
     */
    @Override
    public @ResponseBody Map<String, Integer> queryPrpcItemKindAgriTimesByConditions(@RequestBody Map<String, String> map) throws Exception {
        return prpCitemKindAgriService.queryPrpcItemKindAgriTimesByConditions(map.get("policyNo"),map.get("riskCode"),map.get("kindCode"),map.get("damageStartDate"));
    }
}
