package com.sinosoft.txnlist.api.claiminsurancelist;

import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-17 06:38:35.329 
 * @description 定损清单主表Api接口
 */
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = LossRateMainListApi.PATH)
public interface LossRateMainListApi {

    public static final String PATH = "lossRateMainList";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(LossRateMainListDto lossRateMainListDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(Map<String,String> map);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(LossRateMainListDto lossRateMainListDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    LossRateMainListDto queryByPK(Map<String,String> map);

    /**
     *@description 按清单号查询最大序列号
     *@param map 清单号
     *@return serialNo 最大序列号
     *@author 王心洋
     *@time 2018-01-18
     */
    @RequestMapping(value = "queryMaxSerialByLossListCode",method = {RequestMethod.POST})
    Integer queryMaxSerialByLossListCode(Map<String,String> map) throws Exception;

    /**
     * 按条件查询未关联主表信息实体集合
     * @param map 保单号,报案号
     * @return List<LossRateListDto>定损清单信息列表
     * @author 王心洋
     * @time 2018-01-19
     */
    @RequestMapping(value = "queryByConditions",method = {RequestMethod.POST})
    List<LossRateMainListDto> queryByConditions(Map<String,String> map) throws Exception;
    /**
     * 关联报案号和清单信息
     * @param map 损失率清单号,报案号
     * @author 王心洋
     * @time 2018-01-19
     */
    @RequestMapping(value = "compareInsurance",method = {RequestMethod.POST})
    void compareInsurance(Map<String,String> map) throws Exception;
    /**
     * 按条件查询已关联实体集合
     * @param map 保单号,报案号
     * @return LossRateWholeListDto定损清单信息列表
     * @author 王心洋
     * @time 2018-01-19
     */
    @RequestMapping(value = "queryComparable",method = {RequestMethod.POST})
    LossRateWholeListDto queryComparable(Map<String,String> map) throws Exception;
    /**
     * 根据保单号、报案号查询定损清单表中有耳标号的清单号
     * @param map policyNo 保单号
     * @param map bizNo 报案号
     * @return String 清单号
     * @author 王心洋
     * @time 2018-01-23
     */
    @RequestMapping(value = "queryEarLabelCount",method = {RequestMethod.POST})
    String queryEarLabelCount( Map<String, String> map) throws Exception;
    /**
     * 查询养殖险的定损清单
     * @author: 孙朋飞
     * @date: 2018/1/19 9:26
     * @param map registNo 报案号，保单号policyNo
     * @return 养殖险的定损清单集合
     * @throws Exception
     */
    @RequestMapping(value = "queryBreedLossRateListByLossListCode",method = {RequestMethod.POST})
    public @ResponseBody List<ResponseBreedLossRateListDto> queryBreedLossRateListByLossListCode(@RequestBody Map<String,String> map) throws Exception;
    /**
     * 查询种植险的定损清单
     * @author: 孙朋飞
     * @date: 2018/1/19 14:40
     * @param map registNo 报案号，保单号policyNo，nodeType-节点类型，lossListCode清单号
     * @return 种植险的定损清单集合
     * @throws Exception
     */
    @RequestMapping(value = "queryPlantingLossRateListByLossListCode",method = {RequestMethod.POST})
    public @ResponseBody List<ResponsePlantingLossRateListDto> queryPlantingLossRateListByLossListCode(@RequestBody Map<String,String> map) throws Exception;

    /**
     * 查询养殖险的定损清单
     * @author: 陈道洋
     * @date: 2018/1/19 9:26
     * @param map registNo 报案号和清单号lossListCode
     * @return 养殖险的定损清单集合
     * @throws Exception
     */
    @RequestMapping(value = "downloadlList",method = {RequestMethod.POST})
    public @ResponseBody List<ResponseBreedLossRateListDto> downloadlList(@RequestBody Map<String,String> map) throws Exception;
    /**
     * 查询种植险的定损清单
     * @author: 陈道洋
     * @date: 2018/1/19 14:40
     * @param map registNo 报案号和 清单号lossListCode
     * @return 种植险的定损清单集合
     * @throws Exception
     */
    @RequestMapping(value = "plantingdownloadlList",method = {RequestMethod.POST})
    public @ResponseBody List<ResponsePlantingLossRateListDto> plantingdownloadlList(@RequestBody Map<String,String> map) throws Exception;

    /**
     * 定损清单大对象保存接口
     * @author: 王心洋
     * @date: 2018/3/19
     * @param requestGYLossRateAllListDto
     * @throws Exception
     */
    @RequestMapping(value = "saveLossRateAllList",method = {RequestMethod.POST})
    void saveLossRateAllList(@RequestBody LossRateWholeListDto requestGYLossRateAllListDto) throws Exception;

    /**
     * 通过报案号和清单号查询是否关联
     * @author: 孙朋飞
     * @date: 2018/3/31 16:09
     * @param registNo 报案号
     * @param lossListCode 清单号
     * @return 是否关联
     * @throws Exception
     */
    @RequestMapping(value = "queryLossRateMainListByRegistNoAndLossListCode",method = {RequestMethod.POST})
    public @ResponseBody boolean queryLossRateMainListByRegistNoAndLossListCode(@RequestParam("registNo")String registNo,@RequestParam("lossListCode")String lossListCode) throws Exception;
    /**
     * g根据保单号查询清单号
     * @author: 陈道洋
     * @date: 2018/3/31 16:09
     * @param  policyNo 保单号
     * @return 是否关联
     * @throws Exception
     */
    @RequestMapping(value = "queryByPolicyNo",method = {RequestMethod.POST})
    public void queryByPolicyNo(@RequestParam("policyNo")String policyNo ,@RequestParam("nodeOrigin")String nodeOrigin,@RequestParam("registNo")String registNo) throws Exception;

    /**
     * g根据保单号查询清单号
     * @author: 陈道洋
     * @date: 2018/3/31 16:09
     * @param  registNo 保单号
     * @return 是否关联
     * @throws Exception
     */
    @RequestMapping(value = "queryByregistNo",method = {RequestMethod.POST})
    public List<LossRateMainListDto> queryByregistNo(@RequestParam("registNo")String registNo) throws Exception;

    /**
     * 通过保单号和报案号查询查勘编号（checkId）
     * @param （policyNo保单号 bizNo报案号）
     * @return 查勘编号（checkId）
     * @throws Exception
     * @author: 李文刚
     * @date: 2018/4/16 16:09
     */
    @RequestMapping(value ="findCheckId", method = {RequestMethod.POST})
    public @ResponseBody
    List<LossRateMainListDto> findCheckId(@RequestBody  LossRateMainListDto lossRateMainListDto) throws Exception;

    /**
     * 根据清单号和保单号回写报案号
     * @author: 孙朋飞
     * @date: 2018/4/23 9:26
     * @param map 清单号lossListCode，保单号policyNo，报案号registNo
     * @throws Exception
     */
    @RequestMapping(value="updateLossRateMainListByLossListCode",method = {RequestMethod.POST})
    public @ResponseBody void updateLossRateMainListByLossListCode(@RequestBody Map<String,String> map) throws Exception;

}