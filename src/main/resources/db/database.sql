
-- Table: users
CREATE TABLE users
(
       id       INTEGER PRIMARY KEY,
       username VARCHAR(255) NOT NULL,
       password VARCHAR(255) NOT NULL
);

-- Table: roles
CREATE TABLE roles (
      id   INTEGER PRIMARY KEY,
      name VARCHAR(100) NOT NULL
);

-- Table for mapping user and roles: user_roles
CREATE TABLE user_roles (
    user_id INT NOT NULL,
    role_id INT NOT NULL,

     FOREIGN KEY (user_id) REFERENCES users (id),
     FOREIGN KEY (role_id) REFERENCES roles (id),

     UNIQUE (user_id, role_id)
);

