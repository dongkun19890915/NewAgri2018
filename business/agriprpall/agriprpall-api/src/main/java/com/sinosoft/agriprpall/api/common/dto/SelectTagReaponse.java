package com.sinosoft.agriprpall.api.common.dto;

import java.io.Serializable;
import java.util.List;

/**公共查询返回DTO集合
* @Author: 田健
* @Date: 2017/12/12 12:01
*/
public class SelectTagReaponse implements Serializable {
    private List<SelectTagRetuenDto> selectTagRetuenDtoList;

    public List<SelectTagRetuenDto> getSelectTagRetuenDtoList() {
        return selectTagRetuenDtoList;
    }

    public void setSelectTagRetuenDtoList(List<SelectTagRetuenDto> selectTagRetuenDtoList) {
        this.selectTagRetuenDtoList = selectTagRetuenDtoList;
    }
}
