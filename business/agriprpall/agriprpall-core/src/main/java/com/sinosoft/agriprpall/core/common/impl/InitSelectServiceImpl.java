package com.sinosoft.agriprpall.core.common.impl;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.common.dto.SelectTagCodeDto;
import com.sinosoft.agriprpall.api.common.dto.SelectTagListDto;
import com.sinosoft.agriprpall.api.common.dto.SelectTagRetuenDto;
import com.sinosoft.agriprpall.core.common.InitSelectService;
import com.sinosoft.dms.api.dict.PrpCountryCodeApi;
import com.sinosoft.dms.api.dict.PrpDcodeApi;
import com.sinosoft.dms.api.dict.PrpDcurrencyApi;
import com.sinosoft.dms.api.dict.PrpTownCodeApi;
import com.sinosoft.dms.api.dict.dto.*;
import com.sinosoft.dms.api.model.PrpMmodelMainApi;
import com.sinosoft.dms.api.model.dto.PrpMmodelMainDto;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.kernel.PrpDcompanyApi;
import com.sinosoft.ims.api.kernel.PrpDuserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.ims.api.kernel.dto.QueryComCodeInfoDto;
import com.sinosoft.ims.api.kernel.dto.RequestPrpDuserDto;
import com.sinosoft.pms.api.kernel.*;
import com.sinosoft.pms.api.kernel.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**共共封装请求dto(主要针对返回参数只有codeCode、codeCname)
 * @Author: 田健
 * @Date: 2017/12/12 10:29
 */
@Service
public class InitSelectServiceImpl implements InitSelectService {

