package com.ntels.cep.common.exception;

public class ErrorCode {

    public static final int SERVER_ERROR = 10;
    public static final int MANDATORY_PARAMETER_ERROR = 20;
    public static final int RULE_SYNTAX_ERROR = 30;
    public static final int RULE_VALIDATE_ERROR = 31;
    public static final int RULE_DATA_INSERT_ERROR = 32;
    public static final int EVENT_NOT_EXIST_ERROR = 40;
    public static final int EVENT_OVERLAP_ERROR = 41;
    public static final int EVENT_TYPE_ERROR = 42;
    public static final int RULE_NOT_EXIST_ERROR = 50;
    public static final int RULE_EXECUTE_ERROR = 52;
    public static final int DATA_NOT_EXIST_ERROR = 60;
    public static final int DATA_DUPLICATE_ERROR = 70;
    public static final int DATA_PROCESSING_ERROR = 80;
    public static final int RULE_DATA_EXIST_ERROR = 90;


    public static final String SERVER_ERROR_MSG = "A server error has occurred.";
    public static final String MANDATORY_PARAMETER_ERROR_MSG = "";
    public static final String RULE_SYNTAX_ERROR_MSG = "";
    public static final String RULE_VALIDATE_ERROR_MSG = "Rule Validate Error";
    public static final String RULE_DATA_INSERT_ERROR_MSG = "Rule Data Insert Error";
    public static final String EVENT_NOT_EXIST_ERROR_MSG = "Event Not Exist Error";
    public static final String EVENT_OVERLAP_ERROR_MSG = "Event Name Overlap";
    public static final String EVENT_TYPE_ERROR_MSG = "Event_id Type Error";
    public static final String RULE_EXECUTE_ERROR_MSG = "Rule Execute Error";
    public static final String RULE_NOT_EXIST_ERROR_MSG = "Rule Not Exist Error";
    public static final String DATA_NOT_EXIST_ERROR_MSG = "Data does not exist.";
    public static final String DATA_DUPLICATE_ERROR_MSG = "";
    public static final String DATA_PROCESSING_ERROR_MSG = "An error occurred while processing the data.";
    public static final String RULE_DATA_EXIST_ERROR_MSG = "Rule uses event to delete";

}
