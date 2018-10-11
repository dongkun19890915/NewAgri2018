package com.sinosoft.pms.core.rate.service.impl;

import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.ims.api.kernel.CompanyApi;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.pms.api.rate.dto.PrpDriskKindTaxDto;
import com.sinosoft.pms.core.rate.dao.PrpDriskKindTaxDao;
import com.sinosoft.pms.core.rate.entity.PrpDriskKindTax;
import com.sinosoft.pms.core.rate.entity.PrpDriskKindTaxKey;
import com.sinosoft.pms.core.rate.service.PrpDriskKindTaxService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-29 07:14:25.063 
 * @description 险种险别增值税基础税率配置表Core接口实现
 */
@Service
@Transactional
public class PrpDriskKindTaxServiceImpl extends BaseCustomServiceImpl implements PrpDriskKindTaxService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDriskKindTaxServiceImpl.class);

    @Autowired
    private PrpDriskKindTaxDao prpDriskKindTaxDao;
    @Autowired
    private CompanyApi companyApi;
    @PersistenceContext
    private EntityManager entityManager;
    /**
     *@description 新增
     *@param
     */
    @Override
    public void save(PrpDriskKindTaxDto prpDriskKindTaxDto) {
        PrpDriskKindTax prpDriskKindTax = this.convert(prpDriskKindTaxDto, PrpDriskKindTax.class);
        prpDriskKindTaxDao.save(prpDriskKindTax);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(java.lang.Integer uuid) {
        PrpDriskKindTaxKey prpDriskKindTaxKey = new PrpDriskKindTaxKey(uuid);
        prpDriskKindTaxDao.delete(prpDriskKindTaxKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(PrpDriskKindTaxDto prpDriskKindTaxDto) {
        PrpDriskKindTax prpDriskKindTax = this.convert(prpDriskKindTaxDto, PrpDriskKindTax.class);
        prpDriskKindTaxDao.save(prpDriskKindTax);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpDriskKindTaxDto queryByPK(java.lang.Integer uuid) {
        PrpDriskKindTaxKey prpDriskKindTaxKey = new PrpDriskKindTaxKey(uuid);
        PrpDriskKindTax prpDriskKindTax = prpDriskKindTaxDao.findOne(prpDriskKindTaxKey);
        return this.convert(prpDriskKindTax,PrpDriskKindTaxDto.class);
    }

    /**
     *  递归方法，根据机构代码向上获取税率信息
     * @author: 田健
     * @date: 2017/12/25 10:16
     * @param prpDriskKindTaxDto Comcode  归属机构;Riskcode  险种; Kindcode  险别; TaxType  税率类型 1、保费税率；2、退保手续费税率；3、共保出单费税率；4、投资金退保手续费；9、手续费税率 如果传""则默认为1、保费税率;validDate 当前日期
     * @return  险种险别增值税基础税率配置表信息
     * @throws Exception
     */
    @Override
    public PrpDriskKindTaxDto findTaxRateByLowerComcodeToUpper(PrpDriskKindTaxDto prpDriskKindTaxDto) throws Exception {
        LOGGER.error("价税分离，税率查询入参{}",prpDriskKindTaxDto);
//        List<PrpDriskKindTax> prpDriskKindTaxList = prpDriskKindTaxDao.findAll(
//                Specifications.<PrpDriskKindTax>and()
//                        .eq("comCode", prpDriskKindTaxDto.getComCode())
//                        .eq("riskCode", prpDriskKindTaxDto.getRiskCode())
//                        .eq("taxRateType", prpDriskKindTaxDto.getTaxRateType())
//                        .eq("validStatus", "1")
//                        .eq(StringUtils.isNotEmpty(prpDriskKindTaxDto.getKindCode()), "kindCode", prpDriskKindTaxDto.getKindCode())
//                        //.le((prpDriskKindTaxDto.getValidDate() != null),"validDate", prpDriskKindTaxDto.getValidDate())
//                        .le(" validDate <= TO_DATE('" + prpDriskKindTaxDto.getValidDate() + "','yyyy-mm-dd') ",prpDriskKindTaxDto.getValidDate())
//                        .build());
        Map<String,Object> map = new HashMap<>();
        StringBuffer sql = new StringBuffer("SELECT p FROM PrpDriskKindTax p WHERE ");
        sql.append(" p.validStatus = '1' ");
        sql.append(" and p.comCode = :comCode");
        map.put("comCode",prpDriskKindTaxDto.getComCode());
        sql.append(" and p.riskCode =:riskCode");
        map.put("riskCode",prpDriskKindTaxDto.getRiskCode());
        sql.append(" and p.taxRateType =:taxRateType");
        map.put("taxRateType",prpDriskKindTaxDto.getTaxRateType());
        sql.append(" and p.validDate <=:validDate");
        map.put("validDate",prpDriskKindTaxDto.getValidDate());
        Query dataQuery= entityManager.createQuery(sql.toString());
        this.setQueryParam(dataQuery,map);
        List<PrpDriskKindTax> prpDriskKindTaxList = dataQuery.getResultList();
        if (prpDriskKindTaxList != null && prpDriskKindTaxList.size() > 0) {
            return this.convert(prpDriskKindTaxList.get(0),PrpDriskKindTaxDto.class);
        }
        String comCode=prpDriskKindTaxDto.getComCode();
        PrpDcompanyDto prpDcompanyDto=companyApi.queryCompanyByComCode(prpDriskKindTaxDto.getComCode());
        comCode=prpDcompanyDto.getUpperComCode();
        if(prpDcompanyDto.getComCode().equals(comCode)) {
            //上级代码和本级代码相等，不在查询
            return null;
        }
        prpDriskKindTaxDto.setComCode(comCode);
        return findTaxRateByLowerComcodeToUpper(prpDriskKindTaxDto);
    }
}