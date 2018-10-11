package com.sinosoft.agriprpall.core.policymanage.dao.specification;

import com.sinosoft.agriprpall.core.policymanage.entity.PrpCaddress;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTaddress;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.utils.StringUtils;
import org.springframework.data.jpa.domain.Specification;

/**
 * @Description: 根据投保单号或保单号查PrpTaddress或PrpCaddress表
 * @Author: 宋振振
 * @Date: 9:00 2017/10/17
 */
public class PrpAddressSpecBuilder {
    /**
     * @description: 根据投保单号或保单号查询标的地址打印信息
     * @author: 宋振振
     * @date: 2017/10/17 9:00
     * @param policyNo
     * @return List<PrpCaddress>
     * @throws Exception
     */
    public static Specification<PrpCaddress> prpCaddressSpecification(String policyNo){
        return Specifications.<PrpCaddress>and().eq(StringUtils.isNotEmpty(policyNo),"policyNo",policyNo).build();
    }
    /**
     * @description: 根据投保单号或保单号查询标的地址打印信息
     * @author: 宋振振
     * @date: 2017/10/17 9:00
     * @param proposalNo
     * @return List<PrpTaddress>
     * @throws Exception
     */
    public static Specification<PrpTaddress> prpTaddressSpecification(String proposalNo){
        return Specifications.<PrpTaddress>and().eq(StringUtils.isNotEmpty(proposalNo),"proposalNo",proposalNo).build();
    }
}
