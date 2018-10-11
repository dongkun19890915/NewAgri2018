package com.sinosoft.agriprpall.api.proposalmanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.proposalmanage.dto.QueryRelationResponseDto;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = QueryRelationApi.PATH)
public interface QueryRelationApi {
    public static final String PATH = "QueryRelation";
    /**
     * 投保单关联查询(根据投保单号关联查询)
     * @author: 宋振振
     * @date: 2017/11/5 17:30
     * @param map
     * @return QueryRelationResponseDto 返回与投保单号相关联的单号的Dto
     * @throws Exception
     */
    @RequestMapping(value = "queryRelateByProposalNo",method = RequestMethod.POST)
    public @ResponseBody QueryRelationResponseDto queryRelateByProposalNo(@RequestBody Map<String,String> map)throws Exception;
    /**
     * 保单/批单关联查询(根据保单号关联查询)
     * @author: 宋振振
     * @date: 2017/11/10 9:55
     * @param map
     * @return 返回与保单号相关联的单号的Dto
     * @throws Exception
     */
    @RequestMapping(value = "queryRelateByBizNo",method = RequestMethod.POST)
    public @ResponseBody QueryRelationResponseDto queryRelateByBizNo(@RequestBody Map<String,String> map)throws Exception;
}
