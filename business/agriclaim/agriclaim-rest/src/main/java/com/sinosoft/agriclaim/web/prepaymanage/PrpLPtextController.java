package com.sinosoft.agriclaim.web.prepaymanage;

import com.sinosoft.agriclaim.api.prepaymanage.PrpLPtextApi;
import com.sinosoft.agriclaim.core.prepaymanage.service.PrpLPtextService;
import com.sinosoft.agriclaim.api.prepaymanage.dto.PrpLPtextDto;
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
 * @time  2017-11-08 05:44:02.119 
 * @description 预赔文字表controller层
 */
@RestController
@RequestMapping(value = PrpLPtextController.PATH)
public class PrpLPtextController implements PrpLPtextApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLPtextController.class);

    @Autowired
    private PrpLPtextService prpLPtextService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLPtextDto prpLPtextDto) {
        prpLPtextService.save(prpLPtextDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String preCompensateNo,java.lang.Double lineNo) {
        prpLPtextService.remove(preCompensateNo,lineNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLPtextDto prpLPtextDto) {
        prpLPtextService.modify(prpLPtextDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLPtextDto queryByPK(@RequestBody String preCompensateNo,java.lang.Double lineNo) {
        return prpLPtextService.queryByPK(preCompensateNo,lineNo);
    }
}
