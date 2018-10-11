package com.sinosoft.txnlist.core.claiminsurancelist.service.impl;

import com.sinosoft.txnlist.api.claiminsurancelist.dto.LossRateLossListDto;
import com.sinosoft.txnlist.core.claiminsurancelist.dao.LossRateLossListDao;
import com.sinosoft.txnlist.core.claiminsurancelist.entity.LossRateLossList;
import com.sinosoft.txnlist.core.claiminsurancelist.entity.LossRateLossListKey;
import com.sinosoft.txnlist.core.claiminsurancelist.service.LossRateLossListService;
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
 * @time  2018-01-17 06:38:35.329 
 * @description 定损清单农户标的清单表Core接口实现
 */
@Service
public class LossRateLossListServiceImpl extends BaseServiceImpl implements LossRateLossListService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(LossRateLossListServiceImpl.class);
    
    @Autowired
    private LossRateLossListDao lossRateLossListDao;

    /**
     *@description 新增
     *@param
     */
    public void save(LossRateLossListDto lossRateLossListDto) {
        LossRateLossList lossRateLossList = this.convert(lossRateLossListDto, LossRateLossList.class);
        lossRateLossListDao.save(lossRateLossList);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String lossListCode,java.lang.Integer serialNo,String fCode,String itemCode,java.lang.Integer lossSerialNo) {
        LossRateLossListKey lossRateLossListKey = new LossRateLossListKey(lossListCode,serialNo,fCode,itemCode,lossSerialNo);
        lossRateLossListDao.delete(lossRateLossListKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(LossRateLossListDto lossRateLossListDto) {
        LossRateLossList lossRateLossList = this.convert(lossRateLossListDto, LossRateLossList.class);
        lossRateLossListDao.save(lossRateLossList);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public LossRateLossListDto queryByPK(String lossListCode,java.lang.Integer serialNo,String fCode,String itemCode,java.lang.Integer lossSerialNo) {
        LossRateLossListKey lossRateLossListKey = new LossRateLossListKey(lossListCode,serialNo,fCode,itemCode,lossSerialNo);
        LossRateLossList lossRateLossList = lossRateLossListDao.findOne(lossRateLossListKey);
        return this.convert(lossRateLossList,LossRateLossListDto.class);
    }
    /**
     * 根据清单号和序列号查询清单信息集合
     * @param lossListCode 清单号
     * @param serialNo 序列号
     * @return List<LossRateLossListDto>
     * @author 王心洋
     * @time 2018-01-19
     */
    public List<LossRateLossListDto> queryBylossListCodeAndSerialNo(String lossListCode,Integer serialNo) {
        List<LossRateLossList> lossRateLossListList = lossRateLossListDao.queryBylossListCodeAndSerialNo(lossListCode,serialNo);
        List<LossRateLossListDto> lossRateLossListDtoList = new ArrayList<>();
        this.convertCollection(lossRateLossListList,lossRateLossListDtoList,LossRateLossListDto.class);
        return lossRateLossListDtoList;
    }
}