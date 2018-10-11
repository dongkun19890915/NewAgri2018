package com.sinosoft.ims.api.auth;

import com.sinosoft.ims.IMSConstant;
import com.sinosoft.ims.api.auth.dto.RequestUserMenuManageDto;
import com.sinosoft.ims.api.auth.dto.UtiUserMenuDto;
import com.sinosoft.ims.api.auth.dto.UtiUserMenuImageDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@FeignClient(name = IMSConstant.IMS_SERVICE_NAME, path = UserMenuManageApi.PATH)
public interface UserMenuManageApi {

    public static final String PATH = "userMenuManage";

    /**
     * 常用菜单查询：按照用户代码查询菜单列表
     * @author 王心洋
     * @time 2017-11-14
     * @modify 2018-01-16 添加系统标识字段 王心洋
     * @param map userCode 用户代码
     * @param map sysFlag 系统标识
     * @return utiUserMenuDtoList 用户菜单表信息集合
     */
    @RequestMapping(value = "queryUserMenuInfo",method = {RequestMethod.POST})
    List<UtiUserMenuDto> queryUserMenuInfo(@RequestBody Map<String,String> map) ;

    /**
     * 常用菜单保存
     * @author 王心洋
     * @time 2017-11-14
     * @param utiUserMenuDtos 常用菜单信息dto
     * @return responseDto 操作成功或失败
     */
    @RequestMapping(value = "saveUserMenu",method = {RequestMethod.POST})
    void saveUserMenu(@RequestBody List<UtiUserMenuDto> utiUserMenuDtos);

    /**
     * 常用菜单删除
     * @author 王心洋
     * @time 2017-11-14
     * @param requestUserMenuManageDto 用户代码，菜单编号集合封装集合
     * @return responseDto 操作成功或失败
     */
    @RequestMapping(value = "deleteUserMenuInfo",method = {RequestMethod.POST})
    void deleteUserMenuInfo(RequestUserMenuManageDto requestUserMenuManageDto);

    /**
     * 常用菜单图标查询
     * @author 王心洋
     * @time 2017-11-14
     * @modify 2018-01-16 添加系统标识字段 王心洋
     * @param map sysFlag 系统标识
     * @return utiUserMenuImageDtoList 用户菜单图标表信息集合
     */
    @RequestMapping(value = "queryUserMenuImage",method = {RequestMethod.POST})
    List<UtiUserMenuImageDto> queryUserMenuImage(@RequestBody Map<String,String> map);

}
