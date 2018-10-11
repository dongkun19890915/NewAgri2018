package com.sinosoft.dms.core.dict.dao;

import com.sinosoft.dms.core.dict.entity.PrpDNewCode;
import com.sinosoft.dms.core.dict.entity.PrpDNewCodeKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PrpDNewCodeDao extends JpaBaseDao<PrpDNewCode,PrpDNewCodeKey> {

    void delete(PrpDNewCodeKey key);

    PrpDNewCode save(PrpDNewCode record);

    //List<PrpDNewCode> selectByExample(PrpDNewCodeExample example);
    
    //List<PrpDNewCode> selectByCondition(Map<String, Object> map);
    
    //List<PrpDNewCode> selectByConditionlike(Map<String, Object> map);

    PrpDNewCode findOne(PrpDNewCodeKey key);

    //int updateByPrimaryKey(PrpDNewCode record);

    @Query(
            value="select * from PRPDNEWCODE where validStatus=:validStatus \n#pageable\n",
            countQuery = "select count(*) from table_name where validStatus=:validStatus",
            nativeQuery=true)
    Page<PrpDNewCode> findBySql(@Param("validStatus") int validStatus, Pageable pageable);
}