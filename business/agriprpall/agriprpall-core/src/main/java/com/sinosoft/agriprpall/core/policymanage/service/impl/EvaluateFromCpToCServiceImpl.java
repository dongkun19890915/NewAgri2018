package com.sinosoft.agriprpall.core.policymanage.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.*;
import com.sinosoft.agriprpall.api.policymanage.dto.*;
import com.sinosoft.agriprpall.api.proposalmanage.dto.QueryProposalPrpTengageDto;
import com.sinosoft.agriprpall.core.policymanage.service.*;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.txnlist.api.insuremainlist.InsureMainListApi;
import com.sinosoft.txnlist.api.insuremainlist.dto.InsureMainListDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * CP数据更新C表服务
 * @Author: 王保良
 * @Date: 2017/11/4 14:55
 */
@Service
public class EvaluateFromCpToCServiceImpl extends BaseServiceImpl implements EvaluateFromCpToCService{

    @Autowired
    private PrpCaddressService prpCaddressService;
    @Autowired
    private PrpCcoinsService prpCcoinsService;
    @Autowired
    private PrpCcoinsDetailService prpCcoinsDetailService;
    @Autowired
    private PrpCengageService prpCengageService;
    @Autowired
    private PrpCexpenseService prpCexpenseService;
    @Autowired
    private PrpCfeeService prpCfeeService;
    @Autowired
    private PrpCinsuredService prpCinsuredService;
    @Autowired
    private PrpCitemKindService prpCitemKindService;
    @Autowired
    private PrpCmainService prpCmainService;
    @Autowired
    private PrpCmainAgriService prpCmainAgriService;
    @Autowired
    private PrpCplanService prpCplanService;
    @Autowired
    private PrpCplanCoinsService prpCplanCoinsService;
    @Autowired
    private PrpCitemKindAgriService prpCitemKindAgriService;
    @Autowired
    private PrpCsubsidyService prpCsubsidyService;
    @Autowired
    private PrpCfeildService prpCfeildService;

