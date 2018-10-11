package com.sinosoft.ims.web.kernel;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.kernel.PrpDuserSubApi;
import com.sinosoft.ims.api.kernel.dto.PrpDuserSubDto;
import com.sinosoft.ims.core.kernel.service.PrpDuserSubService;
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
 * @time  2017-11-05 01:10:12.703 
 * @description 员工附加信息表controller层
 */
@RestController
@RequestMapping(value = PrpDuserSubController.PATH)
public class PrpDuserSubController implements PrpDuserSubApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDuserSubController.class);

    @Autowired
    private PrpDuserSubService prpDuserSubService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpDuserSubDto prpDuserSubDto) {
        prpDuserSubService.save(prpDuserSubDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String userCode) {
        prpDuserSubService.remove(userCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpDuserSubDto prpDuserSubDto) {
        prpDuserSubService.modify(prpDuserSubDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDuserSubDto queryByPK(@RequestBody String userCode) {
        return prpDuserSubService.queryByPK(userCode);
    }
}
