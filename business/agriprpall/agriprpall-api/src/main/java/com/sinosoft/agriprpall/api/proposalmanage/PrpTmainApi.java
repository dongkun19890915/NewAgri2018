package com.sinosoft.agriprpall.api.proposalmanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTmainDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * *PrpTmain投保单基本信息表Api接口
 * @Author: 田慧
 * @Date: 2017/11/20 14:25
 */

@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = PrpTmainApi.PATH)
public interface PrpTmainApi {
    public static final String PATH = "prpTmain";


    /**
     *  根据主键查询PrpTmain投保单基本信息表信息
     * @author: 田慧
     * @date: 2017/12/3 11:58
     * @param map 包括proposalNo 投保单号
     * @return PrpTmainDto
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpTmainDto queryByPK(@RequestBody Map<String,String> map);
    /**
     *  根据policyNo保单号、riskCode险种代码检查保单号是否存在
     * @author: 田慧
     * @date: 2017/12/1 14:38
     * @param map 包括policyNo保单号、riskCode 险种代码
     * @return List<prpTmainDto></prpTmainDto> 投保单基本信息表信息
     * @throws Exception
     */
    @RequestMapping(value = "checkPolicyNo",method = {RequestMethod.POST} )
    public List<PrpTmainDto> checkPolicyNo(@RequestBody Map<String,String> map)throws Exception;

    /**
     * 根据投保单号检验是否存在
     *
     * @param map 包括保单号
     * @return Integer 条数
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/12/1 14:38
     */
    @RequestMapping(value = "queryProposalNo", method = {RequestMethod.POST})
    public @ResponseBody
    Integer queryProposalNo(@RequestBody Map<String, String> map) throws Exception;


    /**
     * 根据主键和核保标志为0查询PrpTmain投保单基本信息表信息
     *
     * @param map 包括proposalNo 投保单号
     * @return PrpTmainDto
     * @author: 潘峰
     * @date: 2017/12/3 11:58
     */
    @RequestMapping(value = "queryByUnderwriteFlag", method = {RequestMethod.POST})
    @ResponseBody PrpTmainDto queryByUnderwriteFlag(@RequestBody Map<String, String> map);


    @RequestMapping(value = "findByProposalNo", method = {RequestMethod.POST})
    @ResponseBody PrpTmainDto findByProposalNo(@RequestBody Map<String, String> map) throws Exception;

    /**
     * 批量查询未提交投保单信息
     *
     * @param param proposalNos - 投保单号码集合
     * @author: 何伟东
     * @date: 2018/4/17 15:52
     */
    @RequestMapping(value = "queryInitialProposal", method = {RequestMethod.POST})
    @ResponseBody List<PrpTmainDto> queryInitialProposal(@RequestBody Map<String, List<String>> param);

}
