package com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.*;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCsubsidyDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyListInfoDto;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl.ShowPrPoEnServiceImpl;
import com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.SpecialEndorIniService;
import com.sinosoft.agriprpall.core.endorsemanage.specialendorse.service.SpecialEndorseCheckService;
import com.sinosoft.agriprpall.core.endorsemanage.util.PubTools;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCitemKindDao;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCsubsidyDao;
import com.sinosoft.agriprpall.core.policymanage.dao.specification.QueryPolicySpecBuilder;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCitemKind;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCsubsidy;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 特殊批改初始化信息查询
 * @Author: ldd
 * @Date: 2018/1/9 18:50
 */
@Service
public class SpecialEndorIniServiceImpl extends BaseServiceImpl implements SpecialEndorIniService {
    /** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(ShowPrPoEnServiceImpl.class);

    @Autowired
    private PrpCsubsidyDao prpCsubsidyDao;
    @Autowired
    private PrpCitemKindDao prpCitemKindDao;
    @Autowired
    private SpecialEndorseCheckService specialEndorseCheckService;
    /**
     *  特殊批改初始化信息
     * @author: ldd
     * @date: 2018/1/9 17:47
     * @param requestSpecialEndorseDto 特殊批改入参
     * @return requestSpecialEndorseDto 返回保单大对象及批改相应条件dto
     */
    public RequestSpecialEndorseDto querySpecialEndorIni(RequestSpecialEndorseDto requestSpecialEndorseDto) throws Exception{
        String message="";
        if(requestSpecialEndorseDto == null){
            throw new DataVerifyException("特殊批改初始化入参不可为空！");
        }
        Date date=new Date();
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        List<BLEndorseDto> blEndorseDtoList = new ArrayList<>();
        EndorseConditionDto endorseConditionDto = requestSpecialEndorseDto.getEndorseConditionDto();
        List<ResponseQueryPolicyListInfoDto> responseQueryPolicyListInfoDtoList=requestSpecialEndorseDto.getResponseQueryPolicyListInfoDtoList();
        if (responseQueryPolicyListInfoDtoList == null || responseQueryPolicyListInfoDtoList.size()==0){
            throw new DataVerifyException("请传入希望批改的相应的批单信息");
        }
        if (endorseConditionDto==null){
            throw new DataVerifyException("请传入相应的批改信息");
        }
        //批改类型
        String endorType = endorseConditionDto.getEndorType();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        SpecialEndorseCheckDto specialEndorseCheckDto=new SpecialEndorseCheckDto();
        String policyNo="";
        BLEndorseDto blEndorseDto;
        for(int i=0;i<responseQueryPolicyListInfoDtoList.size();i++) {
            try {
                if(i>=50){
                    responseQueryPolicyListInfoDtoList.remove(i);
                }
                policyNo=responseQueryPolicyListInfoDtoList.get(i).getPolicyNo();
                specialEndorseCheckDto.setPolicyNo(policyNo);
                specialEndorseCheckDto.setStrEndorType(endorType);
                specialEndorseCheckDto.setEndorDate(endorseConditionDto.getEndorDate());
                System.out.println(format.parse(format.format(endorseConditionDto.getValidDate())));
                specialEndorseCheckDto.setValidDate(format.parse(format.format(endorseConditionDto.getValidDate())));
                specialEndorseCheckDto.setRiskCode(policyNo.substring(1,5));
                specialEndorseCheckDto.setLoginComCode(endorseConditionDto.getLoginComCode());
                specialEndorseCheckDto.setUserCode(endorseConditionDto.getUserCode());
                specialEndorseCheckDto.setLoginGradeCode(endorseConditionDto.getLoginGradeCode());

                message=specialEndorseCheckService.specialEndorseCheck(specialEndorseCheckDto);
                if(StringUtils.isNotEmpty(message)){
                    requestSpecialEndorseDto.setMessage(message);
                    responseQueryPolicyListInfoDtoList.remove(i);
                    i = i -1;
                    continue;
                }
                blEndorseDto=new BLEndorseDto();
                blEndorseDto.setPrpPheadDto(new PrpPheadDto());
                blEndorseDto.getPrpPheadDto().setPolicyNo(policyNo);
                blEndorseDto.getPrpPheadDto().setOperatorCode(endorseConditionDto.getOperatorCode());
                blEndorseDto.getPrpPheadDto().setEndorDate(endorseConditionDto.getEndorDate());
                blEndorseDto.getPrpPheadDto().setValidDate(endorseConditionDto.getValidDate());
                blEndorseDto.getPrpPheadDto().setValidHour(0);
                blEndorseDto.getPrpPheadDto().setAppliName(responseQueryPolicyListInfoDtoList.get(i).getAppliName());
                blEndorseDto.getPrpPheadDto().setEndorseType(endorseConditionDto.getEndoretype());
                blEndorseDtoList.add(blEndorseDto);
            } catch (Exception e) {
                //如果允许批改校验方法throw Exception，说明该保单不允许批改，从List中删去 最多50条保单
                responseQueryPolicyListInfoDtoList.remove(i);
                i = i -1;
            }

        }
        boolean flag=false;
        message=requestSpecialEndorseDto.getMessage();
        if(StringUtils.isEmpty(message)){
            message="";
        }
        for(int i=0;i<responseQueryPolicyListInfoDtoList.size();i++) {
            ResponseQueryPolicyListInfoDto responseQueryPolicyListInfoDto=responseQueryPolicyListInfoDtoList.get(i);
            if(responseQueryPolicyListInfoDto.getIsSeeFeeFlag().equals("0")&&endorType.equals("92")){
                message+=responseQueryPolicyListInfoDto.getPolicyNo()+",";
                responseQueryPolicyListInfoDtoList.remove(i);
                i = i -1;
                flag=true;
            }
        }
        if (flag==true){
            message+="为非见费出单！不可进行见费出单保单注销！";
            requestSpecialEndorseDto.setMessage(message);
        }

        flag=false;
        message=requestSpecialEndorseDto.getMessage();
        if(StringUtils.isEmpty(message)){
            message="";
        }
        for (int i=0;i<responseQueryPolicyListInfoDtoList.size();i++){
            ResponseQueryPolicyListInfoDto responseQueryPolicyListInfoDto=responseQueryPolicyListInfoDtoList.get(i);
            if(responseQueryPolicyListInfoDto.getUnderWriteFlag().equals("4")&&responseQueryPolicyListInfoDto.getIsSeeFeeFlag().equals("1")&&!endorType.equals("92")){
                message+=responseQueryPolicyListInfoDto.getPolicyNo()+",";
                responseQueryPolicyListInfoDtoList.remove(i);
                i = i -1;
                flag=true;
            }
        }
        if(flag==true){
            message+="见费出单未收费，只可进行见费出单保单注销！";
            requestSpecialEndorseDto.setMessage(message);
        }
        flag=false;
        message=requestSpecialEndorseDto.getMessage();
        if(StringUtils.isEmpty(message)){
            message="";
        }
        for (int i=0;i<responseQueryPolicyListInfoDtoList.size();i++){
            ResponseQueryPolicyListInfoDto responseQueryPolicyListInfoDto=responseQueryPolicyListInfoDtoList.get(i);
            Date startDate=sdf.parse(responseQueryPolicyListInfoDto.getStartDate());
            if((!responseQueryPolicyListInfoDto.getUnderWriteFlag().equals("4")||date.compareTo(startDate)>=0)&&responseQueryPolicyListInfoDto.getIsSeeFeeFlag().equals("1")&&endorType.equals("92")){
                message+=responseQueryPolicyListInfoDto.getPolicyNo()+",";
                responseQueryPolicyListInfoDtoList.remove(i);
                i = i -1;
                flag=true;
            }
        }
        if(flag==true){
            message+="见费出单已起保或已实收，不可进行见费出单保单注销！";
            requestSpecialEndorseDto.setMessage(message);
        }
        flag=false;
        message=requestSpecialEndorseDto.getMessage();
        if(StringUtils.isEmpty(message)){
            message="";
        }
        for (int i=0;i<responseQueryPolicyListInfoDtoList.size();i++){
            ResponseQueryPolicyListInfoDto responseQueryPolicyListInfoDto=responseQueryPolicyListInfoDtoList.get(i);
            Date startDate=sdf.parse(responseQueryPolicyListInfoDto.getStartDate());
            if(responseQueryPolicyListInfoDto.getUnderWriteFlag().equals("1")&&date.compareTo(startDate)>=0&&responseQueryPolicyListInfoDto.getIsSeeFeeFlag().equals("1")&&endorType.equals("92")){
                message+=responseQueryPolicyListInfoDto.getPolicyNo()+",";
                responseQueryPolicyListInfoDtoList.remove(i);
                i = i -1;
                flag=true;
            }
        }
        if(flag==true){
            message+="见费出单已收费，不可进行见费出单保单注销！";
            requestSpecialEndorseDto.setMessage(message);
        }
        flag=false;
        message=requestSpecialEndorseDto.getMessage();
        if(StringUtils.isEmpty(message)){
            message="";
        }
        for (int i=0;i<responseQueryPolicyListInfoDtoList.size();i++){
            ResponseQueryPolicyListInfoDto responseQueryPolicyListInfoDto=responseQueryPolicyListInfoDtoList.get(i);
            Date startDate=sdf.parse(responseQueryPolicyListInfoDto.getStartDate());
            if(date.compareTo(startDate)<0&&endorType.equals("21")){
                message+=responseQueryPolicyListInfoDto.getPolicyNo()+",";
                responseQueryPolicyListInfoDtoList.remove(i);
                i = i -1;
                flag=true;
            }
        }
        if(flag==true){
            message+="保单未起保，不可进行全单退保！";
            requestSpecialEndorseDto.setMessage(message);
        }
        List retainList = new ArrayList();
        requestSpecialEndorseDto.setResponseQueryPolicyListInfoDtoList(responseQueryPolicyListInfoDtoList);
        if(responseQueryPolicyListInfoDtoList.size()==0) {
//            requestSpecialEndorseDto.setMessage("所选单号中无可批改的保单！");
            return requestSpecialEndorseDto;
        }else{
            requestSpecialEndorseDto.setBlEndorseDtoList(blEndorseDtoList);
            List<String> policyNoList = new ArrayList<>();
            for (BLEndorseDto b : blEndorseDtoList) {
                policyNoList.add(b.getPrpPheadDto().getPolicyNo());
            }
            retainList = this.queryRetainInfo(endorseConditionDto.getEndorType(),policyNoList);
            requestSpecialEndorseDto.setResponseQueryPolicyListInfoDtoList(retainList);
            retainList.forEach(o -> {
                if (o instanceof String) {
                    String errorMessage = null;
                    if(endorType.equals("71")) {
                        errorMessage = "所选保单补贴信息不完全一致！";
                    } else if(endorType.equals("11") || endorType.equals("91")){
                        errorMessage = "所选保单险别标的信息不完全一致！";
                    }
                    String s = (String) o;
                    String mes = requestSpecialEndorseDto.getMessage();
                    requestSpecialEndorseDto.setMessage(mes != null ? mes : "" + s + errorMessage);
                }
            });
        }
        return requestSpecialEndorseDto;
    }


