package com.sinosoft.agriclaim.web.registmanage;

import com.sinosoft.agriclaim.api.registmanage.PrpLRelatePersonApi;
import com.sinosoft.agriclaim.core.registmanage.service.PrpLRelatePersonService;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRelatePersonDto;
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
 * @time  2017-11-08 05:45:22.527 
 * @description 联系人表controller层
 */
@RestController
@RequestMapping(value = PrpLRelatePersonController.PATH)
public class PrpLRelatePersonController implements PrpLRelatePersonApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLRelatePersonController.class);

    @Autowired
    private PrpLRelatePersonService prpLRelatePersonService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLRelatePersonDto prpLRelatePersonDto) {
        prpLRelatePersonService.save(prpLRelatePersonDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String registNo,String personType,java.lang.Integer serialNo) {
        prpLRelatePersonService.remove(registNo,personType,serialNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLRelatePersonDto prpLRelatePersonDto) {
        prpLRelatePersonService.modify(prpLRelatePersonDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLRelatePersonDto queryByPK(@RequestBody String registNo,String personType,java.lang.Integer serialNo) {
        return prpLRelatePersonService.queryByPK(registNo,personType,serialNo);
    }
}
