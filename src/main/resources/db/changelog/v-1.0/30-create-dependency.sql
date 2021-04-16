ALTER TABLE users
    ADD CONSTRAINT users_operation_foreign_key
        FOREIGN KEY (operation_id) REFERENCES operations(id)
            ON DELETE CASCADE

GO

ALTER TABLE operations
    ADD CONSTRAINT operation_user_foreign_key
        FOREIGN KEY (user_id) REFERENCES users(id)
            ON DELETE CASCADE

GO

ALTER TABLE operations
    ADD CONSTRAINT operation_currency_from_foreign_key
        FOREIGN KEY (currency_from) REFERENCES currencies(id)
            ON DELETE CASCADE

GO

ALTER TABLE operations
    ADD CONSTRAINT operation_currency_to_foreign_key
        FOREIGN KEY (currency_to) REFERENCES currencies(id)
            ON DELETE CASCADE
