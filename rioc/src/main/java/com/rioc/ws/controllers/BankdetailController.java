package com.rioc.ws.controllers;

import java.net.MalformedURLException;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rioc.ws.exceptions.ApiException;
import com.rioc.ws.models.dao.Address;
import com.rioc.ws.models.dao.Bankdetail;
import com.rioc.ws.models.dto.AddressDto;
import com.rioc.ws.models.dto.BankdetailDto;
import com.rioc.ws.services.hello.Bankdetail.IBankdetailService;
import com.rioc.ws.services.hello.address.IAddressService;

@RestController
public class BankdetailController {
	private IBankdetailService service;

	public BankdetailController(IBankdetailService service) {
		super();
		this.service = service;
	}
	@PostMapping("/banks")
	public ResponseEntity<Bankdetail> postAddress(@RequestBody @Valid BankdetailDto bankdetailDto, BindingResult result) throws MalformedURLException {
		//
		if (result.hasErrors())
			throw new ApiException("bad entry", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(service.postBankdetail(bankdetailDto),HttpStatus.CREATED);
	}
}
