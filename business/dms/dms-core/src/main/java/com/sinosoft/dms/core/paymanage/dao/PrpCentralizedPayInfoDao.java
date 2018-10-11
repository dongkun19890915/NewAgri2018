package com.sinosoft.dms.core.paymanage.dao;

import com.sinosoft.dms.core.paymanage.entity.PrpCentralizedPayInfo;
import com.sinosoft.dms.core.paymanage.entity.PrpCentralizedPayInfoKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-21 08:39:47.289 
 * PrpCentralizedPayInfoDao数据操作对象
 */
@Repository
public interface PrpCentralizedPayInfoDao extends JpaBaseDao<PrpCentralizedPayInfo,PrpCentralizedPayInfoKey> {

	/**
     *  根据comCode、userCode查询UtiUserGrade集合
     * @author: ldd
     * @date: 2017/11/16 14:55
     * @param comCode 机构代码
     * @param userCode 用户代码
     * @return UtiUserGrade集合
     * @throws Exception
     */
    @Query("Select p From PrpCentralizedPayInfo p Where p.operateId = :operateId")
    public PrpCentralizedPayInfo findInfo(@Param("operateId") String operateId)throws Exception;

}