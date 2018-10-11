package com.sinosoft.agriclaim.web.checkmanage;

import com.sinosoft.agriclaim.api.checkmanage.PrpLAcciCheckApi;
import com.sinosoft.agriclaim.core.checkmanage.service.PrpLAcciCheckService;
import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLAcciCheckDto;
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
 * @description 意健险调查主表controller层
 */
@RestController
@RequestMapping(value = PrpLAcciCheckController.PATH)
public class PrpLAcciCheckController implements PrpLAcciCheckApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLAcciCheckController.class);

    @Autowired
    private PrpLAcciCheckService prpLAcciCheckService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLAcciCheckDto prpLAcciCheckDto) {
        prpLAcciCheckService.save(prpLAcciCheckDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String checkNo) {
        prpLAcciCheckService.remove(checkNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLAcciCheckDto prpLAcciCheckDto) {
        prpLAcciCheckService.modify(prpLAcciCheckDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLAcciCheckDto queryByPK(@RequestBody String checkNo) {
        return prpLAcciCheckService.queryByPK(checkNo);
    }
}
