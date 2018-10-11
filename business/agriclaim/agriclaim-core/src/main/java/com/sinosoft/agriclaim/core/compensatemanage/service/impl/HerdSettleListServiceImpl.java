package com.sinosoft.agriclaim.core.compensatemanage.service.impl;

import com.sinosoft.agriclaim.api.compensatemanage.dto.HerdSettleListDto;
import com.sinosoft.agriclaim.core.compensatemanage.dao.HerdSettleListDao;
import com.sinosoft.agriclaim.core.compensatemanage.entity.HerdSettleList;
import com.sinosoft.agriclaim.core.compensatemanage.entity.HerdSettleListKey;
import com.sinosoft.agriclaim.core.compensatemanage.service.HerdSettleListService;
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
 * @time  2017-11-08 05:40:44.225 
 * @description 养殖险理赔明细表Core接口实现
 */
@Service
public class HerdSettleListServiceImpl extends BaseServiceImpl implements HerdSettleListService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(HerdSettleListServiceImpl.class);
    
    @Autowired
    private HerdSettleListDao herdSettleListDao;

    /**
     *@description 新增
     *@param
     */
    public void save(HerdSettleListDto herdSettleListDto) {
        HerdSettleList herdSettleList = this.convert(herdSettleListDto, HerdSettleList.class);
        herdSettleListDao.save(herdSettleList);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String settlelistCode,String earlabel,String fCode,String kindCode,java.lang.Integer serialNo) {
        HerdSettleListKey herdSettleListKey = new HerdSettleListKey(settlelistCode,earlabel,fCode,kindCode,serialNo);
        herdSettleListDao.delete(herdSettleListKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(HerdSettleListDto herdSettleListDto) {
        HerdSettleList herdSettleList = this.convert(herdSettleListDto, HerdSettleList.class);
        herdSettleListDao.save(herdSettleList);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public HerdSettleListDto queryByPK(String settlelistCode,String earlabel,String fCode,String kindCode,java.lang.Integer serialNo) {
        HerdSettleListKey herdSettleListKey = new HerdSettleListKey(settlelistCode,earlabel,fCode,kindCode,serialNo);
        HerdSettleList herdSettleList = herdSettleListDao.findOne(herdSettleListKey);
        return this.convert(herdSettleList,HerdSettleListDto.class);
    }
}