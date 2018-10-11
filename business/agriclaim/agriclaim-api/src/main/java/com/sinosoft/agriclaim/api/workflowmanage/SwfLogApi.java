package com.sinosoft.agriclaim.api.workflowmanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.workflowmanage.dto.QueryEndcaReturnDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.RequestQueryEndCaseDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfLogDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090 
 * @description 工作流日志表Api接口
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = SwfLogApi.PATH)
public interface SwfLogApi {

    public static final String PATH = "swfLog";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(SwfLogDto swfLogDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String flowId,java.lang.Integer logNo);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(SwfLogDto swfLogDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    SwfLogDto queryByPK(String flowId,java.lang.Integer logNo);
    /**
     * 根据页面输入条件查询结案信息
     * @author: 董坤
     * @date: 2017/11/10 15:04
     * @param requestQueryEndCaseDto 查询页面数据
     * @return ResponseDto 查询结果页面数据
     * @throws Exception
     */
    @RequestMapping(value = "queryEndCaseByCondition",method = {RequestMethod.POST})
    QueryEndcaReturnDto queryEndCaseByCondition(@RequestBody RequestQueryEndCaseDto requestQueryEndCaseDto) throws Exception;
    /**
    * @description 取消自动理赔数据查询(查询已完成调度，未进行理算的数据)
    * @return SwfLogDtoList 查询结果
    * @throws Exception
    * @author 李磊
    * @date 2018-01-22 11:54
    */
    @RequestMapping(value = "querySwfLogDtoList",method = {RequestMethod.POST})
    List<SwfLogDto> querySwfLogDtoList() throws Exception;

    /**
    * @description 保存自动理赔数据到PrpLAutoClaimList表,并执行自动理赔任务
    * @throws Exception
    * @author 李磊
    * @date 2018-01-23 15:53
    */
    @RequestMapping(value = "doClaimTask",method = {RequestMethod.POST})
    void doClaimTask() throws Exception;

    /**
     * 根据传入的不同的业务号码返回相应的流程节点的数据
     * @param registNo 报案号
     * @return businessNo 业务号 (可以是报案号, 立案号 , 理算书好 , 特殊赔案号)
     * @author 王保良
     * @time 2018-02-07
     */
    @RequestMapping(value = "queryByBusinessNo",method = RequestMethod.POST)
    SwfLogDto queryByBusinessNo(@RequestBody Map<String,String> map) throws Exception;
}