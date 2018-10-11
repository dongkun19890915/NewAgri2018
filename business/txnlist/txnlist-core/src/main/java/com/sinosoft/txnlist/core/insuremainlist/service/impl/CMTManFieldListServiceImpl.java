package com.sinosoft.txnlist.core.insuremainlist.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.txnlist.api.insuremainlist.dto.CMTManFieldListDto;
import com.sinosoft.txnlist.core.insuremainlist.dao.CMTManFieldListDao;
import com.sinosoft.txnlist.core.insuremainlist.entity.CMTManFieldList;
import com.sinosoft.txnlist.core.insuremainlist.entity.CMTManFieldListKey;
import com.sinosoft.txnlist.core.insuremainlist.service.CMTManFieldListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2018-04-16 10:32:04.893
 * @description 草莓组合险连带被保险人表Core接口实现
 */
@Service
public class CMTManFieldListServiceImpl extends BaseServiceImpl implements CMTManFieldListService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CMTManFieldListServiceImpl.class);

    @Autowired
    private CMTManFieldListDao cMTManFieldListDao;

    /**
     * @param
     * @description 新增
     */
    public void save(CMTManFieldListDto cMTManFieldListDto) {
        CMTManFieldList cMTManFieldList = this.convert(cMTManFieldListDto, CMTManFieldList.class);
        cMTManFieldListDao.save(cMTManFieldList);
    }

    /**
     * @param
     * @description 删除
     */
    public void remove(String insureListCode, String fCode, String itemCode, String idCard, String kindCode) {
        CMTManFieldListKey cMTManFieldListKey = new CMTManFieldListKey(insureListCode, fCode, itemCode, idCard, kindCode);
        cMTManFieldListDao.delete(cMTManFieldListKey);
    }

    /**
     * @param
     * @description 修改
     */
    public void modify(CMTManFieldListDto cMTManFieldListDto) {
        CMTManFieldList cMTManFieldList = this.convert(cMTManFieldListDto, CMTManFieldList.class);
        cMTManFieldListDao.save(cMTManFieldList);
    }

    /**
     * @param
     * @description 按主键查询实体
     */
    public CMTManFieldListDto queryByPK(String insureListCode, String fCode, String itemCode, String idCard, String kindCode) {
        CMTManFieldListKey cMTManFieldListKey = new CMTManFieldListKey(insureListCode, fCode, itemCode, idCard, kindCode);
        CMTManFieldList cMTManFieldList = cMTManFieldListDao.findOne(cMTManFieldListKey);
        return this.convert(cMTManFieldList, CMTManFieldListDto.class);
    }
}