package com.sinosoft.ims.web.auth;

import com.sinosoft.ims.api.auth.UtiUserMenuImageApi;
import com.sinosoft.ims.core.auth.service.UtiUserMenuImageService;
import com.sinosoft.ims.api.auth.dto.UtiUserMenuImageDto;
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
 * @time  2017-11-13 07:56:24.672 
 * @description 常用菜单图标信息表controller层
 */
@RestController
@RequestMapping(value = UtiUserMenuImageController.PATH)
public class UtiUserMenuImageController implements UtiUserMenuImageApi {

    private static Logger LOGGER = LoggerFactory.getLogger(UtiUserMenuImageController.class);

    @Autowired
    private UtiUserMenuImageService utiUserMenuImageService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody UtiUserMenuImageDto utiUserMenuImageDto) {
        utiUserMenuImageService.save(utiUserMenuImageDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestParam("imageId") String imageId) {
        utiUserMenuImageService.remove(imageId);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody UtiUserMenuImageDto utiUserMenuImageDto) {
        utiUserMenuImageService.modify(utiUserMenuImageDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiUserMenuImageDto queryByPK(@RequestParam("imageId") String imageId) {
        return utiUserMenuImageService.queryByPK(imageId);
    }
}
