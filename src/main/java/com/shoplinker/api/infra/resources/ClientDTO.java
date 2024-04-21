package com.shoplinker.api.infra.resources;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

public record ClientDTO(
    @NotNull(message = "Full name is required.")
    @Max(value = 255, message = "Full name must have a max of 255 characters.")
	String fullName,

	@CPF(message = "CPF is invalid.")
	@NotNull(message = "CPF is required.")
	String cpf,

	@NotNull(message = "Phone number is required.")
	@Pattern(regexp = "\\(\\d{2}\\)\\s\\d{5}-\\d{4}", message = "Phone number is invalid.")
	String phone,

	@Valid
	CredentialDTO credential,

	@Valid
	AddressDTO address
) {}
