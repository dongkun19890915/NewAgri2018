package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPfeeDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCfeeDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.PrpPfeeService;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.SettleService;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCfeeService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * PrpPfee表相关服务
 * @throws Exception
 * @author 王保良
 * @date 2017年10月27日
 */
@Service
public class PrpPfeeServiceImpl extends BaseServiceImpl implements PrpPfeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrpPfeeServiceImpl.class);


    @Autowired
    private SettleService settleService;
    @Autowired
    private PrpCfeeService prpCfeeService;

    /**
     * 批单回倒
     * @param blEndorseDto 批单大对象
     * @param responseQueryPolicyInfoDto 保单大对象
     * @return List<PrpCfeeDto>
     * @throws Exception
     * @author 王保良
     * @date 2017年10月28日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<PrpCfeeDto> backWard(BLEndorseDto blEndorseDto, ResponseQueryPolicyInfoDto responseQueryPolicyInfoDto) throws Exception {
        PrpCfeeDto prpCfeeDto=new PrpCfeeDto();
        PrpPfeeDto prpPfeeDto=new PrpPfeeDto();

        int intCurr=0;
        int intFindFlag=0;
        int index=0;

        if (blEndorseDto.getPrpPfeeDtoList().size()>0){
            for (int i=0;i<blEndorseDto.getPrpPfeeDtoList().size();i++){
                prpPfeeDto=blEndorseDto.getPrpPfeeDtoList().get(i);

                if (prpPfeeDto.getFlag().length()>0 && prpPfeeDto.getFlag().substring(0,1).equals("U")){
                    intCurr=settleService.PrpCfeeSearch(prpPfeeDto.getCurrency(),responseQueryPolicyInfoDto.getPrpCfeeDtoList());
                    if (intCurr>=0){
                        prpCfeeDto=prpCfeeService.PEvaluateC(prpPfeeDto);
                        responseQueryPolicyInfoDto.getPrpCfeeDtoList().set(intCurr,prpCfeeDto);
                    }
                }
                //新增
                if (prpPfeeDto.getFlag().length() > 0 &&
                        prpPfeeDto.getFlag().substring(0, 1).equals("I")) {
                    intCurr=settleService.PrpCfeeSearch(prpPfeeDto.getCurrency(),responseQueryPolicyInfoDto.getPrpCfeeDtoList());
                    if (intCurr >= 0) {
                        responseQueryPolicyInfoDto.getPrpCfeeDtoList().remove(intCurr);
                    }
                }
                //删除（保单注销等）
                if (prpPfeeDto.getFlag().length() > 0 &&
                        prpPfeeDto.getFlag().substring(0, 1).equals("D")) {
                    //根据序号插入（按顺序）
                    for (int j = 0; j < responseQueryPolicyInfoDto.getPrpCfeeDtoList().size(); j++) {
                        prpCfeeDto = responseQueryPolicyInfoDto.getPrpCfeeDtoList().get(j);
                        if (prpPfeeDto.getCurrency().equals(prpCfeeDto.getCurrency())) {
                            intCurr = j;
                            intFindFlag = 1;
                        }
                    }
                    //没找到插入点为最后
                    if (intFindFlag == 0) {
                        intCurr = responseQueryPolicyInfoDto.getPrpCfeeDtoList().size();
                    }
                    //将p记录转为c记录
                    prpCfeeDto = prpCfeeService.PEvaluateC(prpPfeeDto);
                    //在指定位置插入
                    responseQueryPolicyInfoDto.getPrpCfeeDtoList().add(intCurr, prpCfeeDto);
                }
                //退保（全单退保等）
                if (prpPfeeDto.getFlag().length() > 0 &&
                        prpPfeeDto.getFlag().substring(0, 1).equals("B")) {
                    intCurr=settleService.PrpCfeeSearch(prpPfeeDto.getCurrency(),responseQueryPolicyInfoDto.getPrpCfeeDtoList());                    if (intCurr >= 0) {
                        prpCfeeDto = prpCfeeService.PEvaluateC(prpPfeeDto);
                        responseQueryPolicyInfoDto.getPrpCfeeDtoList().set(intCurr, prpCfeeDto);
                    }
                }
            }
        }
        return responseQueryPolicyInfoDto.getPrpCfeeDtoList();
    }
}