    /**
     *  获取保单中需要批改的交集信息
     * @author: ldd
     * @date: 2018/1/10 10:36
     * @param endorType 批改类型
     * @param policyNoList 保单号
     * @return resultList
     * @throws Exception
     */
    public List queryRetainInfo(String endorType,List<String> policyNoList) throws Exception{
        List resultList;
        Map<String,List<? extends Object>> retainInfoByPolicyNo = new HashMap<>();
        for(int i=0;i<policyNoList.size();i++){
            String policyNo = policyNoList.get(i);
            List<? extends Object> retainInfo = new ArrayList<>();
            //调整补贴信息
            if(endorType.equals("71")) {
                List<PrpCsubsidyDto> prpCsubsidyDtoList = new ArrayList<>();
                List<PrpCsubsidy> prpCsubsidyList = prpCsubsidyDao.findAll(QueryPolicySpecBuilder.findPrpCsubsidyByPolicyNo(policyNo));
                convertCollection(prpCsubsidyList, prpCsubsidyDtoList, PrpCsubsidyDto.class);
                retainInfo = prpCsubsidyDtoList;
            }
            //11调整费率,91调整单位保额
            else if(endorType.equals("11") || endorType.equals("91")){
                List<PrpCitemKindDto> prpCitemKindDtoList = new ArrayList<>();
                List<PrpCitemKind> prpCitemKindList = prpCitemKindDao.findAll(QueryPolicySpecBuilder.findPrpCitemKindByPolicyNo(policyNo));
                convertCollection(prpCitemKindList,prpCitemKindDtoList,PrpCitemKindDto.class);
                retainInfo = prpCitemKindDtoList;
            }
            retainInfoByPolicyNo.put(policyNo,retainInfo);
        }
        resultList = new PubTools().getRetainList(retainInfoByPolicyNo);
        return resultList;
    }
}
