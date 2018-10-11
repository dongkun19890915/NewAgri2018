package com.sinosoft.ims.core.auth.dao;

import com.sinosoft.ims.core.auth.entity.UtiGradeTask;
import com.sinosoft.ims.core.auth.entity.UtiGradeTaskKey;
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
 * 岗位功能权限表Dao数据操作对象
 */
@Repository
public interface UtiGradeTaskDao extends JpaBaseDao<UtiGradeTask,UtiGradeTaskKey> {
    /**
     * 根据GradeCodes集合查询UtiGradeTask集合
     * @author: 田健
     * @date: 2018/2/22 17:52
     * @param GradeCodes 岗位集合
     * @return UtiGradeTask集合
     * @throws Exception
     */
    @Query("SELECT p FROM UtiGradeTask p WHERE p.gradeCode in :GradeCodes")
    public List<UtiGradeTask> findAllByGradeCode(@Param("GradeCodes") List<String> GradeCodes)throws Exception;

    /**
     *  查询UtiGradeTask表集合
     * @author: ldd
     * @date: 2017/11/17 9:23
     * @param GradeCode 岗位代码
     * @return UtiGradeTaskDto集合
     */
    @Query("SELECT p FROM UtiGradeTask p WHERE p.gradeCode in :GradeCode")
    public List<UtiGradeTask> queryAllByGradeCode(@Param("GradeCode") String GradeCode)throws Exception;
}