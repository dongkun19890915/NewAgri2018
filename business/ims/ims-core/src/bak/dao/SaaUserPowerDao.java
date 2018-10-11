package com.sinosoft.ims.core.kernel.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.ims.core.kernel.entity.SaaUserPower;
import com.sinosoft.ims.core.kernel.entity.SaaUserPowerKey;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail hongzhongkai
 * @time  2016-09-23 17:19:21.110 
 * 数据权限授权表-Saa_UserPower  数据操作接口类
 */
public interface SaaUserPowerDao extends JpaBaseDao<SaaUserPower, SaaUserPowerKey> {

    List<SaaUserPower> findOneByUserCodeAndTaskID(String userCode, String taskId);
}