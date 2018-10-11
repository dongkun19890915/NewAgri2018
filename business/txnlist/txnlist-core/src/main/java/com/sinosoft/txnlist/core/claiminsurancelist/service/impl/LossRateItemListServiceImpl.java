package com.sinosoft.txnlist.core.claiminsurancelist.service.impl;

import com.sinosoft.txnlist.api.claiminsurancelist.dto.LossRateItemListDto;
import com.sinosoft.txnlist.core.claiminsurancelist.dao.LossRateItemListDao;
import com.sinosoft.txnlist.core.claiminsurancelist.entity.LossRateItemList;
import com.sinosoft.txnlist.core.claiminsurancelist.entity.LossRateItemListKey;
import com.sinosoft.txnlist.core.claiminsurancelist.service.LossRateItemListService;
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
 * @description 定损清单标的表Core接口实现
 */
@Service
public class LossRateItemListServiceImpl extends BaseServiceImpl implements LossRateItemListService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(LossRateItemListServiceImpl.class);
    
    @Autowired
    private LossRateItemListDao lossRateItemListDao;

    /**
     *@description 新增
     *@param
     */
    public void save(LossRateItemListDto lossRateItemListDto) {
        LossRateItemList lossRateItemList = this.convert(lossRateItemListDto, LossRateItemList.class);
        lossRateItemListDao.save(lossRateItemList);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String lossListCode,java.lang.Integer serialNo,String fCode,String itemCode) {
        LossRateItemListKey lossRateItemListKey = new LossRateItemListKey(lossListCode,serialNo,fCode,itemCode);
        lossRateItemListDao.delete(lossRateItemListKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(LossRateItemListDto lossRateItemListDto) {
        LossRateItemList lossRateItemList = this.convert(lossRateItemListDto, LossRateItemList.class);
        lossRateItemListDao.save(lossRateItemList);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public LossRateItemListDto queryByPK(String lossListCode,java.lang.Integer serialNo,String fCode,String itemCode) {
        LossRateItemListKey lossRateItemListKey = new LossRateItemListKey(lossListCode,serialNo,fCode,itemCode);
        LossRateItemList lossRateItemList = lossRateItemListDao.findOne(lossRateItemListKey);
        return this.convert(lossRateItemList,LossRateItemListDto.class);
    }

    /**
     * 根据清单号和序列号查询清单信息集合
     * @param lossListCode 清单号
     * @param serialNo 序列号
     * @return List<LossRateItemListDto>
     * @author 王心洋
     * @time 2018-01-19
     */
    public List<LossRateItemListDto> queryBylossListCodeAndSerialNo(String lossListCode,Integer serialNo) {
        List<LossRateItemList> lossRateItemListList = lossRateItemListDao.queryBylossListCodeAndSerialNo(lossListCode,serialNo);
        List<LossRateItemListDto> lossRateItemListDtoList = new ArrayList<>();
        this.convertCollection(lossRateItemListList,lossRateItemListDtoList,LossRateItemListDto.class);
        return lossRateItemListDtoList;
    }
}