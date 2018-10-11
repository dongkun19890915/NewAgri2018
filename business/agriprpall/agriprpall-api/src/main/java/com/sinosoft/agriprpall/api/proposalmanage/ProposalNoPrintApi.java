package com.sinosoft.agriprpall.api.proposalmanage;


import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.proposalmanage.dto.ResponseInsuranceFormPrintDto;
import com.sinosoft.framework.dto.ResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *（投保单打印查询）
 * @Author: 陈道洋
 * @Date: 2017/11/5 11:55
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = ProposalNoPrintApi.PATH)
public interface ProposalNoPrintApi {

    public static final String PATH = "proposalnoprint";

    /**
     * @description:投保单打印查询
     * @author: 陈道洋
     * @date: 2017/10/19 14:07
     * @param proposalNo 投保单号
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "queryInsuranceFormPrintByCondition",method = RequestMethod.POST)
   public @ResponseBody
    ResponseInsuranceFormPrintDto queryInsuranceFormPrintByCondition(@RequestParam(value = "proposalNo") String proposalNo) throws Exception;

    /**
     * @description:打印流水号回写
     * @author: 陈道洋
     * @date: 2017/10/23 8:37
     * @param proposalNo
     * @param printNo
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "upDatePrintNo",method = RequestMethod.POST)
    public void upDatePrintNo(@RequestParam(value = "proposalNo") String proposalNo, @RequestParam(value = "printNo") String printNo) throws Exception;
}