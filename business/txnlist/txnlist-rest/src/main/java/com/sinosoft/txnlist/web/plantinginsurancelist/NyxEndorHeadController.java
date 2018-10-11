package com.sinosoft.txnlist.web.plantinginsurancelist;

import com.sinosoft.txnlist.api.plantinginsurancelist.NyxEndorHeadApi;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.NyxEndorHeadService;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.NyxEndorHeadDto;
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
 * @description nyxendorheadcontroller层
 */
@RestController
@RequestMapping(value = NyxEndorHeadController.PATH)
public class NyxEndorHeadController implements NyxEndorHeadApi {

    private static Logger LOGGER = LoggerFactory.getLogger(NyxEndorHeadController.class);

    @Autowired
    private NyxEndorHeadService nyxEndorHeadService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody NyxEndorHeadDto nyxEndorHeadDto) throws Exception{
        nyxEndorHeadService.save(nyxEndorHeadDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestParam String endorseNo) throws Exception{
        nyxEndorHeadService.remove(endorseNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody NyxEndorHeadDto nyxEndorHeadDto) {
        nyxEndorHeadService.modify(nyxEndorHeadDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public NyxEndorHeadDto queryByPK(@RequestParam String endorseNo) {
        return nyxEndorHeadService.queryByPK(endorseNo);
    }
}
