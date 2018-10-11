package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTexpenseDto;
import com.sinosoft.agriprpall.core.proposalmanage.dao.PrpTexpenseDao;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTexpense;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTexpenseKey;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTexpenseService;
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
 * @description 税表Core接口实现
 */
@Service
public class PrpTexpenseServiceImpl extends BaseServiceImpl implements PrpTexpenseService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpTexpenseServiceImpl.class);
    
    @Autowired
    private PrpTexpenseDao prpTexpenseDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpTexpenseDto prpTexpenseDto) {
        PrpTexpense prpTexpense = this.convert(prpTexpenseDto, PrpTexpense.class);
        prpTexpenseDao.save(prpTexpense);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String proposalNo) {
        PrpTexpenseKey prpTexpenseKey = new PrpTexpenseKey(proposalNo);
        prpTexpenseDao.delete(prpTexpenseKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpTexpenseDto prpTexpenseDto) {
        PrpTexpense prpTexpense = this.convert(prpTexpenseDto, PrpTexpense.class);
        prpTexpenseDao.save(prpTexpense);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpTexpenseDto queryByPK(String proposalNo) {
        PrpTexpenseKey prpTexpenseKey = new PrpTexpenseKey(proposalNo);
        PrpTexpense prpTexpense = prpTexpenseDao.findOne(prpTexpenseKey);
        return this.convert(prpTexpense,PrpTexpenseDto.class);
    }
}