package com.sinosoft.agriprpall.api.proposalmanage;


import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.client.dto.ResponseGetTaxRateDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.CalNoTaxPremiumInfoDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.ProposalSaveDto;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-16 04:00:52.059 
 * @description 价税分离Api接口
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = LeviedFeeApi.PATH)
public interface LeviedFeeApi {

    public static final String PATH = "leviedfee";

    /**
     * 价税分离
     * @author: 钱浩
     * @date: 2017/10/28 9:27
     * @param proposalSaveDto 投保单保存对象
     * @return ResponseDto :ProposalSaveDto 投保单大对象
     * @throws Exception
     */
    @RequestMapping(value = "dealTMainForYGZ",method = {RequestMethod.POST})
    public @ResponseBody ProposalSaveDto dealTMainForYGZ(@RequestBody ProposalSaveDto proposalSaveDto) throws Exception;

    /**
     * 从页面点击币别确定时调用此价税分离服务
     * @author: 田健
     * @date: 2017/11/19 13:12
     * @param calNocTaxPremiumInfoDto 计算保费价税分离时传入的dto,包含保额、保费、险别等信息
     * @return 返回不含税保费、和税
     * @throws Exception
     */
    @RequestMapping(value = "dealTMainForYGZFromPage",method = {RequestMethod.POST})
    public @ResponseBody CalNoTaxPremiumInfoDto dealTMainForYGZFromPage(@RequestBody CalNoTaxPremiumInfoDto calNocTaxPremiumInfoDto)throws Exception;
}