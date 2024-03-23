package com.serdar.accounts.mapper;

import com.serdar.accounts.dto.AccountDto;
import com.serdar.accounts.entity.Account;

public class AccountMapper {

    public static AccountDto maptToAccountDto(Account account, AccountDto accountDto) {
        accountDto.setAccountNumber(account.getAccountNumber());
        accountDto.setAccountType(account.getAccountType());
        accountDto.setBranchAddress(account.getBranchAddress());

        return accountDto;
    }

    public static Account mapToAccount(AccountDto accountDto, Account account) {
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setAccountType(accountDto.getAccountType());
        account.setBranchAddress(account.getBranchAddress());

        return account;
    }
}