    @Autowired
    private PrpDcompanyApi prpDcompanyApi;
    @Autowired
    private PrpDuserApi prpDuserApi;
    @Autowired
    private PrpDcodeApi prpDcodeApi;
    @Autowired
    private PrpTownCodeApi prpTownCodeApi;
    @Autowired
    private PrpCountryCodeApi prpCountryCodeApi;
    @Autowired
    private PrpDcurrencyApi prpDcurrencyApi;
    @Autowired
    private PrpMmodelMainApi prpMmodelMainApi;
    @Autowired
    private PrpDclauseCodeApi prpDclauseCodeApi;
    @Autowired
    private PrpDriskApi prpDriskApi;
    @Autowired
    private PrpDclauseApi prpDclauseApi;
    @Autowired
    private PrpDclauseCodeKindApi prpDclauseCodeKindApi;
    @Autowired
    private PrpDitemAgriApi prpDitemAgriApi;
    @Autowired
    private PrpDkindAgriApi prpDkindAgriApi;
    /**
     * 根据条件查询信息,当codeType为ComCode时，查询归属机构，当codeType为Handler2Code时，查询归属业务员，当codeType为BusinessProvince时，查询归属区域：省份，
     *                  codeType为BusinessTown时，查询，当codeType为BusinessCountry时，查询归属区域：区县，当codeType为BusinessCity时，查询归属区域：乡镇，
     *                  当codeType为BusinessAreaName时，查询归属区域：村，当codeType为Currency时，查询查询币别信息，当codeType为KindCode0时，查询查询险别信息，
     *                  当codeType为时，查询，当codeType为Model时，查询询模板配置主表信息，当codeType为Clause时，查询条款信息
     * @author: 田健
     * @date: 2017/12/12 10:57
     * @param selectTagListDto 查询请求Dto ，codeType业务类型，riskCode险种代码，codeCode、upperCode、codeCName、comCode、userCode、methodCode等可以复用
     * @return SelectTagRetuenDto 返回Dto
     * @throws Exception
     */
    @Override
    public SelectTagRetuenDto initSelect(SelectTagListDto selectTagListDto) throws Exception {
        SelectTagRetuenDto selectTagRetuenDto = new SelectTagRetuenDto();
        if (AgriPrpallConstant.AGRI_PRPALL_SERVICE_COMCODE.equals(selectTagListDto.getCodeType())) {//归属机构查询
            QueryComCodeInfoDto queryComCodeInfoDto = new QueryComCodeInfoDto();
            queryComCodeInfoDto.setComCName(selectTagListDto.getCodeCName());
            queryComCodeInfoDto.setComCode(selectTagListDto.getComCode());
            queryComCodeInfoDto.setRiskCode(selectTagListDto.getRiskCode());
            queryComCodeInfoDto.setGradeCodes(selectTagListDto.getMethodCode());//借用MethodCode存放岗位代码
            queryComCodeInfoDto.setUserCode(selectTagListDto.getUserCode());
            queryComCodeInfoDto.setLoginComCode(selectTagListDto.getUpperCode());
            List<PrpDcompanyDto> prpDcompanyDtoList = prpDcompanyApi.queryComCodeInfo(queryComCodeInfoDto);
            for (int i = 0; i < prpDcompanyDtoList.size(); i++) {
                SelectTagCodeDto selectTagCodeDto = new SelectTagCodeDto();
                selectTagCodeDto.setCodeCode(prpDcompanyDtoList.get(i).getComCode());
                selectTagCodeDto.setCodeName(prpDcompanyDtoList.get(i).getComCName());
                selectTagRetuenDto.getCodeData().add(selectTagCodeDto);
            }
        } else if (AgriPrpallConstant.AGRI_PRPALL_SERVICE_HANDLER2CODE.equals(selectTagListDto.getCodeType())) {//归属业务员查询
            try {
                RequestPrpDuserDto requestPrpDuserDto = new RequestPrpDuserDto();
                requestPrpDuserDto.setRiskCode(selectTagListDto.getRiskCode());
                requestPrpDuserDto.setUserCode(selectTagListDto.getUserCode());
                requestPrpDuserDto.setUserName(selectTagListDto.getReserve1());//借用reserve1字段
                requestPrpDuserDto.setLoginComCode(selectTagListDto.getUpperCode());
                requestPrpDuserDto.setLoginGradeCodes(selectTagListDto.getMethodCode());//借用MethodCode存放岗位代码
                List<PrpDuserDto> prpDuserDtoList = prpDuserApi.queryHandler1CodeInfo(requestPrpDuserDto);
                for (int i = 0; i < prpDuserDtoList.size(); i++) {
                    SelectTagCodeDto selectTagCodeDto = new SelectTagCodeDto();
                    selectTagCodeDto.setCodeCode(prpDuserDtoList.get(i).getUserCode());
                    selectTagCodeDto.setCodeName(prpDuserDtoList.get(i).getUserName());
                    selectTagRetuenDto.getCodeData().add(selectTagCodeDto);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (AgriPrpallConstant.AGRI_PRPALL_SERVICE_BUSINESSPROVINCE.equals(selectTagListDto.getCodeType()) || AgriPrpallConstant.AGRI_PRPALL_SERVICE_BUSINESSTOWN.equals(selectTagListDto.getCodeType())
                || AgriPrpallConstant.AGRI_PRPALL_SERVICE_BUSINESSCOUNTRY.equals(selectTagListDto.getCodeType())) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("codeType", selectTagListDto.getCodeType());
            map.put("fieldExt", selectTagListDto.getMethodCode());//借用MethodCode存放filldExt
            List<PrpDcodeDto> prpDcodeDtoList = prpDcodeApi.queryAreasProvinceInfo(map);
            for (int i = 0; i < prpDcodeDtoList.size(); i++) {
                SelectTagCodeDto selectTagCodeDto = new SelectTagCodeDto();
                selectTagCodeDto.setCodeCode(prpDcodeDtoList.get(i).getCodeCode());
                selectTagCodeDto.setCodeName(prpDcodeDtoList.get(i).getCodeCName());
                selectTagRetuenDto.getCodeData().add(selectTagCodeDto);
            }
            }else if(AgriPrpallConstant.AGRI_PRPALL_SERVICE_BUSINESSCITY.equals(selectTagListDto.getCodeType())){
                Map<String,String> map = new HashMap<String,String>();
                map.put("codeType",selectTagListDto.getCodeType());
                map.put("fieldExt",selectTagListDto.getMethodCode());//借用MethodCode存放filldExt
                List<PrpTownCodeDto> prpTownCodeDtoList = prpTownCodeApi.queryAreasProvinceInfo(map);
                for(int i = 0 ; i< prpTownCodeDtoList.size(); i++){
                    SelectTagCodeDto selectTagCodeDto = new SelectTagCodeDto();
                    selectTagCodeDto.setCodeCode(prpTownCodeDtoList.get(i).getCodeCode());
                    selectTagCodeDto.setCodeName(prpTownCodeDtoList.get(i).getCodeCname());
                    selectTagRetuenDto.getCodeData().add(selectTagCodeDto);
                }
        } else if (AgriPrpallConstant.AGRI_PRPALL_SERVICE_BUSINESSAREANAME.equals(selectTagListDto.getCodeType())) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("codeType", selectTagListDto.getCodeType());
            map.put("fieldExt", selectTagListDto.getMethodCode());//借用MethodCode存放filldExt
            List<PrpCountryCodeDto> prpCountryCodeDtoList = prpCountryCodeApi.queryAreasProvinceInfo(map);
            for (int i = 0; i < prpCountryCodeDtoList.size(); i++) {
                SelectTagCodeDto selectTagCodeDto = new SelectTagCodeDto();
                selectTagCodeDto.setCodeCode(prpCountryCodeDtoList.get(i).getCodeCode());
                selectTagCodeDto.setCodeName(prpCountryCodeDtoList.get(i).getCodeCName());
                selectTagRetuenDto.getCodeData().add(selectTagCodeDto);
            }
        } else if (AgriPrpallConstant.AGRI_PRPALL_SERVICE_CURRENCY.equals(selectTagListDto.getCodeType())) {//查询币别信息
            PrpDcurrencyRequestDto prpDcurrencyRequestDto = new PrpDcurrencyRequestDto();
            prpDcurrencyRequestDto.setCodeClass(selectTagListDto.getReserve1());//是根据代码查询还是根据名称查询,借用reserve1
            prpDcurrencyRequestDto.setCodeMethod(selectTagListDto.getMethodCode());//模糊查询还是精确查询
            prpDcurrencyRequestDto.setCodeValue(selectTagListDto.getReserve2());//借用reserve2存放
            List<PrpDcurrencyDto> prpDcurrencyDtoList = prpDcurrencyApi.queryPrpDcurrencyByCondition(prpDcurrencyRequestDto);
            for (int i = 0; i < prpDcurrencyDtoList.size(); i++) {
                SelectTagCodeDto selectTagCodeDto = new SelectTagCodeDto();
                selectTagCodeDto.setCodeCode(prpDcurrencyDtoList.get(i).getCurrencyCode());
                selectTagCodeDto.setCodeName(prpDcurrencyDtoList.get(i).getCurrencyCName());
                selectTagRetuenDto.getCodeData().add(selectTagCodeDto);
            }
        } else if (AgriPrpallConstant.AGRI_PRPALL_SERVICE_KINDCODE0.equals(selectTagListDto.getCodeType())) {//查询险别信息（条款配置时需要）
            Map<String,String> map = new HashMap<>();
            map.put("riskCode",selectTagListDto.getRiskCode());
            map.put("kindCName",selectTagListDto.getReserve1());//借用reserve1存放险别中文名称
            map.put("codeType",selectTagListDto.getReserve2());//险别类型1主险2附加险借用reserve2
            List<PrpDkindAgriDto> prpDkindDtoList = prpDkindAgriApi.queryKindCodeInfo(map);
            for (int i = 0; i < prpDkindDtoList.size(); i++) {
                SelectTagCodeDto selectTagCodeDto = new SelectTagCodeDto();
                selectTagCodeDto.setCodeCode(prpDkindDtoList.get(i).getKindCode());
                selectTagCodeDto.setCodeName(prpDkindDtoList.get(i).getKindCName());
                selectTagRetuenDto.getCodeData().add(selectTagCodeDto);
            }
        } else if (AgriPrpallConstant.AGRI_PRPALL_SERVICE_ITEMCODE.equals(selectTagListDto.getCodeType())) {//查询标的信息（条款配置时需要）
            PrpDItemRequestParamsDto prpDItemRequestParamsDto = new PrpDItemRequestParamsDto();
            prpDItemRequestParamsDto.setRiskCode(selectTagListDto.getRiskCode());
            List<PrpDitemAgriDto> prpDitemDtoList = prpDitemAgriApi.queryMainUnderlyingType(prpDItemRequestParamsDto);
            for (int i = 0; i < prpDitemDtoList.size(); i++) {
                SelectTagCodeDto selectTagCodeDto = new SelectTagCodeDto();
                selectTagCodeDto.setCodeCode(prpDitemDtoList.get(i).getItemCode());
                selectTagCodeDto.setCodeName(prpDitemDtoList.get(i).getItemCName());
                selectTagRetuenDto.getCodeData().add(selectTagCodeDto);
            }
        }else if (AgriPrpallConstant.AGRI_PRPALL_SERVICE_MODEL.equals(selectTagListDto.getCodeType())){//根据险种代码和机构代码查询 PrpMmodelMain模板配置主表信息
            Map<String, String> map = new HashMap<String, String>();
            map.put("riskCode", selectTagListDto.getRiskCode());
            map.put("comCode", selectTagListDto.getComCode());
            List<PrpMmodelMainDto> prpMmodelMainDtoList = prpMmodelMainApi.queryPrpMmodelMainByRiskCodeAndComCode(map);
            for (int i = 0; i < prpMmodelMainDtoList.size(); i++) {
                SelectTagCodeDto selectTagCodeDto = new SelectTagCodeDto();
                selectTagCodeDto.setCodeCode(prpMmodelMainDtoList.get(i).getModelCode());
                selectTagCodeDto.setCodeName(prpMmodelMainDtoList.get(i).getModelName());
                selectTagRetuenDto.getCodeData().add(selectTagCodeDto);
            }

        }else if (AgriPrpallConstant.AGRI_PRPALL_SERVICE_CLAUSE.equals(selectTagListDto.getCodeType())){//根据机构和险种查询条款信息
            Map<String, String> map = new HashMap<String, String>();
            map.put("riskCode", selectTagListDto.getRiskCode());
            map.put("comCode", selectTagListDto.getComCode());
            List<PrpDclauseCodeDto> prpDclauseCodeDtoList = prpDclauseCodeApi.queryByRiskCodeAndCom(map);
            for (int i = 0; i < prpDclauseCodeDtoList.size(); i++){
                SelectTagCodeDto selectTagCodeDto = new SelectTagCodeDto();
                selectTagCodeDto.setCodeCode(prpDclauseCodeDtoList.get(i).getClauseCode());
                selectTagCodeDto.setCodeName(prpDclauseCodeDtoList.get(i).getClauseName());
                selectTagRetuenDto.getCodeData().add(selectTagCodeDto);
            }
        }else if (AgriPrpallConstant.AGRI_PRPALL_SERVICE_RISKCODE.equals(selectTagListDto.getCodeType())){//根据险类查询险种
            Map<String, String> map = new HashMap<String, String>();
            map.put("classCode", selectTagListDto.getReserve1());//借用reserve1存放classCode
            List<PrpDriskDto> prpDriskDtoList = prpDriskApi.queryRiskCodeInfo(map);
            for (int i = 0; i < prpDriskDtoList.size(); i++) {
                SelectTagCodeDto selectTagCodeDto = new SelectTagCodeDto();
                selectTagCodeDto.setCodeCode(prpDriskDtoList.get(i).getRiskCode());
                selectTagCodeDto.setCodeName(prpDriskDtoList.get(i).getRiskCName());
                selectTagRetuenDto.getCodeData().add(selectTagCodeDto);
            }
        }else if (AgriPrpallConstant.AGRI_PRPALL_SERVICE_CLAUSECODE.equals(selectTagListDto.getCodeType())){//查询特别约定信息
            Map<String, String> map = new HashMap<String, String>();
            map.put("riskCode", selectTagListDto.getRiskCode());
            List<PrpDclauseDto> prpDclauseDtoList = prpDclauseApi.queryClauseByRiskCode(map);
            for (int i = 0; i < prpDclauseDtoList.size(); i++) {
                SelectTagCodeDto selectTagCodeDto = new SelectTagCodeDto();
                selectTagCodeDto.setCodeCode(prpDclauseDtoList.get(i).getClauseCode());
                selectTagCodeDto.setCodeName(prpDclauseDtoList.get(i).getClauseName());
                selectTagCodeDto.setClausesContext(prpDclauseDtoList.get(i).getContext());
                selectTagRetuenDto.getCodeData().add(selectTagCodeDto);
            }
        }else if (AgriPrpallConstant.AGRI_PRPALL_SERVICE_KINDCODE.equals(selectTagListDto.getCodeType())){//查询险别信息(投保单录入时需要)
            String riskCode = selectTagListDto.getRiskCode();
            if (StringUtils.isEmpty(riskCode)){
                throw new DataVerifyException("险种代码不能为空!");
            }
            Map<String, String> map = new HashMap<String, String>();
            map.put("clauseCode", selectTagListDto.getReserve1());//借用reserve1存放clauseCode
            map.put("calculateFlag", selectTagListDto.getReserve2());//借用reserve2存放calculateFlag主险标识：1-主险，2-附加险

            List<String> prpDclauseKindDtoList = prpDclauseCodeKindApi.queryKindCodeByClauseCode(map);

            List<PrpDkindAgriDto> prpDkindDtoList = new ArrayList<>();
            List<String> kindCNameList = new ArrayList<String>();
            PrpDkindAgriDto prpDkindDto= new PrpDkindAgriDto();
            for (int i = 0; i < prpDclauseKindDtoList.size(); i++){
                Map<String,String> map1=new HashMap<>();
                map1.put("riskCode",riskCode);
                map1.put("kindCode",prpDclauseKindDtoList.get(i));
                prpDkindDto = prpDkindAgriApi.queryByPk(map1);
                if (prpDkindDto != null){
                    prpDkindDtoList.add(prpDkindDto);
                }
            }
            for (int i = 0; i < prpDkindDtoList.size(); i++) {
                SelectTagCodeDto selectTagCodeDto = new SelectTagCodeDto();
                selectTagCodeDto.setCodeCode(prpDkindDtoList.get(i).getKindCode());
                selectTagCodeDto.setCodeName(prpDkindDtoList.get(i).getKindCName());
                selectTagRetuenDto.getCodeData().add(selectTagCodeDto);
            }

        }else if (AgriPrpallConstant.AGRI_PRPALL_SERVICE_ITEMCODE0.equals(selectTagListDto.getCodeType())){//查询标的(投保单录入时需要)
            String riskCode = selectTagListDto.getRiskCode();
            if (StringUtils.isEmpty(riskCode)){
                throw new DataVerifyException("险种代码不能为空!");
            }
            Map<String, String> map = new HashMap<String, String>();
            map.put("clauseCode", selectTagListDto.getReserve1());//借用reserve1存放clauseCode
            map.put("kindCode", selectTagListDto.getReserve2());//借用reserve2存放kindCode险别代码
            List<String> list = prpDclauseCodeKindApi.queryItemCodeByClauseCodeAndKindCode(map);
            List<String> itemCNameList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++){
                Map<String,String> map1=new HashMap<>();
                map1.put("riskCode",riskCode);
                map1.put("itemCode",list.get(i));
                PrpDitemAgriDto prpDitemAgriDto = prpDitemAgriApi.queryByPk(map1);
                itemCNameList.add(prpDitemAgriDto.getItemCName());
            }
            for (int i = 0; i < list.size(); i++) {
                SelectTagCodeDto selectTagCodeDto = new SelectTagCodeDto();
                selectTagCodeDto.setCodeCode(list.get(i));
                selectTagCodeDto.setCodeName(itemCNameList.get(i));
                selectTagRetuenDto.getCodeData().add(selectTagCodeDto);
            }
        }else{//如果上述条件都不满足，则查询prpdcode表
            List<PrpDcodeDto> prpDcodeDtoList = new ArrayList<>();
            Map<String, String> map = new HashMap<String, String>();
            map.put("codeType",selectTagListDto.getCodeType());
            map.put("riskCode",selectTagListDto.getRiskCode());
            prpDcodeDtoList = prpDcodeApi.queryCodeInfoByCodeTypeAndRiskCode(map);
            for (int i = 0; i < prpDcodeDtoList.size(); i++) {
                SelectTagCodeDto selectTagCodeDto = new SelectTagCodeDto();
                selectTagCodeDto.setCodeCode(prpDcodeDtoList.get(i).getCodeCode());
                selectTagCodeDto.setCodeName(prpDcodeDtoList.get(i).getCodeCName());
                selectTagRetuenDto.getCodeData().add(selectTagCodeDto);
            }
            selectTagRetuenDto.setCodeType(selectTagListDto.getCodeType());
        }
        return selectTagRetuenDto;
    }
}
