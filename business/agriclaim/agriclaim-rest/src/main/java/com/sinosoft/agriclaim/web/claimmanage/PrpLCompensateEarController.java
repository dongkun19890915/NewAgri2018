package com.sinosoft.agriclaim.web.claimmanage;

import com.sinosoft.agriclaim.api.claimmanage.PrpLCompensateEarApi;
import com.sinosoft.agriclaim.core.claimmanage.service.PrpLCompensateEarService;
import com.sinosoft.agriclaim.api.claimmanage.dto.PrpLCompensateEarDto;
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
 * @time  2017-11-08 05:39:53.061 
 * @description 理赔分户清单表controller层
 */
@RestController
@RequestMapping(value = PrpLCompensateEarController.PATH)
public class PrpLCompensateEarController implements PrpLCompensateEarApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLCompensateEarController.class);

    @Autowired
    private PrpLCompensateEarService prpLCompensateEarService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLCompensateEarDto prpLCompensateEarDto) {
        prpLCompensateEarService.save(prpLCompensateEarDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String earNo,String registNo,String nodeType,String businessNo) {
        prpLCompensateEarService.remove(earNo,registNo,nodeType,businessNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLCompensateEarDto prpLCompensateEarDto) {
        prpLCompensateEarService.modify(prpLCompensateEarDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLCompensateEarDto queryByPK(@RequestBody String earNo,String registNo,String nodeType,String businessNo) {
        return prpLCompensateEarService.queryByPK(earNo,registNo,nodeType,businessNo);
    }
}
