package com.sinosoft.agriprpall.core.paymanage.dao;

import com.sinosoft.agriprpall.core.paymanage.entity.PrpPaySub;
import com.sinosoft.agriprpall.core.paymanage.entity.PrpPaySubKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.stereotype.Repository;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-12-20 08:18:36.753
 * 承保支付信息子表Dao数据操作对象
 */
@Repository
public interface PrpPaySubDao extends JpaBaseDao<PrpPaySub, PrpPaySubKey> {

    /**
     * 根据批单号码查询支付信息子表数据
     *
     * @param endorseNo 批单号码
     * @param costType 批单号码
     * @return 支付信息子表数据
     * @author: 何伟东
     * @date: 2017/12/26 11:18
     */
    PrpPaySub findByEndorseNoAndCostType(String endorseNo,String costType);
}