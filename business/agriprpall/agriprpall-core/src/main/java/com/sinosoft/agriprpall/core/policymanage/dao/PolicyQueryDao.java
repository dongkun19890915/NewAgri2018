package com.sinosoft.agriprpall.core.policymanage.dao;

import com.sinosoft.agriprpall.api.policymanage.dto.ResponseFileCoverPrintDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponsePaymentPlanPrintDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseSpecificallyAgreedPrintDto;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmain;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmainKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-18 02:43:59.338
 * 保单信息主表Dao数据操作对象
 */
@Repository
public interface PolicyQueryDao extends JpaBaseDao<PrpCmain, PrpCmainKey> {

    @Query(value = "SELECT  new com.sinosoft.agriprpall.api.policymanage.dto.ResponseSpecificallyAgreedPrintDto (p.policyNo,p.operateDate,pc.clauses,pc.titleFlag) FROM PrpCengage pc ,PrpCmain p  where pc.policyNo=p.policyNo and pc.policyNo = :policyNo and pc.clauseCode like 'T%' AND   pc.clauseCode NOT LIKE 'TX%'  ORDER BY   pc.serialNo,pc.lineNo")
    List<ResponseSpecificallyAgreedPrintDto> queryPolicyno(@Param("policyNo") String policyNo);


    @Query(value = "SELECT  new com.sinosoft.agriprpall.api.policymanage.dto.ResponsePaymentPlanPrintDto(p.policyNo,pc.serialNo,pc.payNo,pc.planDate,pc.currency,pc.planFee,p.operateDate) FROM PrpCplan pc ,PrpCmain p  where pc.policyNo=p.policyNo and pc.policyNo = :policyNo")
    List<ResponsePaymentPlanPrintDto> queryPaymentPlan(@Param("policyNo") String policyNo);


    @Query(value = "SELECT  new com.sinosoft.agriprpall.api.policymanage.dto.ResponseFileCoverPrintDto(p.policyNo,p.insuredName,p.riskCode,p.comCode,p.statQuantity,p.sumPremium,p.sumAmount,pc.currency ) FROM PrpCitemKind pc ,PrpCmain p  where pc.policyNo=p.policyNo and pc.itemKindNo =1 and pc.policyNo = :policyNo")
    List<ResponseFileCoverPrintDto> queryfileCoverPrint(@Param("policyNo") String policyNo);


}