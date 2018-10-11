package com.sinosoft.agriprpall.web.endorsemanage;

import com.sinosoft.agriprpall.api.client.dto.RequestVisaStatusWriteBackDto;
import com.sinosoft.agriprpall.api.endorsemanage.PrpPheadApi;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPheadDto;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.EndorsePrintService;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.PrpPheadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = PrpPheadApi.PATH)
public class PrpPheadController implements PrpPheadApi {
    @Autowired
    private PrpPheadService prpPheadService;

    @Autowired
    private EndorsePrintService endorsePrintService;

    public @ResponseBody
    String queryEndorseNo( String strWhere) throws Exception{
        return prpPheadService.queryEndorseNo(strWhere);
    }
    public @ResponseBody Integer queryMaxEndorseNo( String strWhere) throws Exception{
        return prpPheadService.queryMaxEndorseNo(strWhere);
    }
    /**
    *
    * @param map policyNo 保单号
    * @return java.util.List<com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPheadDto>
    * @throws Exception
    * @author 李冬松
    * @date 14:25 2017/12/13
    */
    @Override
    public @ResponseBody List<PrpPheadDto> queryAllByPolicyNo(@RequestBody Map<String,String> map) throws Exception {
        return prpPheadService.queryAllByPolicyNo(map.get("policyNo"));
    }

    /**
     * @param endorseNo 批单号
     * @param endorseNo
     * @return ResponseDto
     * @throws Exception 数据校验异常、数据库异常
     * @description: 类功能简述：批单正本打印，全打
     * @author: 潘峰
     */
    @Override
    public PrpPheadDto endorsementPrint(@RequestParam String endorseNo) throws Exception {
        return endorsePrintService.endorsementPrint(endorseNo);
    }

    /**
     * （通过保单号查询批单信息）
     * @author: 王志文
     * @date: 2017/11/16 17:30
     * @param policyNo
     * @return
     */
    @Override
    public List<PrpPheadDto> queryByPolicyNo(String policyNo) {
        return prpPheadService.queryByPolicyNo(policyNo);
    }

    /**
     * 回写批单打印流水号服务
     * @author: 何伟东
     * @date: 2017/12/4 14:54
     * @param requestVisaStatusWriteBackDto 包含业务号、归属及机构、流水号、单证类型
     * @return message 成功or失败
     */
    @Override
    public Map<String, String> printNoWriteBack(@RequestBody List<RequestVisaStatusWriteBackDto> requestVisaStatusWriteBackDto) {
        String message = endorsePrintService.printNoWriteBack(requestVisaStatusWriteBackDto);
        Map<String,String> returnMap= new HashMap<>(1);
        returnMap.put("message",message);
        return returnMap;
    }


    /**
     *通过保单号，出险小时，出险日期查询批单头表信息
     * @author: 李冬松
     * @date: 2017/12/23 14:32
     * @param map 保单号，出险小时，出险日期
     * @return List<PrpPheadDto>批单表集合
     * @throws Exception
     */
    @Override
    public @ResponseBody List<PrpPheadDto> queryByPolicyNoAndDamagerDate(@RequestBody Map<String, String> map) throws Exception {
        return prpPheadService.queryByPolicyNoAndDamagerDate(map.get("policyNo"),map.get("validDate"),map.get("validHour"));
    }

    /**
     * 根据policyNo和时间条件查询PrpPheadDto集合
     * @author: 刘曼曼
     * @date: 2017/12/23 14:32
     * @param map 保单号，生效小时，生效日期
     * @return List<PrpPheadDto>批单表集合
     * @throws Exception
     */
    @Override
    public @ResponseBody List<PrpPheadDto> queryPrpPheadDtoByNoANDTime(@RequestBody Map<String, String> map) throws Exception {
        return prpPheadService.queryPrpPheadDtoByNoANDTime(map.get("policyNo"),map.get("damageDate"),map.get("damageHour"));
    }
}
