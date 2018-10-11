package com.sinosoft.agriprpall.core.policymanage.service.impl;

import com.sinosoft.agriprpall.api.policymanage.dto.ResItemKindDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseItemKindDto;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCitemKindAgriDao;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCitemKindDao;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCmainDao;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCitemKind;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCitemKindAgri;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmain;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmainKey;
import com.sinosoft.agriprpall.core.policymanage.service.PolicyPrintService;
import com.sinosoft.dms.api.dict.PrpDcodeApi;
import com.sinosoft.dms.api.dict.dto.PrpDcodeDto;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-22 07:54:48.524 
 * @description 保单标的子险信息表Core接口实现
 */
@Service
public class PolicyPrintServiceImpl extends BaseServiceImpl implements PolicyPrintService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PolicyPrintServiceImpl.class);
    
    @Autowired
    private PrpCitemKindDao prpCitemKindDao;
    @Autowired
    private PrpCitemKindAgriDao prpCitemKindAgriDao;
    @Autowired
    private PrpCmainDao prpCmainDao;
    @Autowired
    private PrpDcodeApi prpDcodeApi;

    /**
     * @description: 根据保单号查询险别信息
     * @author: 何伟东
     * @date: 2017/10/22 16:20
     * @param policyNo 保单号
     * @param type main:主险，sub:附加险，null:不筛选
     * @return
     */
    @Override
    public ResItemKindDto queryItemKindListByPolicyNo(String policyNo, String type) {
        if (StringUtils.isEmpty(policyNo)) {
            throw new DataVerifyException("保单号不能为空");
        }
        PrpCmain prpCmain = prpCmainDao.findOne(new PrpCmainKey(policyNo));
        PrpDcodeDto prpDcodeDto = null;
        if (StringUtils.isNotEmpty(prpCmain.getStatUnitCode())){
            prpDcodeDto = prpDcodeApi.queryByPK("Unit", prpCmain.getStatUnitCode());
        }
        ResItemKindDto resItemKindDto = new ResItemKindDto();
        resItemKindDto.setPolicyNo(policyNo);
        resItemKindDto.setOperateDate(prpCmain.getOperateDate());
        List<ResponseItemKindDto> responseItemKindDtoList = new ArrayList<>();
        List<PrpCitemKind> prpCitemKindList = prpCitemKindDao.findByPolicyNo(policyNo);
        List<PrpCitemKindAgri> prpCitemKindAgriList = prpCitemKindAgriDao.findByPolicyNo(policyNo);
        for (PrpCitemKind prpCitemKind : prpCitemKindList) {
            if (StringUtils.isNotEmpty(type)) {
                if ("main".equals(type) && "1".equals(prpCitemKind.getFlag().substring(1,2))) {
                    ResponseItemKindDto responseItemKindDto = this.toResponseDate(prpCitemKind, prpCitemKindAgriList);
                    responseItemKindDto.setUnit(prpDcodeDto != null ? prpDcodeDto.getCodeCName() : null);
                    if("3224".equals(prpCitemKind.getRiskCode())){
                        responseItemKindDto.setUnitOutPut(responseItemKindDto.getUnitCost());
                        responseItemKindDto.setUnitCost("0.00");
                    }
                    responseItemKindDtoList.add(responseItemKindDto);
                } else if ("sub".equals(type) && "2".equals(prpCitemKind.getFlag().substring(1,2))){
                    ResponseItemKindDto responseItemKindDto = this.toResponseDate(prpCitemKind, prpCitemKindAgriList);
                    responseItemKindDto.setUnit(prpDcodeDto != null ? prpDcodeDto.getCodeCName() : null);
                    if("3224".equals(prpCitemKind.getRiskCode())){
                        responseItemKindDto.setUnitOutPut(responseItemKindDto.getUnitCost());
                        responseItemKindDto.setUnitCost("0.00");
                    }
                    responseItemKindDtoList.add(responseItemKindDto);
                }
            }else{
                ResponseItemKindDto responseItemKindDto = this.toResponseDate(prpCitemKind, prpCitemKindAgriList);
                responseItemKindDto.setUnit(prpDcodeDto != null ? prpDcodeDto.getCodeCName() : null);
                responseItemKindDtoList.add(responseItemKindDto);
            }
        }
        resItemKindDto.setResponseItemKindDtoList(responseItemKindDtoList);
        return resItemKindDto;
    }

    /**
     * @description: 将符合条件的数据放到ResponseItemKindDto中
     * @author: 何伟东
     * @date: 2017/10/22 17:41
     * @param prpCitemKind 险别信息
     * @param prpCitemKindAgriList 农险险别信息
     * @return
     */
    private ResponseItemKindDto toResponseDate(PrpCitemKind prpCitemKind, List<PrpCitemKindAgri> prpCitemKindAgriList){
        ResponseItemKindDto responseItemKindDto = convert(prpCitemKind, ResponseItemKindDto.class);
        responseItemKindDto.setAmount(this.doubleToStr(prpCitemKind.getAmount(),2));
        responseItemKindDto.setRate(this.doubleToStr(prpCitemKind.getRate(),2));
        responseItemKindDto.setPremium(this.doubleToStr(prpCitemKind.getPremium(),2));
        responseItemKindDto.setDeductibleRate(this.doubleToStr(prpCitemKind.getDeductibleRate(),4));
        responseItemKindDto.setUnitAmount(this.doubleToStr(prpCitemKind.getUnitAmount(),2));
        for (PrpCitemKindAgri prpCitemKindAgri : prpCitemKindAgriList){
            if (prpCitemKind.getPolicyNo().equals(prpCitemKindAgri.getPolicyNo())
                    && prpCitemKind.getItemKindNo().equals(prpCitemKindAgri.getItemKindNo())
                    && prpCitemKind.getKindCode().equals(prpCitemKindAgri.getKindCode())){
                responseItemKindDto.setGrossQuantity(this.doubleToStr(prpCitemKindAgri.getGrossQuantity(),2));
                responseItemKindDto.setUnitCost(this.doubleToStr(prpCitemKindAgri.getUnitCost(),2));
                responseItemKindDto.setUnitOutPut(this.doubleToStr(prpCitemKindAgri.getUnitOutput(),2));
                responseItemKindDto.setTimesAmount(this.doubleToStr(prpCitemKindAgri.getTimesAmount(),2));
            }
        }
        return responseItemKindDto;
    }

    /**
     * 将Double转换为字符串
     * @author: 何伟东
     * @date: 2017/11/29 15:35
     * @param val Double的值
     * @param i 保留小数位数
     * @return 如果入参是null返回0.00
     */
    private String doubleToStr(Double val, int i) {
        String patten="0.0";
        for (int a=1;a<i;a++) {
            patten += "0";
        }
        DecimalFormat decimalFormat = new DecimalFormat(patten);
        val = val == null ? 0.0 : val;
        String strVal = decimalFormat.format(val);
        return strVal;
    }
}