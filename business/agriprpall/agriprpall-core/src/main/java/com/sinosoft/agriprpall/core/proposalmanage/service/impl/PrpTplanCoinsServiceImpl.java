package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTplanCoinsDto;
import com.sinosoft.agriprpall.core.proposalmanage.dao.PrpTplanCoinsDao;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTplanCoins;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTplanCoinsKey;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTplanCoinsService;
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
 * @description 共保方收费计划表Core接口实现
 */
@Service
public class PrpTplanCoinsServiceImpl extends BaseServiceImpl implements PrpTplanCoinsService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpTplanCoinsServiceImpl.class);
    
    @Autowired
    private PrpTplanCoinsDao prpTplanCoinsDao;

    /**
     *@description 新增
     *@param
     */
    public void save(PrpTplanCoinsDto prpTplanCoinsDto) {
        PrpTplanCoins prpTplanCoins = this.convert(prpTplanCoinsDto, PrpTplanCoins.class);
        prpTplanCoinsDao.save(prpTplanCoins);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String proposalNo,String coinsCode,Integer serialNo,String payReason) {
        PrpTplanCoinsKey prpTplanCoinsKey = new PrpTplanCoinsKey(proposalNo,coinsCode,serialNo,payReason);
        prpTplanCoinsDao.delete(prpTplanCoinsKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpTplanCoinsDto prpTplanCoinsDto) {
        PrpTplanCoins prpTplanCoins = this.convert(prpTplanCoinsDto, PrpTplanCoins.class);
        prpTplanCoinsDao.save(prpTplanCoins);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpTplanCoinsDto queryByPK(String proposalNo,String coinsCode,Integer serialNo,String payReason) {
        PrpTplanCoinsKey prpTplanCoinsKey = new PrpTplanCoinsKey(proposalNo,coinsCode,serialNo,payReason);
        PrpTplanCoins prpTplanCoins = prpTplanCoinsDao.findOne(prpTplanCoinsKey);
        return this.convert(prpTplanCoins,PrpTplanCoinsDto.class);
    }
}