    /**
     * CP数据更新C表服务
     * @author: 王保良
     * @date: 2017/11/30 14:50
     * @param blPolicyDto 保单大对象
     * @param cPpolicyDto cp表大对象
     * @return void
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void evaluateFromCpToC(ResponseQueryPolicyInfoDto blPolicyDto,CPpolicyDto cPpolicyDto,BLEndorseDto blEndorseDto) throws Exception {
        List<PrpCPaddressDto> prpCPaddressDtoList=cPpolicyDto.getPrpCPaddressDtoList();
        List<PrpCPcoinsDto> prpCPcoinsDtoList=cPpolicyDto.getPrpCPcoinsDtoList();
        List<PrpCPcoinsDetailDto> prpCPcoinsDetailDtoList=cPpolicyDto.getPrpCPcoinsDetailDtoList();
        List<PrpCPengageDto> prpCPengageDtoList=cPpolicyDto.getPrpCPengageDtoList();
        PrpCPexpenseDto prpCPexpenseDto=cPpolicyDto.getPrpCPexpenseDto();
        List<PrpCPfeeDto> prpCPfeeDtoList=cPpolicyDto.getPrpCPfeeDtoList();
        List<PrpCPinsuredDto> prpCPinsuredDtoList=cPpolicyDto.getPrpCPinsuredDtoList();
        List<PrpCPitemKindDto> prpCPitemKindDtoList=cPpolicyDto.getPrpCPitemKindDtoList();
        PrpCPmainDto prpCPmainDto=cPpolicyDto.getPrpCPmainDto();
        PrpCPmainAgriDto prpCPmainAgriDto=cPpolicyDto.getPrpCPmainAgriDto();
        List<PrpCPplanDto> prpCPplanDtoList=cPpolicyDto.getPrpCPplanDtoList();
        List<PrpCPplanCoinsDto> prpCPplanCoinsDtoList=cPpolicyDto.getPrpCPplanCoinsDtoList();
        List<PrpCPitemKindAgriDto> prpCPitemKindAgriDtoList=cPpolicyDto.getPrpCPitemKindAgriDtoList();
        List<PrpCPsubsidyDto> prpCPsubsidyDtoList=cPpolicyDto.getPrpCPsubsidyDtoList();
        List<PrpCPfeildDto> prpCPfeildDtoList=cPpolicyDto.getPrpCPfeildDtoList();
        List<QueryProposalPrpTengageDto> queryProposalPrpTengageDtoList=cPpolicyDto.getQueryProposalPrpTengageDtoList();
        
//        List<InsureMainListDto> 	insureMainListDtoList 	= 	new ArrayList<InsureMainListDto>();
//        GisInsureMainListDto 		gisInsureMainListDto 	= 	new GisInsureMainListDto();
        List<PrpCaddressDto> 		prpCaddressDtoList 		= 	new ArrayList<PrpCaddressDto>();
        List<PrpCcoinsDto> 	 		prpCcoinsDtoList   		= 	new ArrayList<PrpCcoinsDto>();
        List<PrpCcoinsDetailDto> 	prpCcoinsDetailList 	= 	new ArrayList<PrpCcoinsDetailDto>();
        List<PrpCengageDto> 		prpCengageDtoList 		= 	new ArrayList<PrpCengageDto>();
        List<PrpCfeeDto> 			prpCfeeDtoList 			= 	new ArrayList<PrpCfeeDto>();
        List<PrpCinsuredDto> 		prpCinsuredDtoList 		= 	new ArrayList<PrpCinsuredDto>();
        List<PrpCitemKindDto> 		prpCitemKindDtoList 	= 	new ArrayList<PrpCitemKindDto>();
        List<PrpCplanDto> 			prpCplanDtoList 		= 	new ArrayList<PrpCplanDto>();
        List<PrpCplanCoinsDto> 		prpCplanCoinsDtoList	= 	new ArrayList<PrpCplanCoinsDto>();
        List<PrpCitemKindAgriDto> 	prpCitemKindAgriDtoList = 	new ArrayList<PrpCitemKindAgriDto>();
        List<PrpCsubsidyDto> 		prpCsubsidyDtoList 		= 	new ArrayList<PrpCsubsidyDto>();
        List<PrpCfeildDto> 			prpCfeildDtoList 		= 	new ArrayList<PrpCfeildDto>();

        for (int i=0;i<prpCPaddressDtoList.size();i++){
            PrpCPaddressDto prpCPaddressDto=prpCPaddressDtoList.get(i);
            PrpCaddressDto prpCaddressDto=prpCaddressService.generatePrpCaddress(prpCPaddressDto);
            prpCaddressDtoList.add(prpCaddressDto);
        }
        for (int i=0;i<prpCPcoinsDtoList.size();i++){
            PrpCPcoinsDto prpCPcoinsDto=prpCPcoinsDtoList.get(i);
            PrpCcoinsDto prpCcoinsDto=prpCcoinsService.generatePrpCcoins(prpCPcoinsDto);
            prpCcoinsDtoList.add(prpCcoinsDto);
        }
        for (int i=0; prpCPcoinsDetailDtoList != null && i<prpCPcoinsDetailDtoList.size();i++){
            PrpCPcoinsDetailDto prpCPcoinsDetailDto=prpCPcoinsDetailDtoList.get(i);
            PrpCcoinsDetailDto prpCcoinsDetailDto=prpCcoinsDetailService.generatePrpCcoinsDetail(prpCPcoinsDetailDto);
            prpCcoinsDetailList.add(prpCcoinsDetailDto);
        }
        for (int i=0; prpCPengageDtoList != null && i<prpCPengageDtoList.size();i++){
            PrpCPengageDto prpCPengageDto=prpCPengageDtoList.get(i);
            PrpCengageDto prpCengageDto=prpCengageService.generatePrpCengage(prpCPengageDto);
            prpCengageDtoList.add(prpCengageDto);
        }
        if(prpCPexpenseDto != null) {
        	PrpCexpenseDto prpCexpenseDto=prpCexpenseService.generatePrpCexpense(prpCPexpenseDto);
        	blPolicyDto.setPrpCexpenseDto(prpCexpenseDto);
        }
        for (int i=0;i<prpCPfeeDtoList.size();i++){
            PrpCPfeeDto prpCPfeeDto=prpCPfeeDtoList.get(i);
            PrpCfeeDto prpCfeeDto=prpCfeeService.generatePrpCfee(prpCPfeeDto);
            prpCfeeDtoList.add(prpCfeeDto);
        }
        for (int i=0;i<prpCPinsuredDtoList.size();i++){
            PrpCPinsuredDto prpCPinsuredDto=prpCPinsuredDtoList.get(i);
            PrpCinsuredDto prpCinsuredDto=prpCinsuredService.generatePrpCinsured(prpCPinsuredDto);
            prpCinsuredDtoList.add(prpCinsuredDto);
        }
        for (int i=0;i<prpCPitemKindDtoList.size();i++){
            PrpCPitemKindDto prpCPitemKindDto=prpCPitemKindDtoList.get(i);
            PrpCitemKindDto prpCitemKindDto=prpCitemKindService.generatePrpCitemKind(prpCPitemKindDto);
            prpCitemKindDtoList.add(prpCitemKindDto);
        }
        PrpCmainDto prpCmainDto=prpCmainService.generatePrpCmain(prpCPmainDto);
        blPolicyDto.setPrpCmainDto(prpCmainDto);

        PrpCmainAgriDto prpCmainAgriDto=prpCmainAgriService.generatePrpCmainAgri(prpCPmainAgriDto);
        blPolicyDto.setPrpCmainAgriDto(prpCmainAgriDto);

        for (int i=0;i<prpCPplanDtoList.size();i++){
            PrpCPplanDto prpCPplanDto=prpCPplanDtoList.get(i);
            PrpCplanDto prpCplanDto=prpCplanService.generatePrpCplan(prpCPplanDto);
            prpCplanDtoList.add(prpCplanDto);
        }
        for (int i=0; prpCPplanCoinsDtoList != null && i<prpCPplanCoinsDtoList.size();i++){
            PrpCPplanCoinsDto prpCPplanCoinsDto=prpCPplanCoinsDtoList.get(i);
            PrpCplanCoinsDto prpCplanCoinsDto=prpCplanCoinsService.generatePrpCplanCoins(prpCPplanCoinsDto);
            prpCplanCoinsDtoList.add(prpCplanCoinsDto);
        }
        for (int i=0; prpCPitemKindAgriDtoList != null && i<prpCPitemKindAgriDtoList.size();i++){
            PrpCPitemKindAgriDto prpCPitemKindAgriDto=prpCPitemKindAgriDtoList.get(i);
            PrpCitemKindAgriDto prpCitemKindAgriDto=prpCitemKindAgriService.generatePrpCitemKindAgri(prpCPitemKindAgriDto,blEndorseDto);
            prpCitemKindAgriDtoList.add(prpCitemKindAgriDto);
        }
        for (int i=0; prpCPsubsidyDtoList != null && i<prpCPsubsidyDtoList.size();i++){
            PrpCPsubsidyDto prpCPsubsidyDto=prpCPsubsidyDtoList.get(i);
            PrpCsubsidyDto prpCsubsidyDto=prpCsubsidyService.generatePrpCsubsidy(prpCPsubsidyDto);
            prpCsubsidyDtoList.add(prpCsubsidyDto);
        }
        String proposalNo=cPpolicyDto.getPrpCPmainDto().getProposalNo();
        for (int i=0;prpCPfeildDtoList != null && i<prpCPfeildDtoList.size();i++){
            PrpCPfeildDto prpCPfeildDto=prpCPfeildDtoList.get(i);
            PrpCfeildDto prpCfeildDto=prpCfeildService.generatePrpCfeild(prpCPfeildDto,proposalNo);
            prpCfeildDtoList.add(prpCfeildDto);
        }
        
        /** 添加保单清单主表信息*/
//        insureMainListDtoList = insureMainListApi.queryByPolicyNo(cPpolicyDto.getPrpCPmainDto().getPolicyNo());
        /** 添加gis清单主表信息*/
//        if(insureMainListDtoList.size() > 0) {
//        	gisInsureMainListApi.queryByInsureListCode(insureMainListDtoList.get(0).getGisInsureListCode());
//        }
        
