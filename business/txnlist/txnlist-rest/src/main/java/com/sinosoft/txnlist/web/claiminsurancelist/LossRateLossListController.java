package com.sinosoft.txnlist.web.claiminsurancelist;

import com.sinosoft.txnlist.api.claiminsurancelist.LossRateLossListApi;
import com.sinosoft.txnlist.core.claiminsurancelist.service.LossRateLossListService;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.LossRateLossListDto;
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
 * @description 定损清单农户标的清单表controller层
 */
@RestController
@RequestMapping(value = LossRateLossListController.PATH)
public class LossRateLossListController implements LossRateLossListApi {

    private static Logger LOGGER = LoggerFactory.getLogger(LossRateLossListController.class);

    @Autowired
    private LossRateLossListService lossRateLossListService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody LossRateLossListDto lossRateLossListDto) {
        lossRateLossListService.save(lossRateLossListDto);
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
        java.lang.Integer lossSerialNo = Integer.parseInt(map.get("lossSerialNo"));
        lossRateLossListService.remove(lossListCode,serialNo,fCode,itemCode,lossSerialNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody LossRateLossListDto lossRateLossListDto) {
        lossRateLossListService.modify(lossRateLossListDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public LossRateLossListDto queryByPK(@RequestBody Map<String,String> map) {
        String lossListCode = map.get("lossListCode");
        java.lang.Integer serialNo = Integer.parseInt(map.get("serialNo"));
        String fCode = map.get("fCode");
        String itemCode = map.get("itemCode");
        java.lang.Integer lossSerialNo = Integer.parseInt(map.get("lossSerialNo"));
        return lossRateLossListService.queryByPK(lossListCode,serialNo,fCode,itemCode,lossSerialNo);
    }
}
