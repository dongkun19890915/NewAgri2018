package com.sinosoft.agriclaim.core.prepaymanage.dao;

import com.sinosoft.agriclaim.core.prepaymanage.entity.PrpLPrepay;
import com.sinosoft.agriclaim.core.prepaymanage.entity.PrpLPrepayKey;
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
 * @time  2017-11-08 05:44:02.119 
 * 预支付理赔表Dao数据操作对象
 */
@Repository
public interface PrpLPrepayDao extends JpaBaseDao<PrpLPrepay,PrpLPrepayKey> {
    /**
     * @author 周柯宇
     * @time  2017-11-08 05:44:02.119
     * 根据条件查询PrpLPrepay表
     */
    @Query(value="select p from PrpLPrepay p where p.claimNo=:claimNo and p.underWriteFlag in (:underWriteFlagList)")
    public List<PrpLPrepay> queryByCondition(@Param("claimNo")String claimNo,@Param("underWriteFlagList")List<String> underWriteFlagList);

    /**
     * （预赔数据查询）
     * @author: 王志文
     * @date: 2018/5/18 8:54
     * @param claimNo
     * @return
     */
    @Query(value = "select p from PrpLPrepay p where p.claimNo =:claimNo")
    public List<PrpLPrepay> queryAllByClaimNo(@Param("claimNo")String claimNo);
}