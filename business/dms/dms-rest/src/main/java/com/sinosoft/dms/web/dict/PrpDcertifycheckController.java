package com.sinosoft.dms.web.dict;

import com.sinosoft.dms.api.dict.PrpDcertifycheckApi;
import com.sinosoft.dms.core.dict.service.PrpDcertifycheckService;
import com.sinosoft.dms.api.dict.dto.PrpDcertifycheckDto;
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
 * @time  2017-12-04 09:05:54.250 
 * @description 单证校验信息表controller层
 */
@RestController
@RequestMapping(value = PrpDcertifycheckController.PATH)
public class PrpDcertifycheckController implements PrpDcertifycheckApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDcertifycheckController.class);

    @Autowired
    private PrpDcertifycheckService prpDcertifycheckService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpDcertifycheckDto prpDcertifycheckDto) {
        prpDcertifycheckService.save(prpDcertifycheckDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String riskCode,String nodeType,String certifyType) {
        prpDcertifycheckService.remove(riskCode,nodeType,certifyType);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpDcertifycheckDto prpDcertifycheckDto) {
        prpDcertifycheckService.modify(prpDcertifycheckDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDcertifycheckDto queryByPK(@RequestBody String riskCode,String nodeType,String certifyType) {
        return prpDcertifycheckService.queryByPK(riskCode,nodeType,certifyType);
    }
}
