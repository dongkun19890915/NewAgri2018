package com.sinosoft.agriprpall.api.proposalmanage;


import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTmainDto;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
*（汇总查询）
* @Author: 陈道洋
* @Date: 2017/11/9 10:37
*/
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = AggregateQueryApi.PATH)
public interface AggregateQueryApi {

    public static final String PATH = "prpTmain";

    /**
     * @description:根据条件进行汇总查询
     * @author: 陈道洋
     * @date: 2017/10/13 18:51
     * @param prptmainDto
     * @return
     * @throws Exception
     */
    @RequestMapping(value="queryPrpTmainByCondition",method = RequestMethod.POST)
    public @ResponseBody
    List<PrpTmainDto> queryPrpTmainByCondition(@RequestBody PrpTmainDto prptmainDto)throws Exception;


}