package com.sinosoft.pms.core.kernel.dao;

import com.sinosoft.pms.core.kernel.entity. PrpDclauseCodeHis;
import com.sinosoft.pms.core.kernel.entity. PrpDclauseCodeHisKey;
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
 * @time  2017-11-07 03:36:19.515
 * 条款配置轨迹表主表Dao数据操作对象
 */
@Repository
public interface  PrpDclauseCodeHisDao extends JpaBaseDao< PrpDclauseCodeHis, PrpDclauseCodeHisKey> {

    /**
     * 查询条款配置轨迹主表的最大修改次数
     * @author: 刘曼曼
     * @date: 2017/11/9 14:32
     * @return Double 修改最大次数
     */
    @Query(value = "select COALESCE(max(indexNo),'0') from PrpDclauseCodeHis")
    public  Double getMaxIndexNo();
}