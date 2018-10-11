package com.sinosoft.dms.core.bill.service.impl;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sinosoft.dms.api.bill.dto.BillDto;
import com.sinosoft.dms.core.bill.service.BillService;
import com.sinosoft.dms.core.bill.utils.BillNoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.dms.api.bill.dto.BillConditionDto;
import com.sinosoft.dms.core.bill.utils.BillRequestDataCheck;
import com.sinosoft.dms.core.common.enums.DmsErrorEnum;




/**
* @description （单号生成接口服务实现）这里把原来的服务实现备份
* @author dongyingchun
* @date 2016年9月14日下午2:30:30
*/
public class BillServiceOldImpl implements BillService {
    /** log日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(BillServiceOldImpl.class);
    
	private static String formatDate = new SimpleDateFormat("yyyy").format(new Date());
    
	@Autowired
	private BillNoUtil billNoUtil;
	/* (non-Javadoc)
	 * @see com.sinosoft.dms.bill.service.BillService#getProposalNo(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional (propagation = Propagation.NOT_SUPPORTED)
	public BillDto getProposalNo(BillConditionDto billConditionDto) throws Exception{
		
		LOGGER.error("投保单生成服务开始:riskCode={},comCode={}",billConditionDto.getRiskCode(),billConditionDto.getComCode());
		
		BillDto billDto = null;
		//需要判断传值过来的riskCode和comCode的准确
		billDto = BillRequestDataCheck.checkDataValid(billConditionDto.getRiskCode(), billConditionDto.getComCode());
		String proposalNo = "";
		//成功的
		if(null != billDto){//传入参数符合
			//取到当前年份
		    //T+险种代码+保险公司代码+年份
			if(DmsErrorEnum.DMS_SUCCESS.getCode().equals(billDto.getResultCode())){
				proposalNo = "T"+billConditionDto.getRiskCode()+billConditionDto.getComCode().substring(3, 6)+formatDate.substring(2, formatDate.length());
				try{
					
					//使用缓存,实现投保单号的生成
					proposalNo = billNoUtil.getNo(proposalNo, 9);
					
					billDto.setProposalNo(proposalNo);
					billDto.setResultCode(DmsErrorEnum.DMS_SUCCESS.getCode());
					billDto.setResultMsg(DmsErrorEnum.DMS_SUCCESS.getName());
				}catch(Exception e){
					LOGGER.error("投保单生成异常:errorCode={},errorMsg={},e={}",DmsErrorEnum.DMS_ERROR_2003.getCode(),DmsErrorEnum.DMS_ERROR_2003.getName(),e);
					billDto.setResultCode(DmsErrorEnum.DMS_ERROR_2003.getCode());
				    billDto.setResultMsg(DmsErrorEnum.DMS_ERROR_2003.getName());
				    throw e;
				}
				
			}else{
				billDto.setProposalNo(proposalNo);
				billDto.setResultCode(billDto.getResultCode());
				billDto.setResultMsg(billDto.getResultCode());
			}
			LOGGER.error("投保单生成服务结束:riskCode={},comCode={},proposalNo={}",billConditionDto.getRiskCode(),billConditionDto.getComCode(),proposalNo);
	        
		}else{
			billDto = new BillDto();
			billDto.setProposalNo(proposalNo);
		    billDto.setResultCode(DmsErrorEnum.DMS_ERROR_2003.getCode());
		    billDto.setResultMsg(DmsErrorEnum.DMS_ERROR_2003.getName());
		}
		
		//此处要和其他系统交互，查询序号：T+险种代码+保险公司代码+年份+自增长序号
		LOGGER.error("投保单生成服务结束riskCode"+billConditionDto.getRiskCode()+"    comCode"+billConditionDto.getComCode());
		
		return billDto;
	}
	
	@Override
	@Transactional (propagation = Propagation.NOT_SUPPORTED)
	public BillDto getOrderNo(BillConditionDto billConditionDto) throws Exception{
	    LOGGER.error("订单号生成服务开始:riskCode={},comCode={}",billConditionDto.getRiskCode(),billConditionDto.getComCode());
        
	    BillDto billDto = null;
        //需要判断传值过来的riskCode和comCode的准确
        billDto = BillRequestDataCheck.checkDataValid(billConditionDto.getRiskCode(), billConditionDto.getComCode());
        String orderNo = "";
        //成功的
        if(null != billDto){//传入参数符合
            //取到当前年份
            //T+险种代码+保险公司代码+年份
            if(DmsErrorEnum.DMS_SUCCESS.getCode().equals(billDto.getResultCode())){
                orderNo = "Q"+billConditionDto.getRiskCode()+billConditionDto.getComCode().substring(3, 6)+formatDate;
                try{
                    
                    //使用缓存,实现投保单号的生成
                    orderNo = billNoUtil.getNo(orderNo, 9);
                    
                    billDto.setOrderNo(orderNo);
                    billDto.setResultCode(DmsErrorEnum.DMS_SUCCESS.getCode());
                    billDto.setResultMsg(DmsErrorEnum.DMS_SUCCESS.getName());
                }catch(Exception e){
                    LOGGER.error("订单号生成异常:errorCode={},errorMsg={},e={}",DmsErrorEnum.DMS_ERROR_2008.getCode(),DmsErrorEnum.DMS_ERROR_2008.getName(),e);
                    billDto.setResultCode(DmsErrorEnum.DMS_ERROR_2008.getCode());
                    billDto.setResultMsg(DmsErrorEnum.DMS_ERROR_2008.getName());
                    throw e;
                }
                
            }else{
                billDto.setOrderNo(orderNo);
                billDto.setResultCode(billDto.getResultCode());
                billDto.setResultMsg(billDto.getResultCode());
            }
            
        }else{
            billDto = new BillDto();
            billDto.setOrderNo(orderNo);
            billDto.setResultCode(DmsErrorEnum.DMS_ERROR_2008.getCode());
            billDto.setResultMsg(DmsErrorEnum.DMS_ERROR_2008.getName());
        }
	    LOGGER.error("订单号生成服务开始:riskCode={},comCode={},orderNo={}",billConditionDto.getRiskCode(),billConditionDto.getComCode(),orderNo);
        
	    return billDto;
	}
	
	/* (non-Javadoc)
	 * @see com.sinosoft.dms.bill.service.BillService#getPolicyNo(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional (propagation = Propagation.NOT_SUPPORTED)
	public BillDto getPolicyNo(BillConditionDto billConditionDto)throws Exception{
		
		LOGGER.error("保单生成服务开始:riskCode={},comCode={}",billConditionDto.getRiskCode(),billConditionDto.getComCode());
		
		BillDto billDto = null;
		billDto = BillRequestDataCheck.checkDataValid(billConditionDto.getRiskCode(), billConditionDto.getComCode());
		String policyNo = "";
		if(null != billDto){
			if(DmsErrorEnum.DMS_SUCCESS.getCode().equals(billDto.getResultCode())){
				policyNo = "P"+billConditionDto.getRiskCode()+billConditionDto.getComCode().substring(3, 6)+formatDate.substring(2, formatDate.length());
				
				try{
					//使用缓存,实现保单号的生成
					policyNo = billNoUtil.getNo(policyNo, 9);
					billDto.setPolicyNo(policyNo);
					billDto.setResultCode(DmsErrorEnum.DMS_SUCCESS.getCode());
					billDto.setResultMsg(DmsErrorEnum.DMS_SUCCESS.getName());
				}catch(Exception e){
					LOGGER.error("保单号生成异常:errorCode={},errorMsg={},e={}",DmsErrorEnum.DMS_ERROR_2004.getCode(),DmsErrorEnum.DMS_ERROR_2004.getName(),e);
					billDto.setResultCode(DmsErrorEnum.DMS_ERROR_2004.getCode());
				    billDto.setResultMsg(DmsErrorEnum.DMS_ERROR_2004.getName());
				    throw e;
				}
				
			}else{
				billDto.setPolicyNo(policyNo);
				billDto.setResultCode(billDto.getResultCode());
				billDto.setResultMsg(billDto.getResultCode());
			}
		    
		}else{
			billDto = new BillDto();
			billDto.setPolicyNo(policyNo);
		    billDto.setResultCode(DmsErrorEnum.DMS_ERROR_2004.getCode());
		    billDto.setResultMsg(DmsErrorEnum.DMS_ERROR_2004.getName());
		}
		LOGGER.error("保单生成服务结束:riskCode={},comCode={},policyNo={}",billConditionDto.getRiskCode(),billConditionDto.getComCode(),policyNo);
        
		//此处要和其他系统交互，查询序号：T+险种代码+保险公司代码+年份+自增长序号
		return billDto;
	}
	
	
	/* (non-Javadoc)
	 * @see com.sinosoft.dms.bill.service.BillService#getEndorseNo(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional (propagation = Propagation.NOT_SUPPORTED)
	public BillDto getEndorseNo(BillConditionDto billConditionDto)throws Exception{
		
		LOGGER.error("批单生成服务开始:riskCode={},comCode={}",billConditionDto.getRiskCode(),billConditionDto.getComCode());
		
		BillDto billDto = new BillDto();
		billDto = BillRequestDataCheck.checkDataValid(billConditionDto.getRiskCode(), billConditionDto.getComCode());
		String endorseNo = "";
		if(null != billDto){
			
			if(DmsErrorEnum.DMS_SUCCESS.getCode().equals(billDto.getResultCode())){
				endorseNo = "E"+billConditionDto.getRiskCode()+billConditionDto.getComCode().substring(3, 6)+formatDate.substring(2, formatDate.length());
				try{
					//使用缓存,实现批单号的生成
					endorseNo = billNoUtil.getNo(endorseNo, 9);
					
					billDto.setEndorseNo(endorseNo);
					billDto.setResultCode(DmsErrorEnum.DMS_SUCCESS.getCode());
					billDto.setResultMsg(DmsErrorEnum.DMS_SUCCESS.getName());
				}catch(Exception e){
					LOGGER.error("批单号生成异常:errorCode={},errorMsg={},e={}",DmsErrorEnum.DMS_ERROR_2005.getCode(),DmsErrorEnum.DMS_ERROR_2005.getName(),e);
					billDto.setResultCode(DmsErrorEnum.DMS_ERROR_2005.getCode());
				    billDto.setResultMsg(DmsErrorEnum.DMS_ERROR_2005.getName());
				    throw e;
				}
			}else{
				billDto.setEndorseNo(endorseNo);
				billDto.setResultCode(billDto.getResultCode());
				billDto.setResultMsg(billDto.getResultCode());
			}
			
		}else{
			billDto = new BillDto();
			billDto.setEndorseNo(endorseNo);
		    billDto.setResultCode(DmsErrorEnum.DMS_ERROR_2005.getCode());
		    billDto.setResultMsg(DmsErrorEnum.DMS_ERROR_2005.getName());
		}
		
		LOGGER.error("批单生成服务结束:riskCode={},comCode={},endorseNo={}",billConditionDto.getRiskCode(),billConditionDto.getComCode(),endorseNo);
        
		
		//此处要和其他系统交互，查询序号：E+险种代码+保险公司代码+年份+自增长序号
		
		return billDto;
	}
	
	
	/* (non-Javadoc)
	 * @see com.sinosoft.dms.bill.service.BillService#getApplyNo(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional (propagation = Propagation.NOT_SUPPORTED)
	public BillDto getApplyNo(BillConditionDto billConditionDto)throws Exception{
		LOGGER.error("批单申请号生成服务开始:riskCode={},comCode={}",billConditionDto.getRiskCode(),billConditionDto.getComCode());
		
		BillDto billDto = new BillDto();
		billDto = BillRequestDataCheck.checkDataValid(billConditionDto.getRiskCode(), billConditionDto.getComCode());
		String applyNo = "";
		if(null != billDto){
			
			if(DmsErrorEnum.DMS_SUCCESS.getCode().equals(billDto.getResultCode())){
				
				applyNo = "A"+billConditionDto.getRiskCode()+billConditionDto.getComCode().substring(3, 6)+formatDate.substring(2, formatDate.length());
				
				//使用缓存,批单申请号
				try{
					applyNo = billNoUtil.getNo(applyNo, 9);
					
					billDto.setApplyNo(applyNo);
					billDto.setResultCode(DmsErrorEnum.DMS_SUCCESS.getCode());
					billDto.setResultMsg(DmsErrorEnum.DMS_SUCCESS.getName());
				}catch(Exception e){
					LOGGER.error("投保单号生成异常:errorCode={},errorMsg={},e={}",DmsErrorEnum.DMS_ERROR_2006.getCode(),DmsErrorEnum.DMS_ERROR_2006.getName(),e);
					billDto.setResultCode(DmsErrorEnum.DMS_ERROR_2006.getCode());
				    billDto.setResultMsg(DmsErrorEnum.DMS_ERROR_2006.getName());
				    throw e;
				}
				
			}else{
				billDto.setApplyNo(applyNo);
				billDto.setResultCode(billDto.getResultCode());
				billDto.setResultMsg(billDto.getResultCode());
			}
		    
		}else{
			billDto = new BillDto();
			billDto.setApplyNo(applyNo);
		    billDto.setResultCode(DmsErrorEnum.DMS_ERROR_2006.getCode());
		    billDto.setResultMsg(DmsErrorEnum.DMS_ERROR_2006.getName());
		}
		LOGGER.error("批单申请号生成服务结束:riskCode={},comCode={},applyNo={}",billConditionDto.getRiskCode(),billConditionDto.getComCode(),applyNo);
        
		return billDto;
	}
	
	
	/* (non-Javadoc)
	 * @see com.sinosoft.dms.bill.service.BillService#getItemNo(java.lang.String)
	 */
	@Override
	@Transactional (propagation = Propagation.NOT_SUPPORTED)
	public BillDto getItemNo(BillConditionDto billConditionDto)throws Exception{
		LOGGER.error("标的号生成服务开始:areaCode={}",billConditionDto.getAreaCode());
		
		BillDto billDto = new BillDto();
		String itemNo = "";
		//I+年份+地区代码+自增长序号 : 1+4+6+9
		itemNo = "I"+formatDate+billConditionDto.getAreaCode().substring(0, 6);
		
		//使用缓存,标的申请号
		try{
			itemNo = billNoUtil.getNo(itemNo, 9);
			
			billDto.setItemNo(itemNo);
			billDto.setResultCode(DmsErrorEnum.DMS_SUCCESS.getCode());
			billDto.setResultMsg(DmsErrorEnum.DMS_SUCCESS.getName());
		}catch(Exception e){
			LOGGER.error("标的号生成异常:errorCode={},errorMsg={},e={}",DmsErrorEnum.DMS_ERROR_2007.getCode(),DmsErrorEnum.DMS_ERROR_2007.getName(),e);
			billDto.setResultCode(DmsErrorEnum.DMS_ERROR_2007.getCode());
		    billDto.setResultMsg(DmsErrorEnum.DMS_ERROR_2007.getName());
		    throw e;
		}
	    LOGGER.error("标的号生成服务结束:areaCode={},itemNo={}",billConditionDto.getAreaCode(),itemNo);
        
		return billDto;
	}
	
	
	
