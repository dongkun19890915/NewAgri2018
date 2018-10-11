package com.sinosoft.agriclaim.core.compensatemanage.dao;

import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLCText;
import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLCTextKey;
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
 * @time  2017-11-08 05:40:44.225 
 * 赔款计算文字表Dao数据操作对象
 */
@Repository
public interface PrpLCTextDao extends JpaBaseDao<PrpLCText,PrpLCTextKey> {

    /**
     * （理算书打印获取信息）
     * @author: 王志文
     * @date: 2017/11/15 12:00
     * @param compensateNo
     * @return
     */
    @Query("select p from PrpLCText p where p.compensateNo =:compensateNo and p.textType = '7'")
    List<PrpLCText> queryPrpLCTextsByCompensateNoAndTextType(@Param("compensateNo") String compensateNo);
}