package com.sinosoft.agriclaim.core.businessutilmanage.dao;

import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLAccIPerson;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLAccIPersonKey;
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
 * @time  2017-11-08 05:35:28.283 
 * 索赔申请人信息表Dao数据操作对象
 */
@Repository
public interface PrpLAccIPersonDao extends JpaBaseDao<PrpLAccIPerson,PrpLAccIPersonKey> {
	/**
     * （根据业务号状态位删除实体）
     * @author: 李洋
     * @date: 2017/11/14 11:03
     * @param certiNo 业务号
     * @param flag 状态位
     */
	@Modifying
	@Transactional
	@Query(value = "delete from PrpLAccIPerson where certiNo= :certiNo and flag = :flag ")
	public void deleteByCertiNoAndFlag(@Param(value = "certiNo") String certiNo,@Param(value = "flag") String flag);
	
}