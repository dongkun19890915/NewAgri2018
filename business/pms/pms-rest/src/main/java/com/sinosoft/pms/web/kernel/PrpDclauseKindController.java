package com.sinosoft.pms.web.kernel;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.pms.api.kernel.PrpDclauseKindApi;
import com.sinosoft.pms.api.kernel.dto.PrpDclauseKindDto;
import com.sinosoft.pms.core.kernel.service.PrpDclauseKindService;
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
 * @description 条款险别关系表controller层
 */
@RestController
@RequestMapping(value = PrpDclauseKindController.PATH)
public class PrpDclauseKindController implements PrpDclauseKindApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDclauseKindController.class);

    @Autowired
    private PrpDclauseKindService prpDclauseKindService;

   /**
     *@description 新增
     *@param
     */
   @Override
    public void save(@RequestBody PrpDclauseKindDto prpDclauseKindDto) {
        prpDclauseKindService.save(prpDclauseKindDto);
    }

    /**
     *@description 删除
     *@param
     */
    @Override
    public void remove(@RequestBody String riskCode,String clauseType,String kindCode,String relateKindCode) {
        prpDclauseKindService.remove(riskCode,clauseType,kindCode,relateKindCode);
    }
    /**
     *@description 修改
     *@param
     */
    @Override
    public void modify(@RequestBody PrpDclauseKindDto prpDclauseKindDto) {
        prpDclauseKindService.modify(prpDclauseKindDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    @Override
    public PrpDclauseKindDto queryByPK(@RequestBody String riskCode,String clauseType,String kindCode,String relateKindCode) {
        return prpDclauseKindService.queryByPK(riskCode,clauseType,kindCode,relateKindCode);
    }
}
