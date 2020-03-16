package com.ntels.cep.common.exception;

public class UnauthorizedException extends HttpException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UnauthorizedException(String message) {
		super(401, message);
	}
	
	public UnauthorizedException(int errorCode, String message) {
		super(errorCode, message);
	}
	
	public String getMsgKey(){
		return "msg.unauthorized";
	}
}
