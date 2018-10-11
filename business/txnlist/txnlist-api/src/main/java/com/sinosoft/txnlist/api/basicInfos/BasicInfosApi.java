package com.sinosoft.txnlist.api.basicInfos;

import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.basicInfos.dto.BasicInfosDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-23 12:58:53.230 
 * @description basicInfosApi接口
 */
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = BasicInfosApi.PATH)
public interface BasicInfosApi {

    public static final String PATH = "basicInfos";

    /**
     *@description 测试
     *@param
     */
    @RequestMapping(value = "test",method = {RequestMethod.GET})
    Map<String,Object> test();

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(BasicInfosDto basicInfosDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String code);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(BasicInfosDto basicInfosDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    BasicInfosDto queryByPK(String code);
}