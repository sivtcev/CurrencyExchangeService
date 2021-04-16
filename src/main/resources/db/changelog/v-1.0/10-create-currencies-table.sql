CREATE TABLE currencies (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    name VARCHAR(255) NOT NULL,
    update_time DATETIME,
    amount_in_usd DECIMAL(13, 4)) engine=InnoDB




