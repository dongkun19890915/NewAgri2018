package com.sinosoft.agriprpall.core.proposalmanage.dao.specification;


import com.sinosoft.agriprpall.core.proposalmanage.entity.*;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.utils.StringUtils;
import org.springframework.data.jpa.domain.Specification;

/**
 * @Description: QueryProposalSpecBuilder
 * @Author: 陈道洋
 * @Date: 2017/10/18 12:44
 */
public class InsuranceFormPrintSpecBuilder {

    /** 
     * @description: 根据投保单号查询PrpTitemKind的条件 
     * @author: 陈道洋
     * @date: 2017/10/18 14:25
     * @param proposalNo 投保单号
     * @return
     */
    public static Specification<PrpTitemKind> prpTitemKindByProposalNoSpecification(String proposalNo){
        return Specifications.<PrpTitemKind>and()
                .eq(StringUtils.isNotEmpty(proposalNo),"proposalNo",proposalNo)
                .build();
    }

    /**
     * @description: 根据投保单号查询PrpTitemKindAgri的条件
     * @author: 陈道洋
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
     * @description: 根据投保单号查询PrpTplan的条件
     * @author: 陈道洋
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
     * @description: 根据投保单号查询PrpTinsured的条件
     * @author: 陈道洋
     * @date: 2017/10/18 15:17
     * @param proposalNo 投保单号
     * @return
     */
    public static Specification<PrpTinsured> prpTinsuredByProposalNoSpecification(String proposalNo){
        return Specifications.<PrpTinsured>and()
                .eq(StringUtils.isNotEmpty(proposalNo),"proposalNo",proposalNo)
                .build();
    }



    /**
     * @description: 根据投保单号查询PrpTaddress的条件
     * @author: 陈道洋
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
     * @description: 根据投保单号查询PrpTengage的条件
     * @author: 陈道洋
     * @date: 2017/10/18 16:11
     * @param proposalNo 投保单号
     * @return
     */
    public static Specification<PrpTengage> prpTengageProposalNoSpecification(String proposalNo){
        return  Specifications.<PrpTengage>and()
                .eq(StringUtils.isNotEmpty(proposalNo),"proposalNo",proposalNo)
                .build();
    }
    /**
     * @description: 根据投保单号查询的条件
     * @author: 陈道洋
     * @date: 2017/10/18 16:11
     * @param proposalNo 投保单号
     * @return
     */
    public static Specification<PrpTsubsidy> prpTsubsidyProposalNoSpecification(String proposalNo){
        return  Specifications.<PrpTsubsidy>and()
                .eq(StringUtils.isNotEmpty(proposalNo),"proposalNo",proposalNo)
                .build();
    }

}
