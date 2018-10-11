package com.sinosoft.pms.api.kernel;

import java.util.List;

import com.sinosoft.pms.api.kernel.dto.PrpDclassDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinosoft.pms.PMSConstant;
import com.sinosoft.pms.api.kernel.dto.ClassQueryConditionDto;

/**
 * @description 险类接口服务api 
 * @author HSQ
 * @date 2017年9月4日 上午9:44:44
 */
@FeignClient(name = PMSConstant.PMS_SERVICE_NAME, path = ClassApi.PATH)
public interface ClassApi {

	String PATH = "class";

	/**
	 * @description 新增险类
	 * @param prpDclassDto
	 * @author HSQ
	 * @date 2017年9月4日 上午9:21:58
	 */
	@RequestMapping(value = "saveClass", method = { RequestMethod.POST })
    String saveClass(@RequestBody PrpDclassDto prpDclassDto) throws Exception;

	/**
	 * @description 删除险类
	 * @param classCode
	 * @author HSQ
	 * @date 2017年9月4日 上午9:23:06
	 */
	@RequestMapping(value = "removeClass", method = { RequestMethod.POST })
    String removeClass(@RequestParam(value = "classCode") String classCode) throws Exception;

	/**
	 * @description 修改险类
	 * @param prpDclassDto
	 * @author HSQ
	 * @date 2017年9月4日 上午9:23:22
	 */
	@RequestMapping(value = "modifyClass", method = { RequestMethod.POST })
    String modifyClass(@RequestBody PrpDclassDto prpDclassDto) throws Exception;

	/**
	 * @description 按主键查询险类
	 * @param classCode
	 * @return
	 * @author HSQ
	 * @date 2017年9月4日 上午9:23:40
	 */
	@RequestMapping(value = "queryClassByPK", method = { RequestMethod.POST })
    @ResponseBody
	PrpDclassDto queryClassByPK(@RequestParam(value = "classCode") String classCode) throws Exception;

	/**
	 * @description 险类转译
	 * @param classCode
	 * @param isChinese
	 * @return
	 * @author HSQ
	 * @date 2017年9月4日 上午9:35:40
	 */
	@RequestMapping(value = "translateCode", method = { RequestMethod.POST })
    String translateCode(@RequestParam(value = "classCode") String classCode,
                         @RequestParam(value = "isChinese") boolean isChinese) throws Exception;
	
	/**
	 * @description 根据条件查询险类
	 * @param classQueryConditionDto
	 * @return
	 * @author HSQ
	 * @date 2017年9月4日 下午5:30:59
	 */
	@RequestMapping(value = "findClassByCondition", method = { RequestMethod.POST })
    @ResponseBody List<PrpDclassDto> findClassByCondition(@RequestBody ClassQueryConditionDto classQueryConditionDto);

	/**
	 * @description 查询所有险类
	 * @return List<PrpDclassDto>
	 * @author HSQ
	 * @date 2017年12月13日 上午10:30
	 */
	@RequestMapping(value = "queryAllClass",method = RequestMethod.POST)
	public @ResponseBody List<PrpDclassDto> queryAllClass() throws Exception;

}