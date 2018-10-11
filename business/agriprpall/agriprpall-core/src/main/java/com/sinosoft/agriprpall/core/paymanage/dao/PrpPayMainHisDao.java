package com.sinosoft.agriprpall.core.paymanage.dao;

import com.sinosoft.agriprpall.core.paymanage.entity.PrpPayMainHis;
import com.sinosoft.agriprpall.core.paymanage.entity.PrpPayMainHisKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-12-20 08:18:36.753
 * 承保支付信息轨迹表Dao数据操作对象
 */
@Repository
public interface PrpPayMainHisDao extends JpaBaseDao<PrpPayMainHis, PrpPayMainHisKey> {

    /**
     * 获取相同的payNo下最大的序号
     *
     * @param payNo 支付号
     * @return 最大的序号
     * @author: 何伟东
     * @date: 2017/12/26 16:54
     */
    @Query(value = "select max(ph.serialNo) from PrpPayMainHis ph where ph.payNo = :payNo")
    Integer queryMaxSerialNo(@Param(value = "payNo") String payNo);
}