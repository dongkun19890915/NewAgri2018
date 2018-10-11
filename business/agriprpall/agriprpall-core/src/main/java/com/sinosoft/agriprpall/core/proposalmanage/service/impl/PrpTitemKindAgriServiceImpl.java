package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTitemKindAgriDto;
import com.sinosoft.agriprpall.core.proposalmanage.dao.PrpTitemKindAgriDao;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTitemKindAgri;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTitemKindAgriKey;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTitemKindAgriService;
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
 * @description 农险标的信息表Core接口实现
 */
@Service
public class PrpTitemKindAgriServiceImpl extends BaseServiceImpl implements PrpTitemKindAgriService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpTitemKindAgriServiceImpl.class);
    
    @Autowired
    private PrpTitemKindAgriDao prpTitemKindAgriDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpTitemKindAgriDto prpTitemKindAgriDto) {
        PrpTitemKindAgri prpTitemKindAgri = this.convert(prpTitemKindAgriDto, PrpTitemKindAgri.class);
        prpTitemKindAgriDao.save(prpTitemKindAgri);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String proposalNo,Integer itemKindNo,String kindCode,Integer times) {
        PrpTitemKindAgriKey prpTitemKindAgriKey = new PrpTitemKindAgriKey(proposalNo,itemKindNo,kindCode,times);
        prpTitemKindAgriDao.delete(prpTitemKindAgriKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpTitemKindAgriDto prpTitemKindAgriDto) {
        PrpTitemKindAgri prpTitemKindAgri = this.convert(prpTitemKindAgriDto, PrpTitemKindAgri.class);
        prpTitemKindAgriDao.save(prpTitemKindAgri);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpTitemKindAgriDto queryByPK(String proposalNo,Integer itemKindNo,String kindCode,Integer times) {
        PrpTitemKindAgriKey prpTitemKindAgriKey = new PrpTitemKindAgriKey(proposalNo,itemKindNo,kindCode,times);
        PrpTitemKindAgri prpTitemKindAgri = prpTitemKindAgriDao.findOne(prpTitemKindAgriKey);
        return this.convert(prpTitemKindAgri,PrpTitemKindAgriDto.class);
    }
}