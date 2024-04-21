CREATE TABLE tb_credentials(
    id UUID NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    is_verified BOOL NOT NULL DEFAULT FALSE,
    verification_code VARCHAR(20) NOT NULL,
    verification_code_expiration TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT NULL,

    CONSTRAINT pk_credentials PRIMARY KEY (id)
);

CREATE INDEX tb_credentials_email_idx ON tb_credentials (email);