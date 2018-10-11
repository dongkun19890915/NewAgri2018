package com.sinosoft.txnlist.core.insuremainlist.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.txnlist.core.insuremainlist.entity.CMPManFieldList;
import com.sinosoft.txnlist.core.insuremainlist.entity.CMPManFieldListKey;
import org.springframework.stereotype.Repository;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2018-04-16 10:32:04.893
 * 草莓组合险连带被保险人表3Dao数据操作对象
 */
@Repository
public interface CMPManFieldListDao extends JpaBaseDao<CMPManFieldList, CMPManFieldListKey> {
}