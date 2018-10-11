package com.sinosoft.ims.api.auth;

import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.ims.IMSConstant;
import com.sinosoft.ims.api.auth.dto.MenuTreeDto;
import com.sinosoft.ims.api.kernel.dto.RequestLoginDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
  * 获取用户菜单信息
  * @Author: ldd
  * @Date: 2017/11/16 16:44
  */
@FeignClient(name = IMSConstant.IMS_SERVICE_NAME, path = ShowMenuApi.PATH)
public interface ShowMenuApi {

    public static final String PATH = "queryMenu";

    /**
     *  查询用户权限菜单信息
     * @author: ldd
     * @date: 2017/11/16 8:48
     * @param comCode 用户机构代码
     * @param userCode 用户代码
     * @param systemCode 系统代码
     * @return MenuTreeDto集合
     */
    @RequestMapping(value = "showMenu",method = {RequestMethod.POST})
    public @ResponseBody List<MenuTreeDto> queryUserMenu(@RequestBody Map<String,String> map) throws Exception;
}
