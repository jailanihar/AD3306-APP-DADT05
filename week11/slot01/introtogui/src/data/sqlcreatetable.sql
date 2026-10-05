CREATE TABLE todos_users (
    username VARCHAR(50) NOT NULL,
    upassword VARCHAR(255) NOT NULL,
    updated_at DATETIME DEFAULT NULL,
    created_at DATETIME DEFAULT NULL,
    PRIMARY KEY (username)
);

CREATE TABLE todos (
    id INT NOT NULL AUTO_INCREMENT,
    todo_value VARCHAR(255),
    username VARCHAR(255),
    PRIMARY KEY (id),
    FOREIGN KEY (username) REFERENCES todos_users (username)
);

INSERT INTO todos_users 
VALUES ('antah', SHA2('berantah', 256), NOW(), NOW());

MD5 - Not recommended (due to Collision)
SHA1 - Not recommended (due to Collision)
BCrypt + Salt