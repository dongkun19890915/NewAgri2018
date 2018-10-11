package com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.impl;

import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCrenewalDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.DeletePrpJDateService;
import com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.PolicyCancellationService;
import com.sinosoft.agriprpall.core.policymanage.service.*;
import com.sinosoft.agriprpall.core.proposalmanage.dao.PrpTmainDao;
import com.sinosoft.agriprpall.core.proposalmanage.entity.PrpTmain;
import com.sinosoft.dms.api.billno.BillNoApi;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PolicyCancellationServiceImpl extends BaseServiceImpl implements PolicyCancellationService {

    @Autowired
    private PrpCmainService prpCmainService;
    @Autowired
    private PrpCrenewalService prpCrenewalService;
    @Autowired
    private PolicyCancelService cancelService;
    @Autowired
    private PrpTmainDao prpTmainDao;
    @Autowired
    private PolicyOriginCancelService policyOriginCancelService;
    @Autowired
    private BillNoApi billNoApi;
    @Autowired
    private PrpDrenewalTraceService prpDrenewalTraceService;
    @Autowired
    private DeletePrpJDateService deletePrpJDateService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void cancellation(ResponseQueryPolicyInfoDto blPolicy, String policyNo) throws Exception{
        if (StringUtils.isEmpty(policyNo)){
            throw new DataVerifyException("请传入保单号");
        }
        String certiType="P";


        blPolicy.setPrpCmainDto(prpCmainService.queryByPK(policyNo));
        List<PrpCrenewalDto> prpCrenewalDtoListTemp=prpCrenewalService.queryByPolicyNo(policyNo);
        String oldPolicyNo="";

        //更新被续保保单的续保标志 Start
        if (prpCrenewalDtoListTemp.size()>0){
            PrpCrenewalDto prpCrenewalDtoTemp=prpCrenewalDtoListTemp.get(0);
            oldPolicyNo=prpCrenewalDtoTemp.getOldPolicyNo();
            //查找是否存在其他被续保业务，如果有，则不改写被续保标志，否则改写续保标志为0
            List<PrpCrenewalDto> prpCrenewalDtoListOld=prpCrenewalService.queryByOldPolicyNo(policyNo,oldPolicyNo);
            List<PrpCmainDto> prpCmainDtoList=prpCmainService.queryByOldPolicyNo(oldPolicyNo);
            if (prpCmainDtoList.size()>0){
                String othFlagTemp=prpCmainDtoList.get(0).getOthFlag();
                //判断是否要改写被续保保单的被续保标志
                if (othFlagTemp.length()>2 && prpCrenewalDtoListOld.size()==0){
                    othFlagTemp=othFlagTemp.substring(0,1)+"0"+othFlagTemp.substring(2);
                }
                prpCmainDtoList.get(0).setOthFlag(othFlagTemp);
                prpCmainService.updatePrpCmain(prpCmainDtoList);
            }
        }
        //更新被续保保单的续保标志 End

        //todo cancel(policyNo,"Y")
        cancelService.cancel(policyNo,"Y");


        List<PrpCrenewalDto> prpCrenewalDtoList=new ArrayList<>();

        // todo 删除续保轨迹表数据2013-01-28 PrpDrenewalTrace
        prpDrenewalTraceService.deleteByPolicyNo(policyNo);

        /** 原始保单删除 */
        //todo 原始保单删除
        policyOriginCancelService.originCancel(policyNo,"Y");

        /** 投保单置为撤销 */
        String proposalNo=blPolicy.getPrpCmainDto().getProposalNo();
        PrpTmain prpTmain= prpTmainDao.findByProposalNo(proposalNo);
        prpTmain.setOthFlag("000200YY000000000000");
        prpTmainDao.save(prpTmain);

        /** 收付数据删除 */
        //todo 收付数据删除
        deletePrpJDateService.deletePrpJDate(policyNo);
        /** 收回保单号 */
        //todo 收回保单号
        Map<String,String> map=new HashMap<>();
        map.put("tableName","prpcmain");
        map.put("billNo",policyNo);
        billNoApi.putNo(map);


    }
}
