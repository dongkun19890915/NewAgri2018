package com.sinosoft.agriprpall.core.proposalmanage.service;


import com.sinosoft.agriprpall.api.proposalmanage.dto.ResponseInsuranceFormPrintDto;

/**
 * @author codegen@研发中心
 * @mail admin@sinosoft.com.cn
 * @time  2017-10-18 08:03:36.446 
 * @description 机构代码表Core接口
 */
public interface ProposalNoPrintService {
    /**
     * @description:投保单打印
     * @author: 陈道洋
     * @date: 2017/10/19 14:07
     * @param proposalNo 投保单号
     * @return 打印查询所需的数据
     * @throws Exception
     */
    public ResponseInsuranceFormPrintDto queryInsuranceFormPrintByCondition(String proposalNo) throws Exception;

    /**
     * @description:投保单打印流水号查询
     * @author: 陈道洋
     * @date: 2017/10/19 14:07
     * @param proposalNo 投保单号
     * @return
     * @throws Exception
     */
    public void upDatePrintNo(String proposalNo, String printNo) throws Exception;

}