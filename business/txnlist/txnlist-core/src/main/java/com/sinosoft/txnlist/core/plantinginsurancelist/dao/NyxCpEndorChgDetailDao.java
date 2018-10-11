package com.sinosoft.txnlist.core.plantinginsurancelist.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.NyxCpEndorChgDetail;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.NyxCpEndorChgDetailKey;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740
 * nyxcpendorchgdetailDao数据操作对象
 */
@Repository
public interface NyxCpEndorChgDetailDao extends JpaBaseDao<NyxCpEndorChgDetail, NyxCpEndorChgDetailKey> {

    /**
     * 根据清单编号查询分户
     *
     * @param inusreListCode 清单编号
     * @return
     * @author: 何伟东
     * @date: 2018/1/11 15:24
     */
    List<NyxCpEndorChgDetail> findByInusreListCode(String inusreListCode);

    @Query(value = "delete from NyxCpEndorChgDetail n where n.inusreListCode=?1")
    @Modifying
    @Transactional
    public void removeByInusreListCode(String inusreListCode)throws Exception;

    @Query(value = "select n from NyxCpEndorChgDetail n where n.inusreListCode=?1")
    public List<NyxCpEndorChgDetail> queryAllByInusreListCode(String insureListCode)throws Exception;
}