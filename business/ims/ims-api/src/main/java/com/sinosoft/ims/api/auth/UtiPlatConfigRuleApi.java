package com.sinosoft.ims.api.auth;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinosoft.ims.IMSConstant;
import com.sinosoft.ims.api.auth.dto.UtiPlatConfigRuleDto;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:45.148 
 * @description UtiPlatConfigRuleApi接口
 */
@FeignClient(name = IMSConstant.IMS_SERVICE_NAME, path = UtiPlatConfigRuleApi.PATH)
public interface UtiPlatConfigRuleApi {

    public static final String PATH = "utiPlatConfigRule";

    /**
     *@description 新增
     *@param
     */
    @RequestMapping(value = "save",method = {RequestMethod.POST})
    void save(UtiPlatConfigRuleDto utiPlatConfigRuleDto);

    /**
     *@description 删除
     *@param
     */
    @RequestMapping(value = "remove",method = {RequestMethod.POST})
    void remove(@RequestParam("systemCode")String systemCode, @RequestParam("paramCode") String paramCode, @RequestParam("serialNo") Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    @RequestMapping(value = "modify",method = {RequestMethod.POST})
    void modify(UtiPlatConfigRuleDto utiPlatConfigRuleDto);
    /**
     *    配置表查询
     * @author: 钱浩
     * @date: 2017/12/18 下午 18:06
     *@description 按主键查询实体
     *@param 
     */
    @RequestMapping(value = "queryByPK",method = {RequestMethod.POST})
   @ResponseBody UtiPlatConfigRuleDto queryByPK(@RequestParam("systemCode")String systemCode, @RequestParam("paramCode") String paramCode, @RequestParam("serialNo") Integer serialNo);
    /**
     * 配置表查询
     * @author: 钱浩
     * @date: 2017/12/18 下午 18:06
     *@description 按主键查询实体
     *@param
     */
    @RequestMapping(value = "queryByPKCollection", method = {RequestMethod.POST})
    @ResponseBody
    UtiPlatConfigRuleDto queryByPKCollection(@RequestBody Map<String, Object> map);

    /**
     * 查询表名
     * @author: 钱浩
     * @date: 2017/11/18 9:18
     * @param paramCode 表代码
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getProperty",method = {RequestMethod.POST})
    String getProperty (@RequestParam("paramCode") String paramCode) throws  Exception;

    /**
     * 根据系统与表代码查询规则信息(系统内使用)
     * @author: 田健
     * @date: 2018/1/20 10:48
     * @param map key值 paramCode表代码，systemCode是归属系统
     * @return String 返回 表中配置的规则值
     * @throws Exception
     */
    @RequestMapping(value = "getPropertyRule",method = {RequestMethod.POST})
    String getPropertyRule (@RequestBody Map<String,String> map) throws  Exception;
    /**
     * 根据系统与表代码查询规则信息（返回前端）
     * @author: 田健
     * @date: 2018/1/20 10:48
     * @param map key值 paramCode表代码，systemCode是归属系统
     * @return String 返回 表中配置的规则值
     * @throws Exception
     */
    @RequestMapping(value = "getPropertyRuleToFront",method = {RequestMethod.POST})
    @ResponseBody Map<String,String> getPropertyRuleToFront (@RequestBody Map<String,String> map) throws  Exception;

    /**
     * 查询表名
     *
     * @param map 表代码
     * @return
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/11/18 9:18
     */
    @RequestMapping(value = "queryProperty", method = {RequestMethod.POST})
    Map<String, String> queryProperty(@RequestBody Map<String, String> map) throws Exception;
    /**
     * 新老农险数据校验
     *
     * @return 拼接字段
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/12/16 上午 10:29
     */
    @RequestMapping(value = "queryNewAgri", method = {RequestMethod.POST})
    @ResponseBody
    String queryNewAgri() throws Exception;
    
     /**
      * @description 根据SystemCode和Paramcode查询UtiPlatConfigRuleDto集合
      * @author 杨昆
      * @date 2017年12月26日 上午11:14:35
      * @param map里面包含SystemCode和Paramcode
      * @return  UtiPlatConfigRuleDto集合
      */
    @RequestMapping(value = "queryUtiPlatConfigRuleDtoBySystemCodeAndParamcode", method = {RequestMethod.POST})
    @ResponseBody
    List<UtiPlatConfigRuleDto> queryUtiPlatConfigRuleDtoBySystemCodeAndParamcode(@RequestBody Map<String, String> map);
}