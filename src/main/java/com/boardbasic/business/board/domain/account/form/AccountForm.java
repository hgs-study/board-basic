package com.boardbasic.business.board.domain.account.form;

import com.boardbasic.business.board.domain.account.entity.Account;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class AccountForm {
    public static class Request{
        @Getter
        public static class Add{
            @Email(message = "이메일 형식으로 입력해주세요.")
            private String email;

            @Pattern(regexp="[a-zA-Z1-9]{8,12}", message = "비밀번호는 영어와 숫자로 포함해서 8~12자리 이내로 입력해주세요.")
            private String password;

            public Account toEntity(){
                return new Account(email,password);
            }
        }

        @Getter
        public static class Modify{
            @Email(message = "이메일 형식으로 입력해주세요.")
            private String email;

            @Pattern(regexp="[a-zA-Z1-9]{8,12}", message = "비밀번호는 영어와 숫자로 포함해서 8~12자리 이내로 입력해주세요.")
            private String password;
        }


    }

    public static class Response{

        @Getter
        public static class Find{
            private Long id;
            private String email;
            private String password;

            private Find(Long id, String email, String password){
                this.id = id;
                this.email = email;
                this.password = password;
            }

            public static Find of(Account account){
                return new Find(
                        account.getId(),
                        account.getEmail(),
                        account.getPassword()
                );
            }
        }
    }
}
