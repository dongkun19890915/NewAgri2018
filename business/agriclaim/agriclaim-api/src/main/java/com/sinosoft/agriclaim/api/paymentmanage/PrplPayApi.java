package com.sinosoft.agriclaim.api.paymentmanage;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCompensateDto;
import com.sinosoft.agriclaim.api.paymentmanage.dto.*;
import com.sinosoft.agriclaim.api.recasemanage.dto.UndwrtWriteBackReCaseDto;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.RequestNyxPlantingClaimListDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:43:17.258 
 * @description 支付信息子表Api接口
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = PrplPayApi.PATH)
public interface PrplPayApi {

    public static final String PATH = "prplPay";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(PrplPayDto prplPayDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestParam("serialNo") String serialNo,@RequestParam("serialNo2") String serialNo2);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(PrplPayDto prplPayDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    PrplPayDto queryByPK(@RequestParam("serialNo") String serialNo,@RequestParam("serialNo2") String serialNo2);
    /**
     * @description 按条件查询支付录入信息（带分页）
     * @param  prpJPlanFeePageMsgDto 查询入参
     * @return PrpJPlanFeePageMsgDto 查询结果
     * @throws Exception
     * @author 李磊
     * @date 2017-12-21 15:35
     */
    @RequestMapping(value = "queryPrpJPlanFeePageMsgDto",method = {RequestMethod.POST})
    public @ResponseBody PrpJPlanFeePageMsgDto queryPrpJPlanFeePageMsgDto(@RequestBody PrpJPlanFeePageMsgDto prpJPlanFeePageMsgDto) throws Exception;

    /**
     * @description 按条件查询支付录入信息（无分页）
     * @param  queryPrpJplanFeeDto 查询入参
     * @return List<PrpJplanFeeDto> 查询结果
     * @throws Exception
     * @author 李磊
     * @date 2017-12-21 15:35
     */
    @RequestMapping(value = "queryPrpJPlanFeeDto",method = {RequestMethod.POST})
    public @ResponseBody
    List<PrpJplanFeeDto> queryPrpJPlanFeeDto(@RequestBody QueryPrpJplanFeeDto queryPrpJplanFeeDto) throws Exception;


    /**
    * @description 按条件查询已经录入的支付信息
    * @param  prplPayDto 查询入参封装对象
    * @return PrplPayDto 查询结果返回对象
    * @throws Exception
    * @author 李磊
    * @date 2017-12-28 14:15
    */
    @RequestMapping(value = "queryPrplPayDtoByCondition",method = {RequestMethod.POST})
    public @ResponseBody
    PageInfo<PrplPayDto> queryPrplPayDtoByCondition(@RequestBody PrplPayDto prplPayDto) throws Exception;

    /**
     * 支付清单的下载
     * @author: 孙朋飞
     * @date: 2017/12/27 16:09
     * @param map listNo清单号和queryType(“0”：下载空模版，“1”：下载带数据)下载类型（必传）
     * @return 文件下载的链接
     * @throws Exception
     */
    @RequestMapping(value = "expNyxClaimPayList",method = RequestMethod.POST)
    public @ResponseBody Map<String,String> expNyxClaimPayList(@RequestBody Map<String,String> map) throws Exception;

    /**
     * 由理赔清单封装支付清单并下载
     * @param requestNyxPlantingClaimListDto
     * @return 文件下载的链接
     * @throws Exception
     * @author 王心洋
     * @time 2018/4/12
     */
    @RequestMapping(value = "expAssembleClaimPayList",method = RequestMethod.POST)
    public @ResponseBody Map<String, String> expAssembleClaimPayList(@RequestBody RequestNyxPlantingClaimListDto requestNyxPlantingClaimListDto) throws Exception;
    /**
     *支付清单数据的导入保存
     * @author: 孙朋飞
     * @date: 2018/1/2 14:44
     * @param map 文件标识fileId和机构代码
     * @return 返回清单号和金额合计
     * @throws Exception
     */
    @RequestMapping(value = "importNyxClaimPayList",method = RequestMethod.POST)
    public @ResponseBody
    Map<String,Object> importNyxClaimPayList(Map<String,String> map) throws Exception;


    /**
     * （支付录入支付保存 GYNX-310）
     * @author: 王志文
     * @date: 2017/12/26 17:56
     * @param paySaveDto 处理意见及信息
     * @return 操作成功信息
     * @throws Exception
     */
    @RequestMapping(value = "savePayMain",method = {RequestMethod.POST})
    Map<String,String> savePayMain(@RequestBody PaySaveDto paySaveDto) throws Exception;

    /**
     * （将该支付编号的信息作废）
     * @author: 王志文
     * @date: 2017/12/27 11:58
     * @param paymentNo 支付编号
     * @return 修改结果信息
     * @throws Exception
     */
    @RequestMapping(value = "updateCancelFlagByPaymentNo",method = {RequestMethod.GET})
    Map<String,String> updateCancelFlagByPaymentNo(@RequestParam("paymentNo") String paymentNo)throws Exception;

    /**
     * （整单支付初始化查询）
     * @author: 王志文
     * @date: 2017/12/28 16:47
     * @param map 支付编号
     * @return 页面组装信息
     * @throws Exception
     */
    @RequestMapping(value = "queryInitEntirePay",method = {RequestMethod.POST})
    PaySaveDto queryInitEntirePay(@RequestBody Map<String,String> map)throws Exception;

    /**
     * （支付情况统计更多查询）
     * @author: 王志文
     * @date: 2018/1/3 14:37
     * @param map 计算书号
     * @return 页面数据dto
     */
    @RequestMapping(value = "queryPayDetail",method = {RequestMethod.POST})
    PageInfo queryPayDetail(@RequestBody Map<String,String> map);

    /**
     * （支付情况统计列表查询）(分页)
     * @author: 王志文
     * @date: 2018/1/4 16:28
     * @param paymentStatisticsInDto 页面入参
     * @return 页面数据
     * @throws Exception 异常信息
     */
    @RequestMapping(value = "queryPaymentStatistics",method = {RequestMethod.POST})
    PageInfo queryPaymentStatistics(@RequestBody PaymentStatisticsInDto paymentStatisticsInDto)throws Exception;


    /**
     * （支付情况统计列表查询）（不分页）
     * @author: 王志文
     * @date: 2018/1/4 18:18
     * @param paymentStatisticsInDto 页面入参
     * @return 页面数据
     * @throws Exception 异常信息
     */
    @RequestMapping(value = "queryPaymentStatisticsNoPage",method = {RequestMethod.POST})
    List<PaymentStatisticsBackDto> queryPaymentStatisticsNoPage(@RequestBody PaymentStatisticsInDto paymentStatisticsInDto) throws Exception;

    /**
     * （状态金额总计查询）
     * @author: 王志文
     * @date: 2018/1/5 9:30
     * @param paymentType 第三方支付标识
     * @param compensateNo 计算书号
     * @return 页面数据集合
     * @throws Exception 异常信息
     */
    @RequestMapping(value = "queryPayStateAmount",method = {RequestMethod.GET})
    List<PayStateAmountBackDto> queryPayStateAmount(@RequestParam("paymentType") String paymentType,@RequestParam("compensateNo")String compensateNo)throws Exception;


    /**
     * 支付情况统计查询导出Excel
     * @param paymentStatisticsInDto   查询入参封装对象
     * @return shortLink 文件下载短链接
     * @throws Exception
     * @author 李文刚
     * @time 2018-1-10
     */

    @RequestMapping(value = "paymentStatisticsExportExcel",method = RequestMethod.POST)
    Map<String,String> paymentStatisticsExportExcel(@RequestBody PaymentStatisticsInDto paymentStatisticsInDto) throws Exception;

    /**
     * 账户同步按钮
     * @Author 王心洋
     * @time 2018/4/24
     * @param registNoList
     * @return List<PrpLCompensateDto>
     */
    @RequestMapping(value = "synchAccount",method = RequestMethod.POST)
    @ResponseBody List<PrpLCompensateDto> synchAccount(@RequestBody List<String> registNoList)throws Exception;

    /**
     * 支付信息统计表在途金额飘窗
     * @param map 计算书号 赔款类型
     * @return
     * @throws Exception
     * @author 王心洋
     * @time 2018/4/27
     */
    @RequestMapping(value = "queryOnTheWayList",method = RequestMethod.POST)
    @ResponseBody List<PrplPayDto> queryOnTheWayList(@RequestBody Map<String,String> map) throws Exception;

    /**
     * （电子回执单下载）
     * @author: 王志文
     * @date: 2018/5/9 9:37
     * @param map
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "downloadReceipt",method = {RequestMethod.POST})
    Map<String,String> downloadReceipt(@RequestBody Map<String,String> map)throws Exception;

    /**
     * （支付信息双核回写方法）
     * @author: 王志文
     * @date: 2018/5/12 16:17
     * @param undwrtWriteBackReCaseDto
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "undwrtBackPay",method = {RequestMethod.POST})
    String undwrtBackPay(@RequestBody UndwrtWriteBackReCaseDto undwrtWriteBackReCaseDto) throws Exception;
    /**
     * 双核系统审核回调
     * @author: 孙朋飞
     * @date: 2018/1/11 15:55
     * @param undwrtWriteBackReCaseDto 接受双核数据
     * @return 回调状态
     * @throws Exception
     */
    @RequestMapping(value = "writeVeriPay",method = RequestMethod.POST)
    public @ResponseBody Integer writeVeriPay(@RequestBody UndwrtWriteBackReCaseDto undwrtWriteBackReCaseDto) throws Exception;
}