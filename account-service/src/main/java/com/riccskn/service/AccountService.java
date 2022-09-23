package com.riccskn.service;

import com.riccskn.dto.AccountDTO;
import com.riccskn.model.AccountModel;

import java.util.List;

public interface AccountService {

    AccountModel addAccount(AccountDTO accountDTO);

    AccountModel getAccountByUsername(String username);

    List<AccountModel> getAllAccounts();

    void deleteAccountByUsername(String username);


}
