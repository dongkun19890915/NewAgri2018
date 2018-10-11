package com.sinosoft.txnlist.web.claiminsurancelist;

import com.sinosoft.txnlist.api.claiminsurancelist.LossRateHerdListApi;
import com.sinosoft.txnlist.core.claiminsurancelist.service.LossRateHerdListService;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.LossRateHerdListDto;
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
 * @description 定损清单农户标的明细表-物controller层
 */
@RestController
@RequestMapping(value = LossRateHerdListController.PATH)
public class LossRateHerdListController implements LossRateHerdListApi {

    private static Logger LOGGER = LoggerFactory.getLogger(LossRateHerdListController.class);

    @Autowired
    private LossRateHerdListService lossRateHerdListService;

    /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody LossRateHerdListDto lossRateHerdListDto) {
        lossRateHerdListService.save(lossRateHerdListDto);
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
        String earLabel = map.get("earLabel");
        lossRateHerdListService.remove(lossListCode,serialNo,fCode,itemCode,lossSerialNo,earLabel);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody LossRateHerdListDto lossRateHerdListDto) {
        lossRateHerdListService.modify(lossRateHerdListDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public LossRateHerdListDto queryByPK(@RequestBody Map<String,String> map) {
        String lossListCode = map.get("lossListCode");
        java.lang.Integer serialNo = Integer.parseInt(map.get("serialNo"));
        String fCode = map.get("fCode");
        String itemCode = map.get("itemCode");
        java.lang.Integer lossSerialNo = Integer.parseInt(map.get("lossSerialNo"));
        String earLabel = map.get("earLabel");
        return lossRateHerdListService.queryByPK(lossListCode,serialNo,fCode,itemCode,lossSerialNo,earLabel);
    }
}
