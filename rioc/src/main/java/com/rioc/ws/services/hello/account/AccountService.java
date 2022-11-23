package com.rioc.ws.services.hello.account;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rioc.ws.exceptions.ApiException;
import com.rioc.ws.mappers.IAccountMapper;
import com.rioc.ws.models.dao.Account;
import com.rioc.ws.models.dto.AccountDto;
import com.rioc.ws.repositories.IAccountRepository;

@Service
public class AccountService implements IAccountService{

	private IAccountRepository repository;
	private IAccountMapper mapper;
	
	
	public AccountService (IAccountRepository repository,IAccountMapper mapper) {
		super();
		this.repository = repository;
		this.mapper = mapper;

	}
	public Account postAccount(AccountDto account) {
		if (!repository.findByFirstNameAndLastName(account.getFirstName(), account.getLastName()).isEmpty()) {
			throw new  ApiException("Already existe", HttpStatus.CONFLICT);
		}
		
		return repository.save(mapper.accountDtoToAccount(account));
	}
	
	

	public AccountDto getAccountById(int id) {
		Optional <Account> optionAccount = repository.findById(id);
		if(optionAccount.isEmpty()) {
			return null;
		}
		return mapper.accountToAccountDto(optionAccount.get()); //utiliser mapper
	}
	
	public Account getById(int id) {
		Optional <Account> optionAccount = repository.findById(id);
		if(optionAccount.isEmpty()) {
			return null;
		}
		return optionAccount.get(); //utiliser mapper
	}
	
	public AccountDto deleteAccountById(int id) {
		repository.deleteById(id);
		return null;
	}
	
	public List<AccountDto> getAllAccount() {
		List<Account> Account = repository.findAll();
		if(Account.isEmpty()) {
			return null;
		}
		return Account.stream().map(account->mapper.accountToAccountDto(account)).collect(Collectors.toList()); //utiliser mapper
	}

}