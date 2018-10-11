package com.sinosoft.agriprpall.api.policymanage;

import com.sinosoft.agriprpall.api.AgriPrpallConstant;
import com.sinosoft.agriprpall.api.client.dto.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 单证系统交互相关的Api类
 * @Author: 何伟东
 * @Date: 2017/11/29 14:08
 */
@FeignClient(name = AgriPrpallConstant.AGRI_PRPALL_SERVICE_NAME, path = VisaApi.PATH)
public interface VisaApi {

    public static final String PATH = "visa";

    /**
     * 查询单证类型以及单证流水号服务
     * @author: 何伟东
     * @date: 2017/11/29 16:32
     * @param queryVisaCodesAndVisaSerialNosDto 包含businessNo业务号、comCode归属机构代码的Dto
     * @return 包含单证类型代码，单证类型名称，单证流水号的list
     */
    @RequestMapping(value = "queryVisaCodesAndVisaSerialNos", method = RequestMethod.POST)
    public @ResponseBody List<ResponseQueryVisaCodesAndVisaSerialNosDto> queryVisaCodesAndVisaSerialNos(@RequestBody RequestQueryVisaCodesAndVisaSerialNosDto queryVisaCodesAndVisaSerialNosDto);

    /**
     * 回写单证状态
     * @author: 何伟东
     * @date: 2017/11/30 9:56
     * @param requestVisaStatusWriteBackDto 包含业务号、归属及机构、流水号、单证类型
     * @return returnStatus 回写单证状态:1:成功;0:失败
     */
    @RequestMapping(value = "visaStatusWriteBack", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, String> visaStatusWriteBack(@RequestBody List<RequestVisaStatusWriteBackDto> requestVisaStatusWriteBackDto);

    /**
     * 废弃流水号
     *
     * @param requesttrashTranDto
     * @return ResponseQueryVisaCodeDto
     * @author: 钱浩
     * @date: 2017/11/30 9:56
     */
    @RequestMapping(value = "trashTrans", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, String> trashTrans(@RequestBody RequesttrashTranDto requesttrashTranDto) throws Exception;
    /**
     * 获取单证类型
     *
     * @param requestQueryVisaCodeDto
     * @return ResponseQueryVisaCodeDto
     * @author: 钱浩
     * @date: 2017/11/30 9:56
     */
    @RequestMapping(value = "visaType", method = RequestMethod.POST)
    public @ResponseBody
    ResponseQueryVisaCodeDto visaType(@RequestBody RequestQueryVisaCodeDto requestQueryVisaCodeDto) throws Exception;
}