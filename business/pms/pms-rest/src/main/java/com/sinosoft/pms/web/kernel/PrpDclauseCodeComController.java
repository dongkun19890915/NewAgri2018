package com.sinosoft.pms.web.kernel;

import com.sinosoft.pms.api.kernel. PrpDclauseCodeComApi;
import com.sinosoft.pms.core.kernel.service. PrpDclauseCodeComService;
import com.sinosoft.pms.api.kernel.dto. PrpDclauseCodeComDto;
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
 * @description 条款机构配置表controller层
 */
@RestController
@RequestMapping(value =  PrpDclauseCodeComController.PATH)
public class  PrpDclauseCodeComController implements  PrpDclauseCodeComApi {

    private static Logger LOGGER = LoggerFactory.getLogger( PrpDclauseCodeComController.class);

    @Autowired
    private  PrpDclauseCodeComService  PrpDclauseCodeComService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody  PrpDclauseCodeComDto  PrpDclauseCodeComDto) {
         PrpDclauseCodeComService.save( PrpDclauseCodeComDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String clauseCode,String comCode,String comName) {
         PrpDclauseCodeComService.remove(clauseCode,comCode,comName);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody  PrpDclauseCodeComDto  PrpDclauseCodeComDto) {
         PrpDclauseCodeComService.modify( PrpDclauseCodeComDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public  PrpDclauseCodeComDto queryByPK(@RequestBody String clauseCode,String comCode,String comName) {
        return  PrpDclauseCodeComService.queryByPK(clauseCode,comCode,comName);
    }
}
