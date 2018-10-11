package com.sinosoft.agriprpall.core.policymanage.dao;

import com.sinosoft.agriprpall.core.policymanage.entity.PrpJplanFee;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpJplanFeeKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.stereotype.Repository;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-23 06:09:14.757 
 * 应收应付费信息表Dao数据操作对象
 */
@Repository
public interface PrpJplanDao extends JpaBaseDao<PrpJplanFee,PrpJplanFeeKey> {
}