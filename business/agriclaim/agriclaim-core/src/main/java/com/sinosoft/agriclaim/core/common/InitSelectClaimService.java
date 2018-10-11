package com.sinosoft.agriclaim.core.common;

import com.sinosoft.agriclaim.api.common.dto.SelectClaimListDto;
import com.sinosoft.agriclaim.api.common.dto.SelectClaimRetuenDto;
import com.sinosoft.dms.api.dict.dto.PrpDcodeDto;

import java.util.List;

/**
 * 双击域公共封装
 * @Author: 孙朋飞
 * @Date: 2018/1/18 11:31
 */
public interface InitSelectClaimService {
    /**
     * @author: 孙朋飞
     * @date: 2018/1/18 11:26
     * @param selectClaimListDto 入参dto,codeType-业务类型，riskCode-险种代码，comCode-机构代码，codeCode英文代码，
     *                           codeCName机构代码，userCode用户代码，upperCode上级代码，methodCode查询代码
     * @return SelectClaimRetuenDto 返回dto
     * @throws Exception
     */
    public SelectClaimRetuenDto initSelectClaim(SelectClaimListDto selectClaimListDto) throws Exception;

    /**
     * 查询报案方法列表的后端
     * @author: 王保良
     * @date: 2018/1/18 11:26
     * @return PrpDcodeDto 返回dto
     * @throws Exception
     */
    public List<PrpDcodeDto> queryReportType() throws Exception;
}
