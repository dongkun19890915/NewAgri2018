package com.sinosoft.agriprpall.core.policymanage.service.impl;


import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpCPitemKindDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPitemKindDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ClaimQueryDeductiblerateDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindDto;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCitemKindDao;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCitemKind;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCitemKindKey;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCitemKindService;
import com.sinosoft.dms.api.dict.dto.PrpDcodeDto;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.DataVerifyException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;



/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-20 05:44:18.998
 * @description 保单标的子险信息表Core接口实现
 */
@Service
public class PrpCitemKindServiceImpl extends BaseServiceImpl implements PrpCitemKindService {
    /** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpCitemKindServiceImpl.class);

    @Autowired
    private PrpCitemKindDao prpCitemKindDao;
    @Autowired
    private EntityManager entityManager;
    /**
     * 标的子险信息表保存
     * @author: 田健
     * @date: 2017/12/25 16:25
     * @param prpCitemKindDto 标的子险信息Dto
     */
    @Override
    public void save(PrpCitemKindDto prpCitemKindDto) {
        PrpCitemKind prpCitemKind = this.convert(prpCitemKindDto, PrpCitemKind.class);
        prpCitemKindDao.save(prpCitemKind);
    }
    /**
     * 根据主键删除标的子险信息表数据
     * @author: 田健
     * @date: 2017/12/25 16:27
     * @param   policyNo 保单号,itemKindNo 序号
     */
    @Override
    public void remove(String policyNo,Integer itemKindNo) {
        PrpCitemKindKey prpCitemKindKey = new PrpCitemKindKey(policyNo,itemKindNo);
        prpCitemKindDao.delete(prpCitemKindKey);
    }
    /**
     * 更新标的子险信息表信息
     * @author: 田健
     * @date: 2017/12/25 16:29
     * @param prpCitemKindDto 标的子险信息Dto
     */
    @Override
    public void modify(PrpCitemKindDto prpCitemKindDto) {
        PrpCitemKind prpCitemKind = this.convert(prpCitemKindDto, PrpCitemKind.class);
        prpCitemKindDao.save(prpCitemKind);
    }
    /**
     * 根据主键查询标的子险信息表数据
     * @author: 田健
     * @date: 2017/12/25 16:27
     * @param  policyNo 保单号,itemKindNo 序号
     */
    @Override
    public PrpCitemKindDto queryByPK(String policyNo,Integer itemKindNo) {
        PrpCitemKindKey prpCitemKindKey = new PrpCitemKindKey(policyNo,itemKindNo);
        PrpCitemKind prpCitemKind = prpCitemKindDao.findOne(prpCitemKindKey);
        return this.convert(prpCitemKind,PrpCitemKindDto.class);
    }
    /**
     * 根据传来的条件查询PrpCitemKind表，返回List<PrpCitemKindDto>给服务调用
     * @author: 宋振振
     * @date: 2017/11/11 16:39
     * @param statement
     * @return List<PrpCitemKindDto>
     * @throws Exception
     */
    @Override
    public List<PrpCitemKindDto> queryPrpCitemKindByCondition(String statement)throws Exception{
        if (StringUtils.isEmpty(statement)) {
            throw new DataVerifyException("入参条件statement为空！");
        }

        List<PrpCitemKindDto> prpCitemKindDtoList = new ArrayList<PrpCitemKindDto>();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select p from PrpCitemKind p where ").append(statement);
        Query dataQuery = entityManager.createNativeQuery(stringBuilder.toString(), PrpCitemKind.class);
        List<PrpCitemKind> prpCitemKindList = dataQuery.getResultList();
        convertCollection(prpCitemKindList, prpCitemKindDtoList, PrpCitemKindDto.class);

        return prpCitemKindDtoList;
    }
    /**
     * 按照 policyNo 查询 PrpCitemKind 集合
     * @author 王心洋
     * @time 2017-11-09
     * @param policyNo 保单号
     * @return List<PrpCitemKind>
     */
    @Override
    public List<PrpCitemKindDto> findItemByPolicyNo(String policyNo) throws Exception {
        List<PrpCitemKind> prpCitemKindList = prpCitemKindDao.findItemByPolicyNo(policyNo);
        List<PrpCitemKindDto> prpCitemKindDtoList = new ArrayList<>();
        convertCollection(prpCitemKindList, prpCitemKindDtoList, PrpCitemKindDto.class);
        return prpCitemKindDtoList;
    }


