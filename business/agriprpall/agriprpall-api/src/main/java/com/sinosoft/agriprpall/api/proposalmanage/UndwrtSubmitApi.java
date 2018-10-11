package com.sinosoft.agriprpall.api.proposalmanage;


import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.endorsemanage.dto.UndwrtEndorSubmitDto;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 04:00:52.059 
 * @description 工作流主表Api接口
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = UndwrtSubmitApi.PATH)
public interface UndwrtSubmitApi {

    public static final String PATH = "undwrtsubmit";
    /**
     * 提交核保接口
     * @author: 钱浩
     * @date: 2017/10/17 14:18
     * @param undwrtEndorSubmitDto 入参对象
     * @return ResponseDto 提交核保状态与工作流号
     * @throws Exception
     */
    @RequestMapping(value ="submitUndwrtByProposal",method =RequestMethod.POST)
    public @ResponseBody
    List submitUndwrtByProposal(@RequestBody UndwrtEndorSubmitDto undwrtEndorSubmitDto) throws Exception;
}