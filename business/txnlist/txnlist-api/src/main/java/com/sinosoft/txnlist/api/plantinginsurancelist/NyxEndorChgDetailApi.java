package com.sinosoft.txnlist.api.plantinginsurancelist;

import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxEndorChgDetailDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * @description nyxendorchgdetailApi接口
 */
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = NyxEndorChgDetailApi.PATH)
public interface NyxEndorChgDetailApi {

    public static final String PATH = "nyxEndorChgDetail";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(@RequestBody NyxEndorChgDetailDto nyxEndorChgDetailDto);

    /**
     *@description 删除
     *@param
     */
//    @RequestMapping(value = "remove",method = {RequestMethod.POST})
//    void remove(String inusreListCode,String businessNo,String endorseNo,String kindCode,String itemCode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(@RequestBody NyxEndorChgDetailDto nyxEndorChgDetailDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
//    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
//    NyxEndorChgDetailDto queryByPK(String inusreListCode,String businessNo,String endorseNo,String kindCode,String itemCode);

    @RequestMapping(value = "removeByEnodrseNo",method = {RequestMethod.POST})
    public void removeByEnodrseNo(@RequestParam(value = "endorseNo") String endorseNo)throws Exception;
    @RequestMapping(value = "saveList",method = {RequestMethod.POST})
    public void saveList(@RequestBody List<NyxEndorChgDetailDto> nyxEndorChgDetailDtoList)throws Exception;
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    NyxEndorChgDetailDto queryByPK(@RequestBody Map<String,String> map);
    /**
     *  根据批单号码集合查询planting的批改变化量清单
     * @author: 田健
     * @date: 2018/4/11 10:19
     * @param endorseNoList 批单集合
     * @return 分户清单批改变化量信息
     */
    @RequestMapping(value = "queryByEndorseNoList",method = {RequestMethod.POST})
    public @ResponseBody Map<String,List<NyxEndorChgDetailDto>> queryByEndorseNoList(@RequestBody List<String> endorseNoList);

    /**
     * 根据批单号码集合查询nyx的批改变化量清单
     *
     * @param param endorseNo-批单号
     * @return List<NyxEndorChgDetailDto>
     * @date: 2018/4/13 18:12
     * @author: 何伟东
     */
    @RequestMapping(value = "queryByEndorseNo", method = {RequestMethod.POST})
    @ResponseBody
    List<NyxEndorChgDetailDto> queryByEndorseNo(@RequestBody Map<String, String> param);
}