package com.sinosoft.pms.core.kernel.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.sinosoft.dms.api.dict.CodeApi;
import com.sinosoft.dms.api.dict.dto.NewCodeQueryConditionDto;
import com.sinosoft.dms.api.dict.dto.PrpDnewCodeDto;
import com.sinosoft.framework.agri.core.utils.StringGyUtils;
import com.sinosoft.framework.core.dao.support.PredicateBuilder;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.pms.api.kernel.dto.ClauseQueryByRiskCodeDto;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.pms.api.kernel.dto.ClauseQueryConditionDto;
import com.sinosoft.pms.api.kernel.dto.PrpDclauseDto;
import com.sinosoft.pms.core.kernel.dao.PrpDclauseDao;
import com.sinosoft.pms.core.kernel.dao.specification.ClauseSpecBuilder;
import com.sinosoft.pms.core.kernel.entity.PrpDclause;
import com.sinosoft.pms.core.kernel.service.ClauseService;

/**
 * @description 条款接口服务serviceImpl
 * @author HSQ
 * @date 2017年9月4日 上午10:31:37
 */
@Service
public class ClauseServiceImpl extends BaseServiceImpl implements ClauseService {

	/** log日志 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ClauseServiceImpl.class);
	
	private static final int FIELDLENGHT = 240;

	@Autowired
	private PrpDclauseDao prpDclauseDao;
	@Autowired
	CodeApi codeApi;

	
	/**
	 * @description 新增条款
	 * @param prpDclauseDto
	 * @author HSQ
	 * @date 2017年9月4日 上午9:21:58
	 */
	@Override
	@Transactional
	@CacheEvict(value = { "translateCodeClause", "queryClauseByClauseCode" }, allEntries = true)
	public String saveClause(PrpDclauseDto prpDclauseDto) throws Exception {
		// 新增控制条款代码必传
		String clauseCode = prpDclauseDto.getClauseCode();
		if (StringUtils.isEmpty(clauseCode)) {
			throw new Exception("条款代码不能为空！");
		}
		Specification<PrpDclause> specification = ClauseSpecBuilder.clauseCodeSpecification(clauseCode);
		List<PrpDclause> prpDclauseCheckList = prpDclauseDao.findAll(specification);
		if(prpDclauseCheckList.size() > 0){
			LOGGER.error("条款代码clauseCode={}已存在！", clauseCode);
			throw new Exception("条款代码" + clauseCode + "已存在！");
		}
		List<PrpDclause> prpDclauseList = new ArrayList<PrpDclause>();
		int lineNo = 0;
		String conText = prpDclauseDto.getContext();
		// 标题（保证最少存储一条数据）
		if(StringUtils.isEmpty(conText)
//                || StringUtils.isNotEmpty(prpDclauseDto.getClauseTitle())
                ){
			PrpDclause prpDclause = convert(prpDclauseDto, PrpDclause.class);
			prpDclause.setTitleFlag("1");// 标题
//			prpDclause.setContext(prpDclauseDto.getClauseTitle());
			prpDclause.setLineNo(++lineNo);
			prpDclauseList.add(prpDclause);
		}
		if(StringUtils.isNotEmpty(conText)){// 条款内容非空则拆分条款为多条存储
			String[] conTextAry = StringGyUtils.split(conText, FIELDLENGHT);
			for(String conText1 : conTextAry){
				PrpDclause prpDclause = convert(prpDclauseDto, PrpDclause.class);
				prpDclause.setTitleFlag("0");// 非标题
				prpDclause.setContext(conText1);
				prpDclause.setLineNo(++lineNo);
				prpDclauseList.add(prpDclause);
			}
		}
		prpDclauseDao.save(prpDclauseList);
		LOGGER.error("新增条款成功clauseCode={}", clauseCode);
		return "success";
	}

	/**
	 * @description 删除条款
	 * @param clauseCode
	 * @author HSQ
	 * @date 2017年9月4日 上午9:23:06
	 */
	@Override
	@Transactional
	@CacheEvict(value = { "translateCodeClause", "queryClauseByClauseCode" }, allEntries = true)
	public String removeClause(String clauseCode) throws Exception {
		if (StringUtils.isEmpty(clauseCode)) {
			throw new Exception("条款代码不能为空！");
		}
		Specification<PrpDclause> specification = ClauseSpecBuilder.clauseCodeSpecification(clauseCode);
		List<PrpDclause> prpDclauseList = prpDclauseDao.findAll(specification);
		if(prpDclauseList.size() == 0){
			LOGGER.error("条款代码clauseCode={}不存在！", clauseCode);
			throw new Exception("条款代码" + clauseCode + "不存在！");
		}
		prpDclauseDao.delete(prpDclauseList);
		return "success";
	}

	/**
	 * @description 修改条款
	 * @param prpDclauseDto
	 * @author HSQ
	 * @date 2017年9月4日 上午9:23:22
	 */
	@Override
	@Transactional
	@CacheEvict(value = { "translateCodeClause", "queryClauseByClauseCode" }, allEntries = true)
	public String modifyClause(PrpDclauseDto prpDclauseDto) throws Exception {
		String clauseCode = prpDclauseDto.getClauseCode();
		if (StringUtils.isEmpty(clauseCode)) {
			throw new Exception("条款代码不能为空！");
		}
		Specification<PrpDclause> specification = ClauseSpecBuilder.clauseCodeSpecification(clauseCode);
		List<PrpDclause> prpDclauseCheckList = prpDclauseDao.findAll(specification);
		if(prpDclauseCheckList.size() == 0){
			LOGGER.error("条款代码clauseCode={}不存在！", clauseCode);
			throw new Exception("条款代码" + clauseCode + "不存在！");
		}
		// 先删除，后保存
		removeClause(clauseCode);
		saveClause(prpDclauseDto);
		return "success";
	}

