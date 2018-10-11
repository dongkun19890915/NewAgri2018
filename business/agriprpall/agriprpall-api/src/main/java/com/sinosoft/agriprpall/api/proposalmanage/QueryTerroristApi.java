package com.sinosoft.agriprpall.api.proposalmanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.client.dto.ResponseQueryTerroristInfoDto;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = QueryTerroristApi.PATH)
public interface QueryTerroristApi {

    public static final String PATH = "queryTerrorist";
    /**
     * 调用反洗钱系统服务查询所有恐怖分子
     * @author: 宋振振
     * @date: 2017/10/21 11:02
     * @param map
     * @return 返回恐怖分子信息列表
     * @throws Exception
     */
    @RequestMapping(value = "queryTerroristInfo",method = RequestMethod.POST)
    public @ResponseBody
    List<ResponseQueryTerroristInfoDto> queryTerroristInfo(@RequestBody Map<String, Integer> map) throws Exception;
}
