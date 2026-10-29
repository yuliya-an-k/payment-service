--liquibase formatted sql
--changeset yuliya:change-transaction-table

 ALTER TABLE transactions ALTER COLUMN status DROP DEFAULT;
 ALTER TABLE transactions ALTER COLUMN status TYPE VARCHAR(20);
 ALTER TABLE transactions ALTER COLUMN status SET DEFAULT 'PENDING';
 ALTER TABLE transactions ADD CONSTRAINT check_transaction_status
             CHECK (status IN ('PENDING', 'SUCCESSFUL', 'FAILED'));
 DROP TYPE transaction_status;
