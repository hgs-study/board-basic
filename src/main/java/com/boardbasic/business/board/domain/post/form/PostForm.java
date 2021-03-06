package com.boardbasic.business.board.domain.post.form;

import com.boardbasic.business.board.domain.post.entity.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class PostForm {
    public static class Request{
        @Getter
        @NoArgsConstructor
        public static class Add{
            private String title;
            private String content;

            public Post toEntity(){
                return new Post(title, content);
            }
        }

        @Getter
        @NoArgsConstructor
        public static class Modify{
            private Long id;
            private String title;
            private String content;

        }
    }

    public static class Response{

        @Getter
        public static class Find{
            private Long id;
            private String title;
            private String content;

            private Find(Long id, String title, String content){
                this.id = id;
                this.title = title;
                this.content = content;
            }

            public static Find of(Post post){
                return new Find(
                            post.getId(),
                            post.getTitle(),
                            post.getContent()
                        );
            }
        }
    }
}
