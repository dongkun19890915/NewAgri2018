package com.sinosoft.dms.core.paymanage.service.impl;

import com.sinosoft.dms.api.dict.PrpDcodeApi;
import com.sinosoft.dms.api.paymanage.PrpCentralizedPayApi;
import com.sinosoft.dms.api.paymanage.dto.PrpCentralizedPayInfoDto;
import com.sinosoft.dms.api.paymanage.dto.PrpDbankDto;
import com.sinosoft.dms.core.paymanage.dao.PrpCentralizedPayInfoDao;
import com.sinosoft.dms.core.paymanage.entity.PrpCentralizedPayInfo;
import com.sinosoft.dms.core.paymanage.entity.PrpCentralizedPayInfoKey;
import com.sinosoft.dms.core.paymanage.service.PrpCentralizedPayService;
import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.ims.api.auth.UtiUserGradeApi;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.pms.api.config.PrpDriskConfigApi;
import com.sinosoft.pms.api.misc.PrpDareaApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-11-21 08:39:47.289
 * @description PrpCentralizedPayInfoCore接口实现
 */
@Service
public class PrpCentralizedPayServiceImpl extends BaseCustomServiceImpl implements PrpCentralizedPayService {
	/** log日志 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PrpCentralizedPayServiceImpl.class);

	@Autowired
	private PrpCentralizedPayInfoDao prpCentralizedPayInfoDao;
	@Autowired
	private PrpCentralizedPayApi prpCentralizedPayInfoApi;
	@Autowired
	private PrpDriskConfigApi prpDriskConfigApi;

	@Autowired
	private UtiUserGradeApi utiUserGradeApi;

	@Autowired
	private PrpDcompanyApi prpDcompanyApi;

	@Autowired
	private PrpDcodeApi prpDcodeApi;


	@Autowired
	private PrpDareaApi prpDareaApi;

	@PersistenceContext
	private EntityManager entityManager;

	// 定义map,调用其他api时传入参数
	Map<String, String> map = new HashMap<>();

	PrpDbankDto prpDbankDto = null;

	/**
	 * @description 新增
	 * @param
	 */
	public void save(PrpCentralizedPayInfoDto prpCentralizedPayInfoDto) {
		PrpCentralizedPayInfo prpCentralizedPayInfo = this.convert(prpCentralizedPayInfoDto,
				PrpCentralizedPayInfo.class);
		prpCentralizedPayInfoDao.save(prpCentralizedPayInfo);
	}

	/**
	 * @description 删除
	 * @param
	 */
	public void remove(String operateId) {
		PrpCentralizedPayInfoKey prpCentralizedPayInfoKey = new PrpCentralizedPayInfoKey(operateId);
		prpCentralizedPayInfoDao.delete(prpCentralizedPayInfoKey);
	}

	/**
	 * @description 修改
	 * @param
	 */
	public void modify(PrpCentralizedPayInfoDto prpCentralizedPayInfoDto) {
		PrpCentralizedPayInfo prpCentralizedPayInfo = this.convert(prpCentralizedPayInfoDto,
				PrpCentralizedPayInfo.class);
		prpCentralizedPayInfoDao.save(prpCentralizedPayInfo);
	}

	/**
	 * @description 按主键查询实体
	 * @param
	 */
	public PrpCentralizedPayInfoDto queryByPK(String operateId) {
		PrpCentralizedPayInfoKey prpCentralizedPayInfoKey = new PrpCentralizedPayInfoKey(operateId);
		PrpCentralizedPayInfo prpCentralizedPayInfo = prpCentralizedPayInfoDao.findOne(prpCentralizedPayInfoKey);
		return this.convert(prpCentralizedPayInfo, PrpCentralizedPayInfoDto.class);
	}


}
