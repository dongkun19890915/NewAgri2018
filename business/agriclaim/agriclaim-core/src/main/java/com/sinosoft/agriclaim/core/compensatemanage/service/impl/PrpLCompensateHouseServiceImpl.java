package com.sinosoft.agriclaim.core.compensatemanage.service.impl;

import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCompensateHouseDto;
import com.sinosoft.agriclaim.core.compensatemanage.dao.PrpLCompensateHouseDao;
import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLCompensateHouse;
import com.sinosoft.agriclaim.core.compensatemanage.entity.PrpLCompensateHouseKey;
import com.sinosoft.agriclaim.core.compensatemanage.service.PrpLCompensateHouseService;
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
 * @time  2017-11-08 05:40:44.225 
 * @description 农房理赔身份证信息表Core接口实现
 */
@Service
public class PrpLCompensateHouseServiceImpl extends BaseServiceImpl implements PrpLCompensateHouseService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLCompensateHouseServiceImpl.class);
    
    @Autowired
    private PrpLCompensateHouseDao prpLCompensateHouseDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpLCompensateHouseDto prpLCompensateHouseDto) {
        PrpLCompensateHouse prpLCompensateHouse = this.convert(prpLCompensateHouseDto, PrpLCompensateHouse.class);
        prpLCompensateHouseDao.save(prpLCompensateHouse);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String idcard,String registNo,String nodeType,String businessNo) {
        PrpLCompensateHouseKey prpLCompensateHouseKey = new PrpLCompensateHouseKey(idcard,registNo,nodeType,businessNo);
        prpLCompensateHouseDao.delete(prpLCompensateHouseKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLCompensateHouseDto prpLCompensateHouseDto) {
        PrpLCompensateHouse prpLCompensateHouse = this.convert(prpLCompensateHouseDto, PrpLCompensateHouse.class);
        prpLCompensateHouseDao.save(prpLCompensateHouse);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLCompensateHouseDto queryByPK(String idcard,String registNo,String nodeType,String businessNo) {
        PrpLCompensateHouseKey prpLCompensateHouseKey = new PrpLCompensateHouseKey(idcard,registNo,nodeType,businessNo);
        PrpLCompensateHouse prpLCompensateHouse = prpLCompensateHouseDao.findOne(prpLCompensateHouseKey);
        return this.convert(prpLCompensateHouse,PrpLCompensateHouseDto.class);
    }
}