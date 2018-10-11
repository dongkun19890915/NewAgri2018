package com.sinosoft.dms.core.dict.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.dms.api.dict.dto.NewCodeQueryConditionDto;
import com.sinosoft.dms.api.dict.dto.PrpDnewCodeDto;
import com.sinosoft.dms.api.dict.dto.PrpDnewTypeDto;
import com.sinosoft.dms.core.dict.dao.PrpDnewCodeDao;
import com.sinosoft.dms.core.dict.dao.PrpDnewTypeDao;
import com.sinosoft.dms.core.dict.dao.specification.PrpDnewCodeSpecBuilder;
import com.sinosoft.dms.core.dict.entity.PrpDnewCode;
import com.sinosoft.dms.core.dict.entity.PrpDnewCodeKey;
import com.sinosoft.dms.core.dict.entity.PrpDnewType;
import com.sinosoft.dms.core.dict.service.CodeService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;

/**
 * @description （prpdcode码表的实现）
 * @author zxp
 * @date 2017年8月28日
 */
@Service
public class CodeServiceImpl extends BaseServiceImpl implements CodeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CodeServiceImpl.class);

	@Autowired
	private PrpDnewCodeDao prpDnewCodeDao;

	@Autowired
	private PrpDnewTypeDao prpDnewTypeDao;

	@Override
	@Cacheable(value="PrpDnewCode_queryNewCodeList",key="#newCodeQueryConditionDto.codeCode+'-'+#newCodeQueryConditionDto.codeType+'-'+#newCodeQueryConditionDto.upperCode")
	public List<PrpDnewCodeDto> queryNewCodeList(NewCodeQueryConditionDto newCodeQueryConditionDto) throws Exception {
		if (newCodeQueryConditionDto == null) {
			throw new Exception("入参对象不能为空");
		}
		if (StringUtils.isEmpty(newCodeQueryConditionDto.getCodeType())) {
			throw new Exception("codetype不能为空");
		}
		PrpDnewCode condition = this.convert(newCodeQueryConditionDto, PrpDnewCode.class);
		List<PrpDnewCode> entityList = prpDnewCodeDao.findAll(PrpDnewCodeSpecBuilder.genCondition(condition, false));
		List<PrpDnewCodeDto> dtoList = new ArrayList<PrpDnewCodeDto>();
		this.convertCollection(entityList, dtoList, PrpDnewCodeDto.class);
		return dtoList;
	}

	@Override
	@Cacheable(value="PrpDnewCode_queryNewCodeListByRiskCode",key="#newCodeQueryConditionDto.codeType+'-'+#newCodeQueryConditionDto.riskCode")
	public List<PrpDnewCodeDto> queryNewCodeListByRiskCode(NewCodeQueryConditionDto newCodeQueryConditionDto)
			throws Exception {
		if (newCodeQueryConditionDto == null) {
			throw new Exception("入参对象不能为空");
		}
		if (StringUtils.isEmpty(newCodeQueryConditionDto.getCodeType())) {
			throw new Exception("codetype不能为空");
		}
		if (StringUtils.isEmpty(newCodeQueryConditionDto.getRiskCode())) {
			throw new Exception("riskcode不能为空");
		}
//		List<PrpDnewCode> entityList = prpDnewCodeDao.queryNewCodeListByRiskCode(newCodeQueryConditionDto.getCodeType(),
//				newCodeQueryConditionDto.getRiskCode());
		List<PrpDnewCode> entityList = null;
		List<PrpDnewCodeDto> dtoList = new ArrayList<PrpDnewCodeDto>();
		this.convertCollection(entityList, dtoList, PrpDnewCodeDto.class);
		return dtoList;
	}

	@Override
	public List<PrpDnewCodeDto> queryNewCodeListByCodeLike(NewCodeQueryConditionDto newCodeQueryConditionDto)
			throws Exception {
		if (newCodeQueryConditionDto == null) {
			throw new Exception("入参对象不能为空");
		}
		if (StringUtils.isEmpty(newCodeQueryConditionDto.getCodeType())) {
			throw new Exception("codetype不能为空");
		}
		if (StringUtils.isEmpty(newCodeQueryConditionDto.getCodeCode())) {
			throw new Exception("codecode不能为空");
		}
		PrpDnewCode condition = this.convert(newCodeQueryConditionDto, PrpDnewCode.class);
		List<PrpDnewCode> entityList = prpDnewCodeDao.findAll(PrpDnewCodeSpecBuilder.genCondition(condition, true));
		List<PrpDnewCodeDto> dtoList = new ArrayList<PrpDnewCodeDto>();
		this.convertCollection(entityList, dtoList, PrpDnewCodeDto.class);
		return dtoList;
	}

	@Override
	@Cacheable(value="PrpDnewCode_queryByKey",key="#prpDNewCodeDto.codeType+'-'+#prpDNewCodeDto.codeCode")
	public PrpDnewCodeDto queryByKey(PrpDnewCodeDto prpDNewCodeDto) throws Exception {
		if (prpDNewCodeDto == null) {
			throw new Exception("入参对象不能为空");
		}
		if (StringUtils.isEmpty(prpDNewCodeDto.getCodeType())) {
			throw new Exception("codetype不能为空");
		}
		if (StringUtils.isEmpty(prpDNewCodeDto.getCodeCode())) {
			throw new Exception("codecode不能为空");
		}
		PrpDnewCodeKey condition = this.convert(prpDNewCodeDto, PrpDnewCodeKey.class);
		PrpDnewCode entity = prpDnewCodeDao.findOne(condition);
		if(!"1".equals(entity.getValidStatus())){
			throw new Exception("配置失效");
		}
		PrpDnewCodeDto dto = this.convert(entity, PrpDnewCodeDto.class);
		return dto;
	}

	@Override
	@Cacheable(value="PrpDnewCode_transCodeCodeReturnCodeName",key="#codeType+'-'+#codeCode+'-'+#isChinese")
	public String transCodeCodeReturnCodeName(String codeType, String codeCode, boolean isChinese) throws Exception {
		if (StringUtils.isEmpty(codeType)) {
			throw new Exception("codetype不能为空");
		}
		if (StringUtils.isEmpty(codeCode)) {
			throw new Exception("codecode不能为空");
		}
		PrpDnewCodeKey condition = new PrpDnewCodeKey();
		condition.setCodeCode(codeCode);
		condition.setCodeType(codeType);
		PrpDnewCode entity = prpDnewCodeDao.findOne(condition);
		if(!"1".equals(entity.getValidStatus())){
			throw new Exception("配置失效");
		}
		String codeName = "";
		if(isChinese){
			codeName = entity.getCodeCName();
		}else{
			codeName = entity.getCodeEName();
		}
		return codeName;
	}

	@Override
	@Transactional
	public void deleteNewcode(PrpDnewCodeDto prpDNewCodeDto) throws Exception {
		if (StringUtils.isEmpty(prpDNewCodeDto.getCodeType())) {
			throw new Exception("codetype不能为空");
		}
		PrpDnewCode condition = this.convert(prpDNewCodeDto, PrpDnewCode.class);
		prpDnewCodeDao.delete(condition);
	}

	@Override
	@Transactional
	public void updateNewcode(PrpDnewCodeDto prpDNewCodeDto) throws Exception {
		if (StringUtils.isEmpty(prpDNewCodeDto.getCodeType())) {
			throw new Exception("codetype不能为空");
		}
		if (StringUtils.isEmpty(prpDNewCodeDto.getCodeCode())) {
			throw new Exception("codecode不能为空");
		}
		if (StringUtils.isEmpty(prpDNewCodeDto.getCodeCName())) {
			throw new Exception("codecname不能为空");
		}
		if (StringUtils.isEmpty(prpDNewCodeDto.getCodeEName())) {
			throw new Exception("codeename不能为空");
		}
		if (StringUtils.isEmpty(prpDNewCodeDto.getValidStatus())) {
			throw new Exception("validstatus不能为空");
		}
		PrpDnewCode condition = this.convert(prpDNewCodeDto, PrpDnewCode.class);
		prpDnewCodeDao.delete(condition);
		prpDnewCodeDao.save(condition);
		
	}

	@Override
	@Transactional
	public void insertNewcode(PrpDnewCodeDto prpDNewCodeDto) throws Exception {
		if (StringUtils.isEmpty(prpDNewCodeDto.getCodeType())) {
			throw new Exception("codetype不能为空");
		}
		if (StringUtils.isEmpty(prpDNewCodeDto.getCodeCode())) {
			throw new Exception("codecode不能为空");
		}
		if (StringUtils.isEmpty(prpDNewCodeDto.getCodeCName())) {
			throw new Exception("codecname不能为空");
		}
		if (StringUtils.isEmpty(prpDNewCodeDto.getCodeEName())) {
			throw new Exception("codeename不能为空");
		}
		prpDNewCodeDto.setValidStatus("1");
		PrpDnewCode condition = this.convert(prpDNewCodeDto, PrpDnewCode.class);
		prpDnewCodeDao.save(condition);
	}

	@Override
	@Cacheable(value="PrpDnewCode_getAllCodeType")
	public List<PrpDnewTypeDto> getAllCodeType() {
		List<PrpDnewType> entityList = prpDnewTypeDao.findAll();
		List<PrpDnewTypeDto> dtoList = new ArrayList<PrpDnewTypeDto>();
		this.convertCollection(entityList, dtoList, PrpDnewTypeDto.class);
		return dtoList;
	}
	
}