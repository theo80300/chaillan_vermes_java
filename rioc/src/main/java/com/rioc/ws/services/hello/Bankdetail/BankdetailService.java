package com.rioc.ws.services.hello.Bankdetail;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rioc.ws.exceptions.ApiException;
import com.rioc.ws.mappers.IAddressMapper;
import com.rioc.ws.mappers.IBankdetailMapper;
import com.rioc.ws.models.dao.Account;
import com.rioc.ws.models.dao.Address;
import com.rioc.ws.models.dao.Bankdetail;
import com.rioc.ws.models.dto.AddressDto;
import com.rioc.ws.models.dto.BankdetailDto;
import com.rioc.ws.repositories.IAddressRepository;
import com.rioc.ws.repositories.IBankdetailRepository;
import com.rioc.ws.services.hello.account.IAccountService;

@Service
public class BankdetailService implements IBankdetailService{
	private IBankdetailRepository repository;
	private IBankdetailMapper mapper;
	private IAccountService accountService;
	
	
	public BankdetailService (IBankdetailRepository repository,IBankdetailMapper mapper, IAccountService accountService) {
		super();
		this.repository = repository;
		this.mapper = mapper;
		this.accountService = accountService;

	}
	public Bankdetail postBankdetail(BankdetailDto bankdetailDto) {
		/*if (!repository.findByBankIdAndAccount_AccountId(bankdetail.getBank_id(), bankdetail.getAccount_id())) {
			throw new  ApiException("Already existe", HttpStatus.CONFLICT);
		}*/
		
		Bankdetail bankdetail = mapper.bankdetailDtoToBankdetail(bankdetailDto);
		Account account = accountService.getById(bankdetailDto.getAccount());
		bankdetail.setAccount_id(account);
		
		return account == null ? null :  repository.save(bankdetail);
	}
}
