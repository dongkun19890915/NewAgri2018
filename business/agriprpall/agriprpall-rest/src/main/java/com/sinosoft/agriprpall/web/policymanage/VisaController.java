package com.sinosoft.agriprpall.web.policymanage;

import com.sinosoft.agriprpall.api.client.dto.*;
import com.sinosoft.agriprpall.api.policymanage.VisaApi;
import com.sinosoft.agriprpall.core.policymanage.service.VisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 单证系统交互相关的Controller类
 * @Author: 何伟东
 * @Date: 2017/11/29 14:08
 */
@RestController
@RequestMapping(value = VisaController.PATH)
public class VisaController implements VisaApi {

    @Autowired
    private VisaService visaService;

    /**
     * 查询单证类型以及单证流水号服务
     * @author: 何伟东
     * @date: 2017/11/29 16:32
     * @param queryVisaCodesAndVisaSerialNosDto 包含businessNo业务号、comCode归属机构代码的Dto
     * @return 包含单证类型代码，单证类型名称，单证流水号的list
     */
    @Override
    public @ResponseBody List<ResponseQueryVisaCodesAndVisaSerialNosDto> queryVisaCodesAndVisaSerialNos(@RequestBody RequestQueryVisaCodesAndVisaSerialNosDto queryVisaCodesAndVisaSerialNosDto) {
        return visaService.queryVisaCodesAndVisaSerialNos(queryVisaCodesAndVisaSerialNosDto);
    }

    /**
     * 回写单证状态
     * @author: 何伟东
     * @date: 2017/11/30 9:56
     * @param requestVisaStatusWriteBackDto 包含业务号、归属及机构、流水号、单证类型
     * @return returnStatus 回写单证状态:1:成功;0:失败
     */
    @Override
    public @ResponseBody
    Map<String, String> visaStatusWriteBack(@RequestBody List<RequestVisaStatusWriteBackDto> requestVisaStatusWriteBackDto) {
        String returnStatus = visaService.visaStatusWriteBack(requestVisaStatusWriteBackDto);
        Map<String,String> map = new HashMap<>(1);
        map.put("returnStatus",returnStatus);
        return map;
    }

    /**
     * 废弃流水号
     * @param requesttrashTranDto
     * @return ResponseQueryVisaCodeDto
     * @author: 钱浩
     * @date: 2017/11/30 9:56
     */
    @RequestMapping(value = "trashTrans", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, String> trashTrans(@RequestBody RequesttrashTranDto requesttrashTranDto) throws Exception {
        return visaService.trashTrans(requesttrashTranDto);
    }

    /**
     * 获取单证类型
     *
     * @param requestQueryVisaCodeDto
     * @return ResponseQueryVisaCodeDto
     * @author: 钱浩
     * @date: 2017/11/30 9:56
     */
    public @ResponseBody
    ResponseQueryVisaCodeDto visaType(@RequestBody RequestQueryVisaCodeDto requestQueryVisaCodeDto) throws Exception {
        return visaService.visaType(requestQueryVisaCodeDto);
    }

}