package com.sinosoft.txnlist.core.plantinginsurancelist.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.NyxPolicyListOrigin;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.NyxPolicyListOriginKey;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-30 07:53:53.940
 * 种植险保单清单最新数据2Dao数据操作对象
 */
@Repository
public interface NyxPolicyListOriginDao extends JpaBaseDao<NyxPolicyListOrigin, NyxPolicyListOriginKey> {

    List<NyxPolicyListOrigin> findByInusreListCode(String insureListCode);
}