package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTmainAgriDto;
import com.sinosoft.agriprpall.core.proposalmanage.dao.PrpTmainAgriDao;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTmainAgri;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTmainAgriKey;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTmainAgriService;
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
 * @description 农业险投保单信息表Core接口实现
 */
@Service
public class PrpTmainAgriServiceImpl extends BaseServiceImpl implements PrpTmainAgriService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpTmainAgriServiceImpl.class);
    
    @Autowired
    private PrpTmainAgriDao prpTmainAgriDao;

    /**
     *@description 新增
     *@param
     */
    @Override
    public void save(PrpTmainAgriDto prpTmainAgriDto) {
        PrpTmainAgri prpTmainAgri = this.convert(prpTmainAgriDto, PrpTmainAgri.class);
        prpTmainAgriDao.save(prpTmainAgri);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(String proposalNo) {
        PrpTmainAgriKey prpTmainAgriKey = new PrpTmainAgriKey(proposalNo);
        prpTmainAgriDao.delete(prpTmainAgriKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(PrpTmainAgriDto prpTmainAgriDto) {
        PrpTmainAgri prpTmainAgri = this.convert(prpTmainAgriDto, PrpTmainAgri.class);
        prpTmainAgriDao.save(prpTmainAgri);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpTmainAgriDto queryByPK(String proposalNo) {
        PrpTmainAgriKey prpTmainAgriKey = new PrpTmainAgriKey(proposalNo);
        PrpTmainAgri prpTmainAgri = prpTmainAgriDao.findOne(prpTmainAgriKey);
        return this.convert(prpTmainAgri,PrpTmainAgriDto.class);
    }
}