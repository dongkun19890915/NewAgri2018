package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPheadDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.PrpPheadDao;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.PrpPhead;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.BLEndroseService;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.BackWardService;
import com.sinosoft.agriprpall.core.policymanage.service.PolicyQueryService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BLEndroseServiceImpl extends BaseServiceImpl implements BLEndroseService {

    /** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(BLEndroseServiceImpl.class);

    @Autowired
    private PrpPheadDao prpPheadDao;
    @Autowired
    public PolicyQueryService policyQueryService;
    @Autowired
    private BackWardService backWardService;
    /**
     * 保单还原到任意的时间点
     * @author: 刘曼曼
     * @date: 2017/11/27 17:32
     * @param policyNo 保单号
     * @param backWardDate 出险日期
     * @return ResponseQueryPolicyInfoDto 保单大对象
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseQueryPolicyInfoDto getBackWardPolicy(String policyNo, String backWardDate) throws Exception {
        ResponseQueryPolicyInfoDto blpolicy = new ResponseQueryPolicyInfoDto();
        List<PrpPheadDto> prpPheadDtos = new ArrayList<PrpPheadDto>();
        PrpPheadDto prpPheadDto = new PrpPheadDto();

        //获取当前保单的最新数据
        blpolicy=policyQueryService.queryPolicyInfoByPolicyNo(policyNo);
        Date date=DateUtils.strToDate(backWardDate);
        List<PrpPhead> prpPheadList=prpPheadDao.queryPrpPheadInfo(policyNo,date);
        this.convertCollection(prpPheadList,prpPheadDtos,PrpPheadDto.class);

        //逐级回倒
        for (int i = 0; i < prpPheadDtos.size(); i++) {
            prpPheadDto=prpPheadDtos.get(i);
            backWardService.backWard(prpPheadDto.getEndorseNo(),blpolicy);
            blpolicy.getPrpCmainDto();
            blpolicy.getPrpCengageDtoList();
        }
        return blpolicy;
    }

    /**
     * 获取原始保单信息
     * @author: 刘曼曼
     * @date: 2017/11/28 10:48
     * @param policyNo 保单号
     * @return ResponseQueryPolicyInfoDto 保单大对象
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseQueryPolicyInfoDto getOriginalPolicy(String policyNo) throws Exception {
        ResponseQueryPolicyInfoDto blpolicy = new ResponseQueryPolicyInfoDto();
        List<PrpPheadDto> prpPheadDtos = new ArrayList<PrpPheadDto>();
        PrpPheadDto prpPheadDto = new PrpPheadDto();

        //获取当前保单的最新数据
        blpolicy=policyQueryService.queryPolicyInfoByPolicyNo(policyNo);
        List<PrpPhead> prpPheadList=prpPheadDao.queryPrpPheadInfoList(policyNo);
        this.convertCollection(prpPheadList,prpPheadDtos,PrpPheadDto.class);
        //逐级回倒
        for (int i = 0; i < prpPheadDtos.size(); i++) {
            prpPheadDto=prpPheadDtos.get(i);
            backWardService.backWard(prpPheadDto.getEndorseNo(),blpolicy);
        }
        return blpolicy;
    }

}
