package com.ntels.cep.common.exception;

public class NCEPException extends RuntimeException {

    private final int errorCode;

    public NCEPException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        String message = this.getMessage();
        return "(" + this.errorCode + ") " + (message != null ? message : "");
    }

}
