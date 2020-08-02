
-- Table: users
CREATE TABLE t_user
(
       id            SERIAL PRIMARY KEY,
       username      VARCHAR(255) NOT NULL,
       password      VARCHAR(255) NOT NULL
);

-- Table: roles
CREATE TABLE t_role (
       id       INT PRIMARY KEY,
       name     VARCHAR(255) NOT NULL
);

-- Table for mapping user and roles: user_roles
CREATE TABLE t_user_roles (
    user_id INT NOT NULL,
    roles_id INT NOT NULL,

     FOREIGN KEY (user_id) REFERENCES t_user (id),
     FOREIGN KEY (roles_id) REFERENCES t_role (id),

     UNIQUE (user_id, roles_id)
);

