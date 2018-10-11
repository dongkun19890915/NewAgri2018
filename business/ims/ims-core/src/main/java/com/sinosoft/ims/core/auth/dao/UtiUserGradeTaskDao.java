package com.sinosoft.ims.core.auth.dao;

import com.sinosoft.ims.core.auth.entity.UtiUserGradeTask;
import com.sinosoft.ims.core.auth.entity.UtiUserGradeTaskKey;
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
 * 机构员工岗位差异功能权限表Dao数据操作对象
 */
@Repository
public interface UtiUserGradeTaskDao extends JpaBaseDao<UtiUserGradeTask,UtiUserGradeTaskKey> {

    /**
     *  根据comCode、userCode查询实体
     * @author: ldd
     * @date: 2017/11/17 9:14
     * @param comCode 机构代码
     * @param userCode 用户代码
     * @return  UtiUserGradeTaskDto集合
     * @throws Exception
     */
    @Query("SELECT p FROM UtiUserGradeTask p WHERE p.comCode = :comCode AND p.userCode = :userCode")
    public List<UtiUserGradeTask> findAllByCondition(@Param("comCode")String comCode,@Param("userCode")String userCode) throws Exception;
    /**
     *  根据comCode、userCode、gradeCode查询实体
     * @author: ldd
     * @date: 2017/11/17 9:14
     * @param comCode 机构代码
     * @param userCode 用户代码
     * @param gradeCode 岗位代码
     * @return  UtiUserGradeTaskDto集合
     * @throws Exception
     */
    @Query("SELECT p FROM UtiUserGradeTask p WHERE p.comCode = :comCode AND p.userCode = :userCode and p.gradeCode =:gradeCode")
    public List<UtiUserGradeTask> queryUtiUserGradeTaskDtoByCondition(@Param("comCode")String comCode,@Param("userCode")String userCode,@Param("gradeCode")String gradeCode) throws Exception;
}