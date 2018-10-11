package com.sinosoft.agriclaim.core.docmanage.dao;

import com.sinosoft.agriclaim.core.docmanage.entity.PrplCertifyDirect;
import com.sinosoft.agriclaim.core.docmanage.entity.PrplCertifyDirectKey;
import com.sinosoft.framework.core.dao.JpaBaseDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-10 02:44:49.773 
 * 索赔指引表Dao数据操作对象
 */
@Repository
public interface PrplCertifyDirectDao extends JpaBaseDao<PrplCertifyDirect,PrplCertifyDirectKey> {
	/**
	 * @description:方法功能简述: 自定义的单证类型和非自定义的单证类型排序字段不同,非自定义的单证类型按typecode排序
	 * @author 安齐崇
	 * @date 2017年11月11日下午3:20:16
	 * @param registNo 报案号
	 */
	@Query(value="select * from PrplCertifyDirect where registNo=?1 and substr(typeCode,1,2)!='99' order by typecode",nativeQuery=true)
    List<PrplCertifyDirect> findNoneDefine(String registNo);
	/**
	 * @description:方法功能简述: 自定义的单证类型和非自定义的单证类型排序字段不同,自定义的单证类型按serialno排序
	 * @author 安齐崇
	 * @date 2017年11月11日下午3:20:16
	 * @param registNo 报案号
	 */
	@Query(value="select * from PrplCertifyDirect where registNo=?1 and substr(typeCode,1,2)='99' order by serialno",nativeQuery=true)
    List<PrplCertifyDirect> findDefine(String registNo);
	/**
	 * @description:方法功能简述：通过报案号删除 
	 * @author 安齐崇
	 * @date 2017年12月23日下午5:37:09
	 * @param businessNo
	 */
	@Transactional(value= TxType.REQUIRED)
	@Modifying
	@Query(value="delete from PrplCertifyDirect where registNo =:registNo",nativeQuery=true)
	void deleteByRegistNo(@Param("registNo") String registNo);
}