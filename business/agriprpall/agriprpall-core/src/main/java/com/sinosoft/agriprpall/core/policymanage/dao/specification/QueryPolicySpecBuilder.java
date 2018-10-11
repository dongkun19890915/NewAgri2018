package com.sinosoft.agriprpall.core.policymanage.dao.specification;

import com.sinosoft.agriprpall.core.policymanage.entity.*;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTcoins;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.utils.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class QueryPolicySpecBuilder {

    /**
     *  根据保单号查询PrpCinsured的条件
     * @author: 王心洋
     * @date: 2017/10/27 16:26
     * @param policyNo
     * @return
     */
    public static Specification<PrpCinsured> findPrpCinsuredByPolicyNo(String policyNo){
        return Specifications.<PrpCinsured>and()
                .eq(StringUtils.isNotEmpty(policyNo),"policyNo",policyNo)
                .build();
    }

    /**
     *  根据保单号查询PrpCitemKindAgri的条件
     * @author: 王心洋
     * @date: 2017/10/27 16:26
     * @param policyNo
     * @return
     */
    public static Specification<PrpCitemKindAgri> findPrpCitemKindAgriByPolicyNo(String policyNo){
        return Specifications.<PrpCitemKindAgri>and()
                .eq(StringUtils.isNotEmpty(policyNo),"policyNo",policyNo)
                .build();
    }

    /**
     *  根据保单号查询PrpCinsured的条件
     * @author: 王心洋
     * @date: 2017/10/27 16:26
     * @param policyNo
     * @return
     */
    public static Specification<PrpCaddress> findPrpCaddressByPolicyNo(String policyNo){
        return Specifications.<PrpCaddress>and()
                .eq(StringUtils.isNotEmpty(policyNo),"policyNo",policyNo)
                .build();
    }

    /**
     *  根据保单号查询PrpCsubsidy的条件
     * @author: 王心洋
     * @date: 2017/10/27 16:26
     * @param policyNo
     * @return
     */
    public static Specification<PrpCsubsidy> findPrpCsubsidyByPolicyNo(String policyNo){
        return Specifications.<PrpCsubsidy>and()
                .eq(StringUtils.isNotEmpty(policyNo),"policyNo",policyNo)
                .build();
    }

    /**
     *  根据保单号查询PrpCitemKind的条件
     * @author: 王心洋
     * @date: 2017/10/27 16:26
     * @param policyNo
     * @return
     */
    public static Specification<PrpCitemKind> findPrpCitemKindByPolicyNo(String policyNo){
        return Specifications.<PrpCitemKind>and()
                .eq(StringUtils.isNotEmpty(policyNo),"policyNo",policyNo)
                .build();
    }

    /**
     *  根据保单号查询PrpCengage的条件
     * @author: 王心洋
     * @date: 2017/10/27 16:26
     * @param policyNo
     * @return
     */
    public static Specification<PrpCengage> findPrpCengageByPolicyNo(String policyNo){
        return Specifications.<PrpCengage>and()
                .eq(StringUtils.isNotEmpty(policyNo),"policyNo",policyNo)
                .build();
    }

    /**
     *  根据保单号查询PrpCfeild的条件
     * @author: 王心洋
     * @date: 2017/10/27 16:26
     * @param policyNo
     * @return
     */
    public static Specification<PrpCfeild> findPrpCfeildByPolicyNo(String policyNo){
        return Specifications.<PrpCfeild>and()
                .eq(StringUtils.isNotEmpty(policyNo),"policyNo",policyNo)
                .build();
    }

    /**
     *  根据保单号查询PrpCinsured的条件
     * @author: 王心洋
     * @date: 2017/10/27 16:26
     * @param policyNo
     * @return
     */
    public static Specification<PrpCfee> findPrpCfeeByPolicyNo(String policyNo){
        return Specifications.<PrpCfee>and()
                .eq(StringUtils.isNotEmpty(policyNo),"policyNo",policyNo)
                .build();
    }

    /**
     *  根据保单号查询PrpCplan的条件
     * @author: 王心洋
     * @date: 2017/10/27 16:26
     * @param policyNo
     * @return
     */
    public static Specification<PrpCplan> findPrpCplanByPolicyNo(String policyNo){
        return Specifications.<PrpCplan>and()
                .eq(StringUtils.isNotEmpty(policyNo),"policyNo",policyNo)
                .build();
    }

    /**
     *  根据保单号查询PrpCinsured的条件
     * @author: 王心洋
     * @date: 2017/10/27 16:26
     * @param policyNo
     * @return
     */
    public static Specification<PrpCcoins> findPrpCcoinsByPolicyNo(String policyNo){
        return Specifications.<PrpCcoins>and()
                .eq(StringUtils.isNotEmpty(policyNo),"policyNo",policyNo)
                .build();
    }

    /**
     *  根据保单号查询PrpCcoinsDetail的条件
     * @author: 王心洋
     * @date: 2017/10/27 16:26
     * @param policyNo
     * @return
     */
    public static Specification<PrpCcoinsDetail> findPrpCcoinsDetailByPolicyNo(String policyNo){
        return Specifications.<PrpCcoinsDetail>and()
                .eq(StringUtils.isNotEmpty(policyNo),"policyNo",policyNo)
                .build();
    }

    /**
     *  根据保单号查询PrpCplanCoins的条件
     * @author: 王心洋
     * @date: 2017/10/27 16:26
     * @param policyNo
     * @return
     */
    public static Specification<PrpCplanCoins> findPrpCplanCoinsByPolicyNo(String policyNo){
        return Specifications.<PrpCplanCoins>and()
                .eq(StringUtils.isNotEmpty(policyNo),"policyNo",policyNo)
                .build();
    }
}
