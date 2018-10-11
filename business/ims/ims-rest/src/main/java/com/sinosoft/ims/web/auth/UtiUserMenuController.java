package com.sinosoft.ims.web.auth;

import com.sinosoft.ims.api.auth.UtiUserMenuApi;
import com.sinosoft.ims.api.auth.dto.UtiUserMenuDto;
import com.sinosoft.ims.core.auth.service.UtiUserMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 07:55:48.156 
 * @description 常用菜单信息表controller层
 */
@RestController
@RequestMapping(value = UtiUserMenuController.PATH)
public class UtiUserMenuController implements UtiUserMenuApi {

    private static Logger LOGGER = LoggerFactory.getLogger(UtiUserMenuController.class);

    @Autowired
    private UtiUserMenuService utiUserMenuService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody UtiUserMenuDto utiUserMenuDto) {
        utiUserMenuService.save(utiUserMenuDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestParam("userCode") String userCode, @RequestParam("menuId") Integer menuId, @RequestParam("comCode") String comCode) {
        utiUserMenuService.remove(userCode, menuId, comCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody UtiUserMenuDto utiUserMenuDto) {
        utiUserMenuService.modify(utiUserMenuDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiUserMenuDto queryByPK(@RequestParam("userCode") String userCode, @RequestParam("menuId") Integer menuId, @RequestParam("comCode") String comCode) {
        return utiUserMenuService.queryByPK(userCode, menuId, comCode);
    }
}
