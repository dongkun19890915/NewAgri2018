package com.sinosoft.ims.core.common.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 
* @description 返回结果信息对象
* @author yumeng
* @date 2016年9月12日下午4:11:44
 */
public class ResultInfo<T> implements java.io.Serializable{
	
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;

	private int resultCode;
	
	private String resultMsg;
	
	private T object;
	
	private String error;
	
	private Exception exception;
	
	public ResultInfo(){
		this.resultCode = 0;
		this.resultMsg = "成功";
	}
	
	/**
	 * 接口调用成功，不需要返回对象
	 */
	public static <T> ResultInfo<T> newSuccess(){
		ResultInfo<T> resultInfo = new ResultInfo<T>();
		return resultInfo;
	}
	
	/**
	 * 接口调用成功，有返回对象
	 */
	public static <T> ResultInfo<T> newSuccess(T object) {
		ResultInfo<T> resultInfo = new ResultInfo<T>();
		resultInfo.setObject(object);
		return resultInfo;
	}
	
	/**
	 * 接口调用失败，有错误码和描述，没有返回对象
	 */
	public static <T> ResultInfo<T> newFailure(int code, String resultMsg){
		ResultInfo<T> resultInfo = new ResultInfo<T>();
		resultInfo.setResultCode(code!=0 ? code : -1);
		resultInfo.setResultMsg(resultMsg);
		return resultInfo;
	}
	
	/**
	 * 接口调用失败，有错误字符串码和描述，没有返回对象
	 */
	public static <T> ResultInfo<T> newFailure(String error, String resultMsg){
		ResultInfo<T> resultInfo = new ResultInfo<T>();
		resultInfo.setResultCode(-1);
		resultInfo.setError(error);
		resultInfo.setResultMsg(resultMsg);
		return resultInfo;
	}
	
	/**
	 * 转换或复制错误结果
	 */
	public static <T> ResultInfo<T> newFailure(ResultInfo<?> failure){
		ResultInfo<T> resultInfo = new ResultInfo<T>();
		resultInfo.setResultCode(failure.getResultCode()!=0 ? failure.getResultCode() : -1);
		resultInfo.setError(failure.getError());
		resultInfo.setResultMsg(failure.getResultMsg());
		resultInfo.setException(failure.getException());
		return resultInfo;
	}
	
	/**
	 * 接口调用失败，返回异常信息
	 */
	public static <T> ResultInfo<T> newException(Exception e){
		ResultInfo<T> resultInfo = new ResultInfo<T>();
		resultInfo.setResultCode(-1);
		resultInfo.setException(e);
		resultInfo.setResultMsg(e.getMessage());
		return resultInfo;
	}
	
	/** 判断返回结果是否成功 */
	public boolean success() {
		return resultCode == 0;
	}
	/** 判断返回结果是否有结果对象 */
	public boolean hasObject() {
		return resultCode ==0 && object !=null;
	}
	/** 判断返回结果是否有异常 */
	public boolean hasException() {
		return exception != null;
	}
	
	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}
	
	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public T getObject() {
		return object;
	}
	
	public void setObject(T object) {
		this.object = object;
	}
	
	public String getError() {
		return error;
	}
	
	public void setError(String error) {
		this.error = error;
	}
	
	public Exception getException() {
		return exception;
	}
	
	public void setException(Exception exception) {
		this.exception = exception;
	}

	public String toString() {
		StringBuilder resultInfo = new StringBuilder("ResultInfo");
		if(object!=null) resultInfo.append("<"+object.getClass().getSimpleName()+">");
		resultInfo.append(": {code="+resultCode);
		if(object!=null) resultInfo.append(", object="+object);
		if(error!=null) resultInfo.append(", error="+error);
		if(resultMsg!=null) resultInfo.append(", resultMsg="+resultMsg);
		if(exception!=null) {
			StringWriter stringWriter = new StringWriter();
			exception.printStackTrace(new PrintWriter(stringWriter));
			resultInfo.append(", exception="+stringWriter.toString());
		}
		resultInfo.append(" }");
		return resultInfo.toString();
	}
	
}
