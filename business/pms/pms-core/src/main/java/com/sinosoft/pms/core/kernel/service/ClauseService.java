package com.sinosoft.pms.core.kernel.service;

import java.util.List;

import com.sinosoft.pms.api.kernel.dto.ClauseQueryByRiskCodeDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinosoft.pms.api.kernel.dto.ClauseQueryConditionDto;
import com.sinosoft.pms.api.kernel.dto.PrpDclauseDto;

/**
 * @description 条款接口服务service
 * @author HSQ
 * @date 2017年9月4日 上午10:30:37
 */
public interface ClauseService {

	/**
	 * @description 新增条款
	 * @param prpDclauseDto
	 * @author HSQ
	 * @date 2017年9月4日 上午9:21:58
	 */
    String saveClause(PrpDclauseDto prpDclauseDto) throws Exception;

	/**
	 * @description 删除条款
	 * @param clauseCode
	 * @author HSQ
	 * @date 2017年9月4日 上午9:23:06
	 */
    String removeClause(String clauseCode) throws Exception;

	/**
	 * @description 修改条款
	 * @param prpDclauseDto
	 * @author HSQ
	 * @date 2017年9月4日 上午9:23:22
	 */
    String modifyClause(PrpDclauseDto prpDclauseDto) throws Exception;

	/**
	 * @description 按条款代码查询条款
	 * @param clauseCode
	 * @return
	 * @author HSQ
	 * @date 2017年9月4日 上午9:23:40
	 */
    PrpDclauseDto queryClauseByClauseCode(String clauseCode) throws Exception;

	/**
	 * @description 条款转译
	 * @param clauseCode
	 * @param isChinese
	 * @return
	 * @author HSQ
	 * @date 2017年9月4日 上午9:35:28
	 */
    String translateCode(String clauseCode, boolean isChinese) throws Exception;
	
	/**
	 * @description 根据条件查询条款
	 * @param clauseQueryConditionDto
	 * @return
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年9月4日 下午5:30:59
	 */
    List<PrpDclauseDto> findClauseByCondition(ClauseQueryConditionDto clauseQueryConditionDto) throws Exception;

	/**
	 * @description 根据险种查询特别约定
	 * @param	clauseQueryByRiskCodeDto
	 * @return List<PrpDclauseDto>
	 * @throws Exception
	 * @author SHY
	 * @date 2017/9/30/030
	 */
    List<PrpDclauseDto> queryClauseByRiskCode(ClauseQueryByRiskCodeDto clauseQueryByRiskCodeDto) throws  Exception;
}