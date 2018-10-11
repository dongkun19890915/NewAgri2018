package com.sinosoft.agriclaim.web.businessutilmanage;

import com.sinosoft.agriclaim.api.businessutilmanage.PrpLEndorApi;
import com.sinosoft.agriclaim.core.businessutilmanage.service.PrpLEndorService;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLEndorDto;
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
 * @description 理赔冲减保额表controller层
 */
@RestController
@RequestMapping(value = PrpLEndorController.PATH)
public class PrpLEndorController implements PrpLEndorApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLEndorController.class);

    @Autowired
    private PrpLEndorService prpLEndorService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLEndorDto prpLEndorDto) {
        prpLEndorService.save(prpLEndorDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String compensateNo,String policyNo,String endorType) {
        prpLEndorService.remove(compensateNo,policyNo,endorType);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLEndorDto prpLEndorDto) {
        prpLEndorService.modify(prpLEndorDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLEndorDto queryByPK(@RequestBody String compensateNo,String policyNo,String endorType) {
        return prpLEndorService.queryByPK(compensateNo,policyNo,endorType);
    }
}
