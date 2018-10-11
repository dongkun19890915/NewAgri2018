package com.sinosoft.agriprpall.core.policymanage.service;


import com.sinosoft.agriprpall.api.client.dto.RequestUpdatePassWordDto;
import com.sinosoft.agriprpall.api.client.dto.ResponseUpdatePassWordDto;
import com.sinosoft.agriprpall.api.policymanage.dto.*;
import com.sinosoft.framework.dto.PageInfo;

import java.util.List;


/**
 *  保单信息查询Core层
 * @Author: 王心洋
 * @Date: 2017/10/26 16:16
 */
public interface PolicyQueryService {

    /**
     *  方法功能简述：根据查询入参的条件以及查询方式分页查询保单列表信息
     * @author: 王心洋
     * @date: 2017/10/26 16:18
     * @param requestDto
     * @return
     * @throws Exception
     */
    public PageInfo<ResponseQueryPolicyListInfoDto> queryPolicyListByConditon(RequestQueryPolicyListInfoDto requestDto) throws Exception ;

    /**
     *  方法功能简述：根据投保单号码查询保单详细信息
     * @author: 王心洋
     * @date: 2017/10/26 16:18
     * @param map policyNo 保单号
     * @param map languageFlag 语言标志
     * @param map loginComCode 登录机构
     * @param map userCode 人员代码
     * @return
     * @throws Exception
     */
    public ResponseQueryPolicyInfoDto queryPolicyInfoByPolicyNo(String policyNo,String languageFlag,String loginComCode,String userCode) throws Exception;

    /**
     * 根据起始保单号，结束保单号区间查询保单号
     * @author: 刘曼曼
     * @date: 2017/11/22 17:02
     * @param startPolicyNo 起始保单号
     * @param endPolicyNo  结束保单号
     * @return List<String> 保单号集合
     */
    public List<String> queryPolicyNoList(String startPolicyNo, String endPolicyNo) throws Exception;

    /**
     * 根据保单号获取保单
     * @author: 刘曼曼
     * @date: 2017/11/29 8:55
     * @param policyNo 保单号
     * @return ResponseQueryPolicyInfoDto保单大对象
     * @throws Exception
     */
    public ResponseQueryPolicyInfoDto queryPolicyInfoByPolicyNo(String policyNo) throws Exception;
    /**
     * 根据保单号，分户序号数组获取保单
     * @author: 刘曼曼
     * @date: 2017/11/29 9:00
     * @param policyNo 保单号
     * @param familyNos 分户序号数组
     * @return ResponseQueryPolicyInfoDto保单大对象
     * @throws Exception
     */
    public ResponseQueryPolicyInfoDto queryPolicyInfoByCondition(String policyNo, String[] familyNos) throws Exception;



    /**
     * @param requestDto 封装查询条件数据以及查询方式、页码信息请求参数
     * @return pageInfo 分页查询结果
     * @throws Exception 数据校验异常、数据库异常
     * @description: 类功能简述：根据查询入参的条件以及查询方式分页查询保单列表信息
     * 实现逻辑概述：1.校验关键入参是否为空，校验页码是否页码信息
     * 2.根据入参拼接查询条件
     * 3.用封装的查询条件查询总记录数
     * 4.总记录数>0时，查询投保单列表信息
     * 5.遍历查询结果将投保单列表信息封装到PageInfo返回给前端
     * @author: 潘峰
     * @date: 2017/10/15 11:01
     */
    public PageInfo<ResponsePolicyQueryDto> queryPolicylListInfoByConditon(RequestPolicyQueryDto requestDto) throws Exception;


    /**
     * @param policyNo 保单号
     * @return ResponseDto
     * @throws Exception 数据校验异常、数据库异常
     * @description: 类功能简述：根据保单号来查特别约定打印
     * @author: 潘峰
     */
    ResponseSpecificallyAgreedPrintDto specificallyAgreedPrint(String policyNo) throws Exception;

    /**
     * @param policyNo 保单号
     * @return ResponseDto
     * @throws Exception 数据校验异常、数据库异常
     * @description: 类功能简述：根据保单号来查缴费计划打印
     * @author: 潘峰
     */
    List<ResponsePaymentPlanPrintDto> paymentPlanPrint(String policyNo) throws Exception;

    /**
     * @param policyNo 保单号
     * @return ResponseDto
     * @throws Exception 数据校验异常、数据库异常
     * @description: 类功能简述：根据保单号来打印承保卷宗封面
     * @author: 潘峰
     */
    ResponseFileCoverPrintDto fileCoverPrint(String policyNo) throws Exception;


    /**
     * @param policyNo
     * @return
     * @throws Exception
     * @description:投保单打印
     * @author: 潘峰
     * @date: 2017/10/19 14:07
     */
    public ResponsePolicyPrintDto queryPolicyPrintByCondition(String policyNo) throws Exception;


    public String upDatePrintNo(String policyNo, String printNo) throws Exception;

    ResponseUpdatePassWordDto changePassword(RequestUpdatePassWordDto requestUpdatePassWordDto);
}
