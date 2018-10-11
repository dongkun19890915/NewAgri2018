package com.sinosoft.txnlist.web.plantinginsurancelist;

import com.sinosoft.txnlist.api.plantinginsurancelist.HerdEndorHeadApi;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.HerdEndorHeadService;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.HerdEndorHeadDto;
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
 * @time  2017-11-18 08:36:26.740 
 * @description 批改头表controller层
 */
@RestController
@RequestMapping(value = HerdEndorHeadController.PATH)
public class HerdEndorHeadController implements HerdEndorHeadApi {

    private static Logger LOGGER = LoggerFactory.getLogger(HerdEndorHeadController.class);

    @Autowired
    private HerdEndorHeadService herdEndorHeadService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody HerdEndorHeadDto herdEndorHeadDto) {
        herdEndorHeadService.save(herdEndorHeadDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestParam String endorseNo) {
        herdEndorHeadService.remove(endorseNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody HerdEndorHeadDto herdEndorHeadDto) {
        herdEndorHeadService.modify(herdEndorHeadDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public HerdEndorHeadDto queryByPK(@RequestParam String endorseNo) {
        return herdEndorHeadService.queryByPK(endorseNo);
    }
}
