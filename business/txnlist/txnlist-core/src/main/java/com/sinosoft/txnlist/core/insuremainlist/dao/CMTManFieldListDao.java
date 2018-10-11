package com.sinosoft.txnlist.core.insuremainlist.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.txnlist.core.insuremainlist.entity.CMTManFieldList;
import com.sinosoft.txnlist.core.insuremainlist.entity.CMTManFieldListKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2018-04-16 10:32:04.893
 * 草莓组合险连带被保险人表Dao数据操作对象
 */
@Repository
public interface CMTManFieldListDao extends JpaBaseDao<CMTManFieldList, CMTManFieldListKey> {

    @Query(value = "select  count(i) from CMTManFieldList i where i.insureListCode=:insureListCode")
    int findAllByIn(String insureListCode);
}