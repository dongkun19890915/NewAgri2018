package com.sinosoft.agriprpall.web.proposalmanage;

import com.sinosoft.agriprpall.api.client.dto.ResponseQueryTerroristInfoDto;
import com.sinosoft.agriprpall.api.proposalmanage.QueryTerroristApi;
import com.sinosoft.agriprpall.core.proposalmanage.service.QueryTerroristService;
import com.sinosoft.framework.dto.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value =QueryTerroristController.PATH)
public class QueryTerroristController implements QueryTerroristApi{

    private static Logger LOGGER = LoggerFactory.getLogger(QueryTerroristController.class);

    @Autowired
    private QueryTerroristService queryTerroristService;
    /**
     * 调用反洗钱系统服务查询所有恐怖分子
     * @author: 宋振振
     * @date: 2017/10/21 11:02
     * @param map
     * @return 返回恐怖分子信息列表
     * @throws Exception
     */
    public @ResponseBody
    List<ResponseQueryTerroristInfoDto> queryTerroristInfo(@RequestBody Map<String, Integer> map) throws Exception{
        Integer pageNo=map.get("pageNo");
        Integer pageSize=map.get("pageSize");
        return queryTerroristService.queryTerroristInfo(pageNo,pageSize);
    }
}
