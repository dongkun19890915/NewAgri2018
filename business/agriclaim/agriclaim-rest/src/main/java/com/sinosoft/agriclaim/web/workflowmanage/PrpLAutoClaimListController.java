package com.sinosoft.agriclaim.web.workflowmanage;

import com.sinosoft.agriclaim.api.workflowmanage.PrpLAutoClaimListApi;
import com.sinosoft.agriclaim.api.workflowmanage.dto.SwfLogDto;
import com.sinosoft.agriclaim.core.workflowmanage.service.PrpLAutoClaimListService;
import com.sinosoft.agriclaim.api.workflowmanage.dto.PrpLAutoClaimListDto;
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
 * @time  2018-01-23 10:17:47.442 
 * @description 自动理赔清单数据表controller层
 */
@RestController
@RequestMapping(value = PrpLAutoClaimListController.PATH)
public class PrpLAutoClaimListController implements PrpLAutoClaimListApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLAutoClaimListController.class);

    @Autowired
    private PrpLAutoClaimListService prpLAutoClaimListService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLAutoClaimListDto prpLAutoClaimListDto) {
        prpLAutoClaimListService.save(prpLAutoClaimListDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody Map<String,String> map) {
        String registNo = map.get("registNo");
        prpLAutoClaimListService.remove(registNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLAutoClaimListDto prpLAutoClaimListDto) {
        prpLAutoClaimListService.modify(prpLAutoClaimListDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLAutoClaimListDto queryByPK(@RequestBody Map<String,String> map) {
        String registNo = map.get("registNo");
        return prpLAutoClaimListService.queryByPK(registNo);
    }
    /**
     * 自动理算接口
     * @param swfLogDtoList 待处理自动理算任务案件集合
     * @author 王心洋
     * @time 2018-01-30
     */
    public void autoClaimList(@RequestBody List<SwfLogDto> swfLogDtoList) throws Exception{
        prpLAutoClaimListService.autoClaimList(swfLogDtoList);
    }
}
