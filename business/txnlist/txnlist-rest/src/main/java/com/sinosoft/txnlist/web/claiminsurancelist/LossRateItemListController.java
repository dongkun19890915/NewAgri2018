package com.sinosoft.txnlist.web.claiminsurancelist;

import com.sinosoft.txnlist.api.claiminsurancelist.LossRateItemListApi;
import com.sinosoft.txnlist.core.claiminsurancelist.service.LossRateItemListService;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.LossRateItemListDto;
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
 * @time  2018-01-17 06:38:35.329 
 * @description 定损清单标的表controller层
 */
@RestController
@RequestMapping(value = LossRateItemListController.PATH)
public class LossRateItemListController implements LossRateItemListApi {

    private static Logger LOGGER = LoggerFactory.getLogger(LossRateItemListController.class);

    @Autowired
    private LossRateItemListService lossRateItemListService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody LossRateItemListDto lossRateItemListDto) {
        lossRateItemListService.save(lossRateItemListDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody Map<String,String> map) {
        String lossListCode = map.get("lossListCode");
        java.lang.Integer serialNo = Integer.parseInt(map.get("serialNo"));
        String fCode = map.get("fCode");
        String itemCode = map.get("itemCode");
        lossRateItemListService.remove(lossListCode,serialNo,fCode,itemCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody LossRateItemListDto lossRateItemListDto) {
        lossRateItemListService.modify(lossRateItemListDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public LossRateItemListDto queryByPK(@RequestBody Map<String,String> map) {
        String lossListCode = map.get("lossListCode");
        java.lang.Integer serialNo = Integer.parseInt(map.get("serialNo"));
        String fCode = map.get("fCode");
        String itemCode = map.get("itemCode");
        return lossRateItemListService.queryByPK(lossListCode,serialNo,fCode,itemCode);
    }
}
