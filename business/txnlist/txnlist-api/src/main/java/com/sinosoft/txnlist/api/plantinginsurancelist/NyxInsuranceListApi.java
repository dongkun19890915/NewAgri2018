package com.sinosoft.txnlist.api.plantinginsurancelist;

import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxInsuranceListDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * *查询投保清单
 * @Author: 田慧
 * @Date: 2017/12/11 16:11
 */
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = NyxInsuranceListApi.PATH)

public interface NyxInsuranceListApi {
    public static final String PATH = "nyxInsuranceList";

    /**
     * 批量保存清单表信息
     * @author: 田健
     * @date: 2017/12/20 17:01
     * @param nyxInsuranceListDtos 清单信息集合
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    String saveByList(@RequestBody List<NyxInsuranceListDto> nyxInsuranceListDtos) throws Exception;

    /**
     * @param inusreListcode
     * @description:（根据inreListcode删除清单数据）
     * @author: 田健
     * @date: 2017/10/20 12:01
     */
    @RequestMapping(value = "removeByInusreListcode", method = {RequestMethod.GET})
    public void removeByInusreListcode(@RequestParam("inusrelistcode") String inusreListcode);
    /**
     * （根据inreListcode根据查询各项补贴金额与农户自缴份额）
     * @author: 田健
     * @date: 2017/10/20 11:57
     * @param map key值是清单号
     * @return nyxInsuranceListDto 返回各项补贴金额
     */
    @RequestMapping(value = "getSumFee",method = {RequestMethod.POST})
    public NyxInsuranceListDto getSumFee(@RequestBody Map<String,String> map);
    /**
     *  根据条件查询投保清单中农户户次
     * @author: 田慧
     * @date: 2017/12/11 19:33
     * @param map 包括inusrelistCode 投保清单编号
     * @return 返回FIdCard的总条数
     * @throws Exception
     */
    @RequestMapping(value = "queryFIdCardByInusrelistCode",method = {RequestMethod.POST})
    public Map<String,Long> queryFIdCardByInusrelistCode(@RequestBody Map<String,String> map)throws Exception;
    /**
     * 根据条件查询投保清单中总户数
     * @author: 田慧
     * @date: 2017/12/11 20:00
     * @param map 包括inusrelistCode 投保清单编号
     * @return 返回areaNumber总数
     * @throws Exception
     */
    @RequestMapping(value = "queryAreaNumberByInusrelistCode",method = {RequestMethod.POST})
    public Map<String,Double> queryAreaNumberByInusrelistCode(@RequestBody Map<String,String> map) throws Exception;

    /**
     * 根据清单号查询NyxInsuranceList表信息
     * @author: 田健
     * @date: 2018/3/19 14:39
     * @param map 中的key 为inusreListCode 清单编号
     * @return 清单表信息集合
     */
    @RequestMapping(value = "queryByInusreListCode",method = {RequestMethod.POST})
    public @ResponseBody List<NyxInsuranceListDto> queryByInusreListCode(@RequestBody Map<String,String> map);

    /**
     * 根据保单号查询NyxInsuranceList表信息
     * @author: 田健
     * @date: 2018/4/13 11:57
     * @param map 中的key为保单号
     * @return NyxInsuranceListDto集合
     * @throws Exception
     */
    @RequestMapping(value = "queryNyxInsuranceListDtoByPolicyNo", method = RequestMethod.POST)
    @ResponseBody List<NyxInsuranceListDto> queryNyxInsuranceListDtoByPolicyNo(@RequestBody Map<String, String> map) throws Exception;
}
