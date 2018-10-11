package com.sinosoft.dms.api.dict;

import com.sinosoft.dms.api.DMSConstant;
import com.sinosoft.dms.api.dict.dto.PrpDnewCodeDto;
import com.sinosoft.dms.api.dict.dto.PrpDnewTypeDto;
import com.sinosoft.dms.api.dict.dto.NewCodeQueryConditionDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
* @description （prpdnewcode的码表的接口服务）
* @author zxp
* @date 2017年8月29日
*/
@Api(value = "codeApi", description = "通用代码接口")
@FeignClient(name = DMSConstant.DMS_SERVICE_NAME, path = CodeApi.PATH)
public interface CodeApi {

	public static final String PATH = "code";
	
	/**
	 * 查询码表列表（不含险种权限关联）
	 * @param newCodeQueryConditionDto codeType必填
	 * @return
	 */
    @RequestMapping(value = "codeList",method = {RequestMethod.POST} ,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public List<PrpDnewCodeDto> queryNewCodeList(@RequestBody NewCodeQueryConditionDto newCodeQueryConditionDto)throws Exception;
    
    
    /**
	 * 查询码表列表（包含险种权限关联）
	 * @param newCodeQueryConditionDto codeType必填
	 * @return
	 */
    @RequestMapping(value = "codeListRisk",method = {RequestMethod.POST} ,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public List<PrpDnewCodeDto> queryNewCodeListByRiskCode(@RequestBody NewCodeQueryConditionDto newCodeQueryConditionDto)throws Exception;
    
    
    /**
	 * 查询码表列表（可根据codecode模糊查询）
	 * @param newCodeQueryConditionDto codeType必填
	 * @return
	 */
    @RequestMapping(value = "codeListLike",method = {RequestMethod.POST},consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public List<PrpDnewCodeDto> queryNewCodeListByCodeLike(@RequestBody NewCodeQueryConditionDto newCodeQueryConditionDto)throws Exception;

	/**
	 * 转码服务 codeType、codecode、flag必填，flag：是否为中文 true中文 false英文
	 * @param codeType
	 * @param codeCode
	 * @param isChinese
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value = "transCodeCode",method = {RequestMethod.POST})
	public String transCodeCodeReturnCodeName(@RequestParam(value = "codeType") String codeType, @RequestParam(value = "codeCode") String codeCode, @RequestParam(value = "isChinese") boolean isChinese) throws Exception;
    
    /**
     * 删除码表数据
     * @param prpDNewCodeDto
     */
	@RequestMapping(value = "deleteNewcode",method = {RequestMethod.POST},consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteNewcode(@RequestBody PrpDnewCodeDto prpDNewCodeDto)throws Exception;
	
	/**
     * 更新码表数据
     * @param prpDNewCodeDto
     */
	@RequestMapping(value = "updateNewcode",method = {RequestMethod.POST},consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateNewcode(@RequestBody PrpDnewCodeDto prpDNewCodeDto)throws Exception;
	
	/**
     * 插入码表数据
     * @param prpDNewCodeDto
     */
	@RequestMapping(value = "insertNewcode",method = {RequestMethod.POST},consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertNewcode(@RequestBody PrpDnewCodeDto prpDNewCodeDto)throws Exception;
	
	/**
     * 根据主键查询码表
     * @param prpDNewCodeDto
     */
    @ApiOperation(value = "通用代码查询",notes = "根据主键查询通用代码", response = PrpDnewCodeDto.class)
	@RequestMapping(value = "queryByKey",method = {RequestMethod.POST},consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public PrpDnewCodeDto queryByKey(@RequestBody PrpDnewCodeDto prpDNewCodeDto)throws Exception;
	
	/**
     * 获取所有码表类型
     * @param
     */
    @RequestMapping(value = "getallcodetype", method = RequestMethod.GET)
    @ResponseBody
    public List<PrpDnewTypeDto> getAllCodeType()throws Exception;

	/**
	 * 部署测试用
	 * @param
	 */
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String test();
}