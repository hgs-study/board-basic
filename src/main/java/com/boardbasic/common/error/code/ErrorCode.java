package com.boardbasic.common.error.code;

import lombok.Getter;

@Getter
public enum ErrorCode {

    //Common
    NOT_FOUND_RESOURCE(400,"C004001","해당 리소스를 찾을 수 없습니다."),
    INVALILD_REQUEST(400,"C004002","잘못된 요청입니다."),
    FORBIDDEN(403,"C004003","해당 권한이 없습니다."),
    SERVER_ERROR(500,"C005001","서버 오류입니다."),

    //POST
    NOT_FOUND_POST(400,"P004001","해당 글을 찾을 수 없습니다."),

    //ACCOUNT
    NOT_FOUND_ACCOUNT(400,"A004001","해당 계정을 찾을 수 없습니다.");

    private int status;
    private String code;
    private String message;

    ErrorCode(int status, String code, String message){
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
