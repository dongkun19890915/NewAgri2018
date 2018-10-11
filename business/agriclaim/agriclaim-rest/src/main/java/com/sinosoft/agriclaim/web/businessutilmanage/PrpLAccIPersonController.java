package com.sinosoft.agriclaim.web.businessutilmanage;

import com.sinosoft.agriclaim.api.businessutilmanage.PrpLAccIPersonApi;
import com.sinosoft.agriclaim.core.businessutilmanage.service.PrpLAccIPersonService;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLAccIPersonDto;
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
 * @time  2017-11-08 05:35:28.283 
 * @description 索赔申请人信息表controller层
 */
@RestController
@RequestMapping(value = PrpLAccIPersonController.PATH)
public class PrpLAccIPersonController implements PrpLAccIPersonApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLAccIPersonController.class);

    @Autowired
    private PrpLAccIPersonService prpLAccIPersonService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLAccIPersonDto prpLAccIPersonDto) {
        prpLAccIPersonService.save(prpLAccIPersonDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String certiNo,String certiType,java.lang.Integer serialNo) {
        prpLAccIPersonService.remove(certiNo,certiType,serialNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLAccIPersonDto prpLAccIPersonDto) {
        prpLAccIPersonService.modify(prpLAccIPersonDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLAccIPersonDto queryByPK(@RequestBody String certiNo,String certiType,java.lang.Integer serialNo) {
        return prpLAccIPersonService.queryByPK(certiNo,certiType,serialNo);
    }
}
