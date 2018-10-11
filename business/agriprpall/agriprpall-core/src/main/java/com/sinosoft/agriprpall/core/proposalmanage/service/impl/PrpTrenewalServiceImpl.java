package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTrenewalDto;
import com.sinosoft.agriprpall.core.proposalmanage.dao.PrpTrenewalDao;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTrenewal;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTrenewalKey;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTrenewalService;
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
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-22 07:33:55.391 
 * @description PrpTrenewalCore接口实现
 */
@Service
public class PrpTrenewalServiceImpl extends BaseServiceImpl implements PrpTrenewalService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpTrenewalServiceImpl.class);
    
    @Autowired
    private PrpTrenewalDao prpTrenewalDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpTrenewalDto prpTrenewalDto) {
        PrpTrenewal prpTrenewal = this.convert(prpTrenewalDto, PrpTrenewal.class);
        prpTrenewalDao.save(prpTrenewal);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String proposalNo) {
        PrpTrenewalKey prpTrenewalKey = new PrpTrenewalKey(proposalNo);
        prpTrenewalDao.delete(prpTrenewalKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpTrenewalDto prpTrenewalDto) {
        PrpTrenewal prpTrenewal = this.convert(prpTrenewalDto, PrpTrenewal.class);
        prpTrenewalDao.save(prpTrenewal);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpTrenewalDto queryByPK(String proposalNo) {
        PrpTrenewalKey prpTrenewalKey = new PrpTrenewalKey(proposalNo);
        PrpTrenewal prpTrenewal = prpTrenewalDao.findOne(prpTrenewalKey);
        return this.convert(prpTrenewal,PrpTrenewalDto.class);
    }
}