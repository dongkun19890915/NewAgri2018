package com.sinosoft.ims.core.kernel.dao;


import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.ims.core.kernel.entity.PrpDagreement;
import com.sinosoft.ims.core.kernel.entity.PrpDagreementKey;
import org.springframework.stereotype.Repository;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-10 07:02:27.097 
 * 代理协议表Dao数据操作对象
 */
@Repository
public interface PrpDagreementDao extends JpaBaseDao<PrpDagreement,PrpDagreementKey> {
}