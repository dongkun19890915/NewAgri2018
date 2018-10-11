package com.sinosoft.txnlist.core.plantinginsurancelist.dao;

import com.sinosoft.txnlist.core.plantinginsurancelist.entity.HerdSettleList;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.HerdSettleListKey;
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
 * 养殖险理赔明细表Dao数据操作对象
 */
@Repository
public interface HerdSettleListDao extends JpaBaseDao<HerdSettleList,HerdSettleListKey> {


    /**
     *  根据GIS清单号查询承保清单 养殖险
     * @param gisInsureListCode
     * @return
     * @throws Exception
     * @author 汪强
     */
    @Query("select p from HerdSettleList p where p.insureListCode in (select c.inusreListCode from InsureMainList c where c.gisInsureListCode=:gisInsureListCode and c.classCode='32')")
    public List<HerdSettleList> queryByGisInsureListCode(@Param("gisInsureListCode")String gisInsureListCode);
}