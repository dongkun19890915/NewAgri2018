package com.sinosoft.ims.core.auth.service;


import com.sinosoft.ims.api.auth.dto.MenuQueryConditionDto;
import com.sinosoft.ims.api.auth.dto.MenuQueryResponseDto;
import com.sinosoft.ims.api.auth.dto.UtiMenuDto;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:27.902 
 * @description 菜单表Core接口
 */
public interface UtiMenuService {

    /**
     *@description 新增
     *@param
     */
    void save(UtiMenuDto utiMenuDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String menuId);
    /**
     *@description 修改
     *@param
     */
    void modify(UtiMenuDto utiMenuDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    UtiMenuDto queryByPK(String menuId);
    
    /**
     * @description
     * @param menuQueryConditionDto
     * @return List<SmcMenuDto>
     * @author libin
     * @date 2017年8月23日 下午4:04:08
     */
    List<UtiMenuDto> queryMenuList(MenuQueryConditionDto menuQueryConditionDto) throws Exception;
    
    /**
     * @description 根据条件获取菜单树
     * @param menuQueryConditionDto
     * @return List<MenuQueryResponseDto>
     * @throws Exception
     * @author libin
     * @date 2017年9月27日 下午8:02:26
     */
    public List<MenuQueryResponseDto> queryMenuListByCondition(MenuQueryConditionDto menuQueryConditionDto) throws Exception;

    /**
     * 根据系统代码、菜单层级查询菜单信息
     * @author: ldd
     * @date: 2017/11/16 9:34
     * @param systemCode 系统代码
     * @param menuLevel 菜单层级
     * @return UtiMenuDto集合
     */
    public List<UtiMenuDto> queryUtiMenuByMenuLevel(String systemCode,Integer menuLevel) throws Exception;

    /**
     *  查询下级菜单
     * @author: ldd
     * @date: 2017/11/16 9:34
     * @param systemCode 系统代码
     * @param upperMenuId 上级菜单代码
     * @return 下级菜单UtiMenuDto集合
     */
    public List<UtiMenuDto> queryUpperMenuByUpperMenuId(String systemCode,String upperMenuId) throws Exception;

    /**
     *  根据systemCode查询菜单
     * @author: ldd
     * @date: 2017/11/16 11:14
     * @param systemCode 系统代码
     * @return UtiMenuDto集合
     */
    public List<UtiMenuDto> queryAllBySystemCode(String systemCode) throws Exception;

    /**
     * @description 根据用户获取菜单列表
     * @author 闫磊
     * @param userCode 用户代码
     * @return list 当前用户菜单列表
     */
     public List<UtiMenuDto> getMenusByUserCode(String userCode)throws Exception;
}