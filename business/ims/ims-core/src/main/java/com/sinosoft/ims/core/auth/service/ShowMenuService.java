package com.sinosoft.ims.core.auth.service;

import com.sinosoft.ims.api.auth.dto.MenuTreeDto;
import com.sinosoft.ims.api.kernel.dto.RequestLoginDto;

import java.util.List;

public interface ShowMenuService {

    /**
     *  查询用户权限菜单信息
     * @author: 李东东
     * @date: 2017/11/16 8:48
     * @param requestLoginDto 请求参数集合
     * @param generateCheckPower 是否需要补充CheckPower()方法所需的入参
     * @return MenuTreeDto集合
     */
    public List<MenuTreeDto> queryUserMenu(RequestLoginDto requestLoginDto, boolean generateCheckPower) throws Exception;

    /**
     * 补充CheckPower()方法所需的入参
     * @author: 李东东
     * @param requestLoginDto 请求参数集合
     * @return 补充完参数的RequestLoginDto集合
     * @throws Exception
     */
    public RequestLoginDto generateCheckPowerConditon(RequestLoginDto requestLoginDto) throws Exception;

    /**
     *  判断某个菜单是否有权执行
     * @author: 李东东
     * @date: 2017/11/16 14:26
     * @param requestLoginDto 登录请求dto
     * @return 判断某个菜单是否有权执行
     */
    public boolean checkPower(RequestLoginDto requestLoginDto) throws Exception;
}
