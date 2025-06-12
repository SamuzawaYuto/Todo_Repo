CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(16) UNIQUE NOT NULL,
    password VARCHAR(60) NOT NULL,
    user_name VARCHAR(10)
);

CREATE TABLE todos (
    todo_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    --title VARCHAR(255) NOT NULL,
    title VARCHAR(255),
    date DATE,
    time TIME,
    area VARCHAR(255),
    url VARCHAR(2083),
    memo VARCHAR(255)
);