package com.sinosoft.agriprpall.web.policymanage;


import com.sinosoft.agriprpall.api.policymanage.PrpCmainApi;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainDto;
import com.sinosoft.agriprpall.api.policymanage.dto.PrpCmainRequestDto;
import com.sinosoft.agriprpall.api.policymanage.dto.RequestPrpCmainInfoDto;
import com.sinosoft.agriprpall.api.policymanage.dto.ResponsePrpCmainInfoDto;
import com.sinosoft.agriprpall.core.policymanage.service.PrpCmainService;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.pms.api.kernel.dto.ResponsePrpDclauseCodeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * *PrpCmain表（保单基本信息表）controller层
 * @Author: 田慧
 * @Date: 2017/11/20 14:58
 */

@RestController
@RequestMapping(value = PrpCmainController.PATH)
public class  PrpCmainController implements PrpCmainApi {
    private static Logger LOGGER = LoggerFactory.getLogger(PrpCplanController.class);
    @Autowired
    private PrpCmainService prpCmainService;
    /**
     *  根据主键查询PrpCMain保单基本信息表信息
     * @author: 田慧
     * @date: 2017/12/3 11:52
     * @param  map 包括policyNo保单号
     * @return
     */
    @Override
    public @ResponseBody PrpCmainDto queryByPK(@RequestBody Map<String,String> map) {
        String policyNo = map.get("policyNo");
        return prpCmainService.queryByPK(policyNo);

    }
    /**
     * * （根据保单号查看是否已经打印）
     * @author: 田慧
     * @date: 20:02
     * @param prpCmainRequestDto  保单号集合
     * @return resultMap
     * @throws Exception
     */
    @Override
    public Map<String,String> queryPrintNo(@RequestBody PrpCmainRequestDto prpCmainRequestDto)throws Exception{
        return prpCmainService.queryPrintNo(prpCmainRequestDto);
    }

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
    @Override
    public PageInfo<PrpCmainDto> queryPolicyListInfo(@RequestBody PrpCmainRequestDto prpCmainRequestDto) throws Exception{
        return prpCmainService.queryPolicyListInfo(prpCmainRequestDto);
    }
    /**
     *  根据policyNo保单号、riskCode险种代码检查保单号是否存在
     * @author: 田慧
     * @date: 2017/12/1 14:38
     * @param policyNo 保单号
     * @param riskCode 险种代码
     * @return List<prpCmainDto> 保单基本信息表信息
     * @throws Exception
     */
//    @Override
//    public List<PrpCmainDto> checkPolicyNo(@RequestParam("policyNo") String policyNo,@RequestParam("riskCode") String riskCode)throws Exception{
//        return prpCmainService.checkPolicyNo(policyNo,riskCode);
//    }

    /**
     * 根据保单号检验是否存在
     *
     * @param map 包括保单号
     * @return Integer 条数
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/12/1 14:38
     */
    public @ResponseBody
    Integer queryPolicyNo(@RequestBody Map<String, String> map) throws Exception {
        String policyNo = map.get("policyNo");
        return prpCmainService.queryPolicyNo(policyNo);
    }
    /**
     * 根据保单号回写PrpCmain表的理赔次数claimTimes字段
     * @author: 宋振振
     * @date: 2017/12/15 9:58
     * @param map policyNo保单号
     * @throws Exception
     */
    public void modifyPrpCmainAddClaimTimes(@RequestBody Map<String,String> map)throws Exception{
        String policyNo=map.get("policyNo");
        prpCmainService.modifyPrpCmainAddClaimTimes(policyNo);
    }
    /**
     * 批量查询保单信息
     *
     * @param map policyNos 多个保单号
     * @return List<PrpCmainDto>
     * @date: 2018/4/12 10:48
     * @author: 何伟东
     */
    @Override
    public @ResponseBody List<PrpCmainDto> queryPolicyInfoByPolicyNos(@RequestBody Map<String, List<String>> map) throws Exception {
        return prpCmainService.queryPolicyInfoByPolicyNos(map.get("policyNos"));
    }

    /**
     * 关联清单查询重复性保单数据
     * @author: 刘曼曼
     * @date: 16:32 16:32
     * @param requestPrpCmainInfoDto 清单号，页码，条数
     * @return PageInfo<ResponsePrpDclauseCodeDto> 保单数据集合
     * @throws Exception
     */
    @Override
    public @ResponseBody  PageInfo<ResponsePrpCmainInfoDto> queryPrpCmainInfo(@RequestBody RequestPrpCmainInfoDto requestPrpCmainInfoDto) throws Exception{
        return prpCmainService.queryPrpCmainInfo(requestPrpCmainInfoDto);
    }

    /**
     * 关联清单查询当前投保单是否同时存在
     * @author: 汪强
     * @date: 16:32 16:32
     * @param requestPrpCmainInfoDto 清单号，页码，条数
     * @return PageInfo<ResponsePrpDclauseCodeDto> 保单数据集合
     * @throws Exception
     */
    @Override
    public @ResponseBody  PageInfo<ResponsePrpCmainInfoDto> queryByPrpNoPrpCmainInfo(@RequestBody RequestPrpCmainInfoDto requestPrpCmainInfoDto) throws Exception{
        return prpCmainService.queryByPrpNoPrpCmainInfo(requestPrpCmainInfoDto);
    }


    /**
     * 关联清单查询当前投保单是否同时存在
     * @author: 汪强
     * @date: 16:32 16:32
     * @param requestPrpCmainInfoDto 清单号，页码，条数
     * @return PageInfo<ResponsePrpDclauseCodeDto> 保单数据集合
     * @throws Exception
     */
    @Override
    public @ResponseBody  PageInfo<ResponsePrpCmainInfoDto> queryByPrpNoPrpCmainInfoList(@RequestBody RequestPrpCmainInfoDto requestPrpCmainInfoDto) throws Exception{
        return prpCmainService.queryByPrpNoPrpCmainInfoList(requestPrpCmainInfoDto);
    }

    /**
     * 理赔更新有效保额
     * @author: 刘曼曼
     * @date: 19:50 19:50
     * @param map policyNo 保单号chgSumAmount 变化量
     * @return Map 更新信息
     */
    @Override
    public @ResponseBody Map<String,String> modifyBypolicy(@RequestBody Map<String,Object> map)throws Exception{
        String policyNo=(String) map.get("policyNo");
        Double chgSumAmount= (Double) map.get("chgSumAmount");
        return prpCmainService.modifyBypolicy(policyNo,chgSumAmount);
    }
}
