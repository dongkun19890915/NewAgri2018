package com.sinosoft.agriclaim.core.workflowmanage.service;


import com.sinosoft.agriclaim.api.schedulemanage.dto.ScheduleSaveDto;
import com.sinosoft.agriclaim.api.workflowmanage.dto.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:47:03.090
 * @description 工作流日志表Core接口
 */
public interface SwfLogService {

    /**
     *@description 新增
     *@param
     */
    void save(SwfLogDto swfLogDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String flowId,java.lang.Integer logNo);
    /**
     *@description 修改
     *@param
     */
    void modify(SwfLogDto swfLogDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    SwfLogDto queryByPK(String flowId,java.lang.Integer logNo);
    /**
     * 整理回访主表数据(自动生成回访主表数据)
     * @param saveDto
     * @param registNo		报案号
     * @param nodeType		当前节点
     * @param state			回访案件状态
     * @author 马俊玲
     * @throws Exception
     */
    PrplReturnVisitSwflogDto setReturnVisitSwflogDto(ScheduleSaveDto saveDto, String registNo, String nodeType, String state);
    /**
     * 检查该节点是否可以被提交，如果不能提交丢出理由原因
     *
     * @param swfLogFlowID 工作流ID
     * @param  swfLogLogNo 工作流logNo
     * @author 马俊玲
     * @return msg
     */
    String checkNodeSubmit(String swfLogFlowID, String swfLogLogNo);
    /**
     * 有原因的更换工作流上的处理原因
     * @author 马俊玲
     * @param swfLogFlowID 工作流ID
     * @param swfLogLogNo 工作流LogNo
     * @param newHandlerCode 操作员代码
     * @param  scheduleObjectID 调度ID
     * @return WorkFlowDto
     */
    WorkFlowDto changeFlowNodeHandler(String swfLogFlowID, String swfLogLogNo, String newHandlerCode, String string,
                                      String scheduleObjectID) ;
    /**
     * （根据页面输入条件查询结案信息）
     * @author: 董坤
     * @date: 2017/11/10 15:04
     * @param requestQueryEndCaseDto 查询页面数据
     * @return ResponseDto 查询结果页面数据
     * @throws Exception
     */
    public QueryEndcaReturnDto queryEndCaseByCondition(@RequestBody RequestQueryEndCaseDto requestQueryEndCaseDto) throws Exception;

    /**
     * @description 取消自动理赔数据查询(查询已完成调度，未进行理算的数据)
     * @return SwfLogDtoList 查询结果
     * @throws Exception
     * @author 李磊
     * @date 2018-01-22 11:54
     */
    public List<SwfLogDto> querySwfLogDtoList() throws Exception;

    /**
     * @description 保存自动理赔数据到PrpLAutoClaimList表,并执行自动理赔任务
     * @throws Exception
     * @author 李磊
     * @date 2018-01-23 15:53
     */
    void doClaimTask() throws Exception;

    /**
     * 根据工作流号查询最大节点号
     * @param flowId 流程编号
     * @return Integer 最大节点号
     * @author 王心洋
     * @time 2018-02-07
     */
    Integer queryMaxLogNo(String flowId);

    /**
     * 根据传入的不同的业务号码返回相应的流程节点的数据
     * @param registNo 报案号
     * @return businessNo 业务号 (可以是报案号, 立案号 , 理算书好 , 特殊赔案号)
     * @author 王保良
     * @time 2018-02-07
     */
    SwfLogDto queryByBusinessNo(String registNo,String businessNo) throws Exception;
}