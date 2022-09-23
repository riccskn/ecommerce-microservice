package com.riccskn.service.impl;

import com.riccskn.dto.AccountDTO;
import com.riccskn.exception.ResourceNotFoundException;
import com.riccskn.model.AccountModel;
import com.riccskn.repository.AccountRepository;
import com.riccskn.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountModel addAccount(AccountDTO accountDTO) {

        if (accountRepository.existsByUsername(accountDTO.getUsername())) {

         throw new ResourceNotFoundException("Account with username: "+accountDTO.getUsername()+" not found");

        }

            AccountModel account = new AccountModel(  accountDTO.getUsername(),
                    accountDTO.getName(),
                    accountDTO.getPassword(),
                    accountDTO.getEmail());

            accountRepository.save(account);
            return account;
        }

    @Override
    public AccountModel getAccountByUsername(String username) {

           return accountRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("Account with username: "+username+" not found"));
    }

    @Override
    public List<AccountModel> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public void deleteAccountByUsername(String username) {

        AccountModel account = accountRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("Account with username: "+username+" not found"));

        accountRepository.delete(account);
    }
}
