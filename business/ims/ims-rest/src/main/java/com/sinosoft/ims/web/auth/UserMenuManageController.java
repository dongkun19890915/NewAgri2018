package com.sinosoft.ims.web.auth;

import com.sinosoft.ims.api.auth.UserMenuManageApi;
import com.sinosoft.ims.api.auth.dto.RequestUserMenuManageDto;
import com.sinosoft.ims.api.auth.dto.UtiUserMenuDto;
import com.sinosoft.ims.api.auth.dto.UtiUserMenuImageDto;
import com.sinosoft.ims.core.auth.service.UserMenuManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = UserMenuManageController.PATH)
public class UserMenuManageController implements UserMenuManageApi {

    private static Logger LOGGER = LoggerFactory.getLogger(UtiUserMenuController.class);

    @Autowired
    private UserMenuManageService userMenuManageService;

    /**
     * 常用菜单查询：按照用户代码查询菜单列表
     * @author 王心洋
     * @time 2017-11-14
     * @modify 2018-01-16 添加系统标识字段 王心洋
     * @param map userCode 用户代码
     * @param map sysFlag 系统标识
     * @return utiUserMenuDtoList 用户菜单表信息集合
     */
    @Override
    public List<UtiUserMenuDto> queryUserMenuInfo(@RequestBody Map<String,String> map) {
        String userCode = map.get("userCode");
        String sysFlag = map.get("sysFlag");
        String comCode = map.get("comCode");
        return userMenuManageService.queryUserMenuInfo(userCode, sysFlag, comCode);
    }

    /**
     * 常用菜单保存
     * @author 王心洋
     * @time 2017-11-14
     * @param utiUserMenuDtos 常用菜单信息dto
     * @return responseDto 操作成功或失败
     */
    @Override
    public void saveUserMenu(@RequestBody List<UtiUserMenuDto> utiUserMenuDtos) {
        userMenuManageService.saveUserMenu(utiUserMenuDtos);
    }

    /**
     * 常用菜单删除
     * @author 王心洋
     * @time 2017-11-14
     * @param requestUserMenuManageDto 用户代码，菜单编号集合封装集合
     * @return responseDto 操作成功或失败
     */
    @Override
    public void deleteUserMenuInfo(@RequestBody RequestUserMenuManageDto requestUserMenuManageDto) {
        userMenuManageService.deleteUserMenuInfo(requestUserMenuManageDto.getUserCode(),
                requestUserMenuManageDto.getMenuCName(), requestUserMenuManageDto.getComCode());
    }

    /**
     * 常用菜单图标查询
     * @author 王心洋
     * @time 2017-11-14
     * @modify 2018-01-16 添加系统标识字段 王心洋
     * @param map sysFlag 系统标识
     * @return utiUserMenuImageDtoList 用户菜单图标表信息集合
     */
    @Override
    public List<UtiUserMenuImageDto> queryUserMenuImage(@RequestBody Map<String,String> map) {
        String sysFlag = map.get("sysFlag");
        return userMenuManageService.queryUserMenuImage(sysFlag);
    }
}
