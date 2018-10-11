package com.sinosoft.agriclaim.core.recasemanage.service;


import com.sinosoft.agriclaim.api.recasemanage.dto.*;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfLogDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:44:45.570 
 * @description 重开赔案表Core接口
 */
public interface PrpLRecaseService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLRecaseDto prpLRecaseDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String claimNo,java.lang.Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLRecaseDto prpLRecaseDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLRecaseDto queryByPK(String claimNo,java.lang.Integer serialNo);

    /**
     * @description 重开赔案列表查询
     * @author: 王志文
     * @date: 2017/11/3 15:28
     * @param reCaseDto 重开赔案查询页面输入框信息
     * @return 列表信息 集合
     */
    PageInfo queryBySql(ReCaseDto reCaseDto) throws Exception;

    /**
     * （报案号超链接查询 实现方法）
     * @author: 王志文
     * @date: 2017/11/3 10:39
     * @param claimNo 立案号
     * @return 页面显示信息，报案号超链接查询后所需信息
     */
    ReCaseViewDto queryReCaseReasonByClaimNo(String claimNo);

    /**
     * @description 重开赔案申请提交双核
     * @author: 王志文
     * @date: 2017/11/3 10:40
     * @param reCaseCommitDto 包含险种名称、立案号、保单号、报案号等基本信息
     * @return 返回提交结果，成功或其他失败信息
     */
    Map<String,String> saveReCaseCommittedByReCaseDto(ReCaseCommitDto reCaseCommitDto)throws Exception;

    /**
     * （双核审核重开赔案后调用，将审核状态写入到理赔表中）
     * @author: 王志文
     * @date: 2017/11/17 15:18
     * @param undwrtWriteBackReCaseDto 包含流程编号、序号、业务号、审核结果
     * @return int  返回回写结果信息，大于0 则回写成功
     * @throws Exception
     */
    String saveCaseTypeByUndwrt(UndwrtWriteBackReCaseDto undwrtWriteBackReCaseDto) throws Exception;

    /**
     * （重开赔案成功后重新生成理算节点，将新的赔款计算书号写入到重开赔案表中）
     * @author: 王志文
     * @date: 2017/11/17 17:04
     * @param compensateNo
     * @return 写入结果，成功或失败
     * @throws Exception
     */
    Map<String,String> saveCompensateNoByRecase(String compensateNo,String claimNo)throws Exception;

    /**
     *  根据投保单号查询PrpLRecase表信息
     * @author: 汪钊
     * @date: 2017/11/20 15:50
     * @param map 包括claimNo立案号
     * @return prpLRecaseDtoList 返回PrpLRecaseDto的集合
     */
    List<PrpLRecaseDto> queryByClaimNo(String claimNo);

    /**
     * （双核回写调用，进行检查回写数据是否符合要求）
     * @author: 王志文
     * @date: 2018/5/7 10:23
     * @param flowID
     * @param logNo
     * @param businessNo
     * @return
     * @throws Exception
     */
    public SwfLogDto checkFlowNode(String flowID, int logNo, String businessNo) throws Exception;
}