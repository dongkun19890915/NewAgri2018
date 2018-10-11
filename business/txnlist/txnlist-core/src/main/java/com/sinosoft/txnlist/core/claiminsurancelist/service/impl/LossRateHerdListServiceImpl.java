package com.sinosoft.txnlist.core.claiminsurancelist.service.impl;

import com.sinosoft.txnlist.api.claiminsurancelist.dto.LossRateHerdListDto;
import com.sinosoft.txnlist.core.claiminsurancelist.dao.LossRateHerdListDao;
import com.sinosoft.txnlist.core.claiminsurancelist.entity.LossRateHerdList;
import com.sinosoft.txnlist.core.claiminsurancelist.entity.LossRateHerdListKey;
import com.sinosoft.txnlist.core.claiminsurancelist.service.LossRateHerdListService;
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
 * @description 定损清单农户标的明细表-物Core接口实现
 */
@Service
public class LossRateHerdListServiceImpl extends BaseServiceImpl implements LossRateHerdListService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(LossRateHerdListServiceImpl.class);
    
    @Autowired
    private LossRateHerdListDao lossRateHerdListDao;

    /**
     *@description 新增
     *@param
     */
    public void save(LossRateHerdListDto lossRateHerdListDto) {
        LossRateHerdList lossRateHerdList = this.convert(lossRateHerdListDto, LossRateHerdList.class);
        lossRateHerdListDao.save(lossRateHerdList);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String lossListCode,java.lang.Integer serialNo,String fCode,String itemCode,java.lang.Integer lossSerialNo,String earLabel) {
        LossRateHerdListKey lossRateHerdListKey = new LossRateHerdListKey(lossListCode,serialNo,fCode,itemCode,lossSerialNo,earLabel);
        lossRateHerdListDao.delete(lossRateHerdListKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(LossRateHerdListDto lossRateHerdListDto) {
        LossRateHerdList lossRateHerdList = this.convert(lossRateHerdListDto, LossRateHerdList.class);
        lossRateHerdListDao.save(lossRateHerdList);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public LossRateHerdListDto queryByPK(String lossListCode,java.lang.Integer serialNo,String fCode,String itemCode,java.lang.Integer lossSerialNo,String earLabel) {
        LossRateHerdListKey lossRateHerdListKey = new LossRateHerdListKey(lossListCode,serialNo,fCode,itemCode,lossSerialNo,earLabel);
        LossRateHerdList lossRateHerdList = lossRateHerdListDao.findOne(lossRateHerdListKey);
        return this.convert(lossRateHerdList,LossRateHerdListDto.class);
    }
    /**
     * 根据清单号和序列号查询清单信息集合
     * @param lossListCode 清单号
     * @param serialNo 序列号
     * @return List<LossRateHerdListDto>
     * @author 王心洋
     * @time 2018-01-19
     */
    public List<LossRateHerdListDto> queryBylossListCodeAndSerialNo(String lossListCode,Integer serialNo) {
        List<LossRateHerdList> lossRateHerdListList = lossRateHerdListDao.queryBylossListCodeAndSerialNo(lossListCode,serialNo);
        List<LossRateHerdListDto> lossRateHerdListDtoList = new ArrayList<>();
        this.convertCollection(lossRateHerdListList,lossRateHerdListDtoList,LossRateHerdListDto.class);
        return lossRateHerdListDtoList;
    }
}