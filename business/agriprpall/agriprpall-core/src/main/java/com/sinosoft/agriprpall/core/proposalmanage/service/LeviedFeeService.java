package com.sinosoft.agriprpall.core.proposalmanage.service;



import com.sinosoft.agriprpall.api.proposalmanage.dto.ProposalSaveDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.CalNoTaxPremiumInfoDto;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 12:54:07.447 
 * @description 价税分离Core接口
 */
public interface LeviedFeeService {

    /**
     * 价税分离
     * @author: 钱浩
     * @date: 2017/10/28 9:27
     * @param blProposal 投保单保存对象
     * @return ResponseDto :ProposalSaveDto 投保单大对象
     * @throws Exception
     */
    public ProposalSaveDto dealTMainForYGZ(ProposalSaveDto blProposal) throws Exception;

    /**
     * 从页面点击币别确定时调用此价税分离服务
     * @author: 田健
     * @date: 2017/11/19 13:07
     * @param calNocTaxPremiumInfoDto 计算保费价税分离时传入的dto,包含保额、保费、险别等信息
     * @return 返回不含税保费、和税
     * @throws Exception
     */
    public CalNoTaxPremiumInfoDto dealTMainForYGZFromPage(CalNoTaxPremiumInfoDto calNocTaxPremiumInfoDto) throws Exception;
}