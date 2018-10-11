package com.sinosoft.txnlist.web.plantinginsurancelist;

import com.sinosoft.txnlist.api.plantinginsurancelist.SettleMainListApi;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.RegisterCoderDto;
import com.sinosoft.txnlist.core.plantinginsurancelist.service.SettleMainListService;
import com.sinosoft.txnlist.api.plantinginsurancelist.dto.SettleMainListDto;
import com.sinosoft.framework.dto.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-18 08:36:26.740 
 * @description settlemainlistcontroller层
 */
@RestController
@RequestMapping(value = SettleMainListController.PATH)
public class SettleMainListController implements SettleMainListApi {

    private static Logger LOGGER = LoggerFactory.getLogger(SettleMainListController.class);

    @Autowired
    private SettleMainListService settleMainListService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody SettleMainListDto settleMainListDto) {
        settleMainListService.save(settleMainListDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String settleListCode) {
        settleMainListService.remove(settleListCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody SettleMainListDto settleMainListDto) {
        settleMainListService.modify(settleMainListDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public SettleMainListDto queryByPK(@RequestBody String settleListCode) {
        return settleMainListService.queryByPK(settleListCode);
    }

    @Override
    public List<SettleMainListDto> queryByCondition(@RequestBody Map<String, String> map) throws Exception {
        return settleMainListService.findByCondition(map.get("policyNo"),map.get("valiDity"));
    }
    /**
     *@description 查询实体
     *@param registerCoder
     *@author 马俊玲
     */
    @Override
    public @ResponseBody List<SettleMainListDto> queryByRegisterCode(@RequestBody Map<String,String> listMap) {
        String registerCoder=listMap.get("registerCode");
        return settleMainListService.findByRegisterCode(registerCoder);
    }
    /**
     *@description 查询实体
     *@param registerCoder
     *@author 马俊玲
     */
    @Override
    public @ResponseBody List<SettleMainListDto> queryByRegisterCodeAndValidity(@RequestBody RegisterCoderDto registerCoderDto) {
        return settleMainListService.queryByRegisterCodeAndValidity(registerCoderDto);
    }

}
