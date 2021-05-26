package com.boardbasic.business.board.domain.account.api;

import com.boardbasic.business.board.domain.account.application.AccountService;
import com.boardbasic.business.board.domain.account.entity.Account;
import com.boardbasic.business.board.domain.account.form.AccountForm.*;
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
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/accounts")
    public ResponseEntity<MessageDTO> add(@Valid @RequestBody Request.Add add){
        accountService.save(add.toEntity());
        return ApiResponse.set(HttpStatus.CREATED,"/","정상적으로 등록되었습니다.");
    }

    @GetMapping("/accounts")
    public List<Response.Find> findAccounts(){
        return accountService.findAccounts().stream()
                                            .map(Response.Find::of)
                                            .collect(Collectors.toList());
    }

    @GetMapping("/accounts/{id}")
    public Response.Find findAccount(@PathVariable Long id){
        return Response.Find.of(accountService.findAccount(id));
    }

    @PutMapping("/accounts/{id}")
    public ResponseEntity<MessageDTO> modifyAccount(@PathVariable Long id,
                                                    @Valid @RequestBody Request.Modify modify){
        final Account account = accountService.findAccount(id);
        accountService.modifyAccount(account.setUpdate(modify));

        return ApiResponse.set(HttpStatus.OK,"/",id+"번 계정이 정상적으로 수정되었습니다.");
    }

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<MessageDTO> deleteAccount(@PathVariable Long id){
        final Account account = accountService.findAccount(id);
        accountService.deleteAccount(account);

        return ApiResponse.set(HttpStatus.OK,"/",id+"번 계정이 정상적으로 삭제되었습니다.");
    }
}
