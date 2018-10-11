package com.sinosoft.ims.core.auth.dao;

import com.sinosoft.ims.core.auth.entity.UtiMenu;
import com.sinosoft.ims.core.auth.entity.UtiMenuKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:27.902 
 * 菜单表Dao数据操作对象
 */
@Repository
public interface UtiMenuDao extends JpaBaseDao<UtiMenu,UtiMenuKey> {
	/**
	 * @description
	 * @param userCode
	 * @return List<UtiMenu>
	 * @author libin
	 * @date 2017年8月24日 上午10:29:05
	 */
	@Query("SELECT DISTINCT m  FROM UtiMenu m , UtiTask t , UtiGradeTask gt , UtiUserGrade ug " +
            "WHERE m.taskCode = t.taskCode and t.taskCode = gt.taskCode "
            + "and gt.gradeCode = ug.gradeCode and ug.validStatus = '1' and m.validStatus = '1'"
            + "AND ug.userCode = :userCode and m.systemCode = :systemCode")
    List<UtiMenu> findMenuByUserCode(@Param("userCode") String userCode, @Param("systemCode") String systemCode);

	/**
	 * 根据系统代码、菜单层级查询菜单信息
	 * @author: ldd
	 * @date: 2017/11/16 9:34
	 * @param systemCode 系统代码
	 * @param menuLevel 菜单层级
	 * @return UtiMenuDto集合
	 */
	@Query("SELECT p from UtiMenu p WHERE p.validStatus = '1' AND p.systemCode = :systemCode AND p.menuLevel = :menuLevel ")
	List<UtiMenu> findUpperMenuByMenuLevel(@Param("systemCode")String systemCode,@Param("menuLevel") Integer menuLevel) throws Exception;

	/**
	 *  查询下级菜单
	 * @author: ldd
	 * @date: 2017/11/16 9:34
	 * @param systemCode 系统代码
	 * @param upperMenuId 上级菜单代码
	 * @return 下级菜单UtiMenuDto集合
	 */
	@Query("SELECT p from UtiMenu p WHERE p.validStatus = '1' AND p.systemCode = :systemCode AND p.upperMenuId = :upperMenuId ORDER BY p.displayNo")
	List<UtiMenu> findUtiMenuByUpperMenuId(@Param("systemCode")String systemCode, @Param("upperMenuId")String upperMenuId) throws Exception;

	/**
	 *  根据systemCode查询菜单
	 * @author: ldd
	 * @date: 2017/11/16 11:14
	 * @param systemCode 系统代码
	 * @return UtiMenuDto集合
	 */
	@Query("SELECT p from UtiMenu p WHERE p.validStatus = '1' AND p.systemCode = :systemCode ORDER BY p.displayNo")
	List<UtiMenu> findAllBySystemCode(@Param("systemCode")String systemCode) throws Exception;


	@Query("select distinct c from UtiMenu c, UtiGradeTask a where a.taskCode = c.taskCode and "
			+ "c.taskCode like 'newagriclaim.taskmanage.%' and c.menuLevel = '2' and a.gradeCode in "
			+ "(select b.gradeCode from UtiUserGrade b where b.userCode = :userCode)")
    List<UtiMenu> getMenusByUserCode(@Param("userCode") String userCode);

    /**
     * 根据url与taskCode查询UtiMenu集合
     * @author: 田健
     * @date: 2018/2/22 17:24
     * @param url 地址
     * @param taskCode 菜单代码
     * @return UtiMenu集合
     * @throws Exception
     */
    @Query("SELECT p from UtiMenu p WHERE p.url = :url and p.taskCode = :taskCode")
    List<UtiMenu> findAllByTaskCodeAnduAndUrl(@Param("url")String url,@Param("taskCode")String taskCode)throws Exception;
}