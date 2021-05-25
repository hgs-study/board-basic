package com.boardbasic.business.board.domain.post.entity;

import com.boardbasic.business.board.domain.post.form.PostForm.*;
import com.boardbasic.common.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Post extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @NotBlank(message = "제목을 입력해주세요.")
    private String title;

    @NotBlank(message = "내용을 입력해주세요.")
    private String content;

    public Post(String title, String content){
        this.title = title;
        this.content = content;
    }

    public Post setUpdate(Request.Modify modify){
        this.title = modify.getTitle();
        this.content = modify.getContent();
        return this;
    }
}
