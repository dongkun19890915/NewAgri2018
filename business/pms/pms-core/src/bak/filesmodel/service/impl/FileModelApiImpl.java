package com.sinosoft.pms.core.filesmodel.service.impl;

import com.sinosoft.framework.core.convert.BeanConverter;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.pms.api.filesmodel.dto.ModelFilesQueryConditionDto;
import com.sinosoft.pms.api.filesmodel.dto.PrpDfilesModelDto;
import com.sinosoft.pms.api.filesmodel.dto.PrpDpayOfNoticeDto;
import com.sinosoft.pms.core.filesmodel.dao.PrpDfilesModelDao;
import com.sinosoft.pms.core.filesmodel.entity.PrpDfilesModelKey;
import com.sinosoft.pms.core.filesmodel.service.FileModelService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;


/**
* @description excel模板下载实现类
* @author dongyingchun
* @date 2016年9月19日下午2:10:20
*/
@Service
public class FileModelApiImpl extends BaseServiceImpl implements FileModelService {
	/** log日志 */
	private static Log LOGGER = LogFactory.getLog(FileModelApiImpl.class);
	
	@Autowired
	private PrpDfilesModelDao prpDfilesModelDao;

	@Override
	public PrpDfilesModelDto downLoadModelExcel(ModelFilesQueryConditionDto modelFilesQueryConditionDto){
		PrpDfilesModelDto prpDfilesModelDto = new PrpDfilesModelDto();
		LOGGER.error("******Excel模板下载开始******riskCode"+modelFilesQueryConditionDto.getRiskCode()+"**ModelType="+modelFilesQueryConditionDto.getModelType());
		//需要判断传入的两个不能为空
		if(null != modelFilesQueryConditionDto.getRiskCode() && !"".equals(modelFilesQueryConditionDto.getModelType())
				&& null != modelFilesQueryConditionDto.getModelType() && !"".equals(modelFilesQueryConditionDto.getModelType())){
			PrpDfilesModelKey key = new PrpDfilesModelKey();
			key.setRiskCode(modelFilesQueryConditionDto.getRiskCode());
			key.setModelType(modelFilesQueryConditionDto.getModelType());
			//进行查询并转换对象
			prpDfilesModelDto = this.convert(prpDfilesModelDao.findOne(key), PrpDfilesModelDto.class);
		}
		
		LOGGER.error("******Excel模板下载结束******riskCode"+prpDfilesModelDto.getRiskCode()+"**ModelType="+prpDfilesModelDto.getModelType()+"**ModelUrl()"+prpDfilesModelDto.getModelUrl());
		
		return prpDfilesModelDto;
	}
	
	
	@Override
	public String dowLoadPayOfNotice(PrpDpayOfNoticeDto prpDpayOfNoticeDto) throws Exception{
		LOGGER.error("******付款通知书生成开始******ProposalNo=="+prpDpayOfNoticeDto.getProposalNo());
		String s= "成功";
		//需要读取本地的工程项目下的模版
		
		
		
		ClassLoader classLoader = getClass().getClassLoader();  
		File file = new File(classLoader.getResource("files"+File.separator+"payOfNoticeModel.doc").getFile());  
		
		InputStream fis = new FileInputStream(file);
		
		OutputStream os = null;
		InputStream fisReturn = null;
		try { 
			
			//对word文档进行处理
			HWPFDocument doc = new HWPFDocument(fis);  
			Range range = doc.getRange();  
			
			//投保人名称
	        range.replaceText("${proposalName}", prpDpayOfNoticeDto.getProposalName());  
	        range.replaceText("${proposalNo}", prpDpayOfNoticeDto.getProposalName());  
	        range.replaceText("${date}", prpDpayOfNoticeDto.getStrDate());  
	        range.replaceText("${premium}", prpDpayOfNoticeDto.getPremium());  
	        range.replaceText("${AccountName}", prpDpayOfNoticeDto.getAccountName());  
	        range.replaceText("${AccountNumber}", prpDpayOfNoticeDto.getAccountNumber());  
	        range.replaceText("${AccountBank}", prpDpayOfNoticeDto.getAccountBank());  
	        
	        //生成文件
	        //
	        os = new FileOutputStream(new File(classLoader.getResource("files"+File.separator+"payOfNoticeModel.doc").getFile()));  
//	        os = new FileOutputStream("C:\\word\\payOfNotice.doc");  
			doc.write(os); 
			
		      
		    //读取新文件,并返回文件流
//			fisReturn = new FileInputStream("C:\\word\\payOfNotice.doc");
		      
		
		}catch(Exception e){
			LOGGER.error("生成付款通知书错误",e);
			
		}finally{
			//
			if(null != fis){
				fis.close();
			}
			if(null != os){
				os.close();
			}
			if(null != fisReturn){
				fisReturn.close();
			}
			
		}
		
		LOGGER.error("******付款通知书生成结束******ProposalNo=="+prpDpayOfNoticeDto.getProposalNo());
		
		
		return s;
		
	}
	

}
