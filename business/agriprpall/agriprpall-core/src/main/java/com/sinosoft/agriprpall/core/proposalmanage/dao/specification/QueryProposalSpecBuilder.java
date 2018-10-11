package com.sinosoft.agriprpall.core.proposalmanage.dao.specification;


import com.sinosoft.agriprpall.core.proposalmanage.entity.*;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.utils.StringUtils;
import org.springframework.data.jpa.domain.Specification;

/**
 * : QueryProposalSpecBuilder
 * @Author: 何伟东
 * @Date: 2017/10/18 12:44
 */
public class QueryProposalSpecBuilder {

    /**
     * : 根据投保单号查询PrpTitemKind的条件
     * @author: 何伟东
     * @date: 2017/10/18 14:25
     * @param proposalNo 投保单号
     * @return
     */
    public static Specification<PrpTitemKind> prpTitemKindByProposalNoSpecification(String proposalNo, String familyNos){
        return Specifications.<PrpTitemKind>and()
                .eq(StringUtils.isNotEmpty(proposalNo),"proposalNo",proposalNo)
                .in(StringUtils.isNotEmpty(familyNos),"familyNo",familyNos)
                .build();
    }

    /**
     * : 根据投保单号查询PrpTitemKindAgri的条件
     * @author: 何伟东
     * @date: 2017/10/18 14:58
     * @param proposalNo 投保单号
     * @return
     */
    public static Specification<PrpTitemKindAgri> prpTitemKindAgriByProposalNoSpecification(String proposalNo){
        return Specifications.<PrpTitemKindAgri>and()
                .eq(StringUtils.isNotEmpty(proposalNo),"proposalNo",proposalNo)
                .build();
    }

    /**
     * : 根据投保单号查询PrpTsubsidy的条件
     * @author: 何伟东
     * @date: 2017/10/18 15:01
     * @param proposalNo 投保单号
     * @return
     */
    public static Specification<PrpTsubsidy> prpTsubsidyByProposalNoSpecification(String proposalNo){
        return Specifications.<PrpTsubsidy>and()
                .eq(StringUtils.isNotEmpty(proposalNo),"proposalNo",proposalNo)
                .build();
    }

    /**
     * : 根据投保单号查询PrpTfee的条件
     * @author: 何伟东
     * @date: 2017/10/18 15:09
     * @param proposalNo 投保单号
     * @return
     */
    public static Specification<PrpTfee> prpTfeeByProposalNoSpecification(String proposalNo){
        return Specifications.<PrpTfee>and()
                .eq(StringUtils.isNotEmpty(proposalNo),"proposalNo",proposalNo)
                .build();
    }

    /**
     * : 根据投保单号查询PrpTplan的条件
     * @author: 何伟东
     * @date: 2017/10/18 15:13
     * @param proposalNo 投保单号
     * @return
     */
    public static Specification<PrpTplan> prpTplanByProposalNoSpecification(String proposalNo){
        return Specifications.<PrpTplan>and()
                .eq(StringUtils.isNotEmpty(proposalNo),"proposalNo",proposalNo)
                .build();
    }

    /**
     * : 根据投保单号查询PrpTinsured的条件
     * @author: 何伟东
     * @date: 2017/10/18 15:17
     * @param proposalNo 投保单号
     * @return
     */
    public static Specification<PrpTinsured> prpTinsuredByProposalNoSpecification(String proposalNo, String familyNos){
        return Specifications.<PrpTinsured>and()
                .eq(StringUtils.isNotEmpty(proposalNo),"proposalNo",proposalNo)
                .in(StringUtils.isNotEmpty(familyNos),"serialNo",familyNos)
                .build();
    }

    /**
     * : 根据投保单号查询PrpTcoins的条件
     * @author: 何伟东
     * @date: 2017/10/18 15:26
     * @param proposalNo
     * @return
     */
    public static Specification<PrpTcoins> prpTcoinsByProposalNoSpecification(String proposalNo){
        return Specifications.<PrpTcoins>and()
                .eq(StringUtils.isNotEmpty(proposalNo),"proposalNo",proposalNo)
                .build();
    }
    /**
     * : 根据投保单号查询PrpTcoinsDetail的条件
     * @author: 何伟东
     * @date: 2017/10/18 15:26
     * @param proposalNo
     * @return
     */
    public static Specification<PrpTcoinsDetail> prpTcoinsDetailByProposalNoSpecification(String proposalNo){
        return Specifications.<PrpTcoinsDetail>and()
                .eq(StringUtils.isNotEmpty(proposalNo),"proposalNo",proposalNo)
                .build();
    }
    /**
     * : 根据投保单号查询prpTplanCoins的条件
     * @author: 何伟东
     * @date: 2017/10/18 15:26
     * @param proposalNo
     * @return
     */
    public static Specification<PrpTplanCoins> prpTplanCoinsByProposalNoSpecification(String proposalNo){
        return Specifications.<PrpTplanCoins>and()
                .eq(StringUtils.isNotEmpty(proposalNo),"proposalNo",proposalNo)
                .build();
    }
    /**
     * : 根据投保单号查询PrpTaddress的条件
     * @author: 何伟东
     * @date: 2017/10/18 16:11
     * @param proposalNo 投保单号
     * @return
     */
    public static Specification<PrpTaddress> prpTaddressByProposalNoSpecification(String proposalNo){
        return Specifications.<PrpTaddress>and()
                .eq(StringUtils.isNotEmpty(proposalNo),"proposalNo",proposalNo)
                .build();
    }

    /**
     *  按投保单号查询prpTcoins集合
     * @author 王心洋
     * @time 2017-11-08
     * @param proposalNo
     * @return Specification<PrpTcoins>
     */
    public static Specification<PrpTcoins> findPrpTcoinsByPolicyNo(String proposalNo){
        return Specifications.<PrpTcoins>and()
                .eq(StringUtils.isNotEmpty(proposalNo),"proposalNo",proposalNo)
                .build();
    }

}
