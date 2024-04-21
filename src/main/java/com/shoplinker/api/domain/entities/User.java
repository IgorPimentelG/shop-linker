package com.shoplinker.api.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@MappedSuperclass
public abstract class User implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "is_active")
	private boolean isActive;

	@Column(name = "created_at'")
	private LocalDateTime createdAt;

	@Column(name = "updated_at'")
	private LocalDateTime updatedAt;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "credential_id", referencedColumnName = "id")
	private Credential credential;

	@PrePersist
	private void prePersist() {
		createdAt = LocalDateTime.now();
	}

	@PreUpdate
	private void preUpdate() {
		updatedAt = LocalDateTime.now();
	}
}
