package com.sinosoft.dms.web.dict;

import com.sinosoft.dms.api.dict.PrpMaxUseApi;
import com.sinosoft.dms.api.dict.dto.PrpMaxUseDto;
import com.sinosoft.dms.core.dict.service.PrpMaxUseService;
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
 * @time  2017-11-05 01:02:29.563 
 * @description PrpMaxUsecontroller层
 */
@RestController
@RequestMapping(value = PrpMaxUseController.PATH)
public class PrpMaxUseController implements PrpMaxUseApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpMaxUseController.class);

    @Autowired
    private PrpMaxUseService prpMaxUseService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpMaxUseDto prpMaxUseDto) {
        prpMaxUseService.save(prpMaxUseDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestParam("groupNo") String groupNo,@RequestParam("tableName") String tableName,@RequestParam("maxNo") String maxNo) {
        prpMaxUseService.remove(groupNo,tableName,maxNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpMaxUseDto prpMaxUseDto) {
        prpMaxUseService.modify(prpMaxUseDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpMaxUseDto queryByPK(@RequestParam("groupNo") String groupNo,@RequestParam("tableName") String tableName,@RequestParam("maxNo") String maxNo) {
        return prpMaxUseService.queryByPK(groupNo,tableName,maxNo);
    }
}
