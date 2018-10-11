package com.sinosoft.ims.core.kernel.service;

import java.util.List;

import com.sinosoft.ims.api.kernel.dto.CompanyConditionDto;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;

/**
 * @description 机构服务接口
 * @author HSQ
 * @date 2017年8月30日 上午10:40:41
 */
public interface CompanyService {

	/**
	 * @description 新增机构 （机构从其他库导入，暂时不用）
	 * @param prpDcompanyDto
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月30日 上午9:47:01
	 */
    String saveCompany(PrpDcompanyDto prpDcompanyDto) throws Exception;

	/**
	 * @description 删除机构
	 * @param comCode
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月30日 上午9:54:37
	 */
    String removeCompany(String comCode) throws Exception;

	/**
	 * @description 修改机构
	 * @param prpDcompanyDto
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月30日 上午9:54:51
	 */
    String modifyCompany(PrpDcompanyDto prpDcompanyDto) throws Exception;

	/**
	 * @description 根据机构代码获取机构
	 * @param comCode
	 * @return
	 * @author HSQ
	 * @date 2017年8月30日 上午9:55:14
	 */
    PrpDcompanyDto queryCompanyByComCode(String comCode);

	/**
	 * @description 获取直接上级机构
	 * @param comCode
	 * @return
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月30日 上午9:57:11
	 */
    PrpDcompanyDto getUpperCompany(String comCode) throws Exception;

	/**
	 * @description 获取所有上级机构
	 * @param comCode
	 * @return
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月30日 上午9:57:11
	 */
    List<PrpDcompanyDto> getAllUpperCompany(String comCode) throws Exception;

	/**
	 * @description 获取直接下级机构
	 * @param comCode
	 * @return
	 * @author HSQ
	 * @date 2017年8月30日 上午9:57:11
	 */
    List<PrpDcompanyDto> getLowerCompany(String comCode);

	/**
	 * @description 获取所有下级机构
	 * @param comCode
	 * @return
	 * @author HSQ
	 * @date 2017年8月30日 上午9:57:11
	 */
    List<PrpDcompanyDto> getAllLowerCompany(String comCode);

	/**
	 * @description 机构转译
	 * @param comCode
	 * @param isChinese
	 * @return
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月30日 上午9:58:47
	 */
    String translateCode(String comCode, boolean isChinese) throws Exception;

	/**
	 * @description 根据条件查询机构
	 * @param companyConditionDto
	 * @return
	 * @throws Exception
	 * @author HSQ
	 * @date 2017年8月30日 下午2:48:14
	 */
    List<PrpDcompanyDto> findCompanyByCondition(CompanyConditionDto companyConditionDto) throws Exception;

	/**
     * 是否是总公司
     * @param comCode 机构代码
     * @return 是则返回true，否则返回false
     * @throws
     */
    boolean isTopCompany(String comCode);

    /**
     * 是否是同级机构(含本身)
     * @param comCode 机构代码
     * @param sameComCode 被比较的机构代码
     * @return 是则返回true，否则返回false
     * @throws
     */
    boolean isSameLevelCompany(String comCode, String comparComCode);

    /**
     * 是否是下级机构(含本身)
     * @param comCode 机构代码
     * @param upperComCode 上级机构代码
     * @return 是则返回true，否则返回false
     * @throws
     */
    boolean isSubCompany(String comCode, String upperComCode);
	/**
	 * @description 根据comcode查询机构
	 * @param companyConditionDto
	 * @return prpDcompanyDto
	 * @throws Exception
	 * @author hrx
	 * @date 2017年9月13日
	 */
    List<PrpDcompanyDto> queryCompanyByCondition(CompanyConditionDto companyConditionDto) throws Exception;

	/**
	 * @description 根据comcode、机构级别查询机构
	 * @param comCode
	 * @param comLevel
	 * @return prpDcompanyDto
	 * @throws Exception
	 * @author hrx
	 * @date 2017年9月25日
	 */
    PrpDcompanyDto getCompanyByCondition(String comCode, String comLevel) throws Exception;

	 /**
   	 * @description 工作流初始化批量分配模板信息所用，查询所有的有效的出单机构，幷按comcode排序
   	 * @param 
   	 * @return
     * @author yanghang
   	 * @throws Exception
   	 * @date 2017年10月25日
     */
	public List<PrpDcompanyDto> querySwfAllCompany();
}
