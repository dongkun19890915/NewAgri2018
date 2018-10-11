package com.sinosoft.txnlist.web.claiminsurancelist;

import com.sinosoft.txnlist.api.claiminsurancelist.NyxClaimPayListApi;
import com.sinosoft.txnlist.core.claiminsurancelist.service.NyxClaimPayListService;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.NyxClaimPayListDto;
import com.sinosoft.framework.dto.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2018-01-02 07:30:32.914
 * @description 理赔支付清单表controller层
 */
@RestController
@RequestMapping(value = NyxClaimPayListController.PATH)
public class NyxClaimPayListController implements NyxClaimPayListApi {

    private static Logger LOGGER = LoggerFactory.getLogger(NyxClaimPayListController.class);

    @Autowired
    private NyxClaimPayListService nyxClaimPayListService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody NyxClaimPayListDto nyxClaimPayListDto) {
        nyxClaimPayListService.save(nyxClaimPayListDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestParam("listNo") String listNo,@RequestParam("serialNo")String serialNo) {
        nyxClaimPayListService.remove(listNo,serialNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody NyxClaimPayListDto nyxClaimPayListDto) {
        nyxClaimPayListService.modify(nyxClaimPayListDto);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    public NyxClaimPayListDto queryByPK(@RequestParam("listNo") String listNo,@RequestParam("serialNo") String serialNo) {
        return nyxClaimPayListService.queryByPK(listNo,serialNo);
    }
    /**
     * 批量保存支付清单
     * @author: 孙朋飞
     * @date: 2018/1/2 17:18
     * @param nyxClaimPayListDtos 支付清单的excel导入集合
     * @throws Exception
     */
    @Override
    public void batchSaveNyxClaimPayList(@RequestBody List<NyxClaimPayListDto> nyxClaimPayListDtos) throws Exception {
        nyxClaimPayListService.batchSaveNyxClaimPayList(nyxClaimPayListDtos);
    }
    /**
     * 查询支付清单信息
     * @author: 孙朋飞
     * @date: 2018/1/3 17:52
     * @param map 清单号
     * @return 支付清单的集合
     * @throws Exception
     */
    @Override
    public @ResponseBody List<NyxClaimPayListDto> queryNyxClaimPayListByListNo(@RequestBody Map<String, String> map) throws Exception {
        return nyxClaimPayListService.queryNyxClaimPayListByListNo(map.get("listNo"));
    }
    /**
     * 分页查询支付清单信息
     * @author: 孙朋飞
     * @date: 2018/1/3 18:59
     * @param map listNo清单号,pageNo当前页,pageSize 每页显示条数
     * @return 支付清单的集合
     * @throws Exception
     */
    @Override
    public @ResponseBody PageInfo<NyxClaimPayListDto> queryNyxClaimPayListPage(@RequestBody Map<String, String> map) throws Exception {
        return nyxClaimPayListService.queryNyxClaimPayListPage(map.get("listNo"),map.get("pageNo"),map.get("pageSize"));
    }

    /**
     * （通过清单号查询所有数据）
     * @author: 王志文
     * @date: 2018/1/2 15:52
     * @param listNo 清单号
     * @return
     */
    @Override
    public List<NyxClaimPayListDto> queryAllNyxClaimPayListDtoByListNo(String listNo) {
        return nyxClaimPayListService.queryAllNyxClaimPayListDtoByListNo(listNo);
    }
    /**
     * （通过支付单号查询所有数据）
     * @author: 王心洋
     * @date: 2018/1/2 15:52
     * @param paymentNo 支付单号
     * @return
     */
    @Override
    public List<NyxClaimPayListDto> queryAllByPaymentNo(String paymentNo) {
        return nyxClaimPayListService.queryAllByPaymentNo(paymentNo);
    }

    /**
     * 根据理算书号查询支付清单信息
     * @author: 孙朋飞
     * @date: 2018/3/29 9:59
     * @param map 理算书号 compensateNo
     * @return 支付清单号
     * @throws Exception
     */
    @Override
    public @ResponseBody Map<String, String> queryNyxClaimPayListByCompensateNo(@RequestBody Map<String, String> map) throws Exception {
        return nyxClaimPayListService.queryNyxClaimPayListByCompensateNo(map.get("compensateNo"));
    }
    /**
     * 根据理算书号删除支付清单
     * @author: 孙朋飞
     * @date: 2018/3/29 11:34
     * @param compensateNo 理算书号
     * @throws Exception
     */
    @Override
    public void deleteNyxClaimPayListByCompensateNo(@RequestParam("compensateNo") String compensateNo) throws Exception {
        nyxClaimPayListService.deleteNyxClaimPayListByCompensateNo(compensateNo);
    }

}
