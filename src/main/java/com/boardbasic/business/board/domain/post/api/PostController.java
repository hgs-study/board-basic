package com.boardbasic.business.board.domain.post.api;

import com.boardbasic.business.board.domain.post.application.PostService;
import com.boardbasic.business.board.domain.post.form.PostForm.*;
import com.boardbasic.common.response.dto.MessageDTO;
import com.boardbasic.common.response.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<MessageDTO> add(@Valid @RequestBody Request.Add add){
        postService.save(add);
        return ApiResponse.set(HttpStatus.CREATED,"/","정상적으로 등록되었습니다.");
    }
}
