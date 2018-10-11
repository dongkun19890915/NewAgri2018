package com.sinosoft.txnlist.core.plantinginsurancelist.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.PlantingTCirculationlist;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.PlantingTCirculationlistKey;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-30 07:53:53.940
 * 投保明细表Dao数据操作对象
 */
@Repository
public interface PlantingTCirculationlistDao extends JpaBaseDao<PlantingTCirculationlist, PlantingTCirculationlistKey> {

    List<PlantingTCirculationlist> findByInusreListCode(String inusreListCode);

}