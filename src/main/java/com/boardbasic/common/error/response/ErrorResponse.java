package com.boardbasic.common.error.response;

import com.boardbasic.common.error.code.ErrorCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ErrorResponse {

    private int status;
    private String code;
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorResponse(ErrorCode code){
        this.status = code.getStatus();
        this.code = code.getCode();
        this.message = code.getMessage();
    }

    public static ErrorResponse of(ErrorCode code){
        return new ErrorResponse(code);
    }
}