    /**
     *  根据条件查询标的子险信息表信息
     * @author: 田慧
     * @date: 2017/11/22 17:16
     * @param prpCitemKindDto 保单标的子险信息表Dto
     * @return 返回PrpCitemKindDto的集合
     * @throws Exception
     */
    @Override
    public List<PrpCitemKindDto> queryByConditions(PrpCitemKindDto prpCitemKindDto)throws Exception {
        List<PrpCitemKind> prpCitemKindList = null;
        if (StringUtils.isEmpty(prpCitemKindDto.getPolicyNo())) {
            throw new DataVerifyException("保单号不能为空");
        }
        //String policyNo = "%"+prpCitemKindDto.getPolicyNo()+"%";
        String policyNo = prpCitemKindDto.getPolicyNo();
        if (prpCitemKindDto.getFlag().equals("0")) {

            if (StringUtils.isEmpty(prpCitemKindDto.getModel())) {
                throw new DataVerifyException("规格型号不能为空");
            }
            String model = "%" + prpCitemKindDto.getModel() + "%";
            prpCitemKindList = prpCitemKindDao.queryByModel(policyNo, model);

        } else if (prpCitemKindDto.getFlag().equals("1")) {
            if (prpCitemKindDto.getFamilyNo() == null) {
                throw new DataVerifyException("分户序号不能为空");
            }
            prpCitemKindList = prpCitemKindDao.queryByamilyNo(policyNo, prpCitemKindDto.getFamilyNo());
        }
        List<PrpCitemKindDto> prpCitemKindDtoList = new ArrayList<PrpCitemKindDto>();
        this.convertCollection(prpCitemKindList, prpCitemKindDtoList, PrpCitemKindDto.class);
        return prpCitemKindDtoList;
    }
    /**
     * P表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpPitemKindDto
     * @return prpCitemKindDto
     * @throws Exception
     */
    @Override
    public PrpCitemKindDto PEvaluateC(PrpPitemKindDto prpPitemKindDto) throws Exception {
        PrpCitemKindDto prpCitemKindDto=new PrpCitemKindDto();
        prpCitemKindDto.setPolicyNo(prpPitemKindDto.getPolicyNo());
        prpCitemKindDto.setRiskCode(prpPitemKindDto.getRiskCode());
        prpCitemKindDto.setItemKindNo(prpPitemKindDto.getItemKindNo());
        prpCitemKindDto.setFamilyNo(prpPitemKindDto.getFamilyNo());
        prpCitemKindDto.setFamilyName(prpPitemKindDto.getFamilyName());
        prpCitemKindDto.setRationType(prpPitemKindDto.getRationType());
        prpCitemKindDto.setKindCode(prpPitemKindDto.getKindCode());
        prpCitemKindDto.setKindName(prpPitemKindDto.getKindName());
        prpCitemKindDto.setItemNo(prpPitemKindDto.getItemNo());
        prpCitemKindDto.setItemCode(prpPitemKindDto.getItemCode());
        prpCitemKindDto.setItemDetailName(prpPitemKindDto.getItemDetailName());
        prpCitemKindDto.setModeCode(prpPitemKindDto.getModeCode());
        prpCitemKindDto.setModeName(prpPitemKindDto.getModeName());
        prpCitemKindDto.setStartDate(prpPitemKindDto.getStartDate());
        prpCitemKindDto.setStartHour(prpPitemKindDto.getStartHour());
        prpCitemKindDto.setEndDate(prpPitemKindDto.getEndDate());
        prpCitemKindDto.setEndHour(prpPitemKindDto.getEndHour());
        prpCitemKindDto.setModel(prpPitemKindDto.getModel());
        prpCitemKindDto.setBuyDate(prpPitemKindDto.getBuyDate());
        prpCitemKindDto.setAddressNo(prpPitemKindDto.getAddressNo());
        prpCitemKindDto.setCalculateFlag(prpPitemKindDto.getCalculateFlag());
        prpCitemKindDto.setCurrency(prpPitemKindDto.getCurrency());
        prpCitemKindDto.setUnitAmount(prpPitemKindDto.getUnitAmount());
        prpCitemKindDto.setQuantity(prpPitemKindDto.getQuantity());
        prpCitemKindDto.setUnit(prpPitemKindDto.getUnit());
        prpCitemKindDto.setValue(prpPitemKindDto.getValue());
        prpCitemKindDto.setAmount(prpPitemKindDto.getAmount());
        prpCitemKindDto.setRatePeriod(prpPitemKindDto.getRatePeriod());
        prpCitemKindDto.setRate(prpPitemKindDto.getRate());
        prpCitemKindDto.setShortRateFlag(prpPitemKindDto.getShortRateFlag());
        prpCitemKindDto.setShortRate(prpPitemKindDto.getShortRate());
        prpCitemKindDto.setBasePremium(prpPitemKindDto.getBasePremium());
        prpCitemKindDto.setBenchmarkPremium(prpPitemKindDto.getBenchmarkPremium());
        prpCitemKindDto.setDiscount(prpPitemKindDto.getDiscount());
        prpCitemKindDto.setAdjustRate(prpPitemKindDto.getAdjustRate());
        prpCitemKindDto.setPremium(prpPitemKindDto.getPremium());
        prpCitemKindDto.setDeductibleRate(prpPitemKindDto.getDeductibleRate());
        prpCitemKindDto.setDeductible(prpPitemKindDto.getDeductible());
        prpCitemKindDto.setTotalLossRatio(prpPitemKindDto.getTotalLossRatio());
        prpCitemKindDto.setTriggerPoint(prpPitemKindDto.getTriggerPoint());
		/* modify by liuning begin 20040313 */
        // prpCitemKindDto.setFlag(prpPitemKindDto.getFlag());
        String strPToCFlag = prpPitemKindDto.getFlag();
        // LIJIBIN MODIFY 2004-03-25 第一位不能取消而是置空
        // prpCitemKindDto.setFlag(strPToCFlag.substring(1,strPToCFlag.length()));
        prpCitemKindDto.setFlag(" "
                + strPToCFlag.substring(1, strPToCFlag.length()));
		/* modify by liuning end 20040313 */
        prpCitemKindDto.setRegionRate(prpPitemKindDto.getRegionRate());
        prpCitemKindDto.setDrinkRate(prpPitemKindDto.getDrinkRate());
        prpCitemKindDto.setDrunkRate(prpPitemKindDto.getDrunkRate());
        //prpCitemKindDto.setAgeSub(prpPitemKindDto.getAgeSub());
        prpCitemKindDto.setUnitDayAmountSub(prpPitemKindDto.getUnitDayAmountSub());
        prpCitemKindDto.setDaySub(prpPitemKindDto.getDaySub());
        prpCitemKindDto.setCattleType(prpPitemKindDto.getCattleType());
        prpCitemKindDto.setUnitPersonLimitAmount(prpPitemKindDto.getUnitPersonLimitAmount());
        prpCitemKindDto.setUnitPersonAmount(prpPitemKindDto.getUnitPersonAmount());
        prpCitemKindDto.setPersonType(prpPitemKindDto.getPersonType());
        prpCitemKindDto.setLawsuitAmount(prpPitemKindDto.getLawsuitAmount());
        prpCitemKindDto.setBedNum(prpPitemKindDto.getBedNum());
        prpCitemKindDto.setBedPremium(prpPitemKindDto.getBedPremium());
        prpCitemKindDto.setHospitalPremium(prpPitemKindDto.getHospitalPremium());
        prpCitemKindDto.setKindWorkerNum(prpPitemKindDto.getKindWorkerNum());
        prpCitemKindDto.setKindWorkerPremium(prpPitemKindDto.getKindWorkerPremium());
        prpCitemKindDto.setClinicNum(prpPitemKindDto.getClinicNum());
        prpCitemKindDto.setClinicPremium(prpPitemKindDto.getClinicPremium());
        prpCitemKindDto.setnClinicNum(prpPitemKindDto.getnClinicNum());
        prpCitemKindDto.setnClinicPremium(prpPitemKindDto.getnClinicPremium());
        prpCitemKindDto.setRoomNum(prpPitemKindDto.getRoomNum());
        prpCitemKindDto.setRoomPremium(prpPitemKindDto.getRoomPremium());
        prpCitemKindDto.setNurseNum(prpPitemKindDto.getNurseNum());
        prpCitemKindDto.setNursePremium(prpPitemKindDto.getNursePremium());
        prpCitemKindDto.setWorkerPremium(prpPitemKindDto.getWorkerPremium());
        prpCitemKindDto.setWorkerNum(prpPitemKindDto.getWorkerNum());
        prpCitemKindDto.setQuantityNewborn(prpPitemKindDto.getQuantityNewborn());
        prpCitemKindDto.setChargeNewbornFlag(prpPitemKindDto.getChargeNewbornFlag());
        prpCitemKindDto.setUnitPremium(prpPitemKindDto.getUnitPremium());
        prpCitemKindDto.setOperationNum(prpPitemKindDto.getOperationNum());
        prpCitemKindDto.setOperationPremium(prpPitemKindDto.getOperationPremium());
        prpCitemKindDto.setMedicalRate(prpPitemKindDto.getMedicalRate());
        prpCitemKindDto.setPostRate(prpPitemKindDto.getPostRate());
        prpCitemKindDto.setNoTaxPremium(prpPitemKindDto.getNoTaxPremium());
        prpCitemKindDto.setTaxFlag(prpPitemKindDto.getTaxFlag());
        prpCitemKindDto.setTaxRate(prpPitemKindDto.getTaxRate());
        prpCitemKindDto.setTaxFee(prpPitemKindDto.getTaxFee());
        prpCitemKindDto.setPremiumCalMethod(prpPitemKindDto.getPremiumCalMethod());
        prpCitemKindDto.setForestUse(prpPitemKindDto.getForestUse());
        return prpCitemKindDto;
    }

