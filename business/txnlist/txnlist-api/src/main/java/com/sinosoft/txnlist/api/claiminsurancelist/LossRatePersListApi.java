package com.sinosoft.txnlist.api.claiminsurancelist;

import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.LossRatePersListDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-17 06:38:35.329 
 * @description 定损清单农户标的明细表-人Api接口
 */
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = LossRatePersListApi.PATH)
public interface LossRatePersListApi {

    public static final String PATH = "lossRatePersList";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(LossRatePersListDto lossRatePersListDto);

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
    void modify(LossRatePersListDto lossRatePersListDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    LossRatePersListDto queryByPK(Map<String,String> map);
}