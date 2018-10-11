package com.sinosoft.agriclaim.web.businessutilmanage;

import com.sinosoft.agriclaim.api.businessutilmanage.WorkProcessApi;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.RequestWorkProcessDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.ResponseSwfLogQueryDto;
import com.sinosoft.agriclaim.core.businessutilmanage.service.WorkProcessService;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.WorkProcessDto;
import com.sinosoft.framework.dto.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-15 07:15:21.216 
 * @description 工作流程表controller层
 */
@RestController
@RequestMapping(value = WorkProcessController.PATH)
public class WorkProcessController implements WorkProcessApi {

    private static Logger LOGGER = LoggerFactory.getLogger(WorkProcessController.class);

    @Autowired
    private WorkProcessService workProcessService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody WorkProcessDto workProcessDto) {
        workProcessService.save(workProcessDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody Integer id,String registNo) {
        workProcessService.remove(id,registNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody WorkProcessDto workProcessDto) {
        workProcessService.modify(workProcessDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public WorkProcessDto queryByPK(@RequestBody Integer id,String registNo) {
        return workProcessService.queryByPK(id,registNo);
    }
    /**
     *（流程查询-分页查询）
     * @author: 孙朋飞
     * @date: 2017/12/16 10:46
     * @param processDto 接受参数的Dto
     * @return 流程查询表的集合
     * @throws Exception
     */
    @Override
    public @ResponseBody  PageInfo<WorkProcessDto> queryWorkProcessByConditions(@RequestBody RequestWorkProcessDto processDto) throws Exception {
        return workProcessService.queryWorkProcessByConditions(processDto);
    }

    /**
     * 案件流程节点列表信息查询
     * @author: 孙朋飞
     * @date: 2017/11/7 11:40
     * @param processDto 接受参数的Dto
     * @return 返回日志表、收付信息表、流程主表、工作流路径日志表信息
     * @throws Exception
     */
    public @ResponseBody ResponseSwfLogQueryDto querySwfLogAndSwfLogStoreByConditions(@RequestBody RequestWorkProcessDto processDto)throws Exception{
        return workProcessService.querySwfLogAndSwfLogStoreByConditions(processDto);
    }
}
