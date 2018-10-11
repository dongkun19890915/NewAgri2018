package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTcoinsDetailDto;
import com.sinosoft.agriprpall.core.proposalmanage.dao.PrpTcoinsDetailDao;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTcoinsDetail;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTcoinsDetailKey;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTcoinsDetailService;
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
 * @time  2017-10-21 05:54:45.680 
 * @description 共保明细信息表Core接口实现
 */
@Service
public class PrpTcoinsDetailServiceImpl extends BaseServiceImpl implements PrpTcoinsDetailService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpTcoinsDetailServiceImpl.class);
    
    @Autowired
    private PrpTcoinsDetailDao prpTcoinsDetailDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpTcoinsDetailDto prpTcoinsDetailDto) {
        PrpTcoinsDetail prpTcoinsDetail = this.convert(prpTcoinsDetailDto, PrpTcoinsDetail.class);
        prpTcoinsDetailDao.save(prpTcoinsDetail);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String proposalNo,Integer serialNo,String currency) {
        PrpTcoinsDetailKey prpTcoinsDetailKey = new PrpTcoinsDetailKey(proposalNo,serialNo,currency);
        prpTcoinsDetailDao.delete(prpTcoinsDetailKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpTcoinsDetailDto prpTcoinsDetailDto) {
        PrpTcoinsDetail prpTcoinsDetail = this.convert(prpTcoinsDetailDto, PrpTcoinsDetail.class);
        prpTcoinsDetailDao.save(prpTcoinsDetail);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpTcoinsDetailDto queryByPK(String proposalNo,Integer serialNo,String currency) {
        PrpTcoinsDetailKey prpTcoinsDetailKey = new PrpTcoinsDetailKey(proposalNo,serialNo,currency);
        PrpTcoinsDetail prpTcoinsDetail = prpTcoinsDetailDao.findOne(prpTcoinsDetailKey);
        return this.convert(prpTcoinsDetail,PrpTcoinsDetailDto.class);
    }
}