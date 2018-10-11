package com.sinosoft.ims.api.kernel;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.ims.IMSConstant;
import com.sinosoft.ims.api.kernel.dto.CompanyConditionDto;
import com.sinosoft.ims.api.kernel.dto.PrpDCompanyDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name= IMSConstant.IMS_SERVICE_NAME,path = CompanyApi.PATH)
public interface CompanyApi {

	public static final String PATH = "company";
	/**
	 * @description （查询机构）
	 * @param prpDCompanyDto
	 * @return
	 * @author maoyang
	 * @
	 * @date 2016年9月23日下午5:28:19
	 */

	@RequestMapping(value = "queryCompany", method = RequestMethod.POST)
	public ResponseDto queryCompany(@RequestBody CompanyConditionDto companyConditionDto);

	@RequestMapping(value = "queryCompanyPage", method = RequestMethod.POST)
	public PageInfo<PrpDCompanyDto> queryCompanyPage(@RequestBody CompanyConditionDto companyConditionDto);

	/**
	 * @description （查询下级机构）
	 * @param prpDCompanyDto
	 * @return
	 * @author maoyang
	 * @
	 * @date 2016年9月23日下午5:26:27
	 */
	@RequestMapping(value = "querylowercompany", method = RequestMethod.POST)
	public ResponseDto querylowercompany(@RequestBody CompanyConditionDto companyConditionDto);

	/**
	 * @description 保存机构
	 * @param prpDCompanydto
	 * @return
	 * @author maoyang
	 * @date 2016年9月23日下午5:27:29
	 */

	@RequestMapping(value = "saveCompany", method = RequestMethod.POST)
	public ResponseDto saveCompany(@RequestBody PrpDCompanyDto prpDCompanydto);
	/**
	 * @description 检查机构代码
	 * @param prpDCompanydto
	 * @return
	 * @author maoyang
	 * @date 2016年9月23日下午5:27:29
	 */

	@RequestMapping(value = "checkComCode", method = RequestMethod.POST)
	public ResponseDto checkComCode(@RequestBody PrpDCompanyDto prpDCompanydto);

	/**
	 * @description （更新机构）
	 * @param prpDCompanyUpdate
	 * @return
	 * @author maoyang
	 * @
	 * @date 2016年9月23日下午5:27:50
	 */
	@RequestMapping(value = "updateCompany", method = RequestMethod.POST)
	public ResponseDto updateCompany(@RequestBody  PrpDCompanyDto prpDCompanyUpdate);


	/**
	 * @description 查询机构证件类型
	 * @param newCodeQueryConditionDto
	 * @return List<PrpDNewCodeDto>
	 * @author hzhongkai
	 * @date 2016年9月29日下午8:12:50
	 */
	@RequestMapping(value = "queryCompanyIdType", method = RequestMethod.POST)
	public  ResponseDto queryCompanyIdType();

	/**
	 * @description 查询上级机构
	 * @return
	 * @author hzhongkai
	 * @
	 * @date 2016年9月29日下午8:55:37
	 */
	@RequestMapping(value = "queryUpperCompany", method = RequestMethod.POST)
	public ResponseDto queryUpperCompany(@RequestBody CompanyConditionDto companyConditionDto);
	/**
	 * @description 省级下拉机构查询
	 * @return
	 * @author hzhongkai
	 * @
	 * @date 2016年9月29日下午8:55:37
	 */
	@RequestMapping(value = "qeuryPrpDCompanyList", method = RequestMethod.POST)
	public ResponseDto qeuryPrpDCompanyList(@RequestBody PrpDCompanyDto prpDCompanyDto);

	/**
	 * @description 加载机构信息
	 * @return
	 * @author hzhongkai
	 * @
	 * @date 2016年9月29日下午8:55:37
	 */
	@RequestMapping(value = "queryCompanyByComcode", method = RequestMethod.POST)
	public ResponseDto queryCompanyByComcode(@RequestBody CompanyConditionDto companyConditionDto);
		
}
