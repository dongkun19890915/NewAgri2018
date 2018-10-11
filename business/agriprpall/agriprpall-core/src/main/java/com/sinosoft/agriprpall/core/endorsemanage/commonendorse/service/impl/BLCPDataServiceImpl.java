package com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.impl;

import com.sinosoft.agriprpall.api.client.dto.RequestQueryVisaCodeDto;
import com.sinosoft.agriprpall.api.client.dto.ResponseQueryVisaCodeDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.*;
import com.sinosoft.agriprpall.api.policymanage.VisaApi;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponseQueryPolicyInfoDto;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.dao.*;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.entity.*;
import com.sinosoft.agriprpall.core.endorsemanage.commonendorse.service.BLCPDataService;
import com.sinosoft.dms.api.customer.PrpDcustomerTaxPayInfoApi;
import com.sinosoft.dms.api.customer.dto.PrpDcustomerTaxPayInfoDto;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BLCPDataServiceImpl extends BaseServiceImpl implements BLCPDataService {
    @Autowired
    private PrpCPmainDao prpCPmainDao;
    @Autowired
    private PrpCPmainAgriDao prpCPmainAgriDao;
    @Autowired
    private PrpCPengageDao prpCPengageDao;
    @Autowired
    private PrpCPaddressDao prpCPaddressDao;
    @Autowired
    private PrpCPcoinsDao prpCPcoinsDao;
    @Autowired
    private PrpCPexpenseDao prpCPexpenseDao;
    @Autowired
    private PrpCPfeeDao prpCPfeeDao;
    @Autowired
    private PrpCPitemKindAgriDao prpCPitemKindAgriDao;
    @Autowired
    private PrpCPitemKindDao prpCPitemKindDao;
    @Autowired
    private PrpCPplanDao prpCPplanDao;
    @Autowired
    private PrpCPsubsidyDao prpCPsubsidyDao;
    @Autowired
    private PrpCPinsuredDao prpCPinsuredDao;
    @Autowired
    private PrpCPitemAgriDao prpCPitemAgriDao;
    @Autowired
    private PrpCPcoinsDetailDao prpCPcoinsDetailDao;
    @Autowired
    private VisaApi visaApi;
    @Autowired
    private PrpDcustomerTaxPayInfoApi prpDcustomerTaxPayInfoApi;
    @Override
    public void saveCP(BLEndorseDto blEndorseDto) throws Exception {
        /**取子表对象*/
        PrpCPmainDto prpCPmainDto=blEndorseDto.getPrpCPmainDto();
        PrpCPmainAgriDto prpCPmainAgriDto=blEndorseDto.getPrpCPmainAgriDto();
        List<PrpCPengageDto> prpCPengageDtoList =blEndorseDto.getPrpCPengageDtoList();
        List<PrpCPaddressDto> prpCPaddrssDtoList=blEndorseDto.getPrpCPaddressDtoList();
        List<PrpCPcoinsDto> prpCPcoinsDtoList=blEndorseDto.getPrpCPcoinsDtoList();
        PrpCPexpenseDto prpCPexpenseDto =blEndorseDto.getPrpCPexpenseDto();
        List<PrpCPfeeDto> prpCPfeeDtoList=blEndorseDto.getPrpCPfeeDtoList();
        List<PrpCPitemKindAgriDto> prpCPitemKindAgriDtoList=blEndorseDto.getPrpCPitemKindAgriDtoList();
        List<PrpCPitemKindDto> prpCPitemKindDtoList =blEndorseDto.getPrpCPitemKindDtoList();
        List<PrpCPplanDto> prpCPplanDtoList =blEndorseDto.getPrpCPplanDtoList();
        List<PrpCPsubsidyDto> prpCPsubsidyDtoList=blEndorseDto.getPrpCPsubsidyDtoList();
        List<PrpCPinsuredDto> prpCPinsuredDtoList=blEndorseDto.getPrpCPinsuredDtoList();
        List<PrpCPcoinsDetailDto> prpCPcoinsDetailDtoList =blEndorseDto.getPrpCPcoinsDetailDtoList();
        List<PrpCPitemAgriDto> prpCPitemAgriDtoList=blEndorseDto.getPrpCPitemAgriDtoList();
        PrpDcustomerTaxPayInfoDto prpDcustomerTaxPayInfoDto=blEndorseDto.getPrpDcustomerTaxPayInfoDto();
        /**
         * 以下为CP表的批单保存：
         * 先转换再保存。
         */
        if(prpCPmainDto!=null){
            //生成单证类型保存到prpcpmainDto中
            RequestQueryVisaCodeDto requestQueryVisaCodeDto = new RequestQueryVisaCodeDto();
            requestQueryVisaCodeDto.setComCode(prpCPmainDto.getComCode());
            requestQueryVisaCodeDto.setCertiType("P");
            requestQueryVisaCodeDto.setRiskCode(prpCPmainDto.getRiskCode());
            ResponseQueryVisaCodeDto responseQueryVisaCodeDto = visaApi.visaType(requestQueryVisaCodeDto);
            prpCPmainDto.setVisaCode(responseQueryVisaCodeDto.getVisaCode());
            prpCPmainDao.save(convert(prpCPmainDto,PrpCPmain.class));
        }
        if(prpCPmainAgriDto!=null){
            prpCPmainAgriDao.save(convert(prpCPmainAgriDto,PrpCPmainAgri.class));
        }
        if(prpCPengageDtoList !=null&& prpCPengageDtoList.size()>0){
            List<PrpCPengage> prpCPengageList =new ArrayList<>();
            convertCollection(prpCPengageDtoList, prpCPengageList,PrpCPengage.class);
            prpCPengageDao.save(prpCPengageList);
        }
        if(prpCPaddrssDtoList!=null&&prpCPaddrssDtoList.size()>0){
            List<PrpCPaddress> prpCPaddressList=new ArrayList<>();
            convertCollection(prpCPaddrssDtoList,prpCPaddressList,PrpCPaddress.class);
            prpCPaddressDao.save(prpCPaddressList);
        }
        if(prpCPcoinsDtoList!=null&&prpCPcoinsDtoList.size()>0){
            List<PrpCPcoins> prpCPcoinsList=new ArrayList<>();
            convertCollection(prpCPcoinsDtoList,prpCPcoinsList,PrpCPcoins.class);
            prpCPcoinsDao.save(prpCPcoinsList);
        }
        if(prpCPexpenseDto !=null){
            prpCPexpenseDao.save(convert(prpCPexpenseDto,PrpCPexpense.class));
        }
        if(prpCPfeeDtoList!=null&&prpCPfeeDtoList.size()>0){
            List<PrpCPfee> prpCPfeeList=new ArrayList<>();
            convertCollection(prpCPfeeDtoList,prpCPfeeList,PrpCPfee.class);
            prpCPfeeDao.save(prpCPfeeList);
        }
        if(prpCPitemKindDtoList !=null&& prpCPitemKindDtoList.size()>0){
            List<PrpCPitemKind> prpCPitemKindList =new ArrayList<>();
            convertCollection(prpCPitemKindDtoList, prpCPitemKindList,PrpCPitemKind.class);
            prpCPitemKindDao.save(prpCPitemKindList);
        }
        if(prpCPitemKindAgriDtoList!=null&&prpCPitemKindAgriDtoList.size()>0){
            List<PrpCPitemKindAgri> prpCPitemKindAgriList=new ArrayList<>();
            convertCollection(prpCPitemKindAgriDtoList,prpCPitemKindAgriList,PrpCPitemKindAgri.class);
            prpCPitemKindAgriDao.save(prpCPitemKindAgriList);
        }
        if(prpCPplanDtoList !=null&& prpCPplanDtoList.size()>0){
            List<PrpCPplan> prpCPplanList =new ArrayList<>();
            convertCollection(prpCPplanDtoList, prpCPplanList,PrpCPplan.class);
            prpCPplanDao.save(prpCPplanList);
        }
        if(prpCPsubsidyDtoList!=null&&prpCPsubsidyDtoList.size()>0){
            List<PrpCPsubsidy> prpCPsubsidyList=new ArrayList<>();
            convertCollection(prpCPsubsidyDtoList,prpCPsubsidyList,PrpCPsubsidy.class);
            prpCPsubsidyDao.save(prpCPsubsidyList);
        }
        if(prpCPinsuredDtoList!=null&&prpCPinsuredDtoList.size()>0){
            List<PrpCPinsured> prpCPinsuredList=new ArrayList<>();
            convertCollection(prpCPinsuredDtoList,prpCPinsuredList,PrpCPinsured.class);
            prpCPinsuredDao.save(prpCPinsuredList);
        }
        if (prpCPcoinsDetailDtoList != null && prpCPcoinsDetailDtoList.size() > 0 && prpCPcoinsDetailDtoList.get(0).getPolicyNo() != null) {
            List<PrpCPcoinsDetail> prpCPcoinsDetailList =new ArrayList<>();
            convertCollection(prpCPcoinsDetailDtoList, prpCPcoinsDetailList,PrpCPcoinsDetail.class);
            prpCPcoinsDetailDao.save(prpCPcoinsDetailList);
        }
        if(prpCPitemAgriDtoList!=null&&prpCPitemAgriDtoList.size()>0){
            List<PrpCPitemAgri> prpCPitemAgriList=new ArrayList<>();
            convertCollection(prpCPitemAgriDtoList,prpCPitemAgriList,PrpCPitemAgri.class);
            prpCPitemAgriDao.save(prpCPitemAgriList);
        }
        if(prpDcustomerTaxPayInfoDto!=null){
            prpDcustomerTaxPayInfoApi.save(prpDcustomerTaxPayInfoDto);
        }
    }

    @Override
    public void deleteCP(String policyNo) throws Exception {
        prpCPitemAgriDao.deleteAllByCondition(policyNo);
        prpCPcoinsDetailDao.deleteAllByCondition(policyNo);
        prpCPinsuredDao.deleteAllByCondition(policyNo);
        prpCPsubsidyDao.deleteAllByCondition(policyNo);
        prpCPplanDao.deleteAllByCondition(policyNo);
        prpCPitemKindDao.deleteAllByCondition(policyNo);
        prpCPitemKindAgriDao.deleteAllByCondition(policyNo);
        prpCPfeeDao.deleteAllByCondition(policyNo);
        prpCPcoinsDao.deleteAllByCondition(policyNo);
        prpCPexpenseDao.deleteAllByCondition(policyNo);
        prpCPaddressDao.deleteAllByCondition(policyNo);
        prpCPengageDao.deleteAllByCondition(policyNo);
        prpCPmainAgriDao.deleteAllByCondition(policyNo);
        prpCPmainDao.deleteAllByCondition(policyNo);
    }

    @Override
    public void evaluateFromCToCP(ResponseQueryPolicyInfoDto blPolicyDtoNew, BLEndorseDto blEndorseDto,ResponseQueryPolicyInfoDto blPolicyDtoOld) throws Exception {
        generatePrpCPaddress(blPolicyDtoNew,blEndorseDto);
        generatePrpCPcoins(blPolicyDtoNew,blEndorseDto);
        generatePrpCPcoinsDetail(blPolicyDtoNew,blEndorseDto);
        generatePrpCPengage(blPolicyDtoNew,blEndorseDto);
        generatePrpCPfee(blPolicyDtoNew,blEndorseDto);
        generatePrpCPinsured(blPolicyDtoNew,blEndorseDto);
        generatePrpCPitemKind(blPolicyDtoNew,blEndorseDto);
        generatePrpCPmain(blPolicyDtoNew,blEndorseDto);
        generatePrpCPmainAgri(blPolicyDtoNew,blEndorseDto);
        generatePrpCPplan(blPolicyDtoNew,blEndorseDto,blPolicyDtoOld);
        generatePrpCPplanCoins(blPolicyDtoNew,blEndorseDto);
        generatePrpCPexpense(blPolicyDtoNew,blEndorseDto);
        generatePrpCPitemKindAgri(blPolicyDtoNew,blEndorseDto);
        generatePrpCPsubSidy(blPolicyDtoNew,blEndorseDto);
        generatePrpCPfeild(blPolicyDtoNew,blEndorseDto);
        generatePrpDcustomerTaxPayInfoDto(blPolicyDtoNew,blEndorseDto);
    }
    public void generatePrpCPaddress(ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        List<PrpCPaddressDto> prpCPaddressDtoList=new ArrayList<>();
        convertCollection(blPolicyDtoNew.getPrpCaddressDtoList(),prpCPaddressDtoList,PrpCPaddressDto.class);
        blEndorseDto.setPrpCPaddressDtoList(prpCPaddressDtoList);
    }
    public void generatePrpCPcoins(ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        List<PrpCPcoinsDto> prpCPcoinsDtoList=new ArrayList<>();
        convertCollection(blPolicyDtoNew.getPrpCcoinsDtoList(),prpCPcoinsDtoList,PrpCPcoinsDto.class);
        blEndorseDto.setPrpCPcoinsDtoList(prpCPcoinsDtoList);
    }
    public void generatePrpCPcoinsDetail(ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        List<PrpCPcoinsDetailDto> prpCPcoinsDetailDtoList=new ArrayList<>();
        convertCollection(blPolicyDtoNew.getPrpCcoinsDetailDtoList(),prpCPcoinsDetailDtoList,PrpCPcoinsDetailDto.class);
        blEndorseDto.setPrpCPcoinsDetailDtoList(prpCPcoinsDetailDtoList);
    }
    public void generatePrpCPengage(ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        List<PrpCPengageDto> prpCPengageDtoList=new ArrayList<>();
        convertCollection(blPolicyDtoNew.getPrpCengageDtoList(),prpCPengageDtoList,PrpCPengageDto.class);
        blEndorseDto.setPrpCPengageDtoList(prpCPengageDtoList);
    }
    public void generatePrpCPfee(ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        List<PrpCPfeeDto> prpCPfeeDtoList=new ArrayList<>();
        convertCollection(blPolicyDtoNew.getPrpCfeeDtoList(),prpCPfeeDtoList,PrpCPfeeDto.class);
        blEndorseDto.setPrpCPfeeDtoList(prpCPfeeDtoList);
    }
    public void generatePrpCPinsured(ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        List<PrpCPinsuredDto> prpCPinsuredDtoList=new ArrayList<>();
        convertCollection(blPolicyDtoNew.getPrpCinsuredDtoList(),prpCPinsuredDtoList,PrpCPinsuredDto.class);
        blEndorseDto.setPrpCPinsuredDtoList(prpCPinsuredDtoList);
    }
    public void generatePrpCPitemKind(ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        List<PrpCPitemKindDto> prpCPitemKindDtoList=new ArrayList<>();
        convertCollection(blPolicyDtoNew.getPrpCitemKindDtoList(),prpCPitemKindDtoList,PrpCPitemKindDto.class);
        blEndorseDto.setPrpCPitemKindDtoList(prpCPitemKindDtoList);
    }
    public void generatePrpCPmain(ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        blEndorseDto.setPrpCPmainDto(convert(blPolicyDtoNew.getPrpCmainDto(),PrpCPmainDto.class));
        /*新的出单员意见在endorseConditionDto对象里*/
        if(blEndorseDto.getEndorseConditionDto() != null && blEndorseDto.getEndorseConditionDto().getRemark() != null) {
            blEndorseDto.getPrpCPmainDto().setRemark(blEndorseDto.getEndorseConditionDto().getRemark());
        }
    }
    public void generatePrpCPmainAgri(ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        blEndorseDto.setPrpCPmainAgriDto(convert(blPolicyDtoNew.getPrpCmainAgriDto(),PrpCPmainAgriDto.class));
    }
    public void generatePrpCPplan(ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto,ResponseQueryPolicyInfoDto blPolicyDtoOld)throws Exception{
        List<PrpCPplanDto> prpCPplanDtoList=new ArrayList<>();
        convertCollection(blPolicyDtoNew.getPrpCplanDtoList(),prpCPplanDtoList,PrpCPplanDto.class);
        for(int i=0;i<prpCPplanDtoList.size();i++){
            /*签单保费和各种补贴的批单号不存，以便批改收付的时候筛选*/
            if("R10,RS3,RS4,RS5,RS6,RS7".indexOf(prpCPplanDtoList.get(i).getPayReason())==-1 && prpCPplanDtoList.get(i).getFlag()!=null &&prpCPplanDtoList.get(i).getFlag().equals("I")) {
                prpCPplanDtoList.get(i).setEndorseNo(blEndorseDto.getPrpPheadDto().getEndorseNo());
//                if(blPolicyDtoOld.getPrpCplanDtoList().size()<blEndorseDto.getPrpCPplanDtoList().size()){
//                    prpCPplanDtoList.get(i).setFlag("I");//这个地方区别于老系统，老系统01，11的批改类型缴费计算新增的或删除的是不变色的，新系统要变色，因此CPPLAN表的flag字段要存值。
//                }
            }
            prpCPplanDtoList.get(i).setSerialNo(i+1);
        }
        for(int i=0;i<prpCPplanDtoList.size();i++){
            if("R10,RS3,RS4,RS5,RS6,RS7".indexOf(prpCPplanDtoList.get(i).getPayReason())==-1&&"01,11,71,91,21,19,92".indexOf(blEndorseDto.getPrpPheadDto().getEndorType())>-1){
                prpCPplanDtoList.get(i).setFlag("I");//这个地方区别于老系统，老系统01，11的批改类型缴费计算新增的或删除的是不变色的，新系统要变色，因此CPPLAN表的flag字段要存值。
            }
        }
        blEndorseDto.setPrpCPplanDtoList(prpCPplanDtoList);
    }
    public void generatePrpCPplanCoins(ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        List<PrpCPplanCoinsDto> prpCPplanCoinsDtoList=new ArrayList<>();
        convertCollection(blPolicyDtoNew.getPrpCplanCoinsDtoList(),prpCPplanCoinsDtoList,PrpCPplanCoinsDto.class);
        blEndorseDto.setPrpCPplanCoinsDtoList(prpCPplanCoinsDtoList);
    }
    public void generatePrpCPexpense(ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        blEndorseDto.setPrpCPexpenseDto(convert(blPolicyDtoNew.getPrpCexpenseDto(),PrpCPexpenseDto.class));
    }
    public void generatePrpCPitemKindAgri(ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        List<PrpCPitemKindAgriDto> prpCPitemKindAgriDtoList=new ArrayList<>();
        convertCollection(blPolicyDtoNew.getPrpCitemKindAgriDtoList(),prpCPitemKindAgriDtoList,PrpCPitemKindAgriDto.class);
        blEndorseDto.setPrpCPitemKindAgriDtoList(prpCPitemKindAgriDtoList);
    }
    public void generatePrpCPsubSidy(ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        List<PrpCPsubsidyDto> prpCPsubsidyDtoList=new ArrayList<>();
        convertCollection(blPolicyDtoNew.getPrpCsubsidyDtoList(),prpCPsubsidyDtoList,PrpCPsubsidyDto.class);
        blEndorseDto.setPrpCPsubsidyDtoList(prpCPsubsidyDtoList);
    }
    public void generatePrpCPfeild(ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        List<PrpCPfeildDto> prpCPfeildDtoList=new ArrayList<>();
        convertCollection(blPolicyDtoNew.getPrpCfeildDtoList(),prpCPfeildDtoList,PrpCPfeildDto.class);
        blEndorseDto.setPrpCPfeildDtoList(prpCPfeildDtoList);
    }
    public void generatePrpDcustomerTaxPayInfoDto(ResponseQueryPolicyInfoDto blPolicyDtoNew,BLEndorseDto blEndorseDto)throws Exception{
        blEndorseDto.setPrpDcustomerTaxPayInfoDto(blPolicyDtoNew.getPrpDcustomerTaxPayInfoDto());
    }
}
