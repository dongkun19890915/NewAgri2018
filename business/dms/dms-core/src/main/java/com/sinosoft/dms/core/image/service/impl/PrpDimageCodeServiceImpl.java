package com.sinosoft.dms.core.image.service.impl;

import com.sinosoft.dms.api.image.dto.PrpDimageCodeDto;
import com.sinosoft.dms.core.image.entity.PrpDimageCode;
import com.sinosoft.dms.core.image.service.PrpDimageCodeService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class PrpDimageCodeServiceImpl extends BaseServiceImpl implements PrpDimageCodeService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public PrpDimageCodeDto queryByPK(String riskCode, String comCode) {
        if (StringUtils.isEmpty(riskCode)) {
            throw new DataVerifyException("险种代码不能为空！");
        }
        if (StringUtils.isEmpty(comCode)) {
            throw new DataVerifyException("机构代码不能为空！");
        }
        StringBuilder dataSQL = new StringBuilder("select pc.* from PrpDimageCode pc where pc.riskCode = :riskCode and pc.comCode = :comCode");
        Query nativeQuery = entityManager.createNativeQuery(dataSQL.toString(),PrpDimageCode.class);
        nativeQuery.setParameter("riskCode", riskCode);
        nativeQuery.setParameter("comCode", comCode);
        PrpDimageCode prpDimageCode = (PrpDimageCode) nativeQuery.getSingleResult();
        PrpDimageCodeDto prpDimageCodeDto = convert(prpDimageCode, PrpDimageCodeDto.class);
        return prpDimageCodeDto;
    }
}