	@Override
	@Transactional (propagation = Propagation.NOT_SUPPORTED)
	public BillDto getCustomerCode(BillConditionDto billConditionDto)throws Exception{
	    
	    LOGGER.error("客户编号生成服务开始:billtype={}",billConditionDto.getBillType());
        
	    BillDto billDto = new BillDto();
	    //如果是个人客户，传值customerCode_1,加11位序号，
	    //如果法人，则传值customerCode_2，加11位序号.进行截取处理，将_后面的截取
	    String customerCode = billConditionDto.getBillType();
	    try{
	        customerCode = billNoUtil.getNo(customerCode, 11);
	        
	        //对customerCode进行处理字符窜截取处理
	        customerCode = customerCode.substring(customerCode.indexOf("_")+1, customerCode.length());
	        
	        //处理完毕后进行赋值
	        billDto.setCustomerCode(customerCode);
	        billDto.setResultCode(DmsErrorEnum.DMS_SUCCESS.getCode());
            billDto.setResultMsg(DmsErrorEnum.DMS_SUCCESS.getName());
	    }catch(Exception e){
            LOGGER.error("客户编号生成异常:e={}",e);
            throw e;
        }
	    LOGGER.error("客户编号生成服务结束:billtype={},customerCode={}",billConditionDto.getBillType(),customerCode);
        
	    return billDto;
	}
	
