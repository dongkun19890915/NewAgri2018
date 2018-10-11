package com.sinosoft.pms.api.kernel;

import java.util.List;

import com.sinosoft.pms.api.kernel.dto.*;
import com.sun.org.apache.xerces.internal.impl.dv.xs.AbstractDateTimeDV;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinosoft.pms.PMSConstant;

/**
 * @description 条款接口服务api 
 * @author HSQ
 * @date 2017年9月4日 上午9:45:02
 */
@FeignClient(name = PMSConstant.PMS_SERVICE_NAME, path = ClauseApi.PATH)
public interface ClauseApi {

	String PATH = "clause";

	/**
	 * @description 新增条款
	 * @param prpDclauseDto
	 * @author HSQ
	 * @date 2017年9月4日 上午9:21:58
	 */
	@RequestMapping(value = "saveClause", method = { RequestMethod.POST })
    String saveclause(@RequestBody PrpDclauseDto prpDclauseDto) throws Exception;

	/**
	 * @description 删除条款
	 * @param clauseCode
	 * @author HSQ
	 * @date 2017年9月4日 上午9:23:06
	 */
	@RequestMapping(value = "removeClause", method = { RequestMethod.POST })
    String removeclause(@RequestParam(value = "clauseCode") String clauseCode) throws Exception;

	/**
	 * @description 修改条款
	 * @param prpDclauseDto
	 * @author HSQ
	 * @date 2017年9月4日 上午9:23:22
	 */
	@RequestMapping(value = "modifyClause", method = { RequestMethod.POST })
    String modifyclause(@RequestBody PrpDclauseDto prpDclauseDto) throws Exception;

	/**
	 * @description 按主键查询条款
	 * @param clauseCode
	 * @return
	 * @author HSQ
	 * @date 2017年9月4日 上午9:23:40
	 */
	@RequestMapping(value = "queryClauseByClauseCode", method = { RequestMethod.POST })
    @ResponseBody PrpDclauseDto queryClauseByClauseCode(@RequestParam(value = "clauseCode") String clauseCode) throws Exception;

	/**
	 * @description 条款转译 
	 * @param clauseCode
	 * @param isChinese
	 * @return
	 * @author HSQ
	 * @date 2017年9月4日 上午9:35:28
	 */
	@RequestMapping(value = "translateCode", method = { RequestMethod.POST })
    String translateCode(@RequestParam(value = "clauseCode") String clauseCode,
                         @RequestParam(value = "isChinese") boolean isChinese) throws Exception;
	
	/**
	 * @description 根据条件查询条款
	 * @param clauseQueryConditionDto
	 * @return
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年9月4日 下午5:30:59
	 */
	@RequestMapping(value = "findClauseByCondition", method = { RequestMethod.POST })
    @ResponseBody List<PrpDclauseDto> findClauseByCondition(@RequestBody ClauseQueryConditionDto clauseQueryConditionDto) throws Exception;

	/**
	* @description 根据险种查询特别约定
	* @param	clauseQueryByRiskCodeDto
	* @return List<PrpDclauseDto>
	* @throws Exception
	* @author SHY
	* @date 2017/9/30/030
	*/
	@RequestMapping(value = "queryClauseByRiskCode", method = { RequestMethod.POST })
    @ResponseBody List<PrpDclauseDto> queryClauseByRiskCode(@RequestBody ClauseQueryByRiskCodeDto clauseQueryByRiskCodeDto) throws Exception;

}