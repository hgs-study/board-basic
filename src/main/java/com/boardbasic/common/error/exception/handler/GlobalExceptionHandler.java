package com.boardbasic.common.error.exception.handler;

import com.boardbasic.common.error.code.ErrorCode;
import com.boardbasic.common.error.exception.BusinessException;
import com.boardbasic.common.error.response.ErrorResponse;
import com.boardbasic.common.response.dto.MessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> BusinessException(BusinessException e){
        ErrorResponse errorResponse = ErrorResponse.of(e.getCode());
        ErrorCode code = e.getCode();
        errorResponse.setMessage(code.getMessage());

        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.valueOf(code.getStatus()));
    }
}
