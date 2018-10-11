package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPinsuredDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCinsuredDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.PrpPinsuredService;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.SettleService;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCinsuredService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * PrpPinsured表相关服务
 * @throws Exception
 * @author 王保良
 * @date 2017年10月27日
 */
@Service
public class PrpPinsuredServiceImpl extends BaseServiceImpl implements PrpPinsuredService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrpPinsuredServiceImpl.class);

    @Autowired
    private SettleService settleService;
    @Autowired
    private PrpCinsuredService prpCinsuredService;
    @Autowired
    private PrpPinsuredService prpPinsuredService;

    /**
     * 批单回倒
     * @param blEndorseDto 批单大对象
     * @param responseQueryPolicyInfoDto 保单大对象
     * @return List<PrpCinsuredDto>
     * @throws Exception
     * @author 王保良
     * @date 2017年10月28日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<PrpCinsuredDto> backWard(BLEndorseDto blEndorseDto, ResponseQueryPolicyInfoDto responseQueryPolicyInfoDto) throws Exception {
        PrpPinsuredDto prpPinsuredDto = new PrpPinsuredDto();
        PrpCinsuredDto prpCinsuredDto = new PrpCinsuredDto();
        int strcurr = 0;
        int iFindFlag = 0;
        if (blEndorseDto.getPrpPinsuredDtoList().size()>0)
        {
            for (int i=0;i<blEndorseDto.getPrpPinsuredDtoList().size();i++)
            {
                prpPinsuredDto = blEndorseDto.getPrpPinsuredDtoList().get(i);
                if (prpPinsuredDto.getFlag().length()>0)
                {
                    if (prpPinsuredDto.getFlag().substring(0,1).equals("U"))
                    {
                        strcurr= settleService.PrpCinsuredSearch(prpPinsuredDto.getSerialNo(),responseQueryPolicyInfoDto.getPrpCinsuredDtoList());
                        if (strcurr >=0)
                        {
                            prpCinsuredDto = prpCinsuredService.PEvaluateC(prpPinsuredDto);
                            responseQueryPolicyInfoDto.getPrpCinsuredDtoList().set(strcurr,prpCinsuredDto);
                        }
                    }
                    if (prpPinsuredDto.getFlag().substring(0,1).equals("I"))
                    {
                        strcurr= settleService.PrpCinsuredSearch(prpPinsuredDto.getSerialNo(),responseQueryPolicyInfoDto.getPrpCinsuredDtoList());

                        if(strcurr >=0)
                        {
                            responseQueryPolicyInfoDto.getPrpCinsuredDtoList().remove(strcurr);}
                    }
                    if (prpPinsuredDto.getFlag().substring(0,1).equals("D"))
                    {
                        //根据序号查找插入点
                        for(int j=0;j<responseQueryPolicyInfoDto.getPrpCinsuredDtoList().size();j++)
                        { prpCinsuredDto =responseQueryPolicyInfoDto.getPrpCinsuredDtoList().get(j);
                            if (prpPinsuredDto.getSerialNo()<prpCinsuredDto.getSerialNo())
                            {strcurr = j;
                                iFindFlag = 1;
                            }
                        }
                        if (iFindFlag ==0)
                        //没找到插入点为最后
                        {strcurr = responseQueryPolicyInfoDto.getPrpCinsuredDtoList().size();}
                        //将p记录转为c记录
                        prpCinsuredDto = prpCinsuredService.PEvaluateC(prpPinsuredDto);
                        //在指定位置插入
                        responseQueryPolicyInfoDto.getPrpCinsuredDtoList().add(strcurr,prpCinsuredDto);
                    }
                    if (prpPinsuredDto.getFlag().substring(0,1).equals("B"))
                    {
                        strcurr= settleService.PrpCinsuredSearch(prpPinsuredDto.getSerialNo(),responseQueryPolicyInfoDto.getPrpCinsuredDtoList());
                        if (strcurr >=0)
                            prpCinsuredDto = prpCinsuredService.PEvaluateC(prpPinsuredDto);
                        responseQueryPolicyInfoDto.getPrpCinsuredDtoList().set(strcurr,prpCinsuredDto);
                        }
                    }
                }
            }
        return responseQueryPolicyInfoDto.getPrpCinsuredDtoList();
    }

}