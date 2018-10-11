package com.sinosoft.agriprpall.api.common.dto;

import java.io.Serializable;
import java.util.List;

/**共共封装请求dto(主要针对返回参数只有codeCode、codeCname)
* @Author: 田健
* @Date: 2017/12/12 10:40
*/
public class SelectTagQueryDto implements Serializable {
    private List<SelectTagListDto> selectTagListDtoList;

    public List<SelectTagListDto> getSelectTagListDtoList() {
        return selectTagListDtoList;
    }

    public void setSelectTagListDtoList(List<SelectTagListDto> selectTagListDtoList) {
        this.selectTagListDtoList = selectTagListDtoList;
    }
}
