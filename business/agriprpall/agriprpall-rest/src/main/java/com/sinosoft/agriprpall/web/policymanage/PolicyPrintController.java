package com.sinosoft.agriprpall.web.policymanage;

import com.sinosoft.agriprpall.api.policymanage.PolicyPrintApi;
import com.sinosoft.agriprpall.api.policymanage.dto.ResItemKindDto;
import com.sinosoft.agriprpall.core.policymanage.service.PolicyPrintService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author codegen@研发中心
 * @mail codegen@sinosoft.com.cn
 * @time  2017-10-22 07:54:48.524 
 * @description 保单标的子险信息表controller层
 */
@RestController
@RequestMapping(value = PolicyPrintController.PATH)
public class PolicyPrintController implements PolicyPrintApi {

    private static Logger LOGGER = LoggerFactory.getLogger(PolicyPrintController.class);

    @Autowired
    private PolicyPrintService policyPrintService;

    /**
     * @description: 根据保单号查询主险信息
     * @author: 何伟东
     * @date: 2017/10/22 16:10
     * @param policyNo
     * @return
     */
    @Override
    public @ResponseBody
    ResItemKindDto queryMainItemKindListByPolicyNo(@RequestParam(value = "policyNo") String policyNo) {
        return policyPrintService.queryItemKindListByPolicyNo(policyNo,"main");
    }

    /**
     * @description: 根据保单号查询附加险信息
     * @author: 何伟东
     * @date: 2017/10/22 16:10
     * @param policyNo
     * @return
     */
    @Override
    public ResItemKindDto querySubItemKindListByPolicyNo(String policyNo) {
        return policyPrintService.queryItemKindListByPolicyNo(policyNo,"sub");
    }
}
