package com.sinosoft.agriclaim.core.claimmanage.dao;

import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLDangerCoins;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLDangerCoinsKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-04-11 07:01:52.256 
 * 危险单位标的表Dao数据操作对象
 */
@Repository
public interface PrpLDangerCoinsDao extends JpaBaseDao<PrpLDangerCoins,PrpLDangerCoinsKey> {
    /**
     * （根据里案号删除共保信息）
     * @author: 王志文
     * @date: 2018/4/11 17:57
     * @param claimNo
     */
    @Modifying
    @Query("delete from PrpLDangerCoins p where p.certiNo=:claimNo ")
    @Transactional(rollbackFor = Exception.class)
    public void deleteByCertiNo(@Param("claimNo") String claimNo);

    /**
     * （根据里案号和dangerNo删除共保信息）
     * @author: 王志文
     * @date: 2018/4/11 17:57
     * @param
     */
    @Modifying
    @Query("delete from PrpLDangerCoins p where p.certiNo=:certiNo and p.dangerNo=:dangerNo")
    @Transactional(rollbackFor = Exception.class)
    void deleteAllByCertiNoAndDangerNo(@Param("certiNo")String certiNo,@Param("dangerNo")Integer dangerNo);
}