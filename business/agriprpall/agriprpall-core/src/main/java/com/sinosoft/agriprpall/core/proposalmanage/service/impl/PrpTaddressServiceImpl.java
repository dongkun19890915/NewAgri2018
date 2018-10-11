package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTaddressDto;
import com.sinosoft.agriprpall.core.proposalmanage.dao.PrpTaddressDao;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTaddress;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTaddressKey;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTaddressService;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
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
 * @time  2017-10-18 08:03:36.446 
 * @description 投保单地址信息表Core接口实现
 */
@Service
public class PrpTaddressServiceImpl extends BaseServiceImpl implements PrpTaddressService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpTaddressServiceImpl.class);
    
    @Autowired
    private PrpTaddressDao prpTaddressDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpTaddressDto prpTaddressDto) {
        PrpTaddress prpTaddress = this.convert(prpTaddressDto, PrpTaddress.class);
        prpTaddressDao.save(prpTaddress);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String proposalNo,Integer addressNo) {
        PrpTaddressKey prpTaddressKey = new PrpTaddressKey(proposalNo,addressNo);
        prpTaddressDao.delete(prpTaddressKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpTaddressDto prpTaddressDto) {
        PrpTaddress prpTaddress = this.convert(prpTaddressDto, PrpTaddress.class);
        prpTaddressDao.save(prpTaddress);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpTaddressDto queryByPK(String proposalNo,Integer addressNo) {
        PrpTaddressKey prpTaddressKey = new PrpTaddressKey(proposalNo,addressNo);
        PrpTaddress prpTaddress = prpTaddressDao.findOne(prpTaddressKey);
        return this.convert(prpTaddress,PrpTaddressDto.class);
    }
}