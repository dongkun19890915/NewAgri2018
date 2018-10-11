package com.sinosoft.dms.core.model.dao;

import com.sinosoft.dms.core.model.entity.PrpModelAddressSub;
import com.sinosoft.dms.core.model.entity.PrpModelAddressSubKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 11:42:08.278 
 * 模板保险地址表Dao数据操作对象
 */
@Repository
public interface PrpModelAddressSubDao extends JpaBaseDao<PrpModelAddressSub,PrpModelAddressSubKey> {

    /**
     * 根据模板代码删除模板保险地址表信息
     * @author: 田慧
     * @date: 2017/11/14 15:10
     * @param modelCodeList 模板代码集合
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query(value = "delete from PrpModelAddressSub pp where pp.modelCode in(:modelCodeList)")
    public void deleteByModelCodeList(@Param("modelCodeList") List<String> modelCodeList);

    /**
     *  根据模板代码查询模板保险地址表信息
     * @author: 田慧
     * @date: 2018/1/29 11:23
     * @param modelCode  模板代码
     * @return 模板保险地址表信息list
     */
    public List<PrpModelAddressSub> findByModelCode(String modelCode);
}