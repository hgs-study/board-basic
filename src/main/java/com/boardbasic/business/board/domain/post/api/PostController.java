package com.boardbasic.business.board.domain.post.api;

import com.boardbasic.business.board.domain.post.application.PostService;
import com.boardbasic.business.board.domain.post.entity.Post;
import com.boardbasic.business.board.domain.post.form.PostForm.*;
import com.boardbasic.common.response.dto.MessageDTO;
import com.boardbasic.common.response.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<MessageDTO> add(@Valid @RequestBody Request.Add add){
        postService.save(add.toEntity());
        return ApiResponse.set(HttpStatus.CREATED,"/","정상적으로 등록되었습니다.");
    }

    @GetMapping("/posts")
    public List<Response.Find> findPosts(){
        return postService.findPosts().stream()
                                      .map(Response.Find::of)
                                      .collect(Collectors.toList());
    }

    @GetMapping("/posts/{id}")
    public Response.Find findPost(@PathVariable Long id){
        return Response.Find.of(postService.findPost(id));
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<MessageDTO> modifyPost(@PathVariable Long id,
                                    @Valid @RequestBody Request.Modify modify){
        final Post post = postService.findPost(id);
        postService.modifyPost(post.setUpdate(modify));

        return ApiResponse.set(HttpStatus.OK,"/",id+"번 게시글이 정상적으로 수정되었습니다.");
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<MessageDTO> deletePost(@PathVariable Long id){
        final Post post = postService.findPost(id);
        postService.deletePost(post);

        return ApiResponse.set(HttpStatus.OK,"/",id+"번 게시글이 정상적으로 삭제되었습니다.");
    }
}
