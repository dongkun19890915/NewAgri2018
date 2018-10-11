package com.sinosoft.agriprpall.api.policymanage;


import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.client.dto.RequestUpdatePassWordDto;
import com.sinosoft.agriprpall.api.client.dto.ResponseUpdatePassWordDto;
import com.sinosoft.agriprpall.api.policymanage.dto.*;
import com.sinosoft.framework.dto.PageInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-22 07:54:48.524
 *  保单标的子险信息表Api接口
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = PolicyQueryApi.PATH)
public interface PolicyQueryApi {
    public static final String PATH = "policyQuery";
    /**
     *  查询保单列表
     * @author: 王心洋
     * @date: 2017/10/27 17:39
     * @param requestDto 保单查询条件页面传入参数DTO
     * @return ResponseDto 列表展示详细信息
     */
    @RequestMapping(value = "queryPolicyListByConditon",method = {RequestMethod.POST})
    public @ResponseBody
    PageInfo<ResponseQueryPolicyListInfoDto> queryPolicyListByConditon(@RequestBody RequestQueryPolicyListInfoDto requestDto) throws Exception;

    /**
     *  查询保单详细信息
     * @author: 王心洋
     * @date: 2017/10/27 17:49
     * @param map policyNo 保单号 languageFlag 中英文标识LanguageFlagConstant中获取判断
     * @return ResponseDto
     */
    @RequestMapping(value = "queryPolicyInfoByPolicyNo",method = {RequestMethod.POST})
    public @ResponseBody
    ResponseQueryPolicyInfoDto queryPolicyInfoByPolicyNo(@RequestBody Map<String,String> map) throws Exception;

    /**
     * 根据起始保单号，结束保单号查询区间内的保单号
     * @author: 刘曼曼
     * @date: 2017/11/22 17:02
     * @param map startPolicyNo 起始保单号
     * @param map endPolicyNo  结束保单号
     * @return  List<String> 保单号集合
     */
    @RequestMapping(value = "queryPolicyNoList",method = {RequestMethod.POST})
    public @ResponseBody
    List<String> queryPolicyNoList(@RequestBody Map<String,String > map) throws Exception;

    /**
     * @param requestPolicyQueryDto 封装查询条件数据以及查询方式、页码信息请求参数
     * @return pageInfo 分页查询结果
     * @throws Exception 数据校验异常、数据库异常
     * @description: 类功能简述：根据查询入参的条件以及查询方式分页查询保单列表信息
     * 实现逻辑概述：1.校验关键入参是否为空，校验页码是否页码信息
     * 2.根据入参拼接查询条件
     * 3.用封装的查询条件查询总记录数
     * 4.总记录数>0时，查询投保单列表信息
     * 5.遍历查询结果将投保单列表信息封装到PageInfo返回给前端
     * @author: 潘峰
     * @date: 2017/10/18 19:01
     */
    @RequestMapping(value = "queryPolicyListPrintByConditon", method = RequestMethod.POST)
    PageInfo<ResponsePolicyQueryDto> queryPolicyListPrintByConditon(@RequestBody RequestPolicyQueryDto requestPolicyQueryDto) throws Exception;


    /**
     * @param policyNo 保单号
     * @return ResponseDto
     * @throws Exception 数据校验异常、数据库异常
     * @description: 类功能简述：根据保单号来查特别约定打印
     * @author: 潘峰
     */
    @RequestMapping(value = "specificallyAgreedPrint", method = RequestMethod.GET)
    public ResponseSpecificallyAgreedPrintDto specificallyAgreedPrint(@RequestParam("policyNo") String policyNo) throws Exception;


    /**
     * @param policyNo 保单号
     * @return ResponseDto
     * @throws Exception 数据校验异常、数据库异常
     * @description: 类功能简述：根据保单号打印承包卷宗封面
     * @author: 潘峰
     */
    @RequestMapping(value = "fileCoverPrint", method = RequestMethod.GET)
    public ResponseFileCoverPrintDto fileCoverPrint(@RequestParam("policyNo") String policyNo) throws Exception;


    /**
     * @param policyNo 保单号
     * @return ResponseDto
     * @throws Exception 数据校验异常、数据库异常
     * @description: 类功能简述：根据保单号来查缴费计划打印
     * @author: 潘峰
     */
    @RequestMapping(value = "paymentPlanPrint", method = RequestMethod.GET)
    public List<ResponsePaymentPlanPrintDto> paymentPlanPrint(@RequestParam("policyNo") String policyNo) throws Exception;


    /**
     * @param policyNo
     * @return
     * @throws Exception
     * @description:保单打印
     * @author: 潘峰
     * @date: 2017/10/19 14:07
     */
    @RequestMapping(value = "queryPolicyPrintByCondition", method = RequestMethod.POST)
    public ResponsePolicyPrintDto queryPolicyPrintByCondition(@RequestParam(value = "policyNo") String policyNo) throws Exception;

    /**
     * @param policyNo
     * @param printNo
     * @return
     * @throws Exception
     * @description:打印
     * 流水号回写
     * @author: 潘峰
     * @date: 2017/10/23 8:37
     */
    @RequestMapping(value = "upDatePrintNo", method = RequestMethod.POST)
    public String updatePrintNo(@RequestParam(value = "policyNo") String policyNo, @RequestParam(value = "printNo") String printNo) throws Exception;

    @RequestMapping(value = "query",method = RequestMethod.POST)
    public ResponseQueryPolicyInfoDto query(@RequestParam(value = "policyNo")String policyNo) throws Exception;


    /**
     * 用户密码修改
     *
     * @param requestUpdatePassWordDto
     * @return
     * @throws Exception
     * @author: 潘峰
     * @date: 22/03/2018 2:48 PM
     */
    @RequestMapping(value = "changePassword", method = RequestMethod.POST)
    ResponseUpdatePassWordDto changePassword(@RequestBody RequestUpdatePassWordDto requestUpdatePassWordDto) throws Exception;


}
