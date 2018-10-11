package com.sinosoft.agriclaim.core.checkmanage.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLCheck;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLCheckKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:38:49.324 
 * 查勘/代查勘信息表Dao数据操作对象
 */
@Repository
public interface PrpLCheckDao extends JpaBaseDao<PrpLCheck,PrpLCheckKey> {
	@Modifying
	@Transactional
	@Query("DELETE from PrpLCheck where registNo=?1")
	void deleteByRegistNo(String registNo);

	/**
	 *@description 按报案号查询最大序列号
	 *@param registNo 清单号
	 *@return serialNo 最大序列号
	 *@author 王心洋
	 *@time 2018-01-18
	 */
	@Transactional
	@Query(value = "select max( l.referSerialNo) from PrpLCheck l where  l.registNo=:registNo")
	Integer queryMaxSerialByRegistNo(@Param(value="registNo") String registNo);

}