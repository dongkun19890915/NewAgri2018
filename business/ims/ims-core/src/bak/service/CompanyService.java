package com.sinosoft.ims.core.kernel.service;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.ims.api.kernel.dto.CompanyConditionDto;
import com.sinosoft.ims.api.kernel.dto.PrpDCompanyDto;
import com.sinosoft.ims.api.kernel.dto.PrpDCompanyReturnDto;

import java.util.List;


public interface CompanyService {

	/**
	 * @description 机构查询列表服务
	 * @param companyConditionDto
	 * @return PageInfo
	 * @
	 * @author hzhongkai
	 * @date 2016年9月28日下午4:46:06
	 */
	public PageInfo<PrpDCompanyDto> queryCompanyPage(CompanyConditionDto companyConditionDto);

	/**
	 * @description 根据comcode查询机构
	 * @param companyConditionDto
	 * @return PageInfo
	 * @
	 * @author hzhongkai
	 * @date 2016年9月28日下午4:46:06
	 */
	public PrpDCompanyDto queryCompanyByComcode(CompanyConditionDto companyConditionDto);

	/**
	 * @description 新增机构服务
	 * @param prpdcompanySave
	 * @return ResponseDto
	 * @
	 * @author hzhongkai
	 * @date 2016年9月28日下午4:46:32
	 */
	public void saveCompany(PrpDCompanyDto prpdcompanySave);

	/**
	 * @description 机构管理修改服务
	 * @param prpdcompanyUpdate
	 * @return ResponseDto
	 * @
	 * @author hzhongkai
	 * @date 2016年9月28日下午4:46:53
	 */
	public void updateCompany(PrpDCompanyDto prpdcompanyUpdate);

	/**
	 * @description 省级下拉机构查询接口
	 * @param prpDcompanyDto
	 * @return
	 * @
	 * @author hzhongkai
	 * @date 2016年9月28日下午4:47:21
	 */
	public List<PrpDCompanyDto> qeuryPrpDCompanyList(PrpDCompanyDto prpDcompanyDto);

	/**
	 * @description 检查机构代码是否重复
	 * @param prpDcompanyDto
	 * @return
	 * @
	 * @author hzhongkai
	 * @date 2016年9月28日下午4:47:21
	 */
	public boolean checkComCode(PrpDCompanyDto prpDcompanyDto);

    /**
     * @description 查询机构列表，增加权限控制
     * @param queryDto
     * @return
     * @
     * @author hzhongkai
     * @date 2016年10月22日上午10:00:50
     */
    PageInfo<PrpDCompanyDto> queryPowerCompanyPage(CompanyConditionDto queryDto)  ;



}
