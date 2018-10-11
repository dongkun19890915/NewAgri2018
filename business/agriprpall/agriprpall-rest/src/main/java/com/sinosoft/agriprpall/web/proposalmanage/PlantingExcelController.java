package com.sinosoft.agriprpall.web.proposalmanage;

import com.sinosoft.agriprpall.api.policymanage.dto.AcceptInsuranceDto;
import com.sinosoft.agriprpall.api.proposalmanage.PlantingExcelApi;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PlantingExcelDto;
import com.sinosoft.agriprpall.core.proposalmanage.service.PlantingExcelService;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.PlantingInsuranceListDto;
import com.sun.corba.se.spi.ior.ObjectKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-24 12:54:07.447
 * @description 分保接受人代码表controller层
 */
@RestController
@RequestMapping(value = PlantingExcelController.PATH)
public class PlantingExcelController implements PlantingExcelApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PlantingExcelController.class);

    @Autowired
    private PlantingExcelService plantingExcelService;

    /**
     * 分户清单查询
     *
     * @param plantingExcelDto 清单入参对象
     * @return ResponseDto：
     * @author: 钱浩
     * @date: 2017/10/31 11:14
     */
    public @ResponseBody
    PageInfo<PlantingInsuranceListDto> queryPlantingExcelByConnection(@RequestBody PlantingExcelDto plantingExcelDto) throws Exception {
        String inusreListCode = plantingExcelDto.getInusreListCode();
        Integer pageNo = plantingExcelDto.getPageNo();
        Integer pageSize = plantingExcelDto.getPageSize();
        return plantingExcelService.queryPlantingExcelByConnection(inusreListCode, pageNo, pageSize);
    }

    /**
     * 分户清单
     *
     * @param plantingExcelDto 清单入参对象
     * @return ResponseDto ：下载链接地址
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/11/1 11:35
     */
    public @ResponseBody
    Map<String, String> getPlantingExcel(@RequestBody PlantingExcelDto plantingExcelDto) throws Exception {
//        String proposalNo = plantingExcelDto.getProposalNo();
//        String policyNo = plantingExcelDto.getPolicyNo();
//        String inusreListCode = plantingExcelDto.getInusreListCode();
//        String userCode = plantingExcelDto.getUserCode();
//        String riskCode = plantingExcelDto.getRiskCode();
//        return plantingExcelService.getPlantingToExcel(riskCode, proposalNo, policyNo, inusreListCode, userCode);
        return plantingExcelService.getFileId(plantingExcelDto);
    }
    /**
     *  养殖险分户清单的下载
     * @author: 田慧
     * @date: 2017/12/5 10:04
     * @param plantingExcelDto 清单入参对象包括 riskCode 险种代码、proposalno 投保单号、policyNo 保单号、inusreListCode  清单号
     *              userCode  用户编码
     * @return  下载链接地址
     * @throws Exception
     */
//    @Override
//    public  Map<String,String> getHerdInsuranceListExcel(@RequestBody PlantingExcelDto plantingExcelDto)throws Exception{
//        String proposalNo = plantingExcelDto.getProposalNo();
//        String policyNo = plantingExcelDto.getPolicyNo();
//        String inusreListCode = plantingExcelDto.getInusreListCode();
//        String userCode = plantingExcelDto.getUserCode();
//        String riskCode = plantingExcelDto.getRiskCode();
//        String  plantingExcelService.getHerdInsuranceListExcel(riskCode,proposalNo,policyNo,inusreListCode,userCode);
//        return plantingExcelService.getHerdInsuranceListExcel(riskCode,proposalNo,policyNo,inusreListCode,userCode);
//    }
    /**
     * 根据出险时间、保单号查询清单信息
     * @author: 田健
     * @date: 2018/4/11 9:36
     * @param map 中 的key 为policyNo 保单号 validDate 出险时间
     * @return 承保分户清单dto集合
     * @throws Exception
     */
    public @ResponseBody List<AcceptInsuranceDto> queryInsureListInfo(@RequestBody Map<String,String> map) throws Exception{
        String policyNo = (String)map.get("policyNo");
        SimpleDateFormat formatter2  = new SimpleDateFormat("yyyy-MM-dd");
        Date validDate = formatter2.parse(map.get("validDate"));
        return plantingExcelService.queryInsureListInfo(policyNo,validDate);
    }
    /**
     * 根据出险时间、保单号查询清单信息并下载
     * @author: 田健
     * @date: 2018/4/11 9:36
     * @param * @param map 中 的key 为policyNo 保单号 validDate 出险时间
     * @return 承保分户清单dto集合
     * @throws Exception
     */
    public @ResponseBody Map<String,String> getInsureListInfoFileId(@RequestBody Map<String,String> map)throws Exception{
        String policyNo = map.get("policyNo");
        SimpleDateFormat formatter2  = new SimpleDateFormat("yyyy-MM-dd");
        Date validDate = formatter2.parse(map.get("validDate"));
        return plantingExcelService.getInsureListInfoFileId(policyNo,validDate);
    }
    public @ResponseBody Map<String,String> getEndorExcel(@RequestBody PlantingExcelDto plantingExcelDto)throws Exception{
        return plantingExcelService.endorExcel(plantingExcelDto);
    }
    public @ResponseBody Map<String,String> getAfterEndorExcel(@RequestBody Map<String,String> map)throws Exception{
        return plantingExcelService.afterEndorExcel(map.get("endorseNo"));
    }
    public @ResponseBody Map<String,String> getChgEndorExcel(@RequestBody Map<String,String> map)throws Exception{
        return plantingExcelService.chgEndorExcel(map.get("policyNo"));
    }
}
