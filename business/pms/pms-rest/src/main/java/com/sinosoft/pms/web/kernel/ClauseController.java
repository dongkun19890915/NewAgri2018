package com.sinosoft.pms.web.kernel;

import java.util.List;

import com.sinosoft.pms.api.kernel.dto.ClauseQueryByRiskCodeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinosoft.pms.api.kernel.ClauseApi;
import com.sinosoft.pms.api.kernel.dto.ClauseQueryConditionDto;
import com.sinosoft.pms.api.kernel.dto.PrpDclauseDto;
import com.sinosoft.pms.core.kernel.service.ClauseService;

/**
 * @description 条款接口服务controller 
 * @author HSQ
 * @date 2017年9月5日 上午9:48:22
 */
@RestController
@RequestMapping(value = ClauseApi.PATH)
public class ClauseController implements ClauseApi {
	
	@Autowired
	private ClauseService clauseService;

	/**
	 * @description 新增条款
	 * @param prpDclauseDto
	 * @author HSQ
	 * @date 2017年9月4日 上午9:21:58
	 */
	@Override
	public String saveclause(@RequestBody PrpDclauseDto prpDclauseDto) throws Exception {
		return clauseService.saveClause(prpDclauseDto);
	}

	/**
	 * @description 删除条款
	 * @param clauseCode
	 * @author HSQ
	 * @date 2017年9月4日 上午9:23:06
	 */
	@Override
	public String removeclause(String clauseCode) throws Exception {
		return clauseService.removeClause(clauseCode);
	}

	/**
	 * @description 修改条款
	 * @param prpDclauseDto
	 * @author HSQ
	 * @date 2017年9月4日 上午9:23:22
	 */
	@Override
	public String modifyclause(@RequestBody PrpDclauseDto prpDclauseDto) throws Exception {
		return clauseService.modifyClause(prpDclauseDto);
	}

	/**
	 * @description 按主键查询条款
	 * @param clauseCode
	 * @return
	 * @author HSQ
	 * @date 2017年9月4日 上午9:23:40
	 */
	@Override
	public @ResponseBody PrpDclauseDto queryClauseByClauseCode(String clauseCode) throws Exception {
		return clauseService.queryClauseByClauseCode(clauseCode);
	}

	/**
	 * @description 条款转译 
	 * @param clauseCode
	 * @param isChinese
	 * @return
	 * @author HSQ
	 * @date 2017年9月4日 上午9:35:28
	 */
	@Override
	public String translateCode(String clauseCode, boolean isChinese) throws Exception {
		return clauseService.translateCode(clauseCode, isChinese);
	}

	/**
	 * @description 根据条件查询条款
	 * @param clauseQueryConditionDto
	 * @return
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年9月4日 下午5:30:59
	 */
	@Override
	public @ResponseBody List<PrpDclauseDto> findClauseByCondition(@RequestBody ClauseQueryConditionDto clauseQueryConditionDto) throws Exception {
		return clauseService.findClauseByCondition(clauseQueryConditionDto);
	}
	/**
	 * @description 根据险种查询特别约定
	 * @param	clauseQueryByRiskCodeDto
	 * @return List<PrpDclauseDto>
	 * @throws Exception
	 * @author SHY
	 * @date 2017/9/30/030
	 */
	@Override
	public @ResponseBody List<PrpDclauseDto> queryClauseByRiskCode(@RequestBody ClauseQueryByRiskCodeDto clauseQueryByRiskCodeDto) throws Exception {
		return clauseService.queryClauseByRiskCode(clauseQueryByRiskCodeDto);
	}

}
