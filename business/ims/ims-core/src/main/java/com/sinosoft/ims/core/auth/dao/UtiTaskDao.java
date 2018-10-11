package com.sinosoft.ims.core.auth.dao;

import org.springframework.stereotype.Repository;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.ims.core.auth.entity.UtiTask;
import com.sinosoft.ims.core.auth.entity.UtiTaskKey;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:27.902 
 * 任务定义表Dao数据操作对象
 */
@Repository
public interface UtiTaskDao extends JpaBaseDao<UtiTask,UtiTaskKey> {
}