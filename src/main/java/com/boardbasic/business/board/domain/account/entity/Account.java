package com.boardbasic.business.board.domain.account.entity;

import com.boardbasic.business.board.domain.account.form.AccountForm.*;
import com.boardbasic.common.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    private String email;

    private String password;

    public Account(String email,String password){
        this.email = email;
        this.password = password;
    }

    public Account setUpdate(Request.Modify modify){
        this.email = modify.getEmail();
        this.password = modify.getPassword();
        return this;
    }

}
