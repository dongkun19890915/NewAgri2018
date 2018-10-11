package com.sinosoft.agriprpall.web.proposalmanage;

import com.sinosoft.agriprpall.api.client.dto.ResponseQueryTraceInfoDto;
import com.sinosoft.agriprpall.api.proposalmanage.ViewTraceApi;
import com.sinosoft.agriprpall.core.proposalmanage.service.ViewTraceService;
import com.sinosoft.framework.dto.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-22 07:33:55.391 
 * @description PrpTrenewalcontroller层
 */
@RestController
@RequestMapping(value = ViewTraceController.PATH)
public class ViewTraceController implements ViewTraceApi {

    private static Logger LOGGER = LoggerFactory.getLogger(ViewTraceController.class);

    @Autowired
    private ViewTraceService viewTraceService;
    /**
     * @description: 核保信息查询
     * @author: 钱浩
     * @date: 2017/10/17 14:18
     * @param map： proposalNo 投保单号
     * @return ResponseDto： 审批意见集合
     * @throws Exception
     */
    public  List<ResponseQueryTraceInfoDto> getViewTrace(@RequestBody Map<String,String> map)throws Exception{
        String proposalNo=map.get("proposalNo");
        return viewTraceService.getViewTrace(proposalNo);
    }
}
