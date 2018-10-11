package com.sinosoft.agriprpall.api.common.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**共共封装请求dto(主要针对返回参数只有codeCode、codeCname)
* @Author: 田健
* @Date: 2017/12/12 10:40
*/
public class SelectTagRetuenDto implements Serializable{
    /**代码类型 */
    private String codeType;

    private List<SelectTagCodeDto> codeData = new ArrayList<SelectTagCodeDto>();

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public List<SelectTagCodeDto> getCodeData() {
        return codeData;
    }

    public void setCodeData(List<SelectTagCodeDto> codeData) {
        this.codeData = codeData;
    }
}
