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
    qId SERIAL PRIMARY KEY,
    formId INT NOT NULL,
    qname VARCHAR(255) NOT NULL,


    FOREIGN KEY (formId) REFERENCES t_form (id)
);

-- Table: answer
CREATE TABLE t_answer (
    a_id SERIAL PRIMARY KEY,
    questionId INT NOT NULL,
    aname VARCHAR(255) NOT NULL,
    properly BOOL  DEFAULT FALSE NOT NULL ,
    user_answer BOOL  DEFAULT FALSE NOT NULL,

    FOREIGN KEY (questionId) REFERENCES t_question(qId)
);

-- Table: answer
CREATE TABLE t_tempresult (
    id SERIAL PRIMARY KEY,
    answerId INT NOT NULL,
    userResult BOOL  DEFAULT FALSE NOT NULL ,

    FOREIGN KEY (answerId) REFERENCES t_answer (a_id)
);
