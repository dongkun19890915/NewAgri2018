package com.sinosoft.agriprpall.api.policymanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.notice.api.common.dto.NoticeReturnDto;
import com.sinosoft.notice.api.common.dto.ReqMessageDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @author 潘峰
 * @date 2017/12/19 上午10:02
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = VoucherSmsApi.PATH)
public interface VoucherSmsApi {

    String PATH = "vouchersms";

    /**
     * 短信发送内容
     *
     * @param reqMessageDto
     * @return
     * @throws Exception
     * @author: 潘峰
     * @date: 2018/1/15 上午10:37
     */
    @RequestMapping(value = "getSmsContent", method = RequestMethod.POST)
    NoticeReturnDto getSmsContent(@RequestBody ReqMessageDto reqMessageDto) throws Exception;


    /**
     * 输入保单号返回需要发送短信条数
     *
     * @param map
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getSendNumber", method = RequestMethod.POST)
    Map getSendNumber(@RequestBody Map<String, String> map) throws Exception;

}
