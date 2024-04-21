package com.shoplinker.api.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_clients")
public class Client extends User {
	private String cpf;
	private String phone;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;
}
