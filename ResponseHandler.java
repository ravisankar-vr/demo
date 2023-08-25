package com.sample.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ResponseHandler {

    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj){
        Map<String, Object> result=new HashMap<String, Object>();
        result.put("message",message);
        result.put("status", status);
        result.put("data", responseObj);

        return new ResponseEntity<Object>(result, status);
    }
}
