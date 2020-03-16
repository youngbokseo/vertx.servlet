package com.ntels.cep.common.exception;

public class ParentNotFoundException extends HttpException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParentNotFoundException(String message) {
		super(404, message);
	}
	
	public ParentNotFoundException(int errorCode, String message) {
		super(errorCode, message);
	}
	
	public String getMsgKey(){
		return "msg.parent.not.found";
	}
}
