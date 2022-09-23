package com.riccskn.controller;

import com.riccskn.dto.AccountDTO;
import com.riccskn.model.AccountModel;
import com.riccskn.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/accounts")
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;

    @GetMapping("/{username}")
    public ResponseEntity<AccountModel> getAccountByUsername(@PathVariable String username) {
        return ResponseEntity.ok(accountService.getAccountByUsername(username));
    }

    @GetMapping
    public ResponseEntity<List<AccountModel>> getAllAccounts() {
         return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @PostMapping
    public ResponseEntity<AccountModel> saveAccount(@RequestBody @Valid AccountDTO accountDTO) {
        return new ResponseEntity<>(accountService.addAccount(accountDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteAccountByUsername(@PathVariable String username) {
        accountService.deleteAccountByUsername(username);

     return new ResponseEntity<Void>(HttpStatus.OK);
    }


}
