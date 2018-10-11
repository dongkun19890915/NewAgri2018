package com.sinosoft.txnlist.api.plantinginsurancelist;

import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdInsuranceListDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time 2017-10-16 03:27:26.178
 * @description 投保明细表Api接口
 */
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = HerdInsuranceListApi.PATH)
public interface HerdInsuranceListApi {

    public static final String PATH = "herdInsuranceList";

    /**
     * 保存
     * @author: 田健
     * @date: 2018/3/19 12:02
     * @param herdInsuranceListDto 养殖险Dto
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(@RequestBody HerdInsuranceListDto herdInsuranceListDto);

    /**
     *根据主键删除
     * @author: 田健
     * @date: 2018/3/19 14:13
     * @param map 中的key为inusreListCode 清单编号,earlAbel ，fCode 农户代码，kindCode 险别代码
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestBody Map<String,String> map);

    /**
     *修改
     * @author: 田健
     * @date: 2018/3/19 14:14
     * @param herdInsuranceListDto 养殖险Dto
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(HerdInsuranceListDto herdInsuranceListDto);

    /**
     * 根据主键查询
     * @author: 田健
     * @date: 2018/3/19 14:15
     * @param map 中的key为inusreListCode 清单编号,earlAbel ，fCode 农户代码，kindCode 险别代码
     * @return 养殖险对象
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    @ResponseBody HerdInsuranceListDto queryByPK(@RequestBody Map<String,String> map);

    @RequestMapping(value = "countByInusreListCode", method = {RequestMethod.POST})
    /*
    * @author:
    * @date: 2018/5/22 下午 18:13
    * */
    public @ResponseBody
    long countByInusreListCode(@RequestBody Map<String, String> map);

    @RequestMapping(value = "queryByInusreListCode",method = {RequestMethod.POST})
    public @ResponseBody List<HerdInsuranceListDto> queryByInusreListCode(@RequestBody Map<String,String> map);

    /**
     * 根据保单号查询HerdInsuranceList表信息
     * @author: 田健
     * @date: 2018/4/13 11:57
     * @param map 中的key为保单号
     * @return HerdInsuranceList集合
     * @throws Exception
     */
    @RequestMapping(value = "queryNyxInsuranceListDtoByPolicyNo", method = RequestMethod.POST)
    @ResponseBody List<HerdInsuranceListDto> queryNyxInsuranceListDtoByPolicyNo(@RequestBody Map<String, String> map) throws Exception;
}