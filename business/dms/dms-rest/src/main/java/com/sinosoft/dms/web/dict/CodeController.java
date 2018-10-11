package com.sinosoft.dms.web.dict;

import com.sinosoft.dms.api.dict.CodeApi;
import com.sinosoft.dms.api.dict.dto.NewCodeQueryConditionDto;
import com.sinosoft.dms.api.dict.dto.PrpDnewCodeDto;
import com.sinosoft.dms.api.dict.dto.PrpDnewTypeDto;
import com.sinosoft.dms.core.dict.service.CodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;*/
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zxp on 2017/8/29.
 */
@RestController
@RequestMapping(value = CodeApi.PATH)
public class CodeController implements CodeApi {

    private static Logger LOGGER = LoggerFactory.getLogger(CodeController.class);

    @Resource
    private CodeService codeService;

	@Override
	@ResponseBody
	public List<PrpDnewCodeDto> queryNewCodeList(@RequestBody NewCodeQueryConditionDto newCodeQueryConditionDto) throws Exception{
		return codeService.queryNewCodeList(newCodeQueryConditionDto);
	}

	@Override
	@ResponseBody
	public List<PrpDnewCodeDto> queryNewCodeListByRiskCode(@RequestBody NewCodeQueryConditionDto newCodeQueryConditionDto) throws Exception{
		return codeService.queryNewCodeListByRiskCode(newCodeQueryConditionDto);
	}

	@Override
	@ResponseBody
	public List<PrpDnewCodeDto> queryNewCodeListByCodeLike(@RequestBody NewCodeQueryConditionDto newCodeQueryConditionDto) throws Exception{
		return codeService.queryNewCodeListByCodeLike(newCodeQueryConditionDto);
	}

	@Override
	public String transCodeCodeReturnCodeName(@RequestParam String codeType,@RequestParam String codeCode,@RequestParam boolean isChinese) throws Exception {
		return codeService.transCodeCodeReturnCodeName(codeType, codeCode, isChinese);
	}

	@Override
	public void deleteNewcode(@RequestBody PrpDnewCodeDto prpDNewCodeDto) throws Exception{
		codeService.deleteNewcode(prpDNewCodeDto);
	}

	@Override
	public void updateNewcode(@RequestBody PrpDnewCodeDto prpDNewCodeDto) throws Exception{
		codeService.updateNewcode(prpDNewCodeDto);
	}

	@Override
	public void insertNewcode(@RequestBody PrpDnewCodeDto prpDNewCodeDto) throws Exception{
		codeService.insertNewcode(prpDNewCodeDto);
	}

	@Override
	@ResponseBody
	public PrpDnewCodeDto queryByKey(@RequestBody PrpDnewCodeDto prpDNewCodeDto) throws Exception{
		return codeService.queryByKey(prpDNewCodeDto);
	}

	@Override
	@ResponseBody
	public List<PrpDnewTypeDto> getAllCodeType() throws Exception{
		return codeService.getAllCodeType();
	}

	/**
	 * 部署测试用
	 * @param
	 */
	@Override
	public String test(){
		System.out.println("has into");
		return "succ";
	}
}
