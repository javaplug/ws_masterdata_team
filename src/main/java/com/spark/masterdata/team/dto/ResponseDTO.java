package com.spark.masterdata.team.dto;

import java.util.HashMap;
import java.util.Map;

public class ResponseDTO {

    private String message;
    
    private Map<String, String> errors = new HashMap<String, String>();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
    
    
}