	@Override
	@Transactional (propagation = Propagation.NOT_SUPPORTED)
	public BillDto getInuoCode(BillConditionDto billConditionDto)throws Exception{
	    
	    LOGGER.error("iNuo编号生成服务开始:billtype={}",billConditionDto.getBillType());
        
	    BillDto billDto = new BillDto();
	    //如果是个人客户，传值customerCode_1,加11位序号，
	    //如果法人，则传值customerCode_2，加11位序号.进行截取处理，将_后面的截取
	    String inuoCode = billConditionDto.getBillType();
	    try{
	    	inuoCode = billNoUtil.getNo(inuoCode, 11);
	        
	        //对customerCode进行处理字符窜截取处理
	        inuoCode = inuoCode.substring(inuoCode.indexOf("_")+1, inuoCode.length());
	        
	        //处理完毕后进行赋值
	        billDto.setNuoCode(inuoCode);
	        billDto.setResultCode(DmsErrorEnum.DMS_SUCCESS.getCode());
            billDto.setResultMsg(DmsErrorEnum.DMS_SUCCESS.getName());
	    }catch(Exception e){
            LOGGER.error("iNuo编号生成异常:e={}",e);
            throw e;
        }
	    LOGGER.error("iNuo编号生成服务结束:billtype={},inuoCode={}",billConditionDto.getBillType(),inuoCode);
        
	    return billDto;
	}
	@Override
	@Transactional (propagation = Propagation.NOT_SUPPORTED)
	public BillDto getUnuoCode(BillConditionDto billConditionDto)throws Exception{
	    
	    LOGGER.error("uNuo编号生成服务开始:billtype={}",billConditionDto.getBillType());
        
	    BillDto billDto = new BillDto();
	    //如果是个人客户，传值customerCode_1,加11位序号，
	    //如果法人，则传值customerCode_2，加11位序号.进行截取处理，将_后面的截取
	    String unuoCode = billConditionDto.getBillType();
	    try{
	    	unuoCode = billNoUtil.getNo(unuoCode, 7);
	        
	        //对customerCode进行处理字符窜截取处理
	    	unuoCode = unuoCode.substring(unuoCode.indexOf("_")+1, unuoCode.length());
	        
	        //处理完毕后进行赋值
	        billDto.setNuoCode(unuoCode);
	        billDto.setResultCode(DmsErrorEnum.DMS_SUCCESS.getCode());
            billDto.setResultMsg(DmsErrorEnum.DMS_SUCCESS.getName());
	    }catch(Exception e){
            LOGGER.error("uNuo编号生成异常:e={}",e);
            throw e;
        }
	    LOGGER.error("uNuo编号生成服务结束:billtype={},unuoCode={}",billConditionDto.getBillType(),unuoCode);
        
	    return billDto;
	}
	
