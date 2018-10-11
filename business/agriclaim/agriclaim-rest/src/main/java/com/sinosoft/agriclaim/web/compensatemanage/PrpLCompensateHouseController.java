package com.sinosoft.agriclaim.web.compensatemanage;

import com.sinosoft.agriclaim.api.compensatemanage.PrpLCompensateHouseApi;
import com.sinosoft.agriclaim.core.compensatemanage.service.PrpLCompensateHouseService;
import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCompensateHouseDto;
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
 * @time  2017-11-08 05:40:44.225 
 * @description 农房理赔身份证信息表controller层
 */
@RestController
@RequestMapping(value = PrpLCompensateHouseController.PATH)
public class PrpLCompensateHouseController implements PrpLCompensateHouseApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLCompensateHouseController.class);

    @Autowired
    private PrpLCompensateHouseService prpLCompensateHouseService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLCompensateHouseDto prpLCompensateHouseDto) {
        prpLCompensateHouseService.save(prpLCompensateHouseDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String idcard,String registNo,String nodeType,String businessNo) {
        prpLCompensateHouseService.remove(idcard,registNo,nodeType,businessNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLCompensateHouseDto prpLCompensateHouseDto) {
        prpLCompensateHouseService.modify(prpLCompensateHouseDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLCompensateHouseDto queryByPK(@RequestBody String idcard,String registNo,String nodeType,String businessNo) {
        return prpLCompensateHouseService.queryByPK(idcard,registNo,nodeType,businessNo);
    }
}
