package com.sinosoft.ims.core.auth.dao;

import com.sinosoft.ims.core.auth.entity.UtiUserGrade;
import com.sinosoft.ims.core.auth.entity.UtiUserGradeKey;
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
 * 用户权限表Dao数据操作对象
 */
@Repository
public interface UtiUserGradeDao extends JpaBaseDao<UtiUserGrade,UtiUserGradeKey> {

    /**
     *  根据comCode、userCode查询UtiUserGrade集合
     * @author: ldd
     * @date: 2017/11/16 14:55
     * @param comCode 机构代码
     * @param userCode UtiUserGrade集合
     * @return UtiUserGrade集合
     * @throws Exception
     */
    @Query("SELECT p FROM UtiUserGrade p WHERE p.comCode = :comCode AND p.userCode = :userCode")
    public List<UtiUserGrade> findAllByCondition(@Param("comCode")String comCode,@Param("userCode")String userCode) throws Exception;

    /**
     * 根据userCode查询UtiUserGrade集合
     * @author: 田健
     * @date: 2018/2/22 17:06
     * @param userCode UtiUserGrade集合
     * @return UtiUserGrade集合
     * @throws Exception
     */
    @Query("SELECT p FROM UtiUserGrade p WHERE p.userCode = :userCode")
    public List<UtiUserGrade> findAllByUserCode(@Param("userCode")String userCode) throws Exception;
}