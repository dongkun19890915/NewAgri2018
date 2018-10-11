package com.sinosoft.txnlist.core.insuremainlist.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.txnlist.api.insuremainlist.dto.CMPManFieldListDto;
import com.sinosoft.txnlist.core.insuremainlist.dao.CMPManFieldListDao;
import com.sinosoft.txnlist.core.insuremainlist.entity.CMPManFieldList;
import com.sinosoft.txnlist.core.insuremainlist.entity.CMPManFieldListKey;
import com.sinosoft.txnlist.core.insuremainlist.service.CMPManFieldListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2018-04-16 10:32:04.893
 * @description 草莓组合险连带被保险人表3Core接口实现
 */
@Service
public class CMPManFieldListServiceImpl extends BaseServiceImpl implements CMPManFieldListService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CMPManFieldListServiceImpl.class);

    @Autowired
    private CMPManFieldListDao cMPManFieldListDao;

    /**
     * @param
     * @description 新增
     */
    public void save(CMPManFieldListDto cMPManFieldListDto) {
        CMPManFieldList cMPManFieldList = this.convert(cMPManFieldListDto, CMPManFieldList.class);
        cMPManFieldListDao.save(cMPManFieldList);
    }

    /**
     * @param
     * @description 删除
     */
    public void remove(String insureListCode, String fCode, String itemCode, String idCard, String kindCode) {
        CMPManFieldListKey cMPManFieldListKey = new CMPManFieldListKey(insureListCode, fCode, itemCode, idCard, kindCode);
        cMPManFieldListDao.delete(cMPManFieldListKey);
    }

    /**
     * @param
     * @description 修改
     */
    public void modify(CMPManFieldListDto cMPManFieldListDto) {
        CMPManFieldList cMPManFieldList = this.convert(cMPManFieldListDto, CMPManFieldList.class);
        cMPManFieldListDao.save(cMPManFieldList);
    }

    /**
     * @param
     * @description 按主键查询实体
     */
    public CMPManFieldListDto queryByPK(String insureListCode, String fCode, String itemCode, String idCard, String kindCode) {
        CMPManFieldListKey cMPManFieldListKey = new CMPManFieldListKey(insureListCode, fCode, itemCode, idCard, kindCode);
        CMPManFieldList cMPManFieldList = cMPManFieldListDao.findOne(cMPManFieldListKey);
        return this.convert(cMPManFieldList, CMPManFieldListDto.class);
    }
}