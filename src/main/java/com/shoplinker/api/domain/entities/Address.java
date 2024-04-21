package com.shoplinker.api.domain.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@Entity
@Table(name = "tb_addresses")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	private String country;
	private String state;
	private String city;
	private String neighborhood;
	private String street;
	private String number;

	@Column(name = "zip_code")
	private String zipCode;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@PrePersist
	private void prePersist() {
		this.createdAt = LocalDateTime.now();
	}

	@PreUpdate
	private void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
