package com.shoplinker.api.infra.resources;

import jakarta.validation.constraints.*;

public record AddressDTO(
  @NotEmpty(message = "Country is required.")
  @Max(value = 100, message = "Country must have a max of 100 characters.")
  String country,

  @NotEmpty(message = "State is required.")
  @Max(value = 50, message = "State must have a max of 100 characters.")
  String state,

  @NotEmpty(message = "City is required.")
  @Max(value = 50, message = "City must have a max of 100 characters.")
  String city,

  @NotEmpty(message = "Neighborhood is required.")
  @Max(value = 100, message = "Neighborhood must have a max of 100 characters.")
  String neighborhood,

  @NotEmpty(message = "Street is required.")
  @Max(value = 100, message = "Street must have a max of 100 characters.")
  String street,

  @NotEmpty(message = "Number is required.")
  @Max(value = 100, message = "Number must have a max of 20 characters.")
  String number,

  @NotEmpty(message = "Zipcode is required.")
  @Pattern(regexp = "\\d{5}-\\d{3}", message = "ZIP code is invalid.")
  String zipcode
) {}