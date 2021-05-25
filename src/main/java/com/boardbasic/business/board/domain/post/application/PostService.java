package com.boardbasic.business.board.domain.post.application;

import com.boardbasic.business.board.domain.post.entity.Post;
import com.boardbasic.business.board.domain.post.form.PostForm.*;
import com.boardbasic.common.error.code.ErrorCode;
import com.boardbasic.common.error.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public void save(Post post){
        postRepository.save(post);
    }

    public List<Post> findPosts(){
        return postRepository.findAll();
    }

    public Post findPost(Long id){
        return postRepository.findById(id)
                                .orElseThrow(()-> new BusinessException(ErrorCode.NOT_FOUND_POST));
    }

    @Transactional
    public void modifyPost(Post post){
        postRepository.save(post);
    }

    @Transactional
    public void deletePost(Post post){
        postRepository.delete(post);
    }
}
