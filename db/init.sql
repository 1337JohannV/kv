CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY  KEY,
    username VARCHAR(255) UNIQUE,
    password varchar(255) NOT NULL
)