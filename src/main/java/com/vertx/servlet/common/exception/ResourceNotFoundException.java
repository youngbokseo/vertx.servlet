package com.ntels.cep.common.exception;

public class ResourceNotFoundException extends HttpException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
		super(404, message);
	}
	
	public ResourceNotFoundException(int errorCode, String message) {
		super(errorCode, message);
	}
	
	public String getMsgKey(){
		return "msg.not.found";
	}
}
