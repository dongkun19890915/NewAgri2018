package com.sinosoft.ims.web.kernel;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.ims.api.auth.dto.SaaGradeDto;
import com.sinosoft.ims.api.kernel.UserApi;
import com.sinosoft.ims.api.kernel.dto.PrpDcompanyDto;
import com.sinosoft.ims.api.kernel.dto.PrpDuserDto;
import com.sinosoft.ims.api.kernel.dto.UserImportDto;
import com.sinosoft.ims.api.kernel.dto.UserQueryConditionDto;
import com.sinosoft.ims.core.kernel.service.UserService;


/**
 * @description （用户关联服务）
 * @author chengzhuo
 * @date 2016年9月25日下午5:40:49
 */
@RestController
@RequestMapping(UserApi.PATH)
public class UserController implements UserApi
{

    @Autowired
    private UserService userApi;

    /**
     * @description （用户查询列表）
     * @param userQueryCondition
     * @return ResponseDto
     * @author chengzhuo
     * @date 2016年9月23日下午4:15:22
     */
    public PageInfo<PrpDuserDto> queryUserList(@RequestBody UserQueryConditionDto userQueryCondition)
    {
        return userApi.queryUserPage(userQueryCondition);
    }


    /**
     * @description （ 保存用户信息 ）
     * @param userDto
     * @return ResponseDto
     * @author chengzhuo
     * @date 2016年9月23日下午4:15:48
     */
    public ResponseDto saveUser(@RequestBody PrpDuserDto userDto)
    {
        return userApi.saveUser(userDto);
    }

    /**
     * @description （ 修改用户信息 ）
     * @param userDto
     * @return ResponseDto
     * @author chengzhuo
     * @
     * @date 2016年9月23日下午4:16:12
     */
    public ResponseDto updateUser(@RequestBody PrpDuserDto userDto)
    {
        return userApi.updateUser(userDto);
    }

    /**
     * @description （密码判断）
     * @param userDto
     * @return ResponseDto
     * @author chengzhuo
     * @
     * @date 2016年9月23日下午4:16:29
     */
    public ResponseDto checkUserPasswd(@RequestBody PrpDuserDto userDto)
    {
        return userApi.checkeUserPasswd(userDto);
    }

    /**
     * @description （ 密码修改 ）
     * @param userDto
     * @return ResponseDto
     * @author chengzhuo
     * @
     * @date 2016年9月23日下午4:16:46
     */
    public ResponseDto updatePasswd(@RequestBody PrpDuserDto userDto)
    {
        return userApi.updatePasswd(userDto);
    }

    /**
     * @description （ 根据用户userCode查询用户信息 ）
     * @param userDto
     * @return ResponseDto
     * @author chengzhuo
     * @
     * @date 2016年9月23日下午4:17:02
     */
    public PrpDuserDto queryUserInfo(String userCode)
    {
    	PrpDuserDto prpDuserDto = userApi.queryUserInfo(userCode);
        return prpDuserDto;
    }

    /**
     * @description （获取用户机构权限）
     * @param userDto
     * @return
     * @author chengzhuo
     * @
     * @date 2016年9月23日下午4:11:34
     */
    public List<PrpDcompanyDto> getUserComCode(@RequestBody PrpDuserDto userDto)
    {
        return userApi.queryUserComCodeService(userDto);
    }

//    /**
//     * @description 获取省级机构权限
//     * @param userDto
//     * @return
//     * @author chengzhuo
//     * @
//     * @date 2016年9月23日下午4:11:34
//     */
//    public List<PrpDcompanyDto> queryDownComCode(@RequestBody UserDto userDto)
//    {
//        return userApi.queryDownComCodeService(userDto);
//    }

//    /**
//     * @description 获取所属保险公司
//     * @return Map<String,String>
//     * @author chengzhuo
//     * @
//     * @date 2016年10月11日下午1:55:40
//     */
//    public PrpDcompanyDto queryHeadComCode(@RequestBody PrpDuserDto userDto)
//    {
//        return userApi.queryHeadComCodeService(userDto);
//    }

    /**
     * @description 用户重复性校验
     * @param userDto
     * @return
     * @author chengzhuo
     * @
     * @date 2016年10月8日下午2:22:40
     */
    public ResponseDto checkRepeatUserCode(@RequestBody PrpDuserDto userDto)
    {
        return userApi.checkRepeatUserCode(userDto);
    }

    /**
    * @description 获取所属保险公司
    * @return Map<String,String>
    * @author chengzhuo
    * @date 2016年10月11日下午1:55:40
    */
    @Override
    public PrpDcompanyDto queryUserCompany(@RequestBody PrpDuserDto userDto) {
        return userApi.queryUserCompany(userDto);
    }
    /**
     * @description 业务员查询服务
     * @param userDto
     * @return List<PrpDuserDto>
     * @throws Exception
     * @author lishaoru
     * @since 2017年9月23日 15:30:58
     */
    @Override
    public List<PrpDuserDto> getHandlerInfo(@RequestBody PrpDuserDto userDto) throws Exception {
        return userApi.getHandlerInfo(userDto);
    }

    /**
     * @description （批量上传用户）
     * @return ResponseDto
     * @author chengzhuo
     * @
     * @date 2016年9月23日下午4:24:58
     */
    public ResponseDto importUsers(@RequestBody UserImportDto userImportDto)
    {
        List<String> gradeIds = new ArrayList<String>();
        for (SaaGradeDto grade : userImportDto.getGrades())
        {
            if (grade.isChecked())
            {
                gradeIds.add(grade.getID());
            }
        }
        userImportDto.setGradeIds(gradeIds);
        return userApi.importUserInfo(userImportDto);
    }

    /**
     * @description 下载用户信息
     * @param userDto
     * @return
     * @author hzhongkai
     * @
     * @date 2016年10月12日下午2:29:53
     */
    public Map<String, String> downloadUserInfo(@RequestBody PrpDuserDto userDto)
    {
        return userApi.downloadUserInfo(userDto);
    }

    /**
     *  修改员工密码prpDuser
     * @param userCode,用户代码 oldPassword, 旧密码 newPassword 新密码]
     * @return java.lang.String 成功返回success,失败返回failed
     * @throws Exception
     * @author 李冬松
     * @date 11:05 2017/10/13
     */
    @Override
    public String modifyPassword(@RequestBody Map<String ,String> map) throws Exception {
        return userApi.modifyPassword(map.get("userCode"),map.get("oldPassword"),map.get("newPassword"));
    }
}