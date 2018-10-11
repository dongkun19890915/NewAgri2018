package com.sinosoft.agriclaim.core.businessutilmanage.service;

import com.sinosoft.agriclaim.api.businessutilmanage.dto.RequestQueryClaimListDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.ResponseCheckDto;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface LossListService {

    /**
     * 按条件查询实体集合
     * @param map 保单号,报案号
     * @return List<LossRateListDto>定损清单信息列表
     * @author 王心洋
     * @time 2017-12-25
     */
    List<LossRateListDto> queryLossByConditions(Map<String,String> map);

    /**
     * 关联种植险报案号和清单信息
     * @param map 损失率清单号,报案号
     * @author 王心洋
     * @time 2017-12-25
     */
    void comparePlantingInsurance(Map<String,String> map);

    /**
     * 关联养殖险报案号和清单信息
     * @param map 损失率清单号,报案号
     * @author 王心洋
     * @time 2017-12-25
     */
    void compareBreedInsurance(Map<String,String> map);
    /**
     * 查询定损清单和承保清单拼接种植险理赔清单
     * @param requestQueryClaimListDto 保单号、报案号、计算书号、生长期、清单号
     * @return List<NyxPlantingClaimListDto> 种植险理赔清单对象集合
     * @author 王心洋
     * @time 2017-12-26
     */
    List<NyxPlantingClaimListDto> queryPlantingClaimList(RequestQueryClaimListDto requestQueryClaimListDto) throws Exception;
    /**
     * 查询定损清单和承保清单拼接养殖险理赔清单
     * @param requestQueryClaimListDto 保单号、报案号、计算书号、生长期、清单号
     * @return List<NyxBreedClaimListDto> 养殖险理赔清单对象集合
     * @author 王心洋
     * @time 2017-12-26
     */
    List<NyxBreedClaimListDto> queryBreedClaimList(RequestQueryClaimListDto requestQueryClaimListDto) throws Exception;

    /**
     * 种植险理赔清单组装导出Excel
     * @param requestQueryClaimListDto 保单号、报案号、计算书号、生长期、清单号
     * @return shortLink 文件下载短链接
     * @throws Exception
     * @author 王心洋
     * @time 2017-12-27
     */
    String expPlantingClaimListExcel(RequestQueryClaimListDto requestQueryClaimListDto) throws Exception;

    /**
     * 养殖险理赔清单组装导出Excel
     * @param requestQueryClaimListDto 保单号、报案号、计算书号、生长期、清单号
     * @return shortLink 文件下载短链接
     * @throws Exception
     * @author 王心洋
     * @time 2017-12-27
     */
    String expBreedClaimListExcel(RequestQueryClaimListDto requestQueryClaimListDto) throws Exception;




    /**
     * 种植险理赔清单导出Excel
     * @param requestNyxPlantingClaimListDto 理赔清单号、保单号、报案号、计算书号、农户代码 、导出类型
     * @return shortLink 文件下载短链接
     * @throws Exception
     * @author 李文刚
     * @time 2017-12-29
     */

    public Map<String,String> nyxPlantingClaimListExportExcel(RequestNyxPlantingClaimListDto requestNyxPlantingClaimListDto) throws Exception;

    /**
     * 养殖险理赔清单导出Excel
     * @param requestNyxBreedClaimListDto 理赔清单号、保单号、报案号、计算书号、农户代码、导出类型
     * @return shortLink 文件下载短链接
     * @throws Exception
     * @author 李文刚
     * @time 2017-12-29
     */
    public Map<String,String> nyxBreedClaimListExportExcel(RequestNyxBreedClaimListDto requestNyxBreedClaimListDto) throws Exception;












    /**
     * （种植险理赔清单数据的导入保存）
     * @author: 孙朋飞
     * @date: 2017/12/28 20:34
     * @param fileId 文件标识id
     * @param comCode 机构代码
     * @param growthPeriod 苗期
     * @param  nodeType 节点类型
     * @param  damageWay 出险方式
     * @param damageDegree 溃塘程度/泛塘时间
     * @return 返回清单号和总赔偿金额
     * @throws Exception
     */
    public Map<String,Object> importPlantingClaimListExcel(String fileId,String comCode,String growthPeriod,String nodeType,String damageWay,String damageDegree) throws Exception;
    /**
     * （养殖险理赔清单数据的导入保存）
     * @author: 孙朋飞
     * @date: 2017/12/29 11:08
     * @param fileId 文件标识id
     * @return 清单号和支付金额
     * @throws Exception
     */
    public Map<String,Object> importBreedClaimListExcel(String fileId,String comCode,String growthPeriod,String nodeType) throws Exception;
    /**
     * （养殖险定损清单数据的下载）
     * @author: 孙朋飞
     * @date: 2017/12/29 19:41
     * @param map 报案号
     * @return 生成下载短链接
     * @throws Exception
     */
    public String expBreedLossRateList(Map<String, String> map) throws Exception;

    /**
     * （种植险定损清单数据的下载）
     * @author: 祁小龙
     * @date: 2017/12/29 19:41
     * @param map 报案号
     * @return 生成下载短链接
     * @throws Exception
     */
    public String expPlantingLossRateList(Map<String, String> map) throws Exception;
    /**
     *定损清单下载（种植险和养殖险）
     * @author: 孙朋飞
     * @date: 2018/1/19 14:15
     * @param map registNo报案号
     * @return 生成下载短链接
     * @throws Exception
     */
    public String expBreedAndPlantingLossRateList(Map<String, String> map) throws Exception;
    /**
     *定损清单下载（种植险和养殖险）
     * @author: 陈道洋
     * @date: 2018/1/19 14:15
     * @param map registNo报案号
     * @return 生成下载短链接
     * @throws Exception
     */
    public String downloadlList(Map<String, String> map) throws Exception;
    /**
     * 特殊赔案清单下载
     * @author: 孙朋飞
     * @date: 2018/1/23 9:47
     * @param map 清单号 listNo
     * @return 生成下载短链接
     * @throws Exception
     */
    public String expSpecCaseList(Map<String, String> map) throws Exception;
    /**
     * 特殊赔案清单模板下载
     * @author: 王心洋
     * @date: 2018/4/12
     * @param map 保单号 出险日期
     * @return 生成下载短链接
     * @throws Exception
     */
    public Map<String,String> expSpecCaseModelList(Map<String,String> map) throws Exception;
    /**
     *特殊赔案清单的导入保存
     * @author: 孙朋飞
     * @date: 2018/1/24 14:23
     * @param fileId 文件id
     * @param comCode 机构代码
     * @return 返回预赔金额和清单号
     * @throws Exception
     */
    public Map<String,Object> importSpecCaseListExcel(String fileId,String comCode)throws Exception;
    /**
     * 查询查勘页面初始化成灾面积等
     * @author: 孙朋飞
     * @date: 2018/4/13 16:22
     * @param map registNo-报案号，policyNo-保单号
     * @return 查勘定损登记集合
     * @throws Exception
     */
    public ResponseCheckDto queryBreedAndPlantingLossRateListPageInit(Map<String, String> map ) throws Exception;
}
