package com.sinosoft.ims.core.kernel.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.ims.core.kernel.entity.UtiIAccount;
import com.sinosoft.ims.core.kernel.entity.UtiIAccountKey;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail hongzhongkai
 * @time  2016-09-23 17:19:21.110 
 * 账户表-UtiIAccount  数据操作接口类
 */
public interface UtiIAccountDao extends JpaBaseDao<UtiIAccount, UtiIAccountKey> {

    List<UtiIAccount> findAllByUserCode(String userCode);
}