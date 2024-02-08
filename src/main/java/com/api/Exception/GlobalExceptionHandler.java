package com.api.Exception;

import com.api.dto.ErrerDetails;
import com.api.dto.PostDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrerDetails>handlResourceNotFoundException(
            ResourceNotFoundException e,
            WebRequest webRequest

    ){
        ErrerDetails errerDetails = new ErrerDetails(e.getMessage() ,new Date() , webRequest.getDescription((true)));
        return  new ResponseEntity<>(errerDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
