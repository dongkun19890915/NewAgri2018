package com.sinosoft.txnlist.api.plantinginsurancelist;

import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxCpEndorChgDetailDto;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * @description nyxcpendorchgdetailApi接口
 */
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = NyxCpEndorChgDetailApi.PATH)
public interface NyxCpEndorChgDetailApi {

    public static final String PATH = "nyxCpEndorChgDetail";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(@RequestBody NyxCpEndorChgDetailDto nyxCpEndorChgDetailDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    public void remove(@RequestParam(value = "insureListCode") String insureListCode)throws Exception;
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(@RequestBody NyxCpEndorChgDetailDto nyxCpEndorChgDetailDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
//    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
//    NyxCpEndorChgDetailDto queryByPK(String inusreListCode,String businessNo,String kindCode,String itemCode);
    @RequestMapping(value = "saveList",method = {RequestMethod.POST})
    public void saveList(@RequestBody List<NyxCpEndorChgDetailDto> nyxCpEndorChgDetailDtoList)throws Exception;

    @RequestMapping(value = "queryByInsureListCode",method = {RequestMethod.POST})
    public @ResponseBody List<NyxCpEndorChgDetailDto> queryByInsureListCode(@RequestBody Map<String,String> map)throws Exception;
}