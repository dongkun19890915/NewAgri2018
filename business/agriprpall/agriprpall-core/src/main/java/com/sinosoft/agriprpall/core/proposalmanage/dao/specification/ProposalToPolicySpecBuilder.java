package com.sinosoft.agriprpall.core.proposalmanage.dao.specification;

import com.sinosoft.agriprpall.core.proposalmanage.entity.*;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.utils.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class ProposalToPolicySpecBuilder {
    /**
     * @description: 根据投保单号查询PrpTmain的条件
     * @author: 宋振振
     * @date: 2017/10/26 16:44
     * @param proposalNo
     * @return
     */
    public static Specification<PrpTmain> prpTmainByProposalNoSpecification(String proposalNo){
        return Specifications.<PrpTmain>and()
                .eq(StringUtils.isNotEmpty(proposalNo),"proposalNo",proposalNo)
                .build();
    }
    /**
     * @description: 根据投保单号查询PrpTrenewal的条件
     * @author: 宋振振
     * @date: 2017/10/26 16:44
     * @param proposalNo
     * @return
     */
    public static Specification<PrpTrenewal> prpTrenewalByProposalNoSpecification(String proposalNo){
        return Specifications.<PrpTrenewal>and()
                .eq(StringUtils.isNotEmpty(proposalNo),"proposalNo",proposalNo)
                .build();
    }
    /**
     * @description: 根据投保单号查询PrpTaddress的条件
     * @author: 宋振振
     * @date: 2017/10/26 16:44
     * @param proposalNo
     * @return
     */
    public static Specification<PrpTaddress> prpTaddressByProposalNoSpecification(String proposalNo){
        return Specifications.<PrpTaddress>and()
                .eq(StringUtils.isNotEmpty(proposalNo),"proposalNo",proposalNo)
                .build();
    }
    /**
     * @description: 根据投保单号查询PrpTitemKind的条件
     * @author: 宋振振
     * @date: 2017/10/26 16:44
     * @param proposalNo
     * @return
     */
    public static Specification<PrpTitemKind> prpTitemKindByProposalNoSpecification(String proposalNo){
        return Specifications.<PrpTitemKind>and()
                .eq(StringUtils.isNotEmpty(proposalNo),"proposalNo",proposalNo)
                .build();
    }
    /**
     * @description: 根据投保单号查询PrpTitemKind的条件
     * @author: 宋振振
     * @date: 2017/10/26 16:44
     * @param proposalNo
     * @return
     */
    public static Specification<PrpTinsured> prpTinsuredByProposalNoSpecification(String proposalNo){
        return Specifications.<PrpTinsured>and()
                .eq(StringUtils.isNotEmpty(proposalNo),"proposalNo",proposalNo)
                .build();
    }
    /**
     * @description: 根据投保单号查询PrpTplan的条件
     * @author: 宋振振
     * @date: 2017/10/26 16:44
     * @param proposalNo
     * @return
     */
    public static Specification<PrpTplan> prpTplanByProposalNoSpecification(String proposalNo){
        return Specifications.<PrpTplan>and()
                .eq(StringUtils.isNotEmpty(proposalNo),"proposalNo",proposalNo)
                .build();
    }
    /**
     * @description: 根据投保单号查询PrpTplanCoins的条件
     * @author: 宋振振
     * @date: 2017/10/26 16:44
     * @param proposalNo
     * @return
     */
    public static Specification<PrpTplanCoins> prpTplanCoinsByProposalNoSpecification(String proposalNo){
        return Specifications.<PrpTplanCoins>and()
                .eq(StringUtils.isNotEmpty(proposalNo),"proposalNo",proposalNo)
                .build();
    }
    /**
     * @description: 根据投保单号查询PrpTfee的条件
     * @author: 宋振振
     * @date: 2017/10/26 16:44
     * @param proposalNo
     * @return
     */
    public static Specification<PrpTfee> prpTfeeByProposalNoSpecification(String proposalNo){
        return Specifications.<PrpTfee>and()
                .eq(StringUtils.isNotEmpty(proposalNo),"proposalNo",proposalNo)
                .build();
    }
    /**
     * @description: 根据投保单号查询PrpTengage的条件
     * @author: 宋振振
     * @date: 2017/10/26 16:44
     * @param proposalNo
     * @return
     */
    public static Specification<PrpTengage> prpTengageByProposalNoSpecification(String proposalNo){
        return Specifications.<PrpTengage>and()
                .eq(StringUtils.isNotEmpty(proposalNo),"proposalNo",proposalNo)
                .build();
    }
    /**
     * @description: 根据投保单号查询PrpTcoins的条件
     * @author: 宋振振
     * @date: 2017/10/26 16:44
     * @param proposalNo
     * @return
     */
    public static Specification<PrpTcoins> prpTcoinsByProposalNoSpecification(String proposalNo){
        return Specifications.<PrpTcoins>and()
                .eq(StringUtils.isNotEmpty(proposalNo),"proposalNo",proposalNo)
                .build();
    }
    /**
     * @description: 根据投保单号查询PrpTcoinsDetail的条件
     * @author: 宋振振
     * @date: 2017/10/26 16:44
     * @param proposalNo
     * @return
     */
    public static Specification<PrpTcoinsDetail> prpTcoinsDetailByProposalNoSpecification(String proposalNo){
        return Specifications.<PrpTcoinsDetail>and()
                .eq(StringUtils.isNotEmpty(proposalNo),"proposalNo",proposalNo)
                .build();
    }
    /**
     * @description: 根据投保单号查询PrpTmainAgri的条件
     * @author: 宋振振
     * @date: 2017/10/26 16:44
     * @param proposalNo
     * @return
     */
    public static Specification<PrpTmainAgri> prpTmainAgriByProposalNoSpecification(String proposalNo){
        return Specifications.<PrpTmainAgri>and()
                .eq(StringUtils.isNotEmpty(proposalNo),"proposalNo",proposalNo)
                .build();
    }
    /**
     * @description: 根据投保单号查询PrpTmainLoan的条件
     * @author: 宋振振
     * @date: 2017/10/26 16:44
     * @param proposalNo
     * @return
     */
    public static Specification<PrpTmainLoan> prpTmainLoanByProposalNoSpecification(String proposalNo){
        return Specifications.<PrpTmainLoan>and()
                .eq(StringUtils.isNotEmpty(proposalNo),"proposalNo",proposalNo)
                .build();
    }
    /**
     * @description: 根据投保单号查询PrpTmainSub的条件
     * @author: 宋振振
     * @date: 2017/10/26 16:44
     * @param proposalNo
     * @return
     */
    public static Specification<PrpTmainSub> prpTmainSubByProposalNoSpecification(String proposalNo){
        return Specifications.<PrpTmainSub>and()
                .eq(StringUtils.isNotEmpty(proposalNo),"proposalNo",proposalNo)
                .build();
    }
    /**
     * @description: 根据投保单号查询PrpTitemKindAgri的条件
     * @author: 宋振振
     * @date: 2017/10/26 16:44
     * @param proposalNo
     * @return
     */
    public static Specification<PrpTitemKindAgri> prpTitemKindAgriByProposalNoSpecification(String proposalNo){
        return Specifications.<PrpTitemKindAgri>and()
                .eq(StringUtils.isNotEmpty(proposalNo),"proposalNo",proposalNo)
                .build();
    }
    /**
     * @description: 根据投保单号查询PrpTfeild的条件
     * @author: 宋振振
     * @date: 2017/10/26 16:44
     * @param proposalNo
     * @return
     */
    public static Specification<PrpTfeild> prpTfeildByProposalNoSpecification(String proposalNo){
        return Specifications.<PrpTfeild>and()
                .eq(StringUtils.isNotEmpty(proposalNo),"proposalNo",proposalNo)
                .build();
    }
    /**
     * @description: 根据投保单号查询PrpTsubsidy的条件
     * @author: 宋振振
     * @date: 2017/10/26 16:44
     * @param proposalNo
     * @return
     */
    public static Specification<PrpTsubsidy> prpTsubsidyByProposalNoSpecification(String proposalNo){
        return Specifications.<PrpTsubsidy>and()
                .eq(StringUtils.isNotEmpty(proposalNo),"proposalNo",proposalNo)
                .build();
    }
    /**
     * @description: 根据投保单号查询PrpTexpense的条件
     * @author: 宋振振
     * @date: 2017/10/26 16:44
     * @param proposalNo
     * @return
     */
    public static Specification<PrpTexpense> prpTexpenseByProposalNoSpecification(String proposalNo){
        return Specifications.<PrpTexpense>and()
                .eq(StringUtils.isNotEmpty(proposalNo),"proposalNo",proposalNo)
                .build();
    }
}
