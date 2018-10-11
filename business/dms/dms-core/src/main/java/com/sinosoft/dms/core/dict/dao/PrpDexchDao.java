package com.sinosoft.dms.core.dict.dao;

import com.sinosoft.dms.api.dict.dto.PrpDexchDto;
import com.sinosoft.dms.core.dict.entity.PrpDexch;
import com.sinosoft.dms.core.dict.entity.PrpDexchKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:01:56.447 
 * 兑换率表Dao数据操作对象
 */
@Repository
public interface PrpDexchDao extends JpaBaseDao<PrpDexch,PrpDexchKey> {
    /**
     * 获取最大的兑换日期exchDate
     * @author: 宋振振
     * @date: 2017/12/09 11:04
     * @param iBaseCurrency
     * @param iExchCurrency
     * @param iExchDate
     * @return Date
     * @throws Exception
     */
    @Query(value = "SELECT MAX(p.exchDate) FROM PrpDexch p WHERE  p.baseCurrency =:baseCurrency AND p.exchCurrency =:exchCurrency AND p.exchDate <= TO_DATE(:exchDate,'yyyy-mm-dd')  AND p.exchRate IS NOT NULL")
    public Date findMaxExchDate(@Param("baseCurrency")String iBaseCurrency, @Param("exchCurrency")String iExchCurrency, @Param("exchDate")String iExchDate)throws Exception;

    /**
     * 获取最大的兑换日期exchDate
     * @author: 王志文
     * @date: 2017/12/09 11:04
     * @param iBaseCurrency
     * @param iExchCurrency
     * @param iExchDate
     * @return PrpDexch
     * @throws Exception
     */
    @Query(value = "SELECT p FROM PrpDexch p WHERE  p.baseCurrency =:baseCurrency AND p.exchCurrency =:exchCurrency AND p.exchDate <= TO_DATE(:exchDate,'yyyy-mm-dd')  AND p.exchRate IS NOT NULL")
    public List<PrpDexch> findMaxExchDateDto(@Param("baseCurrency")String iBaseCurrency, @Param("exchCurrency")String iExchCurrency, @Param("exchDate")String iExchDate)throws Exception;

}