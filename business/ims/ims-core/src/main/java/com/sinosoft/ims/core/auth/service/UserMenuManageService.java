package com.sinosoft.ims.core.auth.service;

import com.sinosoft.ims.api.auth.dto.UtiUserMenuDto;
import com.sinosoft.ims.api.auth.dto.UtiUserMenuImageDto;

import java.util.List;

public interface UserMenuManageService {

    /**
     * 常用菜单查询：按照用户代码查询菜单列表
     * @author 王心洋
     * @time 2017-11-14
     * @modify 2018-01-16 添加系统标识字段 王心洋
     * @param userCode 用户代码
     * @param sysFlag 系统标识
     * @return utiUserMenuDtoList 用户菜单表信息集合
     */
    List<UtiUserMenuDto> queryUserMenuInfo(String userCode, String sysFlag, String comCode);

    /**
     * 常用菜单保存
     * @author 王心洋
     * @time 2017-11-14
     * @param utiUserMenuDtos 常用菜单信息dto
     */
    void saveUserMenu(List<UtiUserMenuDto> utiUserMenuDtos);

    /**
     * 常用菜单删除
     * @author 王心洋
     * @time 2017-11-14
     * @param userCode 用户代码
     * @param menuCName 菜单编号集合
     */
    void deleteUserMenuInfo(String userCode, String menuCName, String comCode);

    /**
     * 常用菜单图标查询
     * @author 王心洋
     * @time 2017-11-14
     * @modify 2018-01-16 添加系统标识字段 王心洋
     * @param sysFlag 系统标识
     * @return utiUserMenuImageDtoList 用户菜单图标表信息集合
     */
    List<UtiUserMenuImageDto> queryUserMenuImage(String sysFlag);

}
