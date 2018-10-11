package com.sinosoft.agriclaim.web.checkmanage;

import com.sinosoft.agriclaim.api.checkmanage.PrpLverifyLossItemApi;
import com.sinosoft.agriclaim.core.checkmanage.service.PrpLverifyLossItemService;
import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLverifyLossItemDto;
import com.sinosoft.framework.dto.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-17 08:28:31.346 
 * @description 核损明细表controller层
 */
@RestController
@RequestMapping(value = PrpLverifyLossItemController.PATH)
public class PrpLverifyLossItemController implements PrpLverifyLossItemApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLverifyLossItemController.class);

    @Autowired
    private PrpLverifyLossItemService prpLverifyLossItemService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLverifyLossItemDto prpLverifyLossItemDto) {
        prpLverifyLossItemService.save(prpLverifyLossItemDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String registNo,String policyNo) {
        prpLverifyLossItemService.remove(registNo,policyNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLverifyLossItemDto prpLverifyLossItemDto) {
        prpLverifyLossItemService.modify(prpLverifyLossItemDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLverifyLossItemDto queryByPK(@RequestBody String registNo,String policyNo) {
        return prpLverifyLossItemService.queryByPK(registNo,policyNo);
    }
}
