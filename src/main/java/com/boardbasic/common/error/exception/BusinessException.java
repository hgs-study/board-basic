package com.boardbasic.common.error.exception;


import com.boardbasic.common.error.code.ErrorCode;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{

    private ErrorCode code;

    public BusinessException(ErrorCode code){
        this.code = code;
    }
}
