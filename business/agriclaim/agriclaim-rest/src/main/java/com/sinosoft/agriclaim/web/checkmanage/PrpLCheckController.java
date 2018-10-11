package com.sinosoft.agriclaim.web.checkmanage;

import com.sinosoft.agriclaim.api.checkmanage.PrpLCheckApi;
import com.sinosoft.agriclaim.core.checkmanage.service.PrpLCheckService;
import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLCheckDto;
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
 * @time  2017-11-08 05:38:49.324 
 * @description 查勘/代查勘信息表controller层
 */
@RestController
@RequestMapping(value = PrpLCheckController.PATH)
public class PrpLCheckController implements PrpLCheckApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLCheckController.class);

    @Autowired
    private PrpLCheckService prpLCheckService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLCheckDto prpLCheckDto) {
        prpLCheckService.save(prpLCheckDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String registNo,java.lang.Integer referSerialNo) {
        prpLCheckService.remove(registNo,referSerialNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLCheckDto prpLCheckDto) {
        prpLCheckService.modify(prpLCheckDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLCheckDto queryByPK(@RequestBody String registNo,java.lang.Integer referSerialNo) {
        return prpLCheckService.queryByPK(registNo,referSerialNo);
    }
}
