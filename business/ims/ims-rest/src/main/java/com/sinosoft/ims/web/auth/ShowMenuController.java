package com.sinosoft.ims.web.auth;

import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.ims.api.auth.ShowMenuApi;
import com.sinosoft.ims.api.auth.dto.MenuTreeDto;
import com.sinosoft.ims.api.kernel.dto.RequestLoginDto;
import com.sinosoft.ims.core.auth.service.ShowMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = ShowMenuController.PATH)
public class ShowMenuController implements ShowMenuApi{
    private static Logger LOGGER = LoggerFactory.getLogger(UtiMenuController.class);

    @Autowired
    private ShowMenuService showMenuService;

    /**
     *  查询用户权限菜单信息
     * @author: ldd
     * @date: 2017/11/16 8:48

     * @return MenuTreeDto集合
     */
    @Override
    public @ResponseBody List<MenuTreeDto> queryUserMenu(@RequestBody Map<String,String> map) throws Exception{
        String comCode=map.get("comCode");
        String userCode=map.get("userCode");
        String systemCode=map.get("systemCode");
        RequestLoginDto requestLoginDto = new RequestLoginDto();
        requestLoginDto.setLoginComCode(comCode);
        requestLoginDto.setUserCode(userCode);
        requestLoginDto.setSystemCode(systemCode);
        return showMenuService.queryUserMenu(requestLoginDto,true);
    }
}
