package com.sinosoft.ims.core.auth.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestParam;

import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.ims.api.auth.PowerApi;
import com.sinosoft.ims.api.auth.dto.MenuQueryConditionDto;
import com.sinosoft.ims.api.auth.dto.MenuQueryResponseDto;
import com.sinosoft.ims.api.auth.dto.PowerConditionDto;
import com.sinosoft.ims.api.auth.dto.UtiMenuDto;
import com.sinosoft.ims.core.auth.dao.UtiMenuDao;
import com.sinosoft.ims.core.auth.entity.UtiMenu;
import com.sinosoft.ims.core.auth.entity.UtiMenuKey;
import com.sinosoft.ims.core.auth.service.PowerService;
import com.sinosoft.ims.core.auth.service.UtiMenuService;
import com.sinosoft.ims.core.common.enums.ImsErrorEnum;
import com.sinosoft.pms.api.kernel.RiskApi;


/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-08-22 03:00:27.902 
 * @description 菜单表Core接口实现
 */
@Service
public class UtiMenuServiceImpl extends BaseServiceImpl implements UtiMenuService {
	/** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(UtiMenuServiceImpl.class);
    private String riskCode;//险种代码
    private String classCode;//险类代码
    private boolean isShowRiskMenu = false; // 是否显示带险种菜单
    private String comCode;//机构代码
    private String userCode;//员工代码
    
    @Autowired
    private UtiMenuDao utiMenuDao;
    
    @Autowired
    private PowerApi powerApi;
    
    @Autowired
    private PowerService powerService;
    
    @Autowired
    private RiskApi riskApi;

    /**
     *@description 新增
     *@param
     */
    public void save(UtiMenuDto utiMenuDto) {
        UtiMenu utiMenu = this.convert(utiMenuDto, UtiMenu.class);
        utiMenuDao.save(utiMenu);
    }
    /**
     *@description 删除
     *@param
     */
    public void remove(String menuId) {
        UtiMenuKey utiMenuKey = new UtiMenuKey(menuId);
        utiMenuDao.delete(utiMenuKey);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(UtiMenuDto utiMenuDto) {
        UtiMenu utiMenu = this.convert(utiMenuDto, UtiMenu.class);
        utiMenuDao.save(utiMenu);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiMenuDto queryByPK(String menuId) {
        UtiMenuKey utiMenuKey = new UtiMenuKey(menuId);
        UtiMenu utiMenu = utiMenuDao.findOne(utiMenuKey);
        return this.convert(utiMenu,UtiMenuDto.class);
    }
    
    /**
     * @description
     * @param menuQueryConditionDto
     * @return List<UtiMenuDto>
     * @author libin
     * @throws Exception 
     * @date 2017年8月23日 下午4:04:08
     */
	@Override
	public List<UtiMenuDto> queryMenuList(MenuQueryConditionDto menuQueryConditionDto) throws Exception {
		Assert.notNull(menuQueryConditionDto, "获取菜单服务入参 smcMenuConditionDto 不允许为空！");
        Assert.hasText(menuQueryConditionDto.getUserCode(), "获取菜单服务入参 UserCode 不允许为空！");

        if(LOGGER.isInfoEnabled()){
        	LOGGER.error("菜单获取服务开始  UserCode=" + menuQueryConditionDto.getUserCode());
        }
        List<UtiMenu> utiMenuList = utiMenuDao.findMenuByUserCode(menuQueryConditionDto.getUserCode(), 
        		menuQueryConditionDto.getSystemCode());
        //返回菜单列表
        List<UtiMenuDto> menuDtoList = new ArrayList<UtiMenuDto>();
        this.convertCollection(utiMenuList, menuDtoList, UtiMenuDto.class);
        if(LOGGER.isInfoEnabled()){
        	LOGGER.error("返回菜单list：" + menuDtoList.size());
        }
        
		return menuDtoList;
	}
	
	/**
     * @description 根据条件获取菜单树
     * @param menuQueryConditionDto
     * @return List<MenuQueryResponseDto>
	 * @throws Exception
	 * @author libin
	 * @date 2017年9月28日 上午10:11:15
	 */
	public List<MenuQueryResponseDto> queryMenuListByCondition(MenuQueryConditionDto menuQueryConditionDto) throws Exception {
		Assert.notNull(menuQueryConditionDto, "获取菜单服务入参 smcMenuConditionDto 不允许为空！");
        Assert.hasText(menuQueryConditionDto.getUserCode(), "获取菜单服务入参 UserCode 不允许为空！");

        String systemCode = menuQueryConditionDto.getSystemCode();
        if(!StringUtils.isEmpty(menuQueryConditionDto.getRiskCode())){
        	isShowRiskMenu = true;
        	classCode = riskApi.queryriskByPK(menuQueryConditionDto.getRiskCode()).getClassCode();
        	riskCode = menuQueryConditionDto.getRiskCode();
        }
        userCode = menuQueryConditionDto.getUserCode();
        comCode = menuQueryConditionDto.getComCode();
        if(LOGGER.isInfoEnabled()){
        	LOGGER.error("菜单获取服务开始  UserCode=" + menuQueryConditionDto.getUserCode());
        }
        List<MenuQueryResponseDto> resList = new ArrayList<MenuQueryResponseDto>();
        MenuQueryResponseDto resDto = null;
        List<UtiMenu> utiMenuList = utiMenuDao.findAll(Specifications.<UtiMenu>and()
       		 .eq(StringUtils.isNotEmpty(systemCode), "systemCode", systemCode)
       		 .eq("menuLevel", "1")
       		 .eq("validStatus", "1")
               .build(), new Sort(Direction.ASC, "displayNo"));
        for(UtiMenu utiMenu: utiMenuList){
        	if (hasExecutePermission(utiMenu)) {
        		resDto = this.convert(utiMenu, MenuQueryResponseDto.class);
        		resDto.setChildMenuList(processNextLevelMenu(utiMenu));
        		resList.add(resDto);
        	}
        }
        if(LOGGER.isInfoEnabled()){
        	LOGGER.error("返回菜单list：" + resList.size());
        }
        
		return resList;
	}
	
	/**
	 * @description 递归查询所有子菜单
	 * @param utiMenu
	 * @return List<MenuQueryResponseDto>
	 * @throws Exception
	 * @author libin
	 * @date 2017年9月28日 上午11:48:07
	 */
	protected List<MenuQueryResponseDto> processNextLevelMenu(UtiMenu utiMenu) throws Exception {
        List<UtiMenu> utiMenuList = utiMenuDao.findAll(Specifications.<UtiMenu>and()
          		 .eq(StringUtils.isNotEmpty(utiMenu.getSystemCode()), "systemCode", utiMenu.getSystemCode())
          		 .eq(StringUtils.isNotEmpty(utiMenu.getMenuId()), "upperMenuId", utiMenu.getMenuId())
          		 .eq("menuLevel", (utiMenu.getMenuLevel() + 1))
          		 .eq("validStatus", "1")
                  .build(), new Sort(Direction.ASC, "displayNo"));
        List<MenuQueryResponseDto> returnList = new ArrayList<MenuQueryResponseDto>();
        if(utiMenuList.size() > 0){
        	for(UtiMenu menu : utiMenuList){
        		if (hasExecutePermission(menu)) {
	        		MenuQueryResponseDto resDto = this.convert(menu, MenuQueryResponseDto.class);
	        		returnList.add(resDto);
	        		resDto.setChildMenuList(processNextLevelMenu(menu));
        		}
            }
        }
        return returnList;
    }
	
	/**
     * 用户对当前菜单是否存在操作权限(如果是用户代码全部为0，且长度大于等于8位，则有所有执行权限）
     * 
     * @param utiMenu
     * @return 存在返回true,否则返回false
     * @throws Exception
     */
	public boolean hasExecutePermission(UtiMenu utiMenu) {
        // 系统代码为platform且员工为超级用户时有权查看所有菜单
        if ("platform".equals(utiMenu.getSystemCode())
                && powerService.isSuperUser(comCode, userCode)) {
            return true;
        }
        // 没有配置功能代码则无权显示
        if (StringUtils.isEmpty(utiMenu.getTaskCode())) {
            return false;
        }

        // 如果是显示带险种的菜单则需判断菜单的险种范围
        if (isShowRiskMenu) {
            String permitRiskClass = utiMenu.getPermitRiskClass();// 允许险类
            String exceptRiskCode = utiMenu.getExceptRiskCode();// 允许险类除外险种
            String exceptRiskClass = utiMenu.getExceptRiskClass();// 禁止险类
            String permitRiskCode = utiMenu.getPermitRiskCode();// 禁止险类除外险种
            // 如果禁止险类范围有值，则表示使用险种选项
            if (!StringUtils.isEmpty(exceptRiskClass) && !StringUtils.isEmpty(permitRiskCode)) {
                // 校验当前的险类在禁止险类范围内存在，且险种不在禁止险类除外险种范围类则不允许显示
                if (((exceptRiskClass + ",").indexOf(classCode) > -1)
                        && ((permitRiskCode + ",").indexOf(riskCode) == -1)) {
                    // 不允许显示
                    return false;
                }
            }
            // 如果允许险类范围有值，则表示使用险种选项
            if (!StringUtils.isEmpty(permitRiskClass) && !StringUtils.isEmpty(exceptRiskCode)) {
                // 校验当前的险类在允许险类范围不存在,则不允许显示
                if ((permitRiskClass + ",").indexOf(classCode) == -1) {
                    return false;
                }
                // 当前的险类在允许险类范围存在
                // 险种在允许险类除外险种范围内则不允许显示
                if ((exceptRiskCode + ",").indexOf(riskCode) > -1) {
                    // 不允许显示
                    return false;
                }
            }
        }
        boolean result = false;
        PowerConditionDto powerConditionDto = new PowerConditionDto();
        powerConditionDto.setUserCode(userCode);
        powerConditionDto.setComCode(comCode);
        powerConditionDto.setGradeCodes("");
        powerConditionDto.setTaskCodes(utiMenu.getTaskCode());
        powerConditionDto.setRiskCode(riskCode);
        powerConditionDto.setSystemCode(utiMenu.getSystemCode());
        ResponseDto resDto = powerApi.checkPower(powerConditionDto);
        if (!StringUtils.isEmpty(resDto.getResultCode()) 
        		&& resDto.getResultCode().equals(ImsErrorEnum.IMS_SUCCESS.getCode())) {
            result = true;
        }
        if (result == false) {
            return false;
        }
        // 如果配置了检查类则调用检查类的方法来作最后的处理
        /**if (utiMenuDto.getCheckClass().trim().length() > 0) {
            try {
                Class cl = Class.forName(utiMenuDto.getCheckClass().trim());
                Object object = cl.newInstance();
                Class[] paramClassArray = new Class[] { String.class,
                        String.class, String.class, String.class, String.class };
                Object[] prarmArray = new Object[] { utiMenuDto.getTaskCode(),
                        userCode, comCode, gradeCodes, riskCode };
                Method method = cl.getDeclaredMethod("hasPermission",
                        paramClassArray);
                logger.info("调用菜单权限检查类" + utiMenuDto.getCheckClass()
                        + "的hasPermission方法");
                boolean value = ((Boolean) method.invoke(object, prarmArray))
                        .booleanValue();

                return value;
            } catch (NoSuchMethodException e) {
                logger
                        .warn("类"
                                + utiMenuDto.getCheckClass()
                                + "必须提供方法public boolean hasPermission(String currentMenuTaskCode, String loginComCode,String loginUserCode, String loginGradeCode, String loginRiskCode)");
                e.printStackTrace();
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }*/

        return true;
    }

    /**
     * 根据系统代码、菜单层级查询菜单信息
     * @author: ldd
     * @date: 2017/11/16 9:34
     * @param systemCode 系统代码
     * @param menuLevel 菜单层级
     * @return UtiMenuDto集合
     */
    @Override
    public List<UtiMenuDto> queryUtiMenuByMenuLevel(String systemCode, Integer menuLevel) throws Exception {
        List<UtiMenu> utiMenuList = utiMenuDao.findUpperMenuByMenuLevel(systemCode,menuLevel);
        List<UtiMenuDto> utiMenuDtoList = new ArrayList<>();
        convertCollection(utiMenuList,utiMenuDtoList,UtiMenuDto.class);
        return utiMenuDtoList;
    }

    /**
     *  查询下级菜单
     * @author: ldd
     * @date: 2017/11/16 9:34
     * @param systemCode 系统代码
     * @param upperMenuId 上级菜单代码
     * @return 下级菜单UtiMenuDto集合
     */
    @Override
    public List<UtiMenuDto> queryUpperMenuByUpperMenuId(String systemCode, String upperMenuId) throws Exception {
        List<UtiMenu> utiMenuList = utiMenuDao.findUtiMenuByUpperMenuId(systemCode,upperMenuId);
        List<UtiMenuDto> utiMenuDtoList = new ArrayList<>();
        convertCollection(utiMenuList,utiMenuDtoList,UtiMenuDto.class);
        return utiMenuDtoList;
    }

    /**
     *  根据systemCode查询菜单
     * @author: ldd
     * @date: 2017/11/16 11:14
     * @param systemCode 系统代码
     * @return UtiMenuDto集合
     */
    public List<UtiMenuDto> queryAllBySystemCode(String systemCode) throws Exception{
        List<UtiMenu> utiMenuList = utiMenuDao.findAllBySystemCode(systemCode);
        List<UtiMenuDto> utiMenuDtoList = new ArrayList<>();
        convertCollection(utiMenuList,utiMenuDtoList,UtiMenuDto.class);
        return utiMenuDtoList;
    }
    
    /**
     * @description 根据用户获取菜单列表
     * @author 闫磊
     * @param userCode 用户代码
     * @return list 当前用户菜单列表
     */
    @Override
    public List<UtiMenuDto> getMenusByUserCode(String userCode)throws Exception{
    	List<UtiMenu> utiMenuList = utiMenuDao.getMenusByUserCode(userCode);
    	List<UtiMenuDto> utiMenuDtoList = new ArrayList<>();
        convertCollection(utiMenuList,utiMenuDtoList,UtiMenuDto.class);
    	return utiMenuDtoList;
    }
}