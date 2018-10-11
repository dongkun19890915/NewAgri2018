package com.sinosoft.agriprpall.api.proposalmanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.proposalmanage.dto.RequestQueryProposalListInfoDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.ResponseQueryProposalInfoDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.ResponseQueryProposalListInfoDto;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
* @Description: 投保单基本信息表Api接口
* @Author: 何伟东
* @Date: 2017/10/15 11:20
*/
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = QueryProposalApi.PATH)
public interface QueryProposalApi {

    public static final String PATH = "proposalmanage";

    /**
     * @description: 方法能简述：根据查询入参的条件以及查询方式分页查询投保单列表信息
     * @author: 何伟东
     * @date: 2017/10/15 11:20
     * @param requestDto
     * @return
     * @throws Exception
     */
    @PostMapping(value = "queryProposalListInfoByConditon")
    public @ResponseBody
    PageInfo<ResponseQueryProposalListInfoDto> queryProposalListInfoByConditon(@RequestBody RequestQueryProposalListInfoDto requestDto) throws Exception;

    /**
     * @description: 方法功能简述：根据投保单号码查询投保单详细信息
     * @author: 何伟东
     * @date: 2017/10/18 11:44
     * @param param proposalNo 投保单号
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "queryProposalInfoByProposalNoAndFamilyNos",method =RequestMethod.POST)
    public @ResponseBody ResponseQueryProposalInfoDto queryProposalInfoByProposalNoAndFamilyNos(@RequestBody Map<String,String> param) throws Exception;
}