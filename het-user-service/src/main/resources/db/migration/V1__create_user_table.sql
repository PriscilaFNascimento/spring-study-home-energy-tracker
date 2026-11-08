CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE applicationUser (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    hasAlertEnabled BOOLEAN NOT NULL,
    energyAlertingThreshold DOUBLE PRECISION NOT NULL DEFAULT 0,
    UNIQUE (email)
);