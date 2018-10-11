package com.sinosoft.dms.api.dict.dto;

import java.util.List;

/**prpDcode返回大对象，返回多个codeType对象
* @Author: 田健
* @Date: 2017/11/20 20:33
*/
public class ResponsePrpDcodeListDto {
    private List<PrpDcodeListDto> prpDcodeListDtoList;

    public List<PrpDcodeListDto> getPrpDcodeListDtoList() {
        return prpDcodeListDtoList;
    }

    public void setPrpDcodeListDtoList(List<PrpDcodeListDto> prpDcodeListDtoList) {
        this.prpDcodeListDtoList = prpDcodeListDtoList;
    }
}
