package com.sinosoft.dms.api.dict;

import com.sinosoft.dms.api.DMSConstant;
import com.sinosoft.dms.api.dict.dto.PrpDcurrencyDto;
import com.sinosoft.dms.api.dict.dto.PrpDcurrencyRequestDto;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:56.447
 * @description 币别代码表Api接口
 */
@FeignClient(name = DMSConstant.DMS_SERVICE_NAME, path = PrpDcurrencyApi.PATH)
public interface PrpDcurrencyApi {

    public static final String PATH = "prpDcurrency";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(@RequestBody PrpDcurrencyDto prpDcurrencyDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestParam("currencyCode") String currencyCode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(@RequestBody PrpDcurrencyDto prpDcurrencyDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpDcurrencyDto queryByPK(@RequestParam("currencyCode") String currencyCode);

    /**
     * 根据条件查询币别信息
     * @author: 宋振振
     * @date: 2017/10/29 11:53
     * @param prpDcurrencyRequestDto 币别查询请求参数的Dto
     * @return List<PrpDcurrencyDto> 返回币别信息
     * @throws Exception
     */
    @RequestMapping(value = "queryPrpDcurrencyByCondition",method = {RequestMethod.POST})
    public @ResponseBody List<PrpDcurrencyDto> queryPrpDcurrencyByCondition(@RequestBody PrpDcurrencyRequestDto prpDcurrencyRequestDto)throws Exception;

    /**
     * @description: 按照币别代码和中英文标志查询币别
     * @author 王心洋
     * @param currencyCode
     * @param languageFlag
     * @return
     * @time 2017-10-31
     */
    @RequestMapping(value = "translateCode",method = {RequestMethod.POST})
    public String translateCode(@RequestParam("currencyCode") String currencyCode,@RequestParam("languageFlag") String languageFlag);
    /**
     * @description:方法功能简述: 查询所有的币别信息，进行下拉框初始化
     * @author 安齐崇
     * @date 2017年12月13日下午11:56:23
     * @return
     */
    @RequestMapping(value = "queryAll",method = {RequestMethod.POST})
    public @ResponseBody List<PrpDcurrencyDto> queryAll();
}