package com.sinosoft.dms.core.bill.utils;


import com.sinosoft.dms.api.bill.dto.BillDto;
import com.sinosoft.dms.core.common.enums.DmsErrorEnum;
import org.springframework.stereotype.Service;

/**
* @description （单号生成入参参数校验）
* @author dongyingchun
* @date 2016年9月14日下午2:50:10
*/
@Service
public class BillRequestDataCheck {
	
	
	/**
	* @description （校验存入参数的准确性）
	* @param riskCode  险种
	* @param comCode  机构编码(需要大雨6位，截取3,6位)
	* @return
	* @author dongyingchun
	* @throws Exception 
	* @date 2016年9月14日下午2:52:03
	*/
	public final static void checkDataValid(String riskCode, String comCode) throws Exception{
		//判断险种位四位  //判断机构编码大于6位
		if(riskCode.length()!= 4 || comCode.length()<6){
//			billDto.setResultCode(DmsErrorEnum.DMS_ERROR_1003.getCode());
//			billDto.setResultCode(DmsErrorEnum.DMS_ERROR_1003.getName());
//			return billDto;
			throw new Exception("错误代码："+DmsErrorEnum.DMS_ERROR_1003.getCode()+"错误原因："+DmsErrorEnum.DMS_ERROR_1003.getName());
		}
	}
	
	
	/**
	 * 校验获取客户编码入参正确性
	 * @param billType
	 * @return
	 */
	public final static BillDto checkCustomValid(String billType) throws Exception{
		BillDto billDto = new BillDto();
		//判断险种位四位  //判断机构编码大于6位
		if(",customerCode_1,customerCode_2,".indexOf(billType) == -1){
//			billDto.setResultCode(DmsErrorEnum.DMS_ERROR_1004.getCode());
//			billDto.setResultCode(DmsErrorEnum.DMS_ERROR_1004.getName());
//			return billDto;
			throw new Exception("错误代码："+DmsErrorEnum.DMS_ERROR_1004.getCode()+"错误原因："+DmsErrorEnum.DMS_ERROR_1004.getName());
		}else{
			billDto.setResultCode(DmsErrorEnum.DMS_SUCCESS.getCode());
			return billDto;
		}
		
	}
}
