package com.sinosoft.agriclaim.api.businessutilmanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLCfeecoinsDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:35:28.283 
 * @description 共保费用信息表（无表名）Api接口
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = PrpLCfeecoinsApi.PATH)
public interface PrpLCfeecoinsApi {

    public static final String PATH = "prpLCfeecoins";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpLCfeecoinsDto prpLCfeecoinsDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestParam("businessNo")String businessNo,@RequestParam("serialNo")java.lang.Double serialNo);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpLCfeecoinsDto prpLCfeecoinsDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpLCfeecoinsDto queryByPK(@RequestParam("businessNo")String businessNo,@RequestParam("serialNo")java.lang.Double serialNo);


    /**
     * @description 共保费用信息表查询
     * @param xml 入参报文
     * @return returnXml 反参报文
     * @throws Exception
     * @author 周柯宇
     * @date 2017-12-8 18:43:36
     */
    @RequestMapping(value = "queryByBusinessNo",method = {RequestMethod.POST})
    public List<PrpLCfeecoinsDto> queryByBusinessNo(@RequestParam("businessNo") String businessNo) throws Exception;

}