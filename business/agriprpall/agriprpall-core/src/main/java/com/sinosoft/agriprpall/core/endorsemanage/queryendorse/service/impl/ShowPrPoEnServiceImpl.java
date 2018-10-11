package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.RequestShowPrPoEnDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.BLEndroseService;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.BackWardService;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.ShowPrPoEnService;
import com.sinosoft.agriprpall.core.policymanage.service.PolicyQueryService;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCmainService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 根据出险日期查询当期批单
 * @author 王保良,刘曼曼
 * @date 2017年10月28日
 */
@Service
public class ShowPrPoEnServiceImpl extends BaseServiceImpl implements ShowPrPoEnService {
    /** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(ShowPrPoEnServiceImpl.class);

    @Autowired
    private PrpCmainService prpCmainService;
    @Autowired
    private PolicyQueryService policyQueryService;
    @Autowired
    private BackWardService backWardService;
    @Autowired
    private BLEndroseService blEndroseService;





    /**
     * 根据出险日期查询批单号
     * @param requestShowPrPoEnDto 查询所需参数Dto
     * @return ResponseQueryPolicyInfoDto 保单大对象
     * @author 王保良,刘曼曼
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PolicyEndorseDto showPrPoEnInfo(RequestShowPrPoEnDto requestShowPrPoEnDto) throws Exception {
        String bizType=requestShowPrPoEnDto.getBizType();
        String policyNo=requestShowPrPoEnDto.getBizNo();
        String damageDate=requestShowPrPoEnDto.getDamageDate();
        String[] familyNos =requestShowPrPoEnDto.getFamilyNos();

        //业务类型校验
        if (!("BIZTYPE_POLICY").equals(bizType.trim())){
            throw new DataVerifyException("业务类型不明确");
        }
        if (StringUtils.isEmpty(policyNo)){
            throw new DataVerifyException("业务单号不详");
        }
        if (familyNos==null){
            familyNos=new String[0];
        }

        ResponseQueryPolicyInfoDto blPolicyDto=new ResponseQueryPolicyInfoDto();
        PolicyEndorseDto policyEndorseDto=new PolicyEndorseDto();

//        if ("BIZTYPE_POLICY".equals(requestShowPrPoEnDto.getBizType())) {
//            if (isOriginalPolicy!=null&&"Y".equals(isOriginalPolicy)) {
//                BLEndorseDto blEndorseDto = new BLEndorseDto();
//                blPolicyDto = blEndroseService.getOriginalPolicy(policyNo);
//                //特殊因子批单则查询C表
//                if (blPolicyDto.getPrpCplanDtoList().size() == 0) {
//                    //团单显示时不查询客户资料数据出来
//                    String messType = blPolicyDto.getPrpCmainDto().getFlag();
//                    String classCode = blPolicyDto.getPrpCmainDto().getClassCode();
//                    if (messType != null && messType.length() > 1) {
//                        messType = messType.substring(1, 2);
//                    } else {
//                        messType = "";
//                    }
//                    blPolicyDto = new ResponseQueryPolicyInfoDto();
//                    if (!messType.trim().equals("")) {//团单
//                        blPolicyDto = policyQueryService.queryPolicyInfoByCondition(policyNo, familyNos);
//                    } else {
//                        blPolicyDto = policyQueryService.queryPolicyInfoByPolicyNo(policyNo);
//                    }
//                }
//            }
//            else {
                blPolicyDto = new ResponseQueryPolicyInfoDto();
                //团单显示时不查询客户资料数据出来
                PrpCmainDto prpCmainDto = prpCmainService.queryByPK(policyNo);
                if (prpCmainDto == null) {
                    throw new DataVerifyException("保单号" + requestShowPrPoEnDto.getBizType() + "不存在");
                }
                String messType = prpCmainDto.getFlag();
                if (messType != null && messType.length() > 1) {
                    messType = messType.substring(1, 2);
                } else {
                    messType = "";
                }
                //如果提供了参数，则进行保单还原
                if (!StringUtils.isEmpty(damageDate)) {
                    if (damageDate.length() > 10) {
                        damageDate = damageDate.substring(0, 10);
                    }
                    BLEndorseDto blEndorseDto = new BLEndorseDto();
                    blPolicyDto = blEndroseService.getBackWardPolicy(policyNo, damageDate);
                } else {
                    //如果，没有提供该参数，则不进行保单还原
                    if (!messType.trim().equals("")) {//团单
                        blPolicyDto = policyQueryService.queryPolicyInfoByCondition(policyNo, familyNos);
                    } else {
                        blPolicyDto = policyQueryService.queryPolicyInfoByPolicyNo(policyNo);
                    }
                }
        policyEndorseDto.setBlPolicyInfoDtoNew(blPolicyDto);
        return policyEndorseDto;
//            }
        }

    }

