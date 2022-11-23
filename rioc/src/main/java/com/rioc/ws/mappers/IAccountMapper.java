package com.rioc.ws.mappers;


import org.mapstruct.Mapper;

import com.rioc.ws.models.dao.Account;
import com.rioc.ws.models.dto.AccountDto;

@Mapper (componentModel = "spring")
public interface IAccountMapper {
	AccountDto accountToAccountDto (Account account);
	Account accountDtoToAccount (AccountDto account);
}
