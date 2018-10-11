package com.sinosoft.agriclaim.api.compensatemanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLLossDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225 
 * @description 赔付标的信息表Api接口
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = PrpLLossApi.PATH)
public interface PrpLLossApi {

    public static final String PATH = "prpLLoss";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpLLossDto prpLLossDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestParam("compensateNo") String compensateNo,@RequestParam("serialNo")java.lang.Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpLLossDto prpLLossDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpLLossDto queryByPK(@RequestParam("compensateNo") String compensateNo,@RequestParam("serialNo")java.lang.Integer serialNo);

    /**
     *
     * @description 根据业务号查询PrpLLoss表
     * @author 周柯宇
     * @date 2018年1月26日 下午3:49:27
     * @param businessNo
     * @return List<PrpLLossDto>
     * @Throws Exception
     */
    @RequestMapping(value = "queryByBusinessNo",method = {RequestMethod.POST})
    List<PrpLLossDto> queryByBusinessNo(@RequestParam("businessNo")String businessNo);
}