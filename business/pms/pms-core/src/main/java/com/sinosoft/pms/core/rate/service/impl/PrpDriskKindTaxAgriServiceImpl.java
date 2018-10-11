package com.sinosoft.pms.core.rate.service.impl;

import com.sinosoft.framework.agri.core.service.impl.BaseCustomServiceImpl;
import com.sinosoft.ims.api.kernel.CompanyApi;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.pms.api.rate.dto.PrpDriskKindTaxAgriDto;
import com.sinosoft.pms.core.rate.dao.PrpDriskKindTaxAgriDao;
import com.sinosoft.pms.core.rate.entity.PrpDriskKindTaxAgri;
import com.sinosoft.pms.core.rate.entity.PrpDriskKindTaxAgriKey;
import com.sinosoft.pms.core.rate.service.PrpDriskKindTaxAgriService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-29 07:14:25.063 
 * @description 险种险别增值税基础税率配置表Core接口实现
 */
@Service
@Transactional
public class PrpDriskKindTaxAgriServiceImpl extends BaseCustomServiceImpl implements PrpDriskKindTaxAgriService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDriskKindTaxAgriServiceImpl.class);

   @Autowired
   private PrpDriskKindTaxAgriDao prpDriskKindTaxAgriDao;
   @PersistenceContext
   private EntityManager entityManager;
   @Autowired
   private CompanyApi companyApi;
    /**
     *@description 新增
     *@param
     */
    @Override
    public void save(PrpDriskKindTaxAgriDto prpDriskKindTaxAgriDto) {
        PrpDriskKindTaxAgri prpDriskKindTaxAgri = this.convert(prpDriskKindTaxAgriDto, PrpDriskKindTaxAgri.class);
        prpDriskKindTaxAgriDao.save(prpDriskKindTaxAgri);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(Integer uuid) {
        PrpDriskKindTaxAgriKey prpDriskKindTaxAgriKey = new PrpDriskKindTaxAgriKey(uuid);
        prpDriskKindTaxAgriDao.delete(prpDriskKindTaxAgriKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(PrpDriskKindTaxAgriDto prpDriskKindTaxAgriDto) {
        PrpDriskKindTaxAgri prpDriskKindTaxAgri = this.convert(prpDriskKindTaxAgriDto, PrpDriskKindTaxAgri.class);
        prpDriskKindTaxAgriDao.save(prpDriskKindTaxAgri);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    @Override
    public PrpDriskKindTaxAgriDto queryByPK(Integer uuid) {
        PrpDriskKindTaxAgriKey prpDriskKindTaxAgriKey = new PrpDriskKindTaxAgriKey(uuid);
        PrpDriskKindTaxAgri prpDriskKindTaxAgri= prpDriskKindTaxAgriDao.findOne(prpDriskKindTaxAgriKey);
        return this.convert(prpDriskKindTaxAgri,PrpDriskKindTaxAgriDto.class);
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
    public PrpDriskKindTaxAgriDto findTaxRateByLowerComcodeToUpper(PrpDriskKindTaxAgriDto prpDriskKindTaxAgriDto) throws Exception {
        LOGGER.error("价税分离，税率查询入参{}",prpDriskKindTaxAgriDto);
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
        StringBuffer sql = new StringBuffer("SELECT p FROM PrpDriskKindTaxAgri p WHERE ");
        sql.append(" p.validStatus = '1' ");
        sql.append(" and p.comCode = :comCode");
        map.put("comCode",prpDriskKindTaxAgriDto.getComCode());
        sql.append(" and p.riskCode =:riskCode");
        map.put("riskCode",prpDriskKindTaxAgriDto.getRiskCode());
        sql.append(" and p.taxRateType =:taxRateType");
        map.put("taxRateType",prpDriskKindTaxAgriDto.getTaxRateType());
        sql.append(" and p.validDate <=:validDate");
        map.put("validDate",prpDriskKindTaxAgriDto.getValidDate());
        Query dataQuery= entityManager.createQuery(sql.toString());
        this.setQueryParam(dataQuery,map);
        List<PrpDriskKindTaxAgri> prpDriskKindTaxList = dataQuery.getResultList();
        if (prpDriskKindTaxList != null && prpDriskKindTaxList.size() > 0) {
            return this.convert(prpDriskKindTaxList.get(0),PrpDriskKindTaxAgriDto.class);
        }
        String comCode=prpDriskKindTaxAgriDto.getComCode();
        PrpDcompanyDto prpDcompanyDto=companyApi.queryCompanyByComCode(prpDriskKindTaxAgriDto.getComCode());
        comCode=prpDcompanyDto.getUpperComCode();
        if(prpDcompanyDto.getComCode().equals(comCode)) {
            //上级代码和本级代码相等，不在查询
            return null;
        }
        prpDriskKindTaxAgriDto.setComCode(comCode);
        return findTaxRateByLowerComcodeToUpper(prpDriskKindTaxAgriDto);
    }

}