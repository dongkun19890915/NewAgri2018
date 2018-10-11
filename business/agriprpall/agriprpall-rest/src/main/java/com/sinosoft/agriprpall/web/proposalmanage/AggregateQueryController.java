package com.sinosoft.agriprpall.web.proposalmanage;

import com.sinosoft.agriprpall.api.proposalmanage.AggregateQueryApi;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTmainDto;
import com.sinosoft.agriprpall.core.proposalmanage.service.AggregateQueryService;
import com.sinosoft.framework.dto.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *（汇总查询）
 * @Author: 陈道洋
 * @Date: 2017/11/9 10:37
 */
@RestController
@RequestMapping(value = AggregateQueryController.PATH)
public class AggregateQueryController implements AggregateQueryApi {

    private static Logger LOGGER = LoggerFactory.getLogger(AggregateQueryController.class);

    @Autowired
    private AggregateQueryService aggregateQueryService;
    /**
     * @description:根据条件进行汇总查询
     * @author: 陈道洋
     * @date: 2017/10/16 8:32
     * @param prptmainDto
     * @return
     * @throws Exception
     */
    @Override
    public @ResponseBody
    List<PrpTmainDto> queryPrpTmainByCondition(@RequestBody PrpTmainDto prptmainDto) throws Exception {
        return aggregateQueryService.queryPrpTmainByCondition(prptmainDto);

    }
}
