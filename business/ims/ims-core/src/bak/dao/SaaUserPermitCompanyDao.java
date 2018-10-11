package com.sinosoft.ims.core.kernel.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.ims.core.kernel.entity.SaaUserPermitCompany;
import com.sinosoft.ims.core.kernel.entity.SaaUserPermitCompanyKey;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail hongzhongkai
 * @time  2016-09-23 17:19:21.110 
 * 业务权限允许机构表-Saa_UserPermitCompany  数据操作接口类
 */
public interface SaaUserPermitCompanyDao extends JpaBaseDao<SaaUserPermitCompany, SaaUserPermitCompanyKey> {

    List<SaaUserPermitCompany> findAllByPowerIdAndValidStatus(String powerId, String validStatuss);
}