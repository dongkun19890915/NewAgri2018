package com.sinosoft.agriclaim.web.checkmanage;

import com.sinosoft.agriclaim.api.checkmanage.PrpLverifyLossExtApi;
import com.sinosoft.agriclaim.core.checkmanage.service.PrpLverifyLossExtService;
import com.sinosoft.agriclaim.api.checkmanage.dto.PrpLverifyLossExtDto;
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
 * @description 处理意见表controller层
 */
@RestController
@RequestMapping(value = PrpLverifyLossExtController.PATH)
public class PrpLverifyLossExtController implements PrpLverifyLossExtApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLverifyLossExtController.class);

    @Autowired
    private PrpLverifyLossExtService prpLverifyLossExtService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLverifyLossExtDto prpLverifyLossExtDto) {
        prpLverifyLossExtService.save(prpLverifyLossExtDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String registNo) {
        prpLverifyLossExtService.remove(registNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLverifyLossExtDto prpLverifyLossExtDto) {
        prpLverifyLossExtService.modify(prpLverifyLossExtDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLverifyLossExtDto queryByPK(@RequestBody String registNo) {
        return prpLverifyLossExtService.queryByPK(registNo);
    }
}
