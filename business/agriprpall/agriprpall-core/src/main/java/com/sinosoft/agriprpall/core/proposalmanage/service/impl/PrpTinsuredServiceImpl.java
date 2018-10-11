package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTinsuredDto;
import com.sinosoft.agriprpall.core.proposalmanage.dao.PrpTinsuredDao;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTinsured;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTinsuredKey;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTinsuredService;
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
 * @description 保险关系人表Core接口实现
 */
@Service
public class PrpTinsuredServiceImpl extends BaseServiceImpl implements PrpTinsuredService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpTinsuredServiceImpl.class);
    
    @Autowired
    private PrpTinsuredDao prpTinsuredDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpTinsuredDto prpTinsuredDto) {
        PrpTinsured prpTinsured = this.convert(prpTinsuredDto, PrpTinsured.class);
        prpTinsuredDao.save(prpTinsured);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String proposalNo,Integer serialNo) {
        PrpTinsuredKey prpTinsuredKey = new PrpTinsuredKey(proposalNo,serialNo);
        prpTinsuredDao.delete(prpTinsuredKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpTinsuredDto prpTinsuredDto) {
        PrpTinsured prpTinsured = this.convert(prpTinsuredDto, PrpTinsured.class);
        prpTinsuredDao.save(prpTinsured);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpTinsuredDto queryByPK(String proposalNo,Integer serialNo) {
        PrpTinsuredKey prpTinsuredKey = new PrpTinsuredKey(proposalNo,serialNo);
        PrpTinsured prpTinsured = prpTinsuredDao.findOne(prpTinsuredKey);
        return this.convert(prpTinsured,PrpTinsuredDto.class);
    }
    /**
     *  根据投保单号查询prpTinsured表信息
     * @author: 田慧
     * @date: 2017/11/20 13:37
     * @param proposalNo 投保单号
     * @return  prpTinsuredDtoList 返回PrpTinsuredDto的集合
     * @throws Exception
     */
    @Override
    public List<PrpTinsuredDto> queryByPolicyNo(String proposalNo)throws Exception{
        if (StringUtils.isEmpty(proposalNo)) {
            throw new DataVerifyException("投保单号不能为空");
        }
        proposalNo = "%" + proposalNo + "%";
        List<PrpTinsured> prpTinsuredList = prpTinsuredDao.findByProposalNoLike(proposalNo);
        List<PrpTinsuredDto> prpTinsuredDtoList = new ArrayList<PrpTinsuredDto>();
        this.convertCollection(prpTinsuredList, prpTinsuredDtoList, PrpTinsuredDto.class);
        return prpTinsuredDtoList;
    }

    /**
     *  根据投保单号、关系人标识查询prpTinsured保险关系人表信息
     * @author: 田慧
     * @date: 2017/11/20 13:49
     * @param proposalNo 投保单号
     * @param insuredFlag 关系人标识
     * @return prpTinsuredDtoList 返回保险关系人表Dto的集合
     * @throws Exception
     */
    @Override
    public List<PrpTinsuredDto> queryByCondition(String proposalNo,String insuredFlag) throws Exception{
        if (StringUtils.isEmpty(proposalNo)) {
            throw new DataVerifyException("投保单号不能为空");
        }
        if (StringUtils.isEmpty(insuredFlag)) {
            throw new DataVerifyException("关系人标识不能为空");
        }
        //模糊查询投保单号
        proposalNo = "%" + proposalNo + "%";
        List<PrpTinsured> prpTinsuredList = prpTinsuredDao.queryByCondition(proposalNo, insuredFlag);
        List<PrpTinsuredDto> prpTinsuredDtoList = new ArrayList<PrpTinsuredDto>();
        this.convertCollection(prpTinsuredList, prpTinsuredDtoList, PrpTinsuredDto.class);
        return prpTinsuredDtoList;
    }
}