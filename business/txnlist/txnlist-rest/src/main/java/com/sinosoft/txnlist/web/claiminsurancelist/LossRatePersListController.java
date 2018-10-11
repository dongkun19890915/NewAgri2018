package com.sinosoft.txnlist.web.claiminsurancelist;

import com.sinosoft.txnlist.api.claiminsurancelist.LossRatePersListApi;
import com.sinosoft.txnlist.core.claiminsurancelist.service.LossRatePersListService;
import com.sinosoft.txnlist.api.claiminsurancelist.dto.LossRatePersListDto;
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
 * @description 定损清单农户标的明细表-人controller层
 */
@RestController
@RequestMapping(value = LossRatePersListController.PATH)
public class LossRatePersListController implements LossRatePersListApi {

    private static Logger LOGGER = LoggerFactory.getLogger(LossRatePersListController.class);

    @Autowired
    private LossRatePersListService lossRatePersListService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody LossRatePersListDto lossRatePersListDto) {
        lossRatePersListService.save(lossRatePersListDto);
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
        String idCard = map.get("idCard");
        lossRatePersListService.remove(lossListCode,serialNo,fCode,itemCode,lossSerialNo,idCard);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody LossRatePersListDto lossRatePersListDto) {
        lossRatePersListService.modify(lossRatePersListDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public LossRatePersListDto queryByPK(@RequestBody Map<String,String> map) {
        String lossListCode = map.get("lossListCode");
        java.lang.Integer serialNo = Integer.parseInt(map.get("serialNo"));
        String fCode = map.get("fCode");
        String itemCode = map.get("itemCode");
        java.lang.Integer lossSerialNo = Integer.parseInt(map.get("lossSerialNo"));
        String idCard = map.get("idCard");
        return lossRatePersListService.queryByPK(lossListCode,serialNo,fCode,itemCode,lossSerialNo,idCard);
    }
}
