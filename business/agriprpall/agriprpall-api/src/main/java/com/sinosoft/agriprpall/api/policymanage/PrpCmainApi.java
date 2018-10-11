package com.sinosoft.agriprpall.api.policymanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainRequestDto;
import com.sinosoft.agriprpall.api.policymanage.dto.RequestPrpCmainInfoDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponsePrpCmainInfoDto;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.pms.api.kernel.dto.ResponsePrpDclauseCodeDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * *PrpCmain表（保单基本信息表）Api接口
 * @Author: 田慧
 * @Date: 2017/11/20 14:53
 */

@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = PrpCmainApi.PATH)
public interface PrpCmainApi {
    public static final String PATH = "prpCmain";

    /**
     *  根据主键查询PrpCMain保单基本信息表信息
     * @author: 田慧
     * @date: 2017/12/3 11:52
     * @param  map 包括policyNo保单号
     * @return
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrpCmainDto queryByPK(@RequestBody Map<String,String> map);

    /**
     * * （根据保单号查看是否已经打印）
     * @author: 田慧
     * @date: 20:02
     * @param prpCmainRequestDto 保单号集合
     * @return resultMap
     * @throws Exception
     */
    @RequestMapping(value = "queryPrintNo",method = {RequestMethod.POST})
     Map<String,String> queryPrintNo(@RequestBody PrpCmainRequestDto prpCmainRequestDto)throws Exception;
    /**
     *  分页查询PrpCMainDto（保单基本信息表Dto）结果集
     * @author: 田慧
     * @date: 2017/11/21 10:47
     * @param prpCmainRequestDto prpCMainDto包括保单号、投保人姓名、保单起期、保单止期、页码、每页记录数
    riskCodeList 险种集合
    policyNoList 保单号集合
     * @return  返回pageInfo  分页查询主表信息（包含保单主表信息集合（PrpCMainDto）
    、当前页数、总记录数）
     * @throws Exception
     */
    @RequestMapping(value = "queryPolicyListInfo",method = {RequestMethod.POST})
    public PageInfo<PrpCmainDto> queryPolicyListInfo(@RequestBody PrpCmainRequestDto prpCmainRequestDto) throws Exception;

    /**
     *  根据policyNo保单号、riskCode险种代码检查保单号是否存在
     * @author: 田慧
     * @date: 2017/12/1 14:38
     * @param policyNo 保单号
     * @param riskCode 险种代码
     * @return List<prpCmainDto></prpCmainDto> 保单基本信息表信息
     * @throws Exception
     */
//    @RequestMapping(value = "checkPolicyNo",method = {RequestMethod.POST})
//    public List<PrpCmainDto> checkPolicyNo(@RequestParam("policyNo") String policyNo,@RequestParam("riskCode") String riskCode)throws Exception;

    /**
     * 根据保单号检验是否存在
     *
     * @param map 包括保单号
     * @return Integer 条数
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/12/1 14:38
     */
    @RequestMapping(value = "queryPolicyNo", method = {RequestMethod.POST})
    public @ResponseBody
    Integer queryPolicyNo(@RequestBody Map<String, String> map) throws Exception;
    /**
     * 根据保单号回写PrpCmain表的理赔次数claimTimes字段
     * @author: 宋振振
     * @date: 2017/12/15 9:58
     * @param map policyNo保单号
     * @throws Exception
     */
    @RequestMapping(value = "modifyPrpCmainAddClaimTimes",method = {RequestMethod.POST})
    public void modifyPrpCmainAddClaimTimes(@RequestBody Map<String,String> map)throws Exception;
    /**
     * 批量查询保单信息
     *
     * @param map policyNos 多个保单号
     * @return List<PrpCmainDto>
     * @date: 2018/4/12 10:48
     * @author: 何伟东
     */
    @RequestMapping(value = "queryPolicyInfoByPolicyNos", method = {RequestMethod.POST})
    @ResponseBody
    List<PrpCmainDto> queryPolicyInfoByPolicyNos(@RequestBody Map<String, List<String>> map) throws Exception;

    /**
     * 关联清单查询重复性保单数据
     * @author: 刘曼曼
     * @date: 16:32 16:32
     * @param requestPrpCmainInfoDto 清单号，页码，条数
     * @return PageInfo<ResponsePrpDclauseCodeDto> 保单数据集合
     * @throws Exception
     */
    @RequestMapping(value = "queryPrpCmainInfo", method = {RequestMethod.POST})
    public @ResponseBody  PageInfo<ResponsePrpCmainInfoDto> queryPrpCmainInfo(@RequestBody RequestPrpCmainInfoDto requestPrpCmainInfoDto) throws Exception;

    /**
     * 关联清单查询当前投保单是否同时存在
     * @author: 汪强
     * @date: 16:32 16:32
     * @param requestPrpCmainInfoDto 清单号，页码，条数
     * @return PageInfo<ResponsePrpDclauseCodeDto> 保单数据集合
     * @throws Exception
     */
    @RequestMapping(value = "queryByPrpNoPrpCmainInfo", method = {RequestMethod.POST})
    @ResponseBody  PageInfo<ResponsePrpCmainInfoDto> queryByPrpNoPrpCmainInfo(@RequestBody RequestPrpCmainInfoDto requestPrpCmainInfoDto) throws Exception;

    /**
     * 关联清单查询当前投保单是否同时存在
     * @author: 汪强
     * @date: 16:32 16:32
     * @param requestPrpCmainInfoDto 清单号，页码，条数
     * @return PageInfo<ResponsePrpDclauseCodeDto> 保单数据集合
     * @throws Exception
     */
    @RequestMapping(value = "queryByPrpNoPrpCmainInfoList", method = {RequestMethod.POST})
    @ResponseBody  PageInfo<ResponsePrpCmainInfoDto> queryByPrpNoPrpCmainInfoList(@RequestBody RequestPrpCmainInfoDto requestPrpCmainInfoDto) throws Exception;

    /**
     * 理赔更新有效保额
     * @author: 刘曼曼
     * @date: 19:50 19:50
     * @param map policyNo 保单号chgSumAmount 变化量
     * @return Map 更新信息
     */
    @RequestMapping(value = "modifyBypolicy", method = {RequestMethod.POST})
    @ResponseBody Map<String,String> modifyBypolicy(@RequestBody Map<String,Object> map)throws Exception;
}
