package com.sinosoft.ims.core.auth.service.impl;

import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.ims.api.auth.dto.UtiUserMenuDto;
import com.sinosoft.ims.core.auth.dao.UtiUserMenuDao;
import com.sinosoft.ims.core.auth.entity.UtiUserMenu;
import com.sinosoft.ims.core.auth.entity.UtiUserMenuKey;
import com.sinosoft.ims.core.auth.service.UtiUserMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-13 07:55:48.156 
 * @description 常用菜单信息表Core接口实现
 */
@Service
public class UtiUserMenuServiceImpl extends BaseServiceImpl implements UtiUserMenuService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(UtiUserMenuServiceImpl.class);
    
    @Autowired
    private UtiUserMenuDao utiUserMenuDao;

    /**
     *@description 新增
     *@param
     */
    public void save(UtiUserMenuDto utiUserMenuDto) {
        UtiUserMenu utiUserMenu = this.convert(utiUserMenuDto, UtiUserMenu.class);
        utiUserMenuDao.save(utiUserMenu);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String userCode, Integer menuId, String comCode) {
        UtiUserMenuKey utiUserMenuKey = new UtiUserMenuKey(userCode, menuId, comCode);
        utiUserMenuDao.delete(utiUserMenuKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(UtiUserMenuDto utiUserMenuDto) {
        UtiUserMenu utiUserMenu = this.convert(utiUserMenuDto, UtiUserMenu.class);
        utiUserMenuDao.save(utiUserMenu);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiUserMenuDto queryByPK(String userCode, Integer menuId, String comCode) {
        UtiUserMenuKey utiUserMenuKey = new UtiUserMenuKey(userCode, menuId, comCode);
        UtiUserMenu utiUserMenu = utiUserMenuDao.findOne(utiUserMenuKey);
        return this.convert(utiUserMenu,UtiUserMenuDto.class);
    }
}