package com.ntels.cep.common.exception;

public class BadRequestException extends HttpException{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String invalidParam;
	
	public BadRequestException(String invalidParam) {
		super(400, null);
		this.invalidParam = invalidParam;
	}
	
	public String[] getMsgArgs(){
		return new String[]{invalidParam};
	}
	
	public String getMsgKey(){
		return "msg.bad.request";
	}
}
