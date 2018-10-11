package com.sinosoft.agriprpall.api.proposalmanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = ProposalToPolicyApi.PATH)
public interface ProposalToPolicyApi {
    public static final String PATH = "proposaltopolicy";
    /**
     * @description: 转保单接口
     * @author: 宋振振
     * @date: 2017/10/25 20:56
     * @param proposalNo
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "proposalToPolicy",method = RequestMethod.POST)
    public @ResponseBody ResponseDto proposalToPolicy(@RequestParam(value = "proposalNo") String proposalNo)throws Exception;

}
