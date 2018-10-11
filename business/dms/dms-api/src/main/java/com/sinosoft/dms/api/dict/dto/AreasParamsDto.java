package com.sinosoft.dms.api.dict.dto;

import com.sinosoft.framework.dto.BaseRequest;

import java.io.Serializable;

/**
 * @description 清单归属区域查询请求参数
 * @author dk
 * @date 2017年8月28日 下午2:29:51
 */
public class AreasParamsDto extends BaseRequest implements Serializable {

    /** 代码类型 */
    private String codeType;

    /** 上级行政区域代码 */
    private String fieldExt;

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getFieldExt() {
        return fieldExt;
    }

    public void setFieldExt(String fieldExt) {
        this.fieldExt = fieldExt;
    }
}
