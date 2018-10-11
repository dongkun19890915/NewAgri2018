package com.sinosoft.agriprpall.web.proposalmanage;

import com.sinosoft.agriprpall.api.proposalmanage.ProposalnoInsurelistApi;
import com.sinosoft.agriprpall.core.proposalmanage.service.ProposalnoInsurelistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ProposalnoInsurelistController.PATH)
public class ProposalnoInsurelistController implements ProposalnoInsurelistApi {

    @Autowired
    private ProposalnoInsurelistService proposalnoInsurelistService;

    /**
     * 投保单号与预投保清单关联
     * @author: 钱浩
     * @date: 2017/11/4 10:06
     * @param proposalNo 投保单号
     * @param inusreListCode 预投保清单号
     */
    public void relatedInsuranceNo(String proposalNo,String inusreListCode)throws Exception{
        proposalnoInsurelistService.relatedInsuranceNo(proposalNo, inusreListCode);
    }

}
