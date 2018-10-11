package com.sinosoft.ims.core.kernel.service.impl;


import com.sinosoft.dms.api.dict.CodeApi;
import com.sinosoft.dms.api.dict.dto.NewCodeQueryConditionDto;
import com.sinosoft.dms.api.dict.dto.PrpDNewCodeDto;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.framework.core.convert.BeanConverter;
import com.sinosoft.framework.core.dao.support.Specifications;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.ims.api.kernel.dto.MenuQueryConditionDto;
import com.sinosoft.ims.api.kernel.dto.SmcMenuDto;
import com.sinosoft.ims.core.kernel.dao.SmcMenuDao;
import com.sinosoft.ims.core.kernel.entity.SmcMenu;
import com.sinosoft.ims.core.kernel.service.MenuService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;


/**
 * @author hzhongkai
 * @description 菜单服务接口实现
 * @date 2016年9月18日下午8:14:04
 */
@Service
public class MenuServiceImpl extends BaseServiceImpl implements MenuService {
    private static Log LOGGER = LogFactory.getLog(MenuServiceImpl.class);

    @Autowired
    private SmcMenuDao smcMenuMapper;

    @Autowired
    private CodeApi codeApi;

    /**
     * @param menuQueryConditionDto
     * @return MenuReturnDto
     * @description 查询菜单
     * @
     * @author hzhongkai
     * @date 2016年9月28日下午5:15:45
     */
    //@Cacheable(value="queryMenuList",key = "caches[0].name+'.'+args[0].userCode+'_'+args[0].systemCode+'_'+args[0].comCode+'_'+args[0].gradeId")
    public List<SmcMenuDto> queryMenuList(MenuQueryConditionDto menuQueryConditionDto) {
        NewCodeQueryConditionDto newCodeQueryConditionDto = new NewCodeQueryConditionDto();
        List<PrpDNewCodeDto> prpDNewCodeDtos = codeApi.queryNewcodeList(newCodeQueryConditionDto);
        for (PrpDNewCodeDto p : prpDNewCodeDtos ) {
            LOGGER.error(p.getCodeCode());
        }
        //
        Assert.notNull(menuQueryConditionDto, "获取菜单服务入参 smcMenuConditionDto 不允许为空！");
        Assert.hasText(menuQueryConditionDto.getUserCode(), "获取菜单服务入参 UserCode 不允许为空！");

        //返回菜单列表
        List<SmcMenuDto> smcMenuDtoList = new ArrayList<SmcMenuDto>();
        LOGGER.error("菜单获取服务开始  UserCode=" + menuQueryConditionDto.getUserCode());
        try {
            List<SmcMenu> menuList = smcMenuMapper.findMenuByUserCode(menuQueryConditionDto.getUserCode());
            // 对象互转
            for (SmcMenu smcMenu : menuList) {
                smcMenuDtoList.add(smcMenuTOsmcMenuDto(smcMenu));
            }
        } catch (Exception e) {
            LOGGER.error("菜单获取服务发生异常！" + e.getMessage());
            throw e;
        }
        return smcMenuDtoList;
    }

    /**
     * @param smcMenu
     * @return SmcMenuDto
     * @description 对象互转
     * @author hzhongkai
     * @date 2016年9月20日下午3:58:45
     */
    private SmcMenuDto smcMenuTOsmcMenuDto(SmcMenu smcMenu) {
        SmcMenuDto smcMenuDto = convert(smcMenu, SmcMenuDto.class);
        return smcMenuDto;
    }
}
