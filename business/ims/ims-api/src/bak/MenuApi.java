package com.sinosoft.ims.api.kernel;

import java.util.List;

import com.sinosoft.ims.IMSConstant;
import com.sinosoft.ims.api.kernel.dto.SmcMenuDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @description 菜单服务接口
 * @author hzhongkai
 * @date 2016年9月18日下午8:13:34
 */
@FeignClient(name= IMSConstant.IMS_SERVICE_NAME, path = MenuApi.PATH)
public interface MenuApi {

    public static final String PATH = "menu";

    /**
     * @description  查询菜单
     * @param appCode
     * @return MenuReturnDto
     * @
     * @author hzhongkai
     * @date 2016年9月28日下午5:15:45
     */
    @RequestMapping(value = "tree/{appCode}", method =  {RequestMethod.POST})
    public List<SmcMenuDto> getMenus(@PathVariable("appCode") String appCode);

}
