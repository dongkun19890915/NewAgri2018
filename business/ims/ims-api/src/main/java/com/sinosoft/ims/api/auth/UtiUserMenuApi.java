package com.sinosoft.ims.api.auth;

import com.sinosoft.ims.IMSConstant;
import com.sinosoft.ims.api.auth.dto.UtiUserMenuDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 07:55:48.156 
 * @description 常用菜单信息表Api接口
 */
@FeignClient(name = IMSConstant.IMS_SERVICE_NAME, path = UtiUserMenuApi.PATH)
public interface UtiUserMenuApi {

    public static final String PATH = "utiUserMenu";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(UtiUserMenuDto utiUserMenuDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String userCode, Integer menuId, @RequestParam("comCode") String comCode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(UtiUserMenuDto utiUserMenuDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    UtiUserMenuDto queryByPK(String userCode, Integer menuId, @RequestParam("comCode") String comCode);
}