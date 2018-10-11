package com.sinosoft.pms.core.kernel.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.pms.api.kernel.dto.PrpDclauseDto;
import com.sinosoft.pms.api.kernel.dto.ResponsePrpDclauseDto;
import com.sinosoft.pms.core.kernel.entity.PrpDclause;
import com.sinosoft.pms.core.kernel.entity.PrpDclauseKey;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-22 06:20:36.415 
 * 条款代码表Dao数据操作对象
 */
@Repository
public interface PrpDclauseDao extends JpaBaseDao<PrpDclause,PrpDclauseKey> {
    /**
     * 根据条款代码查询条款代码表
     * @author: 宋振振
     * @date: 2017/12/12 18:05
     * @param clauseCode
     * @return List<PrpDclause>
     * @throws Exception
     */
    @Query(value = "select p from PrpDclause p where p.clauseCode=?1")
    public List<PrpDclause> findPrpDclauseByClauseCode(String clauseCode)throws Exception;

    @Query(value="select p from PrpDclause p where substring(p.clauseCode,1,1)='T' and p.lineNo=1 and p.validStatus = '1'   and p.clauseCode in :clauseCode")
    List<PrpDclause> findPrpDclauseByRiskCode(@Param("clauseCode") List<String> clauseCode);
    /**
     *  根据clauseCode 条款代码查询PrpDclause条款信息表信息
     * @author: 田慧
     * @date: 2017/12/2 12:50
     * @param clauseCode 条款代码
     * @return PrpDclause条款信息表的集合
     */
    @Query(value = "select p from PrpDclause p where p.clauseCode=:insuranceCode AND p.newClauseCode=:clauseCode AND p.validStatus='1' and p.titleFlag='0' order by p.lineNo ")
    public List<PrpDclause> queryPrpdclauseInfoByCondition(@Param("clauseCode") String clauseCode,@Param("insuranceCode") String insuranceCode);

    /**
     * 根据条款代码查询prpDclause
     * @author: 刘曼曼
     * @date: 2017/12/19 18:39
     * @param clauseCodes 条款代码集合
     * @return
     */
    @Query(value = "select p from PrpDclause p where p.clauseCode in(:clauseCodes) AND p.validStatus='1' and p.titleFlag='0' order by p.lineNo ")
    public List<PrpDclause> queryPrpdclause(@Param("clauseCodes") List<String> clauseCodes);

    /**
     * 根据条款代码查询prpDclause
     * @author: 刘曼曼
     * @date: 2017/12/19 18:39
     * @param clauseCodes 条款代码集合
     * @return
     */
    @Query(value = "select new com.sinosoft.pms.api.kernel.dto.ResponsePrpDclauseDto(c.clauseCode,c.clauseName) from PrpDclause c where c.clauseCode like 'F%' AND c.lineNo=1 AND c.validStatus='1' AND c.clauseCode IN (:clauseCodes) ORDER BY c.clauseCode")
    public List<ResponsePrpDclauseDto> queryCluseCodeAndClauseName(@Param("clauseCodes") List<String> clauseCodes);

    /**
     * 根据条款代码查询险种内容
     * @author: 刘曼曼
     * @date: 2017/12/19 18:39
     * @param clauseCodes 条款代码集合
     * @return
     */
    @Query(value = "select c from PrpDclause c where c.clauseCode=:itemCode and c.newClauseCode=:clauseCode and c.validStatus='1'")
    public List<PrpDclause> queryKindContext(@Param("clauseCode") String clauseCode,@Param("itemCode") String itemCode);

    /**
     *  删除条款管理险别配置详情
     * @author: 宋振振
     * @date: 2018/3/27 19:15
     * @param clauseCode
     * @param itemCode
     */
    @Modifying
    @Transactional
    @Query(value = "delete from PrpDclause p where p.newClauseCode=:newClauseCode and p.clauseCode=:clauseCode")
    public void deletePrpDclause(@Param("newClauseCode") String clauseCode,@Param("clauseCode") String itemCode);
}