package com.sinosoft.ims.core.kernel.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.ims.api.kernel.dto.CompanyListDto;
import com.sinosoft.ims.core.kernel.entity.PrpDcompany;
import com.sinosoft.ims.core.kernel.entity.PrpDcompanyKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-08-17 01:41:08.865
 * 机构代码表Dao数据操作对象
 */
@Repository
public interface PrpDcompanyDao extends JpaBaseDao<PrpDcompany,PrpDcompanyKey> {

    @Query(value = "select * from PrpDcompany where ComCode = :comCode or UpperComCode = :upperComCode and ComLevel = :comLevel " +
            "and ValidStatus = '1' order by ComCode"
            ,nativeQuery = true)
    List<PrpDcompany> queryCompanyByCondition(@Param(value = "comCode") String comCode,
                                              @Param(value = "upperComCode") String upperComCode, @Param(value = "comLevel") String comLevel);

    @Query(value = "select * from PrpDcompany start with comCode = :comCode CONNECT BY Prior comCode = upperComCode",nativeQuery = true)
    List<PrpDcompany> getAllLowerCompany(@Param(value = "comCode") String comCode);

    @Query(value = "select * from (Select * From PrpDcompany start with comcode = :comCode connect by prior uppercomcode = comcode " +
            "and prior comcode != comcode) where comlevel = :comLevel ",nativeQuery = true)
    PrpDcompany getCompanyByCondition(@Param(value = "comCode") String comCode, @Param(value = "comLevel") String comLevel);

    @Query(value = "select * from PrpDcompany where ValidStatus = '1' AND SUBSTR(ComType,1,1) ='1' order by ComCode", nativeQuery = true)
	List<PrpDcompany> querySwfAllCompany();

    @Query(value = "select  p from PrpDcompany  p where p.comCode=?1")
    public List<PrpDcompany> queryByComCode(String comCode);

    @Query(value = "select count(u) FROM PrpDcompany u WHERE u.upperComCode = ?1 And u.validStatus = '1'")
    public int queryIfHasDownCompany(String comCode);
    //原生sql
    @Query(value="SELECT p.ComCode FROM PrpDcompany p  WHERE companyFlag='1'  Connect By p.upperComCode = Prior p.comCode Start With p.comCode=:comCode",nativeQuery = true)
    List<String> findPrpDcompanyByComCode(@Param("comCode") String comCode);

    @Query(value="select p.upperComCode from PrpDcompany p where p.comCode=:comCode")
    public String findPrpDcompanyByUpperComCode(@Param(value="comCode") String comCode);


    @Query(value = "select new com.sinosoft.ims.api.kernel.dto.CompanyListDto( p.comCode,p.comCName,p.upperComCode ) from PrpDcompany  p where p.validStatus='1' ")
    List<CompanyListDto> queryCompayTree();

    /**
     * 根据机构代码查询该机构的所有子级机构
     *
     * @param comCode 机构代码
     * @return 该机构的所有有效子机构信息
     * @author: 何伟东
     * @date: 2018/1/6 15:04
     */
    @Query(value = "select p from PrpDcompany p where p.upperComCode=:comCode and p.validStatus = '1' ")
    List<PrpDcompany> querySubComInfo(@Param(value = "comCode") String comCode);
    /**
     * 查询核算单位下的政策性农险机构的下的有效机构，Flag =’1’时校验的是归属机构不可选择中支公司
     Flag =’2’时，校验的是归属机构为政策性农险部时，政策/商业标志应选择“中央政策性
     * @param comCode 归属机构
     * @return  List<PrpDcompany> 返回机构集合
     * @author: 田健
     * @date: 2018/1/6 15:04
     */
    @Query(value = "select j from PrpDcompany j where j.cancelFlag='1' and j.flag=:flag and j.validStatus='1' and j.comCode=:comCode")
    List<PrpDcompany> CheckBusinessComCodeInfo (@Param("comCode") String comCode,@Param("flag") String flag);
    

    @Query(value = "SELECT p FROM PrpDcompany p WHERE  (p.comCode not like '0000%' or p.comCode like '00000013%' " +
            "or p.comCode like '00000018%' or p.comCode like '000018%') " +
            "and (p.upperComCode=:upperComCode ) " +//or p.comCode=:upperComCode
            "order by comLevel,comCode  ")
    List<PrpDcompany> findCheckAndLossUnit(@Param("upperComCode") String upperComCode);
    @Query("SELECT p FROM PrpDcompany p WHERE  (p.comCode not like '0000%' or p.comCode like '00000013%') " +
            "and (p.upperComCode=:upperComCode or p.comCode=:upperComCode) order by comCode")
    List<PrpDcompany> findScheduleUnit(@Param("upperComCode") String upperComCode);
    /**
     *
     * @description 根据机构代码查询模糊查询和机构级别查询
     * @author 周柯宇
     * @date 2018年1月18日 下午3:27:03
     * @param
     * @return List<PrpDcompany>
     * @Throws Exception
     */
    List<PrpDcompany> findByComCodeStartingWithAndComLevel(String substring, String comLevel);


    /**
     * 根据机构名称查询机构代码
     * @author 刘曼曼
     * @date 2018年3月1日 下午15:46:03
     * @param comCName 机构名称
     * @return List<PrpDcompany>
     */
    List<PrpDcompany> findAllByComCName(String comCName);


//    @Query("select new com.sinosoft.ims.core.kernel.entity.PrpDcompany(p.comCode,p.upperComCode) from PrpDcompany p where  p.upperComCode=:comCode ORDER BY p.comCode")
//    List<PrpDcompany> selectByUpperComCode(@Param("comCode") String comCode);

//    @Query("select new com.sinosoft.ims.core.kernel.entity.PrpDcompany(p.comCode,p.upperComCode) from PrpDcompany p  ORDER BY p.comCode")
//    List<PrpDcompany> selectAllUpperComCode();


    /**
     * 递归查询comcode机构树
     * @param comCode
     * @return
     */
    @Query(value = "select comCode from PrpDcompany start with comCode = :comCode CONNECT BY Prior comCode = upperComCode",nativeQuery = true)
    List selectAllUpperComCode(@Param(value = "comCode") String comCode);

}