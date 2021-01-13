INSERT INTO public.users (id, email, login, "name", "password") VALUES(1, 'teste1@teste.com.br', 'teste1', 'teste1', 'teste1');
INSERT INTO public.users (id, email, login, "name", "password") VALUES(2, 'teste2@teste2.com.br', 'teste2', 'teste2', 'teste2');

INSERT INTO public.fill_form (id, create_date, user_id, title) VALUES(13, '2021-01-13', 1, 'Desenvolvimento Web');
INSERT INTO public.fill_form (id, create_date, user_id, title) VALUES(14, '2021-01-13', 1, 'TESTE DE PROGRAMACAO');
INSERT INTO public.fill_form (id, create_date, user_id, title) VALUES(15, '2021-01-13', 1, 'Desenvolvimento Web');
INSERT INTO public.fill_form (id, create_date, user_id, title) VALUES(16, '2021-01-13', 2, 'Desenvolvimento Web');

INSERT INTO public.questions (id, answer, question, form_id) VALUES(1, 'TESTE DE RESPOSTA', 'PERGUNTA 1', 13);
INSERT INTO public.questions (id, answer, question, form_id) VALUES(2, 'RESPOSTA 2', 'PERGUNTA 2', 13);
INSERT INTO public.questions (id, answer, question, form_id) VALUES(3, 'RESPOSTA 3', 'PERGUNTA 3', 16);
