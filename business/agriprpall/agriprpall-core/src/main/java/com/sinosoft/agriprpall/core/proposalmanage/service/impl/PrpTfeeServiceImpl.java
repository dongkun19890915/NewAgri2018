package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTfeeDto;
import com.sinosoft.agriprpall.core.proposalmanage.dao.PrpTfeeDao;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTfee;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTfeeKey;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTfeeService;
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
 * @description 保单保额保费表Core接口实现
 */
@Service
public class PrpTfeeServiceImpl extends BaseServiceImpl implements PrpTfeeService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpTfeeServiceImpl.class);
    
    @Autowired
    private PrpTfeeDao prpTfeeDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpTfeeDto prpTfeeDto) {
        PrpTfee prpTfee = this.convert(prpTfeeDto, PrpTfee.class);
        prpTfeeDao.save(prpTfee);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String proposalNo,String currency) {
        PrpTfeeKey prpTfeeKey = new PrpTfeeKey(proposalNo,currency);
        prpTfeeDao.delete(prpTfeeKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpTfeeDto prpTfeeDto) {
        PrpTfee prpTfee = this.convert(prpTfeeDto, PrpTfee.class);
        prpTfeeDao.save(prpTfee);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpTfeeDto queryByPK(String proposalNo,String currency) {
        PrpTfeeKey prpTfeeKey = new PrpTfeeKey(proposalNo,currency);
        PrpTfee prpTfee = prpTfeeDao.findOne(prpTfeeKey);
        return this.convert(prpTfee,PrpTfeeDto.class);
    }
}