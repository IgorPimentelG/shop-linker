CREATE TABLE tb_clients(
    id UUID NOT NULL,
    full_name VARCHAR(255) NOT NULL,
    is_active BOOL DEFAULT FALSE,
    cpf CHAR(11) NOT NULL UNIQUE,
    phone CHAR(14) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NULL,
    credential_id UUID NOT NULL,
    address_id UUID NOT NULL,

    CONSTRAINT pk_client PRIMARY KEY (id),
    CONSTRAINT fk_client_credential FOREIGN KEY (credential_id) REFERENCES tb_credentials(id),
    CONSTRAINT fk_client_address FOREIGN KEY (address_id) REFERENCES tb_addresses(id)
);

CREATE TABLE tb_administrators(
    id UUID NOT NULL,
    full_name VARCHAR(255) NOT NULL,
    is_active BOOL DEFAULT FALSE,
    department VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NULL,
    credential_id UUID NOT NULL,

    CONSTRAINT pk_administrator PRIMARY KEY (id),
    CONSTRAINT fk_client_credential FOREIGN KEY (credential_id) REFERENCES tb_credentials(id)
);