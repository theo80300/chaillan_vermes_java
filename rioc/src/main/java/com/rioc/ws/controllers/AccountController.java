package com.rioc.ws.controllers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.rioc.ws.*;
import com.rioc.ws.exceptions.ApiException;
import com.rioc.ws.models.dao.Account;
import com.rioc.ws.models.dao.Address;
import com.rioc.ws.models.dto.AccountDto;
import com.rioc.ws.models.dto.utils.Feature;
import com.rioc.ws.models.dto.utils.FeatureCollection;
import com.rioc.ws.services.hello.address.AddressService;
import com.rioc.ws.services.hello.address.IAddressService;
import com.rioc.ws.services.hello.account.IAccountService;

@RestController
public class AccountController {
	private IAccountService service;
	private IAddressService serviceAddress;

	public AccountController(IAccountService service,IAddressService serviceAddress) {
		super();
		this.service = service;
		this.serviceAddress=serviceAddress;
		
	}
	@PostMapping("/accounts")
	public ResponseEntity<Account> postAccount(@RequestBody @Valid AccountDto account, BindingResult result) throws IOException {
					
		if (result.hasErrors())
			throw new ApiException("bad entry", HttpStatus.BAD_REQUEST);
		boolean verification = this.serviceAddress.getApiAdd(account.getAddress());
		if(verification == true) {
			return new ResponseEntity<>(service.postAccount(account),HttpStatus.CREATED);
		}
		else {
			return null;
		}
	}
	
	
	@GetMapping("/get")
	public AccountDto getAccount(@RequestParam int id){
			return service.getAccountById(id);
	}
	
	@GetMapping("/getall")
	public List<AccountDto> getAllAccount(){
			return service.getAllAccount();
	}
	
	@DeleteMapping("/delete")
	public AccountDto deleteAccountById(@RequestParam int id){
			return service.deleteAccountById(id);
	}
	
}
