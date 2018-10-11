package com.sinosoft.agriprpall.web.proposalmanage;

import com.sinosoft.agriprpall.api.proposalmanage.ProposalNoPrintApi;
import com.sinosoft.agriprpall.api.proposalmanage.dto.ResponseInsuranceFormPrintDto;
import com.sinosoft.agriprpall.core.proposalmanage.service.ProposalNoPrintService;
import com.sinosoft.framework.dto.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 08:03:36.446 
 * @description 机构代码表controller层
 */
@RestController
@RequestMapping(value = ProposalNoPrintController.PATH)
public class ProposalNoPrintController implements ProposalNoPrintApi {

    private static Logger LOGGER = LoggerFactory.getLogger(ProposalNoPrintController.class);

    @Autowired
    private ProposalNoPrintService proposalNoPrintService;

    /**
     * @description:投保单打印查询
     * @author: 陈道洋
     * @date: 2017/10/19 14:07
     * @param proposalNo
     * @return打印查询所需的数据
     * @throws Exception
     */
    @Override
    public @ResponseBody
    ResponseInsuranceFormPrintDto queryInsuranceFormPrintByCondition(@RequestParam(value = "proposalNo") String proposalNo) throws Exception {
        return proposalNoPrintService.queryInsuranceFormPrintByCondition(proposalNo)
                ;
    }

    /**
     * @description:根据投保单号和打印流水号回写打印流水号
     * @author: 陈道洋
     * @date: 2017/10/22 15:36
     * @param proposalNo 投保单号
     * @param printNo
     * @throws Exception
     */
     @Override
    public void upDatePrintNo(@RequestParam(value="proposalNo") String proposalNo, @RequestParam(value="printNo") String printNo) throws Exception {
        proposalNoPrintService.upDatePrintNo(proposalNo,printNo);
    }
}
