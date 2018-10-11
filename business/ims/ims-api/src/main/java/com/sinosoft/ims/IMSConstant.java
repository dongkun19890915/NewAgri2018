package com.sinosoft.ims;

public class IMSConstant {
    public static final String IMS_SERVICE_NAME = "ims";
    public static final String PA_SERVICE_NAME = "prpall";
    public static final String DMS_SERVICE_NAME = "dms";
    
    // 查询的机构方式
    public static final int SELF_COMPANY = 1;//销售公司
    public static final int SAME_COMPANY = 2;//同级机构
    public static final int SUB_COMPANY = 3;//下级机构
    public static final int UPPER_COMPANY = 4;//上级机构
    
    //字符串连接符
    public static final String DILIMITER = "^";
    
    //权限类型
    public static final int ADD_CODE_POWER = 4;//代码权限
    public static final int ADD_CUSTOMER_POWER = 5;//客户代码权限
    
    //密码过期时长（3个月）PasswordExpireDate
    public static final int PASSWORD_EXPIRE_DATES = 90;
    public static final String PERFECT_COM_TREE = "perfectComTree";
    //查勘员岗位标识
    public static final String TASK_CLAIM_CHECK= "claim.check";
}
