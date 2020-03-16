package com.ntels.cep.common.exception;

import java.util.List;

public class HttpException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer errorCode;
	private String msgKey;

	public HttpException(String message){
		this(500, message);
	}
	public HttpException(int errorCode, String message){
		super(message);
		this.errorCode = errorCode;	
		this.msgKey = "msg.error";
	}
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getMsgKey() {
		return msgKey;
	}
	public void setMsgKey(String msgKey) {
		this.msgKey = msgKey;
	}
	public String[] getMsgArgs(){
		return null;
	}
}
