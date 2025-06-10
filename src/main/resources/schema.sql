CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(16) NOT NULL,
    password VARCHAR(255) NOT NULL,
    user_name VARCHAR(10)
);

CREATE TABLE todo (
    task_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    days DATE,
    time TIME,
    area VARCHAR(255),
    url VARCHAR(2083),
    memo VARCHAR(255),
    frag BOOLEAN NOT NULL,
    id BIGINT NOT NULL,
    FOREIGN KEY (id) REFERENCES users(id)
);