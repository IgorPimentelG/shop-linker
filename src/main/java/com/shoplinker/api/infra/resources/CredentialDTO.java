package com.shoplinker.api.infra.resources;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public record CredentialDTO(
  @NotEmpty(message = "Email is required.")
  @Email(message = "Email is invalid.")
  String email,

  @NotEmpty(message = "Password is required.")
  @Pattern(
    regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",
    message = "Password minimum eight characters, at least one letter and one number"
  )
  String password
) {}
