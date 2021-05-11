CREATE TABLE schools (
id SERIAL PRIMARY KEY,
name VARCHAR(255),
description TEXT
);

CREATE TABLE spells (
id SERIAL PRIMARY KEY,
name VARCHAR(255),
level INTEGER,
description TEXT,
school_id INTEGER REFERENCES schools(id)
);