package com.sinosoft.fileserver.controller.config;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @description uploadFile文件传参配置
 * @author 周建龙
 * @date 2016年10月5日上午10:25:44
 */
public class UploadConfig {
	/**
	 * 用户编码
	 */
	private String userCode;

	/**
	 * 有效时间，默认100年
	 */
	private long validTime = 3153600000l;
	/**
	 * 文件路径
	 */
	private String filePath;
	/**
	 * 入參解析狀態 1成功 2 失敗
	 */
	private long parseStatus;
	/**
	 * 解析信息描述
	 */
	private String parseMsg;
	/**
	 * 解析信息描述
	 */
	private MultipartFile file;
	/**
	 * 系统id
	 */
	private String systemId;
	/**
	 * 业务类型
	 */
	private String bussType;

	/**
	 * 
	 * @description 解析request中对象
	 * @param request
	 * @author 周建龙
	 * @date 2016年10月5日下午2:02:48
	 */
	public void parseUploadConfig(HttpServletRequest request) {
		parseStatus = 1;
		// 将当前上下文初始化给 CommonsMutipartResolver （多部分解析器）
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		MultipartHttpServletRequest multiRequest = null;
		// 检查form中是否有enctype="multipart/form-data"
		if (multipartResolver.isMultipart(request)) {
			// 将request变成多部分request
			// multiRequest =multipartResolver.resolveMultipart(request);
			multiRequest = (MultipartHttpServletRequest) request;
			Iterator iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				multiRequest.getFileNames();
				if (file != null) {
					this.file = file;
					break;
				}
			}

		};
		if (this.file == null) {
			parseStatus = 2;
			parseMsg = "没有在该请求中找到上传的文件！";
			return;
		}

		if (!StringUtils.isBlank(multiRequest.getParameter("userCode")) && parseStatus == 1) {
			userCode = multiRequest.getParameter("userCode");
		} else {
			parseStatus = 2;
			parseMsg = "userCode不能为空！";
			return;
		}
		if (!StringUtils.isBlank(multiRequest.getParameter("systemId")) && parseStatus == 1) {
			systemId = multiRequest.getParameter("systemId");
		} else {
			parseStatus = 2;
			parseMsg = "systemId不能为空！";
			return;
		}
		if (!StringUtils.isBlank(multiRequest.getParameter("bussType")) && parseStatus == 1) {
			bussType = multiRequest.getParameter("bussType");
		} else {
			parseStatus = 2;
			parseMsg = "bussType不能为空！";
			return;
		}		
		
		
		if (!StringUtils.isBlank(multiRequest.getParameter("validTime")) && parseStatus == 1) {
			String validTimeStr = multiRequest.getParameter("validTime");
			if (StringUtils.isNumeric(validTimeStr)) {
				validTime = Long.parseLong(validTimeStr);
			} else {
				parseStatus = 2;
				parseMsg = "validTime\"" + validTimeStr + "\"" + "不是一个有效的数值！";
			}
		}
		if (!StringUtils.isBlank(multiRequest.getParameter("filePath")) && parseStatus == 1) {
			filePath = multiRequest.getParameter("filePath");
		}
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public long getParseStatus() {
		return parseStatus;
	}

	public void setParseStatus(long parseStatus) {
		this.parseStatus = parseStatus;
	}

	public String getParseMsg() {
		return parseMsg;
	}

	public void setParseMsg(String parseMsg) {
		this.parseMsg = parseMsg;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public long getValidTime() {
		return validTime;
	}

	public void setValidTime(long validTime) {
		this.validTime = validTime;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getBussType() {
		return bussType;
	}

	public void setBussType(String bussType) {
		this.bussType = bussType;
	}

	
	public String toString() {
		return JSON.toJSONString(this);
	}

	

}
