package com.boardbasic.common.response.util;

import com.boardbasic.common.response.dto.MessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponse {

    public static MessageDTO message(String msg){
        return MessageDTO.builder()
                         .message(msg)
                         .build();
    }

    public static ResponseEntity<MessageDTO> set(HttpStatus status, String responseUrl, String responseMessage){
        return ResponseEntity.status(status).header("Location", responseUrl).body(message(responseMessage));
    }
}
