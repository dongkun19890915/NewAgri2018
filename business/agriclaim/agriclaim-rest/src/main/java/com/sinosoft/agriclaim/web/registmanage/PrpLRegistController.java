package com.sinosoft.agriclaim.web.registmanage;

import com.sinosoft.agriclaim.api.registmanage.PrpLRegistApi;
import com.sinosoft.agriclaim.core.registmanage.service.PrpLRegistService;
import com.sinosoft.agriclaim.api.registmanage.dto.PrpLRegistDto;
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
 * @description 报案信息表controller层
 */
@RestController
@RequestMapping(value = PrpLRegistController.PATH)
public class PrpLRegistController implements PrpLRegistApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLRegistController.class);

    @Autowired
    private PrpLRegistService prpLRegistService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLRegistDto prpLRegistDto) {
        prpLRegistService.save(prpLRegistDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String registNo) {
        prpLRegistService.remove(registNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLRegistDto prpLRegistDto) {
        prpLRegistService.modify(prpLRegistDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLRegistDto queryByPK(@RequestBody String registNo) {
        return prpLRegistService.queryByPK(registNo);
    }
}
