package com.sinosoft.ims.core.auth.service;


import java.util.List;

import com.sinosoft.ims.api.auth.dto.UtiPlatConfigRuleDto;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-11-05 01:10:45.148 
 * @description UtiPlatConfigRuleCore接口
 */
public interface UtiPlatConfigRuleService {

    /**
     *@description 新增
     *@param
     */
    void save(UtiPlatConfigRuleDto utiPlatConfigRuleDto);

    /**
     *@description 删除
     *@param
     */
    void remove(String systemCode, String paramCode, Integer serialNo);
    /**
     *@description 修改
     *@param
     */
    void modify(UtiPlatConfigRuleDto utiPlatConfigRuleDto);
    /**
     *@description 按主键查询实体
     *@param 
     */
    UtiPlatConfigRuleDto queryByPK(String systemCode, String paramCode, Integer serialNo);

    /**
     * 查询表名
     * @author: 钱浩
     * @date: 2017/11/18 9:18
     * @param paramCode 表代码
     * @return
     * @throws Exception
     */
    String  getProperty (String paramCode) throws  Exception;

    /**
     * 根据系统与表代码查询规则信息
     * @author: 田健
     * @date: 2018/1/20 10:48
     * @param  paramCode 表代码，systemCode是归属系统
     * @return String 返回 表中配置的规则值
     * @throws Exception
     */
    String  getPropertyRule (String paramCode,String systemCode) throws  Exception;

    /**
     * 新老农险数据校验
     *
     * @return 拼接字段
     * @throws Exception
     * @author: 钱浩
     * @date: 2017/12/16 上午 10:29
     */
    public String queryNewAgri() throws Exception;
    
    /**
      * @description 根据SystemCode和Paramcode查询UtiPlatConfigRuleDto集合
      * @author 杨昆
      * @date 2017年12月26日 上午11:14:35
      * @param map里面包含SystemCode和Paramcode
      * @return  UtiPlatConfigRuleDto集合
     */
    List<UtiPlatConfigRuleDto> queryUtiPlatConfigRuleDtoBySystemCodeAndParamcode(String systemCode,String paramcode);
}