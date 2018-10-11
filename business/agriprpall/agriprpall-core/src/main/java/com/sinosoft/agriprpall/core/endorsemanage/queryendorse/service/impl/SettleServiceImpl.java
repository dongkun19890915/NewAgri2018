package com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.*;
import com.sinosoft.agriprpall.api.policymanage.dto.*;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.SettleService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Settle (P表标志置C表标志处理(里面包含每个小方法的处理))服务
 * @throws Exception
 * @author 王保良
 * @date 2017年10月27日
 */
@Service
public class SettleServiceImpl extends BaseServiceImpl implements SettleService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SettleServiceImpl.class);


    /**
     * P表标志置C表标志处理(里面包含每个小方法的处理)
     * @param  blEndorseDto 批单大对象
     * @param  responseQueryPolicyInfoDto 保单大对象
     * @return boolean
     * @throws Exception
     * @author 王保良
     * @date 2017年11月27日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean settle(BLEndorseDto blEndorseDto, ResponseQueryPolicyInfoDto responseQueryPolicyInfoDto) throws Exception {

        List<PrpPaddressDto> prpPaddressDtoList=blEndorseDto.getPrpPaddressDtoList();
        List<PrpCaddressDto> prpCaddressDtoList=responseQueryPolicyInfoDto.getPrpCaddressDtoList();
        settlePrpPaddress(prpPaddressDtoList,prpCaddressDtoList);

        List<PrpPengageDto> prpPengageDtoList=blEndorseDto.getPrpPengageDtoList();
        List<PrpCengageDto> prpCengageDtoList=responseQueryPolicyInfoDto.getPrpCengageDtoList();
        settlePrpPengage(prpPengageDtoList,prpCengageDtoList);

        PrpPexpenseDto prpPexpenseDto=blEndorseDto.getPrpPexpenseDto();
        PrpCexpenseDto prpCexpenseDto=responseQueryPolicyInfoDto.getPrpCexpenseDto();
        if (prpPexpenseDto!=null) {
            settlePrpPexpense(prpPexpenseDto, prpCexpenseDto);
        }

        List<PrpPfeeDto> prpPfeeDtoList=blEndorseDto.getPrpPfeeDtoList();
        List<PrpCfeeDto> prpCfeeDtoList=responseQueryPolicyInfoDto.getPrpCfeeDtoList();
        settlePrpPfee(prpPfeeDtoList,prpCfeeDtoList);

        List<PrpPinsuredDto> prpPinsuredDtoList=blEndorseDto.getPrpPinsuredDtoList();
        List<PrpCinsuredDto> prpCinsuredDtoList=responseQueryPolicyInfoDto.getPrpCinsuredDtoList();
        settlePrpPinsured(prpPinsuredDtoList,prpCinsuredDtoList);

        List<PrpPitemKindDto> prpPitemKindDtoList=blEndorseDto.getPrpPitemKindDtoList();
        List<PrpCitemKindDto> prpCitemKindDtoList=responseQueryPolicyInfoDto.getPrpCitemKindDtoList();
        settlePrpPitemKind(prpPitemKindDtoList,prpCitemKindDtoList);

        List<PrpPplanDto> prpPplanDtoList=blEndorseDto.getPrpPplanDtoList();
        List<PrpCplanDto> prpCplanDtoList=responseQueryPolicyInfoDto.getPrpCplanDtoList();
        settlePrpPplan(prpPplanDtoList,prpCplanDtoList);

        List<PrpPplanCoinsDto> prpPplanCoinsDtoList=blEndorseDto.getPrpPplanCoinsDtoList();
        List<PrpCplanCoinsDto> prpCplanCoinsDtoList=responseQueryPolicyInfoDto.getPrpCplanCoinsDtoList();
        settlePrpPplanCoins(prpPplanCoinsDtoList,prpCplanCoinsDtoList);

        return true;
    }





    /**
     * P表标志置C表标志处理
     * @param  prpPaddressDtoList
     * @param  prpCaddressDtoList
     * @return void
     * @throws Exception
     * @author 王保良
     * @date 2017年11月27日
     */
    public void settlePrpPaddress(List<PrpPaddressDto> prpPaddressDtoList,List<PrpCaddressDto> prpCaddressDtoList) throws Exception{
        int icurr=0;
        PrpCaddressDto prpCaddressDto=new PrpCaddressDto();
        for (int i=0;i<prpPaddressDtoList.size();i++) {
            Integer addressNo = prpPaddressDtoList.get(i).getAddressNo();
            icurr = prpCaddressSearch(addressNo, prpCaddressDtoList);
            if (icurr >= 0) {
                prpCaddressDto = prpCaddressDtoList.get(icurr);
                prpCaddressDto.setFlag(prpPaddressDtoList.get(i).getFlag());
                prpCaddressDtoList.set(icurr,prpCaddressDto);
            }
        }
    }

    /**
     * P表标志置C表标志处理
     * @param  prpPengageDtoList
     * @param  prpCengageDtoList
     * @return void
     * @throws Exception
     * @author 王保良
     * @date 2017年11月27日
     */
    public void settlePrpPengage(List<PrpPengageDto> prpPengageDtoList,List<PrpCengageDto> prpCengageDtoList) throws Exception{
        int icurr=0;
        PrpCengageDto prpCengageDto=new PrpCengageDto();
        for (int i=0;i<prpPengageDtoList.size();i++){
            Integer serialNo=prpPengageDtoList.get(i).getSerialNo();
            Integer lineNo=prpPengageDtoList.get(i).getLineNo();
            icurr=PrpCengageSearch(serialNo,lineNo,prpCengageDtoList);
            if (icurr>=0){
                prpCengageDto=prpCengageDtoList.get(icurr);
                prpCengageDto.setFlag(prpPengageDtoList.get(i).getFlag());
                prpCengageDtoList.set(icurr,prpCengageDto);
            }
        }
    }

    /**
     * P表标志置C表标志处理
     * @param  prpCexpenseDto
     * @param  prpPexpenseDto
     * @return void
     * @throws Exception
     * @author 王保良
     * @date 2017年11月27日
     */
    public void settlePrpPexpense( PrpPexpenseDto prpPexpenseDto, PrpCexpenseDto prpCexpenseDto) throws Exception{
        int icurr=0;
        PrpCexpenseDto prpCexpenseDto1=new PrpCexpenseDto();
           String poicyNo=prpPexpenseDto.getPolicyNo();
           icurr=PrpCexpenseSearch(poicyNo,prpCexpenseDto);
           if (icurr>=0){
               prpCexpenseDto1=prpCexpenseDto;
               prpCexpenseDto1.setFlag(prpPexpenseDto.getFlag());
               prpCexpenseDto=prpCexpenseDto1;
           }
    }

    /**
     * P表标志置C表标志处理
     * @param  prpPfeeDtoList
     * @param  prpCfeeDtoList
     * @return void
     * @throws Exception
     * @author 王保良
     * @date 2017年11月27日
     */
    public void settlePrpPfee(List<PrpPfeeDto> prpPfeeDtoList, List<PrpCfeeDto> prpCfeeDtoList) throws Exception{
        int icurr=0;
        PrpCfeeDto prpCfeeDto=new PrpCfeeDto();
        for (int i=0;i<prpPfeeDtoList.size();i++){
            String currency=prpPfeeDtoList.get(i).getCurrency();
            icurr=PrpCfeeSearch(currency,prpCfeeDtoList);
            if (icurr>=0){
                prpCfeeDto=prpCfeeDtoList.get(icurr);
                prpCfeeDto.setFlag(prpPfeeDtoList.get(i).getFlag());
                prpCfeeDtoList.set(icurr,prpCfeeDto);
            }
        }
    }

    /**
     * P表标志置C表标志处理
     * @param  prpPinsuredDtoList
     * @param  prpCinsuredDtoList
     * @return void
     * @throws Exception
     * @author 王保良
     * @date 2017年11月27日
     */
    public void settlePrpPinsured(List<PrpPinsuredDto> prpPinsuredDtoList,List<PrpCinsuredDto> prpCinsuredDtoList) throws Exception {
        int icurr=0;
        PrpCinsuredDto prpCinsuredDto=new PrpCinsuredDto();
        for (int i=0;i<prpPinsuredDtoList.size();i++){
            Integer serialNo=prpPinsuredDtoList.get(i).getSerialNo();
            icurr=PrpCinsuredSearch(serialNo,prpCinsuredDtoList);
            if (icurr>=0){
                prpCinsuredDto=prpCinsuredDtoList.get(icurr);
                prpCinsuredDto.setFlag(prpPinsuredDtoList.get(i).getFlag());
                prpCinsuredDtoList.set(icurr,prpCinsuredDto);
            }
        }
    }

    /**
     * P表标志置C表标志处理
     * @param  prpPitemKindDtoList
     * @param  prpCitemKindDtoList
     * @return boolean
     * @throws Exception
     * @author 王保良
     * @date 2017年11月27日
     */
    public void settlePrpPitemKind(List<PrpPitemKindDto> prpPitemKindDtoList,List<PrpCitemKindDto> prpCitemKindDtoList) throws Exception{
        int icurr=0;
        String strFlag="";
        PrpCitemKindDto prpCitemKindDto=new PrpCitemKindDto();

        for (int i=0;i<prpPitemKindDtoList.size();i++){
            Integer itemKindNo=prpPitemKindDtoList.get(i).getItemKindNo();
            icurr=PrpCitemKindSearch(itemKindNo,prpCitemKindDtoList);
            if (icurr>=0){
                prpCitemKindDto=prpCitemKindDtoList.get(icurr);
                strFlag=prpPitemKindDtoList.get(i).getFlag();
                if (prpCitemKindDto.getFlag().length() > 1 && strFlag.length() > 1){
                    strFlag=strFlag.substring(0,1)+prpCitemKindDto.getFlag().substring(1);
                }
                prpCitemKindDto.setFlag(strFlag);
                prpCitemKindDtoList.set(icurr,prpCitemKindDto);

            }
        }
    }

    /**
     * P表标志置C表标志处理
     * @param  prpPplanDtoList
     * @param  prpCplanDtoList
     * @return boolean
     * @throws Exception
     * @author 王保良
     * @date 2017年11月27日
     */
    public void settlePrpPplan(List<PrpPplanDto> prpPplanDtoList,List<PrpCplanDto> prpCplanDtoList) throws Exception{
        int icurr=0;
        PrpCplanDto prpCplanDto=new PrpCplanDto();

        for (int i=0;i<prpPplanDtoList.size();i++){
            Integer payNo=prpPplanDtoList.get(i).getPayNo();
            Integer serialNo=prpPplanDtoList.get(i).getSerialNo();
            icurr=PrpCplanSearch(payNo,serialNo,prpCplanDtoList);
            if (icurr>=0){
                prpCplanDto=prpCplanDtoList.get(icurr);
                prpCplanDto.setFlag(prpPplanDtoList.get(i).getFlag());
                prpCplanDtoList.set(icurr,prpCplanDto);
            }
        }
    }

    /**
     * P表标志置C表标志处理
     * @param  prpPplanCoinsDtoList
     * @param  prpCplanCoinsDtoList
     * @return boolean
     * @throws Exception
     * @author 王保良
     * @date 2017年11月27日
     */
    public void settlePrpPplanCoins(List<PrpPplanCoinsDto> prpPplanCoinsDtoList,List<PrpCplanCoinsDto> prpCplanCoinsDtoList) throws Exception{
        int icurr=0;
        PrpCplanCoinsDto prpCplanCoinsDto=new PrpCplanCoinsDto();
        for (int i=0;i<prpPplanCoinsDtoList.size();i++){
            Integer serialNo=prpPplanCoinsDtoList.get(i).getSerialNo();
            String payReason=prpPplanCoinsDtoList.get(i).getPayReason();
            icurr=PrpCplanCoinsSearch(serialNo,payReason,prpCplanCoinsDtoList);
            if (icurr>=0){
                prpCplanCoinsDto=prpCplanCoinsDtoList.get(icurr);
                prpCplanCoinsDto.setFlag(prpPplanCoinsDtoList.get(i).getFlag());
                prpCplanCoinsDtoList.set(icurr,prpCplanCoinsDto);
            }
        }
    }



    /**
     * 根据地址序号查询下标
     * @param  addressNo
     * @param  prpCaddressDtoList
     * @return Integer
     * @throws Exception
     * @author 王保良
     * @date 2017年11月27日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer prpCaddressSearch(Integer addressNo,List<PrpCaddressDto> prpCaddressDtoList) throws Exception{
        int icurr=0;
        int iFindFlag=0;
        for (int i=0;i<prpCaddressDtoList.size();i++){
            if (prpCaddressDtoList.get(i).getAddressNo().equals(addressNo)){
                icurr=0;
                iFindFlag=1;
            }
        }
        if (iFindFlag==0){
            icurr=-1;
        }
        return icurr;
    }

    /**
     * 根据序号和行号查询下标
     * @param serialNo
     * @param lineNo
     * @param prpCaddressDtoList
     * @return Integer
     * @throws Exception
     * @author 王保良
     * @date 2017年11月27日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer PrpCengageSearch(Integer serialNo,Integer lineNo,List<PrpCengageDto> prpCengageDtoList) throws Exception{
        int icurr=0;
        int iFindFlag=0;
        for (int i=0;i<prpCengageDtoList.size();i++){
            if (prpCengageDtoList.get(i).getSerialNo().equals(serialNo)&&prpCengageDtoList.get(i).getLineNo().equals(lineNo)){
                icurr=i;
                iFindFlag=1;
            }
        }
        if (iFindFlag==0){
            icurr=-1;
        }
        return icurr;
    }

    /**
     * 根据保单号查询下标
     * @param  policyNo
     * @param  prpCexpenseDto
     * @return Integer
     * @throws Exception
     * @author 王保良
     * @date 2017年11月27日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer PrpCexpenseSearch(String policyNo,PrpCexpenseDto prpCexpenseDto) throws Exception{
        int icurr=0;
        int iFindFlag=0;
        if (prpCexpenseDto!=null) {
            if (prpCexpenseDto.getPolicyNo().trim().equals(policyNo)) {
                iFindFlag = 1;
            }
        }
        if (iFindFlag==0){
            icurr=-1;
        }
        return icurr;
    }

    /**
     * 根据币别信息查询下标
     * @param  currency
     * @param  prpCfeeDtoList
     * @return Integer
     * @throws Exception
     * @author 王保良
     * @date 2017年11月27日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer PrpCfeeSearch(String currency,List<PrpCfeeDto> prpCfeeDtoList) throws  Exception{
        int icurr=0;
        int iFindFlag=0;
        for (int i=0;i<prpCfeeDtoList.size();i++){
            if (prpCfeeDtoList.get(i).getCurrency().trim().equals(currency)){
                icurr=i;
                iFindFlag=1;
            }
        }
        if (iFindFlag == 0){
            icurr=-1;
        }
        return icurr;
    }

    /**
     * 根据序号查询下标
     * @param  serialNo
     * @param  prpCinsuredDtoList
     * @return Integer
     * @throws Exception
     * @author 王保良
     * @date 2017年11月27日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer PrpCinsuredSearch(Integer serialNo,List<PrpCinsuredDto> prpCinsuredDtoList) throws  Exception{
        int icurr=0;
        int iFindFlag=0;
        for (int i=0;i<prpCinsuredDtoList.size();i++){
            if (prpCinsuredDtoList.get(i).getSerialNo().equals(serialNo)){
                icurr=i;
                iFindFlag=1;
            }
        }
        if (iFindFlag==0){
            icurr=-1;
        }
        return icurr;
    }

    /**
     * 根据标的序号查询下标
     * @param  itemKindNo
     * @param  prpCitemKindDtoList
     * @return Integer
     * @throws Exception
     * @author 王保良
     * @date 2017年11月27日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer PrpCitemKindSearch(Integer itemKindNo,List<PrpCitemKindDto> prpCitemKindDtoList) throws Exception{
        int icurr=0;
        int iFindFlag=0;
        for (int i=0;i<prpCitemKindDtoList.size();i++){
            if (prpCitemKindDtoList.get(i).getItemKindNo().equals(itemKindNo)){
                icurr=i;
                iFindFlag=1;
            }
        }
        if (iFindFlag == 0){
            icurr=-1;
        }
        return icurr;
    }

    /**
     * 根据付款序号和序号查询下标
     * @param  payNo
     * @param  serialNo
     * @param  prpCplanDtoList
     * @return Integer
     * @throws Exception
     * @author 王保良
     * @date 2017年11月27日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer PrpCplanSearch(Integer payNo,Integer serialNo,List<PrpCplanDto> prpCplanDtoList) throws Exception{
        int icurr=0;
        int iFindFlag=0;
        for (int i=0;i<prpCplanDtoList.size();i++){
            if (prpCplanDtoList.get(i).getPayNo().equals(payNo) && prpCplanDtoList.get(i).getSerialNo().equals(serialNo)){
                icurr=i;
                iFindFlag=1;
            }
        }
        if (iFindFlag==0){
            icurr=-1;
        }
        return icurr;
    }

    /**
     * 根据序号和付款原因查询下标
     * @param  serialNo
     * @param  payReason
     * @param  prpCplanCoinsDtoList
     * @return Integer
     * @throws Exception
     * @author 王保良
     * @date 2017年11月27日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer PrpCplanCoinsSearch(Integer serialNo,String payReason,List<PrpCplanCoinsDto> prpCplanCoinsDtoList) throws Exception{
        int icurr=0;
        int iFindFlag=0;
        for (int i=0;i<prpCplanCoinsDtoList.size();i++){
            if (prpCplanCoinsDtoList.get(i).getSerialNo().equals(serialNo) && prpCplanCoinsDtoList.get(i).getPayReason().trim().equals(payReason)){
                icurr=i;
                iFindFlag=1;
            }
        }
        if (iFindFlag == 0){
            icurr =-1;
        }
        return icurr;
    }

    /**
     * 根据补贴代码和补贴类型查询下标
     * @param  subsidyCode
     * @param  subsidyType
     * @param  prpCsubsidyDtoList
     * @return Integer
     * @throws Exception
     * @author 王保良
     * @date 2017年11月27日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer PrpCsubsidySearch(String subsidyCode,String subsidyType,List<PrpCsubsidyDto> prpCsubsidyDtoList) throws Exception{
        int icurr =0;
        int iFindFlag = 0;
        for(int i=0;i<prpCsubsidyDtoList.size();i++)
        {  if(prpCsubsidyDtoList.get(i).getSubsidyCode().trim().equals(subsidyCode) && prpCsubsidyDtoList.get(i).getSubsidyType().trim().equals(subsidyType))
        {icurr = i;
            iFindFlag = 1;
        }
        }
        if (iFindFlag ==0)
        { icurr = -1;}
        return icurr;
    }

    /**
     * 根据田块序号查询下标
     * @param  FeildNo
     * @param  prpCfeildDtoList
     * @return Integer
     * @throws Exception
     * @author 王保良
     * @date 2017年11月27日
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer PrpCfeildSearch(String FeildNo,List<PrpCfeildDto> prpCfeildDtoList) throws Exception{
        int icurr =0;
        int iFindFlag = 0;
        for(int i=0;i<prpCfeildDtoList.size();i++)
        {  if(prpCfeildDtoList.get(i).getFeildNo().trim().equals(FeildNo))
        {icurr = i;
            iFindFlag = 1;
        }
        }
        if (iFindFlag ==0)
        { icurr = -1;}
        return icurr;
    }
}