	@Override
	@Transactional (propagation = Propagation.NOT_SUPPORTED)
	public BillDto getSubNuoCode(BillConditionDto billConditionDto)throws Exception{
	    
	    LOGGER.error("subNuo编号生成服务开始:billtype={}",billConditionDto.getBillType());
        
	    BillDto billDto = new BillDto();
	    //如果是个人客户，传值customerCode_1,加11位序号，
	    //如果法人，则传值customerCode_2，加11位序号.进行截取处理，将_后面的截取
	    String subNuoCode = billConditionDto.getBillType();
	    try{
	    	subNuoCode = billNoUtil.getNo(subNuoCode, 13);
	        
	        //对customerCode进行处理字符窜截取处理
	    	subNuoCode = subNuoCode.substring(subNuoCode.indexOf("_")+1, subNuoCode.length());
	        
	        //处理完毕后进行赋值
	        billDto.setSubNuoCode(subNuoCode);
	        billDto.setResultCode(DmsErrorEnum.DMS_SUCCESS.getCode());
            billDto.setResultMsg(DmsErrorEnum.DMS_SUCCESS.getName());
	    }catch(Exception e){
            LOGGER.error("subNuo编号生成异常:e={}",e);
            throw e;
        }
	    LOGGER.error("subNuo编号生成服务结束:billtype={},subNuoCode={}",billConditionDto.getBillType(),subNuoCode);
        
	    return billDto;
	}
    
