package com.sinosoft.agriprpall.core.process.dao;

import com.sinosoft.agriprpall.core.process.entity.PrpStepFlowTemp;
import com.sinosoft.agriprpall.core.process.entity.PrpStepFlowTempKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.stereotype.Repository;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2018-04-03 09:46:55.365
 * 承保流程节点数据临时表Dao数据操作对象
 */
@Repository
public interface PrpStepFlowTempDao extends JpaBaseDao<PrpStepFlowTemp, PrpStepFlowTempKey> {

    PrpStepFlowTemp findByProposalNo(String proposalNo);

    PrpStepFlowTemp findByPolicyNo(String policyNo);

    PrpStepFlowTemp findByEndorseNo(String endorseNo);


}