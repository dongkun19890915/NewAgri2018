package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTmainSubDto;
import com.sinosoft.agriprpall.core.proposalmanage.dao.PrpTmainSubDao;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTmainSub;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTmainSubKey;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTmainSubService;
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
 * @description 投保单隶属表Core接口实现
 */
@Service
public class PrpTmainSubServiceImpl extends BaseServiceImpl implements PrpTmainSubService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpTmainSubServiceImpl.class);
    
    @Autowired
    private PrpTmainSubDao prpTmainSubDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpTmainSubDto prpTmainSubDto) {
        PrpTmainSub prpTmainSub = this.convert(prpTmainSubDto, PrpTmainSub.class);
        prpTmainSubDao.save(prpTmainSub);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String proposalNo,String mainPolicyNo) {
        PrpTmainSubKey prpTmainSubKey = new PrpTmainSubKey(proposalNo,mainPolicyNo);
        prpTmainSubDao.delete(prpTmainSubKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpTmainSubDto prpTmainSubDto) {
        PrpTmainSub prpTmainSub = this.convert(prpTmainSubDto, PrpTmainSub.class);
        prpTmainSubDao.save(prpTmainSub);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpTmainSubDto queryByPK(String proposalNo,String mainPolicyNo) {
        PrpTmainSubKey prpTmainSubKey = new PrpTmainSubKey(proposalNo,mainPolicyNo);
        PrpTmainSub prpTmainSub = prpTmainSubDao.findOne(prpTmainSubKey);
        return this.convert(prpTmainSub,PrpTmainSubDto.class);
    }
}