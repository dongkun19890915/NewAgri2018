package com.sinosoft.agriclaim.api.businessutilmanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.RequestQueryClaimListDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.ResponseCheckDto;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283
 * @description 索赔申请人信息表Api接口
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = LossListApi.PATH)
public interface LossListApi {

    public static final String PATH = "lossList";
    /**
     * 按条件查询种植险实体集合
     * @param map 保单号,报案号
     * @return List<LossRateListDto>定损清单信息列表
     * @author 王心洋
     * @time 2017-12-25
     */
    @RequestMapping(value = "queryLossByConditions",method = {RequestMethod.POST})
    List<LossRateListDto> queryLossByConditions(Map<String,String> map);

    /**
     * 关联种植险报案号和清单信息
     * @param map 损失率清单号,报案号
     * @author 王心洋
     * @time 2017-12-25
     */
    @RequestMapping(value = "comparePlantingInsurance",method = {RequestMethod.POST})
    void comparePlantingInsurance(Map<String,String> map);

    /**
     * 关联养殖险报案号和清单信息
     * @param map 损失率清单号,报案号
     * @author 王心洋
     * @time 2017-12-25
     */
    @RequestMapping(value = "compareBreedInsurance",method = {RequestMethod.POST})
    void compareBreedInsurance(Map<String,String> map);

    /**
     * 查询定损清单和承保清单拼接种植险理赔清单
     * @param requestQueryClaimListDto 保单号、报案号、计算书号、生长期、清单号
     * @return List<NyxPlantingClaimListDto> 种植险理赔清单对象集合
     * @author 王心洋
     * @time 2017-12-26
     */
    @RequestMapping(value = "queryPlantingClaimList",method = {RequestMethod.POST})
    List<NyxPlantingClaimListDto> queryPlantingClaimList(RequestQueryClaimListDto requestQueryClaimListDto) throws Exception;
    /**
     * 查询定损清单和承保清单拼接养殖险理赔清单
     * @param requestQueryClaimListDto 保单号、报案号、计算书号、生长期、清单号
     * @return List<NyxBreedClaimListDto> 养殖险理赔清单对象集合
     * @author 王心洋
     * @time 2017-12-26
     */
    @RequestMapping(value = "queryBreedClaimList",method = {RequestMethod.POST})
    List<NyxBreedClaimListDto> queryBreedClaimList(RequestQueryClaimListDto requestQueryClaimListDto) throws Exception;

    /**
     * 种植险理赔清单组装导出Excel
     * @param requestQueryClaimListDto 保单号、报案号、计算书号、生长期、清单号
     * @return shortLink 文件下载短链接
     * @throws Exception
     * @author 王心洋
     * @time 2017-12-27
     */
    @RequestMapping(value = "expPlantingClaimListExcel",method = {RequestMethod.POST})
    String expPlantingClaimListExcel(RequestQueryClaimListDto requestQueryClaimListDto) throws Exception;
    /**
     * 养殖险理赔清单组装导出Excel
     * @param requestQueryClaimListDto 保单号、报案号、计算书号、生长期、清单号
     * @return shortLink 文件下载短链接
     * @throws Exception
     * @author 王心洋
     * @time 2017-12-27
     */
    @RequestMapping(value = "expBreedClaimListExcel",method = {RequestMethod.POST})
    String expBreedClaimListExcel(RequestQueryClaimListDto requestQueryClaimListDto) throws Exception;




    /**
     * 种植险理赔清单导出Excel
     * @param requestNyxPlantingClaimListDto 理赔清单号、保单号、报案号、计算书号、农户代码 、导出类型
     * @return shortLink 文件下载短链接
     * @throws Exception
     * @author 李文刚
     * @time 2017-12-29
     */

    @RequestMapping(value = "nyxPlantingClaimListExportExcel",method = RequestMethod.POST)
    Map<String,String> nyxPlantingClaimListExportExcel(RequestNyxPlantingClaimListDto requestNyxPlantingClaimListDto) throws Exception;

    /**
     * 养殖险理赔清单导出Excel
     * @param requestNyxBreedClaimListDto 理赔清单号、保单号、报案号、计算书号、农户代码、导出类型
     * @return shortLink 文件下载短链接
     * @throws Exception
     * @author 李文刚
     * @time 2017-12-29
     */
    @RequestMapping(value = "nyxBreedClaimListExportExcel",method = RequestMethod.POST)
    Map<String,String> nyxBreedClaimListExportExcel(RequestNyxBreedClaimListDto requestNyxBreedClaimListDto) throws Exception;

