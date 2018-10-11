package com.sinosoft.agriprpall.web.policymanage;

import com.sinosoft.agriprpall.api.client.dto.RequestUpdatePassWordDto;
import com.sinosoft.agriprpall.api.client.dto.ResponseUpdatePassWordDto;
import com.sinosoft.agriprpall.api.policymanage.PolicyQueryApi;
import com.sinosoft.agriprpall.api.policymanage.dto.*;
import com.sinosoft.agriprpall.core.policymanage.service.PolicyQueryService;
import com.sinosoft.framework.dto.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = PolicyQueryController.PATH)
public class PolicyQueryController implements PolicyQueryApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PolicyPrintController.class);

    @Autowired
    private PolicyQueryService policyQueryService;

    /**
     *  查询保单列表
     * @author: 王心洋
     * @date: 2017/10/27 18:00
     * @param requestDto
     * @return
     */
    @Override
    public @ResponseBody
    PageInfo<ResponseQueryPolicyListInfoDto> queryPolicyListByConditon(@RequestBody RequestQueryPolicyListInfoDto requestDto) throws Exception {
        return policyQueryService.queryPolicyListByConditon(requestDto);
    }

    /**
     *  查询保单详细信息
     * @author: 王心洋
     * @date: 2017/10/27 18:00
     * @param map policyNo 保单号
     * @param map languageFlag 语言标志
     * @param map loginComCode 登录机构
     * @param map userCode 人员代码
     * @return
     */
    @Override
    public
    ResponseQueryPolicyInfoDto queryPolicyInfoByPolicyNo(@RequestBody Map<String,String> map) throws Exception {
        String policyNo= map.get("policyNo");
        String languageFlag=map.get("languageFlag");
        String loginComCode = map.get("loginComCode");
        String userCode = map.get("userCode");
        return policyQueryService.queryPolicyInfoByPolicyNo(policyNo,languageFlag,loginComCode,userCode);
    }

    /**
     * 根据起始保单号，结束保单号查询区间内的保单号
     * @author: 刘曼曼
     * @date: 2017/11/22 17:02
     * @param map startPolicyNo 起始保单号 endPolicyNo  结束保单号
     * @return  List<String> 保单号集合
     */
    public @ResponseBody  List<String> queryPolicyNoList(@RequestBody Map<String,String> map) throws Exception{
        String startPolicyNo=map.get("startPolicyNo");
        String endPolicyNo=map.get("endPolicyNo");
        return policyQueryService.queryPolicyNoList(startPolicyNo,endPolicyNo);
    }

    /**
     * @param requestPolicyQueryDto
     * @return ResponseDto
     * @throws Exception 数据校验异常、数据库异常
     * @description: 类功能简述：查询保单列表信息
     * @author: 潘峰
     */
    @Override
    public PageInfo<ResponsePolicyQueryDto> queryPolicyListPrintByConditon(@RequestBody RequestPolicyQueryDto requestPolicyQueryDto) throws Exception {
        PageInfo<ResponsePolicyQueryDto> policyQueryDtoPageInfo = policyQueryService.queryPolicylListInfoByConditon(requestPolicyQueryDto);
        return policyQueryDtoPageInfo;
    }

    /**
     * @param policyNo 保单号
     * @return ResponseDto
     * @throws Exception 数据校验异常、数据库异常
     * @description: 类功能简述：特别约定打印
     * @author: 潘峰
     */
    @Override
    public ResponseSpecificallyAgreedPrintDto specificallyAgreedPrint(@RequestParam("policyNo") String policyNo) throws Exception {
        ResponseSpecificallyAgreedPrintDto responseSpecificallyAgreedPrintDto = policyQueryService.specificallyAgreedPrint(policyNo);
        return responseSpecificallyAgreedPrintDto;
    }

    /**
     * @param policyNo 保单号
     * @return ResponseDto
     * @throws Exception 数据校验异常、数据库异常
     * @description: 类功能简述：根据保单号打印承包卷宗封面
     * @author: 潘峰
     */
    @Override
    public ResponseFileCoverPrintDto fileCoverPrint(@RequestParam("policyNo") String policyNo) throws Exception {
        ResponseFileCoverPrintDto responseFileCoverPrintDtos = policyQueryService.fileCoverPrint(policyNo);
        return responseFileCoverPrintDtos;
    }

    /**
     * @param policyNo 保单号
     * @return ResponseDto
     * @throws Exception 数据校验异常、数据库异常
     * @description: 类功能简述：根据保单号来查缴费计划打印
     * @author: 潘峰
     */
    @Override
    public List<ResponsePaymentPlanPrintDto> paymentPlanPrint(@RequestParam("policyNo") String policyNo) throws Exception {
        List<ResponsePaymentPlanPrintDto> responsePaymentPlanPrintDtos = policyQueryService.paymentPlanPrint(policyNo);
        return responsePaymentPlanPrintDtos;
    }

    /**
     * @param policyNo
     * @return
     * @throws Exception
     * @description:保单打印
     * @author: 潘峰
     * @date: 2017/10/19 14:07
     */
    @Override
    public ResponsePolicyPrintDto queryPolicyPrintByCondition(@RequestParam(value = "policyNo") String policyNo) throws Exception {
        ResponsePolicyPrintDto responsePolicyPrintDto = policyQueryService.queryPolicyPrintByCondition(policyNo);
        return responsePolicyPrintDto;
    }

    /**
     * @param policyNo
     * @param printNo
     * @return
     * @throws Exception
     * @description:打印流水号回写
     * @author: 潘峰
     * @date: 2017/10/23 8:37
     */
    @Override
    public String updatePrintNo(@RequestParam(value = "policyNo") String policyNo, @RequestParam(value = "printNo") String printNo) throws Exception {
        String s = policyQueryService.upDatePrintNo(policyNo, printNo);
        return s;
    }

    @Override
    public ResponseQueryPolicyInfoDto query(String policyNo) throws Exception {
        return policyQueryService.queryPolicyInfoByPolicyNo(policyNo);
    }

    @Override
    public ResponseUpdatePassWordDto changePassword(@RequestBody RequestUpdatePassWordDto requestUpdatePassWordDto) throws Exception {
        return policyQueryService.changePassword(requestUpdatePassWordDto);
    }

}
