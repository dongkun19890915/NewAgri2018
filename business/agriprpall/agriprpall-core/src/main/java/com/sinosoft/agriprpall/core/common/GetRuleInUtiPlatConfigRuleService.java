package com.sinosoft.agriprpall.core.common;

public interface GetRuleInUtiPlatConfigRuleService {
    /**
     * @description: 多条件查询tablename
     * @author: 钱浩
     * @date: 2017/10/30 10:02
     * @param systemCode 系统
     * @param paramCode 表代码
     * @param serialNo 标志
     * @return
     */
    public String queryfindOne(String systemCode,String paramCode,String serialNo)throws Exception;
    /**
     * @description:平台对接
     * @author: 钱浩
     * @date: 2017/10/25 11:23
     * @param paramCode 表代码
     * @return
     * @throws Exception
     */
    public String getProperty(String paramCode) throws Exception;
}
