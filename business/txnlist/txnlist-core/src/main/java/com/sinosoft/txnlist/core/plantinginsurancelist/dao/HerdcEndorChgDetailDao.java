package com.sinosoft.txnlist.core.plantinginsurancelist.dao;

import com.sinosoft.txnlist.core.plantinginsurancelist.entity.HerdcEndorChgDetail;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.HerdcEndorChgDetailKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-08 01:17:24.831 
 * HerdcEndorChgDetailDao数据操作对象
 */
@Repository
public interface HerdcEndorChgDetailDao extends JpaBaseDao<HerdcEndorChgDetail,HerdcEndorChgDetailKey> {
    /**
     * 按照清单号删除
     *@param inusreListCode 清单号
     *@author 王心洋
     *@time 2017-11-18
     */
    @Query(value = "delete from HerdcEndorChgDetail h where h.inusreListCode=:inusreListCode")
    @Modifying
    @Transactional
    public void removeByInusreListCode(@Param("inusreListCode") String inusreListCode);
    @Query(value = "select h from HerdcEndorChgDetail h where h.inusreListCode=?1")
    public List<HerdcEndorChgDetail> queryAllByInusreListCode(String insureListCode)throws Exception;

}