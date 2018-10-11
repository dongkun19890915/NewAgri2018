package com.sinosoft.agriclaim.api.common;

import com.sinosoft.agriclaim.api.AgriClaimConstant;
import com.sinosoft.agriclaim.api.common.dto.SelectClaimListDto;
import com.sinosoft.agriclaim.api.common.dto.SelectClaimRetuenDto;
import com.sinosoft.dms.api.dict.dto.PrpDcodeDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * 双击域公共封装
 * @Author: 孙朋飞
 * @Date: 2018/1/18 11:34
 */
@FeignClient(name = AgriClaimConstant.AGRI_CLAIM_SERVICE_NAME, path = InitSelectClaimApi.PATH)
public interface InitSelectClaimApi {
    public static final String PATH = "initSelectClaim";
    /**
     * @author: 孙朋飞
     * @date: 2018/1/18 11:26
     * @param selectClaimListDto 入参dto,codeType-业务类型，riskCode-险种代码，comCode-机构代码，codeCode英文代码，
     *                           codeCName机构代码，userCode用户代码，upperCode上级代码，methodCode查询代码
     * @return SelectClaimRetuenDto 返回dto
     * @throws Exception
     */
    @RequestMapping(value = "initSelectClaim",method = {RequestMethod.POST})
    public @ResponseBody SelectClaimRetuenDto initSelectClaim(@RequestBody SelectClaimListDto selectClaimListDto) throws Exception;

    /**
     * 查询报案方法列表的后端
     * @author: 王保良
     * @date: 2018/1/18 11:26
     * @return PrpDcodeDto 返回dto
     * @throws Exception
     */
    @RequestMapping(value = "queryReportType",method = RequestMethod.POST)
    public @ResponseBody
    List<PrpDcodeDto> queryReportType() throws Exception;
}
