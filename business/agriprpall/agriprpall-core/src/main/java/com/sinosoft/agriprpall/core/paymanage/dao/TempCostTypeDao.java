package com.sinosoft.agriprpall.core.paymanage.dao;

import com.sinosoft.agriprpall.core.paymanage.entity.TempCostType;
import com.sinosoft.agriprpall.core.paymanage.entity.TempCostTypeKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 费用类型对应收付原因的临时表Dao
 *
 * @date: 2018/2/12 15:08
 * @author: 何伟东
 */
@Repository
public interface TempCostTypeDao extends JpaRepository<TempCostType, TempCostTypeKey> {

}