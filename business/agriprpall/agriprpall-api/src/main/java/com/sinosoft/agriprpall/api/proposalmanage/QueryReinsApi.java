package com.sinosoft.agriprpall.api.proposalmanage;


import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.client.dto.ResponseQueryRepolicyNoInfoDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 单号详细信息查询
 * @author: 钱浩
 * @date: 2017/11/30 下午 14:39
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = QueryReinsApi.PATH)
public interface QueryReinsApi {

    public static final String PATH = "reins";

    /**
     *  根据分保保单号查询详细信息
     * @author: 钱浩
     * @date: 2017/11/30 下午 14:51
     * @param map: reinsNo 分保保单号
     * @return 分保保单Dto
     * @throws Exception
     */
    @RequestMapping(value="queryByReinNo",method = RequestMethod.POST)
    public @ResponseBody
    List<ResponseQueryRepolicyNoInfoDto> queryByReinNo(@RequestBody Map<String,String> map)throws Exception;


}