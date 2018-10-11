package com.sinosoft.ims.web.auth;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.UtiSolvencyApi;
import com.sinosoft.ims.api.auth.dto.UtiSolvencyDto;
import com.sinosoft.ims.core.auth.service.UtiSolvencyService;
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
 * @time  2017-11-05 01:10:45.148 
 * @description UtiSolvencycontroller层
 */
@RestController
@RequestMapping(value = UtiSolvencyController.PATH)
public class UtiSolvencyController implements UtiSolvencyApi {

    private static Logger LOGGER = LoggerFactory.getLogger(UtiSolvencyController.class);

    @Autowired
    private UtiSolvencyService utiSolvencyService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody UtiSolvencyDto utiSolvencyDto) {
        utiSolvencyService.save(utiSolvencyDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody java.util.Date id) {
        utiSolvencyService.remove(id);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody UtiSolvencyDto utiSolvencyDto) {
        utiSolvencyService.modify(utiSolvencyDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiSolvencyDto queryByPK(@RequestBody java.util.Date id) {
        return utiSolvencyService.queryByPK(id);
    }
}
