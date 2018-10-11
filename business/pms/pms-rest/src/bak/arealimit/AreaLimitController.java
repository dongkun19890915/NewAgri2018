package com.sinosoft.pms.web.arealimit;


import com.sinosoft.framework.dto.PageInfo;
import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.pms.api.arealimit.AreaLimitApi;
import com.sinosoft.pms.api.arealimit.dto.AreaLimitQueryConditionDto;
import com.sinosoft.pms.api.arealimit.dto.AreaLimitReturnDto;
import com.sinosoft.pms.api.arealimit.dto.AreaLimitsDto;
import com.sinosoft.pms.api.arealimit.dto.PrpdAreaLimitDto;
import com.sinosoft.pms.core.arealimit.service.AreaLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description 区域销售限额控制器
 * @author yinqinzhu
 * @date 2016年10月22日下午5:21:23
 */
@RestController
@RequestMapping("/areaLimit")
public class AreaLimitController implements AreaLimitApi{
    @Autowired
    private AreaLimitService areaLimitService;

    
    /**
     * @description 查询区域销售限额
     * @param queryAreaLimitsDto
     * @return
     * @throws Exception
     * @author yinqinzhu
     * @date 2016年10月22日下午5:22:46
     */
    @RequestMapping(value = "getAreaLimit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto getAreaLimit(@RequestBody AreaLimitQueryConditionDto queryAreaLimitsDto)
        throws Exception
    {
        PrpdAreaLimitDto prpdAreaLimitDto = areaLimitService.getAreaLimit(queryAreaLimitsDto);
        return ResponseDto.instance(prpdAreaLimitDto);
    }

    
    /**
     * @description 区域销售限额查询列表
     * @param queryAreaLimitsDto
     * @return
     * @throws Exception
     * @author yinqinzhu
     * @date 2016年10月22日下午5:23:04
     */
    @RequestMapping(value = "queryAreaLimitList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto queryAreaLimitList(@RequestBody AreaLimitQueryConditionDto queryAreaLimitsDto)
        throws Exception
    {
        PageInfo<PrpdAreaLimitDto> page = areaLimitService.queryAreaLimitList(queryAreaLimitsDto);
        return ResponseDto.instance(page);
    }

    
    /**
     * @description 查询最新有效的版次信息
     * @return
     * @throws Exception
     * @author yinqinzhu
     * @date 2016年10月22日下午5:23:14
     */
    @RequestMapping(value = "queryLateAreaLimit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto queryLateAreaLimit()
        throws Exception
    {
        List<PrpdAreaLimitDto> listAreaLimt = areaLimitService.queryLateAreaLimit();
        return ResponseDto.instance(listAreaLimt);
    }

    
    /**
     * @description 区域销售限额保存
     * @param savereaLimitsDto
     * @return
     * @throws Exception
     * @author yinqinzhu
     * @date 2016年10月22日下午5:23:38
     */
    @RequestMapping(value = "saveAreaLimit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto saveAreaLimits(@RequestBody AreaLimitsDto savereaLimitsDto)
        throws Exception
    {
        AreaLimitReturnDto areaLimitReturnDto = areaLimitService.saveAreaLimits(savereaLimitsDto);
        return ResponseDto.instance(areaLimitReturnDto);
    }

}