    /**
     * （种植险理赔清单数据的导入保存）
     * @author: 孙朋飞
     * @date: 2017/12/28 20:34
     * @param map 文件标识fileId、机构代码comCode、needTime苗期、nodetype节点类型、damageWay出险方式、damageDegree溃塘程度
     * @return 返回清单号和总赔偿金额
     * @throws Exception
     */
    @RequestMapping(value="importPlantingClaimListExcel",method = {RequestMethod.POST})
    public @ResponseBody Map<String,Object> importPlantingClaimListExcel(@RequestBody Map<String,String> map) throws Exception;
    /**
     * （养殖险理赔清单数据的导入保存）
     * @author: 孙朋飞
     * @date: 2017/12/29 11:08
     * @param map 文件标识fileId和机构代码
     * @return 返回清单号和赔偿金额
     * @throws Exception
     */
    @RequestMapping(value="importBreedClaimListExcel",method = {RequestMethod.POST})
    public @ResponseBody Map<String,Object> importBreedClaimListExcel(@RequestBody Map<String,String> map) throws Exception;
    /**
     * （养殖险定损清单数据的下载）
     * @author: 孙朋飞
     * @date: 2017/12/29 19:41
     * @param map 报案号
     * @return 生成下载短链接
     * @throws Exception
     */
    @RequestMapping(value="expBreedLossRateList",method = {RequestMethod.POST})
    public @ResponseBody Map<String,String> expBreedLossRateList(@RequestBody Map<String,String> map) throws Exception;
    /**
     * （种植险险定损清单数下载）
     * @author: 祁小龙
     * @date: 2017/12/29 19:41
     * @param map 文件地址
     * @return 生成下载短链接
     * @throws Exception
     */
    @RequestMapping(value="expPlantingLossRateList",method = {RequestMethod.POST})
    public @ResponseBody Map<String,String> expPlantingLossRateList(@RequestBody Map<String,String> map) throws Exception;

    /**
     *定损清单下载（种植险和养殖险）
     * @author: 孙朋飞
     * @date: 2018/1/19 14:15
     * @param map registNo 报案号
     * @return 生成下载短链接
     * @throws Exception
     */
    @RequestMapping(value="expBreedAndPlantingLossRateList",method = {RequestMethod.POST})
    public @ResponseBody Map<String,String> expBreedAndPlantingLossRateList(@RequestBody Map<String,String> map) throws Exception;

    /**
     *定损清单下载（种植险和养殖险）
     * @author: 陈道洋
     * @date: 2018/1/19 14:15
     * @param map registNo 报案号
     * @return 生成下载短链接
     * @throws Exception
     */
    @RequestMapping(value="downloadist",method = {RequestMethod.POST})
    public @ResponseBody Map<String,String> downloadlList(@RequestBody Map<String,String> map) throws Exception;

    /**
     * 特殊赔案清单下载
     * @author: 孙朋飞
     * @date: 2018/1/23 9:47
     * @param map 清单号
     * @return 生成下载短链接
     * @throws Exception
     */
    @RequestMapping(value="expSpecCaseList",method={RequestMethod.POST})
    public @ResponseBody Map<String,String> expSpecCaseList(@RequestBody Map<String,String> map) throws Exception;
    /**
     * 特殊赔案清单模板下载
     * @author: 王心洋
     * @date: 2018/4/12
     * @param map 保单号 出险日期
     * @return 生成下载短链接
     * @throws Exception
     */
    @RequestMapping(value="expSpecCaseModelList",method={RequestMethod.POST})
    public @ResponseBody Map<String,String> expSpecCaseModelList(@RequestBody Map<String,String> map) throws Exception;
    /**
     * 特殊赔案清单的导入保存
     * @author: 孙朋飞
     * @date: 2018/1/24 14:16
     * @param map fileId文件的唯一标识id和机构代码comCode
     * @return 返回预赔金额和清单号
     * @throws Exception
     */
    @RequestMapping(value="importSpecCaseListExcel",method = {RequestMethod.POST})
    public @ResponseBody Map<String,Object> importSpecCaseListExcel(@RequestBody Map<String,String> map) throws Exception;

    /**
     * 查询查勘页面初始化成灾面积等
     * @author: 孙朋飞
     * @date: 2018/4/13 16:22
     * @param map registNo-报案号，policyNo-保单号
     * @return 查勘定损登记集合
     * @throws Exception
     */
    @RequestMapping(value="queryBreedAndPlantingLossRateListPageInit",method = {RequestMethod.POST})
    public @ResponseBody ResponseCheckDto queryBreedAndPlantingLossRateListPageInit(@RequestBody Map<String,String> map) throws Exception;
}