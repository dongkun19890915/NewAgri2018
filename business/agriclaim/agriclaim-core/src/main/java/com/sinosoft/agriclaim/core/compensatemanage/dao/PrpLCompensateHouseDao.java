package com.sinosoft.agriclaim.core.compensatemanage.dao;

import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLCompensateHouse;
import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLCompensateHouseKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225 
 * 农房理赔身份证信息表Dao数据操作对象
 */
@Repository
public interface PrpLCompensateHouseDao extends JpaBaseDao<PrpLCompensateHouse,PrpLCompensateHouseKey> {
	/**
     * （根据报案号、节点类型删除实体）
     * @author: 李洋
     * @date: 2017/11/14 11:03
     * @param registNo 报案号
     * @param nodeType 节点类型
     */
	@Modifying
	@Transactional
	@Query(value = "delete from PrpLCompensateHouse where registNo = :registNo and nodeType= :nodeType ")
	public void deleteByRegistNoAndNodeType(@Param(value = "registNo") String registNo,@Param(value = "nodeType") String nodeType);
}