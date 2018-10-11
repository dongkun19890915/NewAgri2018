package com.sinosoft.agriprpall.core.policymanage.service.impl;

import com.sinosoft.agriprpall.api.endorsemanage.dto.BLEndorseDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpCPitemKindAgriDto;
import com.sinosoft.agriprpall.api.endorsemanage.dto.PrpPitemKindAgriDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindAgriDto;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCitemKindAgriKey;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCitemKindAgriService;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCitemKindAgriDao;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCitemKindAgri;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PrpCitemKindAgriServiceImpl extends BaseServiceImpl implements PrpCitemKindAgriService {

    @Autowired
    private PrpCitemKindAgriDao prpCitemKindAgriDao;
    /**
     * 按照 policyNo 查询 PrpCitemKind 集合
     * @author 王心洋
     * @time 2017-11-09
     * @param policyNo 保单号
     * @param kindCode 险别
     * @return List<PrpCitemKind>
     */
    @Override
    public List<PrpCitemKindAgriDto> queryByConditions(String policyNo, String kindCode) throws Exception {
        List<PrpCitemKindAgri> prpCitemKindAgriList= prpCitemKindAgriDao.findByPolicyNoAndItemKindNoAndKindCode(policyNo,kindCode);
        List<PrpCitemKindAgriDto> prpCitemKindAgriDtoList =new ArrayList<>();
        convertCollection(prpCitemKindAgriList, prpCitemKindAgriDtoList,PrpCitemKindAgriDto.class);
        return prpCitemKindAgriDtoList;
    }

    /**
     * P表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpPitemKindAgriDto
     * @return PrpCitemKindAgriDto
     * @throws Exception
     */
    @Override
    public PrpCitemKindAgriDto PEvaluateC(PrpPitemKindAgriDto prpPitemKindAgriDto) throws Exception {
        PrpCitemKindAgriDto prpCitemKindAgriDto=new PrpCitemKindAgriDto();
        prpCitemKindAgriDto.setDepreciationRate(prpPitemKindAgriDto.getDepreciationRate());
        prpCitemKindAgriDto.setDiscountType(prpPitemKindAgriDto.getDiscountType());
        prpCitemKindAgriDto.setFlag(prpPitemKindAgriDto.getFlag());
        prpCitemKindAgriDto.setGrossQuantity(prpPitemKindAgriDto.getGrossQuantity());
        prpCitemKindAgriDto.setItemKindNo(prpPitemKindAgriDto.getItemKindNo());
        prpCitemKindAgriDto.setKindCode(prpPitemKindAgriDto.getKindCode());
        prpCitemKindAgriDto.setPolicyNo(prpPitemKindAgriDto.getPolicyNo());
        prpCitemKindAgriDto.setProportion(prpPitemKindAgriDto.getProportion());
        prpCitemKindAgriDto.setRemark(prpPitemKindAgriDto.getRemark());
        prpCitemKindAgriDto.setRiskCode(prpPitemKindAgriDto.getRiskCode());
        prpCitemKindAgriDto.setUnitAmount(prpPitemKindAgriDto.getUnitAmount());
        prpCitemKindAgriDto.setUnitCost(prpPitemKindAgriDto.getUnitCost());
        prpCitemKindAgriDto.setUnitOutput(prpPitemKindAgriDto.getUnitOutput());
        prpCitemKindAgriDto.setTimes(prpPitemKindAgriDto.getTimes());
        prpCitemKindAgriDto.setStratDate(prpPitemKindAgriDto.getStratDate());
        prpCitemKindAgriDto.setEndDate(prpPitemKindAgriDto.getEndDate());
        prpCitemKindAgriDto.setInsureArea(prpPitemKindAgriDto.getInsureArea());
        prpCitemKindAgriDto.setTimesAmount(prpPitemKindAgriDto.getTimesAmount());
        prpCitemKindAgriDto.setDistributingRate(prpPitemKindAgriDto.getDistributingRate());
        return prpCitemKindAgriDto;
    }

    /**
     * CP表记录转为C表记录
     * @author: 王保良
     * @date: 2017/11/18
     * @param prpCPitemKindAgriDto
     * @return PrpCitemKindAgriDto
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PrpCitemKindAgriDto generatePrpCitemKindAgri(PrpCPitemKindAgriDto prpCPitemKindAgriDto, BLEndorseDto blEndorseDto) throws Exception {
        Map<Integer ,String> map=new HashedMap();
        for(PrpPitemKindAgriDto prpPitemKindAgriDto:blEndorseDto.getPrpPitemKindAgriDtoList()){
            map.put(prpPitemKindAgriDto.getTimes(),prpPitemKindAgriDto.getFlag());
        }
        PrpCitemKindAgriDto prpCitemKindAgriDto=new PrpCitemKindAgriDto();
        prpCitemKindAgriDto.setDepreciationRate(prpCPitemKindAgriDto.getDepreciationRate());
        prpCitemKindAgriDto.setDiscountType(prpCPitemKindAgriDto.getDiscountType());
        prpCitemKindAgriDto.setGrossQuantity(prpCPitemKindAgriDto.getGrossQuantity());
        prpCitemKindAgriDto.setItemKindNo(prpCPitemKindAgriDto.getItemKindNo());
        prpCitemKindAgriDto.setKindCode(prpCPitemKindAgriDto.getKindCode());
        prpCitemKindAgriDto.setPolicyNo(prpCPitemKindAgriDto.getPolicyNo());
        prpCitemKindAgriDto.setProportion(prpCPitemKindAgriDto.getProportion());
        prpCitemKindAgriDto.setRiskCode(prpCPitemKindAgriDto.getRiskCode());
        prpCitemKindAgriDto.setUnitAmount(prpCPitemKindAgriDto.getUnitAmount());
        prpCitemKindAgriDto.setUnitCost(prpCPitemKindAgriDto.getUnitCost());
        prpCitemKindAgriDto.setUnitOutput(prpCPitemKindAgriDto.getUnitOutput());
        prpCitemKindAgriDto.setFlag(map.get(prpCPitemKindAgriDto.getTimes()));
        prpCitemKindAgriDto.setRemark(prpCPitemKindAgriDto.getRemark());
        prpCitemKindAgriDto.setTimes(prpCPitemKindAgriDto.getTimes());
        prpCitemKindAgriDto.setStratDate(prpCPitemKindAgriDto.getStratDate());
        prpCitemKindAgriDto.setEndDate(prpCPitemKindAgriDto.getEndDate());
        prpCitemKindAgriDto.setDistributingRate(prpCPitemKindAgriDto.getDistributingRate());
        prpCitemKindAgriDto.setTimesAmount(prpCPitemKindAgriDto.getTimesAmount());
        prpCitemKindAgriDto.setInsureArea(prpCPitemKindAgriDto.getInsureArea());
        return prpCitemKindAgriDto;
    }

    /**
     *  （按照 policyNo itemkindno kindcode 报案所在茬次时间 查询 PrpCitemKind 集合）
     * @author: 王志文
     * @date: 2018/3/14 17:45
     * @param policyNo
     * @param kindCode
     * @param times
     * @return
     * @throws Exception
     */
    @Override
    public PrpCitemKindAgriDto queryByPk(String policyNo, String kindCode, int times,int itemKindNo) throws Exception {
        PrpCitemKindAgriKey prpCitemKindAgriKey = new PrpCitemKindAgriKey();
        prpCitemKindAgriKey.setTimes(times);
        prpCitemKindAgriKey.setPolicyNo(policyNo);
        prpCitemKindAgriKey.setKindCode(kindCode);
        prpCitemKindAgriKey.setItemKindNo(itemKindNo);
        PrpCitemKindAgri prpCitemKindAgri = prpCitemKindAgriDao.findOne(prpCitemKindAgriKey);
        return this.convert(prpCitemKindAgri,PrpCitemKindAgriDto.class);
    }

    /**
     * （查询茬次信息）
     * @author: 王志文
     * @date: 2018/4/20 15:11
     * @param policyNo
     * @param kindCode
     * @param itemKindNo
     * @return
     * @throws Exception
     */
    @Override
    public List<PrpCitemKindAgriDto> queryListByPolicyNoAndKindCodeAndTimesDate(String policyNo, String kindCode, int itemKindNo) throws Exception {
        List<PrpCitemKindAgri> prpCitemKindAgriList =
                prpCitemKindAgriDao.findByPolicyNoAndKindCodeAndItemKindNo(policyNo,kindCode,itemKindNo);
        List<PrpCitemKindAgriDto> prpCitemKindAgriDtoList = new ArrayList<>();
        this.convertCollection(prpCitemKindAgriList,prpCitemKindAgriDtoList,PrpCitemKindAgriDto.class);
        return prpCitemKindAgriDtoList;
    }
    /**
     * 根据保单号、险种、险别、出险时间查询茬次信息
     * @author: 孙朋飞
     * @date: 2018/4/25 8:52
     * @param policyNo 保单号
     * @param riskCode 险种
     * @param kindCode 险别
     * @param damageStartDate 出险时间
     * @return 茬次
     */
    @Override
    public Map<String, Integer> queryPrpcItemKindAgriTimesByConditions(String policyNo, String riskCode, String kindCode, String damageStartDate) throws Exception {
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Integer times = prpCitemKindAgriDao.findPrpcItemKindAgriTimesByConditions(policyNo, riskCode, kindCode, dateFormat.parse(damageStartDate));
        Map<String,Integer> map=new HashMap<>();
        if(times==null){
            times=0;
        }
        map.put("times",times);
        return map;
    }
}
