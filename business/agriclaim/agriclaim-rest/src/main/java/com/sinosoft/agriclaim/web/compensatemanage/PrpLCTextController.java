package com.sinosoft.agriclaim.web.compensatemanage;

import com.sinosoft.agriclaim.api.compensatemanage.PrpLCTextApi;
import com.sinosoft.agriclaim.core.compensatemanage.service.PrpLCTextService;
import com.sinosoft.agriclaim.api.compensatemanage.dto.PrpLCTextDto;
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
 * @description 赔款计算文字表controller层
 */
@RestController
@RequestMapping(value = PrpLCTextController.PATH)
public class PrpLCTextController implements PrpLCTextApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLCTextController.class);

    @Autowired
    private PrpLCTextService prpLCTextService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLCTextDto prpLCTextDto) {
        prpLCTextService.save(prpLCTextDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String compensateNo,String textType,java.lang.Integer lineNo) {
        prpLCTextService.remove(compensateNo,textType,lineNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLCTextDto prpLCTextDto) {
        prpLCTextService.modify(prpLCTextDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLCTextDto queryByPK(@RequestBody String compensateNo,String textType,java.lang.Integer lineNo) {
        return prpLCTextService.queryByPK(compensateNo,textType,lineNo);
    }
}
