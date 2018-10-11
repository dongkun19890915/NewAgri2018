package com.sinosoft.agriclaim.web.docmanage;

import com.sinosoft.agriclaim.api.docmanage.PrpLCertifyCollectApi;
import com.sinosoft.agriclaim.core.docmanage.service.PrpLCertifyCollectService;
import com.sinosoft.agriclaim.api.docmanage.dto.PrpLCertifyCollectDto;
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
 * @time  2017-11-08 05:41:23.407 
 * @description 单证收集表controller层
 */
@RestController
@RequestMapping(value = PrpLCertifyCollectController.PATH)
public class PrpLCertifyCollectController implements PrpLCertifyCollectApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLCertifyCollectController.class);

    @Autowired
    private PrpLCertifyCollectService prpLCertifyCollectService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLCertifyCollectDto prpLCertifyCollectDto) {
        prpLCertifyCollectService.save(prpLCertifyCollectDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestParam("businessNo") String businessNo, @RequestParam("lossItemCode")String lossItemCode) {
        prpLCertifyCollectService.remove(businessNo,lossItemCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLCertifyCollectDto prpLCertifyCollectDto) {
        prpLCertifyCollectService.modify(prpLCertifyCollectDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLCertifyCollectDto queryByPK(@RequestParam("businessNo") String businessNo, @RequestParam("lossItemCode")String lossItemCode) {
        return prpLCertifyCollectService.queryByPK(businessNo,lossItemCode);
    }
}
