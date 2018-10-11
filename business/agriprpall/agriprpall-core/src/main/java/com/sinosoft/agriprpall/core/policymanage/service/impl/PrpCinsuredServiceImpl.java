package com.sinosoft.agriprpall.core.policymanage.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpCPinsuredDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPinsuredDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCinsuredDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCinsuredDao;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCmainDao;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCinsured;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCinsuredKey;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmain;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCmainKey;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCinsuredService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrpCinsuredServiceImpl extends BaseServiceImpl implements PrpCinsuredService{
    /** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpCplanServiceImpl.class);
    @Autowired
    private PrpCinsuredDao prpCinsuredDao;
    @Autowired
    private PrpCmainDao prpCmainDao;

    /**
     *   根据保单号查询prpCinsured表（投保人被保险人关系表）信息
     * @author: 田慧
     * @date: 2017/11/20 16:19
     * @param policyNo 保单号
     * @return prpCinsuredDtoList 返回prpCinsuredDto的集合
     * @throws Exception
     */
    @Override
    public List<PrpCinsuredDto> queryByPolicyNo(String policyNo)throws Exception{
        if (StringUtils.isEmpty(policyNo)) {
            throw new DataVerifyException("保单号不能为空");
        }
        policyNo =  policyNo + "%";
        List<PrpCinsured> prpCinsuredList = prpCinsuredDao.findByPolicyNoLike(policyNo);
        List<PrpCinsuredDto> prpCinsuredDtoList = new ArrayList<PrpCinsuredDto>();
        this.convertCollection(prpCinsuredList, prpCinsuredDtoList, PrpCinsuredDto.class);
        return prpCinsuredDtoList;
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    @Override
    public PrpCinsuredDto queryByPK(String policyNo, Integer serialNo) {
        PrpCinsuredKey prpCinsuredKey = new PrpCinsuredKey(policyNo,serialNo);
        PrpCinsured prpCinsured = prpCinsuredDao.findOne(prpCinsuredKey);
        return this.convert(prpCinsured,PrpCinsuredDto.class);
    }

    /**
     *  根据保单号、关系人标识查询prpCinsured 投保人被保险人关系表信息
     * @author: 田慧
     * @date: 2017/11/20 16:51
     * @param policyNo 保单号
     * @param insuredFlag  关系人标识
     * @return prpCinsuredDtoList 返回prpCinsuredDto的集合
     * @throws Exception
     */
    @Override
    public List<PrpCinsuredDto> queryByCondition(String policyNo,String insuredFlag)throws Exception{
        if (StringUtils.isEmpty(policyNo)) {
            throw new DataVerifyException("保单号不能为空");
        }
        policyNo = policyNo + "%";
        if (StringUtils.isEmpty(insuredFlag)) {
            throw new DataVerifyException("关系人标识不能为空");
        }
        List<PrpCinsured> prpCinsuredList = prpCinsuredDao.queryByCondition(policyNo, insuredFlag);
        List<PrpCinsuredDto> prpCinsuredDtoList = new ArrayList<PrpCinsuredDto>();
        this.convertCollection(prpCinsuredList, prpCinsuredDtoList, PrpCinsuredDto.class);
        return prpCinsuredDtoList;
    }
    /**
     *  根据身份证查询PrpCinsuredDto投保人被保险人关系表Dto）结果集
     * @author: 田慧
     * @date: 2017/11/22 10:20
     * @param policyNo 保单号
     * @param identifyNumber 身份证件号
     * @return 返回prpCinsuredDtoList PrpCinsuredDto的集合
     */
     @Override
    public List<PrpCinsuredDto> queryPolicyNoByID(String policyNo, String identifyNumber)throws Exception{
         if (StringUtils.isEmpty(policyNo)) {
             throw new DataVerifyException("保单号不能为空");
         }
         if (StringUtils.isEmpty(identifyNumber)) {
             throw new DataVerifyException("身份证号不能为空");
         }
         //保单号模糊查询
         policyNo =  policyNo + "%";
         //身份证号模糊查询
         identifyNumber =  identifyNumber + "%";
         List<PrpCinsured> prpCinsuredList = prpCinsuredDao.queryPolicyNoByID(policyNo, identifyNumber);
         List<PrpCinsuredDto> prpCinsuredDtoList = new ArrayList<PrpCinsuredDto>();
         this.convertCollection(prpCinsuredList, prpCinsuredDtoList, PrpCinsuredDto.class);
         return prpCinsuredDtoList;
    }

    /**
     * P表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpPinsuredDto
     * @return PrpCinsuredDto
     * @throws Exception
     */
    @Override
    public PrpCinsuredDto PEvaluateC(PrpPinsuredDto prpPinsuredDto) throws Exception {
        PrpCinsuredDto prpCinsuredDto=new PrpCinsuredDto();

        prpCinsuredDto.setPolicyNo(prpPinsuredDto.getPolicyNo());
        prpCinsuredDto.setRiskCode(prpPinsuredDto.getRiskCode());
        prpCinsuredDto.setSerialNo(prpPinsuredDto.getSerialNo());
        prpCinsuredDto.setLanguage(prpPinsuredDto.getLanguage());
        prpCinsuredDto.setInsuredType(prpPinsuredDto.getInsuredType());
        prpCinsuredDto.setInsuredCode(prpPinsuredDto.getInsuredCode());
        prpCinsuredDto.setInsuredName(prpPinsuredDto.getInsuredName());
        prpCinsuredDto.setInsuredAddress(prpPinsuredDto.getInsuredAddress());
        prpCinsuredDto.setInsuredNature(prpPinsuredDto.getInsuredNature());
        prpCinsuredDto.setInsuredFlag(prpPinsuredDto.getInsuredFlag());
        prpCinsuredDto.setInsuredIdentity(prpPinsuredDto.getInsuredIdentity());
        prpCinsuredDto.setRelateSerialNo(prpPinsuredDto.getRelateSerialNo());
        prpCinsuredDto.setIdentifyType(prpPinsuredDto.getIdentifyType());
        prpCinsuredDto.setIdentifyNumber(prpPinsuredDto.getIdentifyNumber());
        prpCinsuredDto.setCreditLevel(prpPinsuredDto.getCreditLevel());
        prpCinsuredDto.setPossessNature(prpPinsuredDto.getPossessNature());
        prpCinsuredDto.setBusinessSource(prpPinsuredDto.getBusinessSource());
        prpCinsuredDto.setBusinessSort(prpPinsuredDto.getBusinessSort());
        prpCinsuredDto.setOccupationCode(prpPinsuredDto.getOccupationCode());
        prpCinsuredDto.setEducationCode(prpPinsuredDto.getEducationCode());
        prpCinsuredDto.setBank(prpPinsuredDto.getBank());
        prpCinsuredDto.setAccountName(prpPinsuredDto.getAccountName());
        prpCinsuredDto.setAccount(prpPinsuredDto.getAccount());
        prpCinsuredDto.setLinkerName(prpPinsuredDto.getLinkerName());
        prpCinsuredDto.setPostAddress(prpPinsuredDto.getPostAddress());
        prpCinsuredDto.setPostCode(prpPinsuredDto.getPostCode());
        prpCinsuredDto.setPhoneNumber(prpPinsuredDto.getPhoneNumber());
        prpCinsuredDto.setMobile(prpPinsuredDto.getMobile());
        prpCinsuredDto.setEmail(prpPinsuredDto.getEmail());
        prpCinsuredDto.setBenefitRate(prpPinsuredDto.getBenefitRate());
        prpCinsuredDto.setBenefitFlag(prpPinsuredDto.getBenefitFlag());
        prpCinsuredDto.setRiskLevel(prpPinsuredDto.getRiskLevel());
        prpCinsuredDto.setFlag(prpPinsuredDto.getFlag());

        prpCinsuredDto.setIsCareClaim(prpPinsuredDto.getIsCareClaim());
        prpCinsuredDto.setCashFocus(prpPinsuredDto.getCashFocus());
        prpCinsuredDto.setValidPeriod3(prpPinsuredDto.getValidPeriod3());
        prpCinsuredDto.setJobTitle(prpPinsuredDto.getJobTitle());
        prpCinsuredDto.setNationality(prpPinsuredDto.getNationality());
        prpCinsuredDto.setBusinessCode(prpPinsuredDto.getBusinessCode());
        prpCinsuredDto.setRevenueRegistNo(prpPinsuredDto.getRevenueRegistNo());
        prpCinsuredDto.setBusinessValidPeriod(prpPinsuredDto.getBusinessValidPeriod());
        prpCinsuredDto.setRevenueRegistValidPeriod(prpPinsuredDto.getRevenueRegistValidPeriod());
        prpCinsuredDto.setOtherCodeNo(prpPinsuredDto.getOtherCodeNo());
        prpCinsuredDto.setOtherCodeValidPeriod(prpPinsuredDto.getOtherCodeValidPeriod());
        prpCinsuredDto.setSex(prpPinsuredDto.getSex());
        return prpCinsuredDto;
    }

    /**
     * CP表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpCPinsuredDto
     * @return PrpCinsuredDto
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PrpCinsuredDto generatePrpCinsured(PrpCPinsuredDto prpCPinsuredDto) throws Exception {
        PrpCinsuredDto prpCinsuredDto=new PrpCinsuredDto();
        prpCinsuredDto.setPolicyNo(prpCPinsuredDto.getPolicyNo());
        prpCinsuredDto.setRiskCode(prpCPinsuredDto.getRiskCode());
        prpCinsuredDto.setSerialNo(prpCPinsuredDto.getSerialNo());
        prpCinsuredDto.setLanguage(prpCPinsuredDto.getLanguage());
        prpCinsuredDto.setInsuredType(prpCPinsuredDto.getInsuredType());
        prpCinsuredDto.setInsuredCode(prpCPinsuredDto.getInsuredCode());
        prpCinsuredDto.setInsuredName(prpCPinsuredDto.getInsuredName());
        prpCinsuredDto.setInsuredAddress(prpCPinsuredDto.getInsuredAddress());
        prpCinsuredDto.setInsuredNature(prpCPinsuredDto.getInsuredNature());
        prpCinsuredDto.setInsuredFlag(prpCPinsuredDto.getInsuredFlag());
        prpCinsuredDto.setInsuredIdentity(prpCPinsuredDto.getInsuredIdentity());
        prpCinsuredDto.setRelateSerialNo(prpCPinsuredDto.getRelateSerialNo());
        prpCinsuredDto.setIdentifyType(prpCPinsuredDto.getIdentifyType());
        prpCinsuredDto.setIdentifyNumber(prpCPinsuredDto.getIdentifyNumber());
        prpCinsuredDto.setCreditLevel(prpCPinsuredDto.getCreditLevel());
        prpCinsuredDto.setPossessNature(prpCPinsuredDto.getPossessNature());
        prpCinsuredDto.setBusinessSource(prpCPinsuredDto.getBusinessSource());
        prpCinsuredDto.setBusinessSort(prpCPinsuredDto.getBusinessSort());
        prpCinsuredDto.setOccupationCode(prpCPinsuredDto.getOccupationCode());
        prpCinsuredDto.setEducationCode(prpCPinsuredDto.getEducationCode());
        prpCinsuredDto.setBank(prpCPinsuredDto.getBank());
        prpCinsuredDto.setAccountName(prpCPinsuredDto.getAccountName());
        prpCinsuredDto.setAccount(prpCPinsuredDto.getAccount());
        prpCinsuredDto.setLinkerName(prpCPinsuredDto.getLinkerName());
        prpCinsuredDto.setPostAddress(prpCPinsuredDto.getPostAddress());
        prpCinsuredDto.setPostCode(prpCPinsuredDto.getPostCode());
        prpCinsuredDto.setPhoneNumber(prpCPinsuredDto.getPhoneNumber());
        prpCinsuredDto.setMobile(prpCPinsuredDto.getMobile());
        prpCinsuredDto.setEmail(prpCPinsuredDto.getEmail());
        prpCinsuredDto.setBenefitRate(prpCPinsuredDto.getBenefitRate());
        prpCinsuredDto.setBenefitFlag(prpCPinsuredDto.getBenefitFlag());
        prpCinsuredDto.setFlag(prpCPinsuredDto.getFlag());
        prpCinsuredDto.setRiskLevel(prpCPinsuredDto.getRiskLevel());
        prpCinsuredDto.setIsCareClaim(prpCPinsuredDto.getIsCareClaim());
        prpCinsuredDto.setCashFocus(prpCPinsuredDto.getCashFocus());
        prpCinsuredDto.setValidPeriod3(prpCPinsuredDto.getValidPeriod3());
        prpCinsuredDto.setJobTitle(prpCPinsuredDto.getJobTitle());
        prpCinsuredDto.setSex(prpCPinsuredDto.getSex());
        prpCinsuredDto.setNationality(prpCPinsuredDto.getNationality());
        prpCinsuredDto.setBusinessCode(prpCPinsuredDto.getBusinessCode());
        prpCinsuredDto.setBusinessValidPeriod(prpCPinsuredDto.getBusinessValidPeriod());
        prpCinsuredDto.setRevenueRegistNo(prpCPinsuredDto.getRevenueRegistNo());
        prpCinsuredDto.setRevenueRegistValidPeriod(prpCPinsuredDto.getRevenueRegistValidPeriod());
        prpCinsuredDto.setOtherCodeNo(prpCPinsuredDto.getOtherCodeNo());
        prpCinsuredDto.setOtherCodeValidPeriod(prpCPinsuredDto.getOtherCodeValidPeriod());


        prpCinsuredDto.setJobtitleName(prpCPinsuredDto.getJobtitleName());
        prpCinsuredDto.setBusinessSortName(prpCPinsuredDto.getBusinessSortName());
        prpCinsuredDto.setInsuredIdentityName(prpCPinsuredDto.getInsuredIdentityName());
        prpCinsuredDto.setRiskLevelName(prpCPinsuredDto.getRiskLevelName());
        prpCinsuredDto.setInsuredTypeName(prpCPinsuredDto.getInsuredTypeName());
        prpCinsuredDto.setInsuredFlagName(prpCPinsuredDto.getInsuredFlagName());
        prpCinsuredDto.setInsuredNatureName(prpCPinsuredDto.getInsuredNatureName());
        prpCinsuredDto.setInsuredLanguageName(prpCPinsuredDto.getInsuredLanguageName());
        prpCinsuredDto.setBusinessSort(prpCPinsuredDto.getBusinessSort());
        return prpCinsuredDto;
    }

    @Override
    public List<PrpCmainDto> queryPolicyById(String identifyNumber) throws Exception {
        if (StringUtils.isEmpty(identifyNumber)){
            throw new DataVerifyException("身份证号不能为空");
        }
        List<PrpCinsured> prpCinsuredList=prpCinsuredDao.queryByIdentifyNumber(identifyNumber);
        List<PrpCmainKey> prpCmainKeyList=new ArrayList<>();
        List<String> policyList = new ArrayList<>();
        for (int i=0;i<prpCinsuredList.size();i++){
            String policyNo=prpCinsuredList.get(i).getPolicyNo();
            policyList.add(policyNo);
        }
        List<PrpCmain> prpCmainList=new ArrayList<>();
        if (policyList.size()!=0) {
            prpCmainList = prpCmainDao.queryAllByPolicyNo(policyList);
        }
        List<PrpCmainDto> prpCmainDtoList=new ArrayList<>();
        convertCollection(prpCmainList,prpCmainDtoList,PrpCmainDto.class);
        return prpCmainDtoList;
    }

    /**
     * （查询被保险人代码）
     * @author: 王志文
     * @date: 2018/3/31 18:14
     * @param policyNo 保单号
     * @return
     * @throws Exception
     */
    @Override
    public List<PrpCinsuredDto> queryInsuredCodeByPolicyNoAndInsuredName(String policyNo) throws Exception {
        List<PrpCinsured> prpCinsuredList = prpCinsuredDao.queryAllByPolicyNoAndInsuredName(policyNo);
        List<PrpCinsuredDto> prpCinsuredDtoList = new ArrayList<>();
        this.convertCollection(prpCinsuredList,prpCinsuredDtoList,PrpCinsuredDto.class);
        return prpCinsuredDtoList;
    }

    /**
     * 根据被保险人代码查询被保险人信息
     * @author: 王志文
     * @date: 2018/3/31 18:14
     * @param map
     * @return
     * @throws Exception
     */
    @Override
    public List<PrpCinsuredDto> queryByInsuredCode(String insuredCode) throws Exception {
        if (StringUtils.isEmpty(insuredCode)){
            throw new DataVerifyException("请输入被保险人代码");
        }
        List<PrpCinsured> prpCinsuredList=prpCinsuredDao.queryByInsuredCode(insuredCode);
        List<PrpCinsuredDto> prpCinsuredDtoList=new ArrayList<>();
        convertCollection(prpCinsuredList,prpCinsuredDtoList,PrpCinsuredDto.class);
        return prpCinsuredDtoList;
    }
}
