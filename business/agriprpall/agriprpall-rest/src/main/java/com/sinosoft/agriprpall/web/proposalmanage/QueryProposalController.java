package com.sinosoft.agriprpall.web.proposalmanage;

import com.sinosoft.agriprpall.api.proposalmanage.QueryProposalApi;
import com.sinosoft.agriprpall.api.proposalmanage.dto.RequestQueryProposalListInfoDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.ResponseQueryProposalInfoDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.ResponseQueryProposalListInfoDto;
import com.sinosoft.agriprpall.core.proposalmanage.service.QueryProposalService;
import com.sinosoft.framework.dto.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
* @Description: 投保单信息查询Controller层
* @Author: 何伟东
* @Date: 2017/10/15 11:14
*/
@RestController
@RequestMapping(value = QueryProposalController.PATH)
public class QueryProposalController implements QueryProposalApi {

    private static Logger LOGGER = LoggerFactory.getLogger(QueryProposalController.class);

    @Autowired
    private QueryProposalService queryProposalService;


    /**
     * @description: 方法功能简述：根据查询入参的条件以及查询方式分页查询投保单列表信息0000000000
     * @author: 何伟东
     * @date: 2017/10/15 11:15
     * @param requestDto 请求参数
     * @return
     * @throws Exception
     */
    @Override
    public @ResponseBody
    PageInfo<ResponseQueryProposalListInfoDto> queryProposalListInfoByConditon(@RequestBody RequestQueryProposalListInfoDto requestDto) throws Exception {
        return queryProposalService.queryProposalListInfoByConditon(requestDto);
    }

    /**
     * @description: 方法功能简述：根据投保单号码查询投保单详细信息
     * @author: 何伟东
     * @date: 2017/10/18 11:57
     * @param param proposalNo 投保单号
     * @return
     * @throws Exception
     */
    @Override
    public @ResponseBody
    ResponseQueryProposalInfoDto queryProposalInfoByProposalNoAndFamilyNos(@RequestBody Map<String,String> param) throws Exception {
        return queryProposalService.queryProposalInfoByProposalNoAndFamilyNos(param.get("proposalNo"),param.get("familyNos"));
    }
}
