package com.rioc.ws.services.hello.address;

import java.util.List;

import com.rioc.ws.models.dao.Address;
import com.rioc.ws.models.dto.AddressDto;

public interface IAddressService {
	public Address postAddress(AddressDto address);
	/*public AddressDto getAddressById(int id);
	public AddressDto deleteAddressById(int id);
	public List<AddressDto> getAllAdress();*/
	public Boolean getApiAdd(AddressDto address);
	
}
