package com.sinosoft.agriclaim.core.checkmanage.dao;

import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLverifyLossExt;
import com.sinosoft.agriclaim.core.checkmanage.entity.PrpLverifyLossExtKey;
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
 * @time  2017-11-17 08:28:31.346 
 * 处理意见表Dao数据操作对象
 */
@Repository
public interface PrpLverifyLossExtDao extends JpaBaseDao<PrpLverifyLossExt,PrpLverifyLossExtKey> {
	/**
     * （根据报案号和标的代码删除实体）
     * @author: 李洋
     * @date: 2017/11/14 11:03
     * @param registNo 报案号
     * @param lossItemCode 标的代码
     */
	@Modifying
	@Transactional
	@Query(value = "delete from PrpLverifyLossExt where registNo = :registNo and lossItemCode= :lossItemCode ")
	public void deleteByRegistNoAndLossCode(@Param(value = "registNo") String registNo,@Param(value = "lossItemCode") String lossItemCode);
}