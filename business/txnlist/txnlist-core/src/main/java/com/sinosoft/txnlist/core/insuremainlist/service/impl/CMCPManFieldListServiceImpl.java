package com.sinosoft.txnlist.core.insuremainlist.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.txnlist.api.insuremainlist.dto.CMCPManFieldListDto;
import com.sinosoft.txnlist.core.insuremainlist.dao.CMCPManFieldListDao;
import com.sinosoft.txnlist.core.insuremainlist.entity.CMCPManFieldList;
import com.sinosoft.txnlist.core.insuremainlist.entity.CMCPManFieldListKey;
import com.sinosoft.txnlist.core.insuremainlist.service.CMCPManFieldListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2018-04-16 10:32:04.893
 * @description 草莓组合险连带被保险人表2Core接口实现
 */
@Service
public class CMCPManFieldListServiceImpl extends BaseServiceImpl implements CMCPManFieldListService {
    /**
     * log日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CMCPManFieldListServiceImpl.class);

    @Autowired
    private CMCPManFieldListDao cMCPManFieldListDao;
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * @param
     * @description 新增
     */
    public void save(CMCPManFieldListDto cMCPManFieldListDto) {
        CMCPManFieldList cMCPManFieldList = this.convert(cMCPManFieldListDto, CMCPManFieldList.class);
        cMCPManFieldListDao.save(cMCPManFieldList);
    }

    /**
     * @param
     * @description 删除
     */
    public void remove(String insureListCode, String fCode, String itemCode, String idCard, String kindCode) {
        CMCPManFieldListKey cMCPManFieldListKey = new CMCPManFieldListKey(insureListCode, fCode, itemCode, idCard, kindCode);
        cMCPManFieldListDao.delete(cMCPManFieldListKey);
    }

    /**
     * @param
     * @description 修改
     */
    public void modify(CMCPManFieldListDto cMCPManFieldListDto) {
        CMCPManFieldList cMCPManFieldList = this.convert(cMCPManFieldListDto, CMCPManFieldList.class);
        cMCPManFieldListDao.save(cMCPManFieldList);
    }

    /**
     * @param
     * @description 按主键查询实体
     */
    public CMCPManFieldListDto queryByPK(String insureListCode, String fCode, String itemCode, String idCard, String kindCode) {
        CMCPManFieldListKey cMCPManFieldListKey = new CMCPManFieldListKey(insureListCode, fCode, itemCode, idCard, kindCode);
        CMCPManFieldList cMCPManFieldList = cMCPManFieldListDao.findOne(cMCPManFieldListKey);
        return this.convert(cMCPManFieldList, CMCPManFieldListDto.class);
    }

    /**
     * mm
     * 批改保存连带被保险人清单转存
     *
     * @param policyNo
     * @return
     */
    @Transactional
    public Boolean insertCMcTOcp(String policyNo) throws Exception {
        String strWhere = " insert into cmcpmanfieldlist c " +
                " (c.insurelistcode, " +
                " c.fCode, " +
                " c.itemCode, " +
                " c.idCard, " +
                " c.kindCode, " +
                " c.idType, " +
                " c.name, " +
                " c.sex, " +
                " c.relation, " +
                " c.industryCategory, " +
                " c.sumAmount, " +
                " c.sumPremium, " +
                " c.rate, " +
                " c.fPremium, " +
                " c.centralPremium, " +
                " c.provincePremium, " +
                " c.cityPremium, " +
                " c.townPremium, " +
                " c.otherPremium " +

                " ) " +
                " select t.insureListCode, " +
                " t.fCode, " +
                " t.itemCode, " +
                " t.idCard, " +
                " t.kindCode, " +
                " t.idType, " +
                " t.name, " +
                " t.sex, " +
                " t.relation, " +
                " t.industryCategory, " +
                " t.sumAmount, " +
                " t.sumPremium, " +
                " t.rate, " +
                " t.fPremium, " +
                " t.centralPremium, " +
                " t.provincePremium, " +
                " t.cityPremium, " +
                " t.townPremium, " +
                " t.otherPremium " +
                " from cmcmanfieldlist t " +
                " where t.insurelistcode in (select p.inusrelistcode " +
                "  from insuremainlist p " +
                " where p.policyNo = '" + policyNo + "') ";
        Query nativeQuery = entityManager.createNativeQuery(strWhere);
        Integer i = (Integer) nativeQuery.executeUpdate();
        Boolean flse = false;
        if (i != null && i > 0) {
            flse = true;
        }
        return flse;
    }
}