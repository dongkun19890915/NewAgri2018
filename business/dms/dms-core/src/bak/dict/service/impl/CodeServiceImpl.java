package com.sinosoft.dms.core.dict.service.impl;

import com.sinosoft.dms.api.dict.dto.PrpDNewCodeDto;
import com.sinosoft.dms.core.dict.dao.PrpDNewCodeDao;
import com.sinosoft.dms.core.dict.entity.PrpDNewCode;
import com.sinosoft.dms.core.dict.entity.PrpDNewCodeKey;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
* @description （prpdcode码表的实现）
* @author dongyingchun
* @date 2016年9月13日下午7:20:46
*/
@Service
public class CodeServiceImpl extends BaseServiceImpl implements CodeService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(CodeServiceImpl.class);
    
	@Autowired
	private PrpDNewCodeDao prpdnewcodeDao;

	@Override
    @Cacheable(value="prpDNewCodeDtoList",key = "caches[0].name+'.'+args[0].codeType+'_'+args[0].codeCode+'_'+args[0].upperCode+'_'+args[0].riskCode")
	public List<PrpDNewCodeDto> searchCodes(NewCodeQueryConditionDto newCodeQueryConditionDto){
		LOGGER.error("获取PrpDNewCode服务开始：codeType={},codeCode={},upperCode={},riskCode={}",newCodeQueryConditionDto.getCodeType(),newCodeQueryConditionDto.getCodeCode(),newCodeQueryConditionDto.getUpperCode(),newCodeQueryConditionDto.getRiskCode());

		//此处预留,需要从register缓存中查询查询,如果查询不到,则从数据库库中查询,查询出来后并插入到缓存中
		//如果能查询到,则需要控制不在查询数据库

        List<PrpDNewCode> list = prpdnewcodeDao.findAll(genCondition(newCodeQueryConditionDto));
        if(list == null){
            return new ArrayList<PrpDNewCodeDto>();
        }
        List<PrpDNewCodeDto> prpdnewcodeDtoList = new ArrayList<PrpDNewCodeDto>(list.size());
        convertCollection(list, prpdnewcodeDtoList, PrpDNewCodeDto.class);

		LOGGER.error("获取PrpDNewCode服务结束：codeType={},upperCode={},riskCode={}",newCodeQueryConditionDto.getCodeType(),newCodeQueryConditionDto.getUpperCode(),newCodeQueryConditionDto.getRiskCode());
		return prpdnewcodeDtoList;
	}

	@Override
    @Cacheable(value="prpDNewCodeDto",key = "caches[0].name+'.'+args[0].codeType+'_'+args[0].codeCode")
	public PrpDNewCodeDto transCodeCodeReturnCodeName(NewCodeQueryConditionDto newCodeQueryConditionDto) throws Exception{
		LOGGER.trace("获取PrpDNewCode转码cname服务:codeType={},codeCode={}",newCodeQueryConditionDto.getCodeType(),newCodeQueryConditionDto.getCodeCode());
        
		String codeType = newCodeQueryConditionDto.getCodeType();
		String codeCode = newCodeQueryConditionDto.getCodeCode();
		
		PrpDNewCodeKey prpDNewCodeKey = new PrpDNewCodeKey();
		prpDNewCodeKey.setCodeCode(codeCode);
		prpDNewCodeKey.setCodeType(codeType);
		
		PrpDNewCode prpDNewCode = prpdnewcodeDao.findOne(prpDNewCodeKey);

		return this.convert(prpDNewCode, PrpDNewCodeDto.class);
	}


	@Override
    @CacheEvict(value="prpDNewCodeDtoList",key="caches[0].name+'.'+args[0].codeType+'_null_null_null'")
	public void deleteNewcode(PrpDNewCodeDto prpDNewCodeDto) {
		String codeType = (String)prpDNewCodeDto.getCodeType();
		String codeCode = prpDNewCodeDto.getCodeCode();
		
		PrpDNewCodeKey prpDNewCodeKey = new PrpDNewCodeKey();
		prpDNewCodeKey.setCodeCode(codeCode);
		prpDNewCodeKey.setCodeType(codeType);
		prpdnewcodeDao.delete(prpDNewCodeKey);
		
	}

	@Override
    @CacheEvict(value="prpDNewCodeDtoList",key="caches[0].name+'.'+args[0].codeType+'_null_null_null'")
	public void updateNewcode(PrpDNewCodeDto prpDNewCodeDto) {
		PrpDNewCode prpdnewcode = convert(prpDNewCodeDto, PrpDNewCode.class);
		prpdnewcode.setValidStatus("1");
		prpdnewcodeDao.save(prpdnewcode);
	}

	@Override
	public void insertNewcode(PrpDNewCodeDto prpDNewCodeDto) {
		PrpDNewCode prpdnewcode = convert(prpDNewCodeDto, PrpDNewCode.class);
		prpdnewcode.setValidStatus("1");
		prpdnewcode.setNewCodeCode(prpDNewCodeDto.getCodeCode());
		prpdnewcodeDao.save(prpdnewcode);
	}

    private Specification<PrpDNewCode> genCondition(NewCodeQueryConditionDto condition){
        return Specifications.<PrpDNewCode>and()
                .eq(StringUtils.isNotEmpty(condition.getCodeCode()),"codeCode", condition.getCodeCode()+"%")
                .eq(StringUtils.isNotEmpty(condition.getCodeType()),"codeType",condition.getCodeType())
                .eq(StringUtils.isNotEmpty(condition.getUpperCode()),"upperCode",condition.getUpperCode())
                .build();
    }

	private Specification<PrpDNewCode> genfuzzyCondition(NewCodeQueryConditionDto condition){
        return Specifications.<PrpDNewCode>and()
                .like(StringUtils.isNotEmpty(condition.getCodeCode()),"codeCode", condition.getCodeCode()+"%")
                .eq(StringUtils.isNotEmpty(condition.getCodeType()),"codeType",condition.getCodeType())
                .eq(StringUtils.isNotEmpty(condition.getUpperCode()),"upperCode",condition.getUpperCode())
				.build();
    }

	@Override
	public List<PrpDNewCodeDto> fuzzySearchCodes(NewCodeQueryConditionDto newCodeQueryConditionDto) {
		LOGGER.trace("获取PrpDNewCode服务开始：codeType={},codeCode={},upperCode={},riskCode={}",newCodeQueryConditionDto.getCodeType(),newCodeQueryConditionDto.getCodeCode(),newCodeQueryConditionDto.getUpperCode(),newCodeQueryConditionDto.getRiskCode());
		//此处预留,需要从register缓存中查询查询,如果查询不到,则从数据库库中查询,查询出来后并插入到缓存中
		//如果能查询到,则需要控制不在查询数据库
        List<PrpDNewCode> list = prpdnewcodeDao.findAll(genfuzzyCondition(newCodeQueryConditionDto));
        if(list == null){
            return new ArrayList<PrpDNewCodeDto>();
        }
        List<PrpDNewCodeDto> prpdnewcodeDtoList = new ArrayList<PrpDNewCodeDto>(list.size());
        convertCollection(list, prpdnewcodeDtoList, PrpDNewCodeDto.class);

		LOGGER.trace("获取PrpDNewCode服务结束：codeType={},upperCode={},riskCode={}",newCodeQueryConditionDto.getCodeType(),newCodeQueryConditionDto.getUpperCode(),newCodeQueryConditionDto.getRiskCode());
        
		return prpdnewcodeDtoList;
	}

    /**
     * 获取单个Code数据
     * @param prpDNewCodeDto
     * @return
     */
	@Override
	public PrpDNewCodeDto queryByKey(PrpDNewCodeDto prpDNewCodeDto){
		String codeType = (String)prpDNewCodeDto.getCodeType();
		String codeCode = prpDNewCodeDto.getCodeCode();
		
		PrpDNewCodeKey prpDNewCodeKey = new PrpDNewCodeKey();
		prpDNewCodeKey.setCodeCode(codeCode);
		prpDNewCodeKey.setCodeType(codeType);
		PrpDNewCode prpDNewCode = prpdnewcodeDao.findOne(prpDNewCodeKey);

		return convert(prpDNewCode, PrpDNewCodeDto.class);
	}

	@Override
	@Cacheable(value="TendencyCacheGetCloudAss")
	public PrpDNewCodeDto queryCodeCacheRedis() {
		// TODO Auto-generated method stub
		PrpDNewCodeDto p = new PrpDNewCodeDto();
		p.setCodeCName("缓存");
		p.setCodeCode("cache");
		p.setCodeType("el");
		System.out.println("无缓存***********************");
		return p;
		
	}
	
	
	
	
}