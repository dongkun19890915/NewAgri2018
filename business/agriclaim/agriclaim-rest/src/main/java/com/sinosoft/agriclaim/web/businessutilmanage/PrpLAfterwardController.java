package com.sinosoft.agriclaim.web.businessutilmanage;

import com.sinosoft.agriclaim.api.businessutilmanage.PrpLAfterwardApi;
import com.sinosoft.agriclaim.core.businessutilmanage.service.PrpLAfterwardService;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLAfterwardDto;
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
 * @description 案后费用处理表controller层
 */
@RestController
@RequestMapping(value = PrpLAfterwardController.PATH)
public class PrpLAfterwardController implements PrpLAfterwardApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLAfterwardController.class);

    @Autowired
    private PrpLAfterwardService prpLAfterwardService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLAfterwardDto prpLAfterwardDto) {
        prpLAfterwardService.save(prpLAfterwardDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String claimNo,java.lang.Double serialNo) {
        prpLAfterwardService.remove(claimNo,serialNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLAfterwardDto prpLAfterwardDto) {
        prpLAfterwardService.modify(prpLAfterwardDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLAfterwardDto queryByPK(@RequestBody String claimNo,java.lang.Double serialNo) {
        return prpLAfterwardService.queryByPK(claimNo,serialNo);
    }
}
