package com.sinosoft.dms.web.dict;


import com.sinosoft.dms.api.dict.PrpDcodeRiskApi;
import com.sinosoft.dms.api.dict.dto.PrpDcodeRiskDto;
import com.sinosoft.dms.core.dict.service.PrpDcodeRiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 特约及附加信息查询Controller
 * @Author: 王保良
 * @Date: 2017/11/17 10:53
 */
@RestController
@RequestMapping(value = PrpDcodeRiskApi.PATH)
public class PrpDcodeRiskController implements PrpDcodeRiskApi {

    @Autowired
    private PrpDcodeRiskService prpDcodeRiskService;

    /**
     * 根据险种代码查询CodeCode
     * @author 王保良
     * @param riskCode(险种代码)
     * @return List<String> codeCode的集合 因为是对内使用,所以并未封装成ResponseDto,请注意
     * @time 2017-11-17
     * @throws Exception
     */
    @Override
    public @ResponseBody List<String> queryCodeCode(@RequestParam("riskCode") String riskCode) throws Exception {
        return prpDcodeRiskService.queryCodeCode(riskCode);
    }
    /**
	 * @description:方法功能简述: 根据险种编码和类型查询PrpDcodeRiskDto数据
	 * @author 安齐崇
	 * @date 2017年12月14日下午11:51:07
	 * @param riskCodes
	 * @param codeType
	 * @return
	 */
    @Override
	@ResponseBody
	public List<PrpDcodeRiskDto> queryByCodesAndType(@RequestParam("riskCodes") String riskCodes,@RequestParam("codeType") String codeType) {
		return prpDcodeRiskService.queryByCodesAndType(riskCodes, codeType);
	}

}
