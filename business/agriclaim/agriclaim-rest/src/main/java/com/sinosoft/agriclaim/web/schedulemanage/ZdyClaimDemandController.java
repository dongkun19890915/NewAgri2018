package com.sinosoft.agriclaim.web.schedulemanage;

import com.sinosoft.agriclaim.api.schedulemanage.ZdyClaimDemandApi;
import com.sinosoft.agriclaim.core.schedulemanage.service.ZdyClaimDemandService;
import com.sinosoft.agriclaim.api.schedulemanage.dto.ZdyClaimDemandDto;
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
 * @time  2017-11-10 02:49:33.975 
 * @description 驻点员App案件推送日志表controller层
 */
@RestController
@RequestMapping(value = ZdyClaimDemandController.PATH)
public class ZdyClaimDemandController implements ZdyClaimDemandApi {

    private static Logger LOGGER = LoggerFactory.getLogger(ZdyClaimDemandController.class);

    @Autowired
    private ZdyClaimDemandService zdyClaimDemandService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody ZdyClaimDemandDto zdyClaimDemandDto) {
        zdyClaimDemandService.save(zdyClaimDemandDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String id) {
        zdyClaimDemandService.remove(id);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody ZdyClaimDemandDto zdyClaimDemandDto) {
        zdyClaimDemandService.modify(zdyClaimDemandDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public ZdyClaimDemandDto queryByPK(@RequestBody String id) {
        return zdyClaimDemandService.queryByPK(id);
    }
}
