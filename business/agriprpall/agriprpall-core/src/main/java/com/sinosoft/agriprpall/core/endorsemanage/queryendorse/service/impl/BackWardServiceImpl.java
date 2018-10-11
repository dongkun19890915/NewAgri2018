package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPengageDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.*;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCmainService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 批单回倒服务
 * @throws Exception
 * @author 王保良
 * @date 2017年11月27日
 */
@Service
public class BackWardServiceImpl extends BaseServiceImpl implements BackWardService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BackWardServiceImpl.class);


    @Autowired
    private QueryPService queryPService;
    @Autowired
    private PrpPmainService prpPmainService;
    @Autowired
    private PrpPmainAgriService prpPmainAgriService;
    @Autowired
    private PrpPaddressService prpPaddressService;
    @Autowired
    private PrpPfeeService prpPfeeService;
    @Autowired
    private PrpPinsuredService prpPinsuredService;
    @Autowired
    private PrpPEngageService prpPEngageService;
    @Autowired
    private PrpPplanService prpPplanService;
    @Autowired
    private PrpPplanCoinsService prpPplanCoinsService;
    @Autowired
    private PrpPitemKindService prpPitemKindService;
    @Autowired
    private PrpPexpenseService prpPexpenseService;
    @Autowired
    private PrpPitemKindAgriService prpPitemKindAgriService;
    @Autowired
    private PrpPsubsidyService prpPsubsidyService;
    @Autowired
    private PrpPfeildService prpPfeildService;

    //copy表
//    @Autowired
//    private PrpPmainCopyService prpPmainCopyService;
//    @Autowired
//    private PrpPmainAgriCopyService prpPmainAgriCopyService;
//    @Autowired
//    private PrpPaddressCopyService prpPaddressCopyService;
//    @Autowired
//    private PrpPfeeCopyService prpPfeeCopyService;
//    @Autowired
//    private PrpPinsuredCopyService prpPinsuredCopyService;
//    @Autowired
//    private PrpPEngageCopyService prpPEngageCopyService;
//    @Autowired
//    private PrpPplanCopyService prpPplanCopyService;
//    @Autowired
//    private PrpPplanCoinsCopyService prpPplanCoinsCopyService;
//    @Autowired
//    private PrpPitemKindCopyService prpPitemKindCopyService;
//    @Autowired
//    private PrpPexpenseCopyService prpPexpenseCopyService;
//    @Autowired
//    private PrpPitemKindAgriCopyService prpPitemKindAgriCopyService;
//    @Autowired
//    private PrpPsubsidyCopyService prpPsubsidyCopyService;
//    @Autowired
//    private PrpPfeildCopyService prpPfeildCopyService;
    /**
     * 批单回倒
     * @param endorseNo 批单号
     * @param blPolicyDto 保单大对象
     * @return void
     * @throws Exception
     * @author 王保良
     * @date 2017年10月28日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void backWard(String endorseNo, ResponseQueryPolicyInfoDto blPolicyDto) throws Exception {
        BLEndorseDto blEndorseDto= queryPService.queryP(endorseNo);

        blPolicyDto.setPrpCmainDto(prpPmainService.backWard(blEndorseDto,blPolicyDto));
        blPolicyDto.setPrpCmainAgriDto(prpPmainAgriService.backWard(blEndorseDto,blPolicyDto));
        blPolicyDto.setPrpCaddressDtoList(prpPaddressService.backWard(blEndorseDto,blPolicyDto));
        blPolicyDto.setPrpCfeeDtoList(prpPfeeService.backWard(blEndorseDto,blPolicyDto));
        blPolicyDto.setPrpCinsuredDtoList(prpPinsuredService.backWard(blEndorseDto,blPolicyDto));
        blPolicyDto.setPrpCengageDtoList(prpPEngageService.backWard(blEndorseDto,blPolicyDto));
        blPolicyDto.setPrpCplanDtoList(prpPplanService.backWard(blEndorseDto,blPolicyDto));
        blPolicyDto.setPrpCplanCoinsDtoList(prpPplanCoinsService.backWard(blEndorseDto,blPolicyDto));
        blPolicyDto.setPrpCitemKindDtoList(prpPitemKindService.backWard(blEndorseDto,blPolicyDto));
        blPolicyDto.setPrpCexpenseDto(prpPexpenseService.backWard(blEndorseDto,blPolicyDto));
        blPolicyDto.setPrpCitemKindAgriDtoList(prpPitemKindAgriService.backWard(blEndorseDto,blPolicyDto));
        blPolicyDto.setPrpCsubsidyDtoList(prpPsubsidyService.backWard(blEndorseDto,blPolicyDto));
        blPolicyDto.setPrpCfeildDtoList(prpPfeildService.backWard(blEndorseDto,blPolicyDto));

        //copy表
//        blPolicyDto.setPrpCmainDto(prpPmainCopyService.backWard(blEndorseDto,blPolicyDto));
//        blPolicyDto.setPrpCmainAgriDto(prpPmainAgriCopyService.backWard(blEndorseDto,blPolicyDto));
//        blPolicyDto.setPrpCaddressDtoList(prpPaddressCopyService.backWard(blEndorseDto,blPolicyDto));
//        blPolicyDto.setPrpCfeeDtoList(prpPfeeCopyService.backWard(blEndorseDto,blPolicyDto));
//        blPolicyDto.setPrpCinsuredDtoList(prpPinsuredCopyService.backWard(blEndorseDto,blPolicyDto));
//        blPolicyDto.setPrpCengageDtoList(prpPEngageCopyService.backWard(blEndorseDto,blPolicyDto));
//        blPolicyDto.setPrpCplanDtoList(prpPplanCopyService.backWard(blEndorseDto,blPolicyDto));
//        blPolicyDto.setPrpCplanCoinsDtoList(prpPplanCoinsCopyService.backWard(blEndorseDto,blPolicyDto));
//        blPolicyDto.setPrpCitemKindDtoList(prpPitemKindCopyService.backWard(blEndorseDto,blPolicyDto));
//        blPolicyDto.setPrpCexpenseDto(prpPexpenseCopyService.backWard(blEndorseDto,blPolicyDto));
//        blPolicyDto.setPrpCitemKindAgriDtoList(prpPitemKindAgriCopyService.backWard(blEndorseDto,blPolicyDto));
//        blPolicyDto.setPrpCsubsidyDtoList(prpPsubsidyCopyService.backWard(blEndorseDto,blPolicyDto));
//        blPolicyDto.setPrpCfeildDtoList(prpPfeildCopyService.backWard(blEndorseDto,blPolicyDto));

    }
}
