package com.rioc.ws.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.rioc.ws.models.dao.Account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Builder
public class BankdetailDto {
	
	private int bank_id;
	private int account;
	@NotNull
	@NotBlank
	@Size(max = 34)
	private String iban;
	
	
}
