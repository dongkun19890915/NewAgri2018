package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTmainLoanDto;
import com.sinosoft.agriprpall.core.proposalmanage.dao.PrpTmainLoanDao;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTmainLoan;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTmainLoanKey;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTmainLoanService;
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
 * @description 贷款保险保单信息表Core接口实现
 */
@Service
public class PrpTmainLoanServiceImpl extends BaseServiceImpl implements PrpTmainLoanService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpTmainLoanServiceImpl.class);
    
    @Autowired
    private PrpTmainLoanDao prpTmainLoanDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpTmainLoanDto prpTmainLoanDto) {
        PrpTmainLoan prpTmainLoan = this.convert(prpTmainLoanDto, PrpTmainLoan.class);
        prpTmainLoanDao.save(prpTmainLoan);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String proposalNo) {
        PrpTmainLoanKey prpTmainLoanKey = new PrpTmainLoanKey(proposalNo);
        prpTmainLoanDao.delete(prpTmainLoanKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpTmainLoanDto prpTmainLoanDto) {
        PrpTmainLoan prpTmainLoan = this.convert(prpTmainLoanDto, PrpTmainLoan.class);
        prpTmainLoanDao.save(prpTmainLoan);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpTmainLoanDto queryByPK(String proposalNo) {
        PrpTmainLoanKey prpTmainLoanKey = new PrpTmainLoanKey(proposalNo);
        PrpTmainLoan prpTmainLoan = prpTmainLoanDao.findOne(prpTmainLoanKey);
        return this.convert(prpTmainLoan,PrpTmainLoanDto.class);
    }
}