package com.sinosoft.agriclaim.api.compensatemanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLChargeDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225 
 * @description 赔款费用信息表Api接口
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = PrpLChargeApi.PATH)
public interface PrpLChargeApi {

    public static final String PATH = "prpLCharge";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpLChargeDto prpLChargeDto);

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
    void modify(PrpLChargeDto prpLChargeDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpLChargeDto queryByPK(@RequestParam("compensateNo") String compensateNo,@RequestParam("serialNo")java.lang.Integer serialNo);

    /**
     *
     * @description 根据业务号查询PrpLCharge
     * @author 周柯宇
     * @date 2018年1月26日 下午3:53:37
     * @param 业务号
     * @return List<PrpLChargeDto>
     * @Throws Exception
     */
    @RequestMapping(value = "queryByBusinessNo",method = {RequestMethod.POST})
    List<PrpLChargeDto> queryByBusinessNo(@RequestParam("businessNo")String businessNo);

    /**
     * （理算保存赔付信息先删除历史数据）
     * @author: 王志文
     * @date: 2018/4/27 15:05
     * @param compensateNo
     * @throws Exception
     */
    @RequestMapping(value = "deletePrpLchargeForCompeSave",method = {RequestMethod.POST})
    void deletePrpLchargeForCompeSave(@RequestParam("compensateNo") String compensateNo)throws Exception;
}