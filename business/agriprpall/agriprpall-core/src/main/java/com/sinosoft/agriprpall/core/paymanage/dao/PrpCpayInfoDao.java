package com.sinosoft.agriprpall.core.paymanage.dao;

import com.sinosoft.agriprpall.core.paymanage.entity.PrpCpayInfo;
import com.sinosoft.agriprpall.core.paymanage.entity.PrpCpayInfoKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.stereotype.Repository;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2018-05-27 08:23:10.186
 * 支付信息表Dao数据操作对象
 */
@Repository
public interface PrpCpayInfoDao extends JpaBaseDao<PrpCpayInfo, PrpCpayInfoKey> {
}