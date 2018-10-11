package com.sinosoft.txnlist.core.plantingUpLoadInsuranceList.dao;

import com.sinosoft.txnlist.core.plantingUpLoadInsuranceList.entity.PlantingUpLoadInsuranceList;
import com.sinosoft.txnlist.core.plantingUpLoadInsuranceList.entity.PlantingUpLoadInsuranceListKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-23 11:48:01.364 
 * plantingUpLoadInsuranceListDao数据操作对象
 */
@Repository
public interface PlantingUpLoadInsuranceListDao extends JpaBaseDao<PlantingUpLoadInsuranceList,PlantingUpLoadInsuranceListKey> {
    /**
     * @description:（根据inreListcode删除清单数据）
     * @author: 王心洋
     * @date: 2017/10/24 17:26
     * @param inusreListcode
     */
    @Transactional
    @Modifying
    @Query(value ="delete from PlantingUpLoadInsuranceList d where d.inusreListCode=:inusreListcode")
    public void removeByInusreListcode(@Param("inusreListcode") String inusreListcode);
}