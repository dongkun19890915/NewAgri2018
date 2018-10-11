package com.sinosoft.dms.api.dict.dto;

import java.util.List;

/**查询prpDcode请求大Dto
* @author: 田健
* @Date: 2017/11/20 20:41
*/
public class RequestPrpDcodeListDto {

    private List<PrpDcodeListDto> prpDcodeListDtoList;

    public List<PrpDcodeListDto> getPrpDcodeListDtoList() {
        return prpDcodeListDtoList;
    }

    public void setPrpDcodeListDtoList(List<PrpDcodeListDto> prpDcodeListDtoList) {
        this.prpDcodeListDtoList = prpDcodeListDtoList;
    }
}
