package com.sinosoft.agriclaim.web.jobmanage;

import com.sinosoft.agriclaim.api.jobmanage.PrpLJobLinkerApi;
import com.sinosoft.agriclaim.core.jobmanage.service.PrpLJobLinkerService;
import com.sinosoft.agriclaim.api.jobmanage.dto.PrpLJobLinkerDto;
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
 * @description 联系人controller层
 */
@RestController
@RequestMapping(value = PrpLJobLinkerController.PATH)
public class PrpLJobLinkerController implements PrpLJobLinkerApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLJobLinkerController.class);

    @Autowired
    private PrpLJobLinkerService prpLJobLinkerService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLJobLinkerDto prpLJobLinkerDto) {
        prpLJobLinkerService.save(prpLJobLinkerDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String staffId) {
        prpLJobLinkerService.remove(staffId);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLJobLinkerDto prpLJobLinkerDto) {
        prpLJobLinkerService.modify(prpLJobLinkerDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLJobLinkerDto queryByPK(@RequestBody String staffId) {
        return prpLJobLinkerService.queryByPK(staffId);
    }
}
