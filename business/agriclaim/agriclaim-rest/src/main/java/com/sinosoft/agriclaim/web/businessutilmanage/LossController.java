package com.sinosoft.agriclaim.web.businessutilmanage;

import com.sinosoft.agriclaim.api.businessutilmanage.LossListApi;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.RequestQueryClaimListDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.ResponseCheckDto;
import com.sinosoft.agriclaim.core.businessutilmanage.service.LossListService;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = LossController.PATH)
public class LossController implements LossListApi {
    private static Logger LOGGER = LoggerFactory.getLogger(LossController.class);

    @Autowired
    LossListService lossListService;
    /**
     * 按条件查询定损清单主表信息列表
     * @param map 保单号,报案号
     * @return List<LossRateListDto>定损清单信息列表
     * @author 王心洋
     * @time 2017-12-25
     */
    @Override
    public List<LossRateListDto> queryLossByConditions(@RequestBody Map<String, String> map) {
        return lossListService.queryLossByConditions(map);
    }

    /**
     * 关联种植险报案号和清单信息
     * @param map 损失率清单号,报案号
     * @author 王心洋
     * @time 2017-12-25
     */
    @Override
    public void comparePlantingInsurance(@RequestBody Map<String, String> map) {
        lossListService.comparePlantingInsurance(map);
    }

    /**
     * 关联养殖险报案号和清单信息
     * @param map 损失率清单号,报案号
     * @author 王心洋
     * @time 2017-12-25
     */
    @Override
    public void compareBreedInsurance(@RequestBody Map<String, String> map) {
        lossListService.compareBreedInsurance(map);
    }

    /**
     * 查询定损清单和承保清单拼接种植险理赔清单
     * @param requestQueryClaimListDto 保单号、报案号、计算书号、生长期、清单号
     * @return List<NyxPlantingClaimListDto> 种植险理赔清单对象集合
     * @author 王心洋
     * @time 2017-12-26
     */
    public List<NyxPlantingClaimListDto> queryPlantingClaimList(@RequestBody RequestQueryClaimListDto requestQueryClaimListDto) throws Exception{
        return lossListService.queryPlantingClaimList(requestQueryClaimListDto);
    }
    /**
     * 查询定损清单和承保清单拼接养殖险理赔清单
     * @param requestQueryClaimListDto 保单号、报案号、计算书号、生长期、清单号
     * @return List<NyxBreedClaimListDto> 养殖险理赔清单对象集合
     * @author 王心洋
     * @time 2017-12-26
     */
    public List<NyxBreedClaimListDto> queryBreedClaimList(@RequestBody RequestQueryClaimListDto requestQueryClaimListDto) throws Exception{
        return lossListService.queryBreedClaimList(requestQueryClaimListDto);
    }

    /**
     * 种植险理赔清单组装导出Excel
     * @param requestQueryClaimListDto 保单号、报案号、计算书号、生长期、清单号
     * @return shortLink 文件下载短链接
     * @throws Exception
     * @author 王心洋
     * @time 2017-12-27
     */
    @Override
    public String expPlantingClaimListExcel(@RequestBody RequestQueryClaimListDto requestQueryClaimListDto) throws Exception {
        return lossListService.expPlantingClaimListExcel(requestQueryClaimListDto);
    }

    /**
     * 养殖险理赔清单组装导出Excel
     * @param requestQueryClaimListDto 保单号、报案号、计算书号、生长期、清单号
     * @return shortLink 文件下载短链接
     * @throws Exception
     * @author 王心洋
     * @time 2017-12-27
     */
    @Override
    public String expBreedClaimListExcel(@RequestBody RequestQueryClaimListDto requestQueryClaimListDto) throws Exception {
        return lossListService.expBreedClaimListExcel(requestQueryClaimListDto);
    }
    /**
     * （种植险理赔清单数据的导入保存）
     * @author: 孙朋飞
     * @date: 2017/12/28 20:34
     * @param map 文件标识fileId、机构代码comCode、needTime苗期、nodetype节点类型、damageWay出险方式、damageDegree溃塘程度
     * @return 返回清单号和总赔偿金额
     * @throws Exception
     */
    @Override
    public @ResponseBody Map<String,Object> importPlantingClaimListExcel(@RequestBody Map<String, String> map) throws Exception {
        return lossListService.importPlantingClaimListExcel(map.get("fileId"),map.get("comCode"),map.get("growthPeriod"),map.get("nodeType"),map.get("damageWay"),map.get("damageDegree"));
    }
    /**
     * （养殖险理赔清单数据的导入保存）
     * @author: 孙朋飞
     * @date: 2017/12/29 11:08
     * @param map 文件标识fileId和机构代码
     * @return 返回清单号和赔偿金额
     * @throws Exception
     */
    @Override
    public @ResponseBody Map<String, Object> importBreedClaimListExcel(@RequestBody Map<String, String> map) throws Exception {
        return lossListService.importBreedClaimListExcel(map.get("fileId"),map.get("comCode"),map.get("growthPeriod"),map.get("nodeType"));
    }
    /**
     * （养殖险定损清单数据的下载）
     * @author: 孙朋飞
     * @date: 2017/12/29 19:41
     * @param map 报案号
     * @return 生成下载短链接
     * @throws Exception
     */
    @Override
    public @ResponseBody Map<String, String> expBreedLossRateList(@RequestBody Map<String, String> map) throws Exception {
       String shortLink= lossListService.expBreedLossRateList(map);
        Map<String,String> hashMap = new HashMap<>(1);
        hashMap.put("shortLink",shortLink);
        return hashMap;
    }



