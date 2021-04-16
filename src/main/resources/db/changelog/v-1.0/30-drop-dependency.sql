ALTER TABLE users
    DROP CONSTRAINT users_operation_foreign_key

GO

ALTER TABLE operations
    DROP CONSTRAINT operation_user_foreign_key

GO

ALTER TABLE operations
    DROP CONSTRAINT operation_currency_from_foreign_key

GO

ALTER TABLE operations
    DROP CONSTRAINT operation_currency_to_foreign_key
