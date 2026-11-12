CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE device(
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    location VARCHAR(255),
    type VARCHAR(50) NOT NULL,
    user_id UUID,
    FOREIGN KEY (user_id) REFERENCES application_user(id) ON DELETE CASCADE
)