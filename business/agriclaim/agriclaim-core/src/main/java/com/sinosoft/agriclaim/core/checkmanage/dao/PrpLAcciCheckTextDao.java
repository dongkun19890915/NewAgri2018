package com.sinosoft.agriclaim.core.checkmanage.dao;

import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLAcciCheckText;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLAcciCheckTextKey;
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
 * @time  2017-11-08 05:38:49.324 
 * 调查文本信息表Dao数据操作对象
 */
@Repository
public interface PrpLAcciCheckTextDao extends JpaBaseDao<PrpLAcciCheckText,PrpLAcciCheckTextKey> {
	/**
     * （根据查勘号删除实体）
     * @author: 李洋
     * @date: 2017/11/14 11:03
     * @param checkNo 查勘号
     */
	@Modifying
	@Transactional
	@Query(value = "delete from PrpLAcciCheckText where checkNo = :checkNo ")
	public void deleteByCheckNo(@Param(value = "checkNo") String checkNo);
}