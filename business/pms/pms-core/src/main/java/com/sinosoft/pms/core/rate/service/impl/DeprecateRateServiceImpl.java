package com.sinosoft.pms.core.rate.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.pms.api.rate.dto.DeprecateRateDto;
import com.sinosoft.pms.api.rate.dto.PrpDdepreCateRateDto;
import com.sinosoft.pms.core.rate.dao.PrpDdepreCateRateDao;
import com.sinosoft.pms.core.rate.entity.PrpDdepreCateRate;
import com.sinosoft.pms.core.rate.entity.PrpDdepreCateRateKey;
import com.sinosoft.pms.core.rate.service.DeprecateRateService;

import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;

/**
 * @description 折旧率接口服务
 * @author HSQ
 * @date 2017年8月23日 上午10:15:57
 */
@Service
public class DeprecateRateServiceImpl extends BaseServiceImpl implements DeprecateRateService {
	
	/**
	 * log日志
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(DeprecateRateServiceImpl.class);
	
	@Autowired
	private PrpDdepreCateRateDao prpDdepreCateRateDao; 

	/**
	 * @description 获取折旧率 TODO 基础数据配置好后需要调整
	 * @param deprecateRateDto
	 * @return
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月23日 上午10:16:06
	 */
	@Override
	@Cacheable(value="deprecateRateKey",key = "#deprecateRateDto.clauseType+'_'+#deprecateRateDto.riskCode+'_'+"
			+ "#deprecateRateDto.seatCount+'_'+#deprecateRateDto.tonCount+'_'+#deprecateRateDto.carKind+'_'+#deprecateRateDto.useNature")
	public PrpDdepreCateRateDto getDeprecateRate(DeprecateRateDto deprecateRateDto) throws Exception {
		
		LOGGER.error("获取折旧率开始：clauseType={},riskCode={},seatCount={},tonCount={},carKind={},useNature={}",
				deprecateRateDto.getClauseType(), deprecateRateDto.getRiskCode(), deprecateRateDto.getSeatCount(),
				deprecateRateDto.getTonCount(), deprecateRateDto.getCarKind(), deprecateRateDto.getUseNature());
		
		String clauseType = deprecateRateDto.getClauseType();
		String riskCode = deprecateRateDto.getRiskCode();
		int seatCount = deprecateRateDto.getSeatCount();
		double tonCount = deprecateRateDto.getTonCount();
		String carKind = deprecateRateDto.getCarKind();
		String useNature = deprecateRateDto.getUseNature();

		// 校验
		if (StringUtils.isEmpty(clauseType)) {
			throw new Exception("条款类型不能为空！");
		}
		if (StringUtils.isEmpty(riskCode)) {
			throw new Exception("险种代码不能为空！");
		}
		if (StringUtils.isEmpty(carKind)) {
			throw new Exception("车辆种类不能为空！");
		}
		if (StringUtils.isEmpty(useNature)) {
			throw new Exception("使用性质不能为空！");
		}
		// 使用性质为家庭自用时必传
		if ("A0".equals(carKind) && seatCount <= 0) {
			throw new Exception("使用性质为家庭自用时，座位数必传且大于0！");
		}
		// 使用性质为货车时必传，用以确认微型载货汽车
		if (carKind.startsWith("H") && tonCount <= 0) {
			throw new Exception("使用性质为货车时，吨位数必传且大于0！");
		}

		String carKindCode = "";
		// 第一位（车辆种类）
		if (carKind.equals("A0")) {
			if (seatCount >= 10) {
				carKindCode = "1";
			} else {
				carKindCode = "0";
			}
		} else if (carKind.startsWith("H") && tonCount < 2) { // 两吨以下货车
			carKindCode = "2";
		} else if (carKind.equals("H5")) { // 带拖挂的载货汽车（半挂牵引车）
			carKindCode = "3";
		} else if (carKind.equals("H1") || carKind.equals("H2")) { // 低速货车和三轮汽车
			carKindCode = "4";
		} else if (carKind.equals("TI")) { // 矿用车
			carKindCode = "5";
		} else if (carKind.startsWith("T")) { // 特种车
			carKindCode = "7";
		} else {
			carKindCode = "6";
		}
		// 第二位（使用性质）
		if (useNature.startsWith("8")) { // 非营业
			carKindCode = carKindCode.substring(0, 1) + "0";
		} else if (useNature.equals("9F")) { // 出租
			carKindCode = carKindCode.substring(0, 1) + "1";
		} else { // 其他
			carKindCode = carKindCode.substring(0, 1) + "2";
		}
		
		PrpDdepreCateRateKey id = new PrpDdepreCateRateKey();
		id.setRiskCode(riskCode);
		id.setClauseType(clauseType);
		id.setCarKindCode(carKindCode);
		PrpDdepreCateRate prpDdepreCateRate = prpDdepreCateRateDao.findOne(id);
		if(null == prpDdepreCateRate){
			throw new Exception("折旧率未配置，请联系系统管理员进行配置！");
		}
		
		LOGGER.error("获取折旧率结束：clauseType={},riskCode={},seatCount={},tonCount={},carKind={},useNature={}",
				deprecateRateDto.getClauseType(), deprecateRateDto.getRiskCode(), deprecateRateDto.getSeatCount(),
				deprecateRateDto.getTonCount(), deprecateRateDto.getCarKind(), deprecateRateDto.getUseNature());
		
		return convert(prpDdepreCateRate, PrpDdepreCateRateDto.class);
	}
	
}
