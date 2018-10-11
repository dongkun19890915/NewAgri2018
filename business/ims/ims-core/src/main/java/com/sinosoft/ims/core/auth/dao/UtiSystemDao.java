package com.sinosoft.ims.core.auth.dao;

import com.sinosoft.ims.core.auth.entity.UtiSystem;
import com.sinosoft.ims.core.auth.entity.UtiSystemKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * 系统定义表Dao数据操作对象
 */
@Repository
public interface UtiSystemDao extends JpaBaseDao<UtiSystem,UtiSystemKey> {
}