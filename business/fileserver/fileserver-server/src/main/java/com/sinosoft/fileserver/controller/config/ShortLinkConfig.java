
package com.sinosoft.fileserver.controller.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;

/**
* @description 短链接配置
* @author 周建龙
* @date 2016年10月20日上午9:53:22
*/

public class ShortLinkConfig {
	/**
	 * 用户编码
	 */
	private String userCode;

	/**
	 * 有效时间，默认10分钟
	 */
	private long validWhenLong = 10*60*1000l;
	/**
	 * 文件id
	 */
	private String fileId;
	/**
	 * 入參解析狀態 1成功 2 失敗
	 */
	private long parseStatus;
	/**
	 * 解析信息描述
	 */
	private String parseMsg;
	/**
	 * 失效时间
	 */
	private Date invalidTime;

	/**
	 * 
	 * @description 解析request中对象
	 * @param request
	 * @author 周建龙
	 * @throws ParseException 
	 * @date 2016年10月5日下午2:02:48
	 */
	public void parseShortLinkConfig(HttpServletRequest request) throws ParseException {
		parseStatus = 1;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		if (!StringUtils.isBlank(request.getParameter("userCode")) && parseStatus == 1) {
			userCode = request.getParameter("userCode");
		} else {
			parseStatus = 2;
			parseMsg = "userCode不能为空！";
			return;
		}
		if (!StringUtils.isBlank(request.getParameter("fileId")) && parseStatus == 1) {
			fileId = request.getParameter("fileId");
		} else {
			parseStatus = 2;
			parseMsg = "fileId不能为空！";
			return;
		}

		boolean isValidWhenLong=false;


		if (!StringUtils.isBlank(request.getParameter("validWhenLong")) && parseStatus == 1) {
			String validWhenLongStr = request.getParameter("validWhenLong");
			if (StringUtils.isNumeric(validWhenLongStr)) {
				validWhenLong = Long.parseLong(validWhenLongStr);
			} else {
				parseStatus = 2;
				parseMsg = "validWhenLong\"" + validWhenLongStr + "\"" + "不是一个有效的数值！";
				return;
			}
			invalidTime=new Date();
			isValidWhenLong=true;
		}else{
			if (!StringUtils.isBlank(request.getParameter("invalidTime")) && parseStatus == 1) {
				String invalidTimeStr=request.getParameter("invalidTime");
				if (!invalidTimeStr.matches("^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-"
						+ "(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-"
						+ "(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]"
						+ "|[2468][048]|[3579][26])00))-02-29))\\s+([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$")) {
					parseStatus = 2;
					parseMsg = "invalidTime\"" + invalidTimeStr + "\"" + "不满足日期规则！";
					return;				
				}
				invalidTime=sdf.parse(invalidTimeStr);
				
				//filePath = request.getParameter("filePath");
			}else{
				isValidWhenLong=true;
			}
			
		}
		if (isValidWhenLong) {
			DateTime dt=new DateTime(invalidTime);
			dt=dt.plus(validWhenLong);
			invalidTime=dt.toDate();
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

	public long getValidWhenLong() {
		return validWhenLong;
	}

	public void setValidWhenLong(long validWhenLong) {
		this.validWhenLong = validWhenLong;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public Date getInvalidTime() {
		return invalidTime;
	}

	public void setInvalidTime(Date invalidTime) {
		this.invalidTime = invalidTime;
	}
	@Override
	public String toString() {
		return "ShortLinkConfig [userCode=" + userCode + ", validWhenLong=" + validWhenLong + ", fileId=" + fileId
				+ ", parseStatus=" + parseStatus + ", parseMsg=" + parseMsg + ", invalidTime=" + invalidTime + "]";
	}


}
