package com.rioc.ws.models.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class AddressDto {
	
	private Long id;
	@NotNull
	@NotBlank
	@Size(max = 10)
	private String street;
	@NotNull
	@NotBlank
	@Size(max = 10)
	private String country;
	@NotNull
	@NotBlank
	@Size(max = 10)
	private String city;
	@NotNull
	private Integer postal;
	@NotNull
	private Integer number;
}