        blPolicyDto.setPrpCaddressDtoList(prpCaddressDtoList);
        blPolicyDto.setPrpCcoinsDtoList(prpCcoinsDtoList);
        blPolicyDto.setPrpCcoinsDetailDtoList(prpCcoinsDetailList);
        blPolicyDto.setPrpCengageDtoList(prpCengageDtoList);
        blPolicyDto.setPrpCfeeDtoList(prpCfeeDtoList);
        blPolicyDto.setPrpCinsuredDtoList(prpCinsuredDtoList);
        blPolicyDto.setPrpCitemKindDtoList(prpCitemKindDtoList);
        blPolicyDto.setPrpCplanDtoList(prpCplanDtoList);
        blPolicyDto.setPrpCplanCoinsDtoList(prpCplanCoinsDtoList);
        blPolicyDto.setPrpCitemKindAgriDtoList(prpCitemKindAgriDtoList);
        blPolicyDto.setPrpCsubsidyDtoList(prpCsubsidyDtoList);
        blPolicyDto.setPrpCfeildDtoList(prpCfeildDtoList);
        blPolicyDto.setGisInsureListDto(cPpolicyDto.getGisInsureListDto());
        blPolicyDto.setQueryProposalPrpTengageDtoList(queryProposalPrpTengageDtoList);
        blPolicyDto.setPrpDcustomerTaxPayInfoDto(cPpolicyDto.getPrpDcustomerTaxPayInfoDto());

//        blPolicyDto.setInsureMainListDtoList(insureMainListDtoList);
//        blPolicyDto.setGisInsureMainListDto(gisInsureMainListDto);
    }

}
