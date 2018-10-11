package com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLPolicyDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PolicyEndorseDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCsubsidyDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.SpecialEndor71Service;
import com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.SpecialEndorRefreshPlanService;
import com.sinosoft.agriprpall.core.endorsemanage.util.PubTools;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.exception.DataVerifyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;


@Service
public class SpecialEndor71ServiceImpl extends BaseServiceImpl implements SpecialEndor71Service {
    private static final Logger LOGGER= LoggerFactory.getLogger(SpecialEndor71ServiceImpl.class);

    @Autowired
    private SpecialEndorRefreshPlanService specialEndorRefreshPlanService;


    /**
     * 调整补贴信息信息流转
     * @author: 刘曼曼
     * @date: 2017/12/15 9:34
     * @param policyEndorseDto 保单，批单大对象
     * @return  EndorsePolicyDto 保单，批单大对象
     * @throws Exception
     */
    @Override
    public PolicyEndorseDto specialEndorse71(PolicyEndorseDto policyEndorseDto,List<PrpCsubsidyDto> prpCsubsidyDtos)throws Exception {
        ResponseQueryPolicyInfoDto blPolicy=policyEndorseDto.getBlPolicyInfoDtoNew();
        if (null == policyEndorseDto) {
            throw new DataVerifyException("页面参数不能为空！");
        }
        //总保费
        Double sumPremium = specialEndorRefreshPlanService.getSumAmountPermiumFee(policyEndorseDto.getBlPolicyInfoDtoOld().getPrpCfeeDtoList());
        PubTools pubTools = new PubTools();
        PolicyEndorseDto endorsePolicyDto = new PolicyEndorseDto();
        List<PrpCsubsidyDto> prpCsubsidyDtoListNew = policyEndorseDto.getBlPolicyInfoDtoNew().getPrpCsubsidyDtoList();
        List<PrpCsubsidyDto> prpCsubsidyDtoListOld = policyEndorseDto.getBlPolicyInfoDtoOld().getPrpCsubsidyDtoList();

        HashMap<String,PrpCsubsidyDto> subsidyMap = new HashMap();
        for (int i=0; i < prpCsubsidyDtos.size(); i++) {
            subsidyMap.put(prpCsubsidyDtos.get(i).getSubsidyCode(), prpCsubsidyDtos.get(i));
        }
        for (int j = 0; j < blPolicy.getPrpCsubsidyDtoList().size(); j++) {
            prpCsubsidyDtoListNew.get(j).setOperationFlag(" ");
            if (subsidyMap.containsKey(blPolicy.getPrpCsubsidyDtoList().get(j).getSubsidyCode())) {
                String subsidyCodeKey = blPolicy.getPrpCsubsidyDtoList().get(j).getSubsidyCode();
                //入参DTO
                PrpCsubsidyDto prpCsubsidyDtoInput = subsidyMap.get(subsidyCodeKey);
                //出参DTO
                PrpCsubsidyDto prpCsubsidyDtoNew = blPolicy.getPrpCsubsidyDtoList().get(j);

                if("01".equals(prpCsubsidyDtoNew.getSubsidyType()) && prpCsubsidyDtoInput.getSubsidyRate()!=null){//比例补贴
                    if(prpCsubsidyDtoInput.getSubsidyRate() != prpCsubsidyDtoNew.getSubsidyRate()) {
                        prpCsubsidyDtoNew.setSubsidyRate(prpCsubsidyDtoInput.getSubsidyRate());
                        //补贴金额计算
                        Double subsidyPremium = new BigDecimal(sumPremium).multiply(new BigDecimal(prpCsubsidyDtoListNew.get(j).getSubsidyRate()).divide(BigDecimal.TEN.multiply(BigDecimal.TEN))).doubleValue();
                        prpCsubsidyDtoListNew.get(j).setSubsidyPremium(subsidyPremium);
                        prpCsubsidyDtoListNew.get(j).setOperationFlag("U");
                    }
                }else if(prpCsubsidyDtoInput.getSubsidyPremium()!=null){
                    if(prpCsubsidyDtoInput.getSubsidyPremium() != prpCsubsidyDtoNew.getSubsidyPremium()){
                        prpCsubsidyDtoNew.setSubsidyPremium(prpCsubsidyDtoInput.getSubsidyPremium());
                        //计算补贴比例
                        Double  subsidyRate=(new BigDecimal(prpCsubsidyDtoListNew.get(j).getSubsidyPremium()).divide(new BigDecimal(sumPremium))).multiply(BigDecimal.TEN.multiply(BigDecimal.TEN)).doubleValue();
                        prpCsubsidyDtoListNew.get(j).setSubsidyRate(subsidyRate);
                        prpCsubsidyDtoListNew.get(j).setOperationFlag("U");
                    }
                }
                if(prpCsubsidyDtoInput.getSubsidyDepartment()!=null){
                    if(prpCsubsidyDtoInput.getSubsidyDepartment() != prpCsubsidyDtoNew.getSubsidyDepartment()){
                        prpCsubsidyDtoNew.setSubsidyDepartment(prpCsubsidyDtoInput.getSubsidyDepartment());
                        prpCsubsidyDtoListNew.get(j).setOperationFlag("U");
                    }
                }
            }
        }


        if (prpCsubsidyDtoListOld.size() == 0) {
            throw new DataVerifyException("查询的补贴信息集合长度为空！");
        }
        //获得查询的第一条补贴信息
        PrpCsubsidyDto prpCsubsidyDtoOld1 = prpCsubsidyDtoListOld.get(0);
        HashMap subsidyDtoNewMap = new HashMap();
        for (int i = 0; i < prpCsubsidyDtoListNew.size(); i++) {
            //避免发生空值
            if (null == prpCsubsidyDtoListNew.get(i).getSubsidyRate()) {
                prpCsubsidyDtoListNew.get(i).setSubsidyRate(0.0);
            }
            //给补贴类型名称赋值
            if ("03".equals(prpCsubsidyDtoListNew.get(i).getSubsidyCode())) {
                prpCsubsidyDtoListNew.get(i).setSubsidyName("中央财政");
            } else if ("04".equals(prpCsubsidyDtoListNew.get(i).getSubsidyCode())) {
                prpCsubsidyDtoListNew.get(i).setSubsidyName("省级财政");
            } else if ("05".equals(prpCsubsidyDtoListNew.get(i).getSubsidyCode())) {
                prpCsubsidyDtoListNew.get(i).setSubsidyName("地市县财政");
            } else if ("07".equals(prpCsubsidyDtoListNew.get(i).getSubsidyCode())) {
                prpCsubsidyDtoListNew.get(i).setSubsidyName("县(区)财政");
            } else {
                prpCsubsidyDtoListNew.get(i).setSubsidyName("其他来源");
            }
        }
        //放入对象
        policyEndorseDto.getBlPolicyInfoDtoNew().setPrpCsubsidyDtoList(prpCsubsidyDtoListNew);
        return policyEndorseDto;
    }

}
