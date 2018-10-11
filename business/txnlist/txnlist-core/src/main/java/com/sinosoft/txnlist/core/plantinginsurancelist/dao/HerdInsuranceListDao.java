package com.sinosoft.txnlist.core.plantinginsurancelist.dao;

import com.sinosoft.framework.core.dao.JpaBaseDao;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxInsuranceInfoDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.HerdInsuranceList;
import com.sinosoft.txnlist.core.plantinginsurancelist.entity.HerdInsuranceListKey;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-30 07:53:53.940
 * 养殖业投保明细Dao数据操作对象
 */
@Repository
public interface HerdInsuranceListDao extends JpaBaseDao<HerdInsuranceList, HerdInsuranceListKey> {

    /**
     * 根据清单号查询HerdInsuranceList信息集合
     * @author: 田健
     * @date: 2018/3/19 14:41
     * @param inusreListCode 清单编号
     * @return HerdInsuranceList信息集合
     */
    public List<HerdInsuranceList> findByInusreListCode(String inusreListCode);

    /*
    * @author:
    * @date: 2018/5/22 下午 18:13
    * */
    @Query(value = "select count(p.inusreListCode) from HerdInsuranceList p where p.inusreListCode=:inusreListCode")
    public Long countByInusreListCode(@Param("inusreListCode") String inusreListCode);


    /**
     * @description:（根据inreListcode删除清单数据）
     * @author: 田健
     * @date: 2017/10/20 11:52
     * @param inusreListCode
     */
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    @Query(value = "delete from HerdInsuranceList p where  p.inusreListCode=:inusreListCode")
    public void removeByInusreListCode(@Param("inusreListCode") String inusreListCode);

    /**
     * 根据清单号关联查询标的清单下的所有农户及费用信息----单险别单标的养殖险
     * @author: 田健
     * @date: 2018/3/2 17:06
     * @param insureListCode 清单号码
     * @param itemListCode 标的清单号
     * @return
     */
    @Query(value = "select new com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxInsuranceInfoDto( sum(a.insurePremium) as " +
            "fPremium,sum(a.centralPremium) as centralPremium,sum(a.provincePremium) " +
            "as provincePremium ,sum(a.cityPremium) as cityPremium,sum(a.townPremium) as townPremium,sum(a.otherPremium) " +
            "as otherPremium,sum(a.insureNumber) as insureArea,count(a.fCode) as iSumInsured) from HerdInsuranceList a where a.inusreListCode=:insureListCode and a.kindCode=:kindCode and a.itemCode=:itemCode and a.validity=1 and a.fCode in " +
            "(select b.fCode from GisFarmerItem b where b.insureListCode=:gisInsureListCode and b.serialNo=:serialNo and b.itemListCode=:itemListCode)")
    public NyxInsuranceInfoDto queryByConditioin(@Param("insureListCode") String insureListCode, @Param("itemListCode") String itemListCode, @Param("serialNo") Integer serialNo, @Param("gisInsureListCode") String gisInsureListCode, @Param("kindCode") String kindCode, @Param("itemCode") String itemCode);

    /**
     * @description:（根据inusreListcode汇总查询获取投保清单中总户数）
     * @author: 田健
     * @date: 2017/10/20 11:52
     * @param inusreListCode 清单号码
     * @return int 农户总数
     */
    @Query(value = "select count(distinct p.fCode) from HerdInsuranceList p where p.inusreListCode=:inusreListCode and p.validity='1' AND p.insureNumber>0")
    public int getSumInsured(@Param("inusreListCode") String inusreListCode);

    /**
     * 根据清单号集合查询信息
     *
     * @param inusreListCodes 清单号集合
     * @return
     * @author: 何伟东
     * @date: 2018-05-10 14:18
     */
    @Query(value = "select h from HerdInsuranceList h where h.inusreListCode in (:inusreListCodes) ")
    List<HerdInsuranceList> queryByInusreListCodes(@Param("inusreListCodes") List<String> inusreListCodes);

}