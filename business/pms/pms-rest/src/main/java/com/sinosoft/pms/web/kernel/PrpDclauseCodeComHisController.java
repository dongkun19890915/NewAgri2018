package com.sinosoft.pms.web.kernel;

import com.sinosoft.pms.api.kernel. PrpDclauseCodeComHisApi;
import com.sinosoft.pms.core.kernel.service. PrpDclauseCodeComHisService;
import com.sinosoft.pms.api.kernel.dto. PrpDclauseCodeComHisDto;
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
 * @description 条款机构配置轨迹表controller层
 */
@RestController
@RequestMapping(value =  PrpDclauseCodeComHisController.PATH)
public class  PrpDclauseCodeComHisController implements  PrpDclauseCodeComHisApi {

    private static Logger LOGGER = LoggerFactory.getLogger( PrpDclauseCodeComHisController.class);

    @Autowired
    private  PrpDclauseCodeComHisService  PrpDclauseCodeComHisService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody  PrpDclauseCodeComHisDto  PrpDclauseCodeComHisDto) {
         PrpDclauseCodeComHisService.save( PrpDclauseCodeComHisDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String clauseCode,String comCode,java.lang.Double indexNo) {
         PrpDclauseCodeComHisService.remove(clauseCode,comCode,indexNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody  PrpDclauseCodeComHisDto  PrpDclauseCodeComHisDto) {
         PrpDclauseCodeComHisService.modify( PrpDclauseCodeComHisDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public  PrpDclauseCodeComHisDto queryByPK(@RequestBody String clauseCode,String comCode,java.lang.Double indexNo) {
        return  PrpDclauseCodeComHisService.queryByPK(clauseCode,comCode,indexNo);
    }
}
