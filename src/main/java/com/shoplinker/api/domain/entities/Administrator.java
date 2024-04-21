package com.shoplinker.api.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_administrators")
public class Administrator extends User {
	private String department;
}
