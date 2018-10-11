package com.sinosoft.dms.core.dict.dao;

import com.sinosoft.dms.api.billno.dto.MPrpMaxNoUntiDto;
import com.sinosoft.dms.core.dict.entity.PrpMaxNo;
import com.sinosoft.dms.core.dict.entity.PrpMaxNoKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import java.lang.Object;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-10 12:51:20.949 
 * PrpMaxNoDao数据操作对象
 */
@Repository
public interface PrpMaxNoDao extends JpaBaseDao<PrpMaxNo,PrpMaxNoKey> {

    @Query(value = "select  new com.sinosoft.dms.api.billno.dto.MPrpMaxNoUntiDto( MAX(p.maxNo) ,MIN(p.maxNo) ,COUNT(p)  ) from  PrpMaxNo p where p.groupNo=:groupNo and p.tableName=:tableName ")
     List<MPrpMaxNoUntiDto> queryPrpMaxNo(@Param("groupNo") String groupNo, @Param("tableName") String tableName);

    /**
     * @author 王保良
     * @time  2017-10-11
     * @description 根据groupNo,tableName,maxNo删除PrpMaxUse表相关数据
     */
    @Modifying
    @Transactional
    @Query(value = "delete from PrpMaxNo p where p.groupNo=:groupNo and p.tableName=:tableName and p.maxNo=:maxNo")
    public void deleteByCondition(@Param("groupNo") String groupNo, @Param("tableName") String tableName, @Param("maxNo") String maxNo);

    /**
     * （通过分组号，表名 查询最大序号和最小序号和个数）
     * @author: 王志文
     * @date: 2017/12/14 20:06
     * @param groupNo
     * @param tableName
     * @return
     */
    @Query("select max(p.maxNo),min(p.maxNo),count(p) from PrpMaxNo p WHERE p.groupNo =:groupNo and p.tableName =:tableName")
    List<Object []> queryMaxNoByGroupNoAndTableName(@Param("groupNo") String groupNo, @Param("tableName") String tableName);
}