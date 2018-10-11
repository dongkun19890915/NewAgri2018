package com.sinosoft.agriclaim.web.checkmanage;

import com.sinosoft.agriclaim.api.checkmanage.PrplQualityCheckApi;
import com.sinosoft.agriclaim.core.checkmanage.service.PrplQualityCheckService;
import com.sinosoft.agriclaim.api.checkmanage.dto.PrplQualityCheckDto;
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
 * @time  2017-11-10 02:44:49.773 
 * @description 质量评审内容表controller层
 */
@RestController
@RequestMapping(value = PrplQualityCheckController.PATH)
public class PrplQualityCheckController implements PrplQualityCheckApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrplQualityCheckController.class);

    @Autowired
    private PrplQualityCheckService prplQualityCheckService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrplQualityCheckDto prplQualityCheckDto) {
        prplQualityCheckService.save(prplQualityCheckDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String registNo,String qualityCheckType,java.lang.Integer serialNo) {
        prplQualityCheckService.remove(registNo,qualityCheckType,serialNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrplQualityCheckDto prplQualityCheckDto) {
        prplQualityCheckService.modify(prplQualityCheckDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrplQualityCheckDto queryByPK(@RequestBody String registNo,String qualityCheckType,java.lang.Integer serialNo) {
        return prplQualityCheckService.queryByPK(registNo,qualityCheckType,serialNo);
    }
}
