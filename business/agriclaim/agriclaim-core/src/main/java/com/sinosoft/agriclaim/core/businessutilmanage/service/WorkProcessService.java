package com.sinosoft.agriclaim.core.businessutilmanage.service;


import com.sinosoft.agriclaim.api.businessutilmanage.dto.RequestWorkProcessDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.WorkProcessDto;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.ResponseSwfLogQueryDto;
import com.sinosoft.framework.dto.PageInfo;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-15 07:15:21.216 
 * @description 工作流程表Core接口
 */
public interface WorkProcessService {

    /**
     *@description 新增
     *@param
     */
    void save(WorkProcessDto workProcessDto);

    /**
     *@description 删除
     *@param
     */
    void remove(Integer id, String registNo);
    /**
     *@description 修改
     *@param
     */
    void modify(WorkProcessDto workProcessDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    WorkProcessDto queryByPK(Integer id, String registNo);
    /**
     * 报案登记暂存-结案时保存到工作流程表中（理算环节除外）
     * @author: 孙朋飞
     * @date: 2017/12/15 15:44
     * @param policyNo 保单号
     * @param registNo 报案号
     * @param claimNo 立案号
     * @param caseNo 结案号
     * @param classCode 险种大类
     * @param riskCode 险种
     * @param nodeType 当前节点代码
     * @param nextNodeName 下一节点代码
     * @param caseType 案件装态
     * @param operator 操作人
     * @throws Exception
     */
    public void saveWorkProcess(String policyNo, String registNo, String claimNo, String caseNo, String classCode, String riskCode, String nodeType, String nextNodeName, Enum caseType, String operator) throws Exception;
    /**
     *（保存到工作流程表中理算环节调用的方法）
     * @author: 孙朋飞
     * @date: 2017/12/15 19:58
     * @param registNo 报案号
     * @param compensateNo 理算书号
     * @param nodeType 当前节点代码
     * @param nextNodeName 下一节点代码
     * @param operator 操作人
     * @throws Exception
     */
    public void saveWorkProcessCompensate(String registNo, String compensateNo,String nodeType,String nextNodeName, String operator) throws Exception;
    /**
     *（流程查询-分页查询）
     * @author: 孙朋飞
     * @date: 2017/12/16 10:46
     * @param processDto 接受参数的Dto
     * @return 流程查询表的集合
     * @throws Exception
     */
    public PageInfo<WorkProcessDto> queryWorkProcessByConditions(RequestWorkProcessDto processDto) throws Exception;
    /**
     * 案件流程节点列表信息查询
     * @author: 孙朋飞
     * @date: 2017/11/7 11:40
     * @param processDto 接受参数的Dto
     * @return 返回日志表、收付信息表、流程主表、工作流路径日志表信息
     * @throws Exception
     */
    public ResponseSwfLogQueryDto querySwfLogAndSwfLogStoreByConditions(RequestWorkProcessDto processDto) throws Exception;
}