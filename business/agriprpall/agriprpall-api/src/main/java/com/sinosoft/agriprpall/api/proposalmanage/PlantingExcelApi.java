package com.sinosoft.agriprpall.api.proposalmanage;


import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.policymanage.dto.AcceptInsuranceDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PlantingExcelDto;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingInsuranceListDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 04:00:52.059 
 * @description 清单查询Api接口
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = PlantingExcelApi.PATH)
public interface PlantingExcelApi {

    public static final String PATH = "plantingexcel";

    /**
     *  分户清单查询
     * @author: 钱浩
     * @date: 2017/10/31 11:14
     * @param plantingExcelDto 清单入参对象
     * @return ResponseDto：
     */
    @RequestMapping(value = "queryPlantingExcelByConnection",method = {RequestMethod.POST})
    public @ResponseBody
    PageInfo<PlantingInsuranceListDto> queryPlantingExcelByConnection(@RequestBody PlantingExcelDto plantingExcelDto)throws Exception;
    /**
     * 分户清单
     * @author: 钱浩
     * @date: 2017/11/1 11:35
     * @param plantingExcelDto 清单入参对象
     * @return  ResponseDto ：下载链接地址
     * @throws Exception
     */
    @RequestMapping(value = "getPlantingExcel",method = {RequestMethod.POST})
    public @ResponseBody
    Map<String,String> getPlantingExcel(@RequestBody PlantingExcelDto plantingExcelDto)throws  Exception;
    /**
     *  养殖险分户清单的下载
     * @author: 田慧
     * @date: 2017/12/5 10:04
     * @param plantingExcelDto 清单入参对象包括 riskCode 险种代码、proposalNo 投保单号、policyNo 保单号、inusreListCode  清单号
     *              userCode  用户编码
     * @return  下载链接地址
     * @throws Exception
     */
//    @RequestMapping(value = "getHerdInsuranceListExcel",method = {RequestMethod.POST})
//    public  Map<String,String> getHerdInsuranceListExcel(@RequestBody PlantingExcelDto plantingExcelDto)throws Exception;
    /**
     * 根据出险时间、保单号查询清单信息
     * @author: 田健
     * @date: 2018/4/11 9:36
     * @param map 中 的key 为policyNo 保单号 validDate 出险时间
     * @return 承保分户清单dto集合
     * @throws Exception
     */
    @RequestMapping(value = "queryInsureListInfo",method = {RequestMethod.POST})
    public @ResponseBody List<AcceptInsuranceDto> queryInsureListInfo(@RequestBody Map<String,String> map) throws Exception;
    /**
     * 根据出险时间、保单号查询清单信息并下载
     * @author: 田健
     * @date: 2018/4/11 9:36
     * @param * @param map 中 的key 为policyNo 保单号 validDate 出险时间
     * @return 承保分户清单dto集合
     * @throws Exception
     */
    @RequestMapping(value = "getInsureListInfoFileId",method = {RequestMethod.POST})
    public @ResponseBody Map<String,String> getInsureListInfoFileId(@RequestBody Map<String,String> map)throws Exception;

    @RequestMapping(value = "getEndorExcel",method = {RequestMethod.POST})
    public @ResponseBody Map<String,String> getEndorExcel(@RequestBody PlantingExcelDto plantingExcelDto)throws Exception;
    @RequestMapping(value = "getAfterEndorExcel",method = {RequestMethod.POST})
    public @ResponseBody Map<String,String> getAfterEndorExcel(@RequestBody Map<String,String> map)throws Exception;
    @RequestMapping(value = "getChgEndorExcel",method = {RequestMethod.POST})
    public @ResponseBody Map<String,String> getChgEndorExcel(@RequestBody Map<String,String> map)throws Exception;
}