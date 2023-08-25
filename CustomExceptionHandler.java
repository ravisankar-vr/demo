package com.sample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private String INCORRECT_REQUEST="INCORRECT_REQUEST";
    private String BAD_REQUEST="BAD_REQUEST";

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(RecordNotFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
        //List<String> details=new ArrayList<>();

        // MethodArgumentNotValidException ex,
        //                                 HttpHeaders headers,
        //                                 HttpStatus status, WebRequest request

        //Get all fields errors
        /*List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());*/

        Map<String, Object> body=new HashMap<String, Object>();
        body.put("timestamp", new Date());
        body.put("status", status.value());

        //Get all fields errors
        String errors = ex.getStackTrace().toString();

        body.put("errors", errors);

        /*details.add(ex.getLocalizedMessage());
        ErrorResponse error =new ErrorResponse(INCORRECT_REQUEST, details);*/

        return new ResponseEntity<>(body, headers, status);
    }


}
