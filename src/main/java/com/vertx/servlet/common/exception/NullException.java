package com.ntels.cep.common.exception;

public class NullException extends HttpException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NullException(String message) {
		super(404 , message);
	}
	
	public NullException(int errorCode, String message) {
		super(errorCode, message);
	}
	
	public String getMsgKey(){
		return "msg.null";
	}
}
