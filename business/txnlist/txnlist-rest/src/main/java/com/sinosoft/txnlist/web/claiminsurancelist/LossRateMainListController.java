package com.sinosoft.txnlist.web.claiminsurancelist;

import com.sinosoft.txnlist.api.claiminsurancelist.LossRateMainListApi;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.*;
import com.sinosoft.txnlist.core.claiminsurancelist.service.LossRateMainListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-17 06:38:35.329 
 * @description 定损清单主表controller层
 */
@RestController
@RequestMapping(value = LossRateMainListController.PATH)
public class LossRateMainListController implements LossRateMainListApi {

    private static Logger LOGGER = LoggerFactory.getLogger(LossRateMainListController.class);

    @Autowired
    private LossRateMainListService lossRateMainListService;

    /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody LossRateMainListDto lossRateMainListDto) {
        lossRateMainListService.save(lossRateMainListDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody Map<String,String> map) {
        String lossListCode = map.get("lossListCode");
        java.lang.Integer serialNo = Integer.parseInt(map.get("serialNo"));
        lossRateMainListService.remove(lossListCode,serialNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody LossRateMainListDto lossRateMainListDto) {
        lossRateMainListService.modify(lossRateMainListDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public LossRateMainListDto queryByPK(@RequestBody Map<String,String> map) {
        String lossListCode = map.get("lossListCode");
        java.lang.Integer serialNo = Integer.parseInt(map.get("serialNo"));
        return lossRateMainListService.queryByPK(lossListCode,serialNo);
    }

    /**
     *@description 按清单号查询最大序列号
     *@param map 清单号
     *@return serialNo 最大序列号
     *@author 王心洋
     *@time 2018-01-18
     */
    public Integer queryMaxSerialByLossListCode(@RequestBody Map<String,String> map) throws Exception{
        String lossListCode = map.get("lossListCode");
        return lossRateMainListService.queryMaxSerialByLossListCode(lossListCode);
    }

    /**
     * 按条件查询未关联主表信息实体集合
     * @param map 保单号,报案号
     * @return List<LossRateMainListDto>定损清单信息列表
     * @author 王心洋
     * @time 2018-01-19
     */
    @Override
    public List<LossRateMainListDto> queryByConditions(@RequestBody Map<String, String> map) throws Exception{
        String policyNo = map.get("policyNo");
        String bizNo = map.get("bizNo");
        return lossRateMainListService.queryByConditions(policyNo,bizNo);
    }

    /**
     * 关联报案号和清单信息
     * @param map 损失率清单号,报案号
     * @author 王心洋
     * @time 2018-01-19
     */
    @Override
    public void compareInsurance(@RequestBody Map<String, String> map) throws Exception{
        String lossListCode = map.get("lossListCode");
        String bizNo = map.get("bizNo");
        String checkBoxFlag = map.get("checkBoxFlag");
        String serialNo = map.get("serialNo");
        lossRateMainListService.compareInsurance(lossListCode, bizNo,checkBoxFlag,serialNo);
    }

    /**
     * 按条件查询已关联实体集合
     * @param map 保单号,报案号
     * @return LossRateWholeListDto定损清单信息列表
     * @author 王心洋
     * @time 2018-01-19
     */
    @Override
    public LossRateWholeListDto queryComparable(@RequestBody Map<String, String> map) throws Exception{
        String policyNo = map.get("policyNo");
        String bizNo = map.get("bizNo");
        return lossRateMainListService.queryComparable(policyNo,bizNo);
    }

    /**
     * 根据保单号、报案号查询定损清单表中有耳标号的清单号
     * @param map policyNo 保单号
     * @param map bizNo 报案号
     * @return String 清单号
     * @author 王心洋
     * @time 2018-01-23
     */
    @Override
    public String queryEarLabelCount(@RequestBody Map<String, String> map) throws Exception{
        String policyNo = map.get("policyNo");
        String bizNo = map.get("bizNo");
        return lossRateMainListService.queryEarLabelCount(policyNo,bizNo);
    }

    /**
     * 查询养殖险的定损清单
     * @author: 孙朋飞
     * @date: 2018/1/19 9:26
     * @param map registNo 报案号,policyNo-保单号，nodeType-节点类型
     * @return 养殖险的定损清单集合
     * @throws Exception
     */
    @Override
    public @ResponseBody List<ResponseBreedLossRateListDto> queryBreedLossRateListByLossListCode(@RequestBody Map<String, String> map) throws Exception {
        return lossRateMainListService.queryBreedLossRateListByLossListCode(map.get("registNo"),map.get("policyNo"),map.get("nodeType"),map.get("lossListCode"));
    }
    /**
     * 查询种植险的定损清单
     * @author: 孙朋飞
     * @date: 2018/1/19 14:40
     * @param map registNo 报案号，保单号policyNo，nodeType-节点类型，lossListCode清单号
     * @return 种植险的定损清单集合
     * @throws Exception
     */
    @Override
    public @ResponseBody  List<ResponsePlantingLossRateListDto> queryPlantingLossRateListByLossListCode(@RequestBody Map<String, String> map) throws Exception {
        return lossRateMainListService.queryPlantingLossRateListByLossListCode(map.get("registNo"),map.get("policyNo"),map.get("nodeType"),map.get("lossListCode"));
    }
    /**
     * 查询养殖险的定损清单
     * @author: 陈道洋
     * @date: 2018/1/19 9:26
     * @param map registNo 报案号
     * @return 养殖险的定损清单集合
     * @throws Exception
     */
    @Override
    public @ResponseBody List<ResponseBreedLossRateListDto> downloadlList(@RequestBody Map<String, String> map) throws Exception {
        return lossRateMainListService.downloadlList(map.get("registNo"),map.get("lossListCode"),map.get("policyNo"));
    }
    /**
     * 查询种植险的定损清单
     * @author: 陈道洋
     * @date: 2018/1/19 14:40
     * @param map registNo 报案号和 lossListCode清单号
     * @return 种植险的定损清单集合
     * @throws Exception
     */
    @Override
    public @ResponseBody  List<ResponsePlantingLossRateListDto> plantingdownloadlList(@RequestBody Map<String, String> map) throws Exception {
        return lossRateMainListService.plantingdownloadlList(map.get("registNo"),map.get("lossListCode"),map.get("policyNo"));
    }
    /**
     * 定损清单大对象保存接口
     * @author: 王心洋
     * @date: 2018/3/19
     * @param requestGYLossRateAllListDto
     * @throws Exception
     */
    @Override
    public void saveLossRateAllList(@RequestBody LossRateWholeListDto requestGYLossRateAllListDto) throws Exception{
        lossRateMainListService.saveLossRateAllList(requestGYLossRateAllListDto);
    }
    /**
     * 通过报案号和清单号查询是否关联
     * @author: 孙朋飞
     * @date: 2018/3/31 16:09
     * @param registNo 报案号
     * @param lossListCode 清单号
     * @return 是否关联
     * @throws Exception
     */
    @Override
    public @ResponseBody boolean queryLossRateMainListByRegistNoAndLossListCode(@RequestParam("registNo") String registNo,@RequestParam("lossListCode") String lossListCode) throws Exception {
        return lossRateMainListService.queryLossRateMainListByRegistNoAndLossListCode(registNo,lossListCode);
    }
    /**
     * g根据保单号查询清单号
     * @author: 陈道洋
     * @date: 2018/3/31 16:09
     * @param  policyNo 保单号
     * @return 是否关联
     * @throws Exception
     */
    public void queryByPolicyNo(@RequestParam("policyNo")String policyNo ,@RequestParam("nodeOrigin")String nodeOrigin,@RequestParam("registNo")String registNo) throws Exception{
         lossRateMainListService.queryByPolicyNo(policyNo,nodeOrigin,registNo);
    }
    /**
     * g根据保单号查询清单号
     * @author: 陈道洋
     * @date: 2018/3/31 16:09
     * @param  registNo 保单号
     * @return 是否关联
     * @throws Exception
     */
    public List<LossRateMainListDto> queryByregistNo(@RequestParam("registNo")String registNo) throws Exception {
       return lossRateMainListService.queryByregistNo(registNo);
    }

    /**
     * 通过保单号和报案号查询查勘编号（checkId）
     * @param （policyNo保单号 bizNo报案号）
     * @return 查勘编号（checkId）
     * @throws Exception
     * @author: 李文刚
     * @date: 2018/4/16 16:09
     */
    @Override
    public @ResponseBody List<LossRateMainListDto> findCheckId(@RequestBody LossRateMainListDto lossRateMainListDto) throws Exception{
        return lossRateMainListService.findCheckId(lossRateMainListDto);

    }
    /**
     * 根据清单号和保单号回写报案号
     * @author: 孙朋飞
     * @date: 2018/4/23 9:26
     * @param map 清单号lossListCode，保单号policyNo，报案号registNo
     * @throws Exception
     */
    @Override
    public @ResponseBody void updateLossRateMainListByLossListCode(@RequestBody Map<String, String> map) throws Exception {
        lossRateMainListService.updateLossRateMainListByLossListCode(map.get("lossListCode"),map.get("policyNo"),map.get("registNo"));
    }


}
