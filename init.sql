CREATE TABLE employee (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    department VARCHAR(100) NOT NULL,
    salary DECIMAL(10, 2) CHECK (salary >= 0),
    CONSTRAINT email_format CHECK (email LIKE '%_@__%.__%')
);
