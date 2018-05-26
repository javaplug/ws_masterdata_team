package com.spark.masterdata.team.dto;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class ResponseDTO {

    private String message;
    
    private Map<String, String> errors = new HashMap<String, String>();
}
