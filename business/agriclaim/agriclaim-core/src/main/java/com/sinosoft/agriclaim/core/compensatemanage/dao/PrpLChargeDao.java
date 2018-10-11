package com.sinosoft.agriclaim.core.compensatemanage.dao;

import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLCharge;
import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLChargeKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:40:44.225 
 * 赔款费用信息表Dao数据操作对象
 */
@Repository
public interface PrpLChargeDao extends JpaBaseDao<PrpLCharge,PrpLChargeKey> {
    /**
     *
     * @description 根据业务号查询PrpLCharge
     * @author 周柯宇
     * @date 2018年1月26日 下午3:53:37
     * @param 业务号
     * @return List<PrpLCharge>
     * @Throws Exception
     */
    @Query("select p from PrpLCharge p where p.compensateNo=:businessNo")
    List<PrpLCharge> findByCompensateNo(@Param("businessNo") String businessNo);

    /**
     * （理算保存赔付信息删除历史数据）
     * @author: 王志文
     * @date: 2018/4/27 15:08
     * @param compensateNo
     * @throws Exception
     */
    @Transactional
    @Modifying
    @Query(value = "delete from PrpLCharge p where p.compensateNo =:compensateNo")
    void deleteAllByCompensateNo(@Param("compensateNo") String compensateNo);
}