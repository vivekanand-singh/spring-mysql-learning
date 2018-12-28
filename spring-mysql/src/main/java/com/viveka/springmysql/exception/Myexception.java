package com.viveka.springmysql.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.viveka.springmysql.model.ResponseDTO;

@RestControllerAdvice
public class Myexception extends ResponseEntityExceptionHandler {
  @ExceptionHandler(Exception.class)
  public final ResponseEntity<ResponseDTO> mymessage(Exception ex, WebRequest request) {
    ResponseDTO exception = new ResponseDTO();
    exception.setMessage(ex.getMessage());
    exception.setStatus("some logic error");
    return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
  }
}
