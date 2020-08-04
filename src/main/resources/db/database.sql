
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

-- Table: form
CREATE TABLE t_form (
    topic_id INT PRIMARY KEY NOT NULL ,
    topic_name VARCHAR(255) NOT NULL,
    data TIMESTAMP  DEFAULT now() NOT NULL

);

-- Table: question
CREATE TABLE t_question (
    question_id INT PRIMARY KEY NOT NULL,
    topic_question_id INT NOT NULL ,
    name_question VARCHAR(255) NOT NULL ,

    FOREIGN KEY (topic_question_id) REFERENCES t_form (topic_id)
);

-- Table: answer
CREATE TABLE t_answer (
    answer_id INT PRIMARY KEY NOT NULL,
    question_answer_id INT NOT NULL,
    name_answer VARCHAR(255) NOT NULL ,
    properly_answer BOOL  DEFAULT FALSE NOT NULL ,

    FOREIGN KEY (question_answer_id) REFERENCES t_question(question_id)
)

