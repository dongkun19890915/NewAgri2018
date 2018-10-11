package com.sinosoft.dms.core.dict.service.impl;

import com.sinosoft.dms.api.dict.dto.PrpDcurrencyDto;
import com.sinosoft.dms.api.dict.dto.PrpDcurrencyRequestDto;
import com.sinosoft.dms.core.dict.dao.PrpDcurrencyDao;
import com.sinosoft.dms.core.dict.entity.PrpDcurrency;
import com.sinosoft.dms.core.dict.entity.PrpDcurrencyKey;
import com.sinosoft.dms.core.dict.service.PrpDcurrencyService;
import com.sinosoft.framework.agri.core.constant.LanguageFlagConstant;
import com.sinosoft.framework.agri.core.constant.QuerySignConstant;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.DataVerifyException;
import org.apache.commons.lang3.StringUtils;
import com.sinosoft.framework.dto.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-11-05 01:01:56.447
 * @description 币别代码表Core接口实现
 */
@Service
public class PrpDcurrencyServiceImpl extends BaseServiceImpl implements PrpDcurrencyService {
	/** log日志 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PrpDcurrencyServiceImpl.class);

	@Autowired
	private PrpDcurrencyDao prpDcurrencyDao;
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * @description 新增
	 * @param
	 */
	public void save(PrpDcurrencyDto prpDcurrencyDto) {
		PrpDcurrency prpDcurrency = this.convert(prpDcurrencyDto, PrpDcurrency.class);
		prpDcurrencyDao.save(prpDcurrency);
	}

	/**
	 * @description 删除
	 * @param
	 */
	public void remove(String currencyCode) {
		PrpDcurrencyKey prpDcurrencyKey = new PrpDcurrencyKey(currencyCode);
		prpDcurrencyDao.delete(prpDcurrencyKey);
	}

	/**
	 * @description 修改
	 * @param
	 */
	public void modify(PrpDcurrencyDto prpDcurrencyDto) {
		PrpDcurrency prpDcurrency = this.convert(prpDcurrencyDto, PrpDcurrency.class);
		prpDcurrencyDao.save(prpDcurrency);
	}

	/**
	 * @description 按主键查询实体
	 * @param
	 */
	public PrpDcurrencyDto queryByPK(String currencyCode) {
		PrpDcurrencyKey prpDcurrencyKey = new PrpDcurrencyKey(currencyCode);
		PrpDcurrency prpDcurrency = prpDcurrencyDao.findOne(prpDcurrencyKey);
		return this.convert(prpDcurrency, PrpDcurrencyDto.class);
	}

	/**
	 * @description: 查询币别
	 * @author: 宋振振
	 * @date: 2017/10/29 11:53
	 * @param prpDcurrencyRequestDto
	 *            币别查询请求参数的Dto
	 * @return List<PrpDcurrencyDto>返回币别信息
	 * @throws Exception
	 */
	public List<PrpDcurrencyDto> queryPrpDcurrencyByCondition(PrpDcurrencyRequestDto prpDcurrencyRequestDto,
			String validStatus) throws Exception {
		if (prpDcurrencyRequestDto == null) {
			throw new DataVerifyException("币别查询请求参数的Dto不能为null！");
		}
		// 获取请求参数
		String codeMethod = prpDcurrencyRequestDto.getCodeMethod();
		String codeClass = prpDcurrencyRequestDto.getCodeClass();
		String codeValue = prpDcurrencyRequestDto.getCodeValue();

		// 拼接SQL
		StringBuilder stringBuilder = new StringBuilder(
				"SELECT p FROM PrpDcurrency p WHERE p.validStatus=:validStatus ");
		if (QuerySignConstant.LIKE.equals(codeMethod)) {

			if (codeClass.equals("codeCode"))
				stringBuilder.append(" AND p.currencyCode like :codeValue ");
			else
				stringBuilder.append(" AND p.currencyCname like :codeValue ");
		} else if (QuerySignConstant.EQ.equals(codeMethod)) {

			if (codeClass.equals("codeCode"))
				stringBuilder.append(" AND p.currencyCode =:codeValue");
			else
				stringBuilder.append(" AND p.currencyCname =:codeValue");
		} else {
			throw new DataVerifyException("请输入正确的查询标识！");
		}
		stringBuilder.append(" ORDER BY currencyCode");
		Query dataResult = entityManager.createQuery(stringBuilder.toString());
		dataResult.setParameter("validStatus", validStatus);
		dataResult.setParameter("codeValue", codeValue + "%");

		List<PrpDcurrency> prpDcurrencyList = dataResult.getResultList();
		List<PrpDcurrencyDto> prpDcurrencyDtoList = new ArrayList<PrpDcurrencyDto>();
		convertCollection(prpDcurrencyList, prpDcurrencyDtoList, PrpDcurrencyDto.class);

		return prpDcurrencyDtoList;
	}

	/**
	 * @description: 按照币别代码和中英文标志查询币别
	 * @author 王心洋
	 * @param currencyCode
	 * @param languageFlag
	 * @return
	 * @time 2017-10-31
	 */
	@Override
	public String translateCode(String currencyCode, String languageFlag) {
		if (currencyCode.equals(""))
			return ""; // 代码空直接返回空字符串
		PrpDcurrencyKey prpDcurrencyKey = new PrpDcurrencyKey(currencyCode);
		PrpDcurrency prpDcurrency = prpDcurrencyDao.findOne(prpDcurrencyKey);
		if (LanguageFlagConstant.CHINESE.equals(languageFlag))
			return prpDcurrency.getCurrencyCName();
		else {
			if (prpDcurrency.getCurrencyCName() == null || prpDcurrency.getCurrencyCName().equals("")) {
				return prpDcurrency.getCurrencyCName();
			} else {
				return prpDcurrency.getCurrencyCName();
			}
		}
	}

	/**
	 * @description:方法功能简述: 查询所有的币别信息由于下拉框的初始化
	 * @author 安齐崇
	 * @date 2017年12月13日下午11:59:54
	 * @return
	 */
	@Override
	public List<PrpDcurrencyDto> queryAll() {
		List<PrpDcurrency> prpDcurrencyList = prpDcurrencyDao.findAll();
		List<PrpDcurrencyDto> prpDcurrencyDtoList = new ArrayList<>();
		for (PrpDcurrency prpDcurrency : prpDcurrencyList) {
			PrpDcurrencyDto currencyDto = new PrpDcurrencyDto();
			currencyDto.setCurrencyCode(prpDcurrency.getCurrencyCode());
			currencyDto.setCurrencyCName(prpDcurrency.getCurrencyCName());
			currencyDto.setCurrencyEName(prpDcurrency.getCurrencyEName());
			prpDcurrencyDtoList.add(currencyDto);
		}
		return prpDcurrencyDtoList;
	}
}