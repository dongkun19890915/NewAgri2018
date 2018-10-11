package com.sinosoft.agriprpall.core.policymanage.dao.specification;


import com.sinosoft.agriprpall.core.policymanage.entity.*;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.utils.StringUtils;
import org.springframework.data.jpa.domain.Specification;

/**
 * @Description: QueryProposalSpecBuilder
 * @Author: 潘峰
 * @Date: 2017/10/18 12:44
 */
public class PolicyPrintSpecBuilder {

    /**
     * @param policyNo 保单号
     * @return
     * @description: 根据保单号查询PrpTitemKind的条件
     * @author: 潘峰
     * @date: 2017/10/18 14:25
     */
    public static Specification<PrpCitemKind> prpCitemKindByPolicyNoSpecification(String policyNo) {
        return Specifications.<PrpCitemKind>and()
                .eq(StringUtils.isNotEmpty(policyNo), "policyNo", policyNo)
                .build();
    }

    /**
     * @param policyNo 保单号
     * @return
     * @description: 根据保单号查询PrpCitemKindAgri的条件
     * @author: 潘峰
     * @date: 2017/10/18 14:58
     */
    public static Specification<PrpCitemKindAgri> prpCitemKindAgriByPolicyNoSpecification(String policyNo) {
        return Specifications.<PrpCitemKindAgri>and()
                .eq(StringUtils.isNotEmpty(policyNo), "policyNo", policyNo)
                .build();
    }


    /**
     * @param policyNo 保单号
     * @return
     * @description: 根据保单号查询PrpCplan的条件
     * @author: 潘峰
     * @date: 2017/10/18 15:13
     */
    public static Specification<PrpCplan> prpCplanByPolicyNoSpecification(String policyNo) {
        return Specifications.<PrpCplan>and()
                .eq(StringUtils.isNotEmpty(policyNo), "policyNo", policyNo)
                .build();
    }

    /**
     * @param policyNo 保单号
     * @return
     * @description: 根据保单号查询PrpCinsured的条件
     * @author: 潘峰
     * @date: 2017/10/18 15:17
     */
    public static Specification<PrpCinsured> prpCinsuredByPolicyNoSpecification(String policyNo) {
        return Specifications.<PrpCinsured>and()
                .eq(StringUtils.isNotEmpty(policyNo), "policyNo", policyNo)
                .build();
    }


    /**
     * @param policyNo 保单号
     * @return
     * @description: 根据保单号查询PrpCaddress的条件
     * @author: 潘峰
     * @date: 2017/10/18 16:11
     */
    public static Specification<PrpCaddress> prpCaddressByPolicyNoSpecification(String policyNo) {
        return Specifications.<PrpCaddress>and()
                .eq(StringUtils.isNotEmpty(policyNo), "policyNo", policyNo)
                .build();
    }

    public static Specification<PrpCengage> prpCengagePolicyNoSpecification(String policyNo) {
        return Specifications.<PrpCengage>and()
                .eq(StringUtils.isNotEmpty(policyNo), "policyNo", policyNo)
                .build();
    }

    /**
     * @param policyNo 投保单号
     * @return
     * @description: 根据投保单号查询的条件
     * @author: 潘峰
     * @date: 2017/10/18 16:11
     */
    public static Specification<PrpCsubsidy> prpCsubsidyPolicyNoSpecification(String policyNo) {
        return Specifications.<PrpCsubsidy>and()
                .eq(StringUtils.isNotEmpty(policyNo), "policyNo", policyNo)
                .build();
    }

}
