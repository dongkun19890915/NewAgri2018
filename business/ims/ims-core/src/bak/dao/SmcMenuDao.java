package com.sinosoft.ims.core.kernel.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.ims.core.kernel.entity.SmcMenu;
import com.sinosoft.ims.core.kernel.entity.SmcMenuKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail hongzhongkai
 * @time  2016-09-23 17:19:21.110 
 * 菜单表-Smc_Menu  数据操作接口类
 */
public interface SmcMenuDao extends JpaBaseDao<SmcMenu, SmcMenuKey> {

    @Query("SELECT DISTINCT m  FROM SmcMenu m ,SaaTask t " +
            ", SaaGradeTask gt , SaaUserGrade ug " +
            "WHERE m.taskCode = t.taskCode and t.iD = gt.taskID and gt.gradeID = ug.gradeID and ug.validStatus = '1' AND ug.userCode = :userCode")
    List<SmcMenu> findMenuByUserCode(@Param("userCode")String userCode);
}