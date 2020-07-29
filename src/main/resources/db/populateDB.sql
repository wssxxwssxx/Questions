--Здесь мы вставляем тестовые данные для бд

INSERT INTO users VALUES (1, 'proselyte', '123');

INSERT INTO roles VALUES (1, 'ROLE_USER');
INSERT INTO roles VALUES (2, 'ROLE_ADMIN');

--Пользовательс id 1, имеет роль "админ"
INSERT INTO user_roles VALUES (1, 2);