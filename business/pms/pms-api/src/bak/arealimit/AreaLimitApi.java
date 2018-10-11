package com.sinosoft.pms.api.arealimit;

import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.pms.PMSConstant;
import com.sinosoft.pms.api.arealimit.dto.AreaLimitQueryConditionDto;
import com.sinosoft.pms.api.arealimit.dto.AreaLimitsDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = PMSConstant.PMS_SERVICE_NAME, path = AreaLimitApi.PATH)
public interface AreaLimitApi {

    public static final String PATH = "areaLimit";

    /**
     * @param queryAreaLimitsDto
     * @return
     * @throws Exception
     * @description 查询区域销售限额
     * @author yinqinzhu
     * @date 2016年10月22日下午5:22:46
     */
    @RequestMapping(value = "getAreaLimit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto getAreaLimit(@RequestBody AreaLimitQueryConditionDto queryAreaLimitsDto) throws Exception;


    /**
     * @param queryAreaLimitsDto
     * @return
     * @throws Exception
     * @description 区域销售限额查询列表
     * @author yinqinzhu
     * @date 2016年10月22日下午5:23:04
     */
    @RequestMapping(value = "queryAreaLimitList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto queryAreaLimitList(@RequestBody AreaLimitQueryConditionDto queryAreaLimitsDto) throws Exception;


    /**
     * @return
     * @throws Exception
     * @description 查询最新有效的版次信息
     * @author yinqinzhu
     * @date 2016年10月22日下午5:23:14
     */
    @RequestMapping(value = "queryLateAreaLimit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto queryLateAreaLimit() throws Exception;


    /**
     * @param savereaLimitsDto
     * @return
     * @throws Exception
     * @description 区域销售限额保存
     * @author yinqinzhu
     * @date 2016年10月22日下午5:23:38
     */
    @RequestMapping(value = "saveAreaLimit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto saveAreaLimits(@RequestBody AreaLimitsDto savereaLimitsDto) throws Exception;
}
