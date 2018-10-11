package com.sinosoft.agriprpall.web.policymanage;

import com.sinosoft.agriprpall.api.policymanage.ClaimQueryDeductiblerateApi;
import com.sinosoft.agriprpall.api.policymanage.dto.ClaimQueryDeductiblerateDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCitemKindDto;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCengageService;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCitemKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = ClaimQueryDeductiblerateController.PATH)
public class ClaimQueryDeductiblerateController implements ClaimQueryDeductiblerateApi{

    @Autowired
    private PrpCitemKindService prpCitemKindService;
    @Autowired
    private PrpCengageService prpCengageService;
    /**
     *  根据保单号、标的、险别查询免赔率
     * @author: 田健
     * @date: 2018/4/13 12:07
     * @param map 中的key为保单号、标的、险别
     * @return
     */
    @Override
    public @ResponseBody ClaimQueryDeductiblerateDto queryDeductiblerate(@RequestBody Map<String, String> map) throws Exception{
        String policyNo = map.get("policyNo");
        String kindCode = map.get("kindCode");
        String itemCode = map.get("itemCode");
        ClaimQueryDeductiblerateDto claimQueryDeductiblerateDto = prpCitemKindService.queryAllByPolicyNoAndKindCodeAndItemCode(policyNo,kindCode,itemCode);
        String eachDeductibleRate = prpCengageService.queryClausesByPolicyNo(policyNo,"TX001");
        claimQueryDeductiblerateDto.setEachDeductibleRate(eachDeductibleRate);
        return claimQueryDeductiblerateDto;
    }
}
