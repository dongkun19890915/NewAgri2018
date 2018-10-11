package com.sinosoft.agriclaim.web.checkmanage;

import com.sinosoft.agriclaim.api.checkmanage.PrpLAcciCheckTextApi;
import com.sinosoft.agriclaim.core.checkmanage.service.PrpLAcciCheckTextService;
import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLAcciCheckTextDto;
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
 * @description 调查文本信息表controller层
 */
@RestController
@RequestMapping(value = PrpLAcciCheckTextController.PATH)
public class PrpLAcciCheckTextController implements PrpLAcciCheckTextApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLAcciCheckTextController.class);

    @Autowired
    private PrpLAcciCheckTextService prpLAcciCheckTextService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLAcciCheckTextDto prpLAcciCheckTextDto) {
        prpLAcciCheckTextService.save(prpLAcciCheckTextDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String checkNo,String textType,java.lang.Integer lineNo) {
        prpLAcciCheckTextService.remove(checkNo,textType,lineNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLAcciCheckTextDto prpLAcciCheckTextDto) {
        prpLAcciCheckTextService.modify(prpLAcciCheckTextDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLAcciCheckTextDto queryByPK(@RequestBody String checkNo,String textType,java.lang.Integer lineNo) {
        return prpLAcciCheckTextService.queryByPK(checkNo,textType,lineNo);
    }
}
