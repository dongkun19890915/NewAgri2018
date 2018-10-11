package com.sinosoft.pms.web.kernel;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.pms.api.kernel.PrpDriskClauseKindApi;
import com.sinosoft.pms.api.kernel.dto.PrpDriskClauseKindDto;
import com.sinosoft.pms.core.kernel.service.PrpDriskClauseKindService;
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
 * @time  2017-11-04 10:42:46.546 
 * @description PrpDriskClauseKindcontroller层
 */
@RestController
@RequestMapping(value = PrpDriskClauseKindController.PATH)
public class PrpDriskClauseKindController implements PrpDriskClauseKindApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDriskClauseKindController.class);

    @Autowired
    private PrpDriskClauseKindService prpDriskClauseKindService;

   /**
     *@description 新增
     *@param
     */
   @Override
    public void save(@RequestBody PrpDriskClauseKindDto prpDriskClauseKindDto) {
        prpDriskClauseKindService.save(prpDriskClauseKindDto);
    }

    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(@RequestBody String riskCode,Integer riskKcSerialNo,String clauseCode) {
        prpDriskClauseKindService.remove(riskCode,riskKcSerialNo,clauseCode);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(@RequestBody PrpDriskClauseKindDto prpDriskClauseKindDto) {
        prpDriskClauseKindService.modify(prpDriskClauseKindDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpDriskClauseKindDto queryByPK(@RequestBody String riskCode,Integer riskKcSerialNo,String clauseCode) {
        return prpDriskClauseKindService.queryByPK(riskCode,riskKcSerialNo,clauseCode);
    }
}
