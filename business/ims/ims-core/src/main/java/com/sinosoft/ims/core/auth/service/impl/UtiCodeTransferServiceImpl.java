package com.sinosoft.ims.core.auth.service.impl;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.dto.UtiCodeTransferDto;
import com.sinosoft.ims.core.auth.dao.UtiCodeTransferDao;
import com.sinosoft.ims.core.auth.entity.UtiCodeTransfer;
import com.sinosoft.ims.core.auth.entity.UtiCodeTransferKey;
import com.sinosoft.ims.core.auth.service.UtiCodeTransferService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-11-05 01:10:12.703
 * @description UtiCodeTransferCore接口实现
 */
@Service
public class UtiCodeTransferServiceImpl extends BaseServiceImpl implements UtiCodeTransferService {
	/** log日志 */
	private static final Logger LOGGER = LoggerFactory.getLogger(UtiCodeTransferServiceImpl.class);

	@Autowired
	private UtiCodeTransferDao utiCodeTransferDao;

	/**
	 * @description 新增
	 * @param
	 */
	public void save(UtiCodeTransferDto utiCodeTransferDto) {
		UtiCodeTransfer utiCodeTransfer = this.convert(utiCodeTransferDto, UtiCodeTransfer.class);
		utiCodeTransferDao.save(utiCodeTransfer);
	}

	/**
	 * @description 删除
	 * @param
	 */
	public void remove(String configCode) {
		UtiCodeTransferKey utiCodeTransferKey = new UtiCodeTransferKey(configCode);
		utiCodeTransferDao.delete(utiCodeTransferKey);
	}

	/**
	 * @description 修改
	 * @param
	 */
	public void modify(UtiCodeTransferDto utiCodeTransferDto) {
		UtiCodeTransfer utiCodeTransfer = this.convert(utiCodeTransferDto, UtiCodeTransfer.class);
		utiCodeTransferDao.save(utiCodeTransfer);
	}

	/**
	 * @description 按主键查询实体
	 * @param
	 */
	public UtiCodeTransferDto queryByPK(String configCode) {
		UtiCodeTransferKey utiCodeTransferKey = new UtiCodeTransferKey(configCode);
		UtiCodeTransfer utiCodeTransfer = utiCodeTransferDao.findOne(utiCodeTransferKey);
		return this.convert(utiCodeTransfer, UtiCodeTransferDto.class);
	}

	/**
	 * 根据险种大类查询UtiCodeTransferDto 险别大类结果集
	 * 
	 * @author: 田慧
	 * @date: 2017/11/22 17:05
	 * @param riskType
	 *            险种大类
	 * @return UtiCodeTransferDto 险别大类的集合
	 */
	@Override
	public List<UtiCodeTransferDto> queryByRiskType(String riskType) throws Exception {
		if (StringUtils.isEmpty(riskType)) {
			throw new DataVerifyException("险种大类不能为空！");
		}
		List<UtiCodeTransfer> utiCodeTransferList = utiCodeTransferDao.findByRiskType(riskType);
		List<UtiCodeTransferDto> utiCodeTransferDtoList = new ArrayList<UtiCodeTransferDto>();
		this.convertCollection(utiCodeTransferList, utiCodeTransferDtoList, UtiCodeTransferDto.class);
		return utiCodeTransferDtoList;
	}

	/**
	 * 根据outerCode查询UtiCodeTransferDto 险别大类结果集
	 * 
	 * @author 杨昆
	 * @date 2017年12月15日 下午10:28:15
	 * @param map
	 *            包括outerCode属性
	 * @return UtiCodeTransferDto集合
	 */
	@Override
	public List<UtiCodeTransferDto> queryUtiCodeTransferDtoByOuterCode(String outerCode) {
		if (StringUtils.isEmpty(outerCode)) {
			throw new DataVerifyException("根据outerCode查询UtiCodeTransferDto 险别大类结果集入参不合法！");
		}
		List<UtiCodeTransfer> utiCodeTransferList = utiCodeTransferDao
				.findAll(Specifications.<UtiCodeTransfer> and().eq("outerCode", outerCode).build());
		List<UtiCodeTransferDto> utiCodeTransferDtoList = new ArrayList<>(utiCodeTransferList.size());
		convertCollection(utiCodeTransferList, utiCodeTransferDtoList, UtiCodeTransferDto.class);
		return utiCodeTransferDtoList;
	}

	/**
	 * @description:方法功能简述:根据险类编码查询outerCode
	 * @author 安齐崇
	 * @date 2017年12月14日下午11:16:16
	 * @param riskTypes
	 *            险类集合
	 * @return
	 */
	@Override
	public List<String> queryOuterCodeByTypes(List<String> riskTypes) {
		if (riskTypes == null || riskTypes.size() < 1) {
			return null;
		}
		List<UtiCodeTransfer> utiCodeTransferList = null;
		List<String> outerCodeList = new ArrayList<>();
		if (riskTypes.size() == 1) {
			utiCodeTransferList = utiCodeTransferDao
					.findAll(Specifications.<UtiCodeTransfer> and().eq("riskType", riskTypes.get(0)).build());
		} else {
			utiCodeTransferList = utiCodeTransferDao
					.findAll(Specifications.<UtiCodeTransfer> and().in("riskType", riskTypes).build());
		}
		for (int i = 0; utiCodeTransferList != null && utiCodeTransferList.size() > 0
				&& i < utiCodeTransferList.size(); i++) {
			UtiCodeTransfer utiCodeTransfer = utiCodeTransferList.get(i);
			outerCodeList.add(utiCodeTransfer.getOuterCode());
		}
		return outerCodeList;
	}
}