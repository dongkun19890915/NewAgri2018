package com.sinosoft.agriclaim.core.individuation.service.impl;

import com.sinosoft.agriclaim.api.individuation.dto.ImageDto;
import com.sinosoft.agriclaim.api.individuation.dto.ImageTypeDto;
import com.sinosoft.agriclaim.api.individuation.dto.ReturnInfo;
import com.sinosoft.agriclaim.api.individuation.dto.SystemToImageRequsetDto;
import com.sinosoft.agriclaim.core.individuation.service.SystemToImageService;
import com.sinosoft.dms.api.image.PrpDimageCodeApi;
import com.sinosoft.dms.api.image.dto.PrpDimageCodeDto;
import com.sinosoft.framework.core.service.impl.BaseServiceImpl;
import com.sinosoft.framework.core.utils.StringUtils;
import com.sinosoft.framework.exception.DataVerifyException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/***
 * 
 * @description 信雅达图片上传
 * @author 周柯宇
 * @date 2017年12月27日 下午6:46:17
 */
@Service
public class SystemToImageServiceImpl extends BaseServiceImpl implements SystemToImageService {

	@Value("${IMAGE_CRUDT_URL}")
	private String IMAGE_CRUDT_URL;

	@Autowired
	private PrpDimageCodeApi prpDimageCodeApi;

	/**
	 * 缓存机构
	 */
	private final String COM_CODE = "00000000";
	/**
	 * 操作员角色
	 */
	private final String ROLE_CODE = "admin";

	/**
	 * 生成请求报文
	 *
	 * @param systemToImageRequsetDto
	 * @return
	 * @throws Exception
	 */
	@Override
	public String transportXML(SystemToImageRequsetDto systemToImageRequsetDto) throws Exception {
		if (systemToImageRequsetDto == null) {
			throw new DataVerifyException("入参不能为空");
		}
		if (StringUtils.isEmpty(systemToImageRequsetDto.getBusinessNo())) {
			throw new DataVerifyException("业务号不能为空");
		}
		if (StringUtils.isEmpty(systemToImageRequsetDto.getLoginComCode())) {
			throw new DataVerifyException("登录机构代码不能为空");
		}
		if (StringUtils.isEmpty(systemToImageRequsetDto.getLoginComName())) {
			throw new DataVerifyException("登录机构名称不能为空");
		}
		if (StringUtils.isEmpty(systemToImageRequsetDto.getLoginUserCode())) {
			throw new DataVerifyException("登录用户代码不能为空");
		}
		if (StringUtils.isEmpty(systemToImageRequsetDto.getLoginUserName())) {
			throw new DataVerifyException("登录用户姓名不能为空");
		}
		String businessNo = systemToImageRequsetDto.getBusinessNo();
		String riskCode = businessNo.substring(1, 5);
		Map<String, String> param = new HashMap<>(2);
		param.put("riskCode", riskCode);
		param.put("comCode", "0000000000");
		PrpDimageCodeDto prpDimageCodeDto = prpDimageCodeApi.queryByPK(param);
		String appCode = prpDimageCodeDto.getClaimCode();
		String appName = prpDimageCodeDto.getClaimName();
		StringBuilder returnXml = getReturnXml(systemToImageRequsetDto, appCode, appName);
		return returnXml.toString();
	}

	private StringBuilder getReturnXml(SystemToImageRequsetDto systemToImageRequsetDto, String appCode, String appName) {
		return new StringBuilder("<?xml version='1.0' encoding='UTF-8'?><root><BASE_DATA><USER_CODE>")
				.append(systemToImageRequsetDto.getLoginUserCode())
				.append("</USER_CODE><USER_NAME>")
				.append(systemToImageRequsetDto.getLoginUserName())
				.append("</USER_NAME><ORG_CODE>")
				.append(systemToImageRequsetDto.getLoginComCode())
				.append("</ORG_CODE><COM_CODE>")
				.append(COM_CODE)
				.append("</COM_CODE><ORG_NAME>")
				.append(systemToImageRequsetDto.getLoginComName())
				.append("</ORG_NAME><ROLE_CODE>")
				.append(ROLE_CODE)
				.append("</ROLE_CODE></BASE_DATA><META_DATA><BATCH><APP_CODE>")
				.append(appCode)
				.append("</APP_CODE><APP_NAME>")
				.append(appName)
				.append("</APP_NAME><BUSI_NO>")
				.append(systemToImageRequsetDto.getBusinessNo())
				.append("</BUSI_NO></BATCH></META_DATA></root>");
	}
	

