package com.sinosoft.ims;

import java.util.HashMap;
import java.util.Map;

/**
 * @description  权限相关常量类
 * @author zkr07
 * @date 2016年10月10日下午2:05:23
 */
public class PowerConstants
{
    public static final String PRPTMAIN = "prptmain";
    public static final String PRPCMAIN = "prpcmain";
    public static final String PRPCOPYMAIN = "prpcopymain";
    public static final String PRPPMAIN = "prppmain";
    
    public static final String PRPDCOMPANY = "prpdcompany";
    
    
    
    /**
     * 表名及其主键映射
     */
    public static Map<String,String> TABLE_PK = new HashMap<String,String>();
    static{
        TABLE_PK.put(PRPTMAIN, "proposalno");
        TABLE_PK.put(PRPCMAIN, "policyno");
        TABLE_PK.put(PRPCOPYMAIN, "applyno");
        TABLE_PK.put(PRPPMAIN, "applyno");
        TABLE_PK.put(PRPDCOMPANY, "comcode");
    }
    /**
     * 由于前台过来的url在数据库没有配置，暂且写死url和该url所属菜单taskcode的映射
     */
    public static Map<String,String> POWER_URL_TASKCODE_MAPPER = new HashMap<String,String>();
    static{
        //待处理批改
        POWER_URL_TASKCODE_MAPPER.put("/endorse/querySuspend", "gscore-front.handleendorse");
        //待处理投保单
        POWER_URL_TASKCODE_MAPPER.put("/proposal/querySuspendProposalPageInfo", "gscore-front.handleproposal");
        //单证下载菜单下的 电子保单查询，电子批单查询
        POWER_URL_TASKCODE_MAPPER.put("/epolicy/queryEpolicyPage", "gscore-front.visamanagement");
        POWER_URL_TASKCODE_MAPPER.put("/epolicy/queryEendorsePage", "gscore-front.visamanagement");
        //保单综合查询
        POWER_URL_TASKCODE_MAPPER.put("/commonquery/queryPageInfo", "gscore-front.synquery");
        //发票索要时的保单查询
        POWER_URL_TASKCODE_MAPPER.put("/commonquery/queryReceiptPage", "gscore-front.drawinvoice");
        //新增批改菜单时的保单查询
        POWER_URL_TASKCODE_MAPPER.put("/commonquery/forEndorse", "gscore-front.addendorse");
        //核批查询
        POWER_URL_TASKCODE_MAPPER.put("/endorse/queryApproval", "gscore-front.hebao");
        
        POWER_URL_TASKCODE_MAPPER.put("/company/queryCompany", "comm-front.organizationmanagement");
    }
    //taskid常量
    public static final String TASK_QUERY = "prppmain";
    /**共同体运维用户*/
    public static final String GRADE_001 = "001";
    /**执行机构超级用户*/
    public static final String GRADE_002 = "002";
    /**成员公司超级用户*/
    public static final String GRADE_003 = "003";
    /**成员公司管理用户*/
    public static final String GRADE_004 = "004";
    /**成员公司承保用户*/
    public static final String GRADE_005 = "005";
    
    // 上海保交所
    public static final String TOP_COMCODE = "000000";
    
    // 保险公司机构
    public static final String COMTYPE_01 = "01";
    // 共保体机构
    public static final String COMTYPE_02 = "02";
    
    //只能查询自己出的单子的权限控制taskcode
    public static final String SINGLEPOWER = "siglepower";
}
