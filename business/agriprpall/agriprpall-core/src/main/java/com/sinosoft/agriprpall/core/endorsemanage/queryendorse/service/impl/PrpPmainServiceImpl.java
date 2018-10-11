package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPmainDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.PrpPmainDao;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPmain;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.PrpPmainService;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCmainService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * PrpPmain表相关服务
 * @throws Exception
 * @author 王保良
 * @date 2017年10月27日
 */
@Service
public class PrpPmainServiceImpl extends BaseServiceImpl implements PrpPmainService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrpPmainServiceImpl.class);
    @Autowired
    private PrpPmainDao prpPmainDao;

    @Autowired
    private PrpCmainService prpCmainService;

    /**
     * 批单回倒
     * @param blEndorseDto 批单大对象
     * @param responseQueryPolicyInfoDto 保单大对象
     * @return PrpCmainDto
     * @throws Exception
     * @author 王保良
     * @date 2017年10月28日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PrpCmainDto backWard(BLEndorseDto blEndorseDto, ResponseQueryPolicyInfoDto blPolicyDto) throws Exception {
        PrpPmainDto prpPmainDto=new PrpPmainDto();
        PrpCmainDto prpCmainDto=new PrpCmainDto();
        prpPmainDto=blEndorseDto.getPrpPmainDto();
        //将批单大对象中的P表转换成C表的 , 再放到blPolicyDto中
        prpCmainDto=prpCmainService.PEvaluateC(prpPmainDto);
        blPolicyDto.setPrpCmainDto(null);
        blPolicyDto.setPrpCmainDto(prpCmainDto);
        return prpCmainDto;
    }

    /**
     * 根据批单号查询PrpPmain表信息
     * @author: 李冬松
     * @date: 2017/12/23 15:47
     * @param endorseNo 批单号
     * @return PrpPmainDto 批改保单信息表
     * @throws Exception
     */
    @Override
    public PrpPmainDto queryPrpPmainDtoByEndorseNo(String endorseNo) throws Exception {
        if(StringUtils.isEmpty(endorseNo)){
            throw new DataVerifyException("批单号为空！");
        }
        PrpPmain prpPmain=prpPmainDao.queryAllByEndorseNo(endorseNo);

        return convert(prpPmain,PrpPmainDto.class);
    }

}
