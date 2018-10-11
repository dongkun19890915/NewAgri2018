package com.sinosoft.agriclaim.core.prepaymanage.dao;

import com.sinosoft.agriclaim.core.prepaymanage.entity.PrpLPtext;
import com.sinosoft.agriclaim.core.prepaymanage.entity.PrpLPtextKey;
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
 * 预赔文字表Dao数据操作对象
 */
@Repository
public interface PrpLPtextDao extends JpaBaseDao<PrpLPtext,PrpLPtextKey> {
}