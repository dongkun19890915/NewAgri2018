package com.sinosoft.agriclaim.web.checkmanage;

import com.sinosoft.agriclaim.api.checkmanage.PrpLCheckExtApi;
import com.sinosoft.agriclaim.core.checkmanage.service.PrpLCheckExtService;
import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLCheckExtDto;
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
 * @description 查勘/代查勘扩展表controller层
 */
@RestController
@RequestMapping(value = PrpLCheckExtController.PATH)
public class PrpLCheckExtController implements PrpLCheckExtApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLCheckExtController.class);

    @Autowired
    private PrpLCheckExtService prpLCheckExtService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLCheckExtDto prpLCheckExtDto) {
        prpLCheckExtService.save(prpLCheckExtDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String registNo,java.lang.Integer serialNo,String columnName,java.lang.Integer referSerialNo) {
        prpLCheckExtService.remove(registNo,serialNo,columnName,referSerialNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLCheckExtDto prpLCheckExtDto) {
        prpLCheckExtService.modify(prpLCheckExtDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLCheckExtDto queryByPK(@RequestBody String registNo,java.lang.Integer serialNo,String columnName,java.lang.Integer referSerialNo) {
        return prpLCheckExtService.queryByPK(registNo,serialNo,columnName,referSerialNo);
    }
}
