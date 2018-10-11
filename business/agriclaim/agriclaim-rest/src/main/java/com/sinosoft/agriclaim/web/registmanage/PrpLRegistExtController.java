package com.sinosoft.agriclaim.web.registmanage;

import com.sinosoft.agriclaim.api.registmanage.PrpLRegistExtApi;
import com.sinosoft.agriclaim.core.registmanage.service.PrpLRegistExtService;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistExtDto;
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
 * @description 报案信息补充说明controller层
 */
@RestController
@RequestMapping(value = PrpLRegistExtController.PATH)
public class PrpLRegistExtController implements PrpLRegistExtApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLRegistExtController.class);

    @Autowired
    private PrpLRegistExtService prpLRegistExtService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLRegistExtDto prpLRegistExtDto) {
        prpLRegistExtService.save(prpLRegistExtDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String registNo,java.lang.Integer serialNo,String nodeType) {
        prpLRegistExtService.remove(registNo,serialNo,nodeType);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLRegistExtDto prpLRegistExtDto) {
        prpLRegistExtService.modify(prpLRegistExtDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLRegistExtDto queryByPK(@RequestBody String registNo,java.lang.Integer serialNo,String nodeType) {
        return prpLRegistExtService.queryByPK(registNo,serialNo,nodeType);
    }
}