    /**
     * P表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpCPitemKindDto
     * @return PrpCitemKindDto
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PrpCitemKindDto generatePrpCitemKind(PrpCPitemKindDto prpCPitemKindDto) throws Exception {
        PrpCitemKindDto prpCitemKindDto=new PrpCitemKindDto();
        prpCitemKindDto.setPolicyNo(prpCPitemKindDto.getPolicyNo());
        prpCitemKindDto.setRiskCode(prpCPitemKindDto.getRiskCode());
        prpCitemKindDto.setItemKindNo(prpCPitemKindDto.getItemKindNo());
        prpCitemKindDto.setFamilyNo(prpCPitemKindDto.getFamilyNo());
        prpCitemKindDto.setFamilyName(prpCPitemKindDto.getFamilyName());
        prpCitemKindDto.setRationType(prpCPitemKindDto.getRationType());
        prpCitemKindDto.setKindCode(prpCPitemKindDto.getKindCode());
        prpCitemKindDto.setKindName(prpCPitemKindDto.getKindName());
        prpCitemKindDto.setItemNo(prpCPitemKindDto.getItemNo());
        prpCitemKindDto.setItemCode(prpCPitemKindDto.getItemCode());
        prpCitemKindDto.setItemDetailName(prpCPitemKindDto.getItemDetailName());
        prpCitemKindDto.setModeCode(prpCPitemKindDto.getModeCode());
        prpCitemKindDto.setModeName(prpCPitemKindDto.getModeName());
        prpCitemKindDto.setStartDate(prpCPitemKindDto.getStartDate());
        prpCitemKindDto.setStartHour(prpCPitemKindDto.getStartHour());
        prpCitemKindDto.setEndDate(prpCPitemKindDto.getEndDate());
        prpCitemKindDto.setEndHour(prpCPitemKindDto.getEndHour());
        prpCitemKindDto.setModel(prpCPitemKindDto.getModel());
        prpCitemKindDto.setBuyDate(prpCPitemKindDto.getBuyDate());
        prpCitemKindDto.setAddressNo(prpCPitemKindDto.getAddressNo());
        prpCitemKindDto.setCalculateFlag(prpCPitemKindDto.getCalculateFlag());
        prpCitemKindDto.setCurrency(prpCPitemKindDto.getCurrency());
        prpCitemKindDto.setUnitAmount(prpCPitemKindDto.getUnitAmount());
        prpCitemKindDto.setQuantity(prpCPitemKindDto.getQuantity());
        prpCitemKindDto.setUnit(prpCPitemKindDto.getUnit());
        prpCitemKindDto.setValue(prpCPitemKindDto.getValue());
        prpCitemKindDto.setAmount(prpCPitemKindDto.getAmount());
        prpCitemKindDto.setRatePeriod(prpCPitemKindDto.getRatePeriod());
        prpCitemKindDto.setRate(prpCPitemKindDto.getRate());
        prpCitemKindDto.setShortRateFlag(prpCPitemKindDto.getShortRateFlag());
        prpCitemKindDto.setShortRate(prpCPitemKindDto.getShortRate());
        prpCitemKindDto.setBasePremium(prpCPitemKindDto.getBasePremium());
        prpCitemKindDto.setBenchmarkPremium(prpCPitemKindDto.getBenchmarkPremium());
        prpCitemKindDto.setDiscount(prpCPitemKindDto.getDiscount());
        prpCitemKindDto.setAdjustRate(prpCPitemKindDto.getAdjustRate());
        prpCitemKindDto.setPremium(prpCPitemKindDto.getPremium());
        prpCitemKindDto.setTriggerPoint(prpCPitemKindDto.getTriggerPoint());
        prpCitemKindDto.setTotalLossRatio(prpCPitemKindDto.getTotalLossRatio());
        prpCitemKindDto.setDeductibleRate(prpCPitemKindDto.getDeductibleRate());
        prpCitemKindDto.setDeductible(prpCPitemKindDto.getDeductible());
        prpCitemKindDto.setFlag(prpCPitemKindDto.getFlag());
        prpCitemKindDto.setRegionRate(prpCPitemKindDto.getRegionRate());
        prpCitemKindDto.setDrinkRate(prpCPitemKindDto.getDrinkRate());
        prpCitemKindDto.setDrunkRate(prpCPitemKindDto.getDrunkRate());
        //	prpCitemKindDto.setAgeSub(prpCPitemKindDto.getAgeSub());
        prpCitemKindDto.setUnitDayAmountSub(prpCPitemKindDto.getUnitDayAmountSub());
        prpCitemKindDto.setDaySub(prpCPitemKindDto.getDaySub());
        prpCitemKindDto.setCattleType(prpCPitemKindDto.getCattleType());
        prpCitemKindDto.setUnitPersonLimitAmount(prpCPitemKindDto.getUnitPersonLimitAmount());
        prpCitemKindDto.setUnitPersonAmount(prpCPitemKindDto.getUnitPersonAmount());
        prpCitemKindDto.setPersonType(prpCPitemKindDto.getPersonType());
        prpCitemKindDto.setLawsuitAmount(prpCPitemKindDto.getLawsuitAmount());
        prpCitemKindDto.setBedNum(prpCPitemKindDto.getBedNum());
        prpCitemKindDto.setBedPremium(prpCPitemKindDto.getBedPremium());
        prpCitemKindDto.setHospitalPremium(prpCPitemKindDto.getHospitalPremium());
        prpCitemKindDto.setKindWorkerNum(prpCPitemKindDto.getKindWorkerNum());
        prpCitemKindDto.setKindWorkerPremium(prpCPitemKindDto.getKindWorkerPremium());
        prpCitemKindDto.setClinicNum(prpCPitemKindDto.getClinicNum());
        prpCitemKindDto.setClinicPremium(prpCPitemKindDto.getClinicPremium());
        prpCitemKindDto.setnClinicNum(prpCPitemKindDto.getnClinicNum());
        prpCitemKindDto.setnClinicPremium(prpCPitemKindDto.getnClinicPremium());
        prpCitemKindDto.setRoomNum(prpCPitemKindDto.getRoomNum());
        prpCitemKindDto.setRoomPremium(prpCPitemKindDto.getRoomPremium());
        prpCitemKindDto.setNurseNum(prpCPitemKindDto.getNurseNum());
        prpCitemKindDto.setNursePremium(prpCPitemKindDto.getNursePremium());
        prpCitemKindDto.setWorkerPremium(prpCPitemKindDto.getWorkerPremium());
        prpCitemKindDto.setWorkerNum(prpCPitemKindDto.getWorkerNum());
        prpCitemKindDto.setQuantityNewborn(prpCPitemKindDto.getQuantityNewborn());
        prpCitemKindDto.setChargeNewbornFlag(prpCPitemKindDto.getChargeNewbornFlag());
        prpCitemKindDto.setUnitPremium(prpCPitemKindDto.getUnitPremium());
        prpCitemKindDto.setReplyNo(prpCPitemKindDto.getReplyNo());
        prpCitemKindDto.setOperationNum(prpCPitemKindDto.getOperationNum());
        prpCitemKindDto.setOperationPremium(prpCPitemKindDto.getOperationPremium());
        prpCitemKindDto.setMedicalRate(prpCPitemKindDto.getMedicalRate());
        prpCitemKindDto.setPostRate(prpCPitemKindDto.getPostRate());
        prpCitemKindDto.setNoTaxPremium(prpCPitemKindDto.getNoTaxPremium());
        prpCitemKindDto.setTaxFlag(prpCPitemKindDto.getTaxFlag());
        prpCitemKindDto.setTaxRate(prpCPitemKindDto.getTaxRate());
        prpCitemKindDto.setTaxFee(prpCPitemKindDto.getTaxFee());
        prpCitemKindDto.setPremiumCalMethod(prpCPitemKindDto.getPremiumCalMethod());
        prpCitemKindDto.setForestUse(prpCPitemKindDto.getForestUse());
        return prpCitemKindDto;
    }

    /**
     * @description: （理赔打印查询itemCode）
     * @author: 王志文
     * @date: 2017/11/11 9:19
     * @param policyNo
     * @return
     */
    @Override
    public List<PrpDcodeDto> queryItemCodeList(String policyNo) {
        System.out.println(policyNo);
        List<PrpCitemKind> prpCitemKindList = prpCitemKindDao.queryItemCodeByPolicyNo(policyNo);
        PrpCitemKindDto prpCitemKindDto = null;
        List<PrpCitemKindDto> prpCitemKindDtoList = new ArrayList<PrpCitemKindDto>();
        List<PrpDcodeDto> list = new ArrayList<>();
        for (PrpCitemKind prpc: prpCitemKindList) {
            prpCitemKindDto = this.convert(prpc,PrpCitemKindDto.class);
            prpCitemKindDtoList.add(prpCitemKindDto);
            PrpDcodeDto prpDcodeDto=new PrpDcodeDto();
            prpDcodeDto.setCodeCode(prpCitemKindDto.getItemCode());
            prpDcodeDto.setCodeCName(prpCitemKindDto.getItemDetailName());
            list.add(prpDcodeDto);
        }
        return list;
    }

