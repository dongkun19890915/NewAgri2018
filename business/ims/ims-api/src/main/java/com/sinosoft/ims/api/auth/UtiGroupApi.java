package com.sinosoft.ims.api.auth;

import com.sinosoft.ims.IMSConstant;
import com.sinosoft.ims.api.auth.dto.AddCodePowerConditionDto;
import com.sinosoft.ims.api.auth.dto.SubComDto;
import com.sinosoft.ims.api.auth.dto.UtiGroupDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:45.148 
 * @description UtiGroupApi接口
 */
@FeignClient(name = IMSConstant.IMS_SERVICE_NAME, path = UtiGroupApi.PATH)
public interface UtiGroupApi {

    public static final String PATH = "utiGroup";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(UtiGroupDto utiGroupDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(String groupCode);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(UtiGroupDto utiGroupDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
    UtiGroupDto queryByPK(String groupCode);
    /**
     *  获取权限查询条件Api
     * @param addCodePowerConditionDto
     * @return String 返回权限查询条件的Sql字符串
     * @throws Exception
     * @author 李冬松
     * @date 11:29 2017/11/20
     */
    @RequestMapping(value = "addCodePower",method = {RequestMethod.POST})
    public @ResponseBody
    String addCodePower(@RequestBody AddCodePowerConditionDto addCodePowerConditionDto)throws Exception;

    /**
     * 获取险种权限（李冬松）
     * @param addCodePowerConditionDto
     * @return String 险种权限的SQL
     * @throws Exception
     */
    @RequestMapping(value = "addRiskCodePermit",method = {RequestMethod.POST})
    public @ResponseBody String addRiskCodePermit(@RequestBody AddCodePowerConditionDto addCodePowerConditionDto)throws Exception;

    /**
     * 获取机构权限的list
     *
     * @param addCodePowerConditionDto
     * @return 机构代码list
     * @author: 何伟东
     * @date: 2018/1/5 16:02
     */
    @RequestMapping(value = "getCodePowerList", method = {RequestMethod.POST})
    public @ResponseBody
    List<String> getCodePowerList(@RequestBody AddCodePowerConditionDto addCodePowerConditionDto) throws Exception;

    /**
     * 获取子级机构信息
     *
     * @param param comCode-机构代码；userCode-用户代码
     * @return 所有子级机构信息
     * @author: 何伟东
     * @date: 2018/1/5 16:02
     */
    @RequestMapping(value = "getSubComList", method = {RequestMethod.POST})
    public @ResponseBody
    List<SubComDto> getSubComList(@RequestBody Map<String, String> param) throws Exception;

}