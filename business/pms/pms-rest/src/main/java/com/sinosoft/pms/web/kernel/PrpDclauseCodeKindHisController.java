package com.sinosoft.pms.web.kernel;

import com.sinosoft.pms.api.kernel.PrpDclauseCodeKindHisApi;
import com.sinosoft.pms.core.kernel.service.PrpDclauseCodeKindHisService;
import com.sinosoft.pms.api.kernel.dto.PrpDclauseCodeKindHisDto;
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
 * @time  2017-11-07 03:36:19.515 
 * @description 条款险别配置轨迹表controller层
 */
@RestController
@RequestMapping(value = PrpDclauseCodeKindHisController.PATH)
public class PrpDclauseCodeKindHisController implements PrpDclauseCodeKindHisApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PrpDclauseCodeKindHisController.class);

    @Autowired
    private PrpDclauseCodeKindHisService prpDclauseCodeKindHisService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody PrpDclauseCodeKindHisDto prpDclauseCodeKindHisDto) {
        prpDclauseCodeKindHisService.save(prpDclauseCodeKindHisDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String clauseCode,java.lang.Double serialNo,String kindCode,java.lang.Double indexNo) {
        prpDclauseCodeKindHisService.remove(clauseCode,serialNo,kindCode,indexNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody PrpDclauseCodeKindHisDto prpDclauseCodeKindHisDto) {
        prpDclauseCodeKindHisService.modify(prpDclauseCodeKindHisDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public PrpDclauseCodeKindHisDto queryByPK(@RequestBody String clauseCode,java.lang.Double serialNo,String kindCode,java.lang.Double indexNo) {
        return prpDclauseCodeKindHisService.queryByPK(clauseCode,serialNo,kindCode,indexNo);
    }
}
