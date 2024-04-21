package com.shoplinker.api.infra.resources;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

public record AdministratorDTO(
  @NotNull(message = "Full name is required.")
  @Max(value = 255, message = "Full name must have a max of 255 characters.")
  String fullName,

  @NotNull(message = "Department is required.")
  @Max(value = 255, message = "Department must have a max of 255 characters.")
  String department,

  @Valid
  CredentialDTO credential
) {}