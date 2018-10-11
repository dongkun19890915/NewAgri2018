package com.sinosoft.pms.core.kernel.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.pms.core.kernel.entity.PrpDkindAgri;
import com.sinosoft.pms.core.kernel.entity.PrpDkindAgriKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * 责任定义表Dao数据操作对象
 */
@Repository
public interface PrpDkindAgriDao extends JpaBaseDao<PrpDkindAgri,PrpDkindAgriKey> {

    /**
     *  根据riskCode查询prpdkind表
     * @author: 何伟东
     * @date: 2017/10/31 16:28
     * @param riskCode
     * @return
     */
    List<PrpDkindAgri> findByRiskCode(String riskCode);

    /**
     *
     * @author: 刘曼曼
     * @date: 2017/11/13 18:34
     * @param list 险种代码集合
     * @return List<PrpDkind>集合
     */
    @Query(value = " select p from PrpDkindAgri p where p.riskCode=:riskCode and p.kindCode in (:list)")
    List<PrpDkindAgri> findByKindCodeAndRiskCode(@Param("list") List<String> list,@Param("riskCode") String riskCode);

    /**
     * 根据险别代码查询险别表
     * @author: 刘曼曼
     * @date: 2017/12/19 10:44
     * @param kindCode 险别代码
     * @return
     */
    List<PrpDkindAgri> findByKindCode(String kindCode);
}