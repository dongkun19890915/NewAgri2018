package com.sinosoft.txnlist.api.plantinginsurancelist;

import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.RegisterCoderDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.SettleMainListDto;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * @description settlemainlistApi接口
 */
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = SettleMainListApi.PATH)
public interface SettleMainListApi {

    public static final String PATH = "settleMainList";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(SettleMainListDto settleMainListDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String settleListCode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(SettleMainListDto settleMainListDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    SettleMainListDto queryByPK(String settleListCode);

    @RequestMapping(value = "queryByCondition",method = {RequestMethod.POST})
    public List<SettleMainListDto> queryByCondition(@RequestBody Map<String,String> map)throws Exception;
    
    /**
     *@description 按立案号查询实体
     *@param 
     *@author 马俊玲
     */
    @RequestMapping(value = "queryByRegisterCode",method = {RequestMethod.POST})
    @ResponseBody List<SettleMainListDto> queryByRegisterCode(@RequestBody Map<String,String> listMap);
    /**
     *@description 查询实体
     *@param
     *@author 马俊玲
     */
    @RequestMapping(value = "queryByRegisterCodeAndValidity",method = {RequestMethod.POST})
    public @ResponseBody List<SettleMainListDto> queryByRegisterCodeAndValidity(@RequestBody RegisterCoderDto registerCoderDto);
}