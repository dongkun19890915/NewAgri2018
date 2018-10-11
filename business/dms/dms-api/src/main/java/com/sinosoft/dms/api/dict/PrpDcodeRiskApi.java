package com.sinosoft.dms.api.dict;

import com.sinosoft.dms.api.DMSConstant;
import com.sinosoft.dms.api.dict.dto.PrpDcodeRiskDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 特约及附加信息查询Api接口
 * @Author: 王保良
 * @Date: 2017/11/17 10:53
 */
@FeignClient(name = DMSConstant.DMS_SERVICE_NAME,path = PrpDcodeRiskApi.PATH )
public interface PrpDcodeRiskApi {
    public static final String PATH="prpDcodeRisk";

    /**
     * 根据险种代码查询CodeCode
     * @author 王保良
     * @param riskCode (险种代码)
     * @return List<String> codeCode的集合
     * @time 2017-11-17
     * @throws Exception
     */
    @RequestMapping(value = "queryCodeCode",method = RequestMethod.POST)
    public @ResponseBody List<String> queryCodeCode(@RequestParam("riskCode") String riskCode) throws Exception;
    
    /**
	 * @description:方法功能简述: 根据险种编码和类型查询PrpDcodeRiskDto数据
	 * @author 安齐崇
	 * @date 2017年12月14日下午11:51:07
	 * @param riskCodes
	 * @param codeType
	 * @return
	 */
	@RequestMapping(value = "queryByRiskTypeAndCode",method = {RequestMethod.POST} )
    @ResponseBody
	List<PrpDcodeRiskDto> queryByCodesAndType(@RequestParam("riskCodes") String riskCodes,@RequestParam("codeType") String codeType);
}