    /**
     * @description: （理赔打印查询itemCode）
     * @author: 王志文
     * @date: 2017/11/11 9:19
     * @param policyNo
     * @return
     */
    @Override
    public List<PrpCitemKindDto> queryItemCodeByPolicyNo(String policyNo) {
        System.out.println(policyNo);
        List<PrpCitemKind> prpCitemKindList = prpCitemKindDao.queryItemCodeByPolicyNo(policyNo);
        PrpCitemKindDto prpCitemKindDto = null;
        List<PrpCitemKindDto> prpCitemKindDtoList = new ArrayList<PrpCitemKindDto>();
        for (PrpCitemKind prpc: prpCitemKindList) {
            prpCitemKindDto = this.convert(prpc,PrpCitemKindDto.class);
            prpCitemKindDtoList.add(prpCitemKindDto);
        }
        return prpCitemKindDtoList;
    }


    /**
     * 根据PolicyNo保单号和FamilyNo分户序号查询PrpCitemKindDto险别信息的集合
     * @author: 宋振振
     * @date: 2017/12/15 14:30
     * @param policyNo 保单号
     * @param familyNo 分户序号
     * @return List<PrpCitemKindDto> 险别信息的集合
     * @throws Exception
     */
    @Override
    public List<PrpCitemKindDto> queryPrpCitemKindByPolicyNoAndFamilyNo(String policyNo,String familyNo)throws Exception{
        if(com.sinosoft.framework.core.utils.StringUtils.isEmpty(policyNo)){
            throw new DataVerifyException("保单号不能为空!");
        }
        if(com.sinosoft.framework.core.utils.StringUtils.isEmpty(familyNo)){
            throw new DataVerifyException("分户序号不能为空!");
        }
        int familyNo1=Integer.parseInt(familyNo);
        List<PrpCitemKindDto> prpCitemKindDtoList=new ArrayList<>();
        List<PrpCitemKind> prpCitemKindList=prpCitemKindDao.queryPrpCitemKindByPolicyNoAndFamilyNo(policyNo,familyNo1);
        convertCollection(prpCitemKindList,prpCitemKindDtoList,PrpCitemKindDto.class);
        return prpCitemKindDtoList;
    }

