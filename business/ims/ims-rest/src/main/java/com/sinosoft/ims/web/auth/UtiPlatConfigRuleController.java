package com.sinosoft.ims.web.auth;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinosoft.ims.api.auth.UtiPlatConfigRuleApi;
import com.sinosoft.ims.api.auth.dto.UtiPlatConfigRuleDto;
import com.sinosoft.ims.core.auth.service.UtiPlatConfigRuleService;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:45.148 
 * @description UtiPlatConfigRulecontroller层
 */
@RestController
@RequestMapping(value = UtiPlatConfigRuleController.PATH)
public class UtiPlatConfigRuleController implements UtiPlatConfigRuleApi {

    private static Logger LOGGER = LoggerFactory.getLogger(UtiPlatConfigRuleController.class);

    @Autowired
    private UtiPlatConfigRuleService utiPlatConfigRuleService;

   /**
     *@description 新增
     *@param
     */
    public void save(@RequestBody UtiPlatConfigRuleDto utiPlatConfigRuleDto) {
        utiPlatConfigRuleService.save(utiPlatConfigRuleDto);
    }

    /**
     *@description 删除
     *@param
     */
    public void remove( String systemCode,String paramCode,Integer serialNo) {
        utiPlatConfigRuleService.remove(systemCode,paramCode,serialNo);
    }
    /**
     *@description 修改
     *@param
     */
    public void modify(@RequestBody UtiPlatConfigRuleDto utiPlatConfigRuleDto) {
        utiPlatConfigRuleService.modify(utiPlatConfigRuleDto);
    }
    /**
     *@description 按主键查询实体
     *@param 
     */
    public UtiPlatConfigRuleDto queryByPK( String systemCode,String paramCode,Integer serialNo) {
        return utiPlatConfigRuleService.queryByPK(systemCode,paramCode,serialNo);
    }
    /**
     * 配置表查询
     * @author: 钱浩
     * @date: 2017/12/18 下午 18:06
     *@description 按主键查询实体
     *@param
     */
    public @ResponseBody
    UtiPlatConfigRuleDto queryByPKCollection(@RequestBody Map<String, Object> map) {
        String systemCode = (String) map.get("systemCode");
        String paramCode = (String) map.get("paramCode");
        Integer serialNo = (Integer) map.get("serialNo");
        return utiPlatConfigRuleService.queryByPK(systemCode, paramCode, serialNo);
    }

    /**
     * 查询表名
     * @author: 钱浩
     * @date: 2017/11/18 9:18
     * @param paramCode 表代码
     * @return
     * @throws Exception
     */
    public String  getProperty (@RequestParam("paramCode") String paramCode) throws  Exception{
        return utiPlatConfigRuleService.getProperty(paramCode);
    }
    /**
     * 根据系统与表代码查询规则信息(系统内使用)
     * @author: 田健
     * @date: 2018/1/20 10:48
     * @param map key值 paramCode表代码，systemCode是归属系统
     * @return String 返回 表中配置的规则值
     * @throws Exception
     */
    @Override
    public String getPropertyRule (@RequestBody Map<String,String> map) throws  Exception{
        String paramCode = map.get("paramCode");
        String systemCode = map.get("systemCode");
        return utiPlatConfigRuleService.getPropertyRule(paramCode,systemCode);
    }
    /**
     * 根据系统与表代码查询规则信息（返回前端）
     * @author: 田健
     * @date: 2018/1/20 10:48
     * @param map key值 paramCode表代码，systemCode是归属系统
     * @return String 返回 表中配置的规则值
     * @throws Exception
     */
    @Override
    public @ResponseBody Map<String,String> getPropertyRuleToFront (@RequestBody Map<String,String> map) throws  Exception{
        String paramCode = map.get("paramCode");
        String systemCode = map.get("systemCode");
        String riskCodes = utiPlatConfigRuleService.getPropertyRule(paramCode,systemCode);
        Map<String,String> stringMap = new HashMap<>();
        stringMap.put("message",riskCodes);
        return stringMap;
    }
    /**
     * 查询表名
     *
     * @param map 表代码
     * @return
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/11/18 9:18
     */
    public Map<String, String> queryProperty(@RequestBody Map<String, String> map) throws Exception {
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("tableName", utiPlatConfigRuleService.getProperty(map.get("paramCode")));
        return map1;
    }
    /**
     * 新老农险数据校验
     *
     * @return 拼接字段
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/12/16 上午 10:29
     */
    public @ResponseBody
    String queryNewAgri() throws Exception {

        return utiPlatConfigRuleService.queryNewAgri();
    }
    
	/**
	 * @description 根据SystemCode和Paramcode查询UtiPlatConfigRuleDto集合
	 * @author 杨昆
	 * @date 2017年12月26日 上午11:14:35
	 * @param map里面包含SystemCode和Paramcode
	 * @return UtiPlatConfigRuleDto集合
	 */
	@Override
	public List<UtiPlatConfigRuleDto> queryUtiPlatConfigRuleDtoBySystemCodeAndParamcode(Map<String, String> map) {
		String systemCode = map.get("systemCode");
		String paramcode = map.get("paramcode");
		List<UtiPlatConfigRuleDto> utiPlatConfigRuleDtoList = utiPlatConfigRuleService
				.queryUtiPlatConfigRuleDtoBySystemCodeAndParamcode(systemCode, paramcode);
		return utiPlatConfigRuleDtoList;
	}
}
