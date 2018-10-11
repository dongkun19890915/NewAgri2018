package com.sinosoft.txnlist.api.plantinginsurancelist;

import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdInsuranceListDto;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.MiddleHerdInsuranceListDto;
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
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = MiddleHerdInsuranceListApi.PATH)
public interface MiddleHerdInsuranceListApi {

    public static final String PATH = "middleHerdInsuranceList";

    /**
     * 保存
     * @author: 田健
     * @date: 2018/3/19 12:02
     * @param middleHerdInsuranceListDto 养殖险Dto
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(@RequestBody MiddleHerdInsuranceListDto middleHerdInsuranceListDto);

    /**
     *根据主键删除
     * @author: 田健
     * @date: 2018/3/19 14:13
     * @param map 中的key为inusreListCode 清单编号,earlAbel ，fCode 农户代码，kindCode 险别代码
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestBody Map<String, String> map);

    /**
     *修改
     * @author: 田健
     * @date: 2018/3/19 14:14
     * @param mIddleHerdInsuranceListDto 养殖险Dto
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(MiddleHerdInsuranceListDto mIddleHerdInsuranceListDto);

    /**
     * 根据主键查询
     * @author: 田健
     * @date: 2018/3/19 14:15
     * @param map 中的key为inusreListCode 清单编号,earlAbel ，fCode 农户代码，kindCode 险别代码
     * @return 养殖险对象
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    @ResponseBody MiddleHerdInsuranceListDto queryByPK(@RequestBody Map<String, String> map);
    /**
     * 根据清单号查询HerdInsuranceList表信息
     * @author: 田健
     * @date: 2018/3/19 14:39
     * @param map 中的key为 inusreListCode 清单编号
     * @return 清单表信息集合
     */
    @RequestMapping(value = "queryByInusreListCode",method = {RequestMethod.POST})
    public @ResponseBody List<MiddleHerdInsuranceListDto> queryByInusreListCode(@RequestBody Map<String, String> map);
}