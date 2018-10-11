package com.sinosoft.agriprpall.api.proposalmanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.client.dto.ResponseQueryTraceInfoDto;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 12:54:07.447 
 * @description
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = ViewTraceApi.PATH)
public interface ViewTraceApi {

    public static final String PATH = "viewtrace";

    /**
     * @description: 核保信息查询
     * @author: 钱浩
     * @date: 2017/10/17 14:18
     * @param map: proposalNo 投保单号
     * @return ResponseDto： 审批意见集合
     * @throws Exception
     */
    @RequestMapping(value = "getViewTrace",method = RequestMethod.POST)
    public @ResponseBody
    List<ResponseQueryTraceInfoDto> getViewTrace(@RequestBody Map<String,String> map)throws Exception;
  }