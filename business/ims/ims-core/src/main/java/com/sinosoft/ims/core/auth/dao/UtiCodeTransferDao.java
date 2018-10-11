package com.sinosoft.ims.core.auth.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.ims.core.auth.entity.UtiCodeTransfer;
import com.sinosoft.ims.core.auth.entity.UtiCodeTransferKey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:12.703 
 * UtiCodeTransferDao数据操作对象
 */
@Repository
public interface UtiCodeTransferDao extends JpaBaseDao<UtiCodeTransfer,UtiCodeTransferKey> {
    /**
     * 根据险种大类查询UtiCodeTransferDto 险别大类结果集
     * @author: 田慧
     * @date: 2017/11/22 16:59
     * @param riskType 险种大类
     * @return UtiCodeTransfer 险别大类的集合
     */
    public List<UtiCodeTransfer> findByRiskType(String riskType);
}