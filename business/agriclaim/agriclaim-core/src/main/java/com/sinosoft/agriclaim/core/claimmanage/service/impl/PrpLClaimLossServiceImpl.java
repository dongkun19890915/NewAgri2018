package com.sinosoft.agriclaim.core.claimmanage.service.impl;

import com.sinosoft.agriclaim.api.claimmanage.dto.ClaimDto1;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimDto;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLClaimLossDto;
import com.sinosoft.agriclaim.core.claimmanage.dao.PrpLClaimDao;
import com.sinosoft.agriclaim.core.claimmanage.dao.PrpLClaimLossDao;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLClaimKey;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLClaimLoss;
import com.sinosoft.agriclaim.core.claimmanage.entity.PrpLClaimLossKey;
import com.sinosoft.agriclaim.core.claimmanage.service.ClaimService;
import com.sinosoft.agriclaim.core.claimmanage.service.PrpLClaimLossService;
import com.sinosoft.agriprpall.api.policymanage.PrpCmainApi;
import com.sinosoft.agriprpall.api.policymanage.PrpCvirturlItemApi;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCvirturlItemDto;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.pms.api.kernel.PrpDitemAgriApi;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:39:53.061 
 * @description 立案险别估损金额表Core接口实现
 */
@Service
public class PrpLClaimLossServiceImpl extends BaseServiceImpl implements PrpLClaimLossService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpLClaimLossServiceImpl.class);
    
    @Autowired
    private PrpLClaimLossDao prpLClaimLossDao;
    @Autowired
    private PrpCmainApi prpCmainApi;
    @Autowired
    private ClaimService claimService;
    @Autowired
    private PrpLClaimDao prpLClaimDao;
    @Autowired
    private PrpCvirturlItemApi prpCvirturlItemApi;
    @Autowired
    private PrpDitemAgriApi prpDitemAgriApi;
    /**
     *@description 新增
     *@param
     */
    public void save(PrpLClaimLossDto prpLClaimLossDto) {
        PrpLClaimLoss prpLClaimLoss = this.convert(prpLClaimLossDto, PrpLClaimLoss.class);
        prpLClaimLossDao.save(prpLClaimLoss);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String claimNo,java.lang.Integer serialNo) {
        PrpLClaimLossKey prpLClaimLossKey = new PrpLClaimLossKey(claimNo,serialNo);
        prpLClaimLossDao.delete(prpLClaimLossKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(PrpLClaimLossDto prpLClaimLossDto) {
        PrpLClaimLoss prpLClaimLoss = this.convert(prpLClaimLossDto, PrpLClaimLoss.class);
        prpLClaimLossDao.save(prpLClaimLoss);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLClaimLossDto queryByPK(String claimNo,java.lang.Integer serialNo) {
        PrpLClaimLossKey prpLClaimLossKey = new PrpLClaimLossKey(claimNo,serialNo);
        PrpLClaimLoss prpLClaimLoss = prpLClaimLossDao.findOne(prpLClaimLossKey);
        return this.convert(prpLClaimLoss,PrpLClaimLossDto.class);
    }

    /**
     *  根据立案号查询PrpLClaimLoss表信息
     * @author: 汪钊
     * @date: 2017/11/20 15:50
     * @return prpLClaimLossDtoList 返回PrpLClaimLossDto的集合
     */
    @Override
    public List<PrpLClaimLossDto> queryByClaimNo(String claimNo) {
        if (StringUtils.isEmpty(claimNo)) {
            throw new DataVerifyException("立案号不能为空");
        }
        List<PrpLClaimLoss> prpLClaimLossList = prpLClaimLossDao.findByClaimNo(claimNo);
        List<PrpLClaimLossDto> prpLClaimLossDtoList = new ArrayList<PrpLClaimLossDto>();
        this.convertCollection(prpLClaimLossList, prpLClaimLossDtoList, PrpLClaimLossDto.class);
        return prpLClaimLossDtoList;
    }

    @Override
    public String saveCLaimLoss(ClaimDto1 claimDto)throws Exception {
        List<PrpLClaimLossDto> prpLclaimLossDtoList = claimDto.getPrpLclaimLossDtoList();
        String riskCode = claimDto.getPrpLClaimDto().getRiskCode();
        for(int i=0;i<prpLclaimLossDtoList.size();i++){
            Map map = new HashMap();
            map.put("itemCName",prpLclaimLossDtoList.get(i).getItemDetailName());
            List itemCode = prpDitemAgriApi.queryItemCode(map);
            prpLclaimLossDtoList.get(i).setItemCode(itemCode.get(0).toString());
            if(prpLclaimLossDtoList.get(i).getKindLoss()==null || prpLclaimLossDtoList.get(i).getKindRest()==null ||prpLclaimLossDtoList.get(i).getDeductibleRate()==null || prpLclaimLossDtoList.get(i).getDeductible()==null ||prpLclaimLossDtoList.get(i).getAcciDeductibleRate()==null ||prpLclaimLossDtoList.get(i).getFamilyNo()==null){
                prpLclaimLossDtoList.get(i).setKindLoss(0.00);
                prpLclaimLossDtoList.get(i).setKindRest(0.00);
                prpLclaimLossDtoList.get(i).setDeductibleRate(0.0000);
                prpLclaimLossDtoList.get(i).setDeductible(0.00);
                prpLclaimLossDtoList.get(i).setAcciDeductibleRate(0.0000);
                prpLclaimLossDtoList.get(i).setFamilyNo(0);
            }
            prpLclaimLossDtoList.get(i).setSerialNo(i+1);
            prpLclaimLossDtoList.get(i).setRiskCode(riskCode);

        }
        List<PrpLClaimLoss> prpLClaimLossList = new ArrayList<>();
        convertCollection(prpLclaimLossDtoList,prpLClaimLossList,PrpLClaimLoss.class);
        Map<String,String> map = new HashMap<>();
        map.put("policyNo",claimDto.getPrpLClaimDto().getPolicyNo());
        map.put("riskCode",riskCode);
        map.put("flag","2");
        for (PrpLClaimLoss prpLClaimLoss :prpLClaimLossList ){
            List<PrpCvirturlItemDto> prpCvirturlItemDtoList = prpCvirturlItemApi.queryVirturlItemByPolicyNo(map);
            if (prpCvirturlItemDtoList.size()>0 ){
                prpLClaimLoss.setItemKindNo(prpCvirturlItemDtoList.get(0).getItemKindNo());
            }
            if (StringUtils.isEmpty(prpLClaimLoss.getClaimNo())){
                prpLClaimLoss.setClaimNo(claimDto.getClaimNo());
            }
        }
        List<PrpLClaimLoss> prpLClaimLosses = prpLClaimLossDao.save(prpLClaimLossList);
        String i="";
        //生成危险单位
        Map<String,String> dangerMap = new HashMap<>();
        dangerMap.put("policyNo",claimDto.getPrpLClaimDto().getPolicyNo());
        PrpCmainDto prpCmainDto = prpCmainApi.queryByPK(dangerMap);
        if (prpCmainDto!= null && "0".equals(prpCmainDto.getCoinsFlag())){
            claimService.getLDangerInfoNewL(claimDto.getClaimNo());
        }else {
            PrpLClaimKey prpLClaimKey = new PrpLClaimKey();
            prpLClaimKey.setClaimNo(claimDto.getClaimNo());
            PrpLClaimDto prpLClaimDto1 = this.convert(prpLClaimDao.findOne(prpLClaimKey),PrpLClaimDto.class);
            claimService.getLDangerInfo(prpLClaimDto1);
        }
       if(prpLClaimLosses!=null){
         i = "Success";
       }
        return i;
    }
}