	@Override
	public ReturnInfo transport(SystemToImageRequsetDto systemToImageRequsetDto) throws Exception {
		
		ReturnInfo returnInfo = null;
//		ImageDto imageDto=null;
//		if("ImageModify".equals(systemToImageRequsetDto.getType())){
//			imageDto=getImageModifyAndQueryDto(systemToImageRequsetDto);
//		}
//		if("ImageQuery".equals(systemToImageRequsetDto.getType())){
//			imageDto=getImageModifyAndQueryDto(systemToImageRequsetDto);
//		}
//	   if("taxRegistImage".equals(systemToImageRequsetDto.getType())){
//			imageDto=getImageModifyDtoTax(systemToImageRequsetDto);
//		}
//		if("ImageQueryCount".equals(systemToImageRequsetDto.getType())){
//			imageDto=getImageQueryCountDto(systemToImageRequsetDto);
//		}
//		returnInfo = send(systemToImageRequsetDto.getType(),imageDto);
		return returnInfo;
	}
	
	
	/***
	 * 
	 * @description 发送数据到信雅达
	 * @author 周柯宇
	 * @date 2017年12月27日 下午6:47:29
	 * @param SystemToImageRequsetDto对象
	 * @return String
	 * @Throws Exception
	 */
	private ReturnInfo send(String type, ImageDto imageDto) throws Exception {
		try {
			String xmlString="";
			
			if("ImageModify".equals(type)){
				xmlString = getImageModifyXML(imageDto);
			}
			if("ImageQuery".equals(type)){
				xmlString = getImageQueryXML(imageDto);
			}
			if("ImageQueryCount".equals(type)){
				xmlString = getImageQueryCountXML(imageDto); 
			}
			System.out.println("核心发送的影像XML：[字符串长度：" + xmlString.length() + "]："
					+ xmlString);
			String retXmlString = request(xmlString);
			System.out.println("平台返回的XML [字符串长度：" + retXmlString.length()
					+ "]：" + retXmlString);
			
			return getImageQueryCountFromXML(retXmlString);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/***
	 * 
	 * @description 解析影像数量查询返回的报文
	 * @author 周柯宇
	 * @date 2017年12月27日 下午6:47:29
	 * @param SystemToImageRequsetDto对象
	 * @return String
	 * @Throws Exception
	 */
	private ReturnInfo getImageQueryCountFromXML(String reqXmlStr)  throws Exception  {
		ReturnInfo returnInfo=new ReturnInfo();
		if(reqXmlStr!=null && !"".equals(reqXmlStr)){
		
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new ByteArrayInputStream(reqXmlStr.getBytes("UTF-8")));
			Element root = doc.getRootElement();
			Element foo = null;
			returnInfo.setResCode(root.elementText("RESPONSE_CODE"));
			returnInfo.setResMsg(root.elementText("RESPONSE_MSG"));
			for (Iterator i = root.elementIterator("RETURN_DATA"); i.hasNext();) {

				foo = (Element) i.next();
				returnInfo.setSumImage(foo.elementText("SUM_IMGS"));
			}
		}
		return returnInfo;
	}
	
	/***
	 * 
	 * @description 发送数据到信雅达，获取返回报文
	 * @author 周柯宇
	 * @date 2017年12月27日 下午6:47:29
	 * @param SystemToImageRequsetDto对象
	 * @return String
	 * @Throws Exception
	 */
	private String request(String xmlData)  throws Exception {
		//开启连接
		URL uploadServlet = new URL(IMAGE_CRUDT_URL);
		URLConnection servletConnection = uploadServlet.openConnection();
		System.out.println("请求核心URL::::::" + servletConnection.getURL());
		// 设置连接参数
		servletConnection.setUseCaches(false);
		servletConnection.setDoOutput(true);
		servletConnection.setDoInput(true);
		//开启流，写入XML数据
		BufferedOutputStream output = new BufferedOutputStream(servletConnection.getOutputStream());
		output.write(xmlData.getBytes());
		output.close();
		try {
			String result="";
			PostMethod postMethod = null;
			HttpClient httpClient = null;
			try {
				postMethod = new PostMethod(IMAGE_CRUDT_URL);
				// 设置格式
				postMethod.getParams().setContentCharset("UTF-8");
				// 请求参数
				postMethod.setParameter("format", "xml");
				postMethod.setParameter("code", "ECM0006");
				postMethod.setParameter("xml", xmlData.toString());
				httpClient = new HttpClient();
				// 执行postMethod
				int statusCode = httpClient.executeMethod(postMethod);
				if(statusCode==HttpStatus.SC_OK){
				    byte[] bodydata = postMethod.getResponseBody();
				    //取得返回值
				    result = new String(bodydata, "UTF-8");
				}else{
				}
			} catch (HttpException e) {
				//协议发生异常，URL不合法请检查URL！
			}catch (IOException e) {
				//请检查网络是否通畅，检查网线是否插好！
			}
			catch (Exception e) {
				
			}finally {
				if (postMethod != null) {
					try {
						postMethod.releaseConnection();
					} catch (Exception e) {
					}
				}
				if (httpClient != null) {
					httpClient = null;
				}
			}
			return result;
		} catch (Exception e) {
			System.out.println("数据已经发送， 但没有返回结果！");
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * 
	 * @description 根据影像查询数量生成Xml字符串
	 * @author 周柯宇
	 * @date 2017年12月28日 上午11:21:51
	 * @param ImageDto对象
	 * @return String
	 * @Throws Exception
	 */
	private String getImageQueryCountXML(ImageDto imageDto) {
		Document document = getImageQueryCountDocument(imageDto);
		if (document != null) {
			document.setXMLEncoding("UTF-8");
			return document.asXML();
		}
		return null;
	}

	/**
	 * 
	 * @description 根据影像查询数量生成Document对象
	 * @author 周柯宇
	 * @date 2017年12月28日 上午11:24:48
	 * @param ImageDto对象
	 * @return Document
	 * @Throws Exception
	 */
	private Document getImageQueryCountDocument(ImageDto imageDto) {
		
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("root");
		Element base_date = root.addElement("BASE_DATA");
		base_date.addElement("USER_CODE").setText("admin");
		base_date.addElement("USER_NAME").setText("admin");
		base_date.addElement("ORG_CODE").setText("00000000");
		base_date.addElement("ORG_NAME").setText("信达财产保险股份有限公司_"+imageDto.getAppCode());
		base_date.addElement("ROLE_CODE").setText("admin");
		Element meta_data = root.addElement("META_DATA");
		Element batch = meta_data.addElement("BATCH");
		batch.addElement("APP_CODE").setText(imageDto.getAppCode());
		batch.addElement("BUSI_NO").setText(imageDto.getBusinessNo());
		return document;
	}

	/***
	 * 
	 * @description 信雅达 查询数量对象
	 * @author 周柯宇
	 * @date 2017年12月27日 下午7:56:39
	 * @param
	 * @return ImageDto
	 * @throws Exception
	 * @Throws Exception
	 */
	private ImageDto getImageQueryCountDto(SystemToImageRequsetDto systemToImageRequsetDto) throws Exception {
		ImageDto imageDto = new ImageDto();
//		ImageTypeDto imageTypeDto = null;
//		List<ImageTypeDto> imageTypeList = new ArrayList<ImageTypeDto>();
//		PrpLRegistDto prpLRegistDto = prpLRegistApi.queryByPK(systemToImageRequsetDto.getBusinessNo());
//		String comcode = prpLRegistDto.getComCode();
//		PrpDcompanyDto prpDcompanyDto = prpDcompanyApi.queryByPK(comcode);
//		String comcname=prpDcompanyDto.getComCName();
//		String classcode =prpLRegistDto.getClassCode();
//		Date  reportdate= prpLRegistDto.getReportDate();
//		boolean flag=reportdate.before(new DateTime("2011-12-12"));
//		List<PrplCertifyDirect> prplCertifyDirectList = prplCertifyDirectDao.findAll(Specifications.<PrplCertifyDirect>and()
//				.eq(StringUtils.isNotEmpty(systemToImageRequsetDto.getBusinessNo()), "registNo", systemToImageRequsetDto.getBusinessNo())
//				.build());
//		List<PrplCertifyDirectDto> PrplCertifyDirectDtoList = new ArrayList<PrplCertifyDirectDto>();
//		this.convertCollection(prplCertifyDirectList, PrplCertifyDirectDtoList, PrplCertifyDirectDto.class);
//		PrplCertifyDirectDto PrplCertifyDirectDto = null;
//		for(int i = 0; i < PrplCertifyDirectDtoList.size(); i++){
//			PrplCertifyDirectDto = PrplCertifyDirectDtoList.get(i);
//			imageTypeDto = new ImageTypeDto();
//			imageTypeDto.setBakCode("");
//			imageTypeDto.setId(PrplCertifyDirectDto.getTypeCode());
//			imageTypeDto.setName(PrplCertifyDirectDto.getTypeName());
//			imageTypeList.add(imageTypeDto);
//		}
//		imageDto.setImageTypes(imageTypeList);
//		imageDto.setBusinessNo(systemToImageRequsetDto.getBusinessNo());
//		imageDto.setAppCode("CLAIM");
//		imageDto.setClassCode(classcode);
//		imageDto.setUserCode(systemToImageRequsetDto.getUserCode());
//		PrpDuserDto prpDuserDto = prpDuserApi.queryByPK(systemToImageRequsetDto.getUserCode());
//		imageDto.setUserName(prpDuserDto.getUserName());
//		imageDto.setAppName("理赔");
//		Map<String,String> map = new HashMap<String,String>();
//		map.put("comCode", comcode);
//		map.put("comLevel", "2");
//		List<PrpDcompanyDto> prpDcompanyDtoList = prpDcompanyApi.queryLikeComcodeAndComlevel(map);
//		if(prpDcompanyDtoList != null && prpDcompanyDtoList.size() > 0){
//			PrpDcompanyDto prpdcompanyDto= prpDcompanyDtoList.get(0);
//			comcode = prpdcompanyDto.getComCode();
//			comcname =prpdcompanyDto.getComCName();
//		}else{
//			prpDcompanyDtoList = prpDcompanyApi.queryByComCode(comcode);
//			PrpDcompanyDto prpdcompanyDto= (PrpDcompanyDto)prpDcompanyDtoList.get(0);
//			comcode = prpdcompanyDto.getComCode();
//			comcname =prpdcompanyDto.getComCName();
//		}
//		imageDto.setComName(comcname);
//		imageDto.setComCode(comcode);
		return imageDto;
	}

	/**
	 * 
	 * @description 根据影像批改扫描修改成Xml字符串 (上传)
	 * @author 周柯宇
	 * @date 2017年12月28日 上午11:21:51
	 * @param ImageDto对象
	 * @return String
	 * @Throws Exception
	 */
	public static String getImageModifyXML(ImageDto imageDto){
		Document document = getImageModifyDocument(imageDto);
		if (document != null) {
			document.setXMLEncoding("UTF-8");
			return document.asXML();
		}
		return null;
	}
	
	/**
	 * 
	 * @description 根据影像批改扫描修改对象生成Document对象(上传)
	 * @author 周柯宇
	 * @date 2017年12月28日 上午11:24:48
	 * @param ImageDto对象
	 * @return Document
	 * @Throws Exception
	 */
	private static Document getImageModifyDocument(ImageDto imageDto) {
		
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("root");
		Element base_date = root.addElement("BASE_DATA");
		base_date.addElement("USER_CODE").setText(imageDto.getUserCode());
		base_date.addElement("USER_NAME").setText(imageDto.getUserName());
		base_date.addElement("ORG_CODE").setText(imageDto.getComCode());
		base_date.addElement("ORG_NAME").setText(imageDto.getComName());
		base_date.addElement("ROLE_CODE").setText(imageDto.getRoleCode());
		Element biz_info = base_date.addElement("BIZ_INFO");
		Element biz_typ  = biz_info.addElement("BIZ_TYPE");
		biz_typ.addAttribute("APP_CODE", imageDto.getAppCode());
		biz_typ.addAttribute("APP_NAME", imageDto.getAppName());
		Element meta_datas = root.addElement("META_DATA");
		Element batch = meta_datas.addElement("BATCH");
		batch.addAttribute("BATCH_ID", "");
		batch.addElement("APP_CODE").setText(imageDto.getAppCode());
		batch.addElement("APP_NAME").setText(imageDto.getAppName());
		batch.addElement("BUSI_NO").setText(imageDto.getBusinessNo());
		batch.addElement("XL").setText(imageDto.getClassCode());
		batch.addElement("COM_CODE").setText(imageDto.getComCode());
		batch.addElement("ONLY_SELF_ALERT").setText(imageDto.getOnlySelfAlert());
		batch.addElement("CLASSIFY_LIMIT").setText(imageDto.getClassifyLimit());
		Element vtree = batch.addElement("VTREE");
		vtree.addAttribute("APP_CODE", imageDto.getAppCode());
		vtree.addAttribute("APP_NAME", imageDto.getAppName());
		if(imageDto.getImageTypes()!=null){
			Collection collection=imageDto.getImageTypes();
			if(!collection.isEmpty()){
				for(Iterator iter=collection.iterator();iter.hasNext();){
					Element node = vtree.addElement("NODE");
					ImageTypeDto imageTypeDto=(ImageTypeDto)iter.next();
					node.addAttribute("ID",imageTypeDto.getId());
					node.addAttribute("NAME",imageTypeDto.getName());
					node.addAttribute("RIGHT", imageTypeDto.getRight_type());
					node.addAttribute("RESEIZE", imageTypeDto.getReseize());
					node.addAttribute("CHILD_FLAG", imageTypeDto.getChild_flag());
					node.addAttribute("BARCODE", imageTypeDto.getBakCode());
					node.addAttribute("MAXPAGES", imageTypeDto.getMaxPages());
					node.addAttribute("MINPAGES", imageTypeDto.getMinPages());
				}
			}
		}	
		return document;
	}
	
	/**
	 * 
	 * @description 根据影像批改扫描修改成Xml字符串 (查看)
	 * @author 周柯宇
	 * @date 2017年12月28日 上午11:21:51
	 * @param ImageDto对象
	 * @return String
	 * @Throws Exception
	 */
	public static String getImageQueryXML(ImageDto imageDto){
		Document document = getImageQueryDocument(imageDto);
		if (document != null) {
			document.setXMLEncoding("UTF-8");
			return document.asXML();
		}
		return null;
	}

	/**
	 * 
	 * @description 根据影像批改扫描修改对象生成Document对象(查看)
	 * @author 周柯宇
	 * @date 2017年12月28日 上午11:24:48
	 * @param ImageDto对象
	 * @return Document
	 * @Throws Exception
	 */
	private static Document getImageQueryDocument(ImageDto imageDto) {

		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("root");
		Element base_date = root.addElement("BASE_DATA");
		base_date.addElement("USER_CODE").setText(imageDto.getUserCode());
		base_date.addElement("USER_NAME").setText(imageDto.getUserName());
		base_date.addElement("ORG_CODE").setText(imageDto.getComCode());
		base_date.addElement("ORG_NAME").setText(imageDto.getComName());
		base_date.addElement("ROLE_CODE").setText(imageDto.getRoleCode());
		/*Element biz_info = base_date.addElement("BIZ_INFO");
		Element biz_typ  = biz_info.addElement("BIZ_TYPE");
		biz_typ.addAttribute("APP_CODE", imageDto.getAppCode());
		biz_typ.addAttribute("APP_NAME", imageDto.getAppName());*/
		Element meta_datas = root.addElement("META_DATA");
		Element batch = meta_datas.addElement("BATCH");
		//batch.addAttribute("BATCH_ID", "");
		batch.addElement("APP_CODE").setText(imageDto.getAppCode());
		batch.addElement("APP_NAME").setText(imageDto.getAppName());
		batch.addElement("BUSI_NO").setText(imageDto.getBusinessNo());
		batch.addElement("XL").setText(imageDto.getClassCode());
		Element vtree = batch.addElement("VTREE");
		vtree.addAttribute("APP_CODE", imageDto.getAppCode());
		vtree.addAttribute("APP_NAME", imageDto.getAppName());
		if(imageDto.getImageTypes()!=null){
			Collection collection=imageDto.getImageTypes();
			if(!collection.isEmpty()){
				for(Iterator iter=collection.iterator();iter.hasNext();){
					Element node = vtree.addElement("NODE");
					ImageTypeDto imageTypeDto=(ImageTypeDto)iter.next();
					node.addAttribute("ID",imageTypeDto.getId());
					node.addAttribute("NAME",imageTypeDto.getName());
					node.addAttribute("RIGHT", imageTypeDto.getRight_type());
					node.addAttribute("RESEIZE", imageTypeDto.getReseize());
					node.addAttribute("CHILD_FLAG", imageTypeDto.getChild_flag());
					node.addAttribute("BARCODE", imageTypeDto.getBakCode());
					node.addAttribute("MAXPAGES", imageTypeDto.getMaxPages());
					node.addAttribute("MINPAGES", imageTypeDto.getMinPages());
				}
			}
		}
		
		return document;
	}

	/***
	 * 
	 * @description 信雅达 获取上传/查看Dto对象
	 * @author 周柯宇
	 * @date 2017年12月27日 下午7:56:39
	 * @param
	 * @return ImageDto
	 * @throws Exception
	 * @Throws Exception
	 */
	private ImageDto getImageModifyAndQueryDto(SystemToImageRequsetDto systemToImageRequsetDto) throws Exception {
		ImageDto imageDto = new ImageDto();
//		ImageTypeDto imageTypeDto = null;
//		List<ImageTypeDto> imageTypeList = new ArrayList<ImageTypeDto>();
//		PrpLRegistDto prpLRegistDto = prpLRegistApi.queryByPK(systemToImageRequsetDto.getBusinessNo());
//		String comcode = prpLRegistDto.getComCode();
//		PrpDcompanyDto prpDcompanyDto = prpDcompanyApi.queryByPK(comcode);
//		String comcname=prpDcompanyDto.getComCName();
//		String classcode =prpLRegistDto.getClassCode();
//		Date  reportdate= prpLRegistDto.getReportDate();
//		boolean flag=reportdate.before(new DateTime("2011-12-12"));
//		List<PrplCertifyDirect> prplCertifyDirectList = prplCertifyDirectDao.findAll(Specifications.<PrplCertifyDirect>and()
//				.eq(StringUtils.isNotEmpty(systemToImageRequsetDto.getBusinessNo()), "registNo", systemToImageRequsetDto.getBusinessNo())
//				.build());
//		List<PrplCertifyDirectDto> PrplCertifyDirectDtoList = new ArrayList<PrplCertifyDirectDto>();
//		this.convertCollection(prplCertifyDirectList, PrplCertifyDirectDtoList, PrplCertifyDirectDto.class);
//		PrplCertifyDirectDto PrplCertifyDirectDto = null;
//		for(int i = 0; i < PrplCertifyDirectDtoList.size(); i++){
//			PrplCertifyDirectDto = PrplCertifyDirectDtoList.get(i);
//			imageTypeDto = new ImageTypeDto();
//			imageTypeDto.setBakCode("");
//			imageTypeDto.setId(PrplCertifyDirectDto.getTypeCode());
//			imageTypeDto.setName(PrplCertifyDirectDto.getTypeName());
//			imageTypeList.add(imageTypeDto);
//		}
//		imageDto.setImageTypes(imageTypeList);
//		imageDto.setBusinessNo(systemToImageRequsetDto.getBusinessNo());
//		imageDto.setAppCode(systemToImageRequsetDto.getBusinessType());
//		imageDto.setClassCode(classcode);
//		imageDto.setUserCode(systemToImageRequsetDto.getUserCode());
//		PrpDuserDto prpDuserDto = prpDuserApi.queryByPK(systemToImageRequsetDto.getUserCode());
//		imageDto.setUserName(prpDuserDto.getUserName());
//		imageDto.setAppName("理赔");
//		Map<String,String> map = new HashMap<String,String>();
//		map.put("comCode", comcode);
//		map.put("comLevel", "2");
//		List<PrpDcompanyDto> prpDcompanyDtoList = prpDcompanyApi.queryLikeComcodeAndComlevel(map);
//		if(prpDcompanyDtoList != null && prpDcompanyDtoList.size() > 0){
//			PrpDcompanyDto prpdcompanyDto= prpDcompanyDtoList.get(0);
//			comcode = prpdcompanyDto.getComCode();
//			comcname =prpdcompanyDto.getComCName();
//		}else{
//			prpDcompanyDtoList = prpDcompanyApi.queryByComCode(comcode);
//			PrpDcompanyDto prpdcompanyDto= (PrpDcompanyDto)prpDcompanyDtoList.get(0);
//			comcode = prpdcompanyDto.getComCode();
//			comcname =prpdcompanyDto.getComCName();
//		}
//		imageDto.setComName(comcname);
//		imageDto.setComCode(comcode);
		return imageDto;
	}

	/***
	 * 
	 * @description 信雅达 获取纳税人Dto对象
	 * @author 周柯宇
	 * @date 2017年12月27日 下午7:56:39
	 * @param
	 * @return ImageDto
	 * @throws Exception
	 * @Throws Exception
	 */
	private ImageDto getImageModifyDtoTax(SystemToImageRequsetDto systemToImageRequsetDto) throws Exception {

		ImageDto imageDto = new ImageDto();
//		ImageTypeDto imageTypeDto=null;
//		ArrayList imageTypeList= new ArrayList();
//		imageTypeDto = new ImageTypeDto();
//		imageTypeDto.setBakCode("");
//		imageTypeDto.setId(systemToImageRequsetDto.getBusinessType());
//		imageTypeDto.setName("税务登记");
//		imageTypeList.add(imageTypeDto);
//		imageDto.setImageTypes(imageTypeList);
//		imageDto.setBusinessNo(systemToImageRequsetDto.getBusinessNo());
//		imageDto.setAppCode(systemToImageRequsetDto.getBusinessType());
//		imageDto.setClassCode("");
//		imageDto.setUserCode(systemToImageRequsetDto.getUserCode());
//		PrpDuserDto prpDuserDto = prpDuserApi.queryByPK(systemToImageRequsetDto.getUserCode());
//		imageDto.setUserName(prpDuserDto.getUserName());
//		imageDto.setComCode("00000000");
//		imageDto.setComName("信达财产保险股份有限公司");
//		imageDto.setAppName("税务登记");
		return imageDto;
	}
}
