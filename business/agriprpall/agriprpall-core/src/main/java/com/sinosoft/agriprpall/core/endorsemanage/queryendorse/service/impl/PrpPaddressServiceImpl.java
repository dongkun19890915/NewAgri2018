package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPaddressDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCaddressDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.PrpPaddressService;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.SettleService;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCaddressService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * PrpPadderss表相关服务
 * @throws Exception
 * @author 王保良
 * @date 2017年10月27日
 */
@Service
public class PrpPaddressServiceImpl extends BaseServiceImpl implements PrpPaddressService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrpPaddressServiceImpl.class);

    @Autowired
    private SettleService settleService;
    @Autowired
    private PrpCaddressService prpCaddressService;

    /**
     * 批单回倒
     * @param blEndorseDto 批单大对象
     * @param responseQueryPolicyInfoDto 保单大对象
     * @return List<PrpCaddressDto>
     * @throws Exception
     * @author 王保良
     * @date 2017年10月28日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<PrpCaddressDto> backWard(BLEndorseDto blEndorseDto, ResponseQueryPolicyInfoDto responseQueryPolicyInfoDto) throws Exception {
        PrpPaddressDto prpPaddressDto=new PrpPaddressDto();
        PrpCaddressDto prpCaddressDto=new PrpCaddressDto();
        int strcurr=0;
        int iFindFlag=0;
        if (blEndorseDto.getPrpPaddressDtoList().size()>0){
            for (int i=0;i<blEndorseDto.getPrpPaddressDtoList().size();i++){
                prpPaddressDto=blEndorseDto.getPrpPaddressDtoList().get(i);
                if (prpPaddressDto.getFlag().substring(0,1).equals("U")){
                    strcurr=settleService.prpCaddressSearch(prpPaddressDto.getAddressNo(),responseQueryPolicyInfoDto.getPrpCaddressDtoList());
                    if (strcurr>=0){
                        prpCaddressDto=prpCaddressService.PEvaluateC(prpPaddressDto);
                        responseQueryPolicyInfoDto.getPrpCaddressDtoList().set(strcurr,prpCaddressDto);
                    }
                }
                if (prpPaddressDto.getFlag().substring(0,1).equals("I")){
                    strcurr=settleService.prpCaddressSearch(prpPaddressDto.getAddressNo(),responseQueryPolicyInfoDto.getPrpCaddressDtoList());
                    if (strcurr>=0){
                        responseQueryPolicyInfoDto.getPrpCaddressDtoList().remove(strcurr);
                    }
                }
                if (prpPaddressDto.getFlag().substring(0,1).equals("D")){
                    for (int j=0;j<responseQueryPolicyInfoDto.getPrpCaddressDtoList().size();j++){
                        prpCaddressDto=responseQueryPolicyInfoDto.getPrpCaddressDtoList().get(j);
                        if (prpPaddressDto.getAddressNo()<prpCaddressDto.getAddressNo()){
                            strcurr=j;
                            iFindFlag=1;
                        }
                    }
                    if (iFindFlag==0){
                        strcurr=responseQueryPolicyInfoDto.getPrpCaddressDtoList().size();
                    }
                    prpCaddressDto=prpCaddressService.PEvaluateC(prpPaddressDto);
                    responseQueryPolicyInfoDto.getPrpCaddressDtoList().add(strcurr,prpCaddressDto);
                }
                if (prpPaddressDto.getFlag().substring(0,1).equals("B")){
                    strcurr=settleService.prpCaddressSearch(prpPaddressDto.getAddressNo(),responseQueryPolicyInfoDto.getPrpCaddressDtoList());
                    if (strcurr>=0){
                        prpCaddressDto=prpCaddressService.PEvaluateC(prpPaddressDto);
                        responseQueryPolicyInfoDto.getPrpCaddressDtoList().set(strcurr,prpCaddressDto);
                    }
                }
            }
        }
        return responseQueryPolicyInfoDto.getPrpCaddressDtoList();
    }
}
