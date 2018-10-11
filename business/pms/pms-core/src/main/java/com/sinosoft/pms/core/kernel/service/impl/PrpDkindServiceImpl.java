package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.pms.api.kernel.dto.PrpDkindDto;
import com.sinosoft.pms.core.kernel.dao.PrpDkindDao;
import com.sinosoft.pms.core.kernel.entity.PrpDkind;
import com.sinosoft.pms.core.kernel.entity.PrpDkindKey;
import com.sinosoft.pms.core.kernel.service.PrpDkindService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124
 * @description 责任定义表Core接口实现
 */
@Service
public class PrpDkindServiceImpl extends BaseServiceImpl implements PrpDkindService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDkindServiceImpl.class);

    @Autowired
    private PrpDkindDao prpDkindDao;
    @PersistenceContext
    private EntityManager entityManager;
    /**
     *@description 新增
     *@param
     */
    @Override
    public void save(PrpDkindDto prpDkindDto) {
        PrpDkind prpDkind = this.convert(prpDkindDto, PrpDkind.class);
        prpDkindDao.save(prpDkind);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(String riskCode,String kindCode) {
        PrpDkindKey prpDkindKey = new PrpDkindKey(riskCode,kindCode);
        prpDkindDao.delete(prpDkindKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(PrpDkindDto prpDkindDto) {
        PrpDkind prpDkind = this.convert(prpDkindDto, PrpDkind.class);
        prpDkindDao.save(prpDkind);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    @Override
    public PrpDkindDto queryByPK(String riskCode,String kindCode) {
        PrpDkindKey prpDkindKey = new PrpDkindKey(riskCode,kindCode);
        PrpDkind prpDkind = prpDkindDao.findOne(prpDkindKey);
        return this.convert(prpDkind,PrpDkindDto.class);
    }

    /**
     * 根据riskCode查询prpdkind表
     * @author: 何伟东
     * @date: 2017/10/31 16:28
     * @param riskCode 险种代码
     * @return
     */
    @Override
    public List<PrpDkindDto> queryByRiskCode(String riskCode) {
        List<PrpDkind> prpDkindList = prpDkindDao.findByRiskCode(riskCode);
        List<PrpDkindDto> prpDkindDtoList = new ArrayList<>();
        convertCollection(prpDkindList,prpDkindDtoList,PrpDkindDto.class);
        return prpDkindDtoList;
    }

    /**
     * 查询主险附加险别信息
     * @author: 何伟东
     * @date: 2017/11/4 16:04
     * @param riskCode 险种代码
     * @param kindCName 险种中文名称
     * @param codeType 险别类型1主险2附加险
     * @return
     */
    @Override
    public List<PrpDkindDto> queryKindCodeInfo(String riskCode, String kindCName, String codeType) throws Exception {
        if (StringUtils.isEmpty(riskCode)){
            throw new DataVerifyException("险种代码不能为空");
        }
        if (StringUtils.isEmpty(codeType)){
            throw new DataVerifyException("险别类型不能为空");
        }
        StringBuilder dataSql = new StringBuilder("select pk from PrpDkind pk where ");
        dataSql.append("pk.riskCode = '").append(riskCode).append("' ");
        dataSql.append("and substr(pk.calculateFlag,3,1) = :codeType ");
        if(StringUtils.isNotEmpty(kindCName)){
            dataSql.append("and pk.kindCName like :kindCName ");
        }
        Query dataQuery = entityManager.createQuery(dataSql.toString());
        dataQuery.setParameter("codeType",codeType);
        if(StringUtils.isNotEmpty(kindCName)){
            dataQuery.setParameter("kindCName","%"+kindCName+"%");
        }
        List<PrpDkind> prpDkindList = dataQuery.getResultList();
        List<PrpDkindDto> prpDkindDtoList = new ArrayList<>();
        convertCollection(prpDkindList,prpDkindDtoList,PrpDkindDto.class);
        return prpDkindDtoList;
    }

    /**
     * 根据多个险别序号查询该险种下的险别信息
     *
     * @param riskCode  险种代码
     * @param kindCodes 险别代码集合（list）
     * @return 险别代码-险别中文名称
     * @author: 何伟东
     * @date: 2018/1/11 18:01
     */
    @Override
    public Map<String, String> queryByKindCodes(String riskCode, List<String> kindCodes) throws Exception {
        if (StringUtils.isEmpty(riskCode)) {
            throw new DataVerifyException("险种代码不能为空");
        }
        if (kindCodes == null || kindCodes.size() < 1) {
            throw new DataVerifyException("条款代码不能为空");
        }
        List<PrpDkind> prpDkinds = prpDkindDao.findBykindCodes(riskCode, kindCodes);
        Map<String, String> returnMap = new HashMap<>();
        prpDkinds.forEach(prpDkind -> returnMap.put(prpDkind.getKindCode(), prpDkind.getKindCName()));
        return returnMap;
    }
}