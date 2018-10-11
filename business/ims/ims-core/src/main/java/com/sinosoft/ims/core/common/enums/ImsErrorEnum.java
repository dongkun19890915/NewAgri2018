package com.sinosoft.ims.core.common.enums;

/**
 * @description 权限管理系统错误信息枚举类
 * @author hzhongkai
 * @date 2016年9月22日下午2:02:27
 */
public enum ImsErrorEnum {

    IMS_SUCCESS("0000", "处理成功"), IMS_ERROR("9999", "处理失败");

    // 数据校验错误（1打头）

    // 业务异常（2打头）

    // 查询异常（3打头）

    // 成员变量
    private String code;

    private String name;

    // 构造方法
    private ImsErrorEnum(String code, String name)
    {
        this.code = code;
        this.name = name;
    }

    /**
     * @description 通过名称获取代码
     * @param name
     *            错误信息描述
     * @return 错误信息代码
     * @author hzhongkai
     * @date 2016年9月22日下午2:04:44
     */
    public static String getCodeByName(String name)
    {
        for (ImsErrorEnum info : ImsErrorEnum.values())
        {
            if (name.indexOf(info.getName()) > -1)
            {
                return info.getCode();
            }
        }
        return "999";
    }

    public String getCode()
    {
        return code;
    }

    public String getName()
    {
        return name;
    }
}
