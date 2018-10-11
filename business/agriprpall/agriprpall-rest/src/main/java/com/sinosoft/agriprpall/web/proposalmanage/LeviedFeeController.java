package com.sinosoft.agriprpall.web.proposalmanage;

import com.sinosoft.agriprpall.api.proposalmanage.LeviedFeeApi;
import com.sinosoft.agriprpall.api.proposalmanage.dto.CalNoTaxPremiumInfoDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.ProposalSaveDto;
import com.sinosoft.agriprpall.api.proposalmanage.dto.PrpTmainDto;
import com.sinosoft.agriprpall.core.proposalmanage.service.LeviedFeeService;
import com.sinosoft.framework.dto.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-24 12:54:07.447 
 * @description 分保接受人代码表controller层
 */
@RestController
@RequestMapping(value = LeviedFeeController.PATH)
public class LeviedFeeController implements LeviedFeeApi {

    private static Logger LOGGER = LoggerFactory.getLogger(LeviedFeeController.class);

    @Autowired
    private LeviedFeeService leviedFeeService;

    /**
     * 价税分离
     * @author: 钱浩
     * @date: 2017/10/28 9:27
     * @param proposalSaveDto 投保单保存对象
     * @return ResponseDto :ProposalSaveDto 投保单大对象
     * @throws Exception
     */
    @Override
    public @ResponseBody
    ProposalSaveDto dealTMainForYGZ(@RequestBody ProposalSaveDto proposalSaveDto) throws Exception{
        return  leviedFeeService.dealTMainForYGZ(proposalSaveDto);
    }
    /**
     * 从页面点击币别确定时调用此价税分离服务
     * @author: 田健
     * @date: 2017/11/19 13:12
     * @param calNocTaxPremiumInfoDto 计算保费价税分离时传入的dto,包含保额、保费、险别等信息
     * @return 返回不含税保费、和税
     * @throws Exception
     */
    @Override
    public CalNoTaxPremiumInfoDto dealTMainForYGZFromPage(@RequestBody CalNoTaxPremiumInfoDto calNocTaxPremiumInfoDto)throws Exception{
        return leviedFeeService.dealTMainForYGZFromPage(calNocTaxPremiumInfoDto);
    }
}
