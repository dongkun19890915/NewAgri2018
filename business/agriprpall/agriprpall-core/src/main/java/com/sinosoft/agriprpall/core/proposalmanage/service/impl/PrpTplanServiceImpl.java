package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTplanDto;
import com.sinosoft.agriprpall.core.proposalmanage.dao.PrpTplanDao;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTplan;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTplanKey;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTplanService;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.DataVerifyException;
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
 * @description 收费计划表Core接口实现
 */
@Service
public class PrpTplanServiceImpl extends BaseServiceImpl implements PrpTplanService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpTplanServiceImpl.class);
    
    @Autowired
    private PrpTplanDao prpTplanDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpTplanDto prpTplanDto) {
        PrpTplan prpTplan = this.convert(prpTplanDto, PrpTplan.class);
        prpTplanDao.save(prpTplan);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String proposalNo,Integer serialNo) {
        PrpTplanKey prpTplanKey = new PrpTplanKey(proposalNo,serialNo);
        prpTplanDao.delete(prpTplanKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpTplanDto prpTplanDto) {
        PrpTplan prpTplan = this.convert(prpTplanDto, PrpTplan.class);
        prpTplanDao.save(prpTplan);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpTplanDto queryByPK(String proposalNo,Integer serialNo) {
        PrpTplanKey prpTplanKey = new PrpTplanKey(proposalNo,serialNo);
        PrpTplan prpTplan = prpTplanDao.findOne(prpTplanKey);
        return this.convert(prpTplan,PrpTplanDto.class);
    }

    /**
     *  根据投保单号查询prpTplan 收费计划表详细信息
     * @author: 田慧
     * @date: 2017/11/20 9:32
     * @param proposalNo 投保单号
     * @return prpTplanDtoList  返回收费计划表Dto集合
     */
    @Override
    public List<PrpTplanDto> queryByProposalNo(String proposalNo)throws Exception{
        if (StringUtils.isEmpty(proposalNo)) {
            throw new DataVerifyException("投保单号不能为空");
        }
        proposalNo = "%" + proposalNo + "%";
        List<PrpTplan> prpTplanList = prpTplanDao.findByProposalNoLike(proposalNo);
        List<PrpTplanDto> prpTplanDtoList = new ArrayList<PrpTplanDto>();
        this.convertCollection(prpTplanList, prpTplanDtoList, PrpTplanDto.class);
        return prpTplanDtoList;

    }
}