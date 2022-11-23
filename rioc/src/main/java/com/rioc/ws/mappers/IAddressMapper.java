package com.rioc.ws.mappers;

import org.mapstruct.Mapper;

import com.rioc.ws.models.dao.Address;
import com.rioc.ws.models.dto.AddressDto;

@Mapper (componentModel = "spring")
public interface IAddressMapper {
	AddressDto addressToAddressDto (Address address);
	Address addressDtoToAddress (AddressDto address);
}
