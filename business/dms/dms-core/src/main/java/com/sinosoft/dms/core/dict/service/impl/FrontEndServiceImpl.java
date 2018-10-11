package com.sinosoft.dms.core.dict.service.impl;

import com.sinosoft.dms.api.dict.dto.FrontEndDto;
import com.sinosoft.dms.core.dict.service.FrontEndService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author zxp
 * @description （prpdcode码表的实现）
 * @date 2017年8月28日
 */
@Service
public class FrontEndServiceImpl extends BaseServiceImpl implements FrontEndService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FrontEndServiceImpl.class);


    @Value("${front_end.prpallFront.claimUrl}")
    private String prpallClaimUrl;
    @Value("${front_end.prpallFront.gisUrl}")
    private String prpallGisUrl;
    @Value("${front_end.prpallFront.sunECMUrl}")
    private String prpallSunECMUrl;
    @Value("${front_end.claimFront.prpallUrl}")
    private String claimPrpallUrl;
    @Value("${front_end.claimFront.gisUrl}")
    private String claimGisUrl;
    @Value("${front_end.claimFront.sunECMUrl}")
    private String claimSunECMUrl;

    /**
     * 承保对接影像的密钥
     */
    @Value("${front_end.prpallFront.sunECMKeys}")
    private String prpallSunECMKeys;

    /**
     * 理赔对接影像的密钥
     */
    @Value("${front_end.claimFront.sunECMKeys}")
    private String claimSunECMKeys;

    /**
     * 前端地址配置后端化
     *
     * @author: 钱浩
     * @date: 2018/5/16 下午 15:30
     */
    public FrontEndDto queryFrontEnd() throws Exception {
        FrontEndDto frontEndDto = new FrontEndDto();
        frontEndDto.setPrpallClaimUrl(prpallClaimUrl);
        frontEndDto.setPrpallGisUrl(prpallGisUrl);
        frontEndDto.setPrpallSunECMUrl(prpallSunECMUrl);
        frontEndDto.setClaimPrpallUrl(claimPrpallUrl);
        frontEndDto.setClaimGisUrl(claimGisUrl);
        frontEndDto.setClaimSunECMUrl(claimSunECMUrl);
        frontEndDto.setPrpallSunECMKeys(prpallSunECMKeys);
        frontEndDto.setClaimSunECMKeys(claimSunECMKeys);
        return frontEndDto;
    }

}