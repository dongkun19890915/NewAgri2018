package com.sinosoft.agriprpall.api.proposalmanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTsubsidyDto;
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
 * @description 补贴表Api接口
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = PrpTsubsidyApi.PATH)
public interface PrpTsubsidyApi {

    public static final String PATH = "prpTsubsidy";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpTsubsidyDto prpTsubsidyDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String proposalNo, String subsidyCode, String subsidyType);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpTsubsidyDto prpTsubsidyDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpTsubsidyDto queryByPK(String proposalNo, String subsidyCode, String subsidyType);
}