package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPitemKindDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.PrpPitemKindService;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.SettleService;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCitemKindService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * PrpPitemKind表相关服务
 * @throws Exception
 * @author 王保良
 * @date 2017年10月27日
 */
@Service
public class PrpPitemKindServiceImpl extends BaseServiceImpl implements PrpPitemKindService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrpPitemKindServiceImpl.class);

    @Autowired
    private SettleService settleService;
    @Autowired
    private PrpCitemKindService prpCitemKindService;

    /**
     * 批单回倒
     * @param blEndorseDto 批单大对象
     * @param responseQueryPolicyInfoDto 保单大对象
     * @return List<PrpCitemKindDto>
     * @throws Exception
     * @author 王保良
     * @date 2017年10月28日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<PrpCitemKindDto> backWard(BLEndorseDto blEndorseDto, ResponseQueryPolicyInfoDto responseQueryPolicyInfoDto) throws Exception {
        PrpCitemKindDto prpCitemKindDto = new PrpCitemKindDto();
        PrpPitemKindDto prpPitemKindDto= new PrpPitemKindDto();

        int intCurr = 0;
        int intFindFlag = 0;
        int index = 0;
        int i = 0;
        int j = 0;

        if (blEndorseDto.getPrpPitemKindDtoList().size() > 0) {
            //在这之前应该已经将P表的数据准备好了，U、I、D、未修改的数据都有
            for (i = 0; i < blEndorseDto.getPrpPitemKindDtoList().size(); i++) {
                prpPitemKindDto = blEndorseDto.getPrpPitemKindDtoList().get(i);

                //修改
                if (prpPitemKindDto.getFlag().length() > 0 &&
                        prpPitemKindDto.getFlag().substring(0, 1).equals("U")) {
                    intCurr = settleService.PrpCitemKindSearch(prpPitemKindDto.getItemKindNo(),responseQueryPolicyInfoDto.getPrpCitemKindDtoList());
                    if (intCurr >= 0) {
                        prpCitemKindDto = prpCitemKindService.PEvaluateC(prpPitemKindDto);
                        responseQueryPolicyInfoDto.getPrpCitemKindDtoList().set(intCurr, prpCitemKindDto);
                    }
                }
                //新增
                if (prpPitemKindDto.getFlag().length() > 0 &&
                        prpPitemKindDto.getFlag().substring(0, 1).equals("I")) {
                    intCurr = settleService.PrpCitemKindSearch(prpPitemKindDto.getItemKindNo(),responseQueryPolicyInfoDto.getPrpCitemKindDtoList());
                    if (intCurr >= 0) {
                        responseQueryPolicyInfoDto.getPrpCitemKindDtoList().remove(intCurr);
                    }
                }
                //删除（保单注销等）
                if (prpPitemKindDto.getFlag().length() > 0 &&
                        prpPitemKindDto.getFlag().substring(0, 1).equals("D")) {
                    //根据序号插入（按顺序）
                    for (j = 0; j < responseQueryPolicyInfoDto.getPrpCitemKindDtoList().size(); j++) {
                        prpCitemKindDto = responseQueryPolicyInfoDto.getPrpCitemKindDtoList().get(j);
                        if (prpPitemKindDto.getItemKindNo() <
                                prpCitemKindDto.getItemKindNo()) {
                            intCurr = j;
                            intFindFlag = 1;
                        }
                    }
                    //没找到插入点为最后
                    if (intFindFlag == 0) {
                        intCurr = responseQueryPolicyInfoDto.getPrpCitemKindDtoList().size();
                    }
                    //将p记录转为c记录
                    prpCitemKindDto = prpCitemKindService.PEvaluateC(prpPitemKindDto);
                    //在指定位置插入
                    responseQueryPolicyInfoDto.getPrpCitemKindDtoList().add(intCurr, prpCitemKindDto);
                }
                //退保（全单退保等）
                if (prpPitemKindDto.getFlag().length() > 0 &&
                        prpPitemKindDto.getFlag().substring(0, 1).equals("B")) {
                    intCurr = settleService.PrpCitemKindSearch(prpPitemKindDto.getItemKindNo(),responseQueryPolicyInfoDto.getPrpCitemKindDtoList());
                    if (intCurr >= 0) {
                        prpCitemKindDto = prpCitemKindService.PEvaluateC(prpPitemKindDto);
                        responseQueryPolicyInfoDto.getPrpCitemKindDtoList().set(intCurr, prpCitemKindDto);
                    }
                }
            }
        }
        return responseQueryPolicyInfoDto.getPrpCitemKindDtoList();
    }
}
