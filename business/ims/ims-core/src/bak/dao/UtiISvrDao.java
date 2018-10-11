package com.sinosoft.ims.core.kernel.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.ims.core.kernel.entity.UtiISvr;
import com.sinosoft.ims.core.kernel.entity.UtiISvrKey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail hongzhongkai
 * @time  2016-09-23 17:19:21.110 
 * 服务表-UtiISvr  数据操作接口类
 */
public interface UtiISvrDao extends JpaBaseDao<UtiISvr, UtiISvrKey> {
    @Query(
            value="select svrCode from UtiISvr ",
            nativeQuery=true)
    List<String> findBySqlSelsvrCode();
}