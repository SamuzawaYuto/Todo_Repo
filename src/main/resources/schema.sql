CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    userId VARCHAR(16) UNIQUE NOT NULL,
    password VARCHAR(60) NOT NULL,
    userName VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS todos (
    todo_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    date DATE,
    time TIME,
    area VARCHAR(255),
    url VARCHAR(2083),
    memo VARCHAR(255),
    userId VARCHAR(16) NOT NULL,
    FOREIGN KEY (userId) REFERENCES users(userId) 
);