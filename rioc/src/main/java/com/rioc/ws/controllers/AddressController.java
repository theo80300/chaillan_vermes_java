package com.rioc.ws.controllers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.rioc.ws.*;
import com.rioc.ws.exceptions.ApiException;
import com.rioc.ws.models.dao.Address;
import com.rioc.ws.models.dto.AccountDto;
import com.rioc.ws.models.dto.AddressDto;
import com.rioc.ws.services.hello.address.IAddressService;

@RestController
public class AddressController {
	private IAddressService service;

	public AddressController(IAddressService service) {
		super();
		this.service = service;
	}
	@PostMapping("/address")
	public ResponseEntity<Address> postAddress(@RequestBody @Valid AddressDto address, BindingResult result) throws MalformedURLException {
		//
		if (result.hasErrors())
			throw new ApiException("bad entry", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(service.postAddress(address),HttpStatus.CREATED);
	}
	
	/*
	@GetMapping("/get_a")
	public AddressDto getAddress(@RequestParam int id){
			return service.getAddressById(id);
	}
	
	@GetMapping("/getall_a")
	public List<AddressDto> getAllAddress(){
			return service.getAllAdress();
	}
	
	@DeleteMapping("/delete_a")
	public AddressDto deleteAddressById(@RequestParam int id){
			return service.deleteAddressById(id);
	}
	*/
}
