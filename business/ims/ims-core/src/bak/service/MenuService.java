package com.sinosoft.ims.core.kernel.service;

import java.util.List;

import com.sinosoft.ims.api.kernel.dto.SmcMenuDto;
import com.sinosoft.ims.api.kernel.dto.MenuQueryConditionDto;


/**
 * @description 菜单服务接口
 * @author hzhongkai
 * @date 2016年9月18日下午8:13:34
 */
public interface MenuService {

    
    /**
     * @description  查询菜单
     * @param menuQueryConditionDto
     * @return MenuReturnDto
     * @
     * @author hzhongkai
     * @date 2016年9月28日下午5:15:45
     */
    List<SmcMenuDto> queryMenuList(MenuQueryConditionDto menuQueryConditionDto) ;;

}
