package com.sinosoft.agriprpall.web.proposalmanage;

import com.sinosoft.agriprpall.api.proposalmanage.PrpTmainApi;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTmainDto;
import com.sinosoft.agriprpall.core.proposalmanage.service.PrpTmainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * *PrpTmain投保单基本信息表controller层
 *
 * @Author: 田慧
 * @Date: 2017/11/20 14:25
 */

@RestController
@RequestMapping(value = PrpTmainController.PATH)

public class PrpTmainController implements PrpTmainApi {
    private static Logger LOGGER = LoggerFactory.getLogger(PrpTitemKindAgriController.class);
    @Autowired
    private PrpTmainService prpTmainService;

    /**
     * 根据主键查询PrpTmain投保单基本信息表信息
     *
     * @param map 包括proposalNo 投保单号
     * @return PrpTmainDto
     * @author: 田慧
     * @date: 2017/12/3 11:58
     */
    @Override
    public PrpTmainDto queryByPK(@RequestBody Map<String, String> map) {
        String proposalNo = map.get("proposalNo");
        return prpTmainService.queryByPK(proposalNo);
    }

    /**
     * 根据policyNo保单号、riskCode险种代码检查保单号是否存在
     *
     * @param map 包括policyNo保单号、riskCode 险种代码
     * @return List<prpTmainDto> 投保单基本信息表信息
     * @throws Exception
     * @author: 田慧
     * @date: 2017/12/1 14:38
     */
    @Override
    public List<PrpTmainDto> checkPolicyNo(@RequestBody Map<String, String> map) throws Exception {
        String policyNo = map.get("policyNo");
        String riskCode = map.get("riskCode");
        return prpTmainService.checkPolicyNo(policyNo, riskCode);
    }

    /**
     * 根据投保单号检验是否存在
     *
     * @param map 包括保单号
     * @return Integer 条数
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/12/1 14:38
     */
    @Override
    public Integer queryProposalNo(@RequestBody Map<String, String> map) throws Exception {
        String proposalNo = map.get("proposalNo");
        return prpTmainService.queryProposalNo(proposalNo);
    }


    /**
     * 根据主键和核保标志为0查询PrpTmain投保单基本信息表信息
     *
     * @param map 包括proposalNo 投保单号
     * @return PrpTmainDto
     * @author: 潘峰
     * @date: 2017/12/3 11:58
     */
    @Override
    public PrpTmainDto queryByUnderwriteFlag(@RequestBody Map<String, String> map) {
        String proposalNo = map.get("proposalNo");
        String underwriteFlag = map.get("underwriteFlag");
        return prpTmainService.queryByUnderwriteFlag(proposalNo, underwriteFlag);
    }

    @Override
    public PrpTmainDto findByProposalNo(@RequestBody Map<String, String> map) throws Exception {
        String proposalNo = map.get("proposalNo");
        return prpTmainService.findByProposalNo(proposalNo);
    }

    /**
     * 批量查询未提交投保单信息
     *
     * @param param proposalNos - 投保单号码集合
     * @author: 何伟东
     * @date: 2018/4/17 15:52
     */
    @Override
    public @ResponseBody
    List<PrpTmainDto> queryInitialProposal(@RequestBody Map<String, List<String>> param) {
        return prpTmainService.queryInitialProposal(param.get("proposalNos"));
    }
}
