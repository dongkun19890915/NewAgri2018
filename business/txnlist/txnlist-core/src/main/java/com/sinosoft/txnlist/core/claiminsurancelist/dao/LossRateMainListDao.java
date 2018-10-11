package com.sinosoft.txnlist.core.claiminsurancelist.dao;

import com.sinosoft.txnlist.api.claiminsurancelist.dto.LossRateMainListDto;
import com.sinosoft.txnlist.core.claiminsurancelist.entity.LossRateMainList;
import com.sinosoft.txnlist.core.claiminsurancelist.entity.LossRateMainListKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-17 06:38:35.329 
 * 定损清单主表Dao数据操作对象
 */
@Repository
public interface LossRateMainListDao extends JpaBaseDao<LossRateMainList,LossRateMainListKey> {

    /**
     *@description 按清单号查询最大序列号
     *@param lossListCode 清单号
     *@return serialNo 最大序列号
     *@author 王心洋
     *@time 2018-01-18
     */
    @Transactional
    @Query(value = "select max( l.serialNo) from LossRateMainList  l where  l.lossListCode=:lossListCode")
    Integer queryMaxSerialByLossListCode(@Param(value="lossListCode") String lossListCode);

    /**
     * 关联报案号和清单信息
     * @param lossListCode 损失率清单号
     * @param bizNo 报案号
     * @author 王心洋
     *@time 2018-01-19
     */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update LossRateMainList l set l.bizNo=:bizNo,l.checkBoxFlag =:checkBoxFlag where l.lossListCode=:lossListCode and l.serialNo=:serialNo")
    public void compareInsurance(@Param(value = "lossListCode") String lossListCode, @Param(value = "bizNo") String bizNo,@Param("checkBoxFlag")String checkBoxFlag,@Param("serialNo")Integer serialNo);

    //将损失率清单号下所有checkBoxFlag 置为0
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update LossRateMainList l set l.checkBoxFlag ='0' where l.policyNo=:policyNo and l.bizNo =:registNo")
    public void updateLossListCheckBoxFlag(@Param(value = "policyNo") String policyNo,@Param("registNo") String registNo);

    /**
     * 按条件查询已关联实体集合
     * @param policyNo 保单号
     * @param bizNo 报案号
     * @return List<LossRateList>定损清单信息列表
     * @author 王心洋
     *@time 2018-01-19
     */
    @Transactional
    @Query(value = "select l from LossRateMainList l where l.policyNo=:policyNo and l.bizNo=:bizNo " +
            "and l.serialNo=(select max(m.serialNo) from LossRateMainList m where m.policyNo=:policyNo and m.bizNo=:bizNo)")
    public LossRateMainList queryComparable(@Param(value = "policyNo") String policyNo, @Param(value = "bizNo") String bizNo);

    /**
     *@description 根据保单号查询清单号
     *@param policyNo 清单号
     *@return serialNo 最大序列号
     *@author 王心洋
     *@time 2018-01-18
     */
    @Transactional
    @Query(value = "select l from LossRateMainList  l where  l.policyNo=:policyNo and l.origin='1'and nodeOrigin=:nodeOrigin and bizNo=:registNo")
    public List<LossRateMainList>  queryBypolicyNo(@Param(value="policyNo") String policyNo, @Param(value="nodeOrigin") String nodeOrigin,@Param(value="registNo") String registNo);

    @Transactional
    @Modifying
    @Query(value = "delete from LossRateMainList l where l.lossListCode in :lossListCode and l.nodeOrigin=:nodeOrigin ")
    void deleteByLossListCodeList(@Param("lossListCode") List<String> lossListCode, @Param(value="nodeOrigin") String nodeOrigin);

    @Transactional
    @Query(value = "select l from LossRateMainList l where l.bizNo= :registNo and l.origin='1'")
    List<LossRateMainList> queryByregistNo(@Param("registNo") String registNo);

    /**
     * 根据清单号和保单号回写报案号
     * @author: 孙朋飞
     * @date: 2018/4/23 9:34
     * @param lossListCode 清单号
     * @param policyNo 保单号
     * @param registNo 报案号
     */
    @Transactional
    @Modifying
    @Query(value="update LossRateMainList p set p.bizNo=:registNo where p.lossListCode=:lossListCode and p.policyNo=:policyNo")
    void updateLossRateMainListByLossListCode(@Param("lossListCode") String lossListCode,@Param("policyNo") String policyNo,@Param("registNo") String registNo);
}