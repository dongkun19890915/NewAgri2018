package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.pms.api.kernel.dto.PrpDsubsidyDto;
import com.sinosoft.pms.core.kernel.dao.PrpDsubsidyDao;
import com.sinosoft.pms.core.kernel.entity.PrpDsubsidy;
import com.sinosoft.pms.core.kernel.entity.PrpDsubsidyKey;
import com.sinosoft.pms.core.kernel.service.PrpDsubsidyService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * @description PrpDsubsidyCore接口实现
 */
@Service
public class PrpDsubsidyServiceImpl extends BaseServiceImpl implements PrpDsubsidyService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDsubsidyServiceImpl.class);
    
    @Autowired
    private PrpDsubsidyDao prpDsubsidyDao;

    /**
     *@description 新增
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(PrpDsubsidyDto prpDsubsidyDto) {
        PrpDsubsidy prpDsubsidy = this.convert(prpDsubsidyDto, PrpDsubsidy.class);
        prpDsubsidyDao.save(prpDsubsidy);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(String riskCode,String comCode,String subsidyYear,String validStatus,String subsidyCode,String subsidyType) {
        PrpDsubsidyKey prpDsubsidyKey = new PrpDsubsidyKey(riskCode,comCode,subsidyYear,validStatus,subsidyCode,subsidyType);
        prpDsubsidyDao.delete(prpDsubsidyKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modify(PrpDsubsidyDto prpDsubsidyDto) {
        PrpDsubsidy prpDsubsidy = this.convert(prpDsubsidyDto, PrpDsubsidy.class);
        prpDsubsidyDao.save(prpDsubsidy);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpDsubsidyDto queryByPK(String riskCode,String comCode,String subsidyYear,String validStatus,String subsidyCode,String subsidyType) {
        PrpDsubsidyKey prpDsubsidyKey = new PrpDsubsidyKey(riskCode,comCode,subsidyYear,validStatus,subsidyCode,subsidyType);
        PrpDsubsidy prpDsubsidy = prpDsubsidyDao.findOne(prpDsubsidyKey);
        return this.convert(prpDsubsidy,PrpDsubsidyDto.class);
    }

    /**
     * 根据条件查询PrpDsubsidy补贴信息表信息(此方法只针对3218险种)
     * @author: 田健
     * @date: 2017/12/1 18:41
     * @param riskCode 险种代码
     * @param comCode 归属机构代码
     * @param subsidyYear 年份
     * @return 返回List<PrpDsubsidyDto>补贴信息表信息集合
     * @throws Exception
     */
    @Override
    public List<PrpDsubsidyDto> findPrpDsubsidyDtoListByCondition(String riskCode, String comCode, String subsidyYear) throws Exception {
        if(StringUtils.isEmpty(riskCode)){
            throw new DataVerifyException("险种代码不能为空！");
        }
        if(StringUtils.isEmpty(comCode)){
            throw new DataVerifyException("归属机构代码不能为空！");
        }
        if(StringUtils.isEmpty(subsidyYear)){
            throw new DataVerifyException("年份不能为空！");
        }
        List<PrpDsubsidyDto> prpDsubsidyDtoList = new ArrayList<PrpDsubsidyDto>();
        List<PrpDsubsidy> prpDsubsidyList = prpDsubsidyDao.findPrpDsubsidyDtoListByCondition(riskCode,comCode,subsidyYear);
        convertCollection(prpDsubsidyList,prpDsubsidyDtoList,PrpDsubsidyDto.class);
        return prpDsubsidyDtoList;
    }

}