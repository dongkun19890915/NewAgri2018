package com.sinosoft.ims.web.kernel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sinosoft.ims.api.kernel.CompanyApi;
import com.sinosoft.ims.api.kernel.dto.CompanyConditionDto;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.ims.core.kernel.service.CompanyService;

/**
 * @description 机构服务controller 
 * @author HSQ
 * @date 2017年8月30日 下午2:39:34
 */
@RestController
@RequestMapping(value = CompanyApi.PATH)
public class CompanyController implements CompanyApi {
	
	@Autowired
	private CompanyService companyService;

	/**
	 * @description 新增机构 
	 * @param prpDcompanyDto
	 * @return
	 * @throws Exception
	 * @author HSQ
	 * @date 2017年8月30日 下午2:45:42
	 */
	@Override
	public String saveCompany(@RequestBody PrpDcompanyDto prpDcompanyDto) throws Exception {
		return companyService.saveCompany(prpDcompanyDto);
	}

	/**
	 * @description 删除机构 
	 * @param comCode
	 * @return
	 * @throws Exception
	 * @author HSQ
	 * @date 2017年8月30日 下午2:45:48
	 */
	@Override
	public String removeCompany(String comCode) throws Exception {
		return companyService.removeCompany(comCode);
	}

	/**
	 * @description 修改机构 
	 * @param prpDcompanyDto
	 * @return
	 * @throws Exception
	 * @author HSQ
	 * @date 2017年8月30日 下午2:46:01
	 */
	@Override
	public String modifyCompany(@RequestBody PrpDcompanyDto prpDcompanyDto) throws Exception {
		return companyService.modifyCompany(prpDcompanyDto);
	}

	/**
	 * @description  根据机构代码获取机构
	 * @param comCode
	 * @return
	 * @author HSQ
	 * @date 2017年8月30日 下午2:46:15
	 */
	@Override
	public @ResponseBody PrpDcompanyDto queryCompanyByComCode(String comCode) {
		return companyService.queryCompanyByComCode(comCode);
	}

	/**
	 * @description 获取直接上级机构 
	 * @param comCode
	 * @return
	 * @throws Exception
	 * @author HSQ
	 * @date 2017年8月30日 下午2:46:26
	 */
	@Override
	public @ResponseBody PrpDcompanyDto getUpperCompany(String comCode) throws Exception {
		return companyService.getUpperCompany(comCode);
	}

	/**
	 * @description 获取所有上级机构 
	 * @param comCode
	 * @return
	 * @throws Exception
	 * @author HSQ
	 * @date 2017年8月30日 下午2:46:30
	 */
	@Override
	public @ResponseBody List<PrpDcompanyDto> getAllUpperCompany(@RequestParam String comCode) throws Exception {
		return companyService.getAllUpperCompany(comCode);
	}

	/**
	 * @description 获取直接下级机构 
	 * @param comCode
	 * @return
	 * @author HSQ
	 * @date 2017年8月30日 下午2:46:34
	 */
	@Override
	public @ResponseBody List<PrpDcompanyDto> getLowerCompany(String comCode) {
		return companyService.getLowerCompany(comCode);
	}

	/**
	 * @description 获取所有下级机构 
	 * @param comCode
	 * @return
	 * @author HSQ
	 * @date 2017年8月30日 下午2:46:39
	 */
	@Override
	public @ResponseBody List<PrpDcompanyDto> getAllLowerCompany(String comCode) {
		return companyService.getAllLowerCompany(comCode);
	}

	/**
	 * @description 机构转译
	 * @param comCode
	 * @param isChinese
	 * @return
	 * @throws Exception
	 * @author HSQ
	 * @date 2017年8月30日 下午2:46:42
	 */
	@Override
	public String translateCode(String comCode, boolean isChinese) throws Exception {
		return companyService.translateCode(comCode, isChinese);
	}

	/**
	 * @description 根据条件查询机构
	 * @param companyConditionDto
	 * @return
	 * @throws Exception
	 * @author HSQ
	 * @date 2017年8月30日 下午2:46:47
	 */
	@Override
	public @ResponseBody List<PrpDcompanyDto> findCompanyByCondition(@RequestBody CompanyConditionDto companyConditionDto) throws Exception {
		return companyService.findCompanyByCondition(companyConditionDto);
	}

	/**
	 * @description 根据comcode查询机构
	 * @param companyConditionDto
	 * @return prpDcompanyDto
	 * @throws Exception
	 * @author hrx
	 * @date 2017年9月13日
	 */
	@Override
	public @ResponseBody List<PrpDcompanyDto> queryCompanyByCondition(@RequestBody CompanyConditionDto companyConditionDto) throws Exception {
		return companyService.queryCompanyByCondition(companyConditionDto);
	}

	/**
	 * @description 根据comcode、机构级别查询机构
	 * @param comCode
	 * @param comLevel
	 * @return prpDcompanyDto
	 * @throws Exception
	 * @author hrx
	 * @date 2017年9月25日
	 */
	@Override
	public @ResponseBody PrpDcompanyDto getCompanyByCondition(@RequestParam(value = "comCode") String comCode,
																	  @RequestParam(value = "comLevel") String comLevel) throws Exception {
		return companyService.getCompanyByCondition(comCode, comLevel);
	}
   
	/**
	  * @description 工作流初始化批量分配模板信息所用，查询所有的有效的出单机构，幷按comcode排序
	  * @author 杨航
	  * @date 2017年11月9日 下午6:35:51
	  * @param prpDcompanyDtoList 
	  * @return
	 */
	@Override
	public List<PrpDcompanyDto> querySwfAllCompany() {
		return companyService.querySwfAllCompany();
	}
}
