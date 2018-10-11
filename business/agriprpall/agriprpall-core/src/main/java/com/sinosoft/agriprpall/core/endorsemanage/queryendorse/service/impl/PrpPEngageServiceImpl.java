package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPengageDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCengageDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.PrpPengageDao;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPengage;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.PrpPEngageService;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.SettleService;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCengageService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * PrpPEngage表相关服务
 * @throws Exception
 * @author 王保良
 * @date 2017年10月27日
 */
@Service
public class PrpPEngageServiceImpl extends BaseServiceImpl implements PrpPEngageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrpPEngageServiceImpl.class);

    @Autowired
    private PrpPengageDao prpPengageDao;
    @Autowired
    private SettleService settleService;
    @Autowired
    private PrpPEngageService prpPEngageService;
    @Autowired
    private PrpCengageService prpCengageService;


    @Override
    public boolean savePrpPEgage(BLEndorseDto endorseDto) throws Exception {
        List<PrpPengage> prpPengageList =new ArrayList<>();
        convertCollection(endorseDto.getPrpPengageDtoList(), prpPengageList,PrpPengage.class);
        prpPengageDao.save(prpPengageList);
        return true;
    }

    /**
     * 批单回倒
     * @param blEndorseDto 批单大对象
     * @param responseQueryPolicyInfoDto 保单大对象
     * @return List<PrpCengageDto>
     * @throws Exception
     * @author 王保良
     * @date 2017年10月28日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<PrpCengageDto> backWard(BLEndorseDto blEndorseDto, ResponseQueryPolicyInfoDto responseQueryPolicyInfoDto) throws Exception {
        PrpPengageDto prpPengageDto = new PrpPengageDto();
        PrpCengageDto prpCengageDto = new PrpCengageDto();
        int strcurr = 0;
        int iFindFlag = 0;
        if (blEndorseDto.getPrpPengageDtoList().size()>0)
        {
            for (int i=0;i<blEndorseDto.getPrpPengageDtoList().size();i++)
            {
                prpPengageDto = blEndorseDto.getPrpPengageDtoList().get(i);
                if (prpPengageDto.getFlag().substring(0,1).equals("U"))
                {
                    strcurr= settleService.PrpCengageSearch(prpPengageDto.getSerialNo(),prpPengageDto.getLineNo(),responseQueryPolicyInfoDto.getPrpCengageDtoList());
                    if (strcurr >=0)
                    {
                        prpCengageDto = prpCengageService.PEvaluateC(prpPengageDto);
                        responseQueryPolicyInfoDto.getPrpCengageDtoList().set(strcurr,prpCengageDto);
                    }
                }
                if (prpPengageDto.getFlag().substring(0,1).equals("I"))
                {
                    strcurr= settleService.PrpCengageSearch(prpPengageDto.getSerialNo(),prpPengageDto.getLineNo(),responseQueryPolicyInfoDto.getPrpCengageDtoList());
                    if(strcurr >=0)
                    {
                        responseQueryPolicyInfoDto.getPrpCengageDtoList().remove(strcurr);
                    }
                }
                if (prpPengageDto.getFlag().substring(0,1).equals("D"))
                {
                    //根据序号查找插入点
                    for(int j=0;j<responseQueryPolicyInfoDto.getPrpCengageDtoList().size();j++)
                    { prpCengageDto = responseQueryPolicyInfoDto.getPrpCengageDtoList().get(i);
                        if (prpPengageDto.getSerialNo()<prpCengageDto.getSerialNo())
                        {strcurr = j;
                            iFindFlag = 1;
                            break;
                        }
                    }
                    if (iFindFlag ==0)
                    //没找到插入点为最后
                    {strcurr = responseQueryPolicyInfoDto.getPrpCengageDtoList().size();}
                    //将p记录转为c记录
                    prpCengageDto = prpCengageService.PEvaluateC(prpPengageDto);
                    //在指定位置插入
                    responseQueryPolicyInfoDto.getPrpCengageDtoList().add(strcurr,prpCengageDto);
                }
                if (prpPengageDto.getFlag().substring(0,1).equals("B"))
                {
                    strcurr= settleService.PrpCengageSearch(prpPengageDto.getSerialNo(),prpPengageDto.getLineNo(),responseQueryPolicyInfoDto.getPrpCengageDtoList());
                    if (strcurr >=0)
                        prpCengageDto = prpCengageService.PEvaluateC(prpPengageDto);
                        responseQueryPolicyInfoDto.getPrpCengageDtoList().set(strcurr,prpCengageDto);
                    }
                }
            }

        return responseQueryPolicyInfoDto.getPrpCengageDtoList();
    }
}