	@Override
	@Transactional (propagation = Propagation.NOT_SUPPORTED)
	public BillDto getSerialNo(BillConditionDto billConditionDto)throws Exception{
	   
	    LOGGER.error("系统中表主键流水号生成服务开始Billtype="+billConditionDto.getBillType());
        
	    BillDto billDto = new BillDto();
	    String cifSerialNo = "";
	    try{
	        long serialNo =0L;
	        //BillConditonDto中billType中，传值具体的表名_。例如：cifCustomer_。进行截取处理，将_后面的截取
	        serialNo = billNoUtil.getSerialNo(billConditionDto.getBillType());
            
	        //对取到单号进行处理
	        cifSerialNo=billConditionDto.getBillType()+serialNo;
	        serialNo = Long.parseLong(cifSerialNo.substring(cifSerialNo.indexOf("_")+1, cifSerialNo.length()));
	        //处理完毕后进行赋值
            billDto.setSerialNo(serialNo);
            billDto.setResultCode(DmsErrorEnum.DMS_SUCCESS.getCode());
            billDto.setResultMsg(DmsErrorEnum.DMS_SUCCESS.getName());
	    }catch(Exception e){
	        LOGGER.error("客户编号生成异常:e={}",e);
            throw e;
        }
	    LOGGER.error("系统中表主键流水号生成服务结束cifSerialNo="+cifSerialNo);
        
	    return billDto;
	}
    
	

}