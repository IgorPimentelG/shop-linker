package com.shoplinker.api.infra.resources;

import com.shoplinker.api.infra.helpers.Formatter;

import java.time.LocalDateTime;
import java.util.UUID;

public record AdministratorInfoDTO(
    UUID id,
	String fullName,
	String department,
    boolean isActive,
    Object createdAt
) {
	public AdministratorInfoDTO {
		createdAt = Formatter.datetime((LocalDateTime) createdAt);
	}
}