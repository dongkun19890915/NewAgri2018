package com.sinosoft.agriprpall.core.policymanage.service.impl;

import com.sinosoft.agriprpall.api.policymanage.dto.PrpCvirturlItemDto;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCinsuredDao;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCitemKindDao;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCvirturlItemDao;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCinsured;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCitemKind;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCitemKindKey;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCvirturlItem;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCvirturlItemService;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.ims.api.auth.UtiPlatConfigRuleApi;
import com.sinosoft.ims.api.auth.dto.UtiPlatConfigRuleDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PrpCvirturlItemServiceImpl extends BaseServiceImpl implements PrpCvirturlItemService{
    /** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(PrpCvirturlItemServiceImpl.class);

    @Autowired
    private PrpCvirturlItemDao prpCvirturlItemDao;
    @Autowired
    private UtiPlatConfigRuleApi utiPlatConfigRuleApi;
    @Autowired
    private PrpCitemKindDao prpCitemKindDao;
    @Autowired
    private PrpCinsuredDao prpCinsuredDao;
    /**
     * 根据PolicyNo保单号和FamilyNo分户序号查询PrpCvirturlItemDto虚拟信息集合
     * @author: 宋振振
     * @date: 2017/12/15 14:30
     * @param policyNo 保单号
     * @param familyNo 分户序号
     * @return List<PrpCvirturlItemDto> 虚拟信息集合
     * @throws Exception
     */
    public List<PrpCvirturlItemDto> queryPrpCvirturlItemDtoByPolicyNoAndFamilyNo(String policyNo, String familyNo)throws Exception{
        if(com.sinosoft.framework.core.utils.StringUtils.isEmpty(policyNo)){
            throw new DataVerifyException("保单号不能为空!");
        }
        if(com.sinosoft.framework.core.utils.StringUtils.isEmpty(familyNo)){
            throw new DataVerifyException("分户序号不能为空!");
        }
        int familyNo1=Integer.parseInt(familyNo);
        List<PrpCvirturlItemDto> prpCvirturlItemDtoList=new ArrayList<>();
        List<PrpCvirturlItem> prpCvirturlItemList=prpCvirturlItemDao.queryPrpCvirturlItemDtoByPolicyNoAndFamilyNo(policyNo,familyNo1);
        convertCollection(prpCvirturlItemList,prpCvirturlItemDtoList,PrpCvirturlItemDto.class);
        return prpCvirturlItemDtoList;
    }

    /**
     * 根据policyNo保单号查询PrpCvirturlItemDto虚拟信息集合
     * @author: 安齐崇
     * @date: 2018/1/24 15:01
     * @param map policyNo保单号
     * @return List<PrpCvirturlItemDto> 虚拟信息集合
     * @throws Exception
     */
    @Override
    public List<PrpCvirturlItemDto> queryVirturlItemByPolicyNo(String policyNo,String riskCode,String flag){
        UtiPlatConfigRuleDto configRuleDto = utiPlatConfigRuleApi.queryByPK("prpall", "CREATE_VIRTUALITEM_RISK", 1);
        String rules = configRuleDto == null ? "" : configRuleDto.getRule();
        List<PrpCvirturlItemDto> virturlItemDtoList = new ArrayList<>();
        if (StringUtils.isNotEmpty(rules)) {
            List<PrpCvirturlItem> virturlItemList = prpCvirturlItemDao
                    .findAll(Specifications.<PrpCvirturlItem> and().eq("policyNo", policyNo).build());
            this.convertCollection(virturlItemList, virturlItemDtoList, PrpCvirturlItemDto.class);
        } else {
            if ("1".equals(flag)) {
                List<PrpCinsured> prpCinsuredList = prpCinsuredDao
                        .findAll(Specifications.<PrpCinsured> and().eq("policyNo", policyNo).build());
                for (PrpCinsured prpCinsured : prpCinsuredList) {
                    PrpCvirturlItemDto itemDto = new PrpCvirturlItemDto();
                    itemDto.setFamilyName(prpCinsured.getInsuredName());
                    itemDto.setCustomerSequenceNo(prpCinsured.getInsuredCode());
                    virturlItemDtoList.add(itemDto);
                }
            } else if ("2".equals(flag)) {
                List<PrpCitemKind> prpCitemKind = prpCitemKindDao
                        .findAll(Specifications.<PrpCitemKind> and().eq("policyNo", policyNo).build());
                this.convertCollection(prpCitemKind, virturlItemDtoList, PrpCvirturlItemDto.class);
            }
        }
        if("1".equals(flag)){
            String familyName =virturlItemDtoList.size() <1 ?"":virturlItemDtoList.get(0).getFamilyName();
            if(StringUtils.isEmpty(familyName)){
                Set<String> set =new HashSet<>();
                virturlItemDtoList = new ArrayList<>();
                List<PrpCinsured> prpCinsuredList = prpCinsuredDao
                        .findAll(Specifications.<PrpCinsured> and().eq("policyNo", policyNo).build());
                for (PrpCinsured prpCinsured : prpCinsuredList) {
                    if(set.add(prpCinsured.getInsuredName())){
                        PrpCvirturlItemDto itemDto = new PrpCvirturlItemDto();
                        itemDto.setFamilyName(prpCinsured.getInsuredName());
                        itemDto.setCustomerSequenceNo(prpCinsured.getInsuredCode());
                        virturlItemDtoList.add(itemDto);
                    }
                }
            }
        }
        if("2".equals(flag)){
            String kindName =virturlItemDtoList.size() <1 ?"":virturlItemDtoList.get(0).getKindName();
            if(StringUtils.isEmpty(kindName)){
                List<PrpCitemKind> prpCitemKind = prpCitemKindDao
                        .findAll(Specifications.<PrpCitemKind> and().eq("policyNo", policyNo).build());
                this.convertCollection(prpCitemKind, virturlItemDtoList, PrpCvirturlItemDto.class);
            }
            for (PrpCvirturlItemDto prpCvirturlItemDto : virturlItemDtoList) {
                if(StringUtils.isEmpty(prpCvirturlItemDto.getItemdetailName())){
                    PrpCitemKind prpCitemKind = prpCitemKindDao.findOne(new PrpCitemKindKey(policyNo, prpCvirturlItemDto.getItemKindNo()));
                    if(prpCitemKind!=null){
                        prpCvirturlItemDto.setItemdetailName(prpCitemKind.getItemDetailName());
                    }
                }
            }
        }
        return virturlItemDtoList;
    }
}
