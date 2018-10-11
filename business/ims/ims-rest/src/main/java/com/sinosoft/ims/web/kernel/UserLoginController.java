package com.sinosoft.ims.web.kernel;


import com.sinosoft.dms.api.dict.dto.PrpDnewTypeDto;
import com.sinosoft.framework.core.context.SinoRequestContext;
import com.sinosoft.ims.api.kernel.dto.PrpDuserResultDto;
import com.sinosoft.ims.api.kernel.dto.ResponseComCodeDto;
import com.sinosoft.ims.api.kernel.dto.ResponseLoginDto;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.ims.api.kernel.UserLoginApi;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.ims.core.kernel.service.UserLoginService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @description 用户登录校验
 * @author chengzhuo
 * @date 2016年9月23日下午4:10:11
 */
@RestController
@RequestMapping(UserLoginApi.PATH)
public class UserLoginController implements UserLoginApi
{
    private static Log LOGGER = LogFactory.getLog(UserLoginController.class);

    @Autowired
    private UserLoginService userLoginService;

//    @Autowired
//    private CodeApi codeApi;
    /**
     * @description 校验登陆密码和账户
     * @return
     * @author chengzhuo
     * @
     * @date 2016年9月23日下午4:10:53
     */
    public @ResponseBody PrpDuserResultDto checkUserLogin(@RequestBody PrpDuserDto userDto)
    {
        System.out.println("开始了......");
        if(LOGGER.isInfoEnabled()){
            LOGGER.error("usercode="+userDto.getUserCode());
        }
        return userLoginService.checkUserLogin(userDto);
    }

    @Override
    public void test() {
        try {
            //List<PrpDnewTypeDto> prpDnewTypeDtos = codeApi.getAllCodeType();
            List<PrpDnewTypeDto> prpDnewTypeDtos =new ArrayList<PrpDnewTypeDto>();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @description 忘记密码
     * @param userDto
     * @return
     * @author zkr07
     * @date 2016年10月7日下午6:00:03
     */
    @Override
    public ResponseDto forgetPwd(@RequestBody PrpDuserDto userDto)
    {
        return userLoginService.forgetPwd(userDto);
    }
    /**
     *  承保系统登录后机构和菜单查询接口rest层
     * @param,userCode 用户代码
     * @param,systemCode 系统代码
     * @return ResponseDto 用户机构和菜单信息
     * @throws Exception
     * @author 李冬松
     * @date 9:41 2017/11/16
     */
    @Override
    public @ResponseBody
    ResponseLoginDto queryLoginInfo(@RequestBody Map<String ,String> map) throws Exception {
        return userLoginService.queryLoginInfo(map.get("userCode"),map.get("systemCode"));
    }
    /**
     * 承保系统登录校验用户名密码rest层
     * @param,u s er Code 用户名
     * @param,p ass word 密码
     * @return boolean 登录成功返回true
     * @throws Exception
     * @author 李冬松
     * @date 15:28 2017/11/18
     */
    @Override
    public boolean checkUserPassword(@RequestBody Map<String,String> map) throws Exception {
        return userLoginService.checkUserPassword(map.get("userCode"),map.get("password"));
    }

    /**
     * 修改用户密码
     *
     * @param map
     * @return
     */
    @Override
    @RequestMapping(value = "modifypwd", method = RequestMethod.POST)
    //public Map<String, String> modifypwd(@RequestParam("oldpwd") String oldpwd, @RequestParam("newpwd") String newpwd) throws Exception {
    public Map<String, String> modifypwd(@RequestBody Map<String,String> map) throws Exception {
        String oldpwd=map.get("oldpwd");
        String newpwd=map.get("newpwd");

        if(oldpwd.isEmpty()||newpwd.isEmpty()){
            throw new Exception("密码参数不能为空");
        }

        //1、校验密码长度
        if(newpwd.length()<6){
            throw new Exception("密码长度大于6位");
        }
        Map<String,String> resultMap=new HashMap<>();

        //1、获取当前用户信息
        String userCode= SinoRequestContext.getCurrentContext().getUserCode();
        if(userLoginService.modifypwd(userCode,oldpwd,newpwd)){
            resultMap.put("resultCode","0000");
            resultMap.put("resultMsg","修改成功");
            return resultMap;
        }
        return null;
    }
    /**
     * 登录机构查询
     * @param map userCode用户代码的map
     * @return ResponseComCodeDto 机构信息具体见dto说明
     * @throws Exception
     * @author 李冬松
     * @date 16:53 2018/1/23
     */
    @Override
    public List<ResponseComCodeDto> queryComCodeList(@RequestBody Map<String, String> map) throws Exception {
        return userLoginService.findComCodeList(map.get("userCode"));
    }
}
