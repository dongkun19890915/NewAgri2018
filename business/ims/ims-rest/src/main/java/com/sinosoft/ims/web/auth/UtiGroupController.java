package com.sinosoft.ims.web.auth;

import com.sinosoft.ims.api.auth.UtiGroupApi;
import com.sinosoft.ims.api.auth.dto.AddCodePowerConditionDto;
import com.sinosoft.ims.api.auth.dto.SubComDto;
import com.sinosoft.ims.api.auth.dto.UtiGroupDto;
import com.sinosoft.ims.core.auth.service.UtiGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:45.148
 * @description UtiGroupcontroller层
 */
@RestController
@RequestMapping(value = UtiGroupApi.PATH)
public class UtiGroupController implements UtiGroupApi{

    private static Logger LOGGER = LoggerFactory.getLogger(UtiGroupController.class);

    @Autowired
    private UtiGroupService utiGroupService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody UtiGroupDto utiGroupDto) {
        utiGroupService.save(utiGroupDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove(@RequestBody String groupCode) {
        utiGroupService.remove(groupCode);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody UtiGroupDto utiGroupDto) {
        utiGroupService.modify(utiGroupDto);
    }
    /**
     *@description 按主键查询实体
     *@param
     */
    public UtiGroupDto queryByPK(@RequestBody String groupCode) {
        return utiGroupService.queryByPK(groupCode);
    }
    /**
     *  获取权限查询条件rest层
     * @param addCodePowerConditionDto
     * @return String 返回权限查询条件的Sql字符串
     * @throws Exception
     * @author 李冬松
     * @date 11:29 2017/11/20
     */
    public @ResponseBody
    String addCodePower(@RequestBody AddCodePowerConditionDto addCodePowerConditionDto)throws Exception{
        return utiGroupService.addCodePower(addCodePowerConditionDto);
    }
    /**
    * 获取险种权限
    * @param addCodePowerConditionDto
    * @return java.lang.String 返回险种的SQL
    * @throws Exception
    * @author 李冬松
    * @date 16:45 2017/12/21
    */
    @Override
    public @ResponseBody String addRiskCodePermit(@RequestBody AddCodePowerConditionDto addCodePowerConditionDto) throws Exception {
        return utiGroupService.addRiskCodePermit(addCodePowerConditionDto);
    }

    /**
     * 获取机构权限的list
     *
     * @param addCodePowerConditionDto
     * @return
     * @author: 何伟东
     * @date: 2018/1/5 16:02
     */
    @Override
    public @ResponseBody List<String> getCodePowerList(@RequestBody AddCodePowerConditionDto addCodePowerConditionDto) throws Exception {
        return utiGroupService.getCodePowerList(addCodePowerConditionDto);
    }

    /**
     * 获取子级机构信息
     *
     * @param param comCode-机构代码；userCode-用户代码
     * @return 所有子级机构信息
     * @author: 何伟东
     * @date: 2018/1/5 16:02
     */
    @Override
    public @ResponseBody
    List<SubComDto> getSubComList(@RequestBody Map<String, String> param) throws Exception {
        return utiGroupService.getSubComList(param);
    }
}
