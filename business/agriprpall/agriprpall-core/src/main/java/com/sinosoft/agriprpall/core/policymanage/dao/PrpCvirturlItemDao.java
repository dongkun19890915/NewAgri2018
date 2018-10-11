package com.sinosoft.agriprpall.core.policymanage.dao;

import com.sinosoft.agriprpall.core.policymanage.entity.PrpCvirturlItem;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCvirturlItemKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-30 01:22:46.932 
 * 分户/虚拟分户信息Dao数据操作对象
 */
@Repository
public interface PrpCvirturlItemDao extends JpaBaseDao<PrpCvirturlItem,PrpCvirturlItemKey> {
    /**
     * @description: 更新PrpCvirturlItem表保单号
     * @author: 宋振振
     * @date: 2017/10/31 15:31
     * @param policyNo
     * @param proposalNo
     * @throws Exception
     */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update PrpCvirturlItem p set p.policyNo =?1 where p.proposalNo =?2")
    public void updateVirtualItem(String policyNo, String proposalNo) throws Exception;
    /**
     * 根据PolicyNo保单号和FamilyNo分户序号查询PrpCvirturlItemDto虚拟信息集合
     * @author: 宋振振
     * @date: 2017/12/15 14:30
     * @param policyNo 保单号
     * @param familyNo 分户序号
     * @return List<PrpCvirturlItem> 虚拟信息集合
     * @throws Exception
     */
    @Query(value = "select p from PrpCvirturlItem p where p.policyNo=?1 And p.familyNo=?2")
    public List<PrpCvirturlItem> queryPrpCvirturlItemDtoByPolicyNoAndFamilyNo(String policyNo, int familyNo)throws Exception;

    @Query(value = "select p from PrpCvirturlItem p where p.policyNo=?1 ")
    public List<PrpCvirturlItem> queryAllByPolicyNo(String policyNo);


//    public List<PrpCvirturlItem> queryAllByCondition(@Param(value = "policyNo") String policyNo);
}