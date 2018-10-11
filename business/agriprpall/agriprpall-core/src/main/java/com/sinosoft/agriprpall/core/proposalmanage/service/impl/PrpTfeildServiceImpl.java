package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTfeildDto;
import com.sinosoft.agriprpall.core.proposalmanage.dao.PrpTfeildDao;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTfeild;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTfeildKey;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTfeildService;
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
 * @description 大户田块信息Core接口实现
 */
@Service
public class PrpTfeildServiceImpl extends BaseServiceImpl implements PrpTfeildService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpTfeildServiceImpl.class);
    
    @Autowired
    private PrpTfeildDao prpTfeildDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpTfeildDto prpTfeildDto) {
        PrpTfeild prpTfeild = this.convert(prpTfeildDto, PrpTfeild.class);
        prpTfeildDao.save(prpTfeild);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String proposalNo,String feildNo) {
        PrpTfeildKey prpTfeildKey = new PrpTfeildKey(proposalNo,feildNo);
        prpTfeildDao.delete(prpTfeildKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpTfeildDto prpTfeildDto) {
        PrpTfeild prpTfeild = this.convert(prpTfeildDto, PrpTfeild.class);
        prpTfeildDao.save(prpTfeild);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpTfeildDto queryByPK(String proposalNo,String feildNo) {
        PrpTfeildKey prpTfeildKey = new PrpTfeildKey(proposalNo,feildNo);
        PrpTfeild prpTfeild = prpTfeildDao.findOne(prpTfeildKey);
        return this.convert(prpTfeild,PrpTfeildDto.class);
    }
}