package com.sinosoft.agriclaim.web.common;


import com.sinosoft.agriclaim.api.common.InitSelectClaimApi;
import com.sinosoft.agriclaim.api.common.dto.SelectClaimListDto;
import com.sinosoft.agriclaim.api.common.dto.SelectClaimRetuenDto;
import com.sinosoft.agriclaim.core.common.InitSelectClaimService;
import com.sinosoft.dms.api.dict.dto.PrpDcodeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 双击域公共封装
 * @Author: 孙朋飞
 * @Date: 2018/1/18 11:33
 */
@RestController
@RequestMapping(value = InitSelectClaimController.PATH)
public class InitSelectClaimController implements InitSelectClaimApi{
    private static Logger LOGGER = LoggerFactory.getLogger(InitSelectClaimController.class);
    @Autowired
    private InitSelectClaimService initSelectClaimService;

    /**
     * @author: 孙朋飞
     * @date: 2018/1/18 11:26
     * @param selectClaimListDto 入参dto,codeType-业务类型，riskCode-险种代码，comCode-机构代码，codeCode英文代码，
     *                           codeCName机构代码，userCode用户代码，upperCode上级代码，methodCode查询代码
     * @return SelectClaimRetuenDto 返回dto
     * @throws Exception
     */
    @Override
    public @ResponseBody SelectClaimRetuenDto initSelectClaim(@RequestBody SelectClaimListDto selectClaimListDto) throws Exception {
        return initSelectClaimService.initSelectClaim(selectClaimListDto);
    }

    /**
     * 查询报案方法列表的后端
     * @author: 王保良
     * @date: 2018/1/18 11:26
     * @return PrpDcodeDto 返回dto
     * @throws Exception
     */
    @Override
    public List<PrpDcodeDto> queryReportType() throws Exception {
        return initSelectClaimService.queryReportType();
    }
}