    /**
     * （赔款金额计算通过保单号和险别查询损失率）
     * @author: 王志文
     * @date: 2018/1/8 10:49
     * @param policyNo 保单号
     * @param kindCode 险别代码
     * @return List<PrpCitemKind> 险别信息集合
     */
    @Override
    public List<PrpCitemKindDto> queryAllByPolicyNoAndKindCode(String policyNo, String kindCode,String itemCode) throws Exception {
        if (StringUtils.isEmpty(policyNo)) {
            throw new BusinessException("保单号不能为空");
        }
        if (StringUtils.isEmpty(kindCode)) {
            throw new BusinessException("险别代码不能为空");
        }
        if (StringUtils.isEmpty(itemCode)) {
            throw new BusinessException("标的代码不能为空");
        }
        List<PrpCitemKind> prpCitemKindList = prpCitemKindDao.queryAllByPolicyNoAndKindCode(policyNo, kindCode,itemCode);
        List<PrpCitemKindDto> prpCitemKindDtoList = new ArrayList<>();
        convertCollection(prpCitemKindList, prpCitemKindDtoList, PrpCitemKindDto.class);
        return prpCitemKindDtoList;
    }

    /**
     * 批量查询险别标的信息
     *
     * @param policyNos 保单号集合
     * @return List<PrpCitemKindDto>
     * @date: 2018/4/12 11:42
     * @author: 何伟东
     */
    @Override
    public List<PrpCitemKindDto> queryItemKindByPolicyNos(List<String> policyNos) throws Exception {
        if (policyNos == null || policyNos.size() < 1) {
            throw new DataVerifyException("保单号不能为空！");
        }
        List<PrpCitemKind> prpCitemKinds = prpCitemKindDao.queryItemKindByPolicyNos(policyNos);
        List<PrpCitemKindDto> prpCitemKindDtos = new ArrayList<>();
        convertCollection(prpCitemKinds, prpCitemKindDtos, PrpCitemKindDto.class);
        return prpCitemKindDtos;
    }

