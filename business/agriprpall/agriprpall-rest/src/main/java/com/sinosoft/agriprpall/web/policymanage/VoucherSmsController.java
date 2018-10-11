package com.sinosoft.agriprpall.web.policymanage;

import com.sinosoft.agriprpall.api.policymanage.VoucherSmsApi;
import com.sinosoft.agriprpall.core.policymanage.service.VoucherSmsService;
import com.sinosoft.framework.exception.DataVerifyException;
import com.sinosoft.notice.api.common.dto.NoticeReturnDto;
import com.sinosoft.notice.api.common.dto.ReqMessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 潘峰
 * @date 2017/12/19 上午10:16
 */
@RestController
@RequestMapping(value = VoucherSmsController.PATH)
public class VoucherSmsController implements VoucherSmsApi {


    @Autowired
    private VoucherSmsService voucherSmsService;

    @Override
    public NoticeReturnDto getSmsContent(@RequestBody ReqMessageDto reqMessageDto) throws Exception {
        return voucherSmsService.getSmsContent(reqMessageDto);
    }


    @Override
    public Map getSendNumber(@RequestBody Map<String, String> map) throws Exception {

        String policyNo = map.get("policyNo");
        if (null == policyNo) {
            throw new DataVerifyException("保单号为空");
        }
        String loginComCode = map.get("loginComCode");
        String userCode = map.get("userCode");
        String tableName = map.get("tableName");
        String userCodeFields = map.get("userCodeFields");
        String comCodeFields = map.get("comCodeFields");
        Integer sendNumber = voucherSmsService.getSendNumber(policyNo,loginComCode,userCode,tableName,userCodeFields,comCodeFields);
        Map<String, Integer> returnMap = new HashMap<>();
        returnMap.put("sendNumber", sendNumber);
        return returnMap;
    }


}
