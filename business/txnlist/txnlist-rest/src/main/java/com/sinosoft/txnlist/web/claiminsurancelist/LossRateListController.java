package com.sinosoft.txnlist.web.claiminsurancelist;

import com.sinosoft.txnlist.api.claiminsurancelist.LossRateListApi;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.RequestSaveLossRateListDto;
import com.sinosoft.txnlist.core.claiminsurancelist.service.LossRateListService;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.LossRateListDto;
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
 * @time  2017-12-26 08:50:16.862 
 * @description 理赔清单信息主表controller层
 */
@RestController
@RequestMapping(value = LossRateListController.PATH)
public class LossRateListController implements LossRateListApi {

    private static Logger LOGGER = LoggerFactory.getLogger(LossRateListController.class);

    @Autowired
    private LossRateListService lossRateListService;

    /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody LossRateListDto lossRateListDto) {
        lossRateListService.save(lossRateListDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String listNo       ) {
        lossRateListService.remove(listNo       );
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody LossRateListDto lossRateListDto) {
        lossRateListService.modify(lossRateListDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public LossRateListDto queryByPK(@RequestBody String listNo       ) {
        return lossRateListService.queryByPK(listNo       );
    }
    /**
     * 按条件查询实体集合
     * @param map 保单号,报案号
     * @return List<NyxBreedClaimListDto>定损清单信息列表
     * @author 王心洋
     * @time 2017-12-25
     */
    @Override
    public List<LossRateListDto> queryByConditions(@RequestBody Map<String,String> map) {
        String policyNo = map.get("policyNo");
        String registNo = map.get("registNo");
        return lossRateListService.queryByConditions(policyNo, registNo);
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
        lossRateListService.compareInsurance(listNo, registNo);
    }
    /**
     * 按条件查询已关联实体集合
     * @param map 保单号,报案号
     * @return List<LossRateListDto>定损清单信息列表
     * @author 王心洋
     * @time 2017-12-26
     */
    @Override
    public List<LossRateListDto> queryComparable(@RequestBody Map<String, String> map) {
        String policyNo = map.get("policyNo");
        String registNo = map.get("registNo");
        return lossRateListService.queryComparable(policyNo,registNo);
    }

    /**
     * 金禾调用定损清单保存接口
     * @param requestSaveLossRateListDto 金禾传入保存大对象
     * @author 王心洋
     * @time 2018-01-03
     */
    public void saveLossRateList(@RequestBody RequestSaveLossRateListDto requestSaveLossRateListDto){
        lossRateListService.saveLossRateList(requestSaveLossRateListDto);
    }
}
