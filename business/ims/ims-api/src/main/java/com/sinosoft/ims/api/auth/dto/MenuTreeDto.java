package com.sinosoft.ims.api.auth.dto;

import com.sinosoft.framework.dto.BaseDto;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单树对象
 * @Author: ldd
 * @Date: 2017/11/16 9:17
 */
public class MenuTreeDto extends BaseDto implements Serializable {
    private static final long serialVersionUID = 1L;

    //UtiMenu表信息对象
    private UtiMenuDto utiMenuDto;
    //子集菜单信息
    private List<MenuTreeDto> childMenuList;

    public UtiMenuDto getUtiMenuDto() {
        return utiMenuDto;
    }

    public void setUtiMenuDto(UtiMenuDto utiMenuDto) {
        this.utiMenuDto = utiMenuDto;
    }

    public List<MenuTreeDto> getChildMenuList() {
        return childMenuList;
    }

    public void setChildMenuList(List<MenuTreeDto> childMenuList) {
        this.childMenuList = childMenuList;
    }
}
