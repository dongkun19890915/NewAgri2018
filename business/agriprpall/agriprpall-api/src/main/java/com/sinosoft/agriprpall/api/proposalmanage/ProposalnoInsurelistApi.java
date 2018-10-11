package com.sinosoft.agriprpall.api.proposalmanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
* @Description: 投保单号与清单关联Core接口
* @Author: 钱浩
* @Date: 9:00 2017/10/17
*/
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = ProposalnoInsurelistApi.PATH)
public interface ProposalnoInsurelistApi {

   public static final String PATH = "proposalnoinsurelist";

    /**
     * 投保单号与预投保清单关联
     * @author: 钱浩
     * @date: 2017/11/4 10:06
     * @param proposalNo 投保单号
     * @param inusreListCode 预投保清单号
     */
    @RequestMapping(value = "relatedInsuranceNo",method = {RequestMethod.POST})
    public void relatedInsuranceNo(@RequestParam("proposalNo") String proposalNo, @RequestParam("inusreListCode") String inusreListCode)throws Exception;

}