package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPsubsidyDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCsubsidyDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.PrpPsubsidyService;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.SettleService;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCsubsidyService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * PrpPsubsidy表相关服务
 * @throws Exception
 * @author 王保良
 * @date 2017年10月27日
 */
@Service
public class PrpPsubsidyServiceImpl extends BaseServiceImpl implements PrpPsubsidyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrpPsubsidyServiceImpl.class);


    @Autowired
    private SettleService settleService;
    @Autowired
    private PrpCsubsidyService prpCsubsidyService;

    /**
     * 批单回倒
     * @param blEndorseDto 批单大对象
     * @param responseQueryPolicyInfoDto 保单大对象
     * @return List<PrpCsubsidyDto>
     * @throws Exception
     * @author 王保良
     * @date 2017年10月28日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<PrpCsubsidyDto> backWard(BLEndorseDto blEndorseDto, ResponseQueryPolicyInfoDto responseQueryPolicyInfoDto) throws Exception {
        PrpPsubsidyDto prpPsubsidyDto = new PrpPsubsidyDto();
        PrpCsubsidyDto prpCsubsidyDto = new PrpCsubsidyDto();
        int intCurr = 0;
        int intFindFlag = 0;
        int index = 0;
        int i = 0;
        int j = 0;
        if (blEndorseDto.getPrpPsubsidyDtoList().size()>0)
        {
            //modify by zhaoning20061226 begin reason:根据OperationFlag位的不同做不同的操作	  
            //在这之前应该已经将P表的数据准备好了，U、I、D、未修改的数据都有
            for (i = 0; i < blEndorseDto.getPrpPsubsidyDtoList().size(); i++) {
                prpPsubsidyDto = blEndorseDto.getPrpPsubsidyDtoList().get(i);

                //修改
                if (prpPsubsidyDto.getOperationFlag().length() > 0 &&
                        prpPsubsidyDto.getOperationFlag().substring(0, 1).equals("U")) {
                    intCurr = settleService.PrpCsubsidySearch(prpPsubsidyDto.getSubsidyCode(),prpPsubsidyDto.getSubsidyType(),responseQueryPolicyInfoDto.getPrpCsubsidyDtoList());
                    if (intCurr >= 0) {
                        prpCsubsidyDto = prpCsubsidyService.PEvaluateC(prpPsubsidyDto);
                        responseQueryPolicyInfoDto.getPrpCsubsidyDtoList().add(prpCsubsidyDto);
                    }
                }
                //新增
                if (prpPsubsidyDto.getOperationFlag().length() > 0 &&
                        prpPsubsidyDto.getOperationFlag().substring(0, 1).equals("I")) {
                    intCurr = settleService.PrpCsubsidySearch(prpPsubsidyDto.getSubsidyCode(),prpPsubsidyDto.getSubsidyType(),responseQueryPolicyInfoDto.getPrpCsubsidyDtoList());
                    if (intCurr >= 0) {
                        responseQueryPolicyInfoDto.getPrpCsubsidyDtoList().remove(intCurr);
                    }
                }
                //删除（保单注销等）
                if (prpPsubsidyDto.getOperationFlag().length() > 0 &&
                        prpPsubsidyDto.getOperationFlag().substring(0, 1).equals("D")) {
                    //将p记录转为c记录
                    prpCsubsidyDto = prpCsubsidyService.PEvaluateC(prpPsubsidyDto);
                    //在指定位置插入
                    responseQueryPolicyInfoDto.getPrpCsubsidyDtoList().add(prpCsubsidyDto);
                }
                //退保（全单退保等）
                if (prpPsubsidyDto.getOperationFlag().length() > 0 &&
                        prpPsubsidyDto.getOperationFlag().substring(0, 1).equals("B")) {
                    intCurr = settleService.PrpCsubsidySearch(prpPsubsidyDto.getSubsidyCode(),prpPsubsidyDto.getSubsidyType(),responseQueryPolicyInfoDto.getPrpCsubsidyDtoList());
                    if (intCurr >= 0) {
                        prpCsubsidyDto = prpCsubsidyService.PEvaluateC(prpPsubsidyDto);
                        responseQueryPolicyInfoDto.getPrpCsubsidyDtoList().add(prpCsubsidyDto);
                    }
                }
            }
        }

        return responseQueryPolicyInfoDto.getPrpCsubsidyDtoList();
    }
}
