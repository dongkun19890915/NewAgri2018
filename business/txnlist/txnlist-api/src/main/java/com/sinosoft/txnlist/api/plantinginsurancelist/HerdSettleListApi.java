package com.sinosoft.txnlist.api.plantinginsurancelist;

import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdSettleListDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * @description 养殖险理赔明细表Api接口
 */
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = HerdSettleListApi.PATH)
public interface HerdSettleListApi {

    public static final String PATH = "herdSettleList";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(HerdSettleListDto herdSettleListDto);

//    /**
//     *@description 删除
//     *@param
//     */
//    @RequestMapping(value = "remove",method = {RequestMethod.POST})
//    void remove(String settleListCode,String earLabel,String fCode,String kindCode,java.lang.Integer serialNo);
//    /**
//     *@description 修改
//     *@param
//     */
//    @RequestMapping(value = "modify",method = {RequestMethod.POST})
//    void modify(HerdSettleListDto herdSettleListDto);
//    /**
//     *@description 按主键查询实体
//     *@param
//     */
//    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
//    HerdSettleListDto queryByPK(String settleListCode,String earLabel,String fCode,String kindCode,java.lang.Integer serialNo);

    /**
     *  根据GIS清单号查询承保清单 养殖险
     * @param gisInsureListCode
     * @return
     * @throws Exception
     * @author 汪强
     */
    @RequestMapping(value = "queryByGisInsureListCode",method = {RequestMethod.POST})
    @ResponseBody List<HerdSettleListDto> queryByGisInsureListCode(@RequestParam("gisInsureListCode") String gisInsureListCode)throws Exception;
}