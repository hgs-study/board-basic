package com.boardbasic.business.board.domain.post.form;

import com.boardbasic.business.board.domain.post.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class PostForm {
    public static class Request{
        @Getter
        @NoArgsConstructor
        public static class Add{
            private String title;
            private String content;

            public static Post toEntity(Add add){
                return new Post(add.title, add.content);
            }
        }
    }
}
