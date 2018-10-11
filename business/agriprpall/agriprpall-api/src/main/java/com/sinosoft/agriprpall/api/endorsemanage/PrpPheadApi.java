package com.sinosoft.agriprpall.api.endorsemanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.client.dto.RequestVisaStatusWriteBackDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPheadDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name= AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME,path = PrpPheadApi.PATH)
public interface PrpPheadApi {
    public static final String PATH="prpphead";

    /**
     *查询Prpphead 批单号
     * @author: 钱浩
     * @date: 2017/11/20 下午 19:31
     * @param strWhere
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "queryEndorseNo",method = RequestMethod.POST)
    public @ResponseBody String queryEndorseNo(@RequestParam("strWhere") String strWhere) throws Exception;

    /**
     * *
     * @author: 钱浩
     * @date: 2017/11/20 下午 19:31
     * @param strWhere
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "queryMaxEndorseNo",method = RequestMethod.POST)
    public @ResponseBody Integer queryMaxEndorseNo(@RequestParam("strWhere") String strWhere) throws Exception;

    /**
    * 通过主键查询
    * @param map  保单号
    * @return PrpPheadDto
    * @throws Exception
    * @author 李冬松
    * @date 16:45 2017/11/23
    */
    @RequestMapping(value = "queryAllByPolicyNo",method = {RequestMethod.POST})
    public @ResponseBody
    List<PrpPheadDto> queryAllByPolicyNo(@RequestBody Map<String,String> map)throws Exception;

    /**
     * @param endorseNo 批单号码
     * @return ResponseDto
     * @throws Exception 数据校验异常、数据库异常
     * @description: 类功能简述：批单正本打印，全打
     * @author: 潘峰
     */
    @RequestMapping(value = "endorsementPrint", method = RequestMethod.GET)
    public PrpPheadDto endorsementPrint(@RequestParam(value = "endorseNo") String endorseNo) throws Exception;

    /**
     * （通过保单号查询批单信息）
     * @author: 王志文
     * @date: 2017/11/16 17:30
     * @param policyNo
     * @return
     */
    @RequestMapping(value = "queryByPolicyNo",method = {RequestMethod.POST})
    List<PrpPheadDto> queryByPolicyNo(@RequestParam("policyNo") String policyNo);

    /**
     * 回写批单打印流水号服务
     * @author: 何伟东
     * @date: 2017/12/4 14:54
     * @param requestVisaStatusWriteBackDto 包含业务号、归属及机构、流水号、单证类型
     * @return message 成功or失败
     */
    @RequestMapping(value = "printNoWriteBack", method = RequestMethod.POST)
    public Map<String, String> printNoWriteBack(@RequestBody List<RequestVisaStatusWriteBackDto> requestVisaStatusWriteBackDto);

    /**
     *通过保单号，出险小时，出险日期查询批单头表信息
     * @author: 李冬松
     * @date: 2017/12/23 14:32
     * @param map 保单号，出险小时，出险日期
     * @return List<PrpPheadDto>批单表集合
     * @throws Exception
     */
    @RequestMapping(value = "queryByPolicyNoAndDamagerDate" ,method = {RequestMethod.POST})
    public @ResponseBody List<PrpPheadDto> queryByPolicyNoAndDamagerDate(@RequestBody Map<String,String> map)throws Exception;

    /**
     * 根据policyNo和时间条件查询PrpPheadDto集合
     * @author: 刘曼曼
     * @date: 2017/12/23 14:32
     * @param map 保单号，出险小时，出险日期，出险日期
     * @return List<PrpPheadDto>批单表集合
     * @throws Exception
     */
    @RequestMapping(value = "queryPrpPheadDtoByNoANDTime",method = {RequestMethod.POST})
    public @ResponseBody List<PrpPheadDto> queryPrpPheadDtoByNoANDTime(@RequestBody Map<String,String> map)throws Exception;
}
