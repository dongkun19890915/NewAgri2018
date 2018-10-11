package com.sinosoft.dms.web.model;

import com.sinosoft.dms.api.model.PrpModelItemKindAgriApi;
import com.sinosoft.dms.core.model.service.PrpModelItemKindAgriService;
import com.sinosoft.dms.api.model.dto.PrpModelItemKindAgriDto;
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
 * @description 模板农险标的附加表controller层
 */
@RestController
@RequestMapping(value = PrpModelItemKindAgriController.PATH)
public class PrpModelItemKindAgriController implements PrpModelItemKindAgriApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpModelItemKindAgriController.class);

    @Autowired
    private PrpModelItemKindAgriService prpModelItemKindAgriService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpModelItemKindAgriDto prpModelItemKindAgriDto) {
        prpModelItemKindAgriService.save(prpModelItemKindAgriDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String modelCode,Integer itemKindNo,String kindCode,Integer times) {
        prpModelItemKindAgriService.remove(modelCode,itemKindNo,kindCode,times);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpModelItemKindAgriDto prpModelItemKindAgriDto) {
        prpModelItemKindAgriService.modify(prpModelItemKindAgriDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpModelItemKindAgriDto queryByPK(@RequestBody String modelCode,Integer itemKindNo,String kindCode,Integer times) {
        return prpModelItemKindAgriService.queryByPK(modelCode,itemKindNo,kindCode,times);
    }
}
