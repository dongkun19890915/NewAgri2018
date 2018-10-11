package com.sinosoft.agriclaim.core.paymentmanage.service;


import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCompensateDto;
import com.sinosoft.agriclaim.api.paymentmanage.dto.*;
import com.sinosoft.agriclaim.api.recasemanage.dto.UndwrtWriteBackReCaseDto;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.NyxClaimPayListDto;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.RequestNyxPlantingClaimListDto;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:43:17.258 
 * @description 支付信息子表Core接口
 */
public interface PrplPayService {

    /**
     *@description 新增
     *@param
     */
    void save(PrplPayDto prplPayDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String serialNo,String serialNo2);
    /**
     *@description 修改
     *@param
     */
    void modify(PrplPayDto prplPayDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    PrplPayDto queryByPK(String serialNo,String serialNo2);
    /**
     * 支付清单的下载
     * @author: 孙朋飞
     * @date: 2017/12/27 16:09
     * @param listNo 清单号
     * @return 文件下载的链接
     * @throws Exception
     */
    public String expNyxClaimPayList(String listNo) throws Exception;
    /**
     * 由理赔清单封装支付清单并下载
     * @param requestNyxPlantingClaimListDto
     * @return 文件下载的链接
     * @throws Exception
     * @author 王心洋
     * @time 2018/4/12
     */
    public String expAssembleClaimPayList(RequestNyxPlantingClaimListDto requestNyxPlantingClaimListDto) throws Exception;
    /**
     * @description 按条件查询支付录入信息（带分页）
     * @param  prpJPlanFeePageMsgDto 查询入参
     * @return PrpJPlanFeePageMsgDto 查询结果
     * @throws Exception
     * @author 李磊
     * @date 2017-12-21 15:35
     */
    public PrpJPlanFeePageMsgDto queryPrpJPlanFeePageMsgDto(PrpJPlanFeePageMsgDto prpJPlanFeePageMsgDto)throws Exception;

    /**
     * @description 按条件查询支付录入信息（无分页）
     * @param  queryPrpJplanFeeDto 查询入参
     * @return List<PrpJplanFeeDto> 查询结果
     * @throws Exception
     * @author 李磊
     * @date 2017-12-21 15:35
     */
    public
    List<PrpJplanFeeDto> queryPrpJPlanFeeDto(QueryPrpJplanFeeDto queryPrpJplanFeeDto) throws Exception;

    /**
     * @description 按条件查询已经录入的支付信息
     * @param  prplPayDto 查询入参封装对象
     * @return PrplPayDto 查询结果返回对象
     * @throws Exception
     * @author 李磊
     * @date 2017-12-28 14:15
     */
    PageInfo<PrplPayDto> queryPrplPayDtoByCondition( PrplPayDto prplPayDto) throws Exception;
    /**
     *支付清单数据的导入保存
     * @author: 孙朋飞
     * @date: 2018/1/2 14:44
     * @param fileId 文件标识id
     * @param comCode 机构代码
     * @return 返回清单号和金额合计
     * @throws Exception
     */
    public Map<String,Object> importNyxClaimPayList(String fileId,String comCode) throws Exception;

    /**
     * （支付录入整单支付保存）
     * @author: 王志文
     * @date: 2017/12/26 15:02
     * @return 保存或提交结果
     * @throws Exception
     */
    Map<String,String> savePaysOut(PaySaveDto paySaveDto)throws Exception;
    Map<String,String> savePayCommit(PaySaveDto paySaveDto,String businessNo)throws Exception;
    String saveEntirePay(PaySaveDto paySaveDto)throws Exception;

    public void savePayBill(NyxClaimPayListDto nyxClaimPayListDto, int count, String billNo, String billFlag);
    /**
     * （将该支付编号的信息作废）
     * @author: 王志文
     * @date: 2017/12/27 11:58
     * @param paymentNo 支付编号
     * @return 修改结果信息
     * @throws Exception
     */
    Map<String,String> updateCancelFlagByPaymentNo(String paymentNo)throws Exception;

    /**
     * （整单支付初始化查询）
     * @author: 王志文
     * @date: 2017/12/28 16:47
     * @param paymentNo 支付编号
     * @return 页面组装信息
     * @throws Exception
     */
    PaySaveDto queryInitEntirePay(String paymentNo)throws Exception;

    /**
     * （支付情况统计更多查询）
     * @author: 王志文
     * @date: 2018/1/3 14:37
     * @param compensateNo 计算书号
     * @return 页面参数dto
     */
    PageInfo queryPayDetail(String compensateNo,String payrefReason,int page,int size);

    /**
     * （支付情况统计列表查询）(分页)
     * @author: 王志文
     * @date: 2018/1/4 16:28
     * @param paymentStatisticsInDto 页面入参
     * @return 页面数据
     * @throws Exception 异常信息
     */
    PageInfo queryPaymentStatistics(PaymentStatisticsInDto paymentStatisticsInDto)throws Exception;

    /**
     * （支付情况统计列表查询）（不分页）
     * @author: 王志文
     * @date: 2018/1/4 18:18
     * @param paymentStatisticsInDto 页面入参
     * @return 页面数据
     * @throws Exception 异常信息
     */
    List<PaymentStatisticsBackDto> queryPaymentStatisticsNoPage(PaymentStatisticsInDto paymentStatisticsInDto) throws Exception;

    /**
     * （状态金额总计查询）
     * @author: 王志文
     * @date: 2018/1/5 9:30
     * @param paymentType 第三方支付标识
     * @param compensateNo 计算书号
     * @return 页面数据集合
     * @throws Exception
     */
    List<PayStateAmountBackDto> queryPayStateAmount(String paymentType,String compensateNo)throws Exception;

    /**
     * 支付情况统计查询导出Excel
     * @param paymentStatisticsInDto   查询入参封装对象
     * @return shortLink 文件下载短链接
     * @throws Exception
     * @author 李文刚
     * @time 2018-1-10
     */
    Map<String,String> paymentStatisticsExportExcel(PaymentStatisticsInDto paymentStatisticsInDto) throws Exception;

    /**
     * 账户同步按钮
     * @Author 王心洋
     * @time 2018/4/24
     * @param registNoList
     * @return List<PrpLCompensateDto>
     */
    List<PrpLCompensateDto> synchAccount(List<String> registNoList) throws Exception;
    /**
     * 支付信息统计表在途金额飘窗
     * @param compensateNo 计算书号
     * @param paymentType 赔款类型
     * @return
     * @throws Exception
     * @author 王心洋
     * @time 2018/4/27
     */
    List<PrplPayDto> queryOnTheWayList(String compensateNo,String paymentType) throws Exception;

    /**
     * （电子回执单下载）
     * @author: 王志文
     * @date: 2018/5/9 9:37
     * @param paymentNo
     * @return
     * @throws Exception
     */
    public Map<String, String> downloadReceipt(String paymentNo) throws Exception;

    /**
     * （支付信息双核回写方法）
     * @author: 王志文
     * @date: 2018/5/12 16:17
     * @param undwrtWriteBackReCaseDto
     * @return
     * @throws Exception
     */
    public String undwrtBackPay(UndwrtWriteBackReCaseDto undwrtWriteBackReCaseDto) throws Exception;
    /**
     * 双核系统审核回调
     * @author: 孙朋飞
     * @date: 2018/1/11 15:55
     * @param undwrtWriteBackReCaseDto 接受双核数据
     * @return 回调状态
     * @throws Exception
     */
    public Integer writeVeriPay(UndwrtWriteBackReCaseDto undwrtWriteBackReCaseDto) throws Exception;
}






