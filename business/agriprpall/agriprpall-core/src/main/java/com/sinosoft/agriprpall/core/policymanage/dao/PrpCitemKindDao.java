package com.sinosoft.agriprpall.core.policymanage.dao;

import com.sinosoft.agriprpall.core.policymanage.entity.PrpCitemKind;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCitemKindKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-22 07:54:48.524
 * 保单标的子险信息表Dao数据操作对象
 */
@Repository
public interface PrpCitemKindDao extends JpaBaseDao<PrpCitemKind,PrpCitemKindKey> {

    /**
     * @description: 根据保单号查询险别信息
     * @author: 何伟东
     * @date: 2017/10/22 17:00
     * @return
     */
    public List<PrpCitemKind> findByPolicyNo(String policyNo);

    @Modifying
    @Transactional
    @Query("delete from PrpCitemKind p where p.policyNo=:policyNo")
    public void deleteByPolicyNo(@Param("policyNo") String policyNo);

    @Query(value = "select p from PrpCitemKind p " +
            "where p.policyNo= ?1 " +
            "and substring(p.flag,2,1) = 1 " +
            "order by p.itemKindNo")
    public List<PrpCitemKind> queryPrpCItemKindMainByCondition(String policyNo);

    @Query(value = "select p from PrpCitemKind p " +
            "where p.policyNo= ?1 " +
            "and substring(p.flag,2,1) = 2 " +
            "order by p.itemKindNo")
    public List<PrpCitemKind> queryPrpCItemKindSubByCondition(String policyNo);

    /**
     * 按照 policyNo 查询 PrpCitemKind 集合
     * @author 王心洋
     * @time 2017-11-09
     * @param policyNo 保单号
     * @return List<PrpCitemKind>
     */
    @Query(value="select a from PrpCitemKind a where a.policyNo=:policyNo")
    List<PrpCitemKind> findItemByPolicyNo(@Param("policyNo") String policyNo);

    /**
     *  当flag 为"0"时policyNo,model为查询条件,查询标的子险信息表信息
     * @author: 田慧
     * @date: 2017/11/22 17:32
     * @param policyNo 保单号
     * @param model 规格型号
     * @return PrpCitemKind的集合
     */
    @Query(value = "select p from PrpCitemKind p where p.policyNo like :policyNo AND p.model like :model")
    public List<PrpCitemKind> queryByModel(@Param("policyNo") String policyNo,@Param("model") String model);

//   public List<PrpCitemKind> findByPolicyNoContainingAndModelContaining( String policyNo,String model);
//   public List<PrpCitemKind> findByPolicyNoLikeAndModelLike( String policyNo,String model);



    /**
     *  flag="1"时policyNo,familyNo为查询条件,查询标的子险信息表信息
     * @author: 田慧
     * @date: 2017/11/22 17:36
     * @param policyNo 保单号
     * @param familyNo 规格型号
     * @return PrpCitemKind的集合
     */
    @Query(value = "select p from PrpCitemKind p where p.policyNo like :policyNo AND p.familyNo=:familyNo ")
    public List<PrpCitemKind> queryByamilyNo(@Param("policyNo") String policyNo,@Param("familyNo") Integer familyNo);

    /**
     * 根据保单号和familyNos查询满足条件的PrpCitemKind
     * @author: 王保良
     * @date: 2017/11/28 15:30
     * @param policyNo 保单号
     * @param familyNos 在itemkind表中是分户序号familyNo
     * @return List<PrpCitemKind> 标的信息集合
     * @throws Exception
     */
    @Query(value = "select p from PrpCitemKind p where p.policyNo=:policyNo and p.familyNo in :str")
    public List<PrpCitemKind> findAllByCondition(@Param("policyNo") String policyNo,@Param("str") String str);
    /**
     * 根据PolicyNo保单号和FamilyNo分户序号查询PrpCitemKindDto险别信息的集合
     * @author: 宋振振
     * @date: 2017/12/15 14:30
     * @param policyNo 保单号
     * @param familyNo 分户序号
     * @return List<PrpCitemKind> 险别信息的集合
     * @throws Exception
     */
    @Query(value = "select p from PrpCitemKind p where p.policyNo=?1 and p.familyNo=?2")
    public List<PrpCitemKind> queryPrpCitemKindByPolicyNoAndFamilyNo(String policyNo,int familyNo)throws Exception;
    /**
     * @description: （理赔打印查询itemCode）
     * @author: 王志文
     * @date: 2017/11/11 9:21
     * @param policyNo 保单号
     * @return List<PrpCitemKind> 险别信息集合
     */
    @Query(value = "select p from PrpCitemKind p where p.policyNo =:policyNo ")
    public List<PrpCitemKind> queryItemCodeByPolicyNo(@Param("policyNo") String policyNo);

    /**
     * （赔款金额计算通过保单号和险别查询损失率）
     * @author: 王志文
     * @date: 2018/1/8 10:49
     * @param policyNo 保单号
     * @param kindCode 险别代码
     * @return List<PrpCitemKind> 险别信息集合
     */
    @Query(value = "select p from PrpCitemKind p where p.policyNo =:policyNo and p.kindCode =:kindCode and p.itemCode=:itemCode")
    List<PrpCitemKind> queryAllByPolicyNoAndKindCode(@Param("policyNo")String policyNo,@Param("kindCode")String kindCode,@Param("itemCode")String itemCode);
    /**
     * 批量查询险别标的信息
     * @param policyNos 保单号集合
     * @return List<PrpCitemKindDto>
     * @date: 2018/4/12 11:42
     * @author: 何伟东
     */
    @Query(value = "select p from PrpCitemKind p where p.policyNo in (:policyNos)")
    List<PrpCitemKind> queryItemKindByPolicyNos(@Param("policyNos")List<String> policyNos);
    /**
     * 根据保单号、险别、标的查询信息
     * @author: 田健
     * @date: 2018/4/13 12:22
     * @param policyNo 保单号
     * @param kindCode 险别
     * @param itemCode 标的
     * @return PrpCitemKindDto信息集合
     */
    @Query(value = "select p from PrpCitemKind p where p.policyNo =:policyNo and p.kindCode =:kindCode and p.itemCode =:itemCode")
    List<PrpCitemKind> queryAllByPolicyNoAndKindCodeAndItemCode(@Param("policyNo")String policyNo,@Param("kindCode")String kindCode,@Param("itemCode")String itemCode);
}