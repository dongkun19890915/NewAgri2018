package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTengageDto;
import com.sinosoft.agriprpall.core.proposalmanage.dao.PrpTengageDao;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTengage;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTengageKey;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTengageService;
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
 * @mail yanghang@sinosoft.com.cn
 * @time  2017-10-19 06:31:19.937 
 * @description 特别约定表Core接口实现
 */
@Service
public class PrpTengageServiceImpl extends BaseServiceImpl implements PrpTengageService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpTengageServiceImpl.class);
    
    @Autowired
    private PrpTengageDao prpTengageDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpTengageDto prpTengageDto) {
        PrpTengage prpTengage = this.convert(prpTengageDto, PrpTengage.class);
        prpTengageDao.save(prpTengage);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String proposalNo,Integer serialNo,Integer lineno) {
        PrpTengageKey prpTengageKey = new PrpTengageKey(proposalNo,serialNo,lineno);
        prpTengageDao.delete(prpTengageKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpTengageDto prpTengageDto) {
        PrpTengage prpTengage = this.convert(prpTengageDto, PrpTengage.class);
        prpTengageDao.save(prpTengage);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpTengageDto queryByPK(String proposalNo,Integer serialNo,Integer lineno) {
        PrpTengageKey prpTengageKey = new PrpTengageKey(proposalNo,serialNo,lineno);
        PrpTengage prpTengage = prpTengageDao.findOne(prpTengageKey);
        return this.convert(prpTengage,PrpTengageDto.class);
    }
}