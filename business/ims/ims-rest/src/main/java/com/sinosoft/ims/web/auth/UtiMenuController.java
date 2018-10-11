package com.sinosoft.ims.web.auth;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.ims.api.auth.UtiMenuApi;
import com.sinosoft.ims.api.auth.dto.UtiMenuDto;
import com.sinosoft.ims.core.auth.service.UtiMenuService;
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
 * @description UtiMenucontroller层
 */
@RestController
@RequestMapping(value = UtiMenuController.PATH)
public class UtiMenuController implements UtiMenuApi {

    private static Logger LOGGER = LoggerFactory.getLogger(UtiMenuController.class);

    @Autowired
    private UtiMenuService utiMenuService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody UtiMenuDto utiMenuDto) {
        utiMenuService.save(utiMenuDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String menuId) {
        utiMenuService.remove(menuId);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody UtiMenuDto utiMenuDto) {
        utiMenuService.modify(utiMenuDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiMenuDto queryByPK(@RequestBody String menuId) {
        return utiMenuService.queryByPK(menuId);
    }
}
