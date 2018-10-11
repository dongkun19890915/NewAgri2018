package com.sinosoft.agriprpall.web.policymanage;

import com.sinosoft.agriprpall.api.policymanage.ProposalToPolicyApi;
import com.sinosoft.agriprpall.core.policymanage.service.ProposalToPolicyService;
import com.sinosoft.framework.dto.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-25 00:11:08.712 
 * @description 保单信息主表controller层
 */
@RestController
@RequestMapping(value = ProposalToPolicyController.PATH)
public class ProposalToPolicyController implements ProposalToPolicyApi {

    private static Logger LOGGER = LoggerFactory.getLogger(ProposalToPolicyController.class);

    @Autowired
    private ProposalToPolicyService proposalToPolicyService;
    /**
     * 转保单(通过投保单号查询投保单相关表,然后将投保单相关表的数据转储到保单相关表)
     * @author: 宋振振
     * @date: 2017/10/25 20:56
     * @param proposalNo 投保单号
     * @return policyNo 保单号
     * @throws Exception
     */
    public @ResponseBody String proposalToPolicy(@RequestParam(value = "proposalNo") String proposalNo,@RequestParam(value = "userCode") String userCode)throws Exception{
        return proposalToPolicyService.proposalToPolicy(proposalNo,userCode);
    }
}
