package com.sinosoft.pms.web.kernel;

import com.sinosoft.pms.api.kernel. PrpDclauseCodeHisApi;
import com.sinosoft.pms.core.kernel.service. PrpDclauseCodeHisService;
import com.sinosoft.pms.api.kernel.dto. PrpDclauseCodeHisDto;
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
 * @description 条款配置轨迹表主表controller层
 */
@RestController
@RequestMapping(value =  PrpDclauseCodeHisController.PATH)
public class  PrpDclauseCodeHisController implements  PrpDclauseCodeHisApi {

    private static Logger LOGGER = LoggerFactory.getLogger( PrpDclauseCodeHisController.class);

    @Autowired
    private  PrpDclauseCodeHisService  PrpDclauseCodeHisService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody  PrpDclauseCodeHisDto  PrpDclauseCodeHisDto) {
         PrpDclauseCodeHisService.save( PrpDclauseCodeHisDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String clauseCode,java.lang.Double indexNo) {
         PrpDclauseCodeHisService.remove(clauseCode,indexNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody  PrpDclauseCodeHisDto  PrpDclauseCodeHisDto) {
         PrpDclauseCodeHisService.modify( PrpDclauseCodeHisDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public  PrpDclauseCodeHisDto queryByPK(@RequestBody String clauseCode,java.lang.Double indexNo) {
        return  PrpDclauseCodeHisService.queryByPK(clauseCode,indexNo);
    }
}
