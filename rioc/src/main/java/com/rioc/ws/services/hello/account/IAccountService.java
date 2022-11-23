package com.rioc.ws.services.hello.account;

import java.util.List;

import com.rioc.ws.models.dao.Account;
import com.rioc.ws.models.dto.AccountDto;

public interface IAccountService {
	public Account postAccount(AccountDto account);
	public AccountDto getAccountById(int id);
	public AccountDto deleteAccountById(int id);
	public List<AccountDto> getAllAccount();
	public Account getById(int id);
}
