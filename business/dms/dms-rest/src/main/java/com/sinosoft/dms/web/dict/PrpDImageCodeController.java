package com.sinosoft.dms.web.dict;

import com.sinosoft.dms.api.dict.PrpDImageCodeApi;
import com.sinosoft.dms.core.dict.service.PrpDImageCodeService;
import com.sinosoft.dms.api.dict.dto.PrpDImageCodeDto;
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
 * @time  2017-11-27 03:00:47.370 
 * @description 承保理赔镜像代码表controller层
 */
@RestController
@RequestMapping(value = PrpDImageCodeController.PATH)
public class PrpDImageCodeController implements PrpDImageCodeApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDImageCodeController.class);

    @Autowired
    private PrpDImageCodeService prpDImageCodeService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpDImageCodeDto prpDImageCodeDto) {
        prpDImageCodeService.save(prpDImageCodeDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(String riskCode,String comCode) {
        prpDImageCodeService.remove(riskCode,comCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpDImageCodeDto prpDImageCodeDto) {
        prpDImageCodeService.modify(prpDImageCodeDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public @ResponseBody PrpDImageCodeDto queryByPK(String riskCode,String comCode) {
        return prpDImageCodeService.queryByPK(riskCode,comCode);
    }
}
