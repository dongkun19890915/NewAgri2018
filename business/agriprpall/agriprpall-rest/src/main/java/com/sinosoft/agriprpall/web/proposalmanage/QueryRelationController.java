package com.sinosoft.agriprpall.web.proposalmanage;

import com.sinosoft.agriprpall.api.proposalmanage.QueryRelationApi;
import com.sinosoft.agriprpall.api.proposalmanage.dto.QueryRelationResponseDto;
import com.sinosoft.agriprpall.core.proposalmanage.service.QueryRelationService;
import com.sinosoft.framework.dto.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = QueryRelationController.PATH)
public class QueryRelationController implements QueryRelationApi{

    private static Logger LOGGER = LoggerFactory.getLogger(QueryRelationController.class);
    @Autowired
    private QueryRelationService queryRelationService;
    /**
     * 投保单关联查询(根据投保单号关联查询)
     * @author: 宋振振
     * @date: 2017/11/5 17:30
     * @param map
     * @return QueryRelationResponseDto 返回与投保单号相关联的单号的Dto
     * @throws Exception
     */
    public QueryRelationResponseDto queryRelateByProposalNo(@RequestBody Map<String,String> map)throws Exception{
        String proposalNo=map.get("proposalNo");//投保单号
        return queryRelationService.queryRelateByProposalNo(proposalNo);
    }
    /**
     * 保单/批单关联查询(根据保单号关联查询)
     * @author: 宋振振
     * @date: 2017/11/10 9:55
     * @param map
     * @return 返回与保单号相关联的单号的Dto
     * @throws Exception
     */
    public QueryRelationResponseDto queryRelateByBizNo(@RequestBody Map<String,String> map)throws Exception{
        String bizNo="bizNo";//业务号，即保单号
        return queryRelationService.queryRelateByBizNo(bizNo);
    }

}
