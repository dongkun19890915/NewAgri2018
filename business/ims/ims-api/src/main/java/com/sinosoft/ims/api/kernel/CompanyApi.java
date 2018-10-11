package com.sinosoft.ims.api.kernel;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinosoft.ims.IMSConstant;
import com.sinosoft.ims.api.kernel.dto.CompanyConditionDto;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;

/**
 * @description 机构服务api
 * @author HSQ
 * @date 2017年8月30日 上午10:40:56
 */
@FeignClient(name = IMSConstant.IMS_SERVICE_NAME, path = CompanyApi.PATH)
public interface CompanyApi {

	public static final String PATH = "company";

	/**
	 * @description 新增机构
	 * @param prpDcompanyDto
	 * @author HSQ
	 * @throws Exception
	 * @date 2017年8月30日 上午9:47:01
	 */
	@RequestMapping(value = "saveCompany", method = { RequestMethod.POST })
	public String saveCompany(@RequestBody PrpDcompanyDto prpDcompanyDto) throws Exception;

	/**
	 * @description 删除机构
	 * @param comCode
	 * @author HSQ
	 * @throws Exception
	 * @date 2017年8月30日 上午9:54:37
	 */
	@RequestMapping(value = "removeCompany", method = { RequestMethod.POST })
	public String removeCompany(@RequestParam(value = "comCode") String comCode) throws Exception;

	/**
	 * @description 修改机构
	 * @param prpDcompanyDto
	 * @author HSQ
	 * @throws Exception
	 * @date 2017年8月30日 上午9:54:51
	 */
	@RequestMapping(value = "modifyCompany", method = { RequestMethod.POST })
	public String modifyCompany(@RequestBody PrpDcompanyDto prpDcompanyDto) throws Exception;

	/**
	 * @description 根据机构代码获取机构
	 * @param comCode
	 * @return
	 * @author HSQ
	 * @date 2017年8月30日 上午9:55:14
	 */
	@RequestMapping(value = "queryCompanyByComCode", method = { RequestMethod.POST })
	public @ResponseBody PrpDcompanyDto queryCompanyByComCode(@RequestParam(value = "comCode") String comCode);

	/**
	 * @description 获取直接上级机构
	 * @param comCode
	 * @return
	 * @author HSQ
	 * @throws Exception
	 * @date 2017年8月30日 上午9:57:11
	 */
	@RequestMapping(value = "getUpperCompany", method = { RequestMethod.POST })
	public @ResponseBody PrpDcompanyDto getUpperCompany(@RequestParam(value = "comCode") String comCode) throws Exception;

	/**
	 * @description 获取所有上级机构
	 * @param comCode
	 * @return
	 * @author HSQ
	 * @throws Exception
	 * @date 2017年8月30日 上午9:57:11
	 */
	@RequestMapping(value = "getAllUpperCompany", method = { RequestMethod.POST })
	public @ResponseBody List<PrpDcompanyDto> getAllUpperCompany(@RequestParam(value = "comCode") String comCode) throws Exception;

	/**
	 * @description 获取直接下级机构
	 * @param comCode
	 * @return
	 * @author HSQ
	 * @date 2017年8月30日 上午9:57:11
	 */
	@RequestMapping(value = "getLowerCompany", method = { RequestMethod.POST })
	public @ResponseBody List<PrpDcompanyDto> getLowerCompany(@RequestParam(value = "comCode") String comCode);

	/**
	 * @description 获取所有下级机构
	 * @param comCode
	 * @return
	 * @author HSQ
	 * @date 2017年8月30日 上午9:57:11
	 */
	@RequestMapping(value = "getAllLowerCompany", method = { RequestMethod.POST })
	public @ResponseBody List<PrpDcompanyDto> getAllLowerCompany(@RequestParam(value = "comCode") String comCode);

	/**
	 * @description 机构转译
	 * @param comCode
	 * @param isChinese
	 * @return
	 * @author HSQ
	 * @throws Exception
	 * @date 2017年8月30日 上午9:58:47
	 */
	@RequestMapping(value = "translateCode", method = { RequestMethod.POST })
	public String translateCode(@RequestParam(value = "comCode") String comCode, @RequestParam(value = "isChinese") boolean isChinese) throws Exception;

	/**
	 * @description 根据条件查询机构
	 * @param companyConditionDto
	 * @return
	 * @throws Exception
	 * @author HSQ
	 * @date 2017年8月30日 下午2:47:09
	 */
	@RequestMapping(value = "findCompanyByCondition", method = { RequestMethod.POST })
	public @ResponseBody List<PrpDcompanyDto> findCompanyByCondition(@RequestBody CompanyConditionDto companyConditionDto) throws Exception;

	/**
	 * @description 根据comcode查询机构
	 * @param companyConditionDto
	 * @return prpDcompanyDto
	 * @throws Exception
	 * @author hrx
	 * @date 2017年9月13日
	 */
	@RequestMapping(value = "queryCompanyByCondition", method = { RequestMethod.POST })
	public @ResponseBody List<PrpDcompanyDto> queryCompanyByCondition(@RequestBody CompanyConditionDto companyConditionDto) throws Exception;

	/**
	 * @description 根据comcode、机构级别查询机构
	 * @param comCode
	 * @param comLevel
	 * @return prpDcompanyDto
	 * @throws Exception
	 * @author hrx
	 * @date 2017年9月25日
	 */
	@RequestMapping(value = "getCompanyByCondition", method = { RequestMethod.POST })
	public @ResponseBody PrpDcompanyDto getCompanyByCondition(@RequestParam(value = "comCode") String comCode,
                                                              @RequestParam(value = "comLevel") String comLevel) throws Exception;
    
	/**
	  * @description 工作流初始化批量分配模板信息所用，查询所有的有效的出单机构，幷按comcode排序
	  * @author 杨航
	  * @date 2017年11月9日 下午6:35:51
	  * @param prpDcompanyDtoList 
	  * @return
	 */
	@RequestMapping(value = "querySwfAllCompany", method = { RequestMethod.POST })
	public @ResponseBody List<PrpDcompanyDto> querySwfAllCompany();

}
