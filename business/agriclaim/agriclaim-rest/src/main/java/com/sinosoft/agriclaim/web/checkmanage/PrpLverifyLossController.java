package com.sinosoft.agriclaim.web.checkmanage;

import com.sinosoft.agriclaim.api.checkmanage.PrpLverifyLossApi;
import com.sinosoft.agriclaim.core.checkmanage.service.PrpLverifyLossService;
import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLverifyLossDto;
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
 * @time  2017-11-17 08:28:31.346 
 * @description 定核损主表controller层
 */
@RestController
@RequestMapping(value = PrpLverifyLossController.PATH)
public class PrpLverifyLossController implements PrpLverifyLossApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLverifyLossController.class);

    @Autowired
    private PrpLverifyLossService prpLverifyLossService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLverifyLossDto prpLverifyLossDto) {
        prpLverifyLossService.save(prpLverifyLossDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String registNo,String lossItemCode) {
        prpLverifyLossService.remove(registNo,lossItemCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLverifyLossDto prpLverifyLossDto) {
        prpLverifyLossService.modify(prpLverifyLossDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLverifyLossDto queryByPK(@RequestBody String registNo,String lossItemCode) {
        return prpLverifyLossService.queryByPK(registNo,lossItemCode);
    }
}
