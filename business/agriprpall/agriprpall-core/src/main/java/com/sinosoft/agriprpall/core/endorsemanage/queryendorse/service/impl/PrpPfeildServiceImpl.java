package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPfeildDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCfeildDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.PrpPfeildService;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.SettleService;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCfeildService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * PrpPfeild表相关服务
 * @throws Exception
 * @author 王保良
 * @date 2017年10月27日
 */
@Service
public class PrpPfeildServiceImpl extends BaseServiceImpl implements PrpPfeildService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrpPfeildServiceImpl.class);

    @Autowired
    private SettleService settleService;
    @Autowired
    private PrpCfeildService prpCfeildService;
    @Autowired
    private PrpPfeildService prpPfeildService;

    /**
     * 批单回倒
     * @param blEndorseDto 批单大对象
     * @param responseQueryPolicyInfoDto 保单大对象
     * @return List<PrpCfeildDto>
     * @throws Exception
     * @author 王保良
     * @date 2017年10月28日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<PrpCfeildDto> backWard(BLEndorseDto blEndorseDto, ResponseQueryPolicyInfoDto responseQueryPolicyInfoDto) throws Exception {
        PrpPfeildDto prpPfeildDto = new PrpPfeildDto();
        PrpCfeildDto prpCfeildDto = new PrpCfeildDto();
        int intCurr = 0;
        int intFindFlag = 0;
        int index = 0;
        int i = 0;
        int j = 0;
        if (blEndorseDto.getPrpPfeildDtoList().size()>0)
        {
            //modify by zhaoning20061226 begin reason:根据OperationFlag位的不同做不同的操作	  
            //在这之前应该已经将P表的数据准备好了，U、I、D、未修改的数据都有
            for (i = 0; i < blEndorseDto.getPrpPfeildDtoList().size(); i++) {
                prpPfeildDto = blEndorseDto.getPrpPfeildDtoList().get(i);

                //修改
                if (prpPfeildDto.getOperationFlag().length() > 0 &&
                        prpPfeildDto.getOperationFlag().substring(0, 1).equals("U")) {
                    intCurr =settleService.PrpCfeildSearch(prpPfeildDto.getFeildNo(),responseQueryPolicyInfoDto.getPrpCfeildDtoList());
                    if (intCurr >= 0) {
                        prpCfeildDto = prpCfeildService.PEvaluateC(prpPfeildDto);
                        responseQueryPolicyInfoDto.getPrpCfeildDtoList().add(prpCfeildDto);
                    }
                }
                //新增
                if (prpPfeildDto.getOperationFlag().length() > 0 &&
                        prpPfeildDto.getOperationFlag().substring(0, 1).equals("I")) {
                    intCurr =settleService.PrpCfeildSearch(prpPfeildDto.getFeildNo(),responseQueryPolicyInfoDto.getPrpCfeildDtoList());
                    if (intCurr >= 0) {
                        responseQueryPolicyInfoDto.getPrpCfeildDtoList().remove(intCurr);
                    }
                }
                //删除（保单注销等）
                if (prpPfeildDto.getOperationFlag().length() > 0 &&
                        prpPfeildDto.getOperationFlag().substring(0, 1).equals("D")) {
                    //将p记录转为c记录
                    prpCfeildDto = prpCfeildService.PEvaluateC(prpPfeildDto);
                    //在指定位置插入
                    responseQueryPolicyInfoDto.getPrpCfeildDtoList().add(prpCfeildDto);
                }
                //退保（全单退保等）
                if (prpPfeildDto.getOperationFlag().length() > 0 &&
                        prpPfeildDto.getOperationFlag().substring(0, 1).equals("B")) {
                    intCurr =settleService.PrpCfeildSearch(prpPfeildDto.getFeildNo(),responseQueryPolicyInfoDto.getPrpCfeildDtoList());
                    if (intCurr >= 0) {
                        prpCfeildDto = prpCfeildService.PEvaluateC(prpPfeildDto);
                        responseQueryPolicyInfoDto.getPrpCfeildDtoList().add(prpCfeildDto);
                    }
                }
            }
        }

        return responseQueryPolicyInfoDto.getPrpCfeildDtoList();
    }
}
