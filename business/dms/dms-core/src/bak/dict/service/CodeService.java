package com.sinosoft.dms.core.dict.service;

import com.sinosoft.dms.api.dict.dto.PrpDNewCodeDto;

import java.util.List;

/**
* @description （prpdcode的码表的接口服务）
* @author ThinkPad
* @date 2016年9月13日下午7:21:41
*/
public interface CodeService{
	
	/**
	* @description （prpdcode的码表的接口方法）
	* @param newCodeQueryConditionDto
	* @return
	* @author dongyingchun
	* @date 2016年9月13日下午7:22:04
	*/
	public List<PrpDNewCodeDto> searchCodes(NewCodeQueryConditionDto newCodeQueryConditionDto);

	public List<PrpDNewCodeDto> fuzzySearchCodes(NewCodeQueryConditionDto newCodeQueryConditionDto);

	/**
	 * 
	 * @description 转码服务
	 * @param newCodeQueryConditionDto  codeType,codeValue 必填 ，否则返回 空
	 * @return
	 * @author zkr16
	 * @date 2016年10月7日上午10:20:45
	 */
	public PrpDNewCodeDto transCodeCodeReturnCodeName(NewCodeQueryConditionDto newCodeQueryConditionDto) throws Exception;
	
	/**
	 * 删除单条code
	 * @param prpDNewCodeDto
	 */
	public void deleteNewcode(PrpDNewCodeDto prpDNewCodeDto);
	
	public void updateNewcode(PrpDNewCodeDto prpDNewCodeDto);
	
	public void insertNewcode(PrpDNewCodeDto prpDNewCodeDto);

	public PrpDNewCodeDto queryByKey(PrpDNewCodeDto prpDNewCodeDto);
	
	public PrpDNewCodeDto queryCodeCacheRedis();

}