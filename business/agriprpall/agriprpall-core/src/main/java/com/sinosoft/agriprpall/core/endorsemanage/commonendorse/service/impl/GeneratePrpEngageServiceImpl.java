package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPengageDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCengageDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.GenerateprpEngageService;
import com.sinosoft.framework.agri.core.utils.StringGyUtils;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;

import java.util.*;

public class GeneratePrpEngageServiceImpl extends BaseServiceImpl implements GenerateprpEngageService{
    /**
    * @description
    * @param blPolicyDto
    * @return com.sinosoft.agriprpall.api.policymanage.dto.PrpCengageDto[]
    * @throws
    * @author 李冬松
    * @date 12:07 2017/11/10
    */

        public  PrpCengageDto[] ungroup(ResponseQueryPolicyInfoDto blPolicyDto) throws Exception{
            int           i,j               = 0;              //循环变量
            PrpCengageDto prpCengageDto     = null;           //原有Dto
            PrpCengageDto prpCengageDtoAdd  = null;           //新增Dto
            String[]      arrClauses        = {};             //拆分的条款数组
            Vector        vec               = new Vector();   //数组
            int           intLineNo         = 0;              //行号
            int           intSerialNo       = 0;              //序号

            intLineNo   = 0;
            if(blPolicyDto.getPrpCengageDtoList()==null){
                return  null;
            }
            if(blPolicyDto.getPrpCengageDtoList().size()>0) {
                intSerialNo = blPolicyDto.getPrpCengageDtoList().get(0).getSerialNo();
            }

            //循环拆分
            for (i = 0 ; i < blPolicyDto.getPrpCengageDtoList().size(); i++){
                prpCengageDto = blPolicyDto.getPrpCengageDtoList().get(i);
                //拆分
                if(StringUtils.isNotEmpty(prpCengageDto.getClauses())&&prpCengageDto.getClauses().trim().equals("")){
                    String[] arrTemp = new String[1];
                    arrTemp[0] = "";
                    arrClauses = arrTemp;
                }else{
                    arrClauses = StringGyUtils.split(prpCengageDto.getClauses(),80);
                }
                //判断是否重新计算行号
                if (intSerialNo!=prpCengageDto.getSerialNo()){
                    intLineNo=0;
                    intSerialNo=prpCengageDto.getSerialNo();
                }

                //赋值
                for(j = 0; j<arrClauses.length; j++){
                    //长度校验
                    if(arrClauses[j].length() > 80){
                        throw new DataVerifyException("长度超过80！");
                    }

                    intLineNo++; //行号加一
                    prpCengageDtoAdd = new PrpCengageDto();
                    prpCengageDtoAdd.setPolicyNo(prpCengageDto.getPolicyNo());
                    prpCengageDtoAdd.setRiskCode(prpCengageDto.getRiskCode());
                    prpCengageDtoAdd.setSerialNo(prpCengageDto.getSerialNo());
                    prpCengageDtoAdd.setLineNo(intLineNo);
                    prpCengageDtoAdd.setClauseCode(prpCengageDto.getClauseCode());
                    prpCengageDtoAdd.setClauses(arrClauses[j]); //节FIELDLENGHT长
                    prpCengageDtoAdd.setTitleFlag(prpCengageDto.getTitleFlag());
                    prpCengageDtoAdd.setFlag(prpCengageDto.getFlag());
                    vec.add(prpCengageDtoAdd);
                }
            }
            return (PrpCengageDto[]) vec.toArray(new PrpCengageDto[vec.size()]);
        }

        /**
        * @description
        * @param blPolicyDto
        * @return java.util.Map
        * @throws
        * @author 李冬松
        * @date 12:07 2017/11/10
        */
    public  Map getGroupedEngages(ResponseQueryPolicyInfoDto blPolicyDto) throws Exception {
        PrpCengageDto prpCengageDto;
        Map engagesGroupBySerialNo = new HashMap();
        List prpCengageDtoList = null;
        for (int i = 0; i < blPolicyDto.getPrpCengageDtoList().size(); i++) {
            prpCengageDto = blPolicyDto.getPrpCengageDtoList().get(i);
            int serialNo = prpCengageDto.getSerialNo();
            if (!engagesGroupBySerialNo.containsKey(serialNo)){
                //新添一组engage
                prpCengageDtoList = new ArrayList();
                engagesGroupBySerialNo.put(serialNo, prpCengageDtoList);
            }else{
                prpCengageDtoList = (ArrayList)engagesGroupBySerialNo.get(serialNo);
            }
            prpCengageDtoList.add(prpCengageDto);
        }
        return engagesGroupBySerialNo;
    }
    /**
     * @description
     * @param flag
     * @param newEngagesList
     * @param blEndorseDto
     * @return void
     * @throws
     * @author 李冬松
     * @date 12:07 2017/11/10
     */
    public  void addPEngage(String flag, List newEngagesList,BLEndorseDto blEndorseDto)
            throws Exception {
        //List<PrpPengageDto> prpPengageDtoList = new ArrayList<>();
        PrpPengageDto prpPengageDto=null;
        for (int j = 0; j < newEngagesList.size(); j++) {
            PrpCengageDto prpCengageDto =  (PrpCengageDto)newEngagesList.get(j);
            prpPengageDto = new PrpPengageDto();
            prpPengageDto.setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
            prpPengageDto.setPolicyNo(prpCengageDto.getPolicyNo());
            prpPengageDto.setRiskCode(prpCengageDto.getRiskCode());
            prpPengageDto.setSerialNo(prpCengageDto.getSerialNo());
            prpPengageDto.setLineNo(prpCengageDto.getLineNo());
            prpPengageDto.setClauseCode(prpCengageDto.getClauseCode());
            prpPengageDto.setClauses(prpCengageDto.getClauses());
            prpPengageDto.setTitleFlag(prpCengageDto.getTitleFlag());
            prpPengageDto.setFlag(flag);//批单标志

            //prpPengageDtoList.add(prpPengageDto);
        }
        blEndorseDto.getPrpPengageDtoList().add(prpPengageDto);
    }
}
