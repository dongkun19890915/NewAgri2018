package com.sinosoft.agriclaim.web.paymentmanage;

import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCompensateDto;
import com.sinosoft.agriclaim.api.paymentmanage.PrplPayApi;
import com.sinosoft.agriclaim.api.paymentmanage.dto.*;
import com.sinosoft.agriclaim.api.recasemanage.dto.UndwrtWriteBackReCaseDto;
import com.sinosoft.agriclaim.core.paymentmanage.service.PrplPayService;
import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.RequestNyxPlantingClaimListDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-08 05:43:17.258 
 * @description 支付信息子表controller层
 */
@RestController
@RequestMapping(value = PrplPayController.PATH)
public class PrplPayController implements PrplPayApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrplPayController.class);

    @Autowired
    private PrplPayService prplPayService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrplPayDto prplPayDto) {
        prplPayService.save(prplPayDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestParam("serialNo") String serialNo,@RequestParam("serialNo2") String serialNo2) {
        prplPayService.remove(serialNo,serialNo2);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrplPayDto prplPayDto) {
        prplPayService.modify(prplPayDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrplPayDto queryByPK(@RequestParam("serialNo") String serialNo,@RequestParam("serialNo2") String serialNo2) {
        return prplPayService.queryByPK(serialNo,serialNo2);
    }
    /**
     * @description 按条件查询支付录入信息（带分页）
     * @param  prpJPlanFeePageMsgDto 查询入参
     * @return PrpJPlanFeePageMsgDto 查询结果
     * @throws Exception
     * @author 李磊
     * @date 2017-12-21 15:35
     */
    public @ResponseBody PrpJPlanFeePageMsgDto queryPrpJPlanFeePageMsgDto(@RequestBody PrpJPlanFeePageMsgDto prpJPlanFeePageMsgDto) throws Exception{
        return prplPayService.queryPrpJPlanFeePageMsgDto(prpJPlanFeePageMsgDto);
    }

    /**
     * @description 按条件查询支付录入信息（无分页）
     * @param  queryPrpJplanFeeDto 查询入参
     * @return List<PrpJplanFeeDto> 查询结果
     * @throws Exception
     * @author 李磊
     * @date 2017-12-21 15:35
     */
    public @ResponseBody
    List<PrpJplanFeeDto> queryPrpJPlanFeeDto(@RequestBody QueryPrpJplanFeeDto queryPrpJplanFeeDto) throws Exception{
        return prplPayService.queryPrpJPlanFeeDto(queryPrpJplanFeeDto);
    }
    /**
     * @description 按条件查询已经录入的支付信息
     * @param  prplPayDto 查询入参封装对象
     * @return PrplPayDto 查询结果返回对象
     * @throws Exception
     * @author 李磊
     * @date 2017-12-28 14:15
     */
    public @ResponseBody
    PageInfo<PrplPayDto> queryPrplPayDtoByCondition(@RequestBody PrplPayDto prplPayDto) throws Exception{
        return prplPayService.queryPrplPayDtoByCondition(prplPayDto);
    }
    /**
     * 支付清单的下载
     * @author: 孙朋飞
     * @date: 2017/12/27 16:09
     * @param map 清单号
     * @return 文件下载的链接
     * @throws Exception
     */
    @Override
    public @ResponseBody Map<String, String> expNyxClaimPayList(@RequestBody Map<String, String> map) throws Exception {
        String shortLink = prplPayService.expNyxClaimPayList(map.get("listNo"));
        Map<String,String> hashmap = new HashMap<>();
        hashmap.put("shortLink",shortLink);
        return hashmap;
    }
    /**
     * 由理赔清单封装支付清单并下载
     * @param requestNyxPlantingClaimListDto
     * @return 文件下载的链接
     * @throws Exception
     * @author 王心洋
     * @time 2018/4/12
     */
    @Override
    public @ResponseBody Map<String, String> expAssembleClaimPayList(@RequestBody RequestNyxPlantingClaimListDto requestNyxPlantingClaimListDto) throws Exception{
        String shortLink = prplPayService.expAssembleClaimPayList(requestNyxPlantingClaimListDto);
        Map<String,String> hashmap = new HashMap<>();
        hashmap.put("shortLink",shortLink);
        return hashmap;
    }
    /**
     *支付清单数据的导入保存
     * @author: 孙朋飞
     * @date: 2018/1/2 14:44
     * @param map 文件标识fileId和机构代码
     * @return 返回清单号和金额合计
     * @throws Exception
     */
    @Override
    public @ResponseBody Map<String, Object> importNyxClaimPayList(@RequestBody Map<String, String> map) throws Exception {
        return prplPayService.importNyxClaimPayList(map.get("fileId"),map.get("comCode"));
    }

    /**
     * （支付录入整单支付保存）
     * @author: 王志文
     * @date: 2017/12/26 15:03
     * @return 操作成功信息
     * @throws Exception
     */
    @Override
    public Map<String, String> savePayMain(@RequestBody PaySaveDto paySaveDto) throws Exception {
        return prplPayService.savePaysOut(paySaveDto);
    }

    /**
     * （将该支付编号的信息作废）
     * @author: 王志文
     * @date: 2017/12/27 11:58
     * @param paymentNo 支付编号
     * @return 修改结果信息
     * @throws Exception
     */
    @Override
    public Map<String, String> updateCancelFlagByPaymentNo(String paymentNo) throws Exception {
        return prplPayService.updateCancelFlagByPaymentNo(paymentNo);
    }

    /**
     * （整单支付初始化查询）
     * @author: 王志文
     * @date: 2017/12/28 16:47
     * @param map 支付编号
     * @return 页面组装信息
     * @throws Exception
     */
    @Override
    public PaySaveDto queryInitEntirePay(@RequestBody Map<String,String> map) throws Exception {
        return prplPayService.queryInitEntirePay(map.get("paymentNo"));
    }

    /**
     * （支付情况统计更多查询）
     * @author: 王志文
     * @date: 2018/1/3 14:37
     * @param map 计算书号
     * @return 页面数据dto
     */
    @Override
    public PageInfo queryPayDetail(@RequestBody Map<String,String> map) {
        String compensateNo = map.get("compensateNo");
        String payrefReason = map.get("payrefReason");
        Integer page = Integer.parseInt(map.get("page"));
        Integer size = Integer.parseInt(map.get("size"));
        return prplPayService.queryPayDetail(compensateNo,payrefReason,page,size);
    }

    /**
     * （支付情况统计列表查询）(分页)
     * @author: 王志文
     * @date: 2018/1/4 16:28
     * @param paymentStatisticsInDto 页面入参
     * @return 页面数据
     * @throws Exception 异常信息
     */
    @Override
    public PageInfo queryPaymentStatistics(@RequestBody PaymentStatisticsInDto paymentStatisticsInDto) throws Exception {
        return prplPayService.queryPaymentStatistics(paymentStatisticsInDto);
    }

    /**
     * （支付情况统计列表查询）（不分页）
     * @author: 王志文
     * @date: 2018/1/4 18:18
     * @param paymentStatisticsInDto 页面入参
     * @return 页面数据
     * @throws Exception 异常信息
     */
    @Override
    public List<PaymentStatisticsBackDto> queryPaymentStatisticsNoPage(PaymentStatisticsInDto paymentStatisticsInDto) throws Exception {
        return prplPayService.queryPaymentStatisticsNoPage(paymentStatisticsInDto);
    }

    /**
     * （状态金额总计查询）
     * @author: 王志文
     * @date: 2018/1/5 9:30
     * @param paymentType 第三方支付标识
     * @param compensateNo 计算书号
     * @return 页面数据集合
     * @throws Exception 异常信息
     */
    @Override
    public List<PayStateAmountBackDto> queryPayStateAmount(String paymentType, String compensateNo) throws Exception {
        return prplPayService.queryPayStateAmount(paymentType,compensateNo);
    }

    /**
     * 支付情况统计查询导出Excel
     * @param paymentStatisticsInDto   查询入参封装对象
     * @return shortLink 文件下载短链接
     * @throws Exception
     * @author 李文刚
     * @time 2018-1-10
     */
    @Override
    public Map<String,String> paymentStatisticsExportExcel(@RequestBody PaymentStatisticsInDto paymentStatisticsInDto) throws Exception{
        return prplPayService.paymentStatisticsExportExcel(paymentStatisticsInDto);
    }

    /**
     * 账户同步按钮
     * @Author 王心洋
     * @time 2018/4/24
     * @param registNoList
     * @return List<PrpLCompensateDto>
     */
    @Override
    public List<PrpLCompensateDto> synchAccount(@RequestBody List<String> registNoList)throws Exception{
        return prplPayService.synchAccount(registNoList);
    }

    /**
     * 支付信息统计表在途金额飘窗
     * @param map 计算书号 赔款类型
     * @return
     * @throws Exception
     * @author 王心洋
     * @time 2018/4/27
     */
    @Override
    public List<PrplPayDto> queryOnTheWayList(@RequestBody Map<String,String> map) throws Exception{
        String compensateNo = map.get("compensateNo");
        String paymentType = map.get("paymentType");
        return prplPayService.queryOnTheWayList(compensateNo,paymentType);
    }

    /**
     * （电子回执单下载）
     * @author: 王志文
     * @date: 2018/5/9 9:37
     * @param map
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, String> downloadReceipt(@RequestBody Map<String, String> map) throws Exception {
        String paymentNo = map.get("paymentNo");
        return prplPayService.downloadReceipt(paymentNo);
    }

    /**
     * （支付信息双核回写方法）
     * @author: 王志文
     * @date: 2018/5/12 16:17
     * @param undwrtWriteBackReCaseDto
     * @return
     * @throws Exception
     */
    @Override
    public String undwrtBackPay(@RequestBody UndwrtWriteBackReCaseDto undwrtWriteBackReCaseDto) throws Exception {
        return prplPayService.undwrtBackPay(undwrtWriteBackReCaseDto);
    }
    /**
     * 双核系统审核回调
     * @author: 孙朋飞
     * @date: 2018/1/11 15:55
     * @param undwrtWriteBackReCaseDto 接受双核数据
     * @return 回调状态
     * @throws Exception
     */
    @Override
    public @ResponseBody Integer writeVeriPay(@RequestBody UndwrtWriteBackReCaseDto undwrtWriteBackReCaseDto) throws Exception {
        return prplPayService.writeVeriPay(undwrtWriteBackReCaseDto);
    }
}
