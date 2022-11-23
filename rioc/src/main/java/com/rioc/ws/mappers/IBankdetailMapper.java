package com.rioc.ws.mappers;

import org.mapstruct.Mapper;
import com.rioc.ws.models.dao.Bankdetail;
import com.rioc.ws.models.dto.BankdetailDto;
@Mapper (componentModel = "spring")
public interface IBankdetailMapper {
	BankdetailDto bankdetailToBankdetailDto (Bankdetail bankdetail);
	Bankdetail bankdetailDtoToBankdetail (BankdetailDto bankdetail);
}
