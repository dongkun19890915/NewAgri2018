package com.sinosoft.ims.api.auth;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sinosoft.ims.IMSConstant;
import com.sinosoft.ims.api.auth.dto.MenuQueryConditionDto;
import com.sinosoft.ims.api.auth.dto.MenuQueryResponseDto;
import com.sinosoft.ims.api.auth.dto.UtiMenuDto;

import feign.Param;


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
    public List<UtiMenuDto> getMenus(@PathVariable("appCode") String appCode)throws Exception;
    
    /**
     * @description 根据条件获取菜单树
     * @param MenuQueryConditionDto
     * @return List<MenuQueryResponseDto>
     * @throws Exception
     * @author libin
     * @date 2017年9月28日 上午9:57:58
     */
    @RequestMapping(value = "queryMenuListByCondition", method =  {RequestMethod.POST})
    public List<MenuQueryResponseDto> queryMenuListByCondition(@RequestBody MenuQueryConditionDto menuQueryConditionDto) throws Exception;

   /**
    * @description 根据用户获取菜单列表
    * @author 闫磊
    * @param userCode 用户代码
    * @return list 当前用户菜单列表
    */
    @RequestMapping(value = "getMenusByUserCode", method =  {RequestMethod.POST})
    public List<UtiMenuDto> getMenusByUserCode(@RequestParam("userCode") String userCode)throws Exception;
}
