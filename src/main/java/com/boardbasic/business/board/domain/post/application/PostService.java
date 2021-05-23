package com.boardbasic.business.board.domain.post.application;

import com.boardbasic.business.board.domain.post.form.PostForm.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void save(Request.Add add){
        postRepository.save(Request.Add.toEntity(add));
    }
}
