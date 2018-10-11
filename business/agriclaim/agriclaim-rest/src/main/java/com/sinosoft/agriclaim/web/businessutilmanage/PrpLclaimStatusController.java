package com.sinosoft.agriclaim.web.businessutilmanage;

import com.sinosoft.agriclaim.api.businessutilmanage.PrpLclaimStatusApi;
import com.sinosoft.agriclaim.core.businessutilmanage.service.PrpLclaimStatusService;
import com.sinosoft.agriclaim.api.businessutilmanage.dto.PrpLclaimStatusDto;
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
 * @time  2017-11-08 05:35:28.283 
 * @description 理赔节点状态表controller层
 */
@RestController
@RequestMapping(value = PrpLclaimStatusController.PATH)
public class PrpLclaimStatusController implements PrpLclaimStatusApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpLclaimStatusController.class);

    @Autowired
    private PrpLclaimStatusService prpLclaimStatusService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpLclaimStatusDto prpLclaimStatusDto) {
        prpLclaimStatusService.save(prpLclaimStatusDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String businessno,String nodetype,java.lang.Integer serialno) {
        prpLclaimStatusService.remove(businessno,nodetype,serialno);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpLclaimStatusDto prpLclaimStatusDto) {
        prpLclaimStatusService.modify(prpLclaimStatusDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpLclaimStatusDto queryByPK(@RequestBody String businessno,String nodetype,java.lang.Integer serialno) {
        return prpLclaimStatusService.queryByPK(businessno,nodetype,serialno);
    }
}
