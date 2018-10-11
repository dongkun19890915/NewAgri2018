package com.sinosoft.agriprpall.web.policymanage;

import com.sinosoft.agriprpall.api.policymanage.CheckPolicyNoApi;
import com.sinosoft.agriprpall.api.policymanage.dto.CheckPolicyNoDto;
import com.sinosoft.agriprpall.core.policymanage.service.CheckPolicyNoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * * 检查保单号是否存在
 * @Author: 田慧
 * @Date: 2017/12/1 11:54
 */
@RestController
@RequestMapping(value = CheckPolicyNoController.PATH)
public class CheckPolicyNoController implements CheckPolicyNoApi{
    private static Logger LOGGER = LoggerFactory.getLogger(CheckPolicyNoController.class);
    @Autowired
    private CheckPolicyNoService checkPolicyNoService;
    /**
     *  检查保单号是否存在
     * @author: 田慧
     * @date: 2017/12/1 14:26
     * @param checkPolicyNoDto 自己定义的Dto 包括policyNo保单号、riskCode险种代码
     * @return map key是message，值分别为两种情况，一种是保单号系统中已存在，不可使用!请重输!，另一种是
     *         保单号已被投保单占用，不可使用!请重输!
     * @throws Exception
     */
    @Override
    public Map<String, String> checkPolicyNo(@RequestBody CheckPolicyNoDto checkPolicyNoDto) throws Exception{
        return checkPolicyNoService.checkPolicyNo(checkPolicyNoDto);
    }
}
