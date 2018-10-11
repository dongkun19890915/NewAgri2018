package com.sinosoft.agriprpall.api.policymanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = ProposalToPolicyApi.PATH)
public interface ProposalToPolicyApi {
    public static final String PATH = "proposaltopolicy";
    /**
     * 转保单(通过投保单号查询投保单相关表,然后将投保单相关表的数据转储到保单相关表)
     * @author: 宋振振
     * @date: 2017/10/25 20:56
     * @param proposalNo 投保单号
     * @param userCode 员工代码
     * @return policyNo 保单号
     * @throws Exception
     */
    @RequestMapping(value = "proposalToPolicy",method = RequestMethod.POST)
    public @ResponseBody String proposalToPolicy(@RequestParam(value = "proposalNo") String proposalNo,@RequestParam(value = "userCode")String userCode)throws Exception;

}
