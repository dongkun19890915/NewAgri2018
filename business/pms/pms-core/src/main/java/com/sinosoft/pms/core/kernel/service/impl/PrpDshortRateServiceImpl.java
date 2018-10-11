package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.pms.api.kernel.dto.PrpDshortRateDto;
import com.sinosoft.pms.core.kernel.dao.PrpDshortRateDao;
import com.sinosoft.pms.core.kernel.entity.PrpDshortRate;
import com.sinosoft.pms.core.kernel.entity.PrpDshortRateKey;
import com.sinosoft.pms.core.kernel.service.PrpDshortRateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 短期费率表Core接口实现
 */
@Service
public class PrpDshortRateServiceImpl extends BaseServiceImpl implements PrpDshortRateService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDshortRateServiceImpl.class);
    
    @Autowired
    private PrpDshortRateDao prpDshortRateDao;

    @Autowired
    private EntityManager entityManager;

    /**
     *@description 新增
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(PrpDshortRateDto prpDshortRateDto) {
        PrpDshortRate prpDshortRate = this.convert(prpDshortRateDto, PrpDshortRate.class);
        prpDshortRateDao.save(prpDshortRate);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(String shortRateId,Integer serialno) {
        PrpDshortRateKey prpDshortRateKey = new PrpDshortRateKey(shortRateId,serialno);
        prpDshortRateDao.delete(prpDshortRateKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modify(PrpDshortRateDto prpDshortRateDto) {
        PrpDshortRate prpDshortRate = this.convert(prpDshortRateDto, PrpDshortRate.class);
        prpDshortRateDao.save(prpDshortRate);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PrpDshortRateDto queryByPK(String shortRateId,Integer serialno) {
        PrpDshortRateKey prpDshortRateKey = new PrpDshortRateKey(shortRateId,serialno);
        PrpDshortRate prpDshortRate = prpDshortRateDao.findOne(prpDshortRateKey);
        return this.convert(prpDshortRate,PrpDshortRateDto.class);
    }

    @Override
    public PrpDshortRateDto queryPrpDshortRateDto(String riskCode, Integer months) throws Exception{
        if(StringUtils.isEmpty(riskCode)|| months==null){
            throw new DataVerifyException("参数为空！");
        }
        PrpDshortRate prpDshortRate= prpDshortRateDao.findOne(new PrpDshortRateKey(riskCode,months));
        PrpDshortRateDto prpDshortRateDto=null;
        if(prpDshortRate!=null){
            prpDshortRateDto=this.convert(prpDshortRate,PrpDshortRateDto.class);
        }
        return prpDshortRateDto;
    }

    /**
     * 根据险种和标的代码查询短期费率
     * @author: 刘曼曼
     * @date: 11:28 11:28
     * @param riskCode 险种
     * @param itemCode 标的
     * @return List<PrpDshortRateDto> 短期费率集合
     * @throws Exception
     */
    @Override
    public List<PrpDshortRateDto> queryByRiskCodeAndItemCode(String riskCode, String itemCode) throws Exception{
       if(StringUtils.isEmpty(riskCode)){
           throw new DataVerifyException("险种代码不能为空!");
       }
       //SQl
       StringBuffer dataSql=new StringBuffer("select p from PrpDshortRate p where p.riskCode=:riskCode ");

       //标的代码
       if(StringUtils.isNotEmpty(itemCode)){
            dataSql.append(" and p.flag=:itemCode ");
        }
        dataSql.append(" order by p.months");
        //执行Sql
        Query dataQuery = entityManager.createQuery(dataSql.toString());
        //设置参数
        dataQuery.setParameter("riskCode",riskCode);
        if(StringUtils.isNotEmpty(itemCode)){
            dataQuery.setParameter("itemCode",itemCode);
        }

        //查询结果
        List<PrpDshortRate> prpDshortRateList=dataQuery.getResultList();
        List<PrpDshortRateDto>  prpDshortRateDtoList=new ArrayList<PrpDshortRateDto>();
        this.convertCollection(prpDshortRateList,prpDshortRateDtoList,PrpDshortRateDto.class);

        return prpDshortRateDtoList;
    }

}