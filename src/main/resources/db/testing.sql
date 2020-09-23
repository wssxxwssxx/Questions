INSERT INTO t_form (id, data, name) VALUES (3000,true,'Преступление и наказание');


--Вопрос: сначала узнай номер ид_формы чтоб задать его в следующий запрос
INSERT INTO t_question (qid, form_id, qname) VALUES (1100, 3000, 'Как звали бабулю?');
--Ответы: сначала узнай номер ид_вопроса чтоб задать его в след. запросе
INSERT INTO t_answer (a_id, aname, properly, question_Id, user_answer) VALUES (10000, 'Старуха Изергиль',true ,1100, false);
INSERT INTO t_answer (a_id, aname, properly, question_Id, user_answer) VALUES (10001, 'Баба Параска',false ,1100, false);
INSERT INTO t_answer (a_id, aname, properly, question_Id, user_answer) VALUES (10002, 'Бабушка "Божий одуванчик"',false ,1100, false);
INSERT INTO t_answer (a_id, aname, properly, question_Id, user_answer) VALUES (10003, 'Жертва',false ,1100, false);
INSERT INTO t_answer (a_id, aname, properly, question_Id, user_answer) VALUES (10004, 'Баба-Яга',false ,1100, false);
INSERT INTO t_answer (a_id, aname, properly, question_Id, user_answer) VALUES (10005, 'Железная Леди',false ,1100, false);

--Вопрос: сначала узнай номер ид_формы чтоб задать его в следующий запрос
INSERT INTO t_question (qid, form_id, qname) VALUES (1101, 3000, 'Кто убил бабулю?');
--Ответы: сначала узнай номер ид_вопроса чтоб задать его в след. запросе
INSERT INTO t_answer (a_id, aname, properly, question_Id, user_answer) VALUES (10006, 'Фонвизин',false ,1101, false);
INSERT INTO t_answer (a_id, aname, properly, question_Id, user_answer) VALUES (10007, 'Раскольников',true ,1101, false);
INSERT INTO t_answer (a_id, aname, properly, question_Id, user_answer) VALUES (10008, 'Онегин',false ,1101, false);
INSERT INTO t_answer (a_id, aname, properly, question_Id, user_answer) VALUES (10009, 'Кот-Бегемот',false ,1101, false);
INSERT INTO t_answer (a_id, aname, properly, question_Id, user_answer) VALUES (10010, 'Иван Иваныч',false ,1101, false);
INSERT INTO t_answer (a_id, aname, properly, question_Id, user_answer) VALUES (10011, 'Агент 007',false ,1101, false);

--Вопрос: сначала узнай номер ид_формы чтоб задать его в следующий запрос
INSERT INTO t_question (qid, form_id, qname) VALUES (1102, 3000, 'Назовите орудие убийства?');
--Ответы: сначала узнай номер ид_вопроса чтоб задать его в след. запросе
INSERT INTO t_answer (a_id, aname, properly, question_Id, user_answer) VALUES (10012, 'молоток',false ,1102, false);
INSERT INTO t_answer (a_id, aname, properly, question_Id, user_answer) VALUES (10013, 'ледоруб',false ,1102, false);
INSERT INTO t_answer (a_id, aname, properly, question_Id, user_answer) VALUES (10014, 'утюг',false ,1102, false);
INSERT INTO t_answer (a_id, aname, properly, question_Id, user_answer) VALUES (10015, 'топор',true ,1102, false);
INSERT INTO t_answer (a_id, aname, properly, question_Id, user_answer) VALUES (10016, 'палка-копалка',false ,1102, false);
INSERT INTO t_answer (a_id, aname, properly, question_Id, user_answer) VALUES (10017, 'мотыга',false ,1102, false);
