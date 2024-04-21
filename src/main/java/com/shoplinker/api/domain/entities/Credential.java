package com.shoplinker.api.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_credentials")
public class Credential implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	private String email;
	private String password;

	@Column(name = "is_verified")
	private boolean isVerified;

	@Column(name = "verification_code")
	private String verificationCode;

	@Column(name = "verification_code_expiration")
	private LocalDateTime verificationCodeExpiration;

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
