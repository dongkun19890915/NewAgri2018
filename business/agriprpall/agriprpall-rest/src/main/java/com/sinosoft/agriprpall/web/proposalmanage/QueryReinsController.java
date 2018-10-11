package com.sinosoft.agriprpall.web.proposalmanage;

import com.sinosoft.agriprpall.api.client.dto.ResponseQueryRepolicyNoInfoDto;
import com.sinosoft.agriprpall.api.proposalmanage.QueryReinsApi;
import com.sinosoft.agriprpall.core.proposalmanage.service.QueryReinsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 单号详细信息查询
 * @author: 钱浩
 * @date: 2017/11/30 下午 14:39
 */
@RestController
@RequestMapping(value = QueryReinsController.PATH)
public class QueryReinsController implements QueryReinsApi {

    private static Logger LOGGER = LoggerFactory.getLogger(QueryReinsController.class);

    @Autowired
    private QueryReinsService queryReinsService;
    /**
     *  根据分保保单号查询详细信息
     * @author: 钱浩
     * @date: 2017/11/30 下午 14:51
     * @param map :  reinsCode 接受人代码 shortName 接受人简称
     * @return 分保保单Dto
     * @throws Exception
     */
    @Override
    public List<ResponseQueryRepolicyNoInfoDto> queryByReinNo(@RequestBody Map<String,String> map) throws Exception {
        String reinsNo=map.get("reinsNo");
        return queryReinsService.queryByReinNo(reinsNo);
    }
}
