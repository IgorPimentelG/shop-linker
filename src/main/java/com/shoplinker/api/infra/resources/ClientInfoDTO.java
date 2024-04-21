package com.shoplinker.api.infra.resources;

import com.shoplinker.api.infra.helpers.Formatter;

import java.time.LocalDateTime;
import java.util.UUID;

public record ClientInfoDTO(
  UUID id,
  String fullName,
  String cpf,
  String phone,
  String email,
  boolean isActive,
  Object createdAt
) {
	public ClientInfoDTO {
		cpf = Formatter.cpf(cpf);
		createdAt = Formatter.datetime((LocalDateTime) createdAt);
	}
}
