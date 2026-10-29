--liquibase formatted sql
--changeset yuliya:create-transaction-table
CREATE TYPE transaction_status AS ENUM ('PENDING', 'SUCCESSFUL', 'FAILED');

CREATE TABLE transactions
(id UUID NOT NULL,
created_at TIMESTAMP NOT NULL,
order_id UUID UNIQUE,
total_amount NUMERIC(19,4) NOT NULL,
status transaction_status NOT NULL DEFAULT 'PENDING',
completed_at TIMESTAMP NOT NULL,
CONSTRAINT pk_transaction PRIMARY KEY (id)
);