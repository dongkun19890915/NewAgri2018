package com.sinosoft.txnlist.core.plantinginsurancelist.dao;

import com.sinosoft.txnlist.core.plantinginsurancelist.entity.SettleMainList;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.SettleMainListKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * settlemainlistDao数据操作对象
 */
@Repository
public interface SettleMainListDao extends JpaBaseDao<SettleMainList,SettleMainListKey> {

    @Query(value = "select s from SettleMainList s where s.policyNo=?1 and s.validity=?2 ")
    public List<SettleMainList> queryAllByCondition(String policyNo,String valiDity);
}