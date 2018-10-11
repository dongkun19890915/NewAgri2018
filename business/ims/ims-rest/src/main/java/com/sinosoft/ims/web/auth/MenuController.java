package com.sinosoft.ims.web.auth;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.ims.api.auth.MenuApi;
import com.sinosoft.ims.api.auth.dto.MenuQueryConditionDto;
import com.sinosoft.ims.api.auth.dto.MenuQueryResponseDto;
import com.sinosoft.ims.api.auth.dto.UtiMenuDto;
import com.sinosoft.ims.core.auth.service.UtiMenuService;


/**
 * @description 菜单控制器 
 * @author hzhongkai
 * @date 2016年10月18日下午12:05:25
 */
@RestController
@RequestMapping(MenuApi.PATH)
public class MenuController implements MenuApi
{
    private static Log LOGGER = LogFactory.getLog(MenuController.class);

    @Autowired
    private UtiMenuService menuApi;

    /**
     * @description 查询comm系统显示的菜单
     * @param appCode
     * @return 菜单json串
     * @author hzhongkai
     * @date 2016年10月18日下午12:05:40
     */
    @RequestMapping(value = "tree/{appCode}", method =  {RequestMethod.POST,RequestMethod.GET})
    public List<UtiMenuDto> getMenus(@PathVariable("appCode") String appCode) throws Exception
    {
    	if(LOGGER.isInfoEnabled()){
    		LOGGER.error("appCode=" + appCode);
    	}
        MenuQueryConditionDto menuQueryConditionDto = new MenuQueryConditionDto();
        menuQueryConditionDto.setUserCode(SinoRequestContext.getCurrentContext().getUserCode());
        menuQueryConditionDto.setUserCode(SinoRequestContext.getCurrentContext().getUserCode());
        menuQueryConditionDto.setSystemCode(appCode);
        List<UtiMenuDto> listMenu = menuApi.queryMenuList(menuQueryConditionDto);
        return listMenu;
    }
    
    /**
     * @description 根据条件获取菜单树
     * @param MenuQueryConditionDto
     * @return List<MenuQueryResponseDto>
     * @throws Exception
     * @author libin
     * @date 2017年9月28日 上午9:59:05
     */
    public List<MenuQueryResponseDto> queryMenuListByCondition(@RequestBody MenuQueryConditionDto menuQueryConditionDto) throws Exception
    {
    	if(LOGGER.isInfoEnabled()){
    		LOGGER.error("appCode=" + menuQueryConditionDto.getSystemCode());
    	}
        List<MenuQueryResponseDto> listMenu = menuApi.queryMenuListByCondition(menuQueryConditionDto);
        return listMenu;
    }

    /**
     * @description 根据用户获取菜单列表
     * @author 闫磊
     * @param userCode 用户代码
     * @return list 当前用户菜单列表
     */
    @Override
    public List<UtiMenuDto> getMenusByUserCode(@RequestParam("userCode") String userCode)throws Exception{
    	return menuApi.getMenusByUserCode(userCode);
    }
}