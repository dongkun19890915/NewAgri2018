package com.sinosoft.pms.core.kernel.service.impl;

import java.util.ArrayList;
import java.util.List;

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
import com.sinosoft.pms.api.kernel.dto.PrpDriskDto;
import com.sinosoft.pms.api.kernel.dto.RiskQueryConditionDto;
import com.sinosoft.pms.core.kernel.dao.PrpDriskDao;
import com.sinosoft.pms.core.kernel.dao.specification.RiskSpecBuilder;
import com.sinosoft.pms.core.kernel.entity.PrpDrisk;
import com.sinosoft.pms.core.kernel.entity.PrpDriskKey;
import com.sinosoft.pms.core.kernel.service.RiskService;

/**
 * @description 险种接口服务serviceImpl
 * @author HSQ
 * @date 2017年9月4日 上午10:41:33
 */
@Service
public class RiskServiceImpl extends BaseServiceImpl implements RiskService {

	/** log日志 */
	private static final Logger LOGGER = LoggerFactory.getLogger(RiskServiceImpl.class);

	@Autowired
	private PrpDriskDao prpDriskDao;

	/**
	 * @description 新增险种
	 * @param prpDriskDto
	 * @author HSQ
	 * @date 2017年9月4日 上午9:21:58
	 */
	@Override
	@Transactional
	@CacheEvict(value = {"translateCodeRisk", "queryRiskByPK"}, allEntries = true)
	public String saveRisk(PrpDriskDto prpDriskDto) throws Exception {
		// 新增控制险种代码必传
		String riskCode = prpDriskDto.getRiskCode();
		if (StringUtils.isEmpty(riskCode)) {
			throw new Exception("险种代码不能为空！");
		}
		PrpDriskDto prpDriskDtoCheck = queryRiskByPK(riskCode);
		if (null != prpDriskDtoCheck) {
			LOGGER.error("险种代码riskCode={}已存在！", riskCode);
			throw new Exception("险种代码" + riskCode + "已存在！");
		}
		PrpDrisk prpDrisk = convert(prpDriskDto, PrpDrisk.class);
        prpDriskDao.save(prpDrisk);
		LOGGER.error("新增险种成功riskCode={}", riskCode);
		return "success";
	}

	/**
	 * @description 删除险种
	 * @param riskCode
	 * @author HSQ
	 * @date 2017年9月4日 上午9:23:06
	 */
	@Override
	@Transactional
	@CacheEvict(value = {"translateCodeRisk", "queryRiskByPK"}, allEntries = true)
	public String removeRisk(String riskCode) throws Exception {
		if (StringUtils.isEmpty(riskCode)) {
			throw new Exception("险种代码不能为空！");
		}
		PrpDriskDto prpDriskDtoCheck = queryRiskByPK(riskCode);
		if (null == prpDriskDtoCheck) {
			LOGGER.error("险种代码riskCode={}不存在！", riskCode);
			throw new Exception("险种代码" + riskCode + "不存在！");
		}
		PrpDriskKey prpDriskKey = new PrpDriskKey(riskCode);
        prpDriskDao.delete(prpDriskKey);
        return "success";
	}

	/**
	 * @description 修改险种
	 * @param prpDriskDto
	 * @author HSQ
	 * @date 2017年9月4日 上午9:23:22
	 */
	@Override
	@Transactional
	@CacheEvict(value = {"translateCodeRisk", "queryRiskByPK"}, allEntries = true)
	public String modifyRisk(PrpDriskDto prpDriskDto) throws Exception {
		String riskCode = prpDriskDto.getRiskCode();
		if (StringUtils.isEmpty(riskCode)) {
			throw new Exception("险种代码不能为空！");
		}
		PrpDriskDto prpDriskDtoCheck = queryRiskByPK(riskCode);	
		if (null == prpDriskDtoCheck) {
			LOGGER.error("险种代码riskCode={}不存在！", riskCode);
			throw new Exception("险种代码" + riskCode + "不存在！");
		}
		PrpDrisk prpDrisk = convert(prpDriskDto, PrpDrisk.class);
        prpDriskDao.save(prpDrisk);
		return "success";
	}

	/**
	 * @description 按主键查询险种
	 * @param riskCode
	 * @return
	 * @author HSQ
	 * @date 2017年9月4日 上午9:23:40
	 */
	@Override
	@Cacheable(value = "queryRiskByPK", key = "#riskCode")
	public PrpDriskDto queryRiskByPK(String riskCode) throws Exception {
		if (StringUtils.isEmpty(riskCode)) {
			throw new Exception("险种代码不能为空！");
		}
		PrpDriskKey prpDriskKey = new PrpDriskKey(riskCode);
        PrpDrisk prpDrisk = prpDriskDao.findOne(prpDriskKey);
        return convert(prpDrisk, PrpDriskDto.class);
	}

	/**
	 * @description 险种转译
	 * @param riskCode
	 * @param isChinese
	 * @return
	 * @author HSQ
	 * @date 2017年9月4日 上午9:35:28
	 */
	@Override
	@Cacheable(value = "translateCodeRisk", key = "#riskCode+'_'+#isChinese")
	public String translateCode(String riskCode, boolean isChinese) throws Exception {
		if (StringUtils.isEmpty(riskCode)) {
			return "";
		}
		PrpDriskDto prpDriskDto = queryRiskByPK(riskCode);
		if(null == prpDriskDto){
			LOGGER.error("险种代码riskCode={}不存在！", riskCode);
			throw new Exception("险种代码" + riskCode + "不存在！");
		}else{
			if(isChinese){
				return prpDriskDto.getRiskCName();
			}else{
				if(StringUtils.isNotEmpty(prpDriskDto.getRiskEName())){
					return prpDriskDto.getRiskEName();
				}else{
					return prpDriskDto.getRiskCName();
				}
			}
		}
	}
	
	/**
	 * @description 根据条件查询险种
	 * @param riskQueryConditionDto
	 * @return
	 * @author HSQ
	 * @date 2017年9月4日 下午5:30:59
	 */
	@Override
	public List<PrpDriskDto> findRiskByCondition(RiskQueryConditionDto riskQueryConditionDto) {
		Specification<PrpDrisk> riskQuerySpecification = RiskSpecBuilder.riskQuerySpecification(riskQueryConditionDto);
		List<PrpDrisk> prpDriskList = prpDriskDao.findAll(riskQuerySpecification);
		List<PrpDriskDto> prpDriskDtoList = new ArrayList<PrpDriskDto>(prpDriskList.size());
		convertCollection(prpDriskList, prpDriskDtoList, PrpDriskDto.class);
		return prpDriskDtoList;
	}
	
}