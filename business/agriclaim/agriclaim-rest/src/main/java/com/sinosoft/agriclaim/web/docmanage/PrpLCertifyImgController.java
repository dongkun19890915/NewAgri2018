package com.sinosoft.agriclaim.web.docmanage;

import com.sinosoft.agriclaim.api.docmanage.PrpLCertifyImgApi;
import com.sinosoft.agriclaim.core.docmanage.service.PrpLCertifyImgService;
import com.sinosoft.agriclaim.api.docmanage.dto.PrpLCertifyImgDto;
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
 * @description 单证及影像表controller层
 */
@RestController
@RequestMapping(value = PrpLCertifyImgController.PATH)
public class PrpLCertifyImgController implements PrpLCertifyImgApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLCertifyImgController.class);

    @Autowired
    private PrpLCertifyImgService prpLCertifyImgService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLCertifyImgDto prpLCertifyImgDto) {
        prpLCertifyImgService.save(prpLCertifyImgDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String businessNo,java.lang.Double serialNo,String lossItemCode) {
        prpLCertifyImgService.remove(businessNo,serialNo,lossItemCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLCertifyImgDto prpLCertifyImgDto) {
        prpLCertifyImgService.modify(prpLCertifyImgDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLCertifyImgDto queryByPK(@RequestBody String businessNo,java.lang.Double serialNo,String lossItemCode) {
        return prpLCertifyImgService.queryByPK(businessNo,serialNo,lossItemCode);
    }
}
