package com.sinosoft.txnlist.core.insuremainlist.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.txnlist.api.insuremainlist.dto.CMCManFieldListDto;
import com.sinosoft.txnlist.core.insuremainlist.dao.CMCManFieldListDao;
import com.sinosoft.txnlist.core.insuremainlist.entity.CMCManFieldList;
import com.sinosoft.txnlist.core.insuremainlist.entity.CMCManFieldListKey;
import com.sinosoft.txnlist.core.insuremainlist.service.CMCManFieldListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2018-04-16 10:32:04.893
 * @description 草莓组合险连带被保险人表1Core接口实现
 */
@Service
public class CMCManFieldListServiceImpl extends BaseServiceImpl implements CMCManFieldListService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CMCManFieldListServiceImpl.class);

    @Autowired
    private CMCManFieldListDao cMCManFieldListDao;

    /**
     * @param
     * @description 新增
     */
    public void save(CMCManFieldListDto cMCManFieldListDto) {
        CMCManFieldList cMCManFieldList = this.convert(cMCManFieldListDto, CMCManFieldList.class);
        cMCManFieldListDao.save(cMCManFieldList);
    }

    /**
     * @param
     * @description 删除
     */
    public void remove(String insureListCode, String fCode, String itemCode, String idCard, String kindCode) {
        CMCManFieldListKey cMCManFieldListKey = new CMCManFieldListKey(insureListCode, fCode, itemCode, idCard, kindCode);
        cMCManFieldListDao.delete(cMCManFieldListKey);
    }

    /**
     * @param
     * @description 修改
     */
    public void modify(CMCManFieldListDto cMCManFieldListDto) {
        CMCManFieldList cMCManFieldList = this.convert(cMCManFieldListDto, CMCManFieldList.class);
        cMCManFieldListDao.save(cMCManFieldList);
    }

    /**
     * @param
     * @description 按主键查询实体
     */
    public CMCManFieldListDto queryByPK(String insureListCode, String fCode, String itemCode, String idCard, String kindCode) {
        CMCManFieldListKey cMCManFieldListKey = new CMCManFieldListKey(insureListCode, fCode, itemCode, idCard, kindCode);
        CMCManFieldList cMCManFieldList = cMCManFieldListDao.findOne(cMCManFieldListKey);
        return this.convert(cMCManFieldList, CMCManFieldListDto.class);
    }
}