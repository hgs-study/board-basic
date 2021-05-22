package com.boardbasic.common.response.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MessageDTO {
    private String message;

    @Builder
    private MessageDTO(String message){
        this.message = message;
    }
}
