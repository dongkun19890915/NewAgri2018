package com.sinosoft.agriclaim.api.businessutilmanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.RequestWorkProcessDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.WorkProcessDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.ResponseSwfLogQueryDto;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-15 07:15:21.216 
 * @description 工作流程表Api接口
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = WorkProcessApi.PATH)
public interface WorkProcessApi {

    public static final String PATH = "workProcess";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(WorkProcessDto workProcessDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(Integer id, String registNo);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(WorkProcessDto workProcessDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    WorkProcessDto queryByPK(Integer id, String registNo);

    /**
     *（流程查询-分页查询）
     * @author: 孙朋飞
     * @date: 2017/12/16 10:46
     * @param processDto 接受参数的Dto
     * @return 流程查询表的集合
     * @throws Exception
     */
    @RequestMapping(value = "queryWorkProcessByConditions",method = {RequestMethod.POST})
    public @ResponseBody PageInfo<WorkProcessDto>  queryWorkProcessByConditions(@RequestBody RequestWorkProcessDto processDto) throws Exception;

    /**
     * 案件流程节点列表信息查询
     * @author: 孙朋飞
     * @date: 2017/11/7 11:40
     * @param processDto （registNo报案号（必须），flowId流程号）
     * @return 返回日志表、收付信息表、流程主表、工作流路径日志表信息
     * @throws Exception
     */
    @RequestMapping(value="querySwfLogAndSwfLogStoreByConditions",method ={RequestMethod.POST})
    public @ResponseBody
    ResponseSwfLogQueryDto querySwfLogAndSwfLogStoreByConditions(@RequestBody RequestWorkProcessDto processDto) throws Exception;

}