	/**
	 * @description 按条款代码查询条款
	 * @param clauseCode
	 * @return
	 * @author HSQ
	 * @date 2017年9月4日 上午9:23:40
	 */
	@Override
	@Cacheable(value = "queryClauseByClauseCode", key = "#clauseCode")
	public PrpDclauseDto queryClauseByClauseCode(String clauseCode) throws Exception {
		if (StringUtils.isEmpty(clauseCode)) {
			throw new Exception("条款代码不能为空！");
		}
		Specification<PrpDclause> specification = ClauseSpecBuilder.clauseCodeSpecification(clauseCode);
		List<PrpDclause> prpDclauseList = prpDclauseDao.findAll(specification);
		if(prpDclauseList.size() == 0){
			return null;
		}
		PrpDclauseDto prpDclauseDto = convert(prpDclauseList.get(0), PrpDclauseDto.class);
		// 组装条款标题及条款内容
		StringBuffer clauseTitleSB = new StringBuffer();
		StringBuffer conTextSB = new StringBuffer();
		for(PrpDclause prpDclause : prpDclauseList){
			if("1".equals(prpDclause.getTitleFlag())){// 条款标题
				clauseTitleSB.append(prpDclause.getContext());
			}else{// 条款内容
				conTextSB.append(prpDclause.getContext());
			}
		}
//		prpDclauseDto.setClauseTitle(clauseTitleSB.toString());
		prpDclauseDto.setContext(conTextSB.toString());
		return prpDclauseDto;
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
	@Cacheable(value = "translateCodeClause", key = "#clauseCode+'_'+#isChinese")
	public String translateCode(String clauseCode, boolean isChinese) throws Exception {
		if (StringUtils.isEmpty(clauseCode)) {
			return "";
		}
		Specification<PrpDclause> specification = ClauseSpecBuilder.clauseCodeSpecification(clauseCode);
		List<PrpDclause> prpDclauseList = prpDclauseDao.findAll(specification);
		if(prpDclauseList.size() == 0){
			LOGGER.error("条款代码clauseCode={}不存在！", clauseCode);
			throw new Exception("条款代码" + clauseCode + "不存在！");
		} else {
//			PrpDclause prpDclause = prpDclauseList.get(0);
//			if (isChinese) {
//				return prpDclause.getClauseCName();
//			} else {
//				if (StringUtils.isNotEmpty(prpDclause.getClauseEName())) {
//					return prpDclause.getClauseEName();
//				} else {
//					return prpDclause.getClauseCName();
//				}
//			}
		}
		return null;
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
	public List<PrpDclauseDto> findClauseByCondition(ClauseQueryConditionDto clauseQueryConditionDto) throws Exception {
		List<PrpDclauseDto> prpDclauseDtoList = new ArrayList<PrpDclauseDto>();
		Specification<PrpDclause> clauseQuerySpecification = ClauseSpecBuilder.clauseQuerySpecification(clauseQueryConditionDto);
		List<PrpDclause> prpDclauseList = prpDclauseDao.findAll(clauseQuerySpecification);
		Set<String> clauseCodeSet = new HashSet<String>();
		for(PrpDclause prpDclause : prpDclauseList){
			clauseCodeSet.add(prpDclause.getClauseCode());
		}
		Iterator<String> iterator = clauseCodeSet.iterator();
		while(iterator.hasNext()){
			String clauseCode = iterator.next();
			PrpDclauseDto prpDclauseDto = queryClauseByClauseCode(clauseCode);
			prpDclauseDtoList.add(prpDclauseDto);
		}
		return prpDclauseDtoList;
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
	public List<PrpDclauseDto> queryClauseByRiskCode(ClauseQueryByRiskCodeDto clauseQueryByRiskCodeDto) throws Exception {
		if (StringUtils.isEmpty(clauseQueryByRiskCodeDto.getCodeType())) {
			throw new BusinessException("codetype不能为空");
		}
		if (StringUtils.isEmpty(clauseQueryByRiskCodeDto.getRiskCode())) {
			throw new BusinessException("riskcode不能为空");
		}
		String clauseCode = clauseQueryByRiskCodeDto.getClauseCode();
		List<PrpDclauseDto> prpDclauseDtoList = new ArrayList<PrpDclauseDto>();
		NewCodeQueryConditionDto newCodeQueryConditionDto = new NewCodeQueryConditionDto();
		newCodeQueryConditionDto.setCodeType(clauseQueryByRiskCodeDto.getCodeType());
		newCodeQueryConditionDto.setRiskCode(clauseQueryByRiskCodeDto.getRiskCode());
		List<PrpDnewCodeDto> prpDnewCodeDtos = codeApi.queryNewCodeListByRiskCode(newCodeQueryConditionDto);
		PredicateBuilder<PrpDclause> dclausePredicateBuilder = Specifications.and();
		String codeCode = "";
		List codeCodeList = new ArrayList();
		if (null != prpDnewCodeDtos && prpDnewCodeDtos.size()>0){
			for (int i=0;i<prpDnewCodeDtos.size();i++) {
				codeCode = prpDnewCodeDtos.get(i).getCodeCode();
				codeCodeList.add(codeCode);
			}
		}
		dclausePredicateBuilder.eq("lineNo","1");
		dclausePredicateBuilder.eq("validStatus","1");
		dclausePredicateBuilder.like("clauseCode",clauseCode+"%");
		dclausePredicateBuilder.in("clauseCode",codeCodeList);
		List<PrpDclause> prpDclauseList = prpDclauseDao.findAll(dclausePredicateBuilder.build());
		this.convertCollection(prpDclauseList, prpDclauseDtoList, PrpDclauseDto.class);
		return prpDclauseDtoList;
	}

}