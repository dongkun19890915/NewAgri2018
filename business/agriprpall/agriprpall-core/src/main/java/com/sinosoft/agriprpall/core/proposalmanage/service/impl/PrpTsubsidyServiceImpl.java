package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTsubsidyDto;
import com.sinosoft.agriprpall.core.proposalmanage.dao.PrpTsubsidyDao;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTsubsidy;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTsubsidyKey;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTsubsidyService;
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
 * @time  2017-10-24 01:57:51.087 
 * @description 补贴表Core接口实现
 */
@Service
public class PrpTsubsidyServiceImpl extends BaseServiceImpl implements PrpTsubsidyService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpTsubsidyServiceImpl.class);
    
    @Autowired
    private PrpTsubsidyDao prpTsubsidyDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpTsubsidyDto prpTsubsidyDto) {
        PrpTsubsidy prpTsubsidy = this.convert(prpTsubsidyDto, PrpTsubsidy.class);
        prpTsubsidyDao.save(prpTsubsidy);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String proposalNo,String subsidyCode,String subsidyType) {
        PrpTsubsidyKey prpTsubsidyKey = new PrpTsubsidyKey(proposalNo,subsidyCode,subsidyType);
        prpTsubsidyDao.delete(prpTsubsidyKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpTsubsidyDto prpTsubsidyDto) {
        PrpTsubsidy prpTsubsidy = this.convert(prpTsubsidyDto, PrpTsubsidy.class);
        prpTsubsidyDao.save(prpTsubsidy);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpTsubsidyDto queryByPK(String proposalNo,String subsidyCode,String subsidyType) {
        PrpTsubsidyKey prpTsubsidyKey = new PrpTsubsidyKey(proposalNo,subsidyCode,subsidyType);
        PrpTsubsidy prpTsubsidy = prpTsubsidyDao.findOne(prpTsubsidyKey);
        return this.convert(prpTsubsidy,PrpTsubsidyDto.class);
    }
}