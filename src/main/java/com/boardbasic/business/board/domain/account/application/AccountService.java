package com.boardbasic.business.board.domain.account.application;

import com.boardbasic.business.board.domain.account.entity.Account;
import com.boardbasic.business.board.domain.account.form.AccountForm.*;
import com.boardbasic.common.error.code.ErrorCode;
import com.boardbasic.common.error.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountService {

    private final AccountRepository accountRepository;

    @Transactional
    public void save(Account account){
        accountRepository.save(account);
    }

    public List<Account> findAccounts(){
        return accountRepository.findAll();
    }

    public Account findAccount(Long id){
        return accountRepository.findById(id)
                                    .orElseThrow(()-> new BusinessException(ErrorCode.NOT_FOUND_ACCOUNT));
    }

    @Transactional
    public void modifyAccount(Account account){
        accountRepository.save(account);
    }

    @Transactional
    public void deleteAccount(Account account){
        accountRepository.delete(account);
    }
}
