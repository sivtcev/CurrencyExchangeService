CREATE TABLE operations (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    time DATETIME,
    user_id BIGINT NOT NULL,
    currency_from BIGINT NOT NULL,
    currency_to BIGINT NOT NULL,
    amount_in_usd DECIMAL(13, 4) NOT NULL) engine=InnoDB