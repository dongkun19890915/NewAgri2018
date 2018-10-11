package com.sinosoft.agriprpall.core.policymanage.service.impl;

import com.sinosoft.agriprpall.api.policymanage.dto.*;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCexpenseOriginDao;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCmainOriginDao;
import com.sinosoft.agriprpall.core.policymanage.entity.*;
import com.sinosoft.agriprpall.core.policymanage.service.PolicyOriginService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * 原始保单大对象
 * @author: 钱浩
 * @date: 2017/11/23 下午 17:26
 */
@Service
public class PolicyOriginServiceImpl extends BaseServiceImpl implements PolicyOriginService {
    /** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PolicyOriginServiceImpl.class);
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PrpCmainOriginDao prpCmainOriginDao;
    @Autowired
    private PrpCexpenseOriginDao prpCexpenseOriginDao;

    /**
     * 原始保单查询
     * @author: 钱浩
     * @date: 2017/11/23 下午 19:55
     * @param policyNo 保单号
     * @return PolicyOriginDto 原始保单对象
     * @throws Exception
     */
    @Override
    public PolicyOriginDto queryByPolicyOrigin(String policyNo) throws Exception {

        if(StringUtils.isEmpty(policyNo)){
            throw new DataVerifyException("保单号不能为空");
        }

        PolicyOriginDto policyOriginDto=new PolicyOriginDto();
        //PrpCmainOriginDto
        PrpCmainOrigin prpCmainOrigin=prpCmainOriginDao.findOne(new PrpCmainOriginKey(policyNo));
        PrpCmainOriginDto prpCmainOriginDto=convert(prpCmainOrigin,PrpCmainOriginDto.class);
        policyOriginDto.setPrpCmainOriginDto(prpCmainOriginDto);
        //PrpCexpenseOriginDto
        PrpCexpenseOrigin prpCexpenseOrigin=prpCexpenseOriginDao.findOne(new PrpCexpenseOriginKey(policyNo));
        PrpCexpenseOriginDto prpCexpenseOriginDto=convert(prpCexpenseOrigin,PrpCexpenseOriginDto.class);
        policyOriginDto.setPrpCexpenseOriginDto(prpCexpenseOriginDto);
        //PrpCitemKindOriginDto
        StringBuffer buffer=new StringBuffer();
        buffer.append(" select p from PrpCitemKindOrigin p where p.policyNo=:policyNo  ");
        Query citemKindQuery=entityManager.createQuery(buffer.toString());
        citemKindQuery.setParameter("policyNo",policyNo);
        List<PrpCitemKindOrigin> prpCitemKindOriginList=citemKindQuery.getResultList();
        List<PrpCitemKindOriginDto> prpCitemKindOriginDtoList=new ArrayList<PrpCitemKindOriginDto>();
        convertCollection(prpCitemKindOriginList,prpCitemKindOriginDtoList,PrpCitemKindOriginDto.class);
        policyOriginDto.setPrpCitemKindOriginDtoList(prpCitemKindOriginDtoList);
        buffer.setLength(0);
        //PrpCfeeOriginDto
        buffer.append(" select p from PrpCfeeOrigin p where p.policyNo=:policyNo  ");
        Query prpCfeeOriginQuery=entityManager.createQuery(buffer.toString());
        prpCfeeOriginQuery.setParameter("policyNo",policyNo);
        List<PrpCfeeOrigin> prpCfeeOriginList=prpCfeeOriginQuery.getResultList();
        List<PrpCfeeOriginDto> prpCfeeOriginDtoList=new ArrayList<PrpCfeeOriginDto>();
        convertCollection(prpCfeeOriginList,prpCfeeOriginDtoList,PrpCfeeOriginDto.class);
        policyOriginDto.setPrpCfeeOriginDtoList(prpCfeeOriginDtoList);
        buffer.setLength(0);
        //PrpCcoinsDetailOriginDto
        buffer.append(" select p from PrpCcoinsDetailOrigin p where p.policyNo=:policyNo  ");
        Query prpCcoinsDetailOriginQuery=entityManager.createQuery(buffer.toString());
        prpCcoinsDetailOriginQuery.setParameter("policyNo",policyNo);
        List<PrpCcoinsDetailOrigin> prpCcoinsDetailOriginList=prpCcoinsDetailOriginQuery.getResultList();
        List<PrpCcoinsDetailOriginDto> prpCcoinsDetailOriginDtoList=new ArrayList<PrpCcoinsDetailOriginDto>();
        convertCollection(prpCcoinsDetailOriginList,prpCcoinsDetailOriginDtoList,PrpCcoinsDetailOriginDto.class);
        policyOriginDto.setPrpCcoinsDetailOriginDtoList(prpCcoinsDetailOriginDtoList);
        buffer.setLength(0);
        // PrpCcoinsOriginDto
        buffer.append(" select p from PrpCcoinsOrigin p where p.policyNo=:policyNo  ");
        Query prpCcoinsOriginQuery=entityManager.createQuery(buffer.toString());
        prpCcoinsOriginQuery.setParameter("policyNo",policyNo);
        List<PrpCcoinsOrigin> prpCcoinsOriginList=prpCcoinsOriginQuery.getResultList();
        List<PrpCcoinsOriginDto> prpCcoinsOriginDtoList=new ArrayList<PrpCcoinsOriginDto>();
        convertCollection(prpCcoinsOriginList,prpCcoinsOriginDtoList,PrpCcoinsOriginDto.class);
        policyOriginDto.setPrpCcoinsOriginDtoList(prpCcoinsOriginDtoList);
        return policyOriginDto;
    }

    @Override
    public PrpCmainOriginDto queryByPolicyNo(String policyNo) throws Exception {
        if(StringUtils.isEmpty(policyNo)){
            throw new DataVerifyException("保单号不能为空！");
        }
        PrpCmainOriginKey prpCmainOriginKey=new PrpCmainOriginKey(policyNo);
        PrpCmainOrigin prpCmainOrigin=prpCmainOriginDao.findOne(prpCmainOriginKey);
        return convert(prpCmainOrigin,PrpCmainOriginDto.class);
    }
}
