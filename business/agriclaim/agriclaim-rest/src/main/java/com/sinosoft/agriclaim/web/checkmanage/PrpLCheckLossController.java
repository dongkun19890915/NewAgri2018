package com.sinosoft.agriclaim.web.checkmanage;

import com.sinosoft.agriclaim.api.checkmanage.PrpLCheckLossApi;
import com.sinosoft.agriclaim.core.checkmanage.service.PrpLCheckLossService;
import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLCheckLossDto;
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
 * @description 查勘事故估损金额表controller层
 */
@RestController
@RequestMapping(value = PrpLCheckLossController.PATH)
public class PrpLCheckLossController implements PrpLCheckLossApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLCheckLossController.class);

    @Autowired
    private PrpLCheckLossService prpLCheckLossService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLCheckLossDto prpLCheckLossDto) {
        prpLCheckLossService.save(prpLCheckLossDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String registNo,java.lang.Integer serialNo) {
        prpLCheckLossService.remove(registNo,serialNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLCheckLossDto prpLCheckLossDto) {
        prpLCheckLossService.modify(prpLCheckLossDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLCheckLossDto queryByPK(@RequestBody String registNo,java.lang.Integer serialNo) {
        return prpLCheckLossService.queryByPK(registNo,serialNo);
    }
}
