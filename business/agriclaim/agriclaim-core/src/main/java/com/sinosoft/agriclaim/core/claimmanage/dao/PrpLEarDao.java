package com.sinosoft.agriclaim.core.claimmanage.dao;

import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLEar;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLEarKey;
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
 * @time  2017-12-01 01:33:42.103 
 * 耳标号表Dao数据操作对象
 */
@Repository
public interface PrpLEarDao extends JpaBaseDao<PrpLEar,PrpLEarKey> {
	/**
     * （根据报案号回写状态）
     * @author: 李洋
     * @date: 2017/11/14 11:03
     * @param registNo 报案号
     */
	@Query("update PrpLEar s set s.validStatus = '0' where s.registNo =:registNo ")
	void updateValidStatusByRegistNo(@Param("registNo") String registNo);
}