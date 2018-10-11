package com.sinosoft.pms.core.kernel.service.impl;

import com.sinosoft.framework.agri.core.constant.LanguageFlagConstant;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.pms.api.kernel.dto.PrpDkindAgriDto;
import com.sinosoft.pms.core.kernel.dao.PrpDkindAgriDao;
import com.sinosoft.pms.core.kernel.entity.PrpDkindAgri;
import com.sinosoft.pms.core.kernel.entity.PrpDkindAgriKey;
import com.sinosoft.pms.core.kernel.entity.PrpDrisk;
import com.sinosoft.pms.core.kernel.entity.PrpDriskKey;
import com.sinosoft.pms.core.kernel.service.PrpDkindAgriService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:50.124 
 * @description 责任定义表Core接口实现
 */
@Service
public class PrpDkindAgriServiceImpl extends BaseServiceImpl implements PrpDkindAgriService {
    @Autowired
    private PrpDkindAgriDao prpDkindAgriDao;
    @PersistenceContext
    private EntityManager entityManager;
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpDkindAgriServiceImpl.class);

    /**
     *@description 新增
     *@param
     */
    @Override
    public void save(PrpDkindAgriDto prpDkindAgriDto) {
        PrpDkindAgri prpDkindAgri = this.convert(prpDkindAgriDto, PrpDkindAgri.class);
        prpDkindAgriDao.save(prpDkindAgri);
    }
    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(String riskCode,String kindCode) {
        PrpDkindAgriKey prpDkindAgriKey = new PrpDkindAgriKey(riskCode,kindCode);
        prpDkindAgriDao.delete(prpDkindAgriKey);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(PrpDkindAgriDto prpDkindAgriDto) {
        PrpDkindAgri prpDkindAgri = this.convert(prpDkindAgriDto, PrpDkindAgri.class);
        prpDkindAgriDao.save(prpDkindAgri);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpDkindAgriDto queryByPK(String riskCode,String kindCode) {
        PrpDkindAgriKey prpDkindAgriKey = new PrpDkindAgriKey(riskCode,kindCode);
        PrpDkindAgri prpDkindAgri = prpDkindAgriDao.findOne(prpDkindAgriKey);
        return this.convert(prpDkindAgri,PrpDkindAgriDto.class);

    }

    /**
     * 根据riskCode查询prpdkind表
     * @author: 何伟东
     * @date: 2017/10/31 16:28
     * @param riskCode 险种代码
     * @return
     */
    @Override
    public List<PrpDkindAgriDto> queryByRiskCode(String riskCode) {
        List<PrpDkindAgri> prpDkindList = prpDkindAgriDao.findByRiskCode(riskCode);
        List<PrpDkindAgriDto> prpDkindDtoList = new ArrayList<>();
        convertCollection(prpDkindList,prpDkindDtoList,PrpDkindAgriDto.class);
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
    public List<PrpDkindAgriDto> queryKindCodeInfo(String riskCode, String kindCName, String codeType) throws Exception {
        if (StringUtils.isEmpty(riskCode)){
            throw new DataVerifyException("险种代码不能为空");
        }
        if (StringUtils.isEmpty(codeType)){
            throw new DataVerifyException("险别类型不能为空");
        }
        StringBuilder dataSql = new StringBuilder("select pk from PrpDkindAgri pk where ");
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
        List<PrpDkindAgri> prpDkindList = dataQuery.getResultList();
        List<PrpDkindAgriDto> prpDkindDtoList = new ArrayList<>();
        convertCollection(prpDkindList,prpDkindDtoList,PrpDkindAgriDto.class);
        return prpDkindDtoList;
    }

    /**
     * （根据险别代码查询prpdkindagri表返回中文或英文名称）
     * @author: 刘曼曼
     * @date: 2018/1/22 15:47
     * @param riskCode 险种代码
     * @param isChinese 中文标识
     * @return 中文或英文名称
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String translateCode(String kindCode,String riskCode, String isChinese) throws Exception{
        if(StringUtils.isEmpty(riskCode)){
            throw new DataVerifyException("险种代码不能为空");
        }
        if(StringUtils.isEmpty(kindCode)){
            throw new DataVerifyException("险别代码不能为空");
        }
        PrpDkindAgriKey prpDkindAgriKey = new PrpDkindAgriKey(riskCode,kindCode);
        PrpDkindAgri prpDkindAgri  = prpDkindAgriDao.findOne(prpDkindAgriKey);
        if(prpDkindAgri != null) {
            if (LanguageFlagConstant.CHINESE.equals(isChinese)) {//isChinese是true则返回中文名称否则返回英文名称
                return prpDkindAgri.getKindCName();
            } else {
                if ("".equals(prpDkindAgri.getKindEName()) || prpDkindAgri.getKindEName() == null) {//如果英文名称为空则返回中文名称
                    return prpDkindAgri.getKindCName();
                } else {
                    return prpDkindAgri.getKindEName();
                }
            }
        }
        return " ";
    }
}