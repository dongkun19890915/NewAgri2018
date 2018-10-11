package com.sinosoft.dms.core.bill.service.impl;
import com.sinosoft.dms.api.bill.dto.BillConditionDto;
import com.sinosoft.dms.core.bill.service.BillService;
import com.sinosoft.dms.core.bill.utils.BillNoUtil;
import com.sinosoft.dms.core.bill.utils.BillRequestDataCheck;
import com.sinosoft.dms.core.common.enums.BillNoPerfixEnum;
import com.sinosoft.dms.core.common.enums.DmsErrorEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
* @description 单号生成接口服务实现
* @author zxp
* @date 2017年8月28日
*/
@Service
@Transactional
public class BillServiceImpl implements BillService {
    /** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(BillServiceImpl.class);
    
	private static String formatYear = new SimpleDateFormat("yyyy").format(new Date());
    
	
	@Autowired
	private BillNoUtil billNoUtil;
	
	@Override
	@Transactional (propagation = Propagation.NOT_SUPPORTED)
	public String getBillNo(BillConditionDto billConditionDto) throws Exception {
		LOGGER.error("单号生成服务开始:riskCode={},comCode={}",billConditionDto.getRiskCode(),billConditionDto.getComCode());
		String billNo = getCommonNo(null,billConditionDto,DmsErrorEnum.DMS_ERROR_2009);
		LOGGER.error("单号生成服务结束:riskCode={},comCode={},proposalNo={}",billConditionDto.getRiskCode(),billConditionDto.getComCode(),billNo);
		return billNo;
	}
	
	@Override
	@Transactional (propagation = Propagation.NOT_SUPPORTED)
	public String getProposalNo(BillConditionDto billConditionDto) throws Exception{
		LOGGER.error("投保单生成服务开始:riskCode={},comCode={}",billConditionDto.getRiskCode(),billConditionDto.getComCode());
		String proposalNo = getCommonNo(BillNoPerfixEnum.PROPOSALNO,billConditionDto,DmsErrorEnum.DMS_ERROR_2003);
		LOGGER.error("投保单生成服务结束:riskCode={},comCode={},proposalNo={}",billConditionDto.getRiskCode(),billConditionDto.getComCode(),proposalNo);
		return proposalNo;
	}
	
	@Override
	@Transactional (propagation = Propagation.NOT_SUPPORTED)
	public String getOrderNo(BillConditionDto billConditionDto) throws Exception{
		LOGGER.error("订单号生成服务开始:riskCode={},comCode={}",billConditionDto.getRiskCode(),billConditionDto.getComCode());
		String orderNo = getCommonNo(BillNoPerfixEnum.ORDERNO,billConditionDto,DmsErrorEnum.DMS_ERROR_2008);
	    LOGGER.error("订单号生成服务开始:riskCode={},comCode={},orderNo={}",billConditionDto.getRiskCode(),billConditionDto.getComCode(),orderNo);
	    return orderNo;
	}
	
	@Override
	@Transactional (propagation = Propagation.NOT_SUPPORTED)
	public String getPolicyNo(BillConditionDto billConditionDto)throws Exception{
		LOGGER.error("保单生成服务开始:riskCode={},comCode={}",billConditionDto.getRiskCode(),billConditionDto.getComCode());
		String policyNo = getCommonNo(BillNoPerfixEnum.POLICYNO,billConditionDto,DmsErrorEnum.DMS_ERROR_2004);
		LOGGER.error("保单生成服务结束:riskCode={},comCode={},policyNo={}",billConditionDto.getRiskCode(),billConditionDto.getComCode(),policyNo);
		return policyNo;
	}
	
	
	@Override
	@Transactional (propagation = Propagation.NOT_SUPPORTED)
	public String getEndorseNo(BillConditionDto billConditionDto)throws Exception{
		LOGGER.error("批单生成服务开始:riskCode={},comCode={}",billConditionDto.getRiskCode(),billConditionDto.getComCode());
		String endorseNo = getCommonNo(BillNoPerfixEnum.ENDORSENO,billConditionDto,DmsErrorEnum.DMS_ERROR_2005);
		LOGGER.error("批单生成服务结束:riskCode={},comCode={},endorseNo={}",billConditionDto.getRiskCode(),billConditionDto.getComCode(),endorseNo);
		return endorseNo;
	}
	
	
	@Override
	@Transactional (propagation = Propagation.NOT_SUPPORTED)
	public String getApplyNo(BillConditionDto billConditionDto)throws Exception{
		LOGGER.error("批单申请号生成服务开始:riskCode={},comCode={}",billConditionDto.getRiskCode(),billConditionDto.getComCode());
		String applyNo = getCommonNo(BillNoPerfixEnum.APPLYNO,billConditionDto,DmsErrorEnum.DMS_ERROR_2006);
		LOGGER.error("批单申请号生成服务结束:riskCode={},comCode={},applyNo={}",billConditionDto.getRiskCode(),billConditionDto.getComCode(),applyNo);
		return applyNo;
	}
	
	
	/**
	 * 方案建议不调用
	 */
	@Override
	@Transactional (propagation = Propagation.NOT_SUPPORTED)
	public String getItemNo(BillConditionDto billConditionDto)throws Exception{
		LOGGER.error("标的号生成服务开始:areaCode={}",billConditionDto.getAreaCode());
		String itemNo = "";
		//I+年份+地区代码+自增长序号 : 1+4+6+9
		itemNo = "I"+formatYear+billConditionDto.getAreaCode().substring(0, 6);
		//使用缓存,标的申请号
		try{
			int length = 9;
			if(billConditionDto.getLength() >= 7){
				length = billConditionDto.getLength();
			}
			itemNo = billNoUtil.getNo(itemNo, length);
			LOGGER.error("标的号生成服务结束:areaCode={},itemNo={}",billConditionDto.getAreaCode(),itemNo);
			return itemNo;
		}catch(Exception e){
			LOGGER.error("标的号生成异常:errorCode={},errorMsg={},e={}",DmsErrorEnum.DMS_ERROR_2007.getCode(),DmsErrorEnum.DMS_ERROR_2007.getName(),e);
			throw new Exception("错误代码："+DmsErrorEnum.DMS_ERROR_2007.getCode()+"错误原因："+DmsErrorEnum.DMS_ERROR_2007.getName());
		}
	}
	
	
	@Override
	@Transactional (propagation = Propagation.NOT_SUPPORTED)
	public String getCustomerCode(BillConditionDto billConditionDto)throws Exception{
	    LOGGER.error("客户编号生成服务开始:billtype={}",billConditionDto.getBillType());
	    BillRequestDataCheck.checkCustomValid(billConditionDto.getBillType());
	    //如果是个人客户，传值customerCode_1,加11位序号，
	    //如果法人，则传值customerCode_2，加11位序号.进行截取处理，将_后面的截取
	    String customerCode = billConditionDto.getBillType();
	    try{
	    	int length = 11;
			if(billConditionDto.getLength() >= 7){
				length = billConditionDto.getLength();
			}
	        customerCode = billNoUtil.getNo(customerCode, length);
	        //对customerCode进行处理字符窜截取处理
	        customerCode = customerCode.substring(customerCode.indexOf("_")+1, customerCode.length());
		    LOGGER.error("客户编号生成服务结束:billtype={},customerCode={}",billConditionDto.getBillType(),customerCode);
	        return customerCode;
	    }catch(Exception e){
            LOGGER.error("客户编号生成异常:e={}",e);
            throw e;
        }
	}

    
	@Override
	@Transactional (propagation = Propagation.NOT_SUPPORTED)
	public String getSerialNo(BillConditionDto billConditionDto)throws Exception{
	    LOGGER.error("系统中表主键流水号生成服务开始Billtype="+billConditionDto.getBillType());
	    //看下这个玩意有啥用
	    String cifSerialNo = "";
	    try{
	        long serialNo =0L;
	        //BillConditonDto中billType中，传值具体的表名_。例如：cifCustomer_。进行截取处理，将_后面的截取
	        serialNo = billNoUtil.getSerialNo(billConditionDto.getBillType());
	        //对取到单号进行处理
	        cifSerialNo=billConditionDto.getBillType()+serialNo;
	        serialNo = Long.parseLong(cifSerialNo.substring(cifSerialNo.indexOf("_")+1, cifSerialNo.length()));
	        LOGGER.error("系统中表主键流水号生成服务结束="+cifSerialNo);
	        return serialNo+"";
	    }catch(Exception e){
	        LOGGER.error("主键流水号生成异常:e={}",e);
            throw e;
        }
	}
    
	
	/**
	 * 投保单号、保单号、批单号、批单申请号、试算单号 统一生成规则
	 * @return
	 * @throws Exception 
	 */
	private String getCommonNo(BillNoPerfixEnum billNoPerfixEnum,BillConditionDto billConditionDto,DmsErrorEnum dmsErrorEnum) throws Exception{
		String perfix = "";
		if(billNoPerfixEnum != null){
			perfix = billNoPerfixEnum.getPerfix();
		}else{
			BillRequestDataCheck.checkPerfix(billConditionDto.getPerfix());
			perfix = billConditionDto.getPerfix();
		}
		int length = 8;
		if(billConditionDto.getLength() >= 8){
			length = billConditionDto.getLength();
		}
				
		//需要判断传值过来的riskCode和comCode的准确
		BillRequestDataCheck.checkDataValid(billConditionDto.getRiskCode(), billConditionDto.getComCode());
		String commonNo = "";
		//取到当前年份
	    //perfix+险种代码+保险公司代码+年份
		commonNo = perfix+billConditionDto.getRiskCode()+billConditionDto.getComCode().substring(0, 7)+formatYear.substring(2, formatYear.length());
		try{
			//使用缓存,实现投保单号的生成 无需加锁
			commonNo = billNoUtil.getNo(commonNo, length);
		}catch(Exception e){
			LOGGER.error("业务单号生成异常",e);
			throw new Exception("错误代码："+dmsErrorEnum.getCode()+"错误原因："+dmsErrorEnum.getName());
		}
		return commonNo;
	}

}