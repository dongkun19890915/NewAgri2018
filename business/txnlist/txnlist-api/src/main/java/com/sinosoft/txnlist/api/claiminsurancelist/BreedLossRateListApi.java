package com.sinosoft.txnlist.api.claiminsurancelist;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.txnlist.api.TxnListConstant;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.BreedLossRateListDto;
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
 * @time  2017-12-25 06:26:52.496 
 * @description 养殖险定损清单信息表Api接口
 */
@FeignClient(name = TxnListConstant.TXN_LIST_SERVICE_NAME, path = BreedLossRateListApi.PATH)
public interface BreedLossRateListApi {

    public static final String PATH = "breedLossRateList";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(BreedLossRateListDto breedLossRateListDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(Map<String,String> map);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(BreedLossRateListDto breedLossRateListDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    BreedLossRateListDto queryByPK(Map<String,String> map);

    /**
     * 关联报案号和清单信息
     * @param map 损失率清单号,报案号
     * @author 王心洋
     * @time 2017-12-25
     */
    @RequestMapping(value = "compareInsurance",method = {RequestMethod.POST})
    void compareInsurance(Map<String,String> map);

    /**
     * 按条件查询已关联实体集合
     * @param map 保单号,报案号
     * @return List<BreedLossRateListDto>定损清单信息列表
     * @author 王心洋
     * @time 2017-12-26
     */
    @RequestMapping(value = "queryComparable",method = {RequestMethod.POST})
    List<BreedLossRateListDto> queryComparable(Map<String,String> map);

    /**
     * 查询养殖险定损清单
     * @author: 孙朋飞
     * @date: 2017/12/29 20:11
     * @param map 报案号
     * @return 定损清单集合
     * @throws Exception
     */
    @RequestMapping(value = "queryBreedLossRateListByRegistNo",method = {RequestMethod.POST})
    public @ResponseBody List<BreedLossRateListDto> queryBreedLossRateListByRegistNo(@RequestBody Map<String,String> map) throws Exception;
    /**
     * 根据定损清单号查询种植险定损清单
     * @author: 杨璐
     * @date: 2017/01/22
     * @param
     * @return 种植险定损清单集合
     * @throws Exception
     */
    @RequestMapping(value = "queryBreedLossRateListDtoByListNo", method = { RequestMethod.POST })
    public @ResponseBody
    PageInfo<BreedLossRateListDto> queryBreedLossRateListDtoByListNo(
            @RequestBody Map<String, String> map) throws Exception;

    /**
     * 根据定损清单号删除养植险定损清单
     * @author: 杨璐
     * @date: 2017/01/22
     * @param
     * @return 种植险定损清单集合
     * @throws Exception
     */
    @RequestMapping(value = "deleteByListNo", method = { RequestMethod.POST })
    public @ResponseBody Map<String, String> deleteBreedLossRateListByListNo(@RequestBody Map<String, String> map)
            throws Exception;

}