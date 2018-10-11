package com.sinosoft.agriprpall.core.proposalmanage.service;

import com.sinosoft.agriprpall.api.proposalmanage.dto.ProposalSaveDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTitemKindDto;
import com.sinosoft.agriprpall.core.policymanage.dao.PrpCvirturlItemDao;
import com.sinosoft.agriprpall.core.policymanage.entity.PrpCvirturlItem;
import com.sinosoft.framework.core.utils.DataUtils;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.ims.api.auth.UtiPlatConfigRuleApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *  提供虚拟分户服务
 * @Author: 何伟东
 * @Date: 2017/10/30 9:48
 */
public interface GroupProposalService {

    /**
     *  判断给定的险种是否是团单虚拟分户
     * @author: 何伟东
     * @date: 2017/10/30 9:56
     * @param riskCode
     * @return
     */
    public  boolean isGroupProposal(String riskCode) throws Exception;
    /**
     *  根据投保单大对象，虚拟出一个标的，虚拟的对象包括虚拟分户信息，以及虚拟分户的保险责任
     * @author: 何伟东
     * @date: 2017/10/30 10:03
     * @param proposalSaveDto
     */
    public void createVirtualItem(ProposalSaveDto proposalSaveDto) throws BusinessException ;

}
