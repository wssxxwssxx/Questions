--Установим две роли (ЮЗЕР и АДМИН)

INSERT INTO t_role VALUES (1, 'ROLE_USER');
INSERT INTO t_role VALUES (2, 'ROLE_ADMIN');

--!НЕВЫПОЛНЯТЬ Пользователь id 1, имеет роль "админ"
--INSERT INTO public.t_user_roles(user_id, roles_id) VALUES (1, 2);


-- Установить первому пользователю роль АДМИНа
UPDATE public.t_user_roles SET (user_id, roles_id) = (1, 2);