    /**
     * 根据保单号、险别、标的查询信息
     *
     * @param policyNo 保单号
     * @param kindCode 险别
     * @param itemCode 标的
     * @return PrpCitemKindDto信息集合
     * @throws Exception
     * @author: 田健
     * @date: 2018/4/13 12:22
     */
    @Override
    public ClaimQueryDeductiblerateDto queryAllByPolicyNoAndKindCodeAndItemCode(String policyNo, String kindCode, String itemCode) throws Exception {
        if (StringUtils.isEmpty(policyNo)) {
            throw new BusinessException("保单号不能为空");
        }
        if (StringUtils.isEmpty(kindCode)) {
            throw new BusinessException("险别代码不能为空");
        }
        if (StringUtils.isEmpty(itemCode)) {
            throw new BusinessException("标的代码不能为空");
        }
        List<PrpCitemKind> prpCitemKindList = prpCitemKindDao.queryAllByPolicyNoAndKindCodeAndItemCode(policyNo, kindCode, itemCode);
        List<PrpCitemKindDto> prpCitemKindDtoList = new ArrayList<>();
        convertCollection(prpCitemKindList, prpCitemKindDtoList, PrpCitemKindDto.class);
        ClaimQueryDeductiblerateDto claimQueryDeductiblerateDto =null;
        for(PrpCitemKindDto prpCitemKindDto:prpCitemKindDtoList){
             claimQueryDeductiblerateDto =this.convert(prpCitemKindDto,ClaimQueryDeductiblerateDto.class);
        }
        return claimQueryDeductiblerateDto;
    }
        }