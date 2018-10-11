package com.sinosoft.txnlist.api.claiminsurancelist;

import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.LossRateListDto;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.RequestSaveLossRateListDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-26 08:50:16.862 
 * @description 理赔清单信息主表Api接口
 */
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = LossRateListApi.PATH)
public interface LossRateListApi {

    public static final String PATH = "lossRateList";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(LossRateListDto lossRateListDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String listNo       );
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(LossRateListDto lossRateListDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    LossRateListDto queryByPK(String listNo       );
    /**
     * 按条件查询实体集合
     * @param map 保单号,报案号
     * @return List<LossRateListDto>定损清单信息列表
     * @author 王心洋
     * @time 2017-12-25
     */
    @RequestMapping(value = "queryByConditions",method = {RequestMethod.POST})
    List<LossRateListDto> queryByConditions(@RequestBody Map<String,String> map);
    /**
     * 关联报案号和清单信息
     * @param map 损失率清单号,报案号
     * @author 王心洋
     * @time 2017-12-25
     */
    @RequestMapping(value = "compareInsurance",method = {RequestMethod.POST})
    void compareInsurance(@RequestBody Map<String,String> map);
    /**
     * 按条件查询已关联实体集合
     * @param map 保单号,报案号
     * @return List<LossRateListDto>定损清单信息列表
     * @author 王心洋
     * @time 2017-12-26
     */
    @RequestMapping(value = "queryComparable",method = {RequestMethod.POST})
    List<LossRateListDto> queryComparable(Map<String,String> map);
    /**
     * 金禾调用定损清单保存接口
     * @param requestSaveLossRateListDto 金禾传入保存大对象
     * @author 王心洋
     * @time 2018-01-03
     */
    @RequestMapping(value = "saveLossRateList",method = {RequestMethod.POST})
    public void saveLossRateList(RequestSaveLossRateListDto requestSaveLossRateListDto);
}