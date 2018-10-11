package com.sinosoft.agriclaim.core.claimmanage.dao;

import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLLText;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLLTextKey;
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
 * @time  2017-11-08 05:39:53.061 
 * 立案文字表Dao数据操作对象
 */
@Repository
public interface PrpLLTextDao extends JpaBaseDao<PrpLLText,PrpLLTextKey> {
	@Modifying
	@Transactional
	@Query(value = "delete from PrpLLText p where p.claimNo = :claimNo ")
	public void deleteByClaimNo(@Param(value = "claimNo") String claimNo);
	List<PrpLLText> findByClaimNo(String claimNo);
	/**
     * （通过claimNo和textType 查找 按lineNo从小到大返回List）
     * @author: 王志文
     * @date: 2017/11/30 18:41
     * @param claimNo 立案号
     * @param textType 文字说明类型
     * @return
     */
    @Query("select p from PrpLLText p where p.claimNo =:claimNo and p.textType =:textType order by p.lineNo asc ")
    List<PrpLLText> queryPrpLLTextsByClaimNoAndTextType(@Param("claimNo") String claimNo,@Param("textType")String textType);
    /**
     * （根据立案号+文字说明类型查询实体）
     * @author: 董坤
     * @date: 2017/11/14 17:02
     * @param claimNo 立案号
     * @param textType 文字说明类型
     * @return PrpLLText实体list
     */
    @Query(value="select p from PrpLLText p where p.claimNo = :claimNo and p.textType = :textType ")
    public List<PrpLLText> queryByClaimNoAndTextType(@Param("claimNo") String claimNo,@Param("textType") String textType);

    /**
     * （根据立案号+文字说明类型删除实体）
     * @author: 董坤
     * @date: 2017/11/14 17:09
     * @param claimNo 立案号
     * @param textType 文字说明类型
     */
    @Modifying
    @Query(value="delete from PrpLLText p where p.claimNo = :claimNo and (p.textType = :textType or p.textType ='7')")
    public void deleteByClaimNoAndTextType(@Param("claimNo") String claimNo,@Param("textType") String textType);
    /**
     * （根据立案号+文字说明类型查询实体）
     * @author: 马俊玲
     * @date: 2017/11/14 17:09
     * @param claimNo 立案号
     * @param textType 文字说明类型
     */
    @Query ("select s from PrpLLText s where s.claimNo=:claimNo and s.textType=:textType")
    public List<PrpLLText> findByClaimNoAndTextType(@Param (value="claimNo") String claimNo,@Param (value="textType") String textType);


}