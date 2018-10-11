package com.sinosoft.txnlist.api.claiminsurancelist;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.NyxClaimPayListDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-02 07:30:32.914
 * @description 理赔支付清单表Api接口
 */
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = NyxClaimPayListApi.PATH)
public interface NyxClaimPayListApi {

    public static final String PATH = "nyxClaimPayList";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(NyxClaimPayListDto nyxClaimPayListDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestParam("listNo")String listNo,@RequestParam("serialNo") String serialNo);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(NyxClaimPayListDto nyxClaimPayListDto);
    /**
     *@description 按主键查询实体
     *@param
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    NyxClaimPayListDto queryByPK(@RequestParam("listNo")String listNo, @RequestParam("serialNo")String serialNo);

    /**
     * 批量保存支付清单
     * @author: 孙朋飞
     * @date: 2018/1/2 17:18
     * @param nyxClaimPayListDtos 支付清单的excel导入集合
     * @throws Exception
     */
    @RequestMapping(value = "batchSaveNyxClaimPayList",method = {RequestMethod.POST})
    public void batchSaveNyxClaimPayList(@RequestBody List<NyxClaimPayListDto> nyxClaimPayListDtos) throws Exception;

    /**
     * 查询支付清单信息
     * @author: 孙朋飞
     * @date: 2018/1/3 17:52
     * @param map 清单号（必传）
     * @return 支付清单的集合
     * @throws Exception
     */
    @RequestMapping(value="queryNyxClaimPayListByListNo",method = {RequestMethod.POST})
    public @ResponseBody List<NyxClaimPayListDto> queryNyxClaimPayListByListNo(@RequestBody Map<String, String> map) throws Exception;
    /**
     * 分页查询支付清单信息
     * @author: 孙朋飞
     * @date: 2018/1/3 18:59
     * @param map 清单号listNo（必传），pageNo当前页,pageSize 每页显示条数
     * @return 支付清单的集合
     * @throws Exception
     */
    @RequestMapping(value="queryNyxClaimPayListPage",method = {RequestMethod.POST})
    public @ResponseBody PageInfo<NyxClaimPayListDto> queryNyxClaimPayListPage(@RequestBody Map<String, String> map) throws Exception;

    /**
     * （通过清单号查询所有数据）
     * @author: 王志文
     * @date: 2018/1/2 15:52
     * @param listNo 清单号
     * @return
     */
    @RequestMapping(value = "queryAllNyxClaimPayListDtoByListNo",method = {RequestMethod.POST})
    List<NyxClaimPayListDto> queryAllNyxClaimPayListDtoByListNo(@RequestParam("listNo") String listNo);
    /**
     * （通过支付单号查询所有数据）
     * @author: 王心洋
     * @date: 2018/4/13 15:52
     * @param paymentNo 支付单号
     * @return
     */
    @RequestMapping(value = "queryAllByPaymentNo",method = {RequestMethod.POST})
    List<NyxClaimPayListDto> queryAllByPaymentNo(@RequestParam("paymentNo") String paymentNo);

    /**
     * 根据理算书号查询支付清单信息
     * @author: 孙朋飞
     * @date: 2018/3/29 9:59
     * @param map 理算书号 compensateNo
     * @return 支付清单号
     * @throws Exception
     */
    @RequestMapping(value="queryNyxClaimPayListByCompensateNo",method = {RequestMethod.POST})
    public @ResponseBody Map<String,String> queryNyxClaimPayListByCompensateNo(@RequestBody Map<String,String> map) throws Exception;

    /**
     * 根据理算书号删除支付清单
     * @author: 孙朋飞
     * @date: 2018/3/29 11:34
     * @param compensateNo 理算书号
     * @throws Exception
     */
    @RequestMapping(value="deleteNyxClaimPayListByCompensateNo",method = {RequestMethod.POST})
    public void deleteNyxClaimPayListByCompensateNo(@RequestParam("compensateNo") String compensateNo) throws Exception;
}