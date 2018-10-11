package com.sinosoft.agriprpall.api.proposalmanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTmainAgriDto;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 08:03:36.446 
 * @description 农业险投保单信息表Api接口
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = PrpTmainAgriApi.PATH)
public interface PrpTmainAgriApi {

    public static final String PATH = "prpTmainAgri";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpTmainAgriDto prpTmainAgriDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String proposalNo);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpTmainAgriDto prpTmainAgriDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpTmainAgriDto queryByPK(String proposalNo);
}