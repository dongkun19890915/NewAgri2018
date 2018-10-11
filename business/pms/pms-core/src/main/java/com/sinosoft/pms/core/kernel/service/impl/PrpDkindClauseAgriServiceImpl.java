package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.pms.api.kernel.dto.PrpDkindClauseAgriDto;
import com.sinosoft.pms.core.kernel.dao.PrpDkindClauseAgriDao;
import com.sinosoft.pms.core.kernel.entity.PrpDkindClauseAgri;
import com.sinosoft.pms.core.kernel.entity.PrpDkindClauseAgriKey;
import com.sinosoft.pms.core.kernel.service.PrpDkindClauseAgriService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-04 10:42:46.546 
 * @description PrpDkindClauseCore接口实现
 */
@Service
public class PrpDkindClauseAgriServiceImpl extends BaseServiceImpl implements PrpDkindClauseAgriService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDkindClauseAgriServiceImpl.class);
    
    @Autowired
    private PrpDkindClauseAgriDao prpDkindClauseAgriDao;

    /**
     *@description 新增
     *@param
     */
    @Override
    public void save(PrpDkindClauseAgriDto prpDkindClauseAgriDto) {
        PrpDkindClauseAgri prpDkindClauseAgri = this.convert(prpDkindClauseAgriDto, PrpDkindClauseAgri.class);
        prpDkindClauseAgriDao.save(prpDkindClauseAgri);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(String riskCode,String clauseFlag,String kindCode,String language,String clauseCode) {
        PrpDkindClauseAgriKey prpDkindClauseAgriKey = new PrpDkindClauseAgriKey(riskCode,clauseFlag,kindCode,language,clauseCode);
        prpDkindClauseAgriDao.delete(prpDkindClauseAgriKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(PrpDkindClauseAgriDto prpDkindClauseAgriDto) {
        PrpDkindClauseAgri prpDkindClauseAgri = this.convert(prpDkindClauseAgriDto, PrpDkindClauseAgri.class);
        prpDkindClauseAgriDao.save(prpDkindClauseAgri);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpDkindClauseAgriDto queryByPK(String riskCode,String clauseFlag,String kindCode,String language,String clauseCode) {
        PrpDkindClauseAgriKey prpDkindClauseAgriKey = new PrpDkindClauseAgriKey(riskCode,clauseFlag,kindCode,language,clauseCode);
        PrpDkindClauseAgri prpDkindClauseAgri = prpDkindClauseAgriDao.findOne(prpDkindClauseAgriKey);
        return this.convert(prpDkindClauseAgri,PrpDkindClauseAgriDto.class);
    }
    /**
     * 根据险种代码查询条款代码集合
     * @param riskCode 险种代码
     * @return List<String> 条款代码集合
     * @throws Exception
     */
    @Override
    public List<String> queryClauseCode(String riskCode)throws Exception{
        if(StringUtils.isEmpty(riskCode)){
            throw new DataVerifyException("险种代码不能为空！");
        }
        List<String> clauseCodes=prpDkindClauseAgriDao.findByRiskCode(riskCode);
        return clauseCodes;
    }
}