    /**
     * 种植险理赔清单导出Excel
     * @param requestNyxPlantingClaimListDto 理赔清单号、保单号、报案号、计算书号、农户代码 、导出类型
     * @return shortLink 文件下载短链接
     * @throws Exception
     * @author 李文刚
     * @time 2017-12-29
     */
    @Override
    public Map<String,String>  nyxPlantingClaimListExportExcel(@RequestBody RequestNyxPlantingClaimListDto requestNyxPlantingClaimListDto) throws Exception {
        return lossListService.nyxPlantingClaimListExportExcel(requestNyxPlantingClaimListDto);
    }

    /**
     * 养殖险理赔清单导出Excel
     * @param requestNyxBreedClaimListDto 理赔清单号、保单号、报案号、计算书号、农户代码、导出类型
     * @return shortLink 文件下载短链接
     * @throws Exception
     * @author 李文刚
     * @time 2017-12-29
     */
    @Override
    public Map<String,String>  nyxBreedClaimListExportExcel(@RequestBody RequestNyxBreedClaimListDto requestNyxBreedClaimListDto) throws Exception {
        return lossListService.nyxBreedClaimListExportExcel(requestNyxBreedClaimListDto);
    }

    /**
     * （种植险险定损清单数据的导出）
     * @author: 祁小龙
     * @date: 2017/12/29 19:41
     * @param map 文件地址
     * @return 生成下载短链接
     * @throws Exception
     */
    @Override
    public @ResponseBody Map<String,String> expPlantingLossRateList(@RequestBody Map<String,String> map) throws Exception{
        Map<String ,String> resMap = new HashMap<String , String >();
        String shortLink =  this.lossListService.expPlantingLossRateList(map);
        resMap.put("shortLink",shortLink);
        return resMap;
    }
    /**
     *定损清单下载（种植险和养殖险）
     * @author: 孙朋飞
     * @date: 2018/1/19 14:15
     * @param map registNo 报案号
     * @return 生成下载短链接
     * @throws Exception
     */
    @Override
    public @ResponseBody Map<String, String> expBreedAndPlantingLossRateList(@RequestBody Map<String, String> map) throws Exception {
        String shortLink= lossListService.expBreedAndPlantingLossRateList(map);
        Map<String,String> hashMap = new HashMap<>(1);
        hashMap.put("shortLink",shortLink);
        return hashMap;
    }
    /**
     *定损清单下载（种植险和养殖险）
     * @author: 陈道洋
     * @date: 2018/1/19 14:15
     * @param map registNo 报案号
     * @return 生成下载短链接
     * @throws Exception
     */
    @Override
    public @ResponseBody Map<String, String> downloadlList(@RequestBody Map<String, String> map) throws Exception {
        String shortLink= lossListService.downloadlList(map);
        Map<String,String> hashMap = new HashMap<>(1);
        hashMap.put("shortLink",shortLink);
        return hashMap;
    }
    /**
     * 特殊赔案清单下载
     * @author: 孙朋飞
     * @date: 2018/1/23 9:47
     * @param map 清单号 listNo
     * @return 生成下载短链接
     * @throws Exception
     */
    @Override
    public @ResponseBody Map<String, String> expSpecCaseList(@RequestBody Map<String, String> map) throws Exception {
        String shortLinkId = lossListService.expSpecCaseList(map);
        Map<String,String> returnMap=new HashMap<>();
        returnMap.put("shortLink",shortLinkId);
        return returnMap;
    }
    /**
     * 特殊赔案清单模板下载
     * @author: 王心洋
     * @date: 2018/4/12
     * @param map 保单号 出险日期
     * @return 生成下载短链接
     * @throws Exception
     */
    @Override
    public @ResponseBody Map<String,String> expSpecCaseModelList(@RequestBody Map<String,String> map) throws Exception{
        return lossListService.expSpecCaseModelList(map);
    }
    /**
     * 特殊赔案清单的导入保存
     * @author: 孙朋飞
     * @date: 2018/1/24 14:16
     * @param map fileId文件的唯一标识id 和机构代码comCode
     * @return 返回预赔金额和清单号
     * @throws Exception
     */
    @Override
    public @ResponseBody Map<String,Object> importSpecCaseListExcel(@RequestBody Map<String, String> map) throws Exception {
        return lossListService.importSpecCaseListExcel(map.get("fileId"),map.get("comCode"));
    }
    /**
     * 查询查勘页面初始化成灾面积等
     * @author: 孙朋飞
     * @date: 2018/4/13 16:22
     * @param map registNo-报案号，policyNo-保单号
     * @return 查勘定损登记集合
     * @throws Exception
     */
    @Override
    public @ResponseBody ResponseCheckDto queryBreedAndPlantingLossRateListPageInit(@RequestBody Map<String, String> map) throws Exception {
        return lossListService.queryBreedAndPlantingLossRateListPageInit(map);
    }
}
