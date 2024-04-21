CREATE TABLE tb_addresses(
    id UUID NOT NULL,
    country VARCHAR(100) NOT NULL,
    state VARCHAR(50) NOT NULL,
    city VARCHAR(50) NOT NULL,
    neighborhood VARCHAR(100) NOT NULL,
    street VARCHAR(100) NOT NULL,
    number VARCHAR(20) NOT NULL,
    zip_code VARCHAR(50) NOT NULL,

    CONSTRAINT pk_address PRIMARY KEY (id)
);