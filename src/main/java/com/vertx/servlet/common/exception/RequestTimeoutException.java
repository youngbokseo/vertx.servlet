package com.ntels.cep.common.exception;

public class RequestTimeoutException extends HttpException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RequestTimeoutException() {
		super(408, "");		
	}
	public RequestTimeoutException(String message) {
		super(408, message);
	}
	
	public RequestTimeoutException(int errorCode, String message) {
		super(errorCode, message);
	}
	
	public String getMsgKey(){
		return "msg.timeover";
	}
}
