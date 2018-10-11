package com.sinosoft.agriclaim.core.businessutilmanage.dao;

import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLMessage;
import com.sinosoft.agriclaim.core.businessutilmanage.entity.PrpLMessageKey;
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
 * @time  2017-11-08 05:35:28.283 
 * 理赔流转讨论留言表Dao数据操作对象
 */
@Repository
public interface PrpLMessageDao extends JpaBaseDao<PrpLMessage,PrpLMessageKey> {
    /**
     * （根据报案号查询实体List，并根据序号降序排列）
     * @author: 董坤
     * @date: 2017/11/15 20:33
     * @param registNo 报案号
     * @return  实体List
     */
    @Query(value="select p from PrpLMessage p where p.registNo=?1 ")
    public List<PrpLMessage> findByRegistNo(String registNo);

    /**
     * （根据报案号查询对应数据的最大序号）
     * @author: 董坤
     * @date: 2017/11/17 17:52
     * @param registNo 报案号
     * @return 该报案号对应的最大序号
     */
    @Query(value="select nvl(max(p.serialNo),0) from PrpLMessage p where p.registNo=?1 ")//todo 待测试
    public Integer findMaxSerialNoByRegistNo(String registNo);

    @Query(value="select p from PrpLMessage p where p.registNo=:registNo order by p.inputDate desc")
    public List<PrpLMessage> findPrpLMessageByRegistNo(@Param("registNo") String registNo);
}