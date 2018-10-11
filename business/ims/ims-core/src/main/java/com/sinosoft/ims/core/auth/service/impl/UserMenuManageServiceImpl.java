package com.sinosoft.ims.core.auth.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.ims.api.auth.dto.UtiUserMenuDto;
import com.sinosoft.ims.api.auth.dto.UtiUserMenuImageDto;
import com.sinosoft.ims.core.auth.dao.UtiUserMenuDao;
import com.sinosoft.ims.core.auth.dao.UtiUserMenuImageDao;
import com.sinosoft.ims.core.auth.entity.UtiUserMenu;
import com.sinosoft.ims.core.auth.entity.UtiUserMenuImage;
import com.sinosoft.ims.core.auth.service.UserMenuManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserMenuManageServiceImpl extends BaseServiceImpl implements UserMenuManageService {

    /** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserMenuManageServiceImpl.class);

    @Autowired
    private UtiUserMenuDao utiUserMenuDao;
    @Autowired
    private UtiUserMenuImageDao utiUserMenuImageDao;

    /**
     * 常用菜单查询：按照用户代码查询菜单列表
     * @author 王心洋
     * @time 2017-11-14
     * @modify 2018-01-16 添加系统标识字段 王心洋
     * @param userCode 用户代码
     * @param sysFlag 系统标识
     * @return utiUserMenuDtoList 用户菜单表信息集合
     */
    @Override
    public List<UtiUserMenuDto> queryUserMenuInfo(String userCode, String sysFlag, String comCode) {
        List<UtiUserMenuDto> utiUserMenuDtoList = new ArrayList<>();
        List<UtiUserMenu> utiUserMenuList = utiUserMenuDao.findByUserCode(userCode, sysFlag, comCode);
        this.convertCollection(utiUserMenuList,utiUserMenuDtoList,UtiUserMenuDto.class);
        return utiUserMenuDtoList;
    }

    /**
     * 常用菜单保存
     * @author 王心洋
     * @time 2017-11-14
     * @param utiUserMenuDtos 常用菜单信息dto
     */
    @Override
    public void saveUserMenu(List<UtiUserMenuDto> utiUserMenuDtos){

        List<UtiUserMenu> utiUserMenus = new ArrayList<>();

        String userCode=utiUserMenuDtos.get(0).getUserCode();
        String sysFlag=utiUserMenuDtos.get(0).getSysFlag();
        String comCode = utiUserMenuDtos.get(0).getComCode();
        Integer maxNum=0;
        maxNum = utiUserMenuDao.findMaxIndexNo(userCode, sysFlag, comCode);

       for(int i=0;i<utiUserMenuDtos.size();i++){
           if(maxNum==null){
               maxNum=0;
           }else {
               ++maxNum;
           }
           utiUserMenuDtos.get(i).setMenuId(maxNum);
       }
        this.convertCollection(utiUserMenuDtos,utiUserMenus,UtiUserMenu.class);
        utiUserMenuDao.save(utiUserMenus);
    }

    /**
     * 常用菜单删除
     * @author 王心洋
     * @time 2017-11-14
     * @param userCode 用户代码
     * @param menuCName 菜单名
     */
    @Override
    @Transactional
    public void deleteUserMenuInfo(String userCode, String menuCName, String comCode) {
//        for(int i=0;i<menuIdList.size();i++){
//            String menuId = menuIdList.get(i);
//            UtiUserMenuKey utiUserMenuKey = new UtiUserMenuKey(userCode,menuId);
        utiUserMenuDao.deleteUtiUserMenu(userCode, menuCName, comCode);
//        }
    }

    /**
     * 常用菜单图标查询
     * @author 王心洋
     * @time 2017-11-14
     * @modify 2018-01-16 添加系统标识字段 王心洋
     * @param sysFlag 系统标识
     * @return utiUserMenuImageDtoList
     * @return utiUserMenuImageDtoList 用户菜单图标表信息集合
     */
    @Override
    public List<UtiUserMenuImageDto> queryUserMenuImage(String sysFlag) {
        List<UtiUserMenuImageDto> utiUserMenuImageDtoList = new ArrayList<>();
        List<UtiUserMenuImage> utiUserMenuImageList = utiUserMenuImageDao.findValid(sysFlag);
        this.convertCollection(utiUserMenuImageList,utiUserMenuImageDtoList,UtiUserMenuImageDto.class);
        return utiUserMenuImageDtoList;
    }
}
