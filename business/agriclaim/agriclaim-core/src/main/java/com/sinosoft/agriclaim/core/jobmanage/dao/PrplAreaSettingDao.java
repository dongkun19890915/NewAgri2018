package com.sinosoft.agriclaim.core.jobmanage.dao;

import com.sinosoft.agriclaim.api.jobmanage.dto.PrplAreaSettingDto;
import com.sinosoft.agriclaim.api.jobmanage.dto.RequestSavePrplAreaSettingDto;
import com.sinosoft.agriclaim.core.jobmanage.entity.PrplAreaSetting;
import com.sinosoft.agriclaim.core.jobmanage.entity.PrplAreaSettingKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
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
 * @time  2017-11-08 05:42:38.981
 * 区域设置表Dao数据操作对象
 */
@Repository
public interface PrplAreaSettingDao extends JpaBaseDao<PrplAreaSetting,PrplAreaSettingKey> {



    @Query(value="select p.handlerName from PrplAreaSetting p where p.handlerCode=?1 and p.handleDept=?2 and p.classCode=?3")
    String findPrplAreaSettingByHandlerCodeAndHandleDept(String handlerCode, String handleDept,String classCode);

    @Modifying
    @Transactional
    @Query(value="delete from PrplAreaSetting where handlerCode=?1 and handleDept=?2")
    void deletePrplAreaSettingByHandlerCode(String handlerCode,String handleDept);

    @Modifying
    @Transactional
    @Query(value="delete from PrplAreaSetting where handleDept=:handleDept")
    void deletePrplAreaSettingByHandleDept(@Param(value="handleDept") String handleDept);

    @Query(value = "select p from PrplAreaSetting p where p.classCode=:classCode and p.handlerCode=:handlerCode  order by p.flowinTime asc")
    public List<PrplAreaSetting> findPrplAreaSettingByClassCodeAndHandlerCode(@Param("classCode") String areaClassCode,@Param("handlerCode") String handlerCode);

    @Query(value="select p from PrplAreaSetting p where p.handleDept in(:list) and p.area is not null")
    public List<PrplAreaSetting> findPrplAreaSettingByhandleDept(@Param("list") List list);
}