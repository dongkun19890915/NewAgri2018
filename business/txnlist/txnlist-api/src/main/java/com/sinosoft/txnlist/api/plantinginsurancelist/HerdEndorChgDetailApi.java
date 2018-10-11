package com.sinosoft.txnlist.api.plantinginsurancelist;

import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdEndorChgDetailDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-14 07:07:05.012 
 * @description 养殖险保单清单最新数据表Api接口
 */
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = HerdEndorChgDetailApi.PATH)
public interface HerdEndorChgDetailApi {

    public static final String PATH = "herdEndorChgDetail";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(HerdEndorChgDetailDto herdEndorChgDetailDto);



    /**
     * 按照清单号删除
     *@param inusreListCode 清单号
     *@author 王心洋
     *@time 2017-11-18
     */
    @RequestMapping(value = "removeByInusreListCode",method = {RequestMethod.POST})
    void removeByInusreListCode(@RequestParam("inusreListCode")String inusreListCode);
    /**
     * 按照清单号删除
     *@param inusreListCode 清单号
     *@author 王心洋
     *@time 2017-11-18
     */
    @RequestMapping(value = "getSumInsured",method = {RequestMethod.POST})
    int getSumInsured(@RequestParam("inusreListCode")String inusreListCode);
    /**
     * 批改保存前删除
     * @param endorseNo 批单号
     * @return void
     * @throws
     * @author 李冬松
     * @date 17:10 2018/4/12
     */
    @RequestMapping(value = "removeByEndorseNo",method = {RequestMethod.POST})
    public void removeByEndorseNo(@RequestParam("endorseNo")String endorseNo)throws Exception;
    @RequestMapping(value = "saveList",method = {RequestMethod.POST})
    public void saveList(@RequestBody List<HerdEndorChgDetailDto> herdEndorChgDetailDtoList)throws Exception;
    /**
     *  根据批单号码集合查询planting的批改变化量清单
     * @author: 田健
     * @date: 2018/4/11 10:19
     * @param endorseNoList 批单集合
     * @return 分户清单批改变化量信息
     */
    @RequestMapping(value = "queryByEndorseNoList",method = {RequestMethod.POST})
    public @ResponseBody Map<String,List<HerdEndorChgDetailDto>> queryByEndorseNoList(@RequestBody List<String> endorseNoList);

    /**
     * 根据批单号码查询herd的批改变化量清单
     *
     * @param param endorseNo-批单号码
     * @return List<HerdEndorChgDetailDto>
     * @date: 2018/4/13 17:57
     * @author: 何伟东
     */
    @RequestMapping(value = "queryByEndorseNo", method = {RequestMethod.POST})
    @ResponseBody
    List<HerdEndorChgDetailDto> queryByEndorseNo(@RequestBody Map<String, String> param);
}