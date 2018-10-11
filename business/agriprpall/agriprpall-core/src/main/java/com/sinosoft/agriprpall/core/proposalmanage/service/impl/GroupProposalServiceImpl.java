package com.sinosoft.agriprpall.core.proposalmanage.service.impl;

import com.sinosoft.agriprpall.api.proposalmanage.dto.ProposalSaveDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTitemKindDto;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCvirturlItemDao;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCvirturlItem;
import com.sinosoft.agriprpall.core.proposalmanage.service.GroupProposalService;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.DataUtils;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.ims.api.auth.UtiPlatConfigRuleApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *  提供虚拟分户服务
 * @Author: 何伟东
 * @Date: 2017/10/30 9:48
 */
@Service
public class GroupProposalServiceImpl extends BaseServiceImpl implements GroupProposalService{

    @Autowired
    private PrpCvirturlItemDao prpCvirturlItemDao;
    @Autowired
    private UtiPlatConfigRuleApi sysConfig;
    /**
     *  判断给定的险种是否是团单虚拟分户
     * @author: 何伟东
     * @date: 2017/10/30 9:56
     * @param riskCode
     * @return
     */
    public  boolean isGroupProposal(String riskCode) throws Exception {

        // 需要进行虚拟分户的险种
        String riskCodes = sysConfig.getProperty("CREATE_VIRTUALITEM_RISK");
        if(StringUtils.isNotEmpty(riskCodes) && riskCodes.indexOf(riskCode)>-1){
            return true;
        }else {
            return false;
        }
    }

    /**
     *  根据投保单大对象，虚拟出一个标的，虚拟的对象包括虚拟分户信息，以及虚拟分户的保险责任
     * @author: 何伟东
     * @date: 2017/10/30 10:03
     * @param proposalSaveDto
     */
    @Transactional(rollbackFor = Exception.class)
    public void createVirtualItem(ProposalSaveDto proposalSaveDto) throws BusinessException {
        String proposalNo = proposalSaveDto.getPrpTmainDto().getProposalNo();
        List<PrpTitemKindDto> prpTitemKindDtoList = proposalSaveDto.getPrpTitemKindDtoList();
        for (PrpTitemKindDto prpTitemKindDto : prpTitemKindDtoList) {
            PrpCvirturlItem prpCvirturlItem = new PrpCvirturlItem();
            if ("3121".equals(prpTitemKindDto.getRiskCode())) {
                prpTitemKindDto.setRationType(prpTitemKindDto.getCattleType());
            }
            DataUtils.copySimpleObject(prpCvirturlItem,prpTitemKindDto);
            // 是否虚拟分户
            prpCvirturlItem.setVirturlFlag("1");
            // 是否冲减保额
            prpCvirturlItem.setAmountFlag("0");
            PrpCvirturlItem prpCvirturlItem1 = prpCvirturlItemDao.saveAndFlush(prpCvirturlItem);
            if (prpCvirturlItem1 == null) {
                throw new BusinessException("投保单"+proposalNo+"生成虚拟分户信息失败！");
            }
        }
    }

}
