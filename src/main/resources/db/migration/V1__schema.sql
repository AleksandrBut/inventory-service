CREATE TABLE IF NOT EXISTS inventory (
        id serial PRIMARY KEY,
        sku_code varchar(36) NOT NULL,
        quantity int NOT NULL
)