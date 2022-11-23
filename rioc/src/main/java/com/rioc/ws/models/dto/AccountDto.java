package com.rioc.ws.models.dto;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Builder
public class AccountDto {
	@NotNull
	@NotBlank
	@Size(max = 10)
	private String firstName;
	@NotNull
	@NotBlank
	@Size(max = 10)
	private String lastName;
	
	private AddressDto address;
}
