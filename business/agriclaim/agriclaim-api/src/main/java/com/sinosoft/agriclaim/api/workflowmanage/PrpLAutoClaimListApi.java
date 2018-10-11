package com.sinosoft.agriclaim.api.workflowmanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.workflowmanage.dto.PrpLAutoClaimListDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfLogDto;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-23 10:17:47.442 
 * @description 自动理赔清单数据表Api接口
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = PrpLAutoClaimListApi.PATH)
public interface PrpLAutoClaimListApi {

    public static final String PATH = "prpLAutoClaimList";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrpLAutoClaimListDto prpLAutoClaimListDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(Map<String,String> map);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrpLAutoClaimListDto prpLAutoClaimListDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpLAutoClaimListDto queryByPK(Map<String,String> map);
    /**
     * 自动理算接口
     * @param swfLogDtoList 待处理自动理赔任务案件集合
     * @author 王心洋
     * @time 2018-01-30
     */
    @RequestMapping(value = "autoClaimList",method = {RequestMethod.POST})
    public void autoClaimList(List<SwfLogDto> swfLogDtoList) throws Exception;
}