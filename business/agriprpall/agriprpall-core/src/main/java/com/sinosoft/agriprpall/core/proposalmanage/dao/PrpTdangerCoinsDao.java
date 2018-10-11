package com.sinosoft.agriprpall.core.proposalmanage.dao;

import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTdangerCoins;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTdangerCoinsKey;
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
 * @time  2017-11-04 09:41:15.792 
 * 共保危险单位表Dao数据操作对象
 */
@Repository
public interface PrpTdangerCoinsDao extends JpaBaseDao<PrpTdangerCoins,PrpTdangerCoinsKey> {
}