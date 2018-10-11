package com.sinosoft.txnlist.core.claiminsurancelist.service.impl;

import com.sinosoft.txnlist.api.claiminsurancelist.dto.LossRatePersListDto;
import com.sinosoft.txnlist.core.claiminsurancelist.dao.LossRatePersListDao;
import com.sinosoft.txnlist.core.claiminsurancelist.entity.LossRatePersList;
import com.sinosoft.txnlist.core.claiminsurancelist.entity.LossRatePersListKey;
import com.sinosoft.txnlist.core.claiminsurancelist.service.LossRatePersListService;
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
 * @description 定损清单农户标的明细表-人Core接口实现
 */
@Service
public class LossRatePersListServiceImpl extends BaseServiceImpl implements LossRatePersListService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(LossRatePersListServiceImpl.class);
    
    @Autowired
    private LossRatePersListDao lossRatePersListDao;

    /**
     *@description 新增
     *@param
     */
    public void save(LossRatePersListDto lossRatePersListDto) {
        LossRatePersList lossRatePersList = this.convert(lossRatePersListDto, LossRatePersList.class);
        lossRatePersListDao.save(lossRatePersList);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String lossListCode,java.lang.Integer serialNo,String fCode,String itemCode,java.lang.Integer lossSerialNo,String idCard) {
        LossRatePersListKey lossRatePersListKey = new LossRatePersListKey(lossListCode,serialNo,fCode,itemCode,lossSerialNo,idCard);
        lossRatePersListDao.delete(lossRatePersListKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(LossRatePersListDto lossRatePersListDto) {
        LossRatePersList lossRatePersList = this.convert(lossRatePersListDto, LossRatePersList.class);
        lossRatePersListDao.save(lossRatePersList);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public LossRatePersListDto queryByPK(String lossListCode,java.lang.Integer serialNo,String fCode,String itemCode,java.lang.Integer lossSerialNo,String idCard) {
        LossRatePersListKey lossRatePersListKey = new LossRatePersListKey(lossListCode,serialNo,fCode,itemCode,lossSerialNo,idCard);
        LossRatePersList lossRatePersList = lossRatePersListDao.findOne(lossRatePersListKey);
        return this.convert(lossRatePersList,LossRatePersListDto.class);
    }
    /**
     * 根据清单号和序列号查询清单信息集合
     * @param lossListCode 清单号
     * @param serialNo 序列号
     * @return List<LossRatePersListDto>
     * @author 王心洋
     * @time 2018-01-19
     */
    public List<LossRatePersListDto> queryBylossListCodeAndSerialNo(String lossListCode,Integer serialNo) {
        List<LossRatePersList> lossRatePersListList = lossRatePersListDao.queryBylossListCodeAndSerialNo(lossListCode,serialNo);
        List<LossRatePersListDto> lossRatePersListDtoList = new ArrayList<>();
        this.convertCollection(lossRatePersListList,lossRatePersListDtoList,LossRatePersListDto.class);
        return lossRatePersListDtoList;
    }
}