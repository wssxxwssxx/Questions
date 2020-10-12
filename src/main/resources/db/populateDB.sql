--добавить юзера
INSERT INTO t_user (id, password, username) VALUES (1, 'password','useruser')
UPDATE t_user set (id, password, username) = (1, '$2b$10$NMb3gV1vUFrCvgEk3oszpuMD/AqlvulWjl4WYr5RAi4PWZy8qpr4W','useruser');
--Установим две роли (ЮЗЕР и АДМИН)

INSERT INTO t_role VALUES (1, 'ROLE_USER');
INSERT INTO t_role VALUES (2, 'ROLE_ADMIN');

--!НЕВЫПОЛНЯТЬ Пользователь id 1, имеет роль "админ"
--INSERT INTO public.t_user_roles(user_id, roles_id) VALUES (1, 2);


-- Установить первому пользователю роль АДМИНа
UPDATE t_user_roles SET (user_id, roles_id) = (1, 2);

INSERT INTO t_form (id, name,user_id)  VALUES (1,'Преступление и наказание',201);
INSERT INTO t_form (id, name,user_id)  VALUES  (2,'Горе от ума',201);
INSERT INTO t_form (id, name,user_id)  VALUES (3,'Морской волк',201);
INSERT INTO t_form (id, name,user_id)  VALUES  (4,'Горе',201);



ALTER SEQUENCE t_form_id_seq RESTART WITH 1;
UPDATE t_form SET id = DEFAULT;

ALTER SEQUENCE t_question_q_id_seq RESTART WITH 1;
UPDATE t_question SET q_id = DEFAULT;