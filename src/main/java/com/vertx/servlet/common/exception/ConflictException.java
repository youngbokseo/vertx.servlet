package com.ntels.cep.common.exception;

public class ConflictException extends HttpException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ConflictException(String message) {
		super(409, message);
	}
	
	public ConflictException(int errorCode, String message) {
		super(errorCode, message);
	}
	
	public String getMsgKey(){
		return "msg.conflict";
	}
}
