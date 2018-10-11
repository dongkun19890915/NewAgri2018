package com.sinosoft.agriprpall.api.proposalmanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTplanCoinsDto;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 01:57:51.087 
 * @description 共保方收费计划表Api接口
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = PrpTplanCoinsApi.PATH)
public interface PrpTplanCoinsApi {

    public static final String PATH = "prpTplanCoins";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpTplanCoinsDto prpTplanCoinsDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String proposalNo, String coinsCode, Integer serialNo, String payReason);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpTplanCoinsDto prpTplanCoinsDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpTplanCoinsDto queryByPK(String proposalNo, String coinsCode, Integer serialNo, String payReason);
}