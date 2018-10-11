package com.sinosoft.agriclaim.core.registmanage.dao;

import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegistExt;
import com.sinosoft.agriclaim.core.registmanage.entity.PrpLRegistExtKey;
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
 * @time  2017-11-08 05:45:22.527 
 * 报案信息补充说明Dao数据操作对象
 */
@Repository
public interface PrpLRegistExtDao extends JpaBaseDao<PrpLRegistExt,PrpLRegistExtKey> {
	@Query(value = "select p from PrpLRegistExt p where p.registNo = :registNo ")
    public List<PrpLRegistExt> queryByRegistNo(@Param("registNo") String registNo);

    /**
     * @description:方法功能简述：通过业务号删除
     * @author 安齐崇
     * @date 2017年12月23日下午5:37:09
     * @param businessNo
     */
    @Modifying
    @Query("delete from PrpLRegistExt where registNo =:registNo")
    void deleteByRegistNo(@Param("registNo") String registNo);
}