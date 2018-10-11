package com.sinosoft.ims.core.auth.dao;

import com.sinosoft.ims.core.auth.entity.UtiUserGradePower;
import com.sinosoft.ims.core.auth.entity.UtiUserGradePowerKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
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
 * @time  2017-08-22 03:00:27.902 
 * 机构员工岗位业务权限表Dao数据操作对象
 */
@Repository
public interface UtiUserGradePowerDao extends JpaBaseDao<UtiUserGradePower,UtiUserGradePowerKey> {

    /**
     * 根据comCode、userCode、gradeCode查询UtiUserGradePower表信息
     * @param comCode 机构代码
     * @param userCode 用户代码
     * @return UtiUserGradePower集合
     * @throws Exception
     */
    @Query("SELECT p FROM UtiUserGradePower p WHERE p.comCode = :comCode AND p.userCode = :userCode")
    public List<UtiUserGradePower> findAllByCondition(@Param("comCode")String comCode,@Param("userCode")String userCode) throws Exception;

    @Query("SELECT p FROM UtiUserGradePower p WHERE p.comCode = :comCode")
    public List<UtiUserGradePower> findAllByComCode(@Param("comCode")String comCode) throws Exception;

}