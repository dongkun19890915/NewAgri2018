package com.sinosoft.dms.web.model;

import com.sinosoft.dms.api.model.PrpModelItemKindApi;
import com.sinosoft.dms.core.model.service.PrpModelItemKindService;
import com.sinosoft.dms.api.model.dto.PrpModelItemKindDto;
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
 * @time  2017-11-16 01:04:20.471 
 * @description 标的子险信息controller层
 */
@RestController
@RequestMapping(value = PrpModelItemKindController.PATH)
public class PrpModelItemKindController implements PrpModelItemKindApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpModelItemKindController.class);

    @Autowired
    private PrpModelItemKindService prpModelItemKindService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpModelItemKindDto prpModelItemKindDto) {
        prpModelItemKindService.save(prpModelItemKindDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String modelCode,Integer itemKindNo) {
        prpModelItemKindService.remove(modelCode,itemKindNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpModelItemKindDto prpModelItemKindDto) {
        prpModelItemKindService.modify(prpModelItemKindDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpModelItemKindDto queryByPK(@RequestBody String modelCode,Integer itemKindNo) {
        return prpModelItemKindService.queryByPK(modelCode,itemKindNo);
    }
}
