package com.sinosoft.agriclaim.web.jobmanage;

import com.sinosoft.agriclaim.api.jobmanage.PrpLJobManagerTimeApi;
import com.sinosoft.agriclaim.core.jobmanage.service.PrpLJobManagerTimeService;
import com.sinosoft.agriclaim.api.jobmanage.dto.PrpLJobManagerTimeDto;
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
 * @time  2017-11-08 05:42:38.981 
 * @description 班表管理从表controller层
 */
@RestController
@RequestMapping(value = PrpLJobManagerTimeController.PATH)
public class PrpLJobManagerTimeController implements PrpLJobManagerTimeApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLJobManagerTimeController.class);

    @Autowired
    private PrpLJobManagerTimeService prpLJobManagerTimeService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLJobManagerTimeDto prpLJobManagerTimeDto) {
        prpLJobManagerTimeService.save(prpLJobManagerTimeDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String fid) {
        prpLJobManagerTimeService.remove(fid);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLJobManagerTimeDto prpLJobManagerTimeDto) {
        prpLJobManagerTimeService.modify(prpLJobManagerTimeDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLJobManagerTimeDto queryByPK(@RequestBody String fid) {
        return prpLJobManagerTimeService.queryByPK(fid);
    }
}
