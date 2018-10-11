package com.sinosoft.agriclaim.core.businessutilmanage.dao;

import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLCfeecoins;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLCfeecoinsKey;
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
 * @time  2017-11-08 05:35:28.283 
 * 共保费用信息表（无表名）Dao数据操作对象
 */
@Repository
public interface PrpLCfeecoinsDao extends JpaBaseDao<PrpLCfeecoins,PrpLCfeecoinsKey> {

    /**
     *
     * @description 根据业务号查询PrpLCfeecoins
     * @author 周柯宇
     * @date 2018年1月26日 下午3:45:11
     * @param businessNo业务号
     * @return List<PrpLCfeecoinsDto>
     * @Throws Exception
     */
    List<PrpLCfeecoins> findByBusinessNo(String businessNo);
}