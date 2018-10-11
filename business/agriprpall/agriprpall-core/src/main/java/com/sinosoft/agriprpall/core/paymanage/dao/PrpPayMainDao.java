package com.sinosoft.agriprpall.core.paymanage.dao;

import com.sinosoft.agriprpall.core.paymanage.entity.PrpPayMain;
import com.sinosoft.agriprpall.core.paymanage.entity.PrpPayMainKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-12-20 08:18:36.753
 * 承保主支付信息表Dao数据操作对象
 */
@Repository
public interface PrpPayMainDao extends JpaBaseDao<PrpPayMain, PrpPayMainKey> {

    /**
     * 根据支付号查询支付信息主表数据
     *
     * @param payNo 支付号
     * @return 支付信息主表数据
     * @author: 何伟东
     * @date: 2017/12/26 11:31
     */
    List<PrpPayMain> findByPayNo(String payNo);
}