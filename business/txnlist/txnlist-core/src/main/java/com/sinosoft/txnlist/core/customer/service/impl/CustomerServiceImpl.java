package com.sinosoft.txnlist.core.customer.service.impl;

import com.sinosoft.txnlist.api.customer.dto.PrpDcustomerDto;
import com.sinosoft.txnlist.core.customer.dao.PrpDcustomerDao;
import com.sinosoft.txnlist.core.customer.entity.PrpDcustomer;
import com.sinosoft.txnlist.core.customer.entity.PrpDcustomerKey;
import com.sinosoft.txnlist.core.customer.service.CustomerService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description 客户信息接口实现
 * @author HSQ
 * @date 2017年8月28日 下午3:26:29
 */
@Service
@Transactional
public class CustomerServiceImpl extends BaseServiceImpl implements CustomerService {

	/** log日志 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	private PrpDcustomerDao prpDcustomerDao;
	

	/**
	 * @description 按主键查询prpDcustomer
	 * @param customerCode
	 * @return
	 * @author HSQ
	 * @throws Exception 
	 * @date 2017年8月28日 下午2:58:42
	 */
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED) 
	public PrpDcustomerDto queryCustomerByPK(String customerCode) throws Exception {
		if(StringUtils.isEmpty(customerCode)){
			throw new Exception("客户编码不能为空！");
		}
		PrpDcustomerKey prpDcustomerKey = new PrpDcustomerKey(customerCode);
        PrpDcustomer prpDcustomer = prpDcustomerDao.findOne(prpDcustomerKey);
        return convert(prpDcustomer,PrpDcustomerDto.class);
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public PrpDcustomerDto queryCustomerByCondition(String customerCode) throws Exception {
		if (StringUtils.isEmpty(customerCode)) {
			throw new Exception("客户编码不能为空！");
		}
		PrpDcustomerKey prpDcustomerKey = new PrpDcustomerKey(customerCode);
		List<PrpDcustomer> prpDcustomerList = prpDcustomerDao.findAll();
		if(prpDcustomerList.size()>0){
			return convert(prpDcustomerList.get(0),PrpDcustomerDto.class);
		}else{
			return null;

		}
	}


	}
