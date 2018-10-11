package com.sinosoft.dms.core.dict.service;

import com.sinosoft.dms.api.dict.dto.PrpDnewCodeDto;
import com.sinosoft.dms.api.dict.dto.PrpDnewTypeDto;
import com.sinosoft.dms.api.dict.dto.NewCodeQueryConditionDto;

import java.util.List;

/**
* @description （prpdnewcode的码表的接口服务）
* @author zxp
* @date 2016年8月29日
*/
public interface CodeService{
	
	/**
	 * 查询码表列表（不含险种权限关联）
	 * @param newCodeQueryConditionDto codeType必填
	 * @return
	 */
	public List<PrpDnewCodeDto> queryNewCodeList(NewCodeQueryConditionDto newCodeQueryConditionDto)throws Exception ;
	
	/**
	 * 查询码表列表（包含险种权限关联）
	 * @param newCodeQueryConditionDto codeType必填
	 * @return
	 */
	public List<PrpDnewCodeDto> queryNewCodeListByRiskCode(NewCodeQueryConditionDto newCodeQueryConditionDto)throws Exception ;

	/**
	 * 查询码表列表（可根据codecode模糊查询）
	 * @param newCodeQueryConditionDto codeType必填
	 * @return
	 */
	public List<PrpDnewCodeDto> queryNewCodeListByCodeLike(NewCodeQueryConditionDto newCodeQueryConditionDto)throws Exception ;
	
	/**
     * 根据主键查询码表
     * @param prpDNewCodeDto
     */
	public PrpDnewCodeDto queryByKey(PrpDnewCodeDto prpDNewCodeDto)throws Exception ;
	
	/**
	 * 转码服务 codeType、codecode、isChinese必填，isChinese：是否为中文 true中文 false英文
	 * @param codeType
	 * @param codeCode
	 * @param isChinese
	 * @return
	 * @throws Exception
	 */
	public String transCodeCodeReturnCodeName(String codeType, String codeCode, boolean isChinese) throws Exception;
    
    /**
     * 删除码表数据
     * @param prpDNewCodeDto
     */
	public void deleteNewcode(PrpDnewCodeDto prpDNewCodeDto)throws Exception ;
	
	/**
     * 更新码表数据
     * @param prpDNewCodeDto
     */
	public void updateNewcode(PrpDnewCodeDto prpDNewCodeDto)throws Exception ;
	
	/**
     * 插入码表数据
     * @param prpDNewCodeDto
     */
	public void insertNewcode(PrpDnewCodeDto prpDNewCodeDto)throws Exception ;
	
	/**
     * 获取所有码表类型
     * @param prpDNewCodeDto
     */
    public List<PrpDnewTypeDto> getAllCodeType()throws Exception ;

}