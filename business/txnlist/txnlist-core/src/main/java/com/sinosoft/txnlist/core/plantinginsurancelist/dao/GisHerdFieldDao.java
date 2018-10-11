package com.sinosoft.txnlist.core.plantinginsurancelist.dao;

import com.sinosoft.txnlist.core.plantinginsurancelist.entity.GisHerdField;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.GisHerdFieldKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 牲畜耳标号/脚环号表Dao数据操作对象
 * @author: 何伟东
 * @date: 2017/12/19 9:50
 */
@Repository
public interface GisHerdFieldDao extends JpaBaseDao<GisHerdField,GisHerdFieldKey> {
    /**
     * 更具清单编号和序号查询金禾投保预确认清单耳标号表
     * @author: 陈道洋
     * @date: 2017/12/19 15:47
     * @param insureListCode 清单编号
     * @param serialNo 序号
     * @return
     */
    public List<GisHerdField> findByInsureListCodeAndSerialNo(String insureListCode, Integer serialNo);
}