package com.sinosoft.agriprpall.web.endorsemanage;

import com.sinosoft.agriprpall.api.endorsemanage.QueryCPApi;
import com.sinosoft.agriprpall.api.endorsemanage.dto.CPpolicyDto;
import com.sinosoft.agriprpall.core.endorsemanage.queryendorse.service.QueryCPservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(QueryCPApi.PATH)
public class QueryCPController implements QueryCPApi{
    @Autowired
    QueryCPservice queryCPservice;
    /**
    * cp表查询
    * @param policyNo 保单号
    * @return com.sinosoft.agriprpall.api.endorsemanage.dto.CPpolicyDto
    * @throws Exception
    * @author 李冬松
    * @date 14:26 2017/12/13
    */
    @Override
    public CPpolicyDto queryCPolicyInfo(String policyNo) throws Exception {
        return queryCPservice.queryCPolicyInfo(policyNo);
    }
}
