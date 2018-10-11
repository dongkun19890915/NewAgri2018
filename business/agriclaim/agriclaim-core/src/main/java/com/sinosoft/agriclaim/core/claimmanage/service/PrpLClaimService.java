package com.sinosoft.agriclaim.core.claimmanage.service;


import com.sinosoft.agriclaim.api.claimmanage.dto.*;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfLogDto;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:39:53.061 
 * @description 立案基本信息表Core接口
 */
public interface PrpLClaimService {

    /**
     *@description 新增
     *@param
     */
    void save(PrpLClaimDto prpLClaimDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String claimNo);
    /**
     *@description 修改
     *@param
     */
    void modify(PrpLClaimDto prpLClaimDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrpLClaimDto queryByPK(String claimNo);

    /**
     * （理赔打印 列表查询接口）
     * @author: 王志文
     * @date: 2017/11/20 17:43
     * @param claimPrintDto 页面输入框输入数据
     * @return 分页数据列表
     */
    PageInfo queryAgriByPrintType(ClaimPrintDto claimPrintDto) throws Exception;

    /**
     * （理赔打印 农险卷宗封面）
     * @author: 王志文
     * @date: 2017/11/11 16:38
     * @param claimNo 立案号
     * @return 理赔打印页面数据
     * @throws Exception
     */
    AgriPrintDto queryAgriByPrint(String claimNo)throws Exception;

    /**
     * （拒赔注销通知书查询）
     * @author: 王志文
     * @date: 2017/11/14 10:38
     * @param claimNo 立案号
     * @return 拒赔注销通知书页面数据
     * @throws Exception
     */
    RefuseCancelBackPrintDto queryRefuseCancelByClaimNo(String claimNo)throws Exception;

    /**
     * （结案报告查询）
     * @author: 王志文
     * @date: 2017/11/14 10:38
     * @param claimNo 立案号
     * @return 结案报告页面数据
     * @throws Exception
     */
    EndCasePrintBackDto queryEndCasePrintByClaimNo(String claimNo)throws Exception ;

    /**
     * （赔款收据打印）
     * @author: 王志文
     * @date: 2017/11/14 17:53
     * @param compensateNo 赔款计算书号
     * @return 赔款收据页面数据
     * @throws Exception
     */
    IndemnityNoticePrintBackDto queryIndemnityNoticeByCompensateNo(String compensateNo)throws Exception;

    /**
     * （赔款理算书打印）
     * @author: 王志文
     * @date: 2017/11/15 11:09
     * @param compensateNo 赔款计算书号
     * @return 赔款理算书打印页面数据
     * @throws Exception
     */
    CompensatePrintBackDto queryCompensatePrintByCompensateNo(String compensateNo)throws Exception;

    /**
     * （保单抄件打印）
     * @author: 王志文
     * @date: 2017/11/15 20:14
     * @param registNo 报案号
     * @return 保单抄件页面数据
     * @throws Exception
     */
    CopyPrintBackDto queryCopyPrintByRegistNo(String registNo,String userCode)throws Exception;


    /**
     * （根据保单号查询PrpLClaim表）
     * @author: 王志文
     * @date: 2017/11/21 10:44
     * @param policyNo 保单号
     * @return PrpLClaimDto 的集合
     */
    List<PrpLClaimDto> queryByPolicyNo(String policyNo) throws Exception;
    /**
     * （根据立案号、报案号、保单号查询结案登记页面详细信息）
     * @param prpLClaimDto （只有立案号、报案号、保单号）
     * @return 结案登记展示页面相关信息
     * @author: 董坤
     * @date: 2017/11/11 10:41
     */
    PrpLClaimEndCaseDto queryEndCaseDetailByCondition(PrpLClaimDto prpLClaimDto) throws Exception;
    /**
     * （结案登记页面详细信息保存）
     * @param prpLClaimEndCaseDto 结案登记展示页面相关信息
     * @return 结案信息保存成功与否信息
     * @author: 董坤
     * @date: 2017/11/13 14:31
     */
    String saveEndCaseInfo(PrpLClaimEndCaseDto prpLClaimEndCaseDto) throws Exception;

    /**
     * （结案登记页面数据保存（流+页面数据） 被主保存方法调用的方法）
     * @author: 董坤
     * @date: 2017/11/15 15:52
     * @param prpLClaimEndCaseDto 页面数据dto
     * @param caseNo 赔案号
     */
    String saveEndcaseInfoAndWorkFlow(PrpLClaimEndCaseDto prpLClaimEndCaseDto,SwfLogDto swfLogDto,String caseNo,boolean isRecase) throws Exception;

}