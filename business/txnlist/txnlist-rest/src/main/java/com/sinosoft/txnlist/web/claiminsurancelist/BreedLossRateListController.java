package com.sinosoft.txnlist.web.claiminsurancelist;

import com.sinosoft.txnlist.api.claiminsurancelist.BreedLossRateListApi;
import com.sinosoft.txnlist.core.claiminsurancelist.service.BreedLossRateListService;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.BreedLossRateListDto;
import com.sinosoft.framework.dto.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-12-25 06:26:52.496 
 * @description 养殖险定损清单信息表controller层
 */
@RestController
@RequestMapping(value = BreedLossRateListController.PATH)
public class BreedLossRateListController implements BreedLossRateListApi {

    private static Logger LOGGER = LoggerFactory.getLogger(BreedLossRateListController.class);

    @Autowired
    private BreedLossRateListService breedLossRateListService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody BreedLossRateListDto breedLossRateListDto) {
        breedLossRateListService.save(breedLossRateListDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody Map<String,String> map) {
        String listNo = map.get("listNo");
        String serialNo = map.get("serialNo");
        breedLossRateListService.remove(listNo,serialNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody BreedLossRateListDto breedLossRateListDto) {
        breedLossRateListService.modify(breedLossRateListDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public BreedLossRateListDto queryByPK(@RequestBody Map<String,String> map) {
        String listNo = map.get("listNo");
        String serialNo = map.get("serialNo");
        return breedLossRateListService.queryByPK(listNo,serialNo);
    }

    /**
     * 关联报案号和清单信息
     * @param map 损失率清单号,报案号
     * @author 王心洋
     * @time 2017-12-25
     */
    @Override
    public void compareInsurance(@RequestBody Map<String, String> map){
        String listNo = map.get("listNo");
        String registNo = map.get("registNo");
        breedLossRateListService.compareInsurance(listNo, registNo);
    }

    /**
     * 按条件查询已关联实体集合
     * @param map 保单号,报案号
     * @return List<BreedLossRateListDto>定损清单信息列表
     * @author 王心洋
     * @time 2017-12-26
     */
    @Override
    public List<BreedLossRateListDto> queryComparable(@RequestBody Map<String, String> map) {
        String policyNo = map.get("policyNo");
        String registNo = map.get("registNo");
        return breedLossRateListService.queryComparable(policyNo,registNo);
    }
    /**
     * 查询定损清单
     * @author: 孙朋飞
     * @date: 2017/12/29 20:11
     * @param map 报案号
     * @return 定损清单集合
     * @throws Exception
     */
    @Override
    public @ResponseBody List<BreedLossRateListDto> queryBreedLossRateListByRegistNo(@RequestBody Map<String, String> map) throws Exception {
        return  breedLossRateListService.queryBreedLossRateListByRegistNo(map.get("registNo"));
    }
    /**
     * 根据定损清单号查询种植险定损清单
     * @author: 杨璐
     * @date: 2017/01/22
     * @param map 清单号
     * @return 种植险定损清单集合
     * @throws Exception
     */
    @Override
    public @ResponseBody PageInfo<BreedLossRateListDto> queryBreedLossRateListDtoByListNo(
            @RequestBody Map<String, String> map) throws Exception {
        return breedLossRateListService.queryBreedLossRateListDtoByListNo(map);
    }

    /**
     * 根据定损清单号删除养植险定损清单
     * @author: 杨璐
     * @date: 2017/01/22
     * @param map 清单号
     * @return 种植险定损清单集合
     * @throws Exception
     */
    @Override
    public @ResponseBody Map<String, String> deleteBreedLossRateListByListNo( @RequestBody Map<String, String> map) throws Exception {
        return breedLossRateListService.deleteBreedLossRateListByListNo(map);
    }
}
