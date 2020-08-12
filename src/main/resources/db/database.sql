
-- Table: users
CREATE TABLE t_user
(
       id            SERIAL PRIMARY KEY,
       username      VARCHAR(255) NOT NULL,
       password      VARCHAR(255) NOT NULL
);

-- Table: roles
CREATE TABLE t_role (
       id       SERIAL PRIMARY KEY,
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

-- Table: form
CREATE TABLE t_form (
    id SERIAL PRIMARY KEY ,
    name VARCHAR(255) NOT NULL,
    data TIMESTAMP  DEFAULT now() NOT NULL

);

-- Table: question
CREATE TABLE t_question (
    q_id SERIAL PRIMARY KEY,
    form_id INT NOT NULL,
    qname VARCHAR(255) NOT NULL,


    FOREIGN KEY (form_id) REFERENCES t_form (id)
);

-- Table: answer
CREATE TABLE t_answer (
    a_id SERIAL PRIMARY KEY,
    question_id INT NOT NULL,
    aname VARCHAR(255) NOT NULL,
    properly_answer BOOL  DEFAULT FALSE NOT NULL ,

    FOREIGN KEY (question_id) REFERENCES t_question(q_id)
)

