package com.sinosoft.pms.web.kernel;

import com.sinosoft.pms.api.kernel.ClauseApi;
import com.sinosoft.pms.api.kernel.dto.ClauseQueryConditionDto;
import com.sinosoft.pms.api.kernel.dto.PrpDClauseDto;
import com.sinosoft.pms.core.kernel.service.ClauseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gaofeng on 2017/7/28.
 */
@RestController
@RequestMapping(ClauseApi.PATH)
public class ClauseController implements ClauseApi {
    @Autowired
    private ClauseService clauseService;

    @Override
    public PrpDClauseDto getClause(ClauseQueryConditionDto conditionDto) {
        return clauseService.getClause(conditionDto);
